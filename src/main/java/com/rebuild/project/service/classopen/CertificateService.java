package com.rebuild.project.service.classopen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rebuild.project.dao.classopen.CertificateDAO;

import com.rebuild.project.vo.classopen.CertificateVO;

@Service
public class CertificateService {
	@Autowired
	private CertificateDAO dao;
	
	public int insert(CertificateVO vo) {
		return dao.insert(vo);
	}
	
	public CertificateVO getImg(int certif_num){
		return dao.getImg(certif_num);
	}
	
}
