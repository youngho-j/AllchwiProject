<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<style>
@font-face {
	font-family: 'CookieRunOTF-Bold';
	src:
		url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_twelve@1.0/CookieRunOTF-Bold00.woff')
		format('woff');
	font-weight: normal;
	font-style: normal;
}

.classApply {
	margin: auto;
	width: 80%;
}

.title_box h3 {
	float: left;
	display: inline-block;
}

.title_box .steps {
	float: right;
	display: flex;
}

.tab-content {
	display: block;
}

.title_box {
	overflow: hidden;
	margin-top: 30px;
	padding: 19px 0;
	border-bottom: 1px solid #c9c9c9;
}

.box {
	width: 100%;
	display: flex;
	padding: 30px 0;
	border-bottom: 1px solid #d8d9db;
}

.title {
	width: 40%;
	text-align: center;
	color: #333;
	font-weight: 500;
	font-size: 16px;
	padding: 14px 14px 14px 70px;
	font-weight: bold;
	text-align: center;
}

.cont {
	width: 70%;
	box-sizing: border-box;
}

.info1 {
	margin-top: 10px;
	padding: 20px 0;
	text-align: left;
	font-size: 24px;
	color: #555;
	border-bottom: 1px solid #d8d9db;
	letter-spacing: -0.35px;
}

.orange {
	color: #ff936f;
	font-weight: 900;
	font-family: 'CookieRunOTF-Bold';

}

.box .pf {
	width: 90px;
	height: 90px;
	border-radius: 50%;
	margin-top: 20px;
	float: left;
	margin-right: 20px;
}

.box .upf {
	width: 130px;
	height: 130px;
	border-radius: 50%;
	background-position: center;
	background-size: cover;
}

.button_box {
	/* display: flex; */
	width: 480px;
	margin: 3% 0% 3% 44%;
}

.button_box2 {
	width: 200px;
}

div {
	margin: 0;
	padding: 0;
	color: #111;
	font-family: 'Noto Sans KR', sans-serif;
	font-weight: 400;
}

.form-control:disabled, .form-control[readonly] {
	background-color: #ffffff;
	opacity: 1;
}

.col-3 {
	padding: 10%;
}

.tutor_txt dt {
	width: 80px;
	height: 80px;
	background: none;
	padding: 0;
	border-radius: 100px;
	overflow: hidden;
}

.tutor_txt dd {
	width: 300px;
	left: 100px;
	top: -80px;
	border-radius: 5px;
	padding: 10px;
	position: relative;
	background: lightgray;
	color: #666;
	letter-spacing: 0;
}

.tutor_txt dd:after {
	right: 100%;
	top: 50%;
	border: solid transparent;
	content: " ";
	position: absolute;
	border-right-color: lightgray;
	border-width: 10px;
	margin-top: -10px;
}

.col-md-2 {
	text-align: center;
	margin: 0 auto;
	align-items: center;
	
}

.form-inline .btn-group-toggle {
	display: flex;
	margin: 10px;
}

.btn-secondary:not (:disabled ):not (.disabled ).active, .btn-secondary:not
	 (:disabled ):not (.disabled ):active, .show>.btn-secondary.dropdown-toggle
	{
	color: #fff;
	background-color: #ff936f;
	border-color: #ff936f;
}

.label-1, .label-12, .label-1-content {
	padding-top: 15px;
	padding-bottom: 15px;
	width: 150px;
	font-size: 16px;
	color: #333;
	letter-spacing: -0.4px;
	font-weight: bold;
}

.label-12 {
	margin-top: 158px;
}

.label-1, .label-12 {
	text-align: center;
	display: inline-flex;
	float: left;
}

.box .inner1 {
	margin-top: 30px;
}

textarea.len980 {
	height: 190px;
	background: #fff;
}

.form-control, .custom-select, textarea.basic {
	font-size: 14px;
	border-radius: 4px;
	border: 1px solid #ddd;
	box-sizing: border-box;
}

.input-group .form-control {
	height: 38px;
}

.input-group-prepend {
	height: 38px;
}

