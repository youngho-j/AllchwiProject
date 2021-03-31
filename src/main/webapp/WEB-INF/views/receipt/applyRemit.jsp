<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript" src="${cp }/resources/js/jquery-3.5.1.js"></script>

<link rel="stylesheet"
	href="${cp}/resources/css/classEnrollment/classEnrollment.css">
<script
	src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=472c28df1aaa1946fb26fe353232eace&libraries=services"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<link id="cp" data-contextPath="${cp}" />

<div class="classOpen">
	<div class="title_box">
		<h3>송금정보 입력</h3>
	</div>

	<form method="post" id="frm-class" action="${cp }/receipt/insert"
		onsubmit="return validate();">
		<!-- 선택된 페이지 출력 -->
		<div class="tab-content" id="pills-tabContent">
			<!-- 01튜터 기본정보 입력 페이지 -->
			<div class="tab-pane fade show active" id="pills-info"
				role="tabpanel">
				<div class="info1">
					<span class="pink">*</span>필수
				</div>

				<div class="box">
					<div class="title">은행<b class="pink">*</b>
					</div>
					<div class="input-group col-5">
						<input type="text" class="form-control" name="rem_bank" id="rem_bank"
							placeholder="은행명을 입력해주세요.">
					</div>
				</div>

				<div class="box">
					<div class="title">
						계좌번호<b class="pink">*</b>
					</div>
					<div class="cont input-group col-5">
						<input type="text" name="rem_account" id="rem_account" class="form-control"
							placeholder=" - 포함하여 입력해주세요.">
					</div>
				</div>

				<div class="box">
					<div class="title">
						신청금액<b class="pink">*</b>
					</div>
					<div class="cont input-group col-5">
						<input type="text" name="rem_pay" class="form-control"
							readonly="readonly" value="${final_price}">원

					</div>
				</div>

				<input type="hidden" name="pay_num" value="${pay_num }">
				<input type="hidden" name="rem_revenue" value="${class_fee }">

				
				<div class="button_box">
					<button type="submit" id="firstNext" class="btn btn-outline-danger"
						data-num='2'>올취 송금요청</button>
				</div>
			
			
			</div>
		</div>
	</form>
</div>


<script>
	function validate() {
		var rem_bank = document.getElementById("rem_bank");
		var rem_account = document.getElementById("rem_account");
		

		//정규식
		var idCheck = /^[A-Za-z0-9_\-]{4,10}$/;
		var emailRule = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
		var nickNameCheck = /^[가-힣a-zA-Z]{2,12}$/;
		var pwCheck = /^[a-zA-Z0-9]{6,12}$/;
		var emailCheck = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;
		var phoneCheck = /^01[0179][0-9]{7,8}$/;

		if (rem_bank.value == "") {
			alert("은행을 입력해주세요.");
			return false;
		}
		
		if (rem_account.value == "") {
			alert("계좌번호를 입력해주세요.");
			return false;
		}
		
		alert("금액이 일주일이내로 입급됩니다.");	
		return true;
	}
</script>