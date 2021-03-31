<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link rel="stylesheet" href="${cp }/resources/css/login/loginForm.css">
<div id=loginbody>
	<div class="login-form">
		<form action="${cp}/login/signUp" onsubmit="return loginValidation()"
			method="post">
			<h1>로그인</h1>
			<div class="form-group" style="margin: 0 0 30px;">
				<input type="email" name="id" placeholder="E-mail Address">
				<span class="input-icon"><i class="fa fa-envelope"></i></span>
			</div>
			<div class="form-group" style="margin: 0 0 30px;">
				<input type="password" name="pwd" placeholder="Password"> <span
					class="input-icon"><i class="fa fa-lock"></i></span>
			</div>
			<input type="submit" class="login-btn" value="로그인" id="loginBtn">
			<!--a 로그인시 실패 결과 메시지창 -->
			<div style="text-align: center">
				<span id=resultMsg style="color: red;"></span>
			</div>
			<div class="other">
				<a class="reset-psw" href="${cp}/login/searchPwd">비밀번호 찾기</a> <a
					class="reset-psw" href="${cp}/login/join">회원가입</a>
			</div>
		</form>
		<div class="seperator">
			<b>or</b>
		</div>
		<p>다른 방법으로 로그인</p>
		<!--a 카카오 로그인 아이콘 /  redirect 경로 수정 -->
		<div class="social-icon">
			<c:if test="${userId eq null}">
				<a href="${cp}/login/login">
					<img src="${cp}/resources/img/kakao_login_medium_narrow.png">
				</a>
			</c:if>
		</div>    
	</div>
</div>
<script type="text/javascript">
	//로그인 유효성 체크 
	function loginValidation() {
		//a id, pwd 
		var id = $("input[name='id']");
		var pwd = $("input[name='pwd']");
		let loginBtn = $('#loginBtn');
		console.log("아이디" + id.val() + " " + pwd.val());
		//a 조건 아이디 비었을때 
		if (id.val() === "" || id.val() === undefined) {
			alert("아이디를 입력하세요.");
			id.focus();
			return false;
			//a 조건 비밀번호 비었을때 
		} else if (pwd.val() === "" || pwd.val() === undefined) {
			alert("비밀번호를 입력하세요.");
			pwd.focus();
			return false;
			//a 조건 아이디 비밀번호 둘다 있을 경우 
		} else if ((id.val() !== "" && pwd.val() !== "")
				|| (id.val() !== undefined && pwd.val() !== undefined)) {
			return true;
			//a 기타 
		} else {
			return false;
		}
	}
	//a 로그인시 아이디 비밀번호 체크 한뒤 로그인 버튼 밑 span영역에 html에 결과 표시
	var msg = "${msg}";
	if (msg === 'fail') {
		$('#resultMsg').html('아이디와 비밀번호를 확인해주세요.');
	} else if (msg === 'secession') {
		$('#resultMsg').html('존재하지 않는 아이디입니다.');
	} else {
		$('#resultMsg').html('');
	}
</script>
