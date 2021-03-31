<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style>
style>.carousel-inner {
	position: relative;
	width: 70%; margin : auto;
	overflow: hidden;
	margin: auto;
}

.carousel {
	position: relative;
	background-color: #A9C8FB;
}
/*a carousel 이미지 크기 */
.carousel-item>img {
	object-fit: fill;
	height: 450px;
}
</style>

<div class="container">
	<!-- jumbotron 패딩 사이즈 0으로 변경 -->
	<div class="jumbotron p-0 p-md-0 text-white rounded bg-light">
		<!-- 메인 배너  -->
		<div id="carouselExampleIndicators" class="carousel slide"
			data-ride="carousel">
			<ol class="carousel-indicators">
				<!-- status.index 0부터 시작 -->
				<c:forEach var="showImg" items="${classImg}" varStatus="status">
					<c:choose>
						<c:when test="${status.index==0}">
							<li data-slide-to="${status.index}" data-target="#carouselExampleIndicators"
							class="active"></li>
						</c:when>
						<c:otherwise>
							<li data-slide-to="${status.index}" data-target="#carouselExampleIndicators"></li>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</ol>
			<div class="carousel-inner">
				<c:forEach var="showImg" items="${classImg}" varStatus="status">
					<c:choose>
						<c:when test="${status.index==0}">
							<div class="carousel-item active">
								<img class="d-block w-100"
								src="${cp}/classImg/getimg?cover_num=${showImg.cover_num}"/>
							</div>
						</c:when>
						<c:otherwise>
							<div class="carousel-item">
								<img class="d-block w-100"
								src="${cp}/classImg/getimg?cover_num=${showImg.cover_num}"/>
							</div>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</div>
			<!--a 좌우이동 flex-start, flex-end로 변경  -->
			<a class="carousel-control-prev" href="#carouselExampleIndicators"
				role="button" data-slide="prev" style="justify-content: flex-start">
				<span class="carousel-control-prev-icon" aria-hidden="true"></span>
				<span class="sr-only">Previous</span>
			</a> <a class="carousel-control-next" href="#carouselExampleIndicators"
				role="button" data-slide="next" style="justify-content: flex-end">
				<span class="carousel-control-next-icon" aria-hidden="true"></span>
				<span class="sr-only">Next</span>
			</a>
		</div>
		<!-- 메인배너 끝 -->
	</div>

	<div class="row mb-2">
		<div class="col-md-6">
			<div
				class="row no-gutters border rounded overflow-hidden flex-md-row mb-4 shadow-sm h-md-250 position-relative">
				<div class="col p-4 d-flex flex-column position-static">
					<strong class="d-inline-block mb-2 text-primary">Notice</strong>
					<h3 class="mb-0">공지사항</h3>
					<div class="mb-1 text-muted">[이번주 등록된 공지사항]</div>
					<c:choose>
						<c:when test="${noticeCount != 0}">
							<p class="card-text mb-auto">
								등록된 공지사항이 ${noticeCount}개 있습니다.
								<br>
								공지를 확인해주시기 바랍니다. &nbsp;:)
							</p>
						</c:when>
						<c:otherwise>
							<p class="card-text mb-auto">이번주 등록된 공지사항이 없습니다.</p>
						</c:otherwise>
					</c:choose>
					<a href="${cp}/community/notice" class="stretched-link">바로가기</a>
				</div>
				<!-- a 이미지 출력 -->
				<div class="col-auto d-none d-lg-block">
					<img class="bd-placeholder-img" width="200" height="250" 
					alt="puppy" src="${cp}/resources/img/puppy.jpg">
				</div>
			</div>
		</div>
		<div class="col-md-6">
			<div
				class="row no-gutters border rounded overflow-hidden flex-md-row mb-4 shadow-sm h-md-250 position-relative">
				<div class="col p-4 d-flex flex-column position-static">
					<strong class="d-inline-block mb-2 text-success">Assignment</strong>
					<h3 class="mb-0">과제</h3>
					<div class="mb-1 text-muted">[이번주 등록된 과제]</div>
					<c:choose>
						<c:when test="${assignCount != 0}">
							<p class="card-text mb-auto">등록된 과제가 ${assignCount}개 있습니다.
							<br>과제를 확인해주시기 바랍니다. &nbsp; :)</p>
						</c:when>
						<c:otherwise>
							<p class="card-text mb-auto">이번주 등록된 과제가 없습니다.</p>
						</c:otherwise>
					</c:choose>
					<a href="${cp}/community/assignment" class="stretched-link">바로가기</a>
				</div>
				<!-- a 이미지 출력 -->
				<div class="col-auto d-none d-lg-block">
					<img class="bd-placeholder-img" width="200" height="250" 
					alt="puppy" src="${cp}/resources/img/puppy2.jpg">
				</div>
			</div>
		</div>
	</div>
</div>