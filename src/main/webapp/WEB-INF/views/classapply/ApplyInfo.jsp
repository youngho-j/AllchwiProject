<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<link rel="stylesheet"
	href="${cp}/resources/css/classMyboard/classMyboard.css">
<style>
@charset "UTF-8";
.title-box {
    position: relative;
    padding-top: 60px;
    border-bottom: none; 
    margin-bottom: 40px;
    overflow: hidden;
}

.tutor_cont {
	width: 1040px;
	margin: 0 auto;
	padding-bottom: 100px;
	margin-bottom: 50%;

}

.tutor_cont .pf_box {
	width: 300px;
	float: left;
	border: 1px solid #ddd;
	padding: 31px;
}

.tutor_cont .gray {
	background-color: #f1f1f1;
	font-size: 0.9rem;
}

.triangle-border {
	position: relative;
	margin: 1em 0 3em;
	padding: 20px;
	border-radius: 10px;
	line-height: 1.43;
	background-color: #f2f2f2;
}

.tutor_cont .pf_box .pf {
	width: 110px;
	height: 110px;
	border-radius: 50%;
	margin: 0 auto;
	background-size: cover;
	background-position: center;
}

.triangle-border.top:after {
	content: '';
	display: block;
	position: absolute;
	top: -13px;
	bottom: auto;
	left: 0;
	right: 0;
	width: 0;
	margin: 0 auto;
	border-style: solid;
	border-width: 0 13px 13px;
	border-color: #f2f2f2 transparent;
}

.tutor_cont .sh_box {
    width: 700px;
    float: right;
    border-top: 1px solid #d8d9db;
    padding-top: 30px;
}

.appcont .height4 {
	height: 100px;
}

.appcont .payend .center3 {
	width: 100%;
	font-weight: 600;
	font-size: 20px;
	margin-top: 20px;
	text-align: center;
	color: #ff005b;
}

.apply-img {
	max-width: 60px;
	max-height: 60px;
	vertical-align: top;
}

.appcont .payend .center5 {
	width: 100%;
	font-weight: 600;
	font-size: 20px;
	text-align: center;
	color: #7185bb;
}

.appcont .payend .center4 {
	width: 100%;
	font-weight: 600;
	font-size: 13px;
	text-align: center;
	margin-top: 10px;
}

.appcont .payend .left {
	float: left;
	font-weight: 600;
	font-size: 16px;
	line-height: 20px;
	padding-left: 220px;
}

.appcont .payend .right {
	float: left;
	width: 300px;
	font-weight: 600;
	font-size: 16px;
	padding-left: 40px;
	color: #ff936f;
}

.nickname {
	width: 200px;
	height: 50px;
	font-weight: bold;
	font-size: 26px;
}

.date {
	color: #888;
	font-size: 16px;
	letter-spacing: -0.35px;
	line-height: 2.3;
}

.class_title {
	padding: 20px;
}
.h4, h4 {
    font-size: 1.4rem;
}
</style>
<div class="container">
	<div class="tutor_cont">
		<div class="title-box">
			<h1>수업 신청 정보</h1>

		</div>
		<c:forEach var="vo" items="${list}">
		
			<div class="date">
				*수업 신청서 제출일 :
				<fmt:formatDate value="${vo.apply_regdate}" pattern="yyyy-MM-dd" />
			</div>
			<div class="apply">
				<div class="pf_box">
					<div class="pf"
						style="background-image: url('${cp}/mypageImg/getimg?pro_num=${vo.pro_num}')"></div>
					<c:choose>
						<c:when test="${vo.apply_auth==0 }">
							<p class="triangle-border top gray" style="margin-top: 50px">
								결제 후 " ${vo.tutor_nickname } "님이 수업 신청서를 확인 할 때까지 잠시만 기다려주세요. <br>
								신청서 확인이 완료되면 회원님께 직접 연락을 드립니다!
							</p>
						</c:when>
						<c:otherwise>
							<p class="triangle-border top gray" style="margin-top: 50px">
								${vo.tutor_nickname } : 신청해 주셔서 정말 감사합니다. <br> <br>
								승인이 완료되었습니다! <br> 수업 시작일에 만나요!
							</p>
						</c:otherwise>
					</c:choose>

				</div>
				<div class="sh_box class_price">
					<div class="appcont">

						<c:choose>
							<c:when test="${vo.apply_auth==0 }">
								<div class="payend height4">
									<div class="center3">
										<img class="apply-img" src="${cp}/resources/img/apply-2.png">
									</div>
								</div>

								<div class="payend">
									<div class="center5">
										<h4 onclick="location.href='${cp}/class/classDetail/class_num=${vo.class_num }'"
											style="cursor: pointer">${vo.class_title }</h4>
										수업 신청 승인 대기중입니다.
									</div>
								</div>
								<div class="payend">					
									<div class="center4">								
									신청일로부터 10일 내에 신청승인이 완료됩니다!</div>
								</div>
							</c:when>
							<c:otherwise>
								<div class="payend height4">
									<div class="center3">
										<img class="apply-img" src="${cp}/resources/img/apply.png">
									</div>
								</div>

								<div class="payend">
									<div class="center5">
										<h4 onclick="location.href='${cp}/class/classDetail/class_num=${vo.class_num }'"
										style="cursor: pointer">${vo.class_title }</h4>
										수업 신청 승인이 완료되었습니다.
									</div>
								</div>
								<div class="payend">
									<div class="center4">상세페이지에서 자세한 일정을 확인해주세요!</div>
								</div>
							</c:otherwise>
						</c:choose>



						<br> <br> <br>
						<div class="payend">
							<div class="left">수업시작일</div>
							<div class="right">
								<fmt:formatDate value="${vo.class_date}" pattern="yyyy-MM-dd" />
							</div>
						</div>
						<div class="payend">
							<div class="left">튜터 연락처</div>
							<div class="right" id="expireDate">${vo.tutor_phone}</div>
						</div>

					</div>
				</div>
			</div>
		</c:forEach>
	</div>



</div>