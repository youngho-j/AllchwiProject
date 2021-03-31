package com.rebuild.project.controller.search;

import java.util.HashMap;
import java.util.List;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.rebuild.project.page.util.PageUtil;
import com.rebuild.project.service.admin.categoryService;
import com.rebuild.project.service.classopen.ClassInfoService;
import com.rebuild.project.service.location.*;
import com.rebuild.project.vo.admin.*;
import com.rebuild.project.vo.classopen.ClassInfoVO;
import com.rebuild.project.vo.location.*;

@Controller
public class ListSearchController {
	@Autowired private ClassInfoService service;
	@Autowired private categoryService category_service;
	@Autowired private BigLocationService bloc_service;
	@Autowired private SmallLocationService sloc_service;

	@RequestMapping(value="/list/search",method = {RequestMethod.GET,RequestMethod.POST},produces ="application/text; charset=utf8")
	public ModelAndView goSearchList(HttpServletRequest req,@RequestParam(value="pageNum",defaultValue="1")int pageNum,
										@RequestParam(value="bcategory_num",defaultValue="-1")int bcategory_num, 
										@RequestParam(value="scategory_num",defaultValue="-1")int scategory_num,
										@RequestParam(value="keyword",defaultValue="")String keyword,
										@RequestParam(value="startDate",defaultValue="")String startDate,
										@RequestParam(value="endDate",defaultValue="")String endDate,
										@RequestParam(value="sloc_num",defaultValue="-1")int sloc_num,
										@RequestParam(value="class_month",defaultValue="-1")int class_month,
										@RequestParam(value="class_form",defaultValue="-1")int class_form) {
		
	
		ModelAndView mv=new ModelAndView(".search.detailSearch");
		HashMap<String, Object> map=new HashMap<String, Object>();
		
		// 필요한 정보(파라미터로 받아온 정보) map 에 저장
		map.put("bcategory_num", bcategory_num);
		map.put("scategory_num", scategory_num);
		map.put("keyword", keyword);
		map.put("sloc_num", sloc_num);
		map.put("startDate", startDate);
		map.put("endDate", endDate);
		map.put("class_month", class_month);
		map.put("class_form", class_form);
		
		
		// 페이징
		int totalRowCount=service.count(map);
		PageUtil pu=new PageUtil(pageNum, totalRowCount, 9, 5);
		int startRow=pu.getStartRow()-1;
		map.put("startRow", startRow);	
		List<ClassInfoVO> list=service.list(map);
		
		// 검색 목록에 필요한 기본 정보 담기
		List<BigCategoryVO> bigcalte_list=category_service.bcate_list();
		List<SmallCategoryVO> smallcate_list = category_service.allscate_list();
		List<BigLocationVO> bloc_list=bloc_service.blocList();
		String scategory_name=category_service.scatename(scategory_num);
		String bcategory_name=category_service.bcatename(bcategory_num);
		mv.addObject("scategory_name", scategory_name);
		mv.addObject("bcategory_name", bcategory_name);
		mv.addObject("smallcate_list", smallcate_list);
		mv.addObject("bigcalte_list", bigcalte_list);
		mv.addObject("bloc_list", bloc_list);
		mv.addObject("list", list);
		mv.addObject("keyword",keyword);
		mv.addObject("sloc_num",sloc_num);
		mv.addObject("class_month",class_month);
		mv.addObject("class_form",class_form);
		mv.addObject("bcategory_num",bcategory_num);
		mv.addObject("scategory_num",scategory_num);
		mv.addObject("pu",pu);

		return mv;
	}
	
	// 세부 지역 불러오기
	@PostMapping("/locatrion/search")
	@ResponseBody
	public List<SmallLocationVO> getScate(int bloc_num){
		List<SmallLocationVO> sloc_list = sloc_service.slocList(bloc_num);
		return sloc_list;
	}
}
