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
			<form action="${cp}/login/kakaoSignIn" method="post">
				<h1>추가 정보입력</h1>
				<!-- 히든으로 값 넘기기 닉네임 / 토큰 / 카카오유저고유아이디-->
				<input type="hidden" value="${access_Token}" name="access_Token">
				<input type="hidden" value="${kakaoUserInfo.nickname}" name="mb_nickname">
				<input type="hidden" value="${kakaoUserInfo.kakaoUser}" name="kakaoUserId">
				<!-- 이름 입력 -->
				<div class="form-group">
					<input type="text" name="mb_name" placeholder="이름 (한글만 입력, 2~5자 이내)"
						onblur="nameCheck()"> <span class="input-icon"><i
						class="fa fa-user-circle-o"></i></span>
				</div>
				<!-- 결과메세지 출력창 -->
				<div>
					<span id="nameMsg"
						style="font-size: 20px; color: red; padding-left: 20px;"></span>
				</div>
				<!-- 아이디(이메일형식) 입력 / 이메일 동의 안했을경우 둘다 입력 / 전체 동의시 이름만 입력-->
				<c:choose>
					<c:when test="${kakaoUserInfo.email == null || kakaoUserInfo.email == ''}">
						<div class="form-group">
							<input type="email" name="id" placeholder="이메일(이메일형식, 15~20자 이내)"
								onblur="idCheck()"> <span class="input-icon"><i
								class="fa fa-envelope"></i></span>
						</div>
						<!-- 결과메세지 출력창 -->
						<div>
							<span id="idMsg"
								style="font-size: 20px; color: red; padding-left: 20px;"></span>
						</div>
					</c:when>
					<c:otherwise>
						<input type="hidden" value="${kakaoUserInfo.email}" name="id">
					</c:otherwise>
				</c:choose>
				<input type="submit" class="login-btn" value="회원가입" name="join" onsubmit="return buttonUp()" 
				disabled="disabled">
			</form>
		</div>
	</div>
</div>
<script type="text/javascript">
	//가입 버튼 활성화 변수
	var nameBl = false;
	var idBl = false;
	//해당 이메일 값이 존재할때 입력영역이 생기지 않으므로 유효성 검사를 하지 않도록 Bl값을 true로 함
	var emailVal = '<c:out value="${kakaoInfo.email}"/>';
	if(emailVal != null || emailVal != '' || emailVal != undefined){
		idBl = true;
	} else {
		idBl = false;
	}

	//이름 유효성 검사
	function nameCheck() {
		let name = $("input[name='mb_name']").val();
		console.log(name);
		//메세지 출력위해 객체로 가져오기
		let nameMsg = $("#nameMsg");
		//한글만 가능한 정규식
		let regExp = /([^가-힣\x20])/i;
		//검사
		if (regExp.test(name)) {
			nameMsg.css("color", "red");
			nameMsg.html("한글이 아닙니다.[자음, 모음만 처리불가]");
			nameBl = false;
		} else if (name.length < 1) {
			nameMsg.css("color", "red");
			nameMsg.html("2글자 이상 입력하세요");
			nameBl = false;
		} else if (name.length > 5) {
			nameMsg.css("color", "red");
			nameMsg.html("5글자 이내로 입력하세요");
			nameBl = false;
		} else {
			nameMsg.html("");
			nameBl = true;
			buttonUp();
		}
	}
	//이메일 유효성 검사
	function idCheck() {
		var id = $("input[name='id']").val();
		let idMsg = $("#idMsg");
		let regExpId = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
		if (!regExpId.test(id)) {
			idMsg.css("color", "red");
			idMsg.html("이메일 형식으로 입력해주세요.");
			idBl = false;
		} else if (id.length < 15) {
			idMsg.css("color", "red");
			idMsg.html("15자리 이상 입력해주세요.");
			idBl = false;
		} else if (id.length > 20) {
			idMsg.css("color", "red");
			idMsg.html("20자리 이내로 입력해주세요.");
			idBl = false;
		} else {
			//아이디 존재여부를 ajax사용하여 
			$.getJSON("${cp}/CheckID/do2", {
				id : id
			}, function(data) {
				console.log(data.code);
				if (data.code == 'fail') {
					idMsg.css("color", "red");
					idMsg.html("해당 아이디는 이미 존재합니다.");
					idBl = false;
				} else {
					idMsg.css("color", "green");
					idMsg.html("사용가능한 아이디입니다.");
					idBl = true;
					buttonUp();
				}
			});
		}
	}
	
	// 버튼 활성화 함수 -> submit, 클릭 
	function buttonUp() {
		let btn = $("input[name='join']");
		let btnColor = $(".login-form .login-btn");
		if (nameBl && idBl) {
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
