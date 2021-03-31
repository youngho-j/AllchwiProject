package com.rebuild.project.controller.classopen;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

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

import com.rebuild.project.service.admin.categoryService;
import com.rebuild.project.service.classdetail.ClassDetailService;
import com.rebuild.project.service.classopen.*;
import com.rebuild.project.service.login.KakaoLoginService;
import com.rebuild.project.vo.admin.*;
import com.rebuild.project.vo.classdetail.ClassDetailVO;
import com.rebuild.project.vo.classopen.*;
import com.rebuild.project.vo.location.*;
import com.rebuild.project.vo.profileImg.ProfileImgVO;

@Controller
public class ClassOpenController {
	@Autowired
	private ClassInfoService classinfo_service;
	@Autowired
	private categoryService category_service;
	@Autowired
	private ClassDetailService detail_service;
	
	@Autowired
	private KakaoLoginService kls;
	
	@RequestMapping("/class/enrollment")
	public String goEnrollement(Model model) {
		List<BigCategoryVO> bcate_list = category_service.bcate_list();
		String appKey = kls.getAppKey();
		
		model.addAttribute("bcate_list", bcate_list);
		model.addAttribute("appkey", appKey);

		return ".classOpen.ClassEnrollment";
	}
	
	// 작은카테고리 전송 컨트롤러
	@PostMapping("/class/category")
	@ResponseBody
	public List<SmallCategoryVO> getScate(int bcategory_num){
		List<SmallCategoryVO> list = category_service.scate_list(bcategory_num);
		return list;
	}
	