.nav-pills .nav-link.active, .nav-pills .show>.nav-link {
	font-weight: bold;
	color: #fff;
	background-color: #7185bb;
}
.tutor_img{
	background: white; 
	z-index: 0; 
	width: 100%; 
	height: 100%; 
	background-size: cover; 
	background-position: center; 

}
.class {
    color: #888;
    font-size: 16px;
    margin: 0;
    padding: 10px 0;
    cursor: pointer;
}
 .class .intext {
    width: 450px;
    display: inline-block;
    font-size: 16px;
}
.class .intext .dwn {
    display: block;
}
.class .intext img {
    float: right;
    margin-right: 30px;
    margin-top: 6px;
}
img {
    max-width: 100%;
    max-height: 100%;

}
.class .intext .up {
    display: none;
}
.class.on .intext .up {
    display: block;
}
.class .subtext {
    width: 100%;
    font-size: 14px;
    display: none;
}
.class .subtext .ch {
    font-size: 15px;
    line-height: 1.4;
}
.class .subtext .ch font {
    color: #000;
    font-weight: 300;
    margin-right: 5px;
}
.class.on .intext .dwn {
    display: none;
}
.class .intext .up {
    display: none;
}
.class.on .intext .up {
    display: block;
}
</style>
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
<script>
	window.onload=function(){
		if("${code}" == 'tutor'){
			alert("?????? ????????? ????????? ????????? ????????? ?????????!");
			history.back();
		}
	}
</script>

