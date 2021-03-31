package com.rebuild.project.service.myclassmanage;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rebuild.project.dao.myclassmanage.MyClassManageDAO;
import com.rebuild.project.vo.classapply.ClassApplyVO;
import com.rebuild.project.vo.classopen.ClassInfoVO;
import com.rebuild.project.vo.myclassmanage.MyClassManageVO;

@Service
public class MyClassManageService {
	
	@Autowired
	private MyClassManageDAO mcmd;
	
	//a 클래스 신청한 회원 목록 보기
	public List<MyClassManageVO> searchApply(HashMap<String, Object> hm) {
		return mcmd.searchApply(hm);
	}
	//a 개설한 클래스번호 및 타이틀 목록 보기
	public List<ClassInfoVO> searchMyClass(int ml_num) {
		return mcmd.searchMyClass(ml_num);
	}
	//a 클래스 신청서 카운팅
	public int applyCounting(HashMap<String, Object> hm) {
		return mcmd.applyCounting(hm);
	}
	//신청서 넘버로 신청한 회원정보 가져오기
	public ClassApplyVO getApply(int apply_num) {
		return mcmd.getApply(apply_num);
	}
	//신청서 넘버로 수업승인 업데이트
	public int updateApply(int apply_num) {
		return mcmd.updateApply(apply_num);
	}
}
