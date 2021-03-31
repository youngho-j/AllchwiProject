package com.rebuild.project.service.classdetail;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rebuild.project.dao.classdetail.ClassReviewDAO;
import com.rebuild.project.vo.classdetail.ClassReviewVO;
@Service
public class ClassReviewService {
@Autowired private ClassReviewDAO dao;
	public int insertReview(ClassReviewVO vo) {
		return dao.insertReview(vo);
	}
	public List<ClassReviewVO> reviewList(HashMap<String, Object> map) {
		return dao.reviewList(map);
	}
	public int rcount(HashMap<String, Object> map) {
		return dao.rcount(map);
	}
	public int writeOk(HashMap<String, Object> map) {
		return dao.writeOk(map);
	}
	public ClassReviewVO rate_avg(int class_num) {
		return dao.rate_avg(class_num);
	}
	public List<ClassReviewVO> best_tutor(){
		return dao.best_tutor();
	}
}
