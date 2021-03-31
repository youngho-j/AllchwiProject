package com.rebuild.project.filter;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.StringUtils;



public class LoginCheckFilter implements Filter {
	private List<String> excludedUrls;
	
	/*
	 * 제외할 URL 파라미터로 전달 받아 List에 초기 세팅 해준다
	 * --> Context path를 제외한 다음 URL만 검사한다
	 *  /allchwi/class URL을 받을 경우 class를 파라미터로 넘겨줘야 제외된다.
	 * 
	 * */
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		String excludePattern = filterConfig.getInitParameter("excludedUrls");
	    excludedUrls = Arrays.asList(excludePattern.split(","));
	    System.out.println(excludedUrls);
	}

	/*
	 * 	URL 필터 적용 해야 페이지에 넘어갈때 로그인 여부 판단
	 * 
	 * */
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		// Redirect 여부 저장
		boolean isRedirect = false;
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		
		// URL 정보 String으로 받아온다
		String path = req.getRequestURI();
		
		// URL 정보 /개수를 판단하여 루트 여부 판다
		int count = StringUtils.countOccurrencesOf(path, "/");
		if(count > 1) {
			// 루트가 아니면 context path 다음 URL 문자 추출
			path = path.split("/")[1];
		}
		
		// path 정보가 제외된 URL에 포함여부 판다 
		// path가 root인지 판단해준다
		if(!excludedUrls.contains(path) && !path.equals("/"))
		{
			// 세션에 ml_num(회원 번호)가 있는지 확인
			Integer ml_num = (Integer)req.getSession().getAttribute("ml_num");
			if(ml_num==null) {
				// 회원정보가 없으면 ㅑisRedirect true로 변경
				isRedirect = true;
			}
		}
		
		if(isRedirect == true){
			// 회원 정보가 없으면 로그인 페이지로 이동
			req.getRequestDispatcher("/login/main").forward(req, resp);
		}else {
			// 로그인 확인후 원래 진행할려 했던 Controller로 이동 시켜준다
			chain.doFilter(req, resp);
		}		 
	}

	@Override
	public void destroy() {
		
	}

}
