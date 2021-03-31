<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script type="text/javascript" src="${cp}/resources/js/jquery-3.5.1.js"></script>
<script type="text/javascript" src="${cp}/resources/vendor/bootstrap/js/bootstrap.js"></script>
<style>
#top {
	float: right;
}
#top > p{
	margin: 5px;
}
#btnGroup {
	float: right;
	margin-top: 10px;
}
#bottom {
	clear: right;
	margin-top: 10px;
}
</style>
<div class="container">
	<div class="jumbotron" style="padding: 2rem;">
		<div>
			<h4>${ntv.notice_title }</h4>
			<div id="top">
				<p>
					등록일 :
					<fmt:formatDate value="${ntv.notice_regdate}"
						pattern="yyyy-MM-dd HH:mm" />
				</p>
				<p>조회수 : ${ntv.notice_view}</p>
			</div>
		</div>
		<hr class="my-4" style="clear: right; margin: 0px">
		<div class="card card-body" style="height: 15rem; margin-top: 25px">
			<!-- white-space 스타일 시트를 사용하여 개행과 공백등이 원래대로 보이도록 처리-->
			<div style="white-space: pre">${ntv.notice_content }</div>
		</div>
		<div id="btnGroup">
			<button class="btn btn-primary" id="updateBtn" onclick="showModal('${ntv.notice_num}')">수정</button>
			<button class="btn btn-danger" id="deleteBtn" onclick="deleteNotice('${ntv.notice_num}')">삭제</button>
		</div>
		<div id="bottom">
			<c:choose>
				<c:when test="${prev != null }">
					이전글&nbsp&nbsp <a href="${cp}/community/noticeDetail?notice_num=${prev.notice_num }">${prev.notice_title }</a>
				</c:when>
				<c:otherwise>
					이전글이 존재하지 않습니다.
				</c:otherwise>
			</c:choose>

			<hr class="my-2">
			<c:choose>
				<c:when test="${next != null }">
					다음글&nbsp&nbsp <a href="${cp}/community/noticeDetail?notice_num=${next.notice_num }">${next.notice_title }</a>
				</c:when>
				<c:otherwise>
					다음글이 존재하지 않습니다.
				</c:otherwise>
			</c:choose>
		</div>
	</div>
</div>
<!--a 공지글 작성 모달창 -->
<div class="container">
	<div class="modal-container"></div>
</div>
<script type="text/javascript">
	//관리자가 아닐경우 글작성을 못하게 함. ajax
	window.onload = function(){
		//세션에 저장된 값을 가져옴
		let ml_num = ${ml_num};
		let class_num = ${commuInfo.class_num}
		$.getJSON("${cp}/adminCheck.do", {
					ml_num : ml_num,
					class_num : class_num				
				}, function(data) {
					//관리자인경우
					if (data.code == 'success') {
						console.log("성공");
						$('#updateBtn').attr('disabled', false);
						$('#deleteBtn').attr('disabled', false);
					} else {
						console.log("실패");
						$('#updateBtn').attr('disabled', true);
						$('#deleteBtn').attr('disabled', true);
					}
		});
	}
	//글 삭제하는함수
	function deleteNotice(notice_num){
		location.href="${cp}/community/noticeDelete?notice_num="+notice_num;
	}
	
	//글 수정 모달창 띄우는 함수
	function showModal(notice_num){
		var url = "${cp}/community/notice/updateNotice?notice_num="+notice_num;
	    $('.modal-container').load(url,function(result){
			$('#updateNotice').modal();
		});
	}
</script>
