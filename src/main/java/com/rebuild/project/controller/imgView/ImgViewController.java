package com.rebuild.project.controller.imgView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.rebuild.project.service.classopen.*;
import com.rebuild.project.service.onlineclass.OnlineClassService;
import com.rebuild.project.service.profileImg.ProfileImgService;
import com.rebuild.project.vo.classopen.*;
import com.rebuild.project.vo.onlineclass.OnlineClassVO;
import com.rebuild.project.vo.profileImg.ProfileImgVO;

/*
 *  Url mapping경로/cover_num=?
 *  컨트롤러에 이미지 번호 보내주면 화면에 이미지 출력가능
 *  이미지 태그 and background에서 사용가능
 */
@Controller
public class ImgViewController {
	@Autowired
	private ProfileImgService proService;
	@Autowired
	private ClassImgService imgService;
	@Autowired
	private OnlineClassService onlineService;
	@Autowired
	private CertificateService certiService;
	
	

	@GetMapping("/mypageImg/getimg")
	public ResponseEntity<byte[]> getImgPro(int pro_num){
		ProfileImgVO vo = proService.getImg(pro_num);
		String imgeName = vo.getPro_filename();
		byte[] imgeContent = (byte[])vo.getPro_img();
		String formatName = imgeName.substring(imgeName.lastIndexOf(".") + 1);
		final HttpHeaders headers = new HttpHeaders();
		
		 if(formatName.equalsIgnoreCase("jpg")) {
		    	headers.setContentType(MediaType.IMAGE_JPEG);
		 }else if(formatName.equalsIgnoreCase("png")) {
		    	headers.setContentType(MediaType.IMAGE_PNG);
		 }
		 
		return new ResponseEntity<byte[]>(imgeContent,headers,HttpStatus.OK);
	}
	
	@GetMapping("/classImg/getimg")
	public ResponseEntity<byte[]> getImgCover(int cover_num){
		ClassImgVO vo = imgService.getImg(cover_num);
		String imgeName = vo.getCover_name();
		byte[] imgeContent = (byte[])vo.getCover_file();
		String formatName = imgeName.substring(imgeName.lastIndexOf(".") + 1);
		final HttpHeaders headers = new HttpHeaders();
		
		 if(formatName.equalsIgnoreCase("jpg")) {
		    	headers.setContentType(MediaType.IMAGE_JPEG);
		 }else if(formatName.equalsIgnoreCase("png")) {
		    	headers.setContentType(MediaType.IMAGE_PNG);
		 }
		 
		return new ResponseEntity<byte[]>(imgeContent,headers,HttpStatus.OK);
	}
	
	//자격증 이미지 뽑기
	@GetMapping("/certiImg/getimg")
	public ResponseEntity<byte[]> getCertiCover(int certif_num){
		//System.out.println("썰티번호" + certif_num);
		CertificateVO vo = certiService.getImg(certif_num);
		String imgeName = vo.getCertif_name();
		byte[] imgeContent = (byte[])vo.getCertif_file();
		String formatName = imgeName.substring(imgeName.lastIndexOf(".") + 1);
		final HttpHeaders headers = new HttpHeaders();
		
		 if(formatName.equalsIgnoreCase("jpg")) {
		    	headers.setContentType(MediaType.IMAGE_JPEG);
		 }else if(formatName.equalsIgnoreCase("png")) {
		    	headers.setContentType(MediaType.IMAGE_PNG);
		 }
		 
		return new ResponseEntity<byte[]>(imgeContent,headers,HttpStatus.OK);
	}
	
	
		
	@GetMapping("/onlineImg/getimg")
	public ResponseEntity<byte[]> getImgOnline(int online_num){
		OnlineClassVO vo = onlineService.getImg(online_num);
		byte[] imgeContent = (byte[])vo.getOnline_thumbnail();
		final HttpHeaders headers = new HttpHeaders();
		
		headers.setContentType(MediaType.IMAGE_PNG);	 
		 
		return new ResponseEntity<byte[]>(imgeContent,headers,HttpStatus.OK);
	}
	
	
	
	
}
