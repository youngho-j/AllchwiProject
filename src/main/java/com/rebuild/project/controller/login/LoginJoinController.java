package com.rebuild.project.controller.login;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rebuild.project.service.login.MemberLoginService;
import com.rebuild.project.vo.login.*;

@Controller
public class LoginJoinController {
	@Autowired
	private MemberLoginService mls;
	
	
	private Logger log = LoggerFactory.getLogger(LoginJoinController.class);
	
	//회원가입 페이지 이동
	@GetMapping("/login/join")
	public String goJoin() {
		log.debug("올취 회원가입 페이지로 이동(카카오 회원x)");
		return ".login.join";
	}
	
	//a 회원가입정보 포스트 방식으로 받기 / session => 실제경로 구해오기 위해 필요 / mlv => 아이디, 비밀번호  / miv => 이름
	@PostMapping("/login/join")
	public String signUp(HttpSession session, MemberLoginVO mlv, MemberInfoVO miv) {		
		//트랜잭션 처리한 service 메소드 필요
		try {
			int result = mls.joinMember(session, mlv, miv);
			if(result == 4) {
				log.debug("올취 회원가입 성공 - 로그인 메인 화면으로 이동");
				return "redirect:/login/main";						
			}
			log.debug("회원가입 실패 - 에러 페이지로 이동");
			return ".error.error";
		} catch (Exception e) {
			//exception 발생시 에러페이지로 이동
			log.debug("회원가입 실패(exception 발생) - 에러 페이지로 이동");
			e.printStackTrace();
			return ".error.error";
		}
	}
	
	//ajax로 아이디 중복확인(올취에서 회원가입할 경우)
	@RequestMapping(value = "/CheckID/do", produces = "application/json;charset=utf-8")
	@ResponseBody
	public String idCheck(String id) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		//a 올취 회원중 중복되는 아이디가 있는지 확인하기 위해 
		MemberLoginVO vo = mls.idCheck(map);
		JSONObject json = new JSONObject();
		//0 검색된 아이디가 존재하면
		if (vo != null) {
			//0 아이디가 존재 -> 사용할 수 없음
			json.put("code", "fail");
		} else {
			//0 아이디가 없음 -> 사용 가능
			json.put("code", "success");
		}
		// json 형태로 나타냄
		return json.toString();
	}
	//ajax로 전체 아이디 중복확인(카카오 로그인시 아이디가 없을 경우)
	@RequestMapping(value = "/CheckID/do2", produces = "application/json;charset=utf-8")
	@ResponseBody
	public String allCheck(String id) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		//a 전체 회원중 중복되는 아이디가 있는지 확인하기 위해 
		List<MemberLoginVO> vo = mls.allIdCheck(map);
		JSONObject json = new JSONObject();
		//0 검색된 아이디가 존재하면
		if (vo != null) {
			//0 아이디가 존재 -> 사용할 수 없음
			json.put("code", "fail");
		} else {
			//0 아이디가 없음 -> 사용 가능
			json.put("code", "success");
		}
		// json 형태로 나타냄
		return json.toString();
	}	
}
