package com.rebuild.project.dao.wishlist;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rebuild.project.vo.wishlist.*;

@Repository
public class WishListDAO {
	@Autowired
	private SqlSession session;
	private final String NAMESPACE = "com.rebuild.mybatis.mapper.WishListMapper";	
	public int insertWish(WishListVO vo) {
		return session.insert(NAMESPACE+".insertWish", vo);
	}
	public int deleteWish(WishListVO vo) {
		return session.delete(NAMESPACE+".deleteWish", vo);
	}
	public WishListVO getWish(HashMap<String, Object> map) {
		return session.selectOne(NAMESPACE+".getWish", map);
	}
	public List<WishListJoinVO> getWishList(HashMap<String, Object> map) {
		return session.selectList(NAMESPACE + ".myWishList", map);
	}
	public int count(int ml_num) {
		return session.selectOne(NAMESPACE+".count",ml_num);
	}

}
