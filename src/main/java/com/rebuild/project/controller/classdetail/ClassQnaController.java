package com.rebuild.project.controller.classdetail;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rebuild.project.page.util.PageUtil;
import com.rebuild.project.service.classdetail.ClassQnaService;
import com.rebuild.project.vo.classdetail.ClassQnaVO;

@Controller
public class ClassQnaController {
	@Autowired
	private ClassQnaService service;
	
	@PostMapping("/classDetail/qna")
	@ResponseBody
	public String insertQna(ClassQnaVO qvo) {
		try {
			service.insertQna(qvo);
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
		return "success";
	}
	@PostMapping("/classDetail/qnareply")
	@ResponseBody
	public String insertRelply(ClassQnaVO qvo) {
		try {
			service.insertReply(qvo);
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
		return "success";
	}
	@GetMapping("/classDetail/qnalist")
	@ResponseBody
	public HashMap<String, Object> qnaList(int class_num,@RequestParam(value="pageNum",defaultValue="1")int pageNum) {
		HashMap<String, Object> map=new HashMap<String, Object>();
		map.put("class_num", class_num);
		int totalRowCount=service.count(map);
		PageUtil pu=new PageUtil(pageNum, totalRowCount, 4, 5);
		int startRow=pu.getStartRow()-1;
		map.put("startRow", startRow);	
		List<ClassQnaVO> qlist=service.qnaList(map);
		HashMap<String, Object> map1=new HashMap<String, Object>();
		map1.put("pu",pu);
		map1.put("qlist",qlist);
		return map1;
	}
	@GetMapping("/classDetail/commlist")
	@ResponseBody
	public List<ClassQnaVO> commList(@RequestParam HashMap<String, Object> map){;
		List<ClassQnaVO> commlist=service.commList(map);
		return commlist;
	}
}
