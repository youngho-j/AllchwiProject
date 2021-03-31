package com.rebuild.project.controller.community;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rebuild.project.page.util.PageUtil;
import com.rebuild.project.service.community.NoticeService;
import com.rebuild.project.vo.community.*;

@Controller
public class NoticeController {
	@Autowired
	private NoticeService nts;
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	// a 커뮤니티  공지사항 페이지로 이동
	@GetMapping("/community/notice")
	public String goNotice(Model model, HttpSession session,
			@RequestParam(value = "pageNum", defaultValue = "1") int pageNum) {
		// 페이징 처리를 위한 값을 담기 위해 map 선언
		HashMap<String, Object> map = new HashMap<String, Object>();
		// 세션에 저장 되어있는 commuVo 꺼내오기
		CommunityVO commu = (CommunityVO) session.getAttribute("commuInfo");
		// VO에서 커뮤니티 번호 가져오기
		int commu_num = commu.getCommu_num();
		map.put("commu_num", commu_num);
		int totalRowCount = nts.count(map);
		// 페이징 처리 위한 객체 불러오기
		PageUtil pu = new PageUtil(pageNum, totalRowCount, 5, 5);
		// 객체를 통해 시작페이지를 map에 담기, 0부터 시작하므로 -1
		map.put("startRow", pu.getStartRow() - 1);
		// 페이징 처리된 목록 가져오기
		List<NoticeVO> list = nts.noticeList(map);
		model.addAttribute("list", list);
		model.addAttribute("pu", pu);
		
		log.debug("커뮤니티 공지사항 페이지로 이동");
		return ".community.notice.main";
	}

	// a 공지글 작성 모달창 띄우기
	@RequestMapping("/community/notice/writeNotice")
	public String writeNotice(HttpSession session, Model model) {
		// 페이징 처리를 위한 값을 담기 위해 map 선언
		// HashMap<String, Object> map = new HashMap<String, Object>();
		// 세션에 저장 되어있는 commuVo 꺼내오기
		CommunityVO commu = (CommunityVO) session.getAttribute("commuInfo");
		model.addAttribute("commu", commu);
		log.debug("커뮤니티 공지사항 글 작성 모달창");
		return "community/notice/writeNotice";
	}

	// a 모달창에서 값을 가지고 컨트롤러로 이동
	@RequestMapping("/community/notice/insertNotice")
	public String insertNotice(NoticeVO ntv) {
		int result = nts.writeNotice(ntv);
		// insert 후 공지사항 페이지로 리다이렉트
		//result값으로 값이 DB에 저장되었는지 판단 필요!!
		if(result > 0) {
			return "redirect:/community/notice";			
		} else {
			// 오류시 처리 필요!!
			return "redirect:/community/notice";						
		}
	}

	// 관리자인 경우에만 글 등록 가능
	@RequestMapping(value = "/adminCheck.do", produces = "application/json;charset=utf-8")
	@ResponseBody
	public String adminCheck(int ml_num, int class_num) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		JSONObject json = new JSONObject();
		map.put("ml_num", ml_num);
		map.put("class_num", class_num);

		int result = nts.adminCheck(map);
		if (result == 1) {
			// 카운트 1 -> 관리자 o
			json.put("code", "success");
		} else {
			// 카운트 0 -> 관리자 x
			json.put("code", "fail");
		}
		return json.toString();
	}
	//디테일 페이지 이동
	@GetMapping("/community/noticeDetail")
	public String detailPage(Model model, int notice_num) {
		try {
			// 조회수 증가 후 해당번호에 대한 정보를 vo에 담음
			nts.hit(notice_num);
			NoticeVO ntv = nts.getDetail(notice_num);
			NoticeVO next = nts.next(notice_num);
			NoticeVO prev = nts.prev(notice_num);
			model.addAttribute("ntv", ntv);
			model.addAttribute("next", next);
			model.addAttribute("prev", prev);
			log.debug("커뮤니티 공지사항 상세 페이지로 이동");
			return ".community.notice.noticeDetail";
		} catch (Exception e) {
			e.printStackTrace();
			return ".error.error";
		}
	}
	//공지사항 글 삭제
	@GetMapping("/community/noticeDelete")
	public String noticeDelete(int notice_num) {
		int result = nts.delete(notice_num);
		//삭제 성공시
		if(result > 0) {
			//메인페이지 호출하는 컨트롤러로 이동
			log.debug("커뮤니티 공지사항 글 삭제 후 공지사항 페이지로 이동");
			return "redirect:/community/notice";
		} else {
			return ".error.error";
		}
	}
	// a 공지글 작성 모달창 띄우기
	@RequestMapping("/community/notice/updateNotice")
	public String updateNotice(HttpSession session, Model model, @RequestParam(value = "notice_num")int notice_num) {
		// 페이징 처리를 위한 값을 담기 위해 map 선언
		NoticeVO ntv;
		try {
			ntv = nts.getDetail(notice_num);
			model.addAttribute("ntv", ntv);
			//updateNotice jsp로 이동
			log.debug("커뮤니티 공지사항 수정 모달창 띄우기");
			return "community/notice/updateNotice";
		} catch (Exception e) {
			e.printStackTrace();
			return ".error.error";
		}
	}

	// a 모달창에서 값을 가지고 컨트롤러로 이동
	@RequestMapping("/community/notice/updateOkNotice")
	public String updateOkNotice(NoticeVO ntv) {
		int result = nts.update(ntv);
		// insert 후 공지사항 페이지로 리다이렉트
		if(result > 0) {
			//메인페이지 호출하는 컨트롤러로 이동
			log.debug("커뮤니티 공지사항 글 수정 후 공지사항 페이지로 이동");
			return "redirect:/community/notice";
		} else {
			return ".error.error";
		}
	}
}
