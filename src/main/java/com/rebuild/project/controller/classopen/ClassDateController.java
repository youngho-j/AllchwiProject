package com.rebuild.project.controller.classopen;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rebuild.project.service.classopen.*;
import com.rebuild.project.vo.classopen.*;

@Controller
public class ClassDateController {
	
	@Autowired
	private ClassDateService service;
	@Autowired
	private ClassInfoService infoService;
	
	@GetMapping("/class/classDate")
	public String goClassDate(HttpSession session,int class_num,Model model) {
		
		ClassInfoVO vo = infoService.select(class_num);
		
		session.setAttribute("class_num", vo.getClass_num());
		session.setAttribute("class_count", vo.getClass_count());
		session.setAttribute("class_form", vo.getClass_form());
		session.setAttribute("class_hour", vo.getClass_hour());
		
		List<ClassDateVO> list = service.select(class_num);
		
		model.addAttribute("list", list);
		
		return ".classOpen.classDate";
	}
	
	@GetMapping("/class/dateModal")
	public String goClassModal() {
		
		return "classOpen/dateModal";
	}
	
	@PostMapping("/class/classInsert")
	@ResponseBody
	public String ClassDateInsert(@RequestParam(value = "startDate[]",defaultValue = "")List<String> startDate,
									@RequestParam(value = "startTime[]",defaultValue = "")List<String> startTime,
									@RequestParam(value = "endTime[]",defaultValue = "")List<String> endTime,
									@RequestParam(value = "monthDate[]",defaultValue = "")List<String> monthDate,
									@RequestParam(value="delDate",defaultValue="")List<Integer> delDate,
									@RequestParam HashMap<String, Object> formdata
									,HttpSession session) {
		int class_count =  Integer.parseInt((String)formdata.get("class_count"));
		int class_num =  Integer.parseInt((String)formdata.get("class_num"));
		int class_form =  Integer.parseInt((String)formdata.get("class_form"));
		int updateCnt =  Integer.parseInt((String)formdata.get("updateCnt"));
		
		String class_comment = (String)formdata.get("class_comment");
		String class_msg = (String)formdata.get("class_msg");		
		if(startDate.size() > 0) {
			if(class_form == 0) {
				for (int c = 1; c <= updateCnt; c++) { 
					System.out.println(updateCnt);
					ArrayList<ClassDateVO> list = new ArrayList<ClassDateVO>();
						
					for(int i = 0; i< class_count; i++) {
						String startD = startDate.get(i+((c-1)*class_count));
						String class_startTime = startTime.get(i+((c-1)*class_count));
						String class_endTime = endTime.get(i+((c-1)*class_count));
						SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
						Date date;
						try {
							date = format.parse(startD);
							Timestamp class_date = new Timestamp(date.getTime());
							ClassDateVO vo = new ClassDateVO(0, class_num, class_date, class_startTime, class_endTime, class_comment, class_msg, 0, 0, i+1, null);
							list.add(vo);
						} catch (ParseException e) {
							e.printStackTrace();
							return  "fail";
						}
					}
					int n = service.insert(list);
				}
			}else {
				for (int i = 0; i < monthDate.size(); i++) {
					System.out.println("Asda");
					int class_month =  Integer.parseInt(monthDate.get(i));
					SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
					Date date;
					try {
						String startD = startDate.get(i);
						date = format.parse(startD);
						Timestamp class_date = new Timestamp(date.getTime());
						ClassDateVO vo = new ClassDateVO(0, class_num, class_date, null, null, class_comment, class_msg, class_month, 0, 1, null);
						int n = service.insert(vo);
					} catch (ParseException e) {
						e.printStackTrace();
						return  "fail";
					}
				}
			}	
		}
		// 삭제한 된 날짜 delete
		service.deleteDate(delDate);
		
		session.removeAttribute("class_num");
		session.removeAttribute("class_count");
		session.removeAttribute("class_form");
		session.removeAttribute("class_hour");
		
		return "success";
	}
	
}
