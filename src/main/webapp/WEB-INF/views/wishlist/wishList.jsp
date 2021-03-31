<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<link rel="stylesheet" href="${cp}/resources/css/wishList/wishList.css">
    
<div class="container">
	<!-- My WishList Header -->
	<div class="title-box">
		<h1>위시리스트</h1>
		<ul>
			<li class="wishOn"><a href="${cp}/class/wishList">위시리스트</a></li>
		</ul>
	</div>
	<!-- WishList BoxList -->
	<div class="class-box">
		<c:forEach var="vo" items="${list}">
		
		<div class="class-info">
			<div class="image">
				<img src="${cp}/classImg/getimg?cover_num=${vo.cover_num }">
			</div>
			<div class="information-box">
				<h3 onclick="location.href='${cp}/classDetail/detail?class_num=${vo.class_num}'">
					${vo.class_title }
				</h3>
				<div class="stars-box">
					<c:choose>
						<c:when test="${vo.class_form=='0' }">
							<font class="class-type">오프라인 </font>&nbsp;|&nbsp; &nbsp;												
						</c:when>
						<c:otherwise>
							<font class="class-type">온라인  </font>&nbsp;|&nbsp; &nbsp;												
						</c:otherwise>
					</c:choose>
					<font class="class-stars">
						<c:set var="grade" value="${vo.class_rating+((vo.class_rating%1>0.5)?(1-(vo.class_rating%1))%1:-(vo.class_rating%1))}" />
						<c:forEach var="num" begin="1" end="5" step="1">
							<c:choose>
								<c:when test="${num  <= grade}">
									<img src="${cp }/resources/img/star.png" width="15px">
								</c:when>
								<c:otherwise>
									<img src="${cp }/resources/img/star_gray.png" width="15px">
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</font>
					<span>(${vo.class_rating })</span>
				</div>
				<div class="start-date">
					&nbsp;|&nbsp; 
					<font>${vo.sloc_name }</font>
				</div>
				<div class="price"><font>￦</font><fmt:formatNumber type="number" maxFractionDigits="3" value="${vo.class_price }" /></div>
			</div>
		</div>
		</c:forEach>
		<div>
			<ul class="pagination justify-content-center" style="margin: 20px 0">
				<c:choose>
					<c:when test="${pu.startPageNum>1 }">
						<li class="page-item"><a class="page-link"
							href="${cp }/class/wishList?pageNum=${pu.startPageNum-1 }">이전</a></li>
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
								href="${cp }/class/wishList?pageNum=${i }">${i }</a></li>
						</c:when>
						<c:otherwise>
							<li class="page-item"><a class="page-link"
								href="${cp }/class/wishList?pageNum=${i }">${i }</a></li>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				<c:choose>
					<c:when test="${pu.totalPageCount>pu.endPageNum }">
						<li class="page-item"><a class="page-link"
							href="${cp }/class/wishList?pageNum=${pu.endPageNum+1 }">다음</a></li>
					</c:when>
					<c:otherwise>
						<li class="page-item disabled"><a class="page-link" href="#">다음</a></li>
					</c:otherwise>
				</c:choose>
			</ul>
		</div>
	</div>
</div>