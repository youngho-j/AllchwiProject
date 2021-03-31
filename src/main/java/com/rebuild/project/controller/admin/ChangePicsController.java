package com.rebuild.project.controller.admin;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.rebuild.project.page.util.PageUtil;
import com.rebuild.project.service.admin.ChangePicsService;
import com.rebuild.project.vo.admin.MainPicsVO;
import com.rebuild.project.vo.admin.PicsListVO;

@Controller
public class ChangePicsController {
	@Autowired
	private ChangePicsService service;

	@RequestMapping(value = { "/admin/changePics", "/admin/insertPics", "admin/confirmPics" })
	public String changePics(HttpServletRequest request, Model model, List<MultipartFile> file1, HttpSession session,
			@RequestParam(value="pageNum", defaultValue = "1") int pageNum,
			String firstPic, String secondPic, String thirdPic
	){
		// 이미지 업로드 할때
		if (request.getServletPath().equals("/admin/insertPics")) {
			// 업로드할 폴더 경로 얻어오기
			String uploadPath = session.getServletContext().getRealPath("/resources/mainPicsUpload");
			System.out.println(uploadPath);

			for (int i = 0; i < file1.size(); i++) {
				MultipartFile file = file1.get(i);
				// 전송된 파일명
				String org_filename = file.getOriginalFilename();

				// 실제 저장할 파일명(중복되지 않도록)
				String save_filename = UUID.randomUUID() + "_" + org_filename;
				try {
					// 전송된 파일을 읽어오는 스트림
					InputStream fis = file.getInputStream();

					// 전송된 파일을 서버에 복사(업로드) 하기 위한 출력스트림
					FileOutputStream fos = new FileOutputStream(uploadPath + File.separator + save_filename);

					// 파일복사하기
					FileCopyUtils.copy(fis, fos);
					fis.close();
					fos.close();

					// 파일 사이즈 얻어오기
					long filesize = file.getSize();

					// DB에 파일정보 저장하기
					MainPicsVO vo = new MainPicsVO(0, org_filename, save_filename, filesize);
					service.picsInsert(vo);
				} catch (IOException ie) {
					System.out.println(ie.getMessage());
					return ".admin.error";
				}
			}
		}
		
		// 사진확정 할때
		if (request.getServletPath().equals("/admin/confirmPics")) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			
			map.put("firstPic", firstPic);
			map.put("secondPic", secondPic);
			map.put("thirdPic", thirdPic);
			try {
				service.confirmPics(map);
			} catch (Exception e) {
				e.printStackTrace();
				return ".admin.error";
			}
		}
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		int totalRowCount=service.count();
		
		PageUtil pu = new PageUtil(pageNum, totalRowCount, 5, 5);
		map.put("startRow", pu.getStartRow()-1);
		
		List<PicsListVO> list = service.pics_list(map);
		model.addAttribute("list", list);
		model.addAttribute("pu", pu);

		return ".admin.changePics";
	}
	
	
	
	@RequestMapping(value="admin/changePics2", produces= "application/json;charset=utf-8")
	@ResponseBody
	public List<PicsListVO> changePics2(int pageNum) {
		
		int totalRowCount = service.count();
		PageUtil pu = new PageUtil(pageNum, totalRowCount, 5, 5);
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("startRow", pu.getStartRow()-1);
		
		List<PicsListVO> list = service.pics_list(map);
		
		return list;
	}
}
