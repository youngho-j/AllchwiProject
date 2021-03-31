<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<link rel="stylesheet" href="${cp}/resources/css/classDetail/classDetail.css">
<!--  <script src="${cp}/resources/js/classDetail/classDetail.js"></script> -->
<style>
	li a{color:black;}
	ul{
   		list-style:none;
   	}
</style>


<script type="text/javascript"
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=${appkey}&libraries=services"></script>


<div class="container-fluid" id="container_detail" style="margin-top:-65px">
	<div class="row">
		<div class="col-md-12">
			<div class="row">
				<!-- 왼쪽수업정보 -->
				<div class="col-md-12">
	
					<!-- class wrap -->
					<!-- class_navi -->
					<div class="class_wrap">
						<div id="class_navi" class="class_navi">
							<ul style="margin: 0">
								<li><a href="#sumary" id="li1" class="on">요약</a></li>
								<li><a href="#tutor" id="li2" class="">튜터</a></li>
								<li><a href="#intro" id="li3" class="">수업소개</a></li>
								<li><a href="#location" id="li4" class="">장소</a></li>
							</ul>
						</div>
						<!--class_navi 내용  -->
						<!-- 1.요약 -->
						<div class="class_detail" id="sumary">
							<!-- 강사프로필 -->
							<div class="tutor_profile">
								<div class="tutor_img">

									<img alt="tutorprofile" class="roundImg"
										src="${cp}/mypageImg/getimg?pro_num=${vo.pro_num}" />

								</div>
								<div class="name">${vo.tutor_nickname }</div>
							</div>
							<div class="class_title">
								<!-- 수업명 -->
								<div class="title">
									<h3>${vo.class_title }</h3>
								</div>

								<!-- 기본정보 -->
								<div class="info">
									<ul>
										<li class="ar" id="regionAll"><c:if
												test="${vo.class_form==0}">
												${vo.bloc_name }&nbsp${vo.sloc_name}
											</c:if> <c:if test="${vo.class_form==1}">
												온라인
											</c:if></li>
										<li class="hu"><font color="#ff936f">${vo.class_hour}</font>시간/회</li>
										<li class="gr">최대인원:<font color="#ff936f">${vo.class_min}~${vo.class_max}</font>명
										</li>
										<li class="ohu"><font color="#ff936f">${vo.class_price}</font>/시간</li>
									</ul>
								</div>
							</div>
						</div>
						<!-- //1.요약 -->
						<!-- 2.튜터소개 -->
						<div class="class_detail detail_sec_bor" id="tutor">
							<div class="sec01">
								<h1 class="t_info">튜터정보</h1>

								<div class="cert">
								
										<ul>
											<c:forEach var="cert" items="${certiList}">
												<li class="com"><img
													src="https://user-images.githubusercontent.com/65140754/88015559-721aa500-cb5c-11ea-9c7b-4acdb7694eaf.png">
													${cert.certif_name }</li>
											</c:forEach>
										</ul>

										<div id="carouselExampleCaptions" class="carousel slide" data-ride="carousel">
										<ol class="carousel-indicators">
											<c:forEach var="cert" items="${certiList}" varStatus="status">
												<c:choose>
													<c:when test="${status.index==0}">
														<li data-target="#carouselExampleCaptions"
															data-slide-to="${status.index}" class="active"></li>
													</c:when>
													<c:otherwise>
														<li data-target="#carouselExampleCaptions"
															data-slide-to="${status.index}"></li>
													</c:otherwise>
												</c:choose>
											</c:forEach>
										</ol>

										<div class="carousel-inner">
											<c:forEach var="cert" items="${certiList}" varStatus="status">
												<c:choose>
													<c:when test="${status.index==0}">
														<div class="carousel-item active">
															<img
																src="${cp}/certiImg/getimg?certif_num=${cert.certif_num }"
																class="d-block w-100">
															<div class="carousel-caption d-none d-md-block">
																<h5>${cert.certif_name }</h5>
															</div>
														</div>
													</c:when>
													<c:otherwise>
														<div class="carousel-item">
															<img
																src="${cp}/certiImg/getimg?certif_num=${cert.certif_num }"
																class="d-block w-100">
															<div class="carousel-caption d-none d-md-block">
																<h5>${cert.certif_name }</h5>
															</div>
														</div>
													</c:otherwise>
												</c:choose>
											</c:forEach>
										</div>

										<a class="carousel-control-prev"
											href="#carouselExampleCaptions" role="button"
											data-slide="prev"> <span
											class="carousel-control-prev-icon" aria-hidden="true"></span>
											<span class="sr-only">Previous</span>
										</a> <a class="carousel-control-next"
											href="#carouselExampleCaptions" role="button"
											data-slide="next"> <span
											class="carousel-control-next-icon" aria-hidden="true"></span>
											<span class="sr-only">Next</span>
										</a>
									</div>

								</div>


								<div class="d_info">
									<p>${vo.tutor_about}</p>
								</div>
							</div>
						</div>
						<!-- //2.튜터소개 -->
						<!-- 3.수업소개 -->
						<div class="class_detail detail_sec_bor" id="intro">
							<div class="sec01">
								<h1 class="t_info">수업소개</h1>
								<div class="d_info">${vo.class_about}</div>
								<h1 class="t_info">수업대상</h1>
								<div class="d_info">${vo.class_target}</div>
								<h1 class="t_info">커리큘럼</h1>

								<c:forEach var="cur" items="${curriList}">
									<div class="currbox">
										<img
											src="https://user-images.githubusercontent.com/65140754/88137328-482db500-cc26-11ea-8913-a1986a0ba3bf.png">
										<h3>${cur.curri_count}회차</h3>
										<div class="d_info">${cur.curri_content}</div>
									</div>
								</c:forEach>

							</div>
						</div>
						<!-- //3.수업소개 -->

						<!--  수업장소 -->
						<div class="class_detail detail_sec_bor" id="location">
							<h1 class="t_info">수업장소</h1>
							<c:if test="${vo.class_form==0 }">
								${vo.class_address }
								<div id="map" style="width: 800px; height: 500px;"></div>
							</c:if>

						</div>

					</div>
					<!--// class wrap -->
				</div>


			</div>
		</div>
	</div>
