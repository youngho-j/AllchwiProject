package com.rebuild.project.controller.mypage;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.rebuild.project.service.login.*;
import com.rebuild.project.vo.login.*;



@Controller
public class SignoutController {
	@Autowired
	private MemberInfoService mis;
	
	@Autowired
	private MemberLoginService mls;
	
	//회원탈퇴 페이지로 이동
	@GetMapping("/mypage/signout")
	public String goPage(HttpSession session, Model model) {
		//a 변수를 담아줄 객체 생성
		HashMap<String, Object> hm = new HashMap<String, Object>();
		//a 세션에 저장되어있는 회원번호 가져오기
		int ml_num = (int)session.getAttribute("ml_num");
		//map에 변수를 담아서 넘겨줌.
		hm.put("ml_num", ml_num);
		//a 검색한 회원정보를 vo에 담기
		MemberLoginVO mlv = mls.loginInfo(hm);
		//a 모델 객체에 vo값 담아주기
		model.addAttribute("mlv", mlv);
		return ".mypage.signout";
	}
	//a 탈퇴정보를 회원정보 및 로그인정보에 업데이트 하기
	@PostMapping("/mypage/signout")
	public String signout(MemberLoginVO mlv, MemberInfoVO miv) {
		HashMap<String, Object> hm = new HashMap<String, Object>();
		//해쉬맵에 값 담기
		hm.put("ml_num", mlv.getMl_num());
		hm.put("mb_reason", miv.getMb_reason());
		//a 회원정보 탈퇴 요청 상태로 넘기기
		hm.put("mb_auth", 1);
		//a 로그인정보 탈퇴 상태로 넘기기
		hm.put("login_auth", 1);
		int result = 0;
		try {
			result = mis.UpdateSignout(hm);
			if(result >= 2) {
				return "redirect:/";			
			} else {
				return ".error.error";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ".error.error";
		}
	}
}