	@RequestMapping(value="/class/enrollmentInsert",produces ="application/text; charset=utf8",
			method = RequestMethod.POST)
	@ResponseBody
	public String classInsert(
			HttpSession session,
			ClassInfoVO vo,
			@RequestParam("picture")MultipartFile picture,
			@RequestParam("certName[]")String[] certName,
			@RequestParam("cert[]")List<MultipartFile> certes,
			@RequestParam("images")List<MultipartFile> images,
			@RequestParam("curriculum[]")List<String> curriculum) {
		
		int ml_num = (int)session.getAttribute("ml_num");
		vo.setMl_num(ml_num);
		
		String[] addr = vo.getClass_address().split(" ");
		
		// 도/특별시
		String state = addr[0];
		// 도/구
		String city = addr[1];
		
		//큰 테이블 중복여주 체크 후 insert
		BigLocationVO blocVo = new BigLocationVO(0, state);		
		
		//작은 카테고리 중복후 insert
		SmallLocationVO slocVo = new SmallLocationVO(0, 0, city);
		
		// 승인여부 init
		vo.setClass_auth(1);
		vo.setClass_status(1);
		
		// 프로필 이미지 업로드.
		String proImgName = picture.getOriginalFilename(); //프로필이미지 파일명
		byte[] proImgFile = null; //vo에 담을 바이트 이미지 파일
		try {
			proImgFile = picture.getBytes(); //multipart로 얻은 File 바이트형식으로 바꿔 저장
		} catch (IOException e1) {
			System.out.println(e1.getMessage());
		}
		
		// 프로필이미지 VO 생성
		ProfileImgVO proVo = new ProfileImgVO(0, proImgFile, proImgName,null);
		
		// 자격증 데이터 가져오기.
		ArrayList<CertificateVO> certList = new ArrayList<CertificateVO>(); // 여러개 일경우 받을 List
		for (int i = 0; i < certes.size(); i++) {
			MultipartFile cert = certes.get(i);	//list로 들어온 자격지 File 얻어오기
			String originalName = cert.getOriginalFilename(); // 자격증 파일명
			byte[] certFile = null;
			try {
				certFile = cert.getBytes();
			} catch (IOException e) {
				e.printStackTrace();
			}
			CertificateVO certVo = new CertificateVO(0, 12, originalName,certFile, certName[i], null);
			certList.add(certVo);
		}
			
		// 커버이미지 받아오기.
		ArrayList<ClassImgVO> coverList = new ArrayList<ClassImgVO>();
		for(MultipartFile img : images) {
			String originalNames = img.getOriginalFilename();
			byte[] imgFile = null;
			try {
				imgFile = img.getBytes();
			} catch (IOException e) {
				e.printStackTrace();
			}
			ClassImgVO imgVo = new ClassImgVO(0, 1, originalNames, imgFile, null);
			coverList.add(imgVo);
			
		}
		
		//커리큘럼 vo 생성
		ArrayList<CurriculumVO> curriList = new ArrayList<CurriculumVO>();
		for (int i = 0; i < vo.getClass_count(); i++) {
			CurriculumVO curriVo = new CurriculumVO(0, 0, i+1, curriculum.get(i), null);
			curriList.add(curriVo);
		}
		
		try {
			classinfo_service.insert(vo, blocVo, slocVo, proVo, certList, coverList, curriList);
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
		
		session.setAttribute("tutor_auth", 1);
		
		return "success";
	}
	
	@GetMapping("/class/classInfoUpdate")
	public String setClassUpdate(HttpSession session,Model model,int class_num) {
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("class_num",class_num);
		ClassDetailVO vo = detail_service.getDetail(map);
		List<BigCategoryVO> bcate_list = category_service.bcate_list();

		String appKey = kls.getAppKey();
		
		model.addAttribute("bcate_list", bcate_list);
		model.addAttribute("appkey", appKey);		
		model.addAttribute("list", vo);
		
		return ".classOpen.classEnrollmentUpdate";
	}
	
	@PostMapping("/class/classUpdate")
	@ResponseBody
	public ClassDetailVO classUpdate(HttpSession session,int class_num) {
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("class_num",class_num);
		ClassDetailVO vo = detail_service.getDetail(map);
		
		System.out.println("num" + vo.getCoverList().get(0).getCover_num());
		return vo;
	}
	
	@RequestMapping(value="/class/enrollmentUpdate",produces ="application/text; charset=utf8",
			method = RequestMethod.POST)
	@ResponseBody
	public String classUpdateInsert(
			HttpSession session,
			ClassInfoVO vo,
			@RequestParam(value="picture",required = false)MultipartFile picture,
			@RequestParam(value="certName[]",defaultValue = "")String[] certName,
			@RequestParam(value="cert[]",required = false)List<MultipartFile> certes,
			@RequestParam(value="images",required = false)List<MultipartFile> images,
			@RequestParam(value="curriculum[]",defaultValue = "")List<String> curriculum,
			@RequestParam(value="deleteCert[]",defaultValue = "")List<Integer> deletecert,
			@RequestParam(value="delCoverImg[]",defaultValue = "")List<Integer> delcoverimg) {
		
		int ml_num = (int)session.getAttribute("ml_num");
		vo.setMl_num(ml_num);
		
		String[] addr = vo.getClass_address().split(" ");
		
		// 도/특별시
		String state = addr[0];
		// 도/구
		String city = addr[1];
		
		//큰 테이블 중복여주 체크 후 insert
		BigLocationVO blocVo = new BigLocationVO(0, state);		
		
		//작은 카테고리 중복후 insert
		SmallLocationVO slocVo = new SmallLocationVO(0, 0, city);
		
		// 승인여부 init
		vo.setClass_auth(0);
		ProfileImgVO proVo = null;
		// 프로필 이미지 업로드.
		if(picture != null) {
			String proImgName = picture.getOriginalFilename(); //프로필이미지 파일명
			byte[] proImgFile = null; //vo에 담을 바이트 이미지 파일
			try {
				proImgFile = picture.getBytes(); //multipart로 얻은 File 바이트형식으로 바꿔 저장
			} catch (IOException e1) {
				System.out.println(e1.getMessage());
			}
			// 프로필이미지 VO 생성
			proVo = new ProfileImgVO(vo.getPro_num(), proImgFile, proImgName,null);
			System.out.println("profile"+vo.getPro_num());
		}
		
		// 자격증 데이터 가져오기.
		ArrayList<CertificateVO> certList = new ArrayList<CertificateVO>(); // 여러개 일경우 받을 List
		for (int i = 0; i < certes.size(); i++) {
			MultipartFile cert = certes.get(i);	//list로 들어온 자격지 File 얻어오기
			String originalName = cert.getOriginalFilename(); // 자격증 파일명
			byte[] certFile = null;
			try {
				certFile = cert.getBytes();
			} catch (IOException e) {
				e.printStackTrace();
			}
			CertificateVO certVo = new CertificateVO(0, 0, originalName,certFile, certName[i], null);
			certList.add(certVo);
		}
			
		// 커버이미지 받아오기.
		ArrayList<ClassImgVO> coverList = new ArrayList<ClassImgVO>();
		for(MultipartFile img : images) {
			String originalNames = img.getOriginalFilename();
			byte[] imgFile = null;
			try {
				imgFile = img.getBytes();
			} catch (IOException e) {
				e.printStackTrace();
			}
			ClassImgVO imgVo = new ClassImgVO(0, 1, originalNames, imgFile, null);
			coverList.add(imgVo);
			
		}
		
		//커리큘럼 vo 생성
		ArrayList<CurriculumVO> curriList = new ArrayList<CurriculumVO>();
		for (int i = 0; i < vo.getClass_count(); i++) {
			CurriculumVO curriVo = new CurriculumVO(0, 0, i+1, curriculum.get(i), null);
			curriList.add(curriVo);
		}
		
		try {
			classinfo_service.update(vo, blocVo, slocVo, proVo, certList, coverList, curriList,delcoverimg,deletecert);
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
		
		return "success";
	}
	
	@PostMapping("/class/classDelete")
	@ResponseBody
	public String classDelete(HttpSession session, int class_num) {
		int ml_num = (int)session.getAttribute("ml_num");
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("class_num",class_num);
		map.put("ml_num",ml_num);
		
		try {
			classinfo_service.classDelete(map);
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
		return "success";
	}
	
}