</div>

<script>
	$(function(){
		var navOffset = $('.class_navi').offset();
		$(window).scroll(function() {
			if ($(document).scrollTop() > navOffset.top) {
				$('.class_navi').addClass('active');
	
			} else {
				$('.class_navi').removeClass('active');
			}
		});
		var remoteOffset = $('.remote').offset();
		$(window).scroll(function() {
			if ($(document).scrollTop() > remoteOffset.top) {
				$('.remote').addClass('active');
			} else {
				$('.remote').removeClass('active');
			}
		});
		$("#class_navi a").click(function() {
			$(this).addClass('on');
			$("#class_navi a").not(this).removeClass('on');
		});
		$("#card-header collapse").click(function() {
			$(this).addClass('show');
		});		
	});
	
	
	//카카오 지도 api
	var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
	mapOption = {
		center : new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
		level : 3, // 지도의 확대 레벨
		draggable : false
	};
	//지도를 생성합니다    
	var map = new kakao.maps.Map(mapContainer, mapOption);
	//주소-좌표 변환 객체를 생성합니다
	var geocoder = new kakao.maps.services.Geocoder();
	//주소로 좌표를 검색합니다
	geocoder.addressSearch('${vo.class_address}',function(result, status) {
		// 정상적으로 검색이 완료됐으면 
		if (status === kakao.maps.services.Status.OK) {
			var coords = new kakao.maps.LatLng(result[0].y,result[0].x);
		// 결과값으로 받은 위치를 마커로 표시합니다
			var marker = new kakao.maps.Marker({
				map : map,
				position : coords
			});
		// 인포윈도우로 장소에 대한 설명을 표시합니다
			var infowindow = new kakao.maps.InfoWindow({
					content : '<div style="width:150px;text-align:center;padding:6px 0;">${vo.class_address}</div>'
			});
			infowindow.open(map, marker);
		// 지도의 중심을 결과값으로 받은 위치로 이동시킵니다 
			map.setCenter(coords);
		}
	});
</script>