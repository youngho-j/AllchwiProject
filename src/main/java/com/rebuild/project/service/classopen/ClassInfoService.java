package com.rebuild.project.service.classopen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rebuild.project.dao.classopen.*;
import com.rebuild.project.dao.location.*;
import com.rebuild.project.dao.profileImg.ProfileImgDAO;
import com.rebuild.project.service.login.MemberLoginService;
import com.rebuild.project.vo.classopen.*;
import com.rebuild.project.vo.location.*;
import com.rebuild.project.vo.myclasslist.MyClassListVO;
import com.rebuild.project.vo.profileImg.ProfileImgVO;

@Service
public class ClassInfoService {
	@Autowired
	private ClassInfoDAO infoDao;
	@Autowired
	private CertificateDAO certDao;
	@Autowired
	private ProfileImgDAO proImgDao;
	@Autowired
	private CurriculumDAO curriDao;
	@Autowired
	private ClassImgDAO coverDao;
	@Autowired
	private BigLocationDAO bigDao;
	@Autowired
	private SmallLocationDAO smallDao;
	@Autowired
	private MemberLoginService loginService;
	
	public int insert(ClassInfoVO vo) {
		return infoDao.insert(vo);
	}
	
	public List<ClassInfoVO> list(HashMap<String, Object> map){
		return infoDao.list(map);
	}
	public int count(HashMap<String, Object> map) {
		return infoDao.count(map);
	}
	
	public ClassInfoVO getTutorinfo(int class_num) {
		return infoDao.getTutorinfo(class_num);
	}
	@Transactional
	public boolean insert(ClassInfoVO vo, 
			BigLocationVO blocVo, 
			SmallLocationVO slocVo,
			ProfileImgVO proVo,
			ArrayList<CertificateVO> certList, 
			ArrayList<ClassImgVO> coverList, 
			ArrayList<CurriculumVO> curriList) throws Exception{
		
		
		//큰 지역 (도/특별시) insert
		bigDao.insert(blocVo);
		
		//작은지역의 큰지역 key 넣기
		slocVo.setBloc_num(blocVo.getBloc_num());
		
		//작은 지역 (시/구) 
		smallDao.insert(slocVo);
		
		//튜터프로필 넣기
		proImgDao.insert(proVo);
		
		// 수업정보에 작은 지역 넗기
		vo.setSloc_num(slocVo.getSloc_num());
		// 수업정보에 프로필번호 넣기
		vo.setPro_num(proVo.getPro_num());
		
		// 수업정보 insert
		int infoNum =  infoDao.insert(vo);

		// 수업 번호 가져 오기.
		int class_num = vo.getClass_num();
		
		// 자격증 insert
		for(CertificateVO cert:certList) {
			cert.setClass_num(class_num);
			certDao.insert(cert);
		}
		
		for(ClassImgVO cover:coverList) {
			cover.setClass_num(class_num);
			coverDao.insert(cover);
		}
		
		for(CurriculumVO curri:curriList) {
			curri.setClass_num(class_num);
			curriDao.insert(curri);
		}
		
		loginService.tutorAuth(vo.getMl_num());
		
		return true;
	}

	public ClassInfoVO getInfo(int class_num) {
		return infoDao.getInfo(class_num);
	}
	
	public HashMap<String, Object> getMyBoardInfo(HashMap<String, Object> map) {
		return infoDao.getMyBoardInfo(map);
	}
	public List<ClassInfoVO> getClassTitle(int ml_num) {
		return infoDao.getClassTitle(ml_num);
	}
	public ClassInfoVO select(int class_num) {
		return infoDao.select(class_num);
	}

	public List<MyClassListVO> getMyList(HashMap<String, Object> map) {
		return infoDao.getMyList(map);
	}

	public int countMy(HashMap<String, Object> map) {
		return infoDao.countMy(map);
	}

	public int statusUpdate(HashMap<String, Object> map) {
		return infoDao.statusUpdate(map);
	}
	
	@Transactional
	public boolean update(ClassInfoVO vo, BigLocationVO blocVo, SmallLocationVO slocVo, ProfileImgVO proVo,
			ArrayList<CertificateVO> certList, 
			ArrayList<ClassImgVO> coverList, 
			ArrayList<CurriculumVO> curriList,
			List<Integer> delcoverimg, 
			List<Integer> deletecert) throws Exception{
		
				//큰 지역 (도/특별시) insert
				bigDao.insert(blocVo);
				
				//작은지역의 큰지역 key 넣기
				slocVo.setBloc_num(blocVo.getBloc_num());
				
				//작은 지역 (시/구) 
				smallDao.insert(slocVo);
				
				if(proVo !=null) {
					//튜터프로필 넣기
					proImgDao.updateImg(proVo);
				}
				
				// 수업정보에 작은 지역 넗기
				vo.setSloc_num(slocVo.getSloc_num());
				
				// 수업정보 insert
				int infoNum =  infoDao.update(vo);

				// 수업 번호 가져 오기.
				int class_num = vo.getClass_num();
				
				// 자격증 insert
				for(CertificateVO cert:certList) {
					cert.setClass_num(class_num);
					certDao.insert(cert);
				}
				
				for(ClassImgVO cover:coverList) {
					cover.setClass_num(class_num);
					coverDao.insert(cover);
				}
				
				curriDao.delete(vo.getClass_num());
				
				for(CurriculumVO curri:curriList) {
					curri.setClass_num(class_num);
					curriDao.insert(curri); //update insert
				}
				
				// 삭제한 커버이미지 
				for(int cover_num : delcoverimg) {
					coverDao.delete(cover_num);
				}
				
				// 자격증 삭제
				for(int cert_num : deletecert) {
					certDao.delete(cert_num);
				}
				
				//튜터 여부 업데이트
				
				
				
				return true;
	}

	public int salesUpdate(HashMap<String, Object> map) throws Exception {
		return infoDao.salesUpdate(map);
	}

	public void classDelete(HashMap<String, Object> map) throws Exception{
		infoDao.classDelete(map);
		loginService.tutorAuth((int)map.get("ml_num"));
	}
}
