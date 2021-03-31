<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript" src="${cp}/resources/js/jquery-3.5.1.js"></script>
<!-- 1아이콘 폰트 사용 -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="${cp }/resources/css/login/loginForm.css">

<div class="container">
	<div id=loginbody>
		<div class="login-form">
		<!-- 메일보내는 링크로  -->
			<form action="${cp}/login/searchPwd" method="post">
				<h1>비밀번호 찾기</h1>
				<!-- 아이디(이메일형식) 입력-->
				<div class="form-group">
					<input type="email" name="id" placeholder="회원가입한 아이디를 입력해주세요"
						onblur="idCheck()"> <span class="input-icon"><i
						class="fa fa-user-circle-o"></i></span>
				</div>
				<!-- 결과메세지 출력창 -->
				<div>
					<span id="idMsg"
						style="font-size: 20px; color: red; padding-left: 20px;"></span>
				</div>
				<!-- 메일받을 계정 입력-->
				<div class="form-group">
					<input type="email" name="sendEmail" placeholder="메일을 받을 이메일주소를 입력해주세요"
						onblur="emailCheck()" disabled="disabled"><span class="input-icon"><i
						class="fa fa-envelope"></i></span>
				</div>
				<!-- 결과메세지 출력창 -->
				<div>
					<span id="emailMsg"
						style="font-size: 20px; color: red; padding-left: 20px;"></span>
				</div>
				<input type="submit" class="login-btn" value="인증 메일보내기" name="send" onsubmit="return buttonUp()" disabled="disabled">
			</form>
		</div>
	</div>
</div>
<script type="text/javascript">
var idBl = false;
var emailBl = false;
var checkCount = 0;
//이메일 유효성 검사
function idCheck() {
	// 횟수 -> 5번 틀리면 더이상 할 수 없게 
	var id = $("input[name='id']").val();
	let idMsg = $("#idMsg");
	let regExpId = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
	var email = $("input[name='sendEmail']");
	//나중에 세션에 담아서 찾기를 못하도록 해야함, 횟수제한 
	if(checkCount > 4){
		$("input[name='id']").attr('disabled', true);
	}
	if (!regExpId.test(id)) {
		idMsg.html("이메일 형식으로 입력해주세요.");
		email.attr('disabled', true);
		idBl = false;
	} else if (id.length < 15) {
		idMsg.html("15자리 이상 입력해주세요.");
		email.attr('disabled', true);
		idBl = false;
	} else if (id.length > 20) {
		idMsg.html("20자리 이내로 입력해주세요.");
		email.attr('disabled', true);
		idBl = false;
	} else {
		//아이디 존재여부를 ajax사용하여 
		$.getJSON("${cp}/CheckID/do", {
			id : id
		}, function(data) {
			console.log(data.code);
			if (data.code == 'fail') {
				idMsg.css("color", "green");
				idMsg.html("아이디 확인 완료!");
				email.removeAttr('disabled');
				idBl = true;
				buttonUp();
			} else {
				idMsg.css("color", "red");
				idMsg.html("존재하지 않는 아이디입니다.");
				email.attr('disabled', true);
				checkCount += 1;
				idBl = false;
			}
		});
	}
}
function emailCheck(){
	var email = $("input[name='sendEmail']").val();
	let emailMsg = $("#emailMsg");
	let regExpEmail = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
	if ((!regExpEmail.test(email)) || (email.trim() == "")) {
		emailMsg.html("이메일 형식으로 입력해주세요.");
		emailBl = false;
	} else {
		emailBl = true;
		buttonUp();
	}
}
//버튼 활성화 함수 -> submit, 클릭 
function buttonUp() {
	let btn = $("input[name='send']");
	let btnColor = $(".login-form .login-btn");
	if (idBl && emailBl) {
		console.log("트루");
		btn.removeAttr('disabled');
		btnColor.css('background-color','#45aba6');			
		btnColor.css('border','1px solid #45aba6');			
		return true;
	} else {
		console.log("아님..");
		btn.attr('disabled', true);
		btnColor.css('background-color','gray');			
		btnColor.css('border','1px solid gray');			
		return false;
	}
}
</script>