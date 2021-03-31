package com.rebuild.project.controller.login;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rebuild.project.service.login.MailSenderService;
import com.rebuild.project.vo.login.MemberLoginVO;

@Controller
public class MailSenderController {
	@Autowired
	private MailSenderService mailSender;
	
	
	private Logger log = LoggerFactory.getLogger(MailSenderController.class);
	
	// 비밀번호찾기 페이지 이동
	@GetMapping("/login/searchPwd")
	public String goSearchPwd() {
		log.debug("비밀번호 찾기 페이지 이동");
		return ".login.searchPwd";
	}
	// 비밀번호 찾기 페이지에서 메일 보낸 뒤 메인으로   
	@RequestMapping(value = "/login/searchPwd", method = RequestMethod.POST)
	public String searchPwdEmail(MemberLoginVO mlv, String sendEmail, Model model, HttpServletRequest req) {		
		// 인증 메일 보내기 메서드
		mailSender.mailSendWithpassword(mlv, sendEmail, model, req);
		//메일보내고 메인으로 
		log.debug("메일 발송 - 메인페이지로 이동");
		return "redirect:/";
	}
}
