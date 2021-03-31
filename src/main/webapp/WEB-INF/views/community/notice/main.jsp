<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script type="text/javascript" src="${cp }/resources/js/jquery-3.5.1.js"></script>
<script type="text/javascript" src="${cp}/resources/vendor/bootstrap/js/bootstrap.js"></script>
<style>
.title-box {
	position: relative;
	padding-top: 60px;
	border-bottom: 1px solid #e4e4e4;
	margin-bottom: 40px;
	overflow: hidden;
}

.title-box h1 {
	float: left;
	font-size: 26px;
	color: #333;
	line-height: 1.85;
	padding-bottom: 10px;
}

.title-box .class-option {
	width: 400px;
	border: 1px solid #ddd;
	background: #fff;
	border-radius: 4px;
	padding: 9px 11px;
	float: right;
	margin-top: -5px;
	color: #888;
	letter-spacing: -0.35px;
}

.content-box {
	margin-bottom: 400px;
}

.flex-div {
	display: flex;
}

#subBtn {
	float: right;
}
</style>
<div class="container">
	<div class="title-box">
		<h1>공지사항</h1>
	</div>
	<div class="jumbotron">
		<h4>수업 관련 공지를 확인해 주세요 :)</h4>
		<hr class="my-4">
		<div class="card card-body">
			<table class="table table-hover" style="text-align: center">
				<thead class="thead-dark">
					<tr>
						<th>글번호</th>
						<th>제목</th>
						<th>작성일</th>
						<th>조회수</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="nt" items="${list }">
						<tr>
							<td>${nt.notice_num}</td>
							<td onclick="goDetail('${nt.notice_num}')">${nt.notice_title}</td>
							<td><fmt:formatDate value="${nt.notice_regdate}"
									pattern="yyyy-MM-dd"/></td>
							<td>${nt.notice_view}</td>
						<tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div>
			<ul class="pagination justify-content-center" style="margin: 20px 0">
				<c:choose>
					<c:when test="${pu.startPageNum>1 }">
						<li class="page-item"><a class="page-link"
							href="${cp }/community/notice?pageNum=${pu.startPageNum-1 }">이전</a></li>
					</c:when>
					<c:otherwise>
						<li class="page-item disabled"><a class="page-link" href="#">이전</a></li>
					</c:otherwise>
				</c:choose>

				<c:forEach var="i" begin="${pu.startPageNum}" end="${pu.endPageNum }">
					<c:choose>
						<c:when test="${pu.pageNum==i}">
							<li class="page-item active"><a class="page-link"
								href="${cp }/community/notice?pageNum=${i }">${i }</a></li>
						</c:when>
						<c:otherwise>
							<li class="page-item"><a class="page-link"
								href="${cp }/community/notice?pageNum=${i }">${i }</a></li>
						</c:otherwise>
					</c:choose>
				</c:forEach>

				<c:choose>
					<c:when test="${pu.totalPageCount>pu.endPageNum }">
						<li class="page-item"><a class="page-link"
							href="${cp }/community/notice?pageNum=${pu.endPageNum+1 }">다음</a></li>
					</c:when>
					<c:otherwise>
						<li class="page-item disabled"><a class="page-link" href="#">다음</a></li>
					</c:otherwise>
				</c:choose>
			</ul>
		</div>
		
		<button type="button" id="writeOk" class="btn btn-primary" style="float:right" onclick="showModal()">글작성</button>
		<!--a 공지글 작성 모달창 -->
		<div class="container">
			<div class="modal-container"></div>
		</div>
	</div>
</div>
<script type="text/javascript">
// 관리자가 아닐경우 글작성을 못하게 함. ajax
window.onload = function(){
	console.log("체크체크");
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
					$('#writeOk').attr('disabled', false);
				} else {
					console.log("실패");
					$('#writeOk').attr('disabled', true);
				}
	});
}
//글쓰기 모달창 띄우는 함수
function showModal(){
	var url = "${cp}/community/notice/writeNotice";
    $('.modal-container').load(url,function(result){
		$('#writeNotice').modal();
	});
}
//글 상세페이지로 이동하는 함수
function goDetail(notice_num){
	location.href="${cp}/community/noticeDetail?notice_num="+notice_num;
}
</script>