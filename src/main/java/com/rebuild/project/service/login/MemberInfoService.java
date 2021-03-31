package com.rebuild.project.service.login;

import java.util.HashMap;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rebuild.project.dao.login.*;
import com.rebuild.project.dao.profileImg.ProfileImgDAO;
import com.rebuild.project.vo.login.ProfileVO;
import com.rebuild.project.vo.profileImg.ProfileImgVO;

@Service
public class MemberInfoService {
	@Autowired
	private MemberInfoDAO mid;
	
	@Autowired
	private ProfileImgDAO pid;
	
	@Autowired
	private MemberLoginDAO mld;
	
	//1회원탈퇴정보 업데이트 트랜잭션 처리 필요
	@Transactional
	public int UpdateSignout(HashMap<String, Object> hm) throws Exception{
		//a 회원정보에 탈퇴사유, 탈퇴 승인번호 업데이트
		int n = mid.UpdateSignout(hm);
		//a 로그인정보에 탈퇴 승인번호 업데이트
		int n1 = mld.signout(hm);
		return n+n1;
	}
	//2회원정보 조회
	public ProfileVO selectInfo(int ml_num) {
		return mid.selectInfo(ml_num);
	}
	//3프로필 업데이트
	@Transactional
	public boolean updateInfo(ProfileImgVO piv, ProfileVO pfv) throws Exception{
		HashMap<String, Object> hm = new HashMap<String, Object>();
		int ui2 = 0;
		hm.put("ml_num", pfv.getMl_num());
		//a 별명 map에 담기
		hm.put("mb_nickname", pfv.getMb_nickname());
		//a 내 소개 map에 담기
		hm.put("mb_about", pfv.getMb_about());
		//a 별명, 소개 업데이트
		int ui = mid.UpdateInfo(hm);
		//a 이미지 파일이 있을 경우 
		if(piv != null) {
			//a 이미지 번호 검색
			int pro_num = mid.selectProNum(pfv.getMl_num());
			//a 이미지번호 piv에 담기
			piv.setPro_num(pro_num);
			ui2 = pid.updateImg(piv);
			//a 한번에 업데이트 된 경우
			if(ui + ui2 >= 2) {
				return true;			
			} else {
				return false;
			}
		} else {
			//a 이미지 파일이 없을경우
			if(ui > 0) {
				return true;
			} else {
				return false;
			}			
		}
	}
}
