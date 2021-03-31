# 온/오프라인 취미클래스 수강사이트 Allchwi

# 목적
취미를 배우고 싶은 사람과 클래스를 운영하고 싶은 사람을 매칭해주는 웹사이트를 구현하고자 함

# 프로젝트 기획의도
언제나 어디서나 누구나 들을 수 있는 온라인강의부터
직접 체험하는 오프라인 강의까지!

학생들은 자신이 원하는 수업을 클릭 한번으로 신청 할 수 있고 
튜터는 자신이 잘하는 것으로 수익을 낼 수 있습니다.

# 메인페이지
<p align="center"><img src="/main.png" width="60%" height="70%" title="메인페이지"></img></p>


# 개발환경
| 운영체제 	| DB 	| 사용언어 	| 라이브러리/프레임워크	| 개발도구	| Web Server  	|  
|:--:|:--:|:--:|:--:|:--:|:--:|
| Window7 	| MariaDB 	| Java, Javascript, CSS 	| jQuery, Mybatis 	|  Spring Tool Suite 3	|  Tomcat 8.5.15	| 

# 기능설명

## 1. 회원

- 로그인  
- 프로필  
- 위시리스트  
- 결제
- 수업신청
- Q&A
- 리뷰
- 마이페이지
- 커뮤니티

## 2. 관리자

- 카테고리 관리
- 수업 관리
- 튜터 심사
- 수업료 정산
- 통계

## 3. 튜터

- 수업개설(온/오프라인)
- 학생관리
- 수업관리
- Q&A답변
- 온라인 커뮤니티 관리(공지사항, 자료실, 강의, 과제, QnA)
- 수업료 정산

# 프로젝트에서 맡은 역할

### 회원
- 로그인(일반, 소셜 - 카카오API)
- 회원가입
- 비밀번호 변경(Java Mail API)
- 포인트(적립, 내역) / 프로필 / 탈퇴 

### 튜터
- 수업 신청서 관리(수업 신청서 post 방식 페이징 처리, 신청 수락 및 반려 모달 창)
- 온라인 커뮤니티 관리(커뮤니티 창 생성, 공지사항 게시판)