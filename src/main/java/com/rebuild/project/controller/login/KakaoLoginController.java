package com.rebuild.project.controller.login;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rebuild.project.service.login.*;
import com.rebuild.project.vo.login.*;

@Controller
public class KakaoLoginController {
	@Autowired
	private KakaoLoginService kls;
	
	@Autowired
	private MemberLoginService mls;

	
	private Logger log = LoggerFactory.getLogger(KakaoLoginController.class);
	
	//카카오 로그인페이지로 이동
	@RequestMapping(value = "/login/login")
	public String goLoginPage() {
		log.debug("카카오 로그인 페이지로 이동");
		String client_id = kls.getClientId();
		String redirect_uri = kls.getRedirectUri();
		String path = "https://kauth.kakao.com/oauth/authorize?client_id="+ client_id + "&redirect_uri=" + redirect_uri + "&response_type=code";		
		
		return "redirect:" + path;
	}
	
	@RequestMapping(value = "/login/kakaologin")
	public String kakaologin(@RequestParam("code") String code, HttpSession session, Model model, HashMap<String, Object> map) {
		//a url에 담겨져 있는  code 값을 통해 
		String access_Token = kls.getAccessToken(code);
		//로그인한 카카오아이디의 정보를 담은 객체 생성
		HashMap<String, Object> kakaoUserInfo = kls.getUserInfo(access_Token);
		//카카오 계정이 존재하거나 존재하지 않을 수 있으므로 계정을 통해 검사
		String kakaoEmail = (String)kakaoUserInfo.get("email");
		//kakao 계정이 존재할 경우 
		if(kakaoEmail != "" || kakaoEmail != null) {
			log.debug("카카오 페이지에서 로그인 성공시");
			//kakao 이메일과 카카오 유저아이디 map에 담아주기
			map.put("kakaoUser",(String)kakaoUserInfo.get("kakaoUser"));
			//a 카카오 이메일로 회원정보가 있는지 검색
			MemberLoginVO infoCheckVo = mls.kakaoIdCheck(map);
			//a 회원정보 존재 -> 가입된 회원 -> 로그인후 메인페이지로 이동
			if (infoCheckVo != null) {
				log.debug("올취에 회원가입 된 카카오 회원인 경우 - 메인페이지로 이동");
				//a 로그인번호를 세션에 저장
				session.setAttribute("ml_num", infoCheckVo.getMl_num());
				//a 튜터 인증을 받은 회원일 경우 세션에 저장
				if(infoCheckVo.getTutor_auth() != 0) {
					//a 튜터인증 여부 저장 - 나중에 등록 시 필요
					session.setAttribute("tutor_auth", infoCheckVo.getTutor_auth());
				}
				//a kakao회원인지 아닌지 구분을 위해 세션에 토큰 저장
				session.setAttribute("access_Token", access_Token);
				return "redirect:/";
			} else {
				log.debug("올취에 회원가입 하지 않은 카카오 회원인 경우 - 회원가입페이지로 이동");
				//0 회원정보 없음 -> 미가입 회원 -> 필요 정보 입력 페이지 이동
				model.addAttribute("access_Token", access_Token);
				model.addAttribute("kakaoUserInfo", kakaoUserInfo);
				return ".login.kakaoJoin";
			}
		//카카오 계정 존재하지 않을 경우
		} else {
			log.debug("올취에 회원가입 하지 않고 카카오 계정을 불러올 수 없는  카카오 회원인 경우 - 회원가입페이지로 이동");
			//카카오 정보 중 별명을 꺼낼 수 있는 객체
			model.addAttribute("access_Token", access_Token);
			model.addAttribute("kakaoUserInfo", kakaoUserInfo);
			//회원정보 입력 페이지로 이동
			return ".login.kakaoJoin";			
		}
	}
	//카카오 회원 올취 회원가입
	@RequestMapping(value = "/login/kakaoSignIn")
	public String kakaologin2(HttpSession session, Model model, MemberLoginVO mlv, MemberInfoVO miv, String access_Token, HashMap<String, Object> map, String kakaoUserId) {
		try {
			//카카오 회원아이디를 memberloginVO 담음
			mlv.setKakaoUser(kakaoUserId);
			//회원가입
			int result = mls.kakaoJoinMember(session, mlv, miv);
			if(result == 4) {
				map.put("kakaoUser", kakaoUserId);
				//a map 값과 일치하는 로그인정보 가져오기
				MemberLoginVO getInfoVo = mls.kakaoIdCheck(map);
				//a 로그인번호를 세션에 저장
				session.setAttribute("ml_num", getInfoVo.getMl_num());
				//a kakao회원인지 아닌지 구분을 위해 세션에 토큰 저장
				session.setAttribute("access_Token", access_Token);
				log.debug("카카오 회원가입 완료 - 메인페이지로 이동");
				return "redirect:/";						
			}
			log.debug("카카오 회원가입 실패 - 에러페이지로 이동");
			return ".error.error";
		} catch (Exception e) {
			//exception 발생시 에러페이지로 이동
			e.printStackTrace();
			log.debug("카카오 회원가입 실패(exception 발생) - 에러페이지로 이동");
			return ".error.error";
		}
	}
}
