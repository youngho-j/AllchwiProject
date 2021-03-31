<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript" src="${cp}/resources/js/jquery-3.5.1.js"></script>
<link rel="stylesheet" href="${cp }/resources/css/mypage/changePwdForm.css">
<div class="container">
	<div class="pw_cont02">
		<div class="box1">
			<div class="title_box">
				<div class="left">비밀번호 재설정</div>
			</div>
			<form action="${cp}/mypage/changePwd" method="POST" id="changePwd" onsubmit="return buttonUp()">
				<div class="main_box">
					<!--1 회원정보중 회원 번호를 넘겨서 업데이트 시켜줘야함 -->
					<input type="hidden" id="ml_num" name="ml_num"
						class="form-control" value="${mlv.ml_num}">
					<input type="hidden" id="id" name="id"
						class="form-control" value="${mlv.id}">
					<div class="input_box">
						<div class="left_box">
							<b>·</b>&nbsp;현재 비밀번호
						</div>
						<div class="right_box">
							<input type="password" id="currPwd" onblur="checkPwd()" name="currPwd"
								class="form-control" placeholder="현재 비밀번호">
							<span id="cpMsg" style="font-size: 15px; padding-left: 14px;"></span>
						</div>
					</div>
					<div class="input_box">
						<div class="left_box">
							<b>·</b>&nbsp;새 비밀번호
						</div>
						<div class="right_box">
							<input type="password" id="inPwd" name="pwd" onblur="pwdValidation()"
								class="form-control" placeholder="새 비밀번호" disabled="disabled">
								<span id="ipMsg" style="font-size: 15px; padding-left: 14px;"></span>
						</div>
					</div>
					<div class="input_box">
						<div class="left_box">
							<b>·</b>&nbsp;비밀번호 확인
						</div>
						<div class="right_box">
							<input type="password" id="cfmPwd"  onblur="pwdDCheck()"
								class="form-control" placeholder="비밀번호 확인" disabled="disabled">
								<span id="cfpMsg" style="font-size: 15px; padding-left: 14px;"></span>
						</div>
					</div>
				</div>
				<div class="foot_box">
					<input type="submit" class="btn btn-danger btn-lg" id="btn"
					value="비밀번호 변경" onsubmit="return buttonUp()" disabled="disabled">
				</div>
			</form>
		</div>
	</div>
</div>
<script type="text/javascript">
//모든 값이 입력되었을때 데이터를 보내기 위한 변수 선언
var curBl = false;
var inBl = false;
var cfmBl = false;
//현재 비밀번호와 일치하는지 확인(ajax사용) 
function checkPwd(){
	//검색을 위한 조건 값을 받아옴
	let id = $("#id").val();
	let pwd = $("#currPwd").val();
	//현재비밀번호관련 메세지 출력창
	let cpMsg = $("#cpMsg");
	//비밀번호가 일치할 경우 입력할 수 있게 활성화하려고 값을 가져옴 
	let inPwd = $("#inPwd");
	let cfmPwd = $("#cfmPwd");
	$.getJSON("${cp}/CheckPWD.do",
		{id : id, pwd : pwd},
		function(data){
			if(data.code == 'success'){
				cpMsg.css('color','green');
				cpMsg.html("비밀번호가 일치합니다.");
				inPwd.removeAttr('disabled');
				cfmPwd.removeAttr('disabled');
				curBl = true;
				buttonUp();
			} else {
				cpMsg.css('color','red');
				cpMsg.html("비밀번호가 일치하지 않습니다.");
				inPwd.attr("disabled",true);
				cfmPwd.attr("disabled",true);
				curBl = false;
			}
	});
}
//비밀번호 유효성 검사
function pwdValidation() {
	let pwd = $("#inPwd").val();
	let prevPwd = $("#currPwd").val();
	let ipMsg = $("#ipMsg");
	// 특문 + 숫자 + 영문
	var regExpPwd = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[!@#$%^&*()])[A-Za-z\d!@#$%^&*()]/;
	if(!regExpPwd.test(pwd)) {
		ipMsg.css('color','red');
		ipMsg.html("영문 + 숫자 + 특수문자를 조합해주세요.");
		inBl = false;
	} else if (pwd.length < 8) {
		ipMsg.css('color','red');
		ipMsg.html("8자리 이상 입력해주세요.");
		inBl = false;
	} else if (pwd.length > 10) {
		ipMsg.css('color','red');
		ipMsg.html("10자리 이내로 입력해주세요.");
		inBl = false;
	} else if(pwd === prevPwd){
		ipMsg.css('color','red');
		ipMsg.html("사용불가(전 비밀번호와 일치)");
		inBl = false;
	} else {
		ipMsg.css('color','green');
		ipMsg.html("사용가능한 비밀번호입니다.");
		inBl = true;
		buttonUp();
	}
}
//비밀번호 확인 유효성 검사
function pwdDCheck() {
	let pwd = $("#inPwd").val();
	let pwd1 = $("#cfmPwd").val();
	let cfpMsg = $("#cfpMsg");
	if(pwd1 === "") {
		cfpMsg.css('color','red');
		cfpMsg.html("비밀번호를 재입력해주세요.");
		cfmBl = false;
	} else if (pwd !== pwd1) {
		cfpMsg.css('color','red');
		cfpMsg.html("비밀번호가 일치하지 않습니다.");
		cfmBl = false;
	} else {
		cfpMsg.css('color','green');
		cfpMsg.html("비밀번호가 일치합니다.");
		cfmBl = true;
		buttonUp();
	}
}
//버튼 활성화 함수 -> submit, 클릭 
function buttonUp() {
	let btn = $("#btn");
	if(curBl && inBl && cfmBl) {
		btn.removeAttr('disabled');
		return true;
	} else {
		btn.attr('disabled', true);
		return false;
	}
}
</script>
