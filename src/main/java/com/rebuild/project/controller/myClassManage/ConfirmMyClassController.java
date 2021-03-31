package com.rebuild.project.controller.myClassManage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rebuild.project.service.myclassmanage.MyClassManageService;
import com.rebuild.project.vo.classapply.ClassApplyVO;

@Controller
public class ConfirmMyClassController {
	@Autowired
	private MyClassManageService mcms;
	//a [컨트롤러 -> 모달]
	@RequestMapping("/myClass/classAccept")
	public String goClassAccept(@RequestParam(value = "apply_num") int apply_num, Model model) {
		//a 신청서 번호로 신청한 회원정보 가져오기
		ClassApplyVO cav = mcms.getApply(apply_num);
		//a 모델객체에 vo 담기
		model.addAttribute("cav", cav);
		//a 모달창으로 이동
		return "myClass/classAccept";
	}
	//a [모달 -> 컨트롤러]
	@RequestMapping("/myClass/classAcceptUpdate")
	public String updateApply(@RequestParam(value = "apply_num") int apply_num) {
		//a 신청한 회원정보 수업승인 업데이트 
		int result = mcms.updateApply(apply_num);
		//a 수업승인 업데이트 성공시 
		if(result > 0) {
			return "redirect:/myClass/myClassManage";			
		} else {
			return "redirect:/";
		}
	}
}
