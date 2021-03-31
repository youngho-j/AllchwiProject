package com.rebuild.project.controller.community;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.rebuild.project.service.community.*;
import com.rebuild.project.vo.community.*;

@Controller
public class AssignmentController {
	@Autowired private AssignmentService assign_service;
	@Autowired private AssignSubmitService submit_service;
	@Autowired private AssignDataService data_service;
	
	
	// 과제 게시판으로 이동
	@GetMapping("/community/assignment")
	public String goAssign(HttpSession session, Model model) {
		// 현재 로그인 된 ml_num
		int ml_num = (int)session.getAttribute("ml_num");
		// 해당 class_num의 ml_num(튜터)
		CommunityVO vo = (CommunityVO)session.getAttribute("commuInfo");
		int tutor_num=vo.getMl_num();
		
		model.addAttribute("stu_num",ml_num);
		model.addAttribute("tutor_num",tutor_num);
		
		// 전체 과제 목록
		int commu_num=vo.getCommu_num();
		List<AssignmentVO> list=assign_service.list(commu_num);
		model.addAttribute("list", list);
		return ".community.board.assignment";
	}
	
	// 튜터 과제 업로드
	@RequestMapping(value="/assign/upload", method = RequestMethod.POST)
	@ResponseBody
	public String uploadOk(AssignmentVO vo) {
		
		int n=assign_service.insert(vo);
		if(n>0) {		
			return "success";
		}else {
			return "fail";
		}

	}
	
	// 튜터 과제 삭제
	@RequestMapping(value="/assign/delete", method = RequestMethod.GET)
	@ResponseBody
	public String deleteOk(int assign_num) {
	
		int n=assign_service.delete(assign_num);
		if(n>0) {		
			return "success";
		}else {
			return "fail";
		}
		
	}
	// 튜터 과제 수정할 목록 불러오기
	@RequestMapping(value="/assign/update", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	@ResponseBody
	public String update(int assign_num) {
		
		AssignmentVO vo=assign_service.updatelist(assign_num);
		JSONObject json=new JSONObject();
		json.put("assign_title", vo.getAssign_title());
		json.put("assign_content", vo.getAssign_content());
		json.put("assign_num", vo.getAssign_num());
		return json.toString();
		
	}
	
	// 튜터 과제 수정
	@RequestMapping(value="/assign/updateOk", method = RequestMethod.POST)
	@ResponseBody
	public String updateOk(AssignmentVO vo) {
		int n=assign_service.update(vo);
		if(n>0) {		
			return "success";
		}else {
			return "fail";
		}
	}
	
	// 학생 과제 제출 List
	@PostMapping("/assign/submitList")
	@ResponseBody
	public List<AssignSubmitVO> submitOk(@RequestParam(value="assign_num")int assign_num) {
		HashMap<String, Object> map=new HashMap<String, Object>();
    	map.put("assign_num", assign_num);
    	List<AssignSubmitVO> sub_list=submit_service.sub_list(map);
    	return sub_list;
	}
	
	// 학생 과제 제출 - data insert
	@RequestMapping(value="/assign/data", method = {RequestMethod.POST,RequestMethod.GET},produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String subData(Model model, HttpSession session, MultipartHttpServletRequest multireq, 
			@RequestParam(value="sub_content")String sub_content, 
			@RequestParam(value="assign_num")int assign_num) {
		
    	int ml_num = (int)session.getAttribute("ml_num");
        
        AssignSubmitVO svo=new AssignSubmitVO(0, assign_num, ml_num, sub_content, null);
        int submit=submit_service.insert(svo);
        
        int sub_num=svo.getSub_num();
        
        List<MultipartFile> fileList = multireq.getFiles("assign_file");
        String path = session.getServletContext().getRealPath("/resources/AssignUpload");
        int assign_data=-1;
        for (MultipartFile mf : fileList) {
        	
            String assign_orgFilename = mf.getOriginalFilename(); // 원본 파일 명
            String assign_saveFilename=UUID.randomUUID()+"_" +assign_orgFilename; // 저장 파일 명
            long fileSize = mf.getSize(); // 파일 사이즈

            try {
                mf.transferTo(new File(path+File.separator+assign_saveFilename));
                AssignDataVO dvo=new AssignDataVO(0, sub_num, assign_orgFilename, assign_saveFilename, null, fileSize);
                assign_data=data_service.insert(dvo);
            } catch (IllegalStateException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        if(submit>0 && assign_data>0) {
        	return "success";
        }else {
        	return "error";
        }
	}
        // 학생 과제 제출 파일 다운로드
        @GetMapping("/assign/download")
    	public String download(int assigndata_num ,Model model,HttpSession session) {
        	
    		//다운로드할 파일정보를 갖는 객체얻어오기
    		AssignDataVO vo=data_service.saveFilename(assigndata_num);
    		String path=session.getServletContext().getRealPath("/resources/AssignUpload");
    		
    		//다운로드할파일객체
    		File f=new File(path + File.separator + vo.getAssign_saveFilename());
    		
    		//다운로드창에 보여질 파일명
    		String filename=vo.getAssign_orgFilename();
    
    		model.addAttribute("file",f);
    		model.addAttribute("filename",filename);
    		model.addAttribute("filesize",vo.getAssigndata_size());
    		return "filedownloadView";
    	}
	
	
}
