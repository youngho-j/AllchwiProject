package com.rebuild.project.dao.classopen;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rebuild.project.vo.classopen.CertificateVO;

@Repository
public class CertificateDAO {
	@Autowired
	private SqlSession session;
	private final String NAMESPACE = "com.rebuild.mybatis.mapper.CertificateMapper";
	
	public int insert(CertificateVO vo) {
		return session.insert(NAMESPACE + ".insert",vo);
	}

	public int delete(int cert_num) {
		return session.delete(NAMESPACE + ".delete", cert_num);
	}
	
	public CertificateVO getImg(int certif_num) {
		return session.selectOne(NAMESPACE + ".imgList", certif_num);
	}

}
