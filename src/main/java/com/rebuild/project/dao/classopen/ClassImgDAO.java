package com.rebuild.project.dao.classopen;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rebuild.project.vo.classopen.ClassImgVO;

@Repository
public class ClassImgDAO {
	@Autowired
	SqlSession session;	
	private final String NAMESPACE = "com.rebuild.mybatis.mapper.ClassImgMapper";
	
	public int insert(ClassImgVO vo) {
		return session.insert(NAMESPACE + ".insert",vo);
	}

	public ClassImgVO getImg(int cover_num) {
		return session.selectOne(NAMESPACE + ".imgSelect", cover_num);
	}

	public int delete(int cover_num) {
		return session.delete(NAMESPACE + ".delete",cover_num);
	}
	//a 튜터번호로 이미지 리스트 가져오기
	public List<ClassImgVO> getImgList(int class_num){
		return session.selectList(NAMESPACE + ".imgList", class_num);
	}
	
}
