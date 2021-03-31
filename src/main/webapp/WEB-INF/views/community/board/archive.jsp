<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script type="text/javascript" src="${cp }/resources/js/jquery-3.5.1.js"></script>

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
		<h1>자료실</h1>
	</div>
	<div class="jumbotron">
		<h4>수업 관련 자료를 확인해주세요.</h4>
		<hr class="my-4">
		<div class="card card-body">
			<table class="table table-hover" style="text-align: center">
				<thead class="thead-dark">
					<tr>
						<th>번호</th>
						<th>말머리 </th>
						<th>제목</th>
						<th>작성일</th>
						<th>조회수</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="vo" items="${list }">
						<tr onclick="detail('${vo.room_num}','${vo.commu_num }')">
							<td>${vo.room_num }</td>
							<c:choose>	
								<c:when test="${vo.horsehead == 1}">						
									<td>과제</td>
								</c:when>
								<c:when test="${vo.horsehead == 2}">						
									<td>참고자료</td>
								</c:when>
								<c:otherwise>
									<td>수업자료</td>
								</c:otherwise>
							</c:choose>
							<td>${vo.room_title}</td>
							<td><fmt:formatDate value="${vo.room_regdate }"
									pattern="yyyy-MM-dd" /></td>
							<td>${vo.room_view }</td>
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
							href="${cp }/community/archive?pageNum=${pu.startPageNum-1 }&field=${field}&keyword=${keyword}">이전</a></li>
					</c:when>
					<c:otherwise>
						<li class="page-item disabled"><a class="page-link" href="#">이전</a></li>
					</c:otherwise>
				</c:choose>

				<c:forEach var="i" begin="${pu.startPageNum}" end="${pu.endPageNum }">
					<c:choose>
						<c:when test="${pu.pageNum==i}">
							<li class="page-item active"><a class="page-link"
								href="${cp }/community/archive?pageNum=${i }&field=${field}&keyword=${keyword}">${i }</a></li>
						</c:when>
						<c:otherwise>
							<li class="page-item"><a class="page-link"
								href="${cp }/community/archive?pageNum=${i }&field=${field}&keyword=${keyword}">${i }</a></li>
						</c:otherwise>
					</c:choose>
				</c:forEach>

				<c:choose>
					<c:when test="${pu.totalPageCount>pu.endPageNum }">
						<li class="page-item"><a class="page-link"
							href="${cp }/community/archive?pageNum=${pu.endPageNum+1 }&field=${field}&keyword=${keyword}">다음</a></li>
					</c:when>
					<c:otherwise>
						<li class="page-item disabled"><a class="page-link" href="#">다음</a></li>
					</c:otherwise>
				</c:choose>
			</ul>
		</div>
		
		<c:choose>
			<c:when test="${ml_num == commu_ml_num}">
				<button type="button" class="btn btn-primary" style="float:right" onclick="location.href='${cp}/community/writeContent'">글작성</button>
			</c:when>
			<c:otherwise>
				<button type="button" class="btn btn-primary" style="float:right"  disabled="disabled">글작성</button>
			</c:otherwise>
		</c:choose>



	</div>
</div>

<script type="text/javascript">
	function detail(room_num,commu_num){
		location.href="${cp}/community/archiveDetail?room_num="+room_num+"&commu_num="+commu_num;
	}
	


</script>