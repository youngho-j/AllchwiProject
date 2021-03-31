package com.rebuild.project.controller.admin;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rebuild.project.page.util.PageUtil;
import com.rebuild.project.service.admin.categoryService;
import com.rebuild.project.vo.admin.*;

@Controller
public class CategoryController {
	@Autowired
	private categoryService service;
	
	@GetMapping("/admin/category")
	public String adminMain(Model model,@RequestParam(value="pageNum", defaultValue ="1"  )int pageNum) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		int totalRowCount =service.count();
		
		PageUtil pu = new PageUtil(pageNum, totalRowCount, 5, 5);
		map.put("startRow", pu.getStartRow()-1);
		
		List<BigsmallCategoryVO> cate_list = service.cate_list();
		List<BigCategoryVO> bcate_list = service.bcate_list();	//5개만 보여주는 리스트
		
		
		model.addAttribute("cate_list", cate_list);		//5개만 보여주는 리스트
		model.addAttribute("bcate_list", bcate_list);
		return ".admin.category";
	}
	
	
	//전체 카테고리 리스트
	@RequestMapping(value="/admin/searchByCate/list",produces= "application/json;charset=utf-8")
	@ResponseBody
	public List<BigsmallCategoryVO> searchByCate() {
		
		List<BigsmallCategoryVO> list = service.list();	
		
		return list;
	}
	
	//전체카테고리 5개만보여주기
	@RequestMapping(value="/admin/lessList",produces= "application/json;charset=utf-8")
	@ResponseBody
	public List<BigsmallCategoryVO> lessList() {
		List<BigsmallCategoryVO> cate_list = service.cate_list();	//5개만 보여주기
		
		return cate_list;
	}
	
	
		
	@RequestMapping(value="/admin/big_category/insert",produces= "application/json;charset=utf-8")
	@ResponseBody
	public List<BigsmallCategoryVO> big_category(BigCategoryVO vo) {
		service.bcate_insert(vo);
		List<BigsmallCategoryVO> list = service.list();
		
		return list;
	}

	
	@RequestMapping(value="/admin/big_category_list",produces= "application/json;charset=utf-8")
	@ResponseBody
	public List<BigCategoryVO> big_category_list() {
		List<BigCategoryVO> bcate_list = service.bcate_list();
		return bcate_list;
	}

	
	
	@RequestMapping(value="/admin/small_category",produces= "application/json;charset=utf-8")
	@ResponseBody
	public List<BigsmallCategoryVO> small_category(SmallCategoryVO vo) {
		
		service.scate_insert(vo);	
		List<BigsmallCategoryVO> list = service.list();
		
		return list;
	}
	
	@RequestMapping(value = "/admin/category/deleteScate", produces= "application/json;charset=utf-8")
	@ResponseBody
	public List<BigsmallCategoryVO> scategory_del(int scategory_num, int bcategory_num) {
		service.del_scate(scategory_num);
				
		List<BigsmallCategoryVO> searchByCate_list = service.searchByCate(bcategory_num);	//카테고리별 리스트
		return searchByCate_list;	
	}
	
	@RequestMapping(value = "/admin/category/deleteScate2", produces= "application/json;charset=utf-8")
	@ResponseBody
	public List<BigsmallCategoryVO> scategory_del2(int scategory_num, int bcategory_num) {
		service.del_scate(scategory_num);
		
		List<BigsmallCategoryVO> whole_list = service.list();	//전체리스트
		
		
		return whole_list;	
	}
	

	@RequestMapping(value = "/admin/category/deleteBcate", produces= "application/json;charset=utf-8")
	@ResponseBody
	public List<BigsmallCategoryVO> bcategory_del(int bcategory_num) {
		service.del_bcate(bcategory_num);
		List<BigsmallCategoryVO> whole_list= service.list();
		
		return whole_list;	
	}
	
	
	//카테고리별검색 전체리스트
	@RequestMapping(value = "/admin/category/searchByCate", produces= "application/json;charset=utf-8")
	@ResponseBody
	public List<BigsmallCategoryVO> searchByCate(int bcategory_num) {
		List<BigsmallCategoryVO> searchByCate_list = service.searchByCate(bcategory_num);
		return searchByCate_list;	
	}
	
	//카테고리별검색 list5개
	@RequestMapping(value = "/admin/category/searchByCateList5", produces= "application/json;charset=utf-8")
	@ResponseBody
	public List<BigsmallCategoryVO> searchByCateList5(int bcategory_num) {
		List<BigsmallCategoryVO> searchByCate_list5 = service.searchByCateList5(bcategory_num);
		return searchByCate_list5;	
	}
	
	
	//대분류 입력시 중복값 막기
	@RequestMapping(value="/admin/bcate_check",produces= "application/json;charset=utf-8")
	@ResponseBody
	public HashMap<String, Object> bcate_check(String bcategory_name) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		String using = service.bcate_check(bcategory_name);		
		map.put("using",using);
		return map;
	}
	
	//검색 5개만보기
	@RequestMapping(value="/admin/category/search",produces= "application/json;charset=utf-8")
	@ResponseBody
	public List<BigsmallCategoryVO> search(String keyword) {
		List<BigsmallCategoryVO> searchList = service.search(keyword);		
		return searchList;
	}
	
	//검색 5개이상 보기
	@RequestMapping(value="/admin/category/searchMore",produces= "application/json;charset=utf-8")
	@ResponseBody		
	public List<BigsmallCategoryVO> searchMore(String keyword) {
		List<BigsmallCategoryVO> searchMoreList = service.searchMore(keyword);		
		return searchMoreList;
	}	
	

}
