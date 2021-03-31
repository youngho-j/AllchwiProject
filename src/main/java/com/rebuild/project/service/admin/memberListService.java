package com.rebuild.project.service.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rebuild.project.dao.admin.memberListDAO;
import com.rebuild.project.vo.admin.MemberListVO;

@Service
public class memberListService {
	@Autowired
	private memberListDAO dao;
	
	public List<MemberListVO> member_list(){
		return dao.member_list();
	}

	@Transactional
	public int update_mlnum (int ml_num) throws Exception {
		dao.update_mlnum_ml(ml_num);	//member_login 테이블 탈퇴처리
		dao.update_mlnum_mi(ml_num);	//member_info 테이블 탈퇴처리
		return 1;
	}
	
	
}

