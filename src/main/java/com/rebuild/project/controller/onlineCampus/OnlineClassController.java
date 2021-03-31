package com.rebuild.project.controller.onlineCampus;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.jcodec.api.JCodecException;
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

import com.rebuild.project.page.util.PageUtil;
import com.rebuild.project.service.onlineclass.OnlineClassService;
import com.rebuild.project.vo.community.CommunityVO;
import com.rebuild.project.vo.onlineclass.OnlineClassVO;


@Controller
public class OnlineClassController {
	@Autowired
	private OnlineClassService service;
	
	
	@GetMapping("/community/mediaList")
	public String goOnlineClass(HttpSession session, Model model,
				@RequestParam(value="pageNum",defaultValue = "1")int pageNum) {
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		CommunityVO commu = (CommunityVO)session.getAttribute("commuInfo");
		int commu_num = commu.getCommu_num();

		map.put("commu_num",commu_num);
		
		int totalRowCount = service.count(map);
		PageUtil pu = new PageUtil(pageNum, totalRowCount, 3, 5);
		
		map.put("startRow",pu.getStartRow() - 1);
		List<OnlineClassVO> list = service.list(map);
		
		model.addAttribute("list", list);		
		model.addAttribute("pu", pu);		
		
		return ".community.onlineCampus.mediaList";
	}
	
	@GetMapping("/community/mediaModal")
	public String showModal(HttpSession session,Model model,
			@RequestParam(value="online_num", defaultValue = "-1")int online_num) {
		
		
		if(online_num > 0) {
			OnlineClassVO vo = service.select(online_num);
			model.addAttribute("info", vo);
		}
		
		
		return "community/onlineCampus/fileuploadModal";
	}
	
	@RequestMapping(value = "/community/save-product", produces ="application/text; charset=utf8",
			method = RequestMethod.POST)
	public void saveFile( @RequestParam(value="files",required = false) MultipartFile files, Model model, 
			@RequestParam(value="online_num",defaultValue = "0")int online_num,
			HttpSession session,@RequestParam  HashMap<String, Object> formdata) {
		
		int commu_num =((CommunityVO)session.getAttribute("commuInfo")).getCommu_num();
		
		String online_title = (String)formdata.get("online_title");
		String online_content = (String)formdata.get("online_content");
		String delfileName = (String)formdata.get("delfileName");
			
		if(files !=null) {
		
			String uploadPath = 
					session.getServletContext().getRealPath("/resources/mediaFold");
			
			
			String path = uploadPath+ File.separator+commu_num;
			System.out.println(path);
			File Folder = new File(path);
	
			// 해당 디렉토리가 없을경우 디렉토리를 생성합니다.
			if (!Folder.exists()) {
				try{
				    Folder.mkdir(); //폴더 생성합니다.
			    }catch(Exception e){
				    e.getStackTrace();
			    }        
			}
			
			String orgfileName = files.getOriginalFilename();
			
			String savefileName = UUID.randomUUID() + "_" + orgfileName;
			
			File fos = new File(path+File.separator + savefileName);
			String online_file = commu_num 
					+ File.separator + savefileName;
			try {
				files.transferTo(fos);
				
				int online_time = Videoffmpeg.media_player_time(path+File.separator + savefileName);
				byte[] thumbnail = null;
				try {
					thumbnail = Mp4Thumbnail.getThumbnail(fos);
				} catch (JCodecException e) {
					e.printStackTrace();
				}
				
				OnlineClassVO vo = new OnlineClassVO(online_num, commu_num, online_title,online_content, online_time, online_file, thumbnail, null);
				service.classInsert(vo);
				
				if(delfileName != null) {
					File file = new File(uploadPath + File.separator + delfileName);
					file.delete();
				}
				
			} catch (IOException e) {
				FileUtils.deleteQuietly(fos);
				e.printStackTrace();
			}		
		}else {
			OnlineClassVO updateVo = new OnlineClassVO(0, commu_num, online_title,online_content, 0, null, null, null);
			service.update(updateVo);
		}
		
	}
	
	@PostMapping("/community/onlineDelte")
	@ResponseBody
	public String deleteClass(@RequestParam(value="online_num",defaultValue = "0")int online_num,
								HttpSession session) {
		
		OnlineClassVO vo = service.select(online_num);
		
		if(vo !=null) {
			try {
				service.delete(online_num);
				
				String uploadPath = 
						session.getServletContext().getRealPath("/resources/mediaFold");
				
				File file = new File(uploadPath + File.separator + vo.getOnline_file());
				
				file.delete();
			} catch (SQLException e) {
				e.printStackTrace();
				return "fail";
			}
			
		}else {
			return "fail";
		}
		return "success";
	}
	
}
