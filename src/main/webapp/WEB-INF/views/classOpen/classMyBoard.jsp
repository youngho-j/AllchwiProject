<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<link rel="stylesheet" href="${cp}/resources/css/classMyboard/classMyboard.css">
<script type="text/javascript">

	function selectTitle(val){
		var v = $(val).val();
		location.href = "${cp}/class/classBoard?class_num="+v;  
	}
	
	function commuCreate(){
		$.ajax({
		    type: "post",
		    dataType: "text",
		    url: "${cp}/class/community",
		    data: {class_num : '${list.class_num}' ,commu_title: '${list.class_title}'},
		    success: function(data) {
		    	if(data == 'success'){
		    		alert('커뮤니티가 생성되었습니다.');
		    		location.href = "${cp}/class/classBoard?class_num=${list.class_num}"; 
		    	}else if(data == 'already'){				    		
		    		alert('이미 커뮤니티가 존재합니다.!');
		    	}else{
		    		alert('생성 실패!!!')
		    	}
		    }
		});
	}
	
	function fnStatusChange(){
		
		if('${list.class_auth}'=='0'){
			$.ajax({
			    type: "post",
			    dataType: "text",
			    url: "${cp}/class/classStatusUpdate",
			    data: {class_num : '${list.class_num}' ,class_auth: '${list.class_auth}'},
			    success: function(data) {
			    	if(data == 'success'){
			    		alert('심사신청이 되었습니다.');
			    		location.href = "${cp}/class/classBoard?class_num=${list.class_num}"; 
			    	}else{				    		
			    		alert('다시 신청해주세요!');
			    	}
			    }
			});
		}else{
			alert("심사요청을 할수 없습니다.");
		}
	}
	
	function salesStatus(val){
		
		if (confirm("정말 판매상태를 변경하시겠습니까?") == true){    
			$.ajax({
			    type: "post",
			    dataType: "text",
			    url: "${cp}/class/classSalesUpdate",
			    data: {class_num: '${list.class_num}',class_status:val},
			    success: function(data) {
			    	if(data == 'success'){
			    		alert('판매상태가 변경되었습니다.');
			    		location.href = "${cp}/class/classBoard?class_num=${list.class_num}";
			    	}else{				    		
			    		alert('다시 변경해주세요!');
			    	}
			    }
			});

		}else{   //취소

		    return;

		}
	}
	
	function delClassInfo(){
		if (confirm("정말 수업을 삭제하시 겠습니까??/n아직 수업을 완료하지 않은 회원이 있으시면 취소하지 마세요.") == true){    
			$.ajax({
			    type: "post",
			    dataType: "text",
			    url: "${cp}/class/classDelete",
			    data: {class_num: '${list.class_num}'},
			    success: function(data) {
			    	if(data == 'success'){
			    		alert('정상적으로 수업이 삭제되었습니다.');
			    		location.href = "${cp}/class/classBoard";
			    	}else{				    		
			    		alert('다시 변경해주세요!');
			    	}
			    }
			});

		}else{   //취소
		    return;
		}
	}
</script>
<div class="container">
	<div class="title-box">
		<h1>내 수업</h1>
		<select class="class-option" onchange="selectTitle(this);">
			<c:forEach var="vo" items="${title}">
				<option value="${vo.class_num}" <c:if test="${list.class_num==vo.class_num}">selected</c:if>>${vo.class_title }</option>
			</c:forEach>  
		</select>
	</div>  
	<c:choose>
		<c:when test="${not empty list}">
		<div class="static-container">  
			<h3>수업상태</h3>
			<div class="static-box">
				<div class="image"
					style="background-image: url(${cp}/classImg/getimg?cover_num=${list.cover_num });"></div>
				<div class="info-box">
					<c:if test="${list.class_auth == '2' }">
						<div class="dropdown more-text">
				            <button type="button" class="btn btn-default dropdown toggle" data-toggle="dropdown">
							<svg class="cursor" width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-three-dots-vertical" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
			 					 <path fill-rule="evenodd" d="M9.5 13a1.5 1.5 0 1 1-3 0 1.5 1.5 0 0 1 3 0zm0-5a1.5 1.5 0 1 1-3 0 1.5 1.5 0 0 1 3 0zm0-5a1.5 1.5 0 1 1-3 0 1.5 1.5 0 0 1 3 0z"/>
							</svg>
				            <span class="caret"></span></button>
				            <ul class="dropdown-menu" role="menu">
				                <li style="text-align: center;"><a href="#" onclick="delClassInfo()"><font style="font-size: 14px; color: black;">수업 삭제</font></a></li>
				            </ul>
				        </div>
					</c:if>
					<div>
						<h3 onclick="location.href='${cp}/classDetail/detail?class_num=${list.class_num }'" style="cursor: pointer">${list.class_title }</h3>
					</div>
					<div>
						<span class="date">업데이트 : <fmt:formatDate value="${list.class_regdate}" pattern="yyyy-MM-dd HH:mm:ss"/></span>
						<c:choose>
							<c:when test="${list.class_auth== '0' }">
								<div class="button_gray cursor" onclick="fnStatusChange(${list.class_num});" style="float:right;">심사요청하기</div>
							</c:when>
							<c:when test="${list.class_auth == '1'}">
								<div class="button_gray" style="float:right;">심사대기중</div>
							</c:when>
							<c:when test="${list.class_auth == '2'}">
								<div class="button_gray" style="float:right;">심사완료</div>
							</c:when>																																														
						</c:choose>
						<c:if test="${list.class_status == '1'&& list.class_auth == '2' }">
							<a href="${cp}/class/classDate?class_num=${list.class_num}">
							<div class="button_gray" style="margin-right : 10px; float:right;">시간/날짜 설정</div></a> 
						</c:if>
					</div>
					<div style="margin-top: 56px">
						<div class="button-box">
							<c:if test="${list.class_form == 1 }">
								<c:choose>
									<c:when test="${community !='1'}">
										<div class="button_gray cursor" style="margin-left: 10px;" onclick="commuCreate()">커뮤니티 생성</div>
									</c:when>
									<c:otherwise>
										<a href="${cp}/onclass/community?class_num=${list.class_num}">
										<div class="button_gray cursor" style="margin-left: 10px;">커뮤니티</div></a>
									</c:otherwise>	
								</c:choose> 
							</c:if>
							<c:if test="${list.class_auth!='1'}">
								<a href="${cp}/class/classInfoUpdate?class_num=${list.class_num}">
								<div class="button_gray cursor" style="margin-left: 10px;">수업수정</div></a>
							</c:if>
							<c:if test="${list.class_status== '1' && list.class_auth == '2'}">
								<div class="button_gray cursor" style="margin-left: 10px;" onclick="salesStatus(0)">판매시작하기</div>
							</c:if>
							<c:if test="${list.class_status== '0' && list.class_auth == '2'}">
								<div class="button_white cursor" style="margin-left: 10px;" onclick="salesStatus(1)">판매중지하기</div>
							</c:if>
						</div>
					</div>
				</div>
			</div>
		</div>
		</c:when>
		<c:otherwise>
			<div class="static-container">  
				수업이 존재하지 않습니다.
			</div>
		</c:otherwise>
	</c:choose>
</div>