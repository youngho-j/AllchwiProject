package com.rebuild.project.controller.community;

import java.util.HashMap;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rebuild.project.page.util.PageUtil;
import com.rebuild.project.service.community.CommuQnaService;
import com.rebuild.project.vo.community.CommuQnaVO;

@Controller
public class CommuQnaController {
	@Autowired
	private CommuQnaService service;

	@GetMapping("/community/qna")
	public String goQna() {
		return ".community.qna.commuQna";
	}

	// 질문작성
	@PostMapping("/community/insertQna")
	@ResponseBody
	public String insertQna(CommuQnaVO qvo) {
		try {
			service.insertQna(qvo);
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
		return "success";
	}

	// 답변작성
	@PostMapping("/community/qnareply")
	@ResponseBody
	public String insertRelply(CommuQnaVO qvo) {
		try {
			service.insertReply(qvo);
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
		return "success";
	}

	// 질문목록
	@GetMapping("/community/qnalist")
	@ResponseBody
	public HashMap<String, Object> qnaList(int commu_num,
			@RequestParam(value = "pageNum", defaultValue = "1") int pageNum) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("commu_num", commu_num);
		int totalRowCount = service.count(map);
		PageUtil pu = new PageUtil(pageNum, totalRowCount, 4, 5);
		int startRow = pu.getStartRow() - 1;
		map.put("startRow", startRow);
		List<CommuQnaVO> qlist = service.qnaList(map);
		HashMap<String, Object> map1 = new HashMap<String, Object>();
		map1.put("pu", pu);
		map1.put("qlist", qlist);
		return map1;
	}

	// 댓글목록
	@GetMapping("/community/commlist")
	@ResponseBody
	public List<CommuQnaVO> commList(@RequestParam HashMap<String, Object> map) {
		;
		List<CommuQnaVO> commlist = service.commList(map);
		return commlist;
	}

	// 답변작성권한
	@RequestMapping(value = "/replyAuth", produces = "application/json;charset=utf-8")
	@ResponseBody
	public String adminCheck(int ml_num, int class_num) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		JSONObject json = new JSONObject();
		map.put("ml_num", ml_num);
		map.put("class_num", class_num);
		int result = service.replyAuth(map);
		if (result == 1) {
			json.put("code", "success");
		} else {
			json.put("code", "fail");
		}
		return json.toString();
	}
	// 튜터 과제 수정
	@RequestMapping(value="/community/editQna", method = RequestMethod.POST)
	@ResponseBody
	public String updateOk(CommuQnaVO vo) {
		System.out.println("assign/updateOk method");
		int n=service.editQna(vo);
		if(n>0) {		
			return "success";
		}else {
			return "fail";
		}
		
	}
	// 튜터 과제 삭제
	@RequestMapping(value = "/community/delQna", method = RequestMethod.GET)
	@ResponseBody
	public String deleteOk(int qna_num) {
		int n = service.delQna(qna_num);
		if (n > 0) {
			return "success";
		} else {
			return "fail";
		}
	}
}
