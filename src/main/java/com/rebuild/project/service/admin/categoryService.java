package com.rebuild.project.service.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rebuild.project.dao.admin.categoryDAO;
import com.rebuild.project.vo.admin.*;

@Service
public class categoryService {
	@Autowired
	private categoryDAO dao;
	
	public int bcate_insert(BigCategoryVO vo) {
		return dao.bcate_insert(vo);
	}	
	
	public int scate_insert(SmallCategoryVO vo) {
		return dao.scate_insert(vo);
	}
	

	public List<BigsmallCategoryVO> list(){
		return dao.list();
	}
	
	public List<BigsmallCategoryVO> cate_list(){
		return dao.cate_list();
	}
	
	public int count() {
		return dao.count();
	}
	
	
	
	public List<BigsmallCategoryVO> searchByCate(int bcategory_num){
		return dao.searchByCate(bcategory_num);
	}
	
	public List<BigsmallCategoryVO> searchByCateList5(int bcategory_num){
		return dao.searchByCateList5(bcategory_num);
	}
	
	
	
	public List<BigCategoryVO> bcate_list(){
		return dao.bcate_list();
	}
	
	
	public int del_scate(int scategory_num) {
		return dao.del_scate(scategory_num);
	}
	
	public int del_bcate(int bcategory_num) {
		return dao.del_bcate(bcategory_num);
	}
	
	public String bcate_check(String bcategory_name) {
		return dao.bcate_check(bcategory_name);
	}
	
	public List<BigsmallCategoryVO> search(String keyword) {
		return dao.search(keyword);
	}
	
	public List<BigsmallCategoryVO> searchMore(String keyword) {
		return dao.searchMore(keyword);
	}
	
	
	
	
	public List<SmallCategoryVO> scate_list(int bcategory_num){
		return dao.scate_list(bcategory_num);
	}
	public List<SmallCategoryVO> allscate_list(){
		return dao.allscate_list();
	}
	
	public String scatename(int scategory_num) {
		return dao.scatename(scategory_num);
	}
	public String bcatename(int bcategory_num) {
		return dao.bcatename(bcategory_num);
	}
}
