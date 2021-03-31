package com.rebuild.project.dao.community;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rebuild.project.vo.community.NoticeVO;

@Repository
public class NoticeDAO {
	@Autowired
	private SqlSession session;
	private String NAMESPACE="com.rebuild.mybatis.mapper.CommunityNoticeMapper";
	
	//공지글 작성
	public int writeNotice(NoticeVO ntv) {
		return session.insert(NAMESPACE + ".writeNotice", ntv);
	}
	//커뮤니티 관리자 확인(세션 회원 번호, 세션 튜터 번호)
	public int adminCheck(HashMap<String, Object> map) {
		return session.selectOne(NAMESPACE + ".adminCheck", map);
	}
	//공지사항 목록 출력
	public List<NoticeVO> noticeList(HashMap<String, Object> map){
		return session.selectList(NAMESPACE + ".noticeList", map);
	}
	//공지사항 글 갯수
	public int count(HashMap<String, Object> map) {
		return session.selectOne(NAMESPACE + ".count", map);
	}
	//상세 페이지 출력
	public NoticeVO getDetail(int notice_num) {
		return session.selectOne(NAMESPACE + ".getDetail", notice_num);
	}
	//조회수 증가시키기 
	public int hit(int notice_num) {
		return session.update(NAMESPACE + ".hit", notice_num);
	}
	//다음글
	public NoticeVO next(int notice_num) {
		return session.selectOne(NAMESPACE + ".next", notice_num);
	}
	//이전글
	public NoticeVO prev(int notice_num) {
		return session.selectOne(NAMESPACE + ".prev", notice_num);
	}
	//글삭제
	public int delete(int notice_num) {
		return session.delete(NAMESPACE + ".delete", notice_num);
	}
	//글수정
	public int update(NoticeVO ntv) {
		return session.update(NAMESPACE + ".update", ntv);
	}
	//이번주 공지사항 글 갯수
	public int weekNotice(int commu_num) {
		return session.selectOne(NAMESPACE + ".weekNotice", commu_num);
	}
}
