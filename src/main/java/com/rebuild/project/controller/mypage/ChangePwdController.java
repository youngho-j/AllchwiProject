package com.rebuild.project.controller.mypage;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rebuild.project.service.login.MemberLoginService;
import com.rebuild.project.vo.login.MemberLoginVO;


@Controller
public class ChangePwdController {
	@Autowired
	private MemberLoginService mls;
	
	private Logger log = LoggerFactory.getLogger(ChangePwdController.class);
	
	//비밀번호 변경 페이지로 이동
	@GetMapping("/mypage/changePwd")
	public String goPage(HttpSession session, Model model) {
		//객체를 담아줄 hashmap 선언
		HashMap<String, Object> hm = new HashMap<String, Object>();
		//세션에 저장된 회원번호 가져오기
		int ml_num = (int)session.getAttribute("ml_num");
		//hashmap에 회원번호 담기
		hm.put("ml_num", ml_num);
		//회원번호 사용하여 로그인 정보 출력
		MemberLoginVO mlv = mls.loginInfo(hm);
		//모델 객체에 로그인정보를 담은 vo를 넣어서 비밀번호 변경 페이지로 이동
		model.addAttribute("mlv", mlv);
		log.debug("비밀번호 변경 페이지로 이동");
		return ".mypage.changePwd";
	}
	//현재 비밀번호 확인 ajax
	@RequestMapping(value = "/CheckPWD.do", produces = "application/json;charset=utf-8")
	@ResponseBody
	public String checkPwd(String id, String pwd) {
		//검색을 위해 hashmap에 조건을 넣어줌.
		HashMap<String, Object> hm = new HashMap<String, Object>();
		hm.put("id", id);
		hm.put("pwd", pwd);
		
		//0 비밀번호 검색 결과를 vo에 넣어줌.
		MemberLoginVO vo = mls.checkPwd(hm);
		
		JSONObject json = new JSONObject();
		//0 검색된 결과가 없으면
		if (vo == null) {
			//비밀번호가 일치하지 않습니다.
			json.put("code", "fail");
		} else {
			//비밀번호가 일치합니다.
			json.put("code", "success");
			log.debug("비밀번호 ajax 확인 - 성공시 출력");
		}
		// json 형태로 나타냄
		return json.toString();
	}
	
	//비밀번호 변경 처리후 메인페이지로 리다이렉트
	@PostMapping("/mypage/changePwd")
	public String changePassword(MemberLoginVO mlv, String currPwd) {
		HashMap<String, Object> hm = new HashMap<String, Object>();
		hm.put("id", mlv.getId());
		hm.put("pwd", mlv.getPwd());
		hm.put("prevPwd", currPwd);
		int result = mls.changePwd(hm);
		if(result > 0) {
			log.debug("비밀번호 변경 완료 후 메인페이지로 이동");
			//완료될 경우 메인으로 
			return "redirect:/";			
		} else {
			//실패시 에러 페이지로 이동
			return ".error.error";
		}
	}
}
