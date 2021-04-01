package com.rebuild.project.controller.receiveTuition;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rebuild.project.page.util.PageUtil;
import com.rebuild.project.service.login.KakaoLoginService;
import com.rebuild.project.service.receiveTuition.ReceiptService;
import com.rebuild.project.vo.receiveTuition.*;

@Controller
public class ReceiptController {
	@Autowired
	private ReceiptService service;
	
	@Autowired
	private KakaoLoginService kls;
	
	@RequestMapping(value= {"/receipt/main","/receipt/insert"})
	public String adminMain(HttpSession session,HttpServletRequest request, Model model,@RequestParam(value="pageNum",defaultValue = "1")int pageNum,
			@RequestParam(value="rem_pay",defaultValue = "1")int rem_pay, String rem_bank, String rem_account, 
			@RequestParam(value="pay_num",defaultValue = "1")int pay_num,
			@RequestParam(value="rem_revenue",defaultValue = "1")int rem_revenue
			
			) {
		
		if(request.getServletPath().equals("/receipt/insert")) {
			InsertRemitVO vo = new InsertRemitVO(pay_num, rem_pay, rem_bank, rem_account,rem_revenue);
			try {
				service.insertUpdateRecipt(vo, pay_num);
			}catch(Exception e) {
				e.printStackTrace();
				return "fail";
			}
		}
		
		int ml_num = (Integer)session.getAttribute("ml_num");
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		int totalRowCount = service.count();
		PageUtil pu = new PageUtil(pageNum, totalRowCount, 6, 5);
		map.put("startRow", pu.getStartRow() - 1);
		map.put("ml_num",ml_num);
		
		List<ReceiptVO> list = service.receipt_list(map);
		model.addAttribute("list", list);
		model.addAttribute("pu", pu);
		
		return ".receipt.receiveTuition";
	}
	
	@RequestMapping(value="/receipt/apply")
	public String receiptApply(Model model, int final_price, int pay_num, int class_fee) {	
		model.addAttribute("final_price", final_price);
		model.addAttribute("pay_num", pay_num);
		model.addAttribute("class_fee", class_fee);
		model.addAttribute("appkey", kls.getAppKey());
		
		return ".receipt.applyRemit";
	}
}
