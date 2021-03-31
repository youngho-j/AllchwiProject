package com.rebuild.project.controller.community;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.rebuild.project.page.util.PageUtil;
import com.rebuild.project.service.community.ArchiveService;
import com.rebuild.project.vo.community.*;

@Controller
public class ArchiveController {
	@Autowired
	private ArchiveService service;
		
	@RequestMapping(value = { "/community/archive", "/community/archiveDelete"})
	public String goAssign(HttpSession session, Model model, HttpServletRequest request,
		@RequestParam(value="pageNum",defaultValue = "1") int pageNum,
		@RequestParam(value="room_num",defaultValue = "0") int room_num,
		String save_filename){
		
		// 글 삭제일경우 (/community/archiveDelete)
		if (request.getServletPath().equals("/community/archiveDelete")) {
			try {
				service.delete(room_num); //db에서 지우기
				String uploadPath = session.getServletContext().getRealPath("resources/archiveUpload");
				File file = new File(uploadPath+ File.separator+ save_filename);
				file.delete();	//저장된 폴더에 있는 파일 지우기
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
		CommunityVO commuVo = (CommunityVO) session.getAttribute("commuInfo");
		int commu_num = commuVo.getCommu_num();			
		
		int commu_ml_num = commuVo.getMl_num();
		int ml_num= (Integer)session.getAttribute("ml_num");
		
		int totalRowCount = service.count(commu_num);
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		PageUtil pu = new PageUtil(pageNum, totalRowCount, 6, 5);
		
		map.put("commu_num",commu_num);
		map.put("startRow", pu.getStartRow()-1);
		map.put("endRow", pu.getEndRow());
		
		List<ArchiveVO> list = service.list(map);
		model.addAttribute("list", list);
		model.addAttribute("pu",pu);
		model.addAttribute("commu_ml_num",commu_ml_num);
		model.addAttribute("ml_num",ml_num);
		
		return ".community.board.archive";
	}
	
	@GetMapping("/community/archiveUpdate") //글수정 페이지로 이동
	public String archiveUpdate(int room_num,String save_filename, String room_title, String room_content, 
			int horsehead, String org_filename,Model model) {
		ArchiveVO vo = new ArchiveVO(room_num, 0, room_title, room_content, null, 0, horsehead, org_filename, save_filename, 0);
		model.addAttribute("vo",vo);
		return ".community.board.updateArchiveContent";
	}
	
	@PostMapping("/community/archiveUpdateOk") //글수정 완료
	public String archiveUpdateOk(int room_num,String prev_save_filename, String room_title, String room_content, 
			int horsehead, MultipartFile file1, HttpSession session) {
		
		try {
			if(!file1.isEmpty()) {	//수정할 파일이 존재할 경우
				String path = session.getServletContext().getRealPath("resources/archiveUpload");
				
				//기존 파일 삭제하기
				File f = new File(path+File.separator+prev_save_filename);				
				f.delete();
				
				//전송된 파일 업로드하기
				String org_filename = file1.getOriginalFilename();	
				//실제 저장할 파일명(중복되지 않도록)
				String save_filename = UUID.randomUUID()+"_"+org_filename; 
				InputStream fis = file1.getInputStream();
				FileOutputStream fos = new FileOutputStream(path+File.separator+save_filename);
				
				//파일복사하기
				FileCopyUtils.copy(fis, fos);
				fis.close();
				fos.close();
				
				long filesize = file1.getSize(); //파일크기 얻어오기
			
				ArchiveVO vo = new ArchiveVO(room_num, 0, room_title, room_content, null, 0, horsehead, org_filename, save_filename, filesize);
				service.update(vo);
				
			}else {	//수정할 파일이 전송되지 않은경우
				ArchiveVO vo = new ArchiveVO(room_num, 0, room_title, room_content, null, 0, horsehead, null, null, 0);
				service.update(vo);
			}
			
			return "redirect:/community/archive";
			
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return ".admin.error";
		}
	}
	
	
	
	@GetMapping("/community/archiveDetail")	//글내용(detail) 보기
	public String detail(int room_num,Model model,HttpSession session) {
		service.hit(room_num);	//조회수 1증가
		ArchiveVO vo = service.detail(room_num);
		ArchiveVO next=service.next(room_num);//다음글
		ArchiveVO prev=service.prev(room_num);//이전글
		
		CommunityVO commuVo = (CommunityVO) session.getAttribute("commuInfo");
		int commu_ml_num = commuVo.getMl_num();
		int ml_num= (Integer)session.getAttribute("ml_num");
		
		model.addAttribute("vo", vo);
		model.addAttribute("next",next);
		model.addAttribute("prev",prev);	
		model.addAttribute("commu_ml_num",commu_ml_num);
		model.addAttribute("ml_num",ml_num);
	
		return ".community.board.archiveContent";
	}
	
	@GetMapping("/community/writeContent") //글작성 페이지로 이동
	public String writeContent() {
		return ".community.board.writeArchiveContent";
	}
	
	
	@RequestMapping("/community/writeContentOk")
	public String writeContentOk(int horsehead, String room_title, String room_content, 
			MultipartFile file1,HttpSession session) {
		
		CommunityVO commuVo = (CommunityVO) session.getAttribute("commuInfo");
		int commu_num = commuVo.getCommu_num();
		
		//업로드할 폴더 경로 얻어오기
		String uploadPath=
				session.getServletContext().getRealPath("/resources/archiveUpload");
		System.out.println(uploadPath);
		
		//전송된 파일명
		String org_filename=file1.getOriginalFilename();
		
		//실제 저장할 파일명(중복되지 않도록)
		String save_filename=UUID.randomUUID()+"_" +org_filename;
		try {
			//전송된 	파일을 읽어오는 스트림
			InputStream fis = file1.getInputStream();
			
			//전송된 파일을 서버에 복사(업로드) 하기 위한 출력스트림
			FileOutputStream fos =
					new FileOutputStream(uploadPath+File.separator+save_filename);		
			
			//파일복사하기
			FileCopyUtils.copy(fis, fos);
			fis.close();
			fos.close();
			
			long filesize = file1.getSize(); //파일크기 얻어오기
				
			//DB에 파일정보 저장하기
			ArchiveVO vo = new ArchiveVO(0, commu_num, room_title, room_content, 
					null, 0, horsehead, org_filename, save_filename, filesize);
			service.insert(vo);
			return "redirect:/community/archive";
		
		}catch(IOException ie) {
			System.out.println(ie.getMessage());
			return ".community.board.error";
		}
	}
	
	
	@GetMapping("/community/download")
	public String download(int room_num,Model model,HttpSession session) {
		//다운로드할 파일정보를 갖는 객체얻어오기		
		ArchiveVO vo =service.getInfo(room_num);
		System.out.println("세이브 파일네임:" + vo.getSave_filename());
		
		String path=session.getServletContext().getRealPath("/resources/archiveUpload");
		
		//다운로드할파일객체
		File f=new File(path + File.separator + vo.getSave_filename());
		
		//다운로드창에 보여질 파일명
		String filename=vo.getOrg_filename();		
		model.addAttribute("file",f);
		model.addAttribute("filename",filename);
		model.addAttribute("filesize",vo.getFilesize());
		return "filedownloadView";
	}

}
