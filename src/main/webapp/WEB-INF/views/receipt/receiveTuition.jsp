<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<style>
.container {
	margin: 0 auto;
}

.container .title-box {
	position: relative;
	padding-top: 60px;
	border-bottom: 1px solid #e4e4e4;
	margin-bottom: 40px;
	overflow: hidden;
}

.container .title-box h1 {
	float: left;
	font-size: 26px;
	color: #333;
	line-height: 1.85;
	padding-bottom: 10px;
}

.container .title-box ul {
	display: flex;
	position: absolute;
	margin-top: 15px;
	right: 0;
	overflow: visible;
}

.container .title-box ul li.on {
	color: #333;
	border-bottom: 2px solid #333;
	font-weight: 500;
}

.container .title-box ul li {
	cursor: pointer;
	font-size: 16px;
	color: #555;
	letter-spacing: -0.4px;
	margin: 0 30px;
	box-sizing: border-box;
	text-align: center;
	padding-bottom: 20px;
}

li {
	list-style: none;
}

.container .class-box {
	border-bottom: 1px solid #cccfd3;
	margin-bottom: 30px;
}

.container .class-box .class-info {
	padding-bottom: 30px;
	display: flex;
}

a, span {
	color: inherit;
	font-size: inherit;
	font-weight: inherit;
	line-height: inherit;
	text-decoration: none;
}

.container .class-box .class-info .image {
	width: 320px;
	height: 180px;
	background-size: cover;
	background-position: center;
}

.container .class-box .class-info .information-box {
	width: 690px;
	padding-top: 10px;
	margin-left: 30px;
}

.container .class-box .class-info .information-box p {
	font-size: 14px;
	color: #888;
	letter-spacing: -0.35px;
}

.container .class-box .class-info .information-box h3 {
	color: #333;
	font-size: 20px;
	letter-spacing: -0.5px;
	font-weight: 500;
	line-height: 2;
	height: 40px;
	overflow: hidden;
	cursor: pointer;
}

.container .class-box .stars-box .class-type {
	color: #888;
	letter-spacing: -0.35px;
	font-size: 14px;
}

.container .class-box .stars-box .class-stars img {
	width: 15px;
	margin-left: -2px;
	margin-bottom: 3px;
	vertical-align: middle;
}

img {
	max-width: 100%;
	max-height: 100%;
	vertical-align: top;
}

.container .class-box .stars-box span {
	font-size: 14px;
	color: #888;
	letter-spacing: -0.35px;
}

.container .class-box .class-info .information-box .start-date {
	margin-top: 10px;
	color: #888;
	font-size: 14px;
	letter-spacing: -0.35px;
}

.container .class-box .class-info .information-box .review-fold.on {
	color: #ff005a;
}

.container .class-box .class-info .information-box .review-fold {
	font-size: 14px;
	color: #888;
	letter-spacing: -0.35px;
	line-height: 2.36;
	margin-top: 10px;
}

.container .cursor {
	cursor: pointer;
}

.container .class-box .class-info .information-box .review-fold .arrw-box
	{
	overflow: hidden;
	display: inline-block;
}

.container .class-box .class-info .information-box .review-fold .arrw {
	margin-top: -13px;
	margin-left: 5px;
	position: absolute;
	width: 16px;
}

.container .class-box .class-info .information-box .review-fold .arrw.up
	{
	display: none;
}

.container .class-box .class-info .information-box .price {
	font-size: 24px;
	letter-spacing: -0.6px;
	color: #ff005a;
	font-weight: 500;
	text-align: right;
	margin-top: -61px;
}

.container .class-box .class-info .information-box .price font {
	font-size: 14px;
}

.container .class-box .review-info.textarea {
	padding: 0;
	height: initial;
}

.container .class-box .review-info {
	border: 1px solid #cccfd3;
	padding: 30px;
	box-sizing: border-box;
	display: none;
	margin-bottom: 30px;
}

.container .class-box .review-info.textarea>div {
	overflow: hidden;
}

.container .class-box .review-info textarea {
	width: 100%;
	height: 110px;
	border: none;
	color: #333;
	font-size: 14px;
	line-height: 1.57;
	padding: 20px;
	background: #fff;
	box-sizing: border-box;
	resize: none;
}

button, input, optgroup, select, textarea {
	margin: 0;
	font: inherit;
	color: inherit;
}

.container .class-box .review-info.textarea .stars-box {
	height: 41px;
	border-top: 1px solid #cccfd3;
}

.container .class-box .review-info.textarea>div {
	overflow: hidden;
}

.container .class-box .review-info.textarea .stars {
	padding: 10px;
	display: inline-block;
	color: #888;
}

.container .class-box .review-info .glyphicon.glyphicon-star.active {
	color: #ffc600;
}

.glyphicon {
	position: relative;
	top: 1px;
	display: inline-block;
	font-family: 'Glyphicons Halflings';
	font-style: normal;
	font-weight: 400;
	line-height: 1;
	-webkit-font-smoothing: antialiased;
	-moz-osx-font-smoothing: grayscale;
}

.container .class-box .review-info.textarea .stars font {
	color: #888;
	font-size: 14px;
	line-height: 1.57;
	margin-left: 5px;
}

