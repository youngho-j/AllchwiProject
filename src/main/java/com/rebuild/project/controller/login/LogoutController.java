package com.rebuild.project.controller.login;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rebuild.project.service.login.*;

@Controller
public class LogoutController {
	@Autowired
	private MemberLoginService mls;
	
	@Autowired
	private KakaoLoginService kls;
	
	private Logger log = LoggerFactory.getLogger(LogoutController.class);
	
	// else문 아래 dead코드 없애기 위해 선언
	@SuppressWarnings("unused")
	// 로그인후 드롭바에서 로그아웃 눌렀을경우 호출
	@RequestMapping(value = "/login/logout")
	public String logout(HttpSession session) {
		//a 카카오 회원일 경우 세션에 담긴 access token 확인 후
		String access_Token = (String)session.getAttribute("access_Token");
		//a 토큰 값 존재할 경우 아래 경로로 리다이렉트 이동하여 카카오서버에서 계정 나가기 후 로그아웃 리다이렉트 uri로 이동
		if(access_Token != null) {
			log.debug("카카오 정보로 회원인 경우 로그아웃 - 리다이렉트uri 받아서 컨트롤러로 이동");
			String client_id = kls.getClientId();
			String logout_redirect_uri = kls.getLogOutUri();
			String path = "https://kauth.kakao.com/oauth/logout?client_id="+ client_id + "&logout_redirect_uri=" + logout_redirect_uri;
			return "redirect:" + path;
		} else {
			log.debug("회원 로그아웃 - 메인페이지로 이동");
			//a 올취에서 가입한 회원인경우 
			mls.logout(session);    
			return "redirect:/";
		}
	}
	//a 카카오 서버에서 넘어오는 로그아웃 리다이렉트 uri를 받아서 아래 세션값들을 무효화하여 로그아웃
	@RequestMapping(value="/login/kakaologout")
	public String kakaologout(HttpSession session) {
		log.debug("카카오 정보로 회원인 경우 - 션에 저장된 토큰 값 및 정보 제거 - 메인페이지로 이동");
	    session.removeAttribute("access_Token");
	    session.removeAttribute("ml_num");
	    session.removeAttribute("tutor_auth");
	    session.invalidate();
	    return "redirect:/";
	}
}
