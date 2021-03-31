package com.rebuild.project.service.classopen;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rebuild.project.dao.classopen.ClassDateDAO;
import com.rebuild.project.vo.classopen.ClassDateVO;;

@Service
public class ClassDateService {
	@Autowired private ClassDateDAO dao;
	
	public List<ClassDateVO> list(int class_num){
		return dao.list(class_num);
	}
	
	@Transactional
	public int insert(ArrayList<ClassDateVO> list) {
		
		int n = 0;
		int ref = 0;
		for(ClassDateVO vo:list) {
			vo.setTime_ref(ref);
			dao.insert(vo);
			if(vo.getTime_cnt() == 1) {
				ref = vo.getDate_num();
				dao.update(ref);
			}
		}
		
		return n;
	}
	
	public int insert(ClassDateVO vo) {
		
		int n = 0;
		int ref = 0;
		
		n += dao.insert(vo);
		ref = vo.getTime_ref();
		dao.update(ref);
		
		return n;
	}

	public List<ClassDateVO> select(int class_num) {
		return dao.select(class_num);
	}
	@Transactional
	public void deleteDate(List<Integer> delDate) {
		
		for (int i = 0; i < delDate.size(); i++) {
			dao.deleteDate(delDate.get(i));
		}
		
	}
}
