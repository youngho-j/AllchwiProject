package com.rebuild.project.service.login;

//트랜잭션 처리를 위한 상속받을 인터페이스 구현 [로그인테이블, 포인트 테이블, 이미지 테이블, 회원정보테이블] 
public interface MemberJoinService {
	int joinMember(Object data);
}
