<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript" src="${cp}/resources/js/jquery-3.5.1.js"></script>
<link rel="stylesheet" href="${cp }/resources/css/mypage/signoutForm.css">
<div class="container">
	<div class="pw_cont02">
		<div class="box1">
			<div class="title_box">
				<div class="left">회원 탈퇴</div>
			</div>
			<form action="${cp}/mypage/signout" method="POST" id="signout" onsubmit="return buttonUp()">
				<div class="main_box">
					<!--1 회원정보중 회원 번호를 넘겨서 업데이트 시켜줘야함 -->
					<input type="hidden" id="ml_num" name="ml_num"
						class="form-control" value="${mlv.ml_num}">
					<!-- ajax 처리시  id value값 넘겨줘야함 -->
					<input type="hidden" id="id" name="id"
						class="form-control" value="${mlv.id}">
					<div class="input_box">
						<div class="left_box">
							<b>·</b>&nbsp;아이디
						</div>
						<!-- 나중에 값 받아서 넣기 -->
						<div class="right_box" id="maildiv">
							${mlv.id}	
						</div>
					</div>
					<div class="input_box">
						<div class="left_box">
							<b>·</b>&nbsp;비밀번호
						</div>
						<div class="right_box">
							<input type="password" id="currPwd" onblur="checkPwd()" name="pwd"
								class="form-control" placeholder="비밀번호를 입력해주세요.">
							<span id="cpMsg" style="font-size: 15px; padding-left: 14px;"></span>
						</div>
					</div>
					<div class="input_box">
						<div class="left_box">
						</div>
						<div class="right_box">
							<textarea class="form-control" name="mb_reason" id="feedback" placeholder="서비스 탈퇴 사유에 대해 알려주세요." onblur="feedValidation()"></textarea>
							<span id="fdMsg" style="font-size: 15px; padding-left: 14px;"></span>
						</div>
					</div>
				</div>
				<div class="foot_box">
					<input type="submit" class="btn btn-danger btn-lg" id="btn"
					value="탈퇴 신청" onsubmit="return buttonUp()" disabled="disabled">
				</div>
			</form>
		</div>
	</div>
</div>
<script type="text/javascript">
//모든 값이 입력되었을때 데이터를 보내기 위한 변수 선언
var currBl = false;
var feedBl = false;
//현재 비밀번호와 일치하는지 확인(ajax사용) 
function checkPwd(){
	//검색을 위한 조건 값을 받아옴
	let id = $("#id").val();
	let pwd = $("#currPwd").val();
	let cpMsg = $("#cpMsg");
	$.getJSON("${cp}/CheckPWD.do",
		{id : id, pwd : pwd},
		function(data){
			if(data.code == 'success'){
				cpMsg.css('color','green');
				cpMsg.html("비밀번호가 일치합니다.");
				currBl = true;
				buttonUp();
			} else {
				cpMsg.css('color','red');
				cpMsg.html("비밀번호가 일치하지 않습니다.");
				currBl = false;
			}
	});
}
//탈퇴사유 유효성 검사
function feedValidation() {
	let feed = $("#feedback").val();
	let fdMsg = $("#fdMsg");
	//a 공백일 경우 
	if(feed === "") {
		fdMsg.css('color','red');
		fdMsg.html("사유를 작성해 주세요.");
		feedBl = false;
	} else {
		feedBl = true;
		buttonUp();
	}
}
//버튼 활성화 함수 -> submit, 클릭 
function buttonUp() {
	let btn = $("#btn");
	if(currBl && feedBl) {
		btn.removeAttr('disabled');
		return true;
	} else {
		btn.attr('disabled', true);
		return false;
	}
}
</script>
