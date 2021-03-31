package com.rebuild.project.service.community;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rebuild.project.dao.community.NoticeDAO;
import com.rebuild.project.vo.community.NoticeVO;

@Service
public class NoticeService {
	@Autowired 
	private NoticeDAO ntd;
	
		//공지글 작성
		public int writeNotice(NoticeVO ntv) {
			return ntd.writeNotice(ntv);
		}
		//커뮤니티 관리자 확인(세션 회원 번호, 세션 튜터 번호)
		public int adminCheck(HashMap<String, Object> map) {
			return ntd.adminCheck(map);
		}
		//공지사항 목록 출력
		public List<NoticeVO> noticeList(HashMap<String, Object> map){
			return ntd.noticeList(map);
		}
		//공지사항 글 갯수
		public int count(HashMap<String, Object> map) {
			return ntd.count(map);
		}
		//조회수 증가 후 상세 페이지 출력
		@Transactional
		public NoticeVO getDetail(int notice_num) throws Exception{
			return ntd.getDetail(notice_num);
		}
		//조회수 증가시키기 
		public int hit(int notice_num) {
			return ntd.hit(notice_num);
		}
		//조회수 증가 후 다음글
		public NoticeVO next(int notice_num) {
			return ntd.next(notice_num);
		}
		//조회수 증가 후 이전글
		public NoticeVO prev(int notice_num) {
			return ntd.prev(notice_num);
		}
		//글삭제
		public int delete(int notice_num) {
			return ntd.delete(notice_num);
		}
		//글수정
		public int update(NoticeVO ntv) {
			return ntd.update(ntv);
		}
		//이번주 공지 글 갯수 
		public int weekNotice(int commu_num) {
			return ntd.weekNotice(commu_num);
		}
}