.container .class-box .review-info.textarea .regi-button {
	border-left: 1px solid #cccfd3;
	padding: 9px;
	width: 68px;
	box-sizing: border-box;
	text-align: center;
	font-size: 14px;
	color: #555;
	float: right;
}
</style>

<div class="container">
	<!--MyTItleBox head-->
	<div class="title-box">
		<h1>튜터 수업료 정산</h1>
	</div>
	<div class="my-class-list">
		<c:choose>
			<c:when test="${list.size()>0 }">
				<c:forEach var="vo" items="${list}">
					<div class="class-box">
						<div class="class-info">
							<div class="image" style="text-align: center;">
								<img src="${cp}/mypageImg/getimg?pro_num=${vo.pro_num }"
									style="width: 150px; height: 180px;">
							</div>

							<div class="information-box">
								<h3
									style="overflow: hidden; text-overflow: ellipsis; white-space: nowrap;">${vo.class_title }</h3>
								<div class="stars-box">
									<c:choose>
										<c:when test="${vo.class_form == 0 }">
											<font class="class-type">오프라인 수업</font>&nbsp;|&nbsp; &nbsp;
								</c:when>
										<c:otherwise>
											<font class="class-type">온라인 수업</font>&nbsp;|&nbsp; &nbsp;
								</c:otherwise>
									</c:choose>

									<span> ${vo.mb_nickname }(${vo.id })</span>
								</div>
								<div class="start-date">
									<font>결제날짜 : <fmt:formatDate value="${vo.pay_regdate }"
											pattern="yy-MM-dd hh:mm:ss" /> &nbsp;&nbsp;
									</font>
								</div>

								<div class="price">
									<font>￦</font><fmt:formatNumber value="${vo.final_price}" pattern="#,###" /></div>
										
								<button type="button" class="btn btn-primary"
									onclick="receive('${vo.pay_num}','${vo.final_price }','${vo.class_fee}')"
									style="margin-left: 600px; width: 111px;">수업료 받기</button>
							</div>
						</div>
					</div>
				</c:forEach>
			</c:when>
			<c:otherwise>

				<h4 style="text-align: center;"> 받을 수업료가 없습니다.</h4>
			</c:otherwise>


		</c:choose>

		<div>
			<ul class="pagination justify-content-center" style="margin: 20px 0">
				<c:choose>
					<c:when test="${pu.startPageNum>1 }">
						<li class="page-item"><a class="page-link"
							href="${cp }/receipt/main?pageNum=${pu.startPageNum-1 }&field=${field}&keyword=${keyword}">이전</a></li>
					</c:when>
					<c:otherwise>
						<li class="page-item disabled"><a class="page-link" href="#">이전</a></li>
					</c:otherwise>
				</c:choose>

				<c:forEach var="i" begin="${pu.startPageNum}"
					end="${pu.endPageNum }">
					<c:choose>
						<c:when test="${pu.pageNum==i}">
							<li class="page-item active"><a class="page-link"
								href="${cp }/receipt/main?pageNum=${i }&field=${field}&keyword=${keyword}">${i }</a></li>
						</c:when>
						<c:otherwise>
							<li class="page-item"><a class="page-link"
								href="${cp }/receipt/main?pageNum=${i }&field=${field}&keyword=${keyword}">${i }</a></li>
						</c:otherwise>
					</c:choose>
				</c:forEach>


				<c:choose>
					<c:when test="${pu.totalPageCount>pu.endPageNum }">
						<li class="page-item"><a class="page-link"
							href="${cp }/receipt/main?pageNum=${pu.endPageNum+1 }&field=${field}&keyword=${keyword}">다음</a></li>
					</c:when>
					<c:otherwise>
						<li class="page-item disabled"><a class="page-link" href="#">다음</a></li>
					</c:otherwise>
				</c:choose>
			</ul>
		</div>

		<div style="padding-top: 100px"></div>
	</div>
</div>



<script type="text/javascript">
	//post 방식으로 보내기
	function receive(pay_num, final_price, class_fee) {		
		var form = document.createElement("form");
		form.setAttribute("charset", "utf-8");
		form.setAttribute("method", "post");
		form.setAttribute("action", "${cp}/receipt/apply");

		//파라미터 값이 null이 아닌 경우, hidden input을 생성하여 값을 넣음.
		var hiddenPayNum = document.createElement("input");
		hiddenPayNum.setAttribute("type", "hidden");
		hiddenPayNum.setAttribute("name", "pay_num");
		hiddenPayNum.setAttribute("value", pay_num);

		var hiddenFinalPrice = document.createElement("input");
		hiddenFinalPrice.setAttribute("type", "hidden");
		hiddenFinalPrice.setAttribute("name", "final_price");
		hiddenFinalPrice.setAttribute("value", final_price);

		var hiddenClassFee = document.createElement("input");
		hiddenClassFee.setAttribute("type", "hidden");
		hiddenClassFee.setAttribute("name", "class_fee");
		hiddenClassFee.setAttribute("value", class_fee);

		//폼에 hidden input 추가 
		form.appendChild(hiddenPayNum);
		form.appendChild(hiddenFinalPrice);
		form.appendChild(hiddenClassFee);

		//body부분에 폼을 붙이고 페이지 이동
		document.body.appendChild(form);
		form.submit();
	}
</script>