<div class="classApply">

	<div class="title_box">
		<h3>????????? ?????????</h3>
		<div class="steps">
			<ul class="nav nav-pills mb-3" id="pills-tab" role="tablist">
				<li class="nav-item" role="presentation">
					<a class="nav-link active" id="pills-home-tab" data-toggle="pill" href="#pills-info" 
					role="tab" aria-selected="true" style="pointer-events: none; ">01????????? ??????</a></li>
				<li class="nav-item" role="presentation">
					<a class="nav-link" id="pills-profile-tab" data-toggle="pill" href="#pills-title"
					role="tab" aria-selected="false" style="pointer-events: none; ">02???????????????</a></li>
				<li class="nav-item" role="presentation">
					<a class="nav-link"	id="pills-contact-tab" data-toggle="pill" href="#pills-price"
					role="tab" aria-selected="false" style="pointer-events: none; ">03??????</a></li>
			</ul>
		</div>
	</div>
	<form method="post" id="applyForm">
		<input type="hidden" name="ml_num" value="${ml_num }">
		<input type="hidden" name="class_num" value="${class_num }">
		<div class="tab-content" id="pills-tabContent">
			<!-- 01 ????????? ?????? ?????? ???-->
			<div class="tab-pane fade show active" id="pills-info" role="tabpanel"
				data-num="1">
			
			<c:forEach var="vo" items="${classDate_list }" begin="0" end="0">
			
				<div class="info1">
					<span class="orange">${vo.class_title }</span>
				</div>
			</c:forEach>
					
				<div class="box">
				<c:forEach var="vo" items="${classDate_list }" begin="0" end="0">
					<div class="col-md-6">
						<div class="title">
							??????????????????<b class="pink">*</b>
							<div class="col-3">
								<div class="tutor_t">
									<dl class="tutor_txt">
										<dt>
											<div class="tutor_img" style="background-image: url('${cp}/mypageImg/getimg?pro_num=${pro_num}');">
											</div>
										</dt>
										<dd>										
											?????? ????????? ???????????????!
											<br>
											????????? ????????? ?????????????????? :)
										</dd>
									</dl>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>
					<!--  ?????? ?????? ?????? ????????? ??????   -->
					<div class="col-md-6">
						<c:forEach var="date" items="${classDate_list}">
						
							<div id="certifi" class="certificate class" onclick="fold(this)">
								<div class="intext">
									<c:choose>
										<c:when test="${class_form=='0'}">
										<input type="radio" aria-label="Radio button for following text input" name="date_num" value="${date.date_num }" checked>
											<fmt:formatDate value="${date.class_date}" pattern="yyyy-MM-dd"/>&ensp;&ensp; ${date.class_startTime } ~ ${date.class_endTime }
											<img src="${cp}/resources/img/icon_down.png" class="dwn"> 
											<img src="${cp}/resources/img/icon_up.png" class="up">
										</c:when>
										<c:otherwise>
										<input type="radio" aria-label="Radio button for following text input" name="date_num" value="${date.date_num }" checked>
											<fmt:formatDate value="${date.class_date}" pattern="yyyy-MM-dd"/>&ensp;&ensp; ( ${date.class_month }??????	)									
										</c:otherwise>
									</c:choose>
								</div>
							
								<div class="subtext">
								<c:forEach var="vo" items="${date.list}">
									<div class="ch">
										<font>${vo.time_cnt}???</font> : 
										<fmt:formatDate value="${vo.class_date}" pattern="yyyy-MM-dd"/> ${vo.class_startTime } ~ ${vo.class_endTime }
									</div>
								</c:forEach>
								</div>
							</div>
							
						</c:forEach>
					</div>
	
				</div>
			
				
	
	
				<div class="button_box">
					<button type="button" class="btn btn-outline-danger" id="wirteBtn"
						data-num='2'>?????? ????????? ????????????</button>
				</div>
	
	
			</div>
	
			<!-- 02 ??????????????? ?????? ??? -->
			<div class="tab-pane fade" id="pills-title" role="tabpanel"
				data-num='2'>
			<c:forEach var="vo" items="${classDate_list }"  begin="0" end="0">
				<div class="info1">
					<span class="orange">${vo.class_title }</span>
				</div>
			</c:forEach>
				<div class="box">
					<div class="col-md-6">
						<div class="title">
							???????????????<b class="pink">*</b>
							<div class="col-3">
								<div class="tutor_t">
									<dl class="tutor_txt">
										<dt>
											<div class="tutor_img" style="background-image: url('${cp}/mypageImg/getimg?pro_num=${pro_num}');">
											</div>
										</dt>
										<dd>
											??????????????? ?????? <br> ?????????????????? ?????? ?????? ??????????????????.<br> ??????????????? :)
										</dd>
									</dl>
								</div>
							</div>
						</div>
					</div>
					<div class="col-md-2">
						<div class="label-1">?????? ?????? ??????</div>
						<div class="label-1">???????????? ?????????</div>
						<div class="label-12">?????? ????????? ??????</div>
					</div>
	
					<div class="col-md-4">
	
						<div class="btn-group btn-group-toggle" data-toggle="buttons">
							<label class="btn btn-secondary active"> 
							<input type="radio" name="stu_lev" value="1" checked> ?????????
							</label> <label class="btn btn-secondary"> 
							<input type="radio" name="stu_lev" value="2"> ???/?????????
							</label> <label class="btn btn-secondary"> 
							<input type="radio"	name="stu_lev" value="3"> ?????????
							</label>
						</div>
						<br>
	
	
						<div class="cont">
							<div class="inner1">
								<textarea class="basic len980 form-control"
									placeholder="???????????? ???????????? ?????? ???????????????. ????????? ?????? ????????? ???????????????? ????????? ?????? ?????? ????????? ?????? ???????????????????"
									id="Introduction" name="stu_msg"></textarea>
							</div>
						</div>
	
						<input type="text" id="phone" name="stu_phone" class="form-control"
							style="width: 250px; margin-top: 20px;"
							placeholder="?????????????????? - ?????? ??????????????????.">
	
					</div>
	
				</div>
				<div class="button_box">
					<button type="button" class="btn btn-outline-danger" id="payBtn">????????????</button>
				</div>
	
			</div>
	
			<!-- 03 ?????? ???  -->
			<div class="tab-pane fade" id="pills-price" role="tabpanel"
				data-num='3'>
				<c:forEach var="vo" items="${classDate_list }"  begin="0" end="0">
					<div class="info1">
						<span class="orange">${vo.class_title }</span>
					</div>
				
					<div class="box">
						<div class="col-md-6">
							<div class="title">
								????????????<b class="pink">*</b>
								<div class="col-3">
									<div class="tutor_t">
										<dl class="tutor_txt">
											<dt>
												<div class="tutor_img" style="background-image: url('${cp}/mypageImg/getimg?pro_num=${pro_num}');">
												</div>
											</dt>
											<dd>
												?????? ?????? ????????? ???????????????.<br> ????????? ?????? ????????? ??? ?????????<br> ?????????????????? :)
											</dd>
										</dl>
									</div>
								</div>
							</div>
						</div>
						<div class="col-md-2">
							<div class="label-1">???????????????</div>
							<div class="label-1">???????????????</div>
							<div class="label-1">????????????</div>
							<div class="label-1">????????????</div>
							<div class="label-1">????????????</div>
						</div>
		
						<div class="col-md-4">
		
							<div class="label-1-content">
								${vo.class_price*vo.class_hour*vo.class_count }
								<input type="hidden" name ="class_fee" id="class_fee" value="${vo.class_price*vo.class_hour*vo.class_count }">
							</div>
							<div class="label-1-content">${point } ?????????
								<input type="hidden" id="ppoint" value="${point }">
							</div>
							<div class="label-1-content">
								<input type="text" id="point" name="pay_point" style="width: 88px" value="0">
								?????????
							</div>
							<div class="label-1-content" style="width: 200px" id="pointDiv">
								<span style="color: red">${vo.class_price*vo.class_hour*vo.class_count }</span>
								<input type="hidden" name="final_price" value="${vo.class_price*vo.class_hour*vo.class_count }"/>
							</div>
							<div class="label-1-content">
								<div class="button_box2">
									<input type="hidden" name="pay_way" value="card">
									<button type="button" class="btn btn-outline-danger" id="cardPay">????????????/????????????</button>
								</div>
		
							</div>
		
		
		
		
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</form>
</div>
<script>
	// [??????????????? ???????????? ] ?????? ?????? ???, ?????? ????????? ??????
	$("#wirteBtn").click(function() {
		$('#pills-tab li:nth-child(2) a').tab('show');
	});
	// [????????????] ?????? ?????? ???, ??????  ????????? ??????
	$("#payBtn").click(function() {
		if($("#Introduction").val().length!=0 && $("#phone").val().length!=0){
			$('#pills-tab li:nth-child(3) a').tab('show');
		}else if($("#Introduction").val().length==0){
			alert("???????????? ????????? ?????? ?????? ??????????????????!");
			$("#Introduction").focus();
		}else if($("#phone").val().length==0){
			alert("????????? ????????? ??????????????????! ");
			$("#phone").focus();
		}
		
	});
	//????????? 
	$("#point").on("change", function() {
		
		$("#pointDiv").empty();
	    var usePoint =parseInt( $(this).val());
	    var classPay= $("#class_fee").val();
	    var ppoint= $("#ppoint").val();

	    if(usePoint>ppoint){
	    	alert("???????????? ??????????????? ?????? ????????? ?????? ???????????????!");
	    	$("#pointDiv").focus();
	    }else if(usePoint==null && usePoint==""){
	    	$("#pointDiv").append("<span style='color: red'>"+ classPay +"</span>");
	    }else if(usePoint.keyCode<48 || usePoint.keyCode>57){
	    	alert("????????? ??????????????????!");
	    	$("#pointDiv").focus();
	    }else{
	    	$("#pointDiv").append("<span style='color: red'>"+ (classPay - usePoint)	+"</span>");
	    	$("#pointDiv").append("<input type='hidden' name='final_price' value='"+ (classPay - usePoint)	+"'/>");
	    }
	   
	});
	
	// [????????????/????????????] ?????? ?????? ???, ?????? ??? ?????? and ClassApply table insert
	$("#cardPay").click(function() {
		  var IMP = window.IMP; // ????????????
	      IMP.init('${init}'); // 'iamport' ?????? ???????????? "????????? ????????????"??? ??????
	      var msg;
	      var final_price=$("input[name='final_price']").val();  

	        IMP.request_pay({
	            pg : '${pg}',
	            pay_method : '${pay_method}',
	            merchant_uid : 'merchant_' + new Date().getTime(),
	            name : '${name}',
	            amount : final_price,
	            buyer_email : '${bemail}',
	            buyer_name : '${bname}',
	            buyer_tel : '${btel}',
	            buyer_addr : '${baddr}',
	            buyer_postcode : '${bpostcode}',
	    
	        }, function(rsp) {
	            if ( rsp.success ) {

	                //????????? ????????? ?????????
	                var formData = $("#applyForm").serialize();
	                var class_num=$("input[name='class_num']").val();
    		
	        		$.post("${cp}/class/applyOk",formData , function(data) {
	        			
	        			if(data=="success"){
	        				
	                        msg = '????????? ?????????????????????.';
	                        msg += '\n??????ID : ' + rsp.imp_uid;
	                        msg += '\n?????? ??????ID : ' + rsp.merchant_uid;
	                        msg += '\?????? ?????? : ' + rsp.paid_amount;
	                        
	                        alert(msg);
	        				
	        				location.href="${cp}/class/success?class_num="+class_num;
	        			}else if(data=="fail"){
	        				alert("?????? ?????? ??????;");
	        				location.href="${cp}/";
	        			}else if(data=="already"){
	        				alert("?????? ????????? ???????????????. ?????? ????????? ??????????????????.");
	        				$('#pills-tab li:nth-child(1) a').tab('show');
	        			}
	        		});
	            } else {
	                msg = '????????? ?????????????????????.';
	                msg += '???????????? : ' + rsp.error_msg;
	                alert(msg);
	                //????????? ????????? ?????????
	                location.href="${cp}/";

	                
	            }
	        });
	        
	    });

	function fold(elm){
		if($(elm).children('.subtext').css('display')=='none'){
				$(elm).siblings('.certificate.class').removeClass('on').find('.subtext').hide();
				$(elm).children('.subtext').toggle("slow");
				$(elm).addClass('on');
		}else{
			$(elm).removeClass('on').find('.subtext').hide();
		}
	}
</script>