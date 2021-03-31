package com.rebuild.project.service.classopen;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rebuild.project.dao.classopen.ClassImgDAO;
import com.rebuild.project.vo.classopen.ClassImgVO;

@Service
public class ClassImgService {
	@Autowired
	private ClassImgDAO dao;
	
	public int insert(ClassImgVO vo) {
		return dao.insert(vo);
	}
	
	public ClassImgVO getImg(int cover_num) {
		return dao.getImg(cover_num);
	}
	//a 튜터번호로 이미지 리스트 가져오기
	public List<ClassImgVO> getImgList(int class_num){
		return dao.getImgList(class_num);
	}
}
