<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<link rel="stylesheet"
	href="${cp}/resources/css/classDetail/classDetail.css">
<script src="${cp}/resources/js/classDetail/classDetail.js"></script>
<script type="text/javascript"
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=${appkey}&libraries=services"></script>
<link id="cp" data-contextPath="${cp}"/>
<input type="hidden" id="ml_num" value="${ml_num }">
<input type="hidden" id="class_num" value="${class_num }">
<input type="hidden" id="tutor_num" value="${cdv.ml_num }">
<input type="hidden" id="finished" value="${finished }">
<div class="container-fluid" id="container_detail">
	<div class="row">
		<div class="col-md-12">
			<div class="row">
				<!-- 왼쪽수업정보 -->
				<div class="col-md-8">
					<!-- carousel -->
					<div class="carousel slide" id="carousel">
						<ol class="carousel-indicators">
							<c:forEach var="cover" items="${cdv.getCoverList()}">
								<c:choose>
									<c:when test="${cover.cnt==1}">
										<li data-slide-to="${cover.cnt}" data-target="#carousel"
											class="active"></li>
									</c:when>
									<c:otherwise>
										<li data-slide-to="${cover.cnt}" data-target="#carousel"></li>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</ol>
						<div class="carousel-inner">
							<c:forEach var="cover" items="${cdv.getCoverList()}">
								<c:choose>
									<c:when test="${cover.cnt==1}">
										<div class="carousel-item active">
											<img class="d-block w-100" alt="Carousel"
												src="${cp}/classImg/getimg?cover_num=${cover.cover_num}" />
										</div>
									</c:when>
									<c:otherwise>
										<div class="carousel-item">
											<img class="d-block w-100" alt="Carousel"
												src="${cp}/classImg/getimg?cover_num=${cover.cover_num}" />
										</div>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</div>
						<!-- carousel-control -->
						<a class="carousel-control-prev" href="#carousel"
							data-slide="prev"> <span class="carousel-control-prev-icon"></span>
							<span class="sr-only">Previous</span>
						</a> <a class="carousel-control-next" href="#carousel"
							data-slide="next"> <span class="carousel-control-next-icon"></span>
							<span class="sr-only">Next</span>
						</a>
						<!-- //carousel-control -->
						<!-- //carousel -->
					</div>
					<!-- class wrap -->
					<!-- class_navi -->
					<div class="class_wrap ">
						<div id="class_navi" class="class_navi">
							<ul style="margin: 0">
								<li><a href="#sumary" id="li1" class="on">요약</a></li>
								<li><a href="#tutor" id="li2" class="">튜터</a></li>
								<li><a href="#intro" id="li3" class="">수업소개</a></li>
								<li><a href="#review" id="li4" class="">리뷰</a></li>
								<li><a href="#qna" id="li5" class="">문의</a></li>
							</ul>
						</div>
						<!--class_navi 내용  -->
						<!-- 1.요약 -->
						<div class="class_detail" id="sumary">
							<!-- 강사프로필 -->
							<div class="tutor_profile">
								<div class="tutor_img">
									<img alt="tutorprofile" class="roundImg"
										src="${cp}/mypageImg/getimg?pro_num=${cdv.pro_num}" />
								</div>
								<div class="name">${cdv.tutor_nickname }</div>
							</div>
							<div class="class_title">
								<!-- 수업명 -->
								<div class="title">
									<h3>${cdv.class_title }</h3>
								</div>

								<!-- 별점 -->
								<div class="info">
									<a class="starimg"> <c:if test="${not empty rlist}">
											<fmt:formatNumber value="${rating.tot_avg }" pattern="0"
												type="number" var="tot_avg" />
											<c:forEach var="index" begin="1" end="${tot_avg }">
												<img
													src="https://user-images.githubusercontent.com/65140754/86704557-f98df180-c04f-11ea-98d7-6ef52adba462.png">
											</c:forEach>
											<c:forEach var="index" begin="1" end="${5-tot_avg }">
												<img
													src="https://user-images.githubusercontent.com/65140754/88132019-57f2cc80-cc19-11ea-9093-0f7747ab82b6.png">
											</c:forEach>
										</c:if> <c:if test="${empty rlist}">
											<c:forEach var="index" begin="1" end="5">
												<img
													src="https://user-images.githubusercontent.com/65140754/86704557-f98df180-c04f-11ea-98d7-6ef52adba462.png">
											</c:forEach>
										</c:if> (${rpu.totalRowCount })
									</a>
									<!-- 찜하기 -->
									<c:choose>
										<c:when test="${empty ml_num}">
											<a onclick="alert('로그인이 필요합니다'); " href="${cp}/login/main"
												id="btn_wishlist" class="btn_wishlist"> <img
												id="wishsrc"
												src="https://user-images.githubusercontent.com/65140754/86717485-2e547580-c05d-11ea-9dcf-27e47ad3f8e2.png">
												찜하기
											</a>
										</c:when>
										<c:otherwise>
											<c:choose>
												<c:when test="${wstatus eq true}">
													<a href="javascript:void(0);" class="btn_wishlist"
														id="btn_after_wish"> <img id="wishsrc"
														src="https://user-images.githubusercontent.com/65140754/86716818-8474e900-c05c-11ea-8c48-5764f4d57b28.png">
														찜하기
													</a>
												</c:when>
												<c:otherwise>
													<a href="javascript:void(0);" class="btn_wishlist"
														id="btn_before_wish"> <img id="wishsrc"
														src="https://user-images.githubusercontent.com/65140754/86717485-2e547580-c05d-11ea-9dcf-27e47ad3f8e2.png">
														찜하기
													</a>
												</c:otherwise>
											</c:choose>
										</c:otherwise>
									</c:choose>
									<!-- ///찜하기 -->

								</div>
								<!-- 기본정보 -->
								<div class="info">
									<ul>
										<li class="ar" id="regionAll"><c:if
												test="${cdv.class_form==0}">
												${cdv.bloc_name }&nbsp${cdv.sloc_name}
											</c:if> <c:if test="${cdv.class_form==1}">
												온라인
											</c:if></li>
										<li class="hu"><font color="#ff936f">${cdv.class_hour}</font>시간/회</li>
										<li class="gr">최대인원:<font color="#ff936f">${cdv.class_min}~${cdv.class_max}</font>명
										</li>
										<li class="ohu"><font color="#ff936f">${cdv.class_price}</font>/시간</li>
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
										<c:forEach var="cert" items="${cdv.getCertList()}">
											<li class="com"><img
												src="https://user-images.githubusercontent.com/65140754/88015559-721aa500-cb5c-11ea-9c7b-4acdb7694eaf.png">
												${cert.certif_name }</li>
										</c:forEach>
									</ul>
								</div>
								<div class="d_info">
									<p>${cdv.tutor_about}</p>
								</div>
							</div>
						</div>
						<!-- //2.튜터소개 -->
						<!-- 3.수업소개 -->
						<div class="class_detail detail_sec_bor" id="intro">
							<div class="sec01">
								<h1 class="t_info">수업소개</h1>
								<div class="d_info">${cdv.class_about}</div>
								<h1 class="t_info">수업대상</h1>
								<div class="d_info">${cdv.class_target}</div>
								<h1 class="t_info">커리큘럼</h1>
								<c:forEach var="curr" items="${cdv.getCurriList()}">
									<div class="currbox">
										<img
											src="https://user-images.githubusercontent.com/65140754/88137328-482db500-cc26-11ea-8913-a1986a0ba3bf.png">
										<h3>${curr.curri_count}회차</h3>
										<div class="d_info">${curr.curri_content}</div>
									</div>
								</c:forEach>
							</div>
						</div>
						<!-- //3.수업소개 -->
						<!-- 4.리뷰 -->
						<div class="class_detail detail_sec_bor" id="review">
							<div class="sec01">
								<h1 class="t_info">리뷰(${rpu.totalRowCount })</h1>
								<div class="btn_write" id="btn_write_review">리뷰쓰기</div>
								<c:if test="${not empty rlist}">
									<!-- 별점평균 -->
									<div class="review_box">
										<fmt:formatNumber value="${rating.tot_avg }" pattern="0"
											type="number" var="tot_avg" />
										<c:forEach var="index" begin="1" end="${tot_avg }">
											<img
												src="https://user-images.githubusercontent.com/65140754/86704557-f98df180-c04f-11ea-98d7-6ef52adba462.png">
										</c:forEach>
										<c:forEach var="index" begin="1" end="${5-tot_avg }">
											<img
												src="https://user-images.githubusercontent.com/65140754/88132019-57f2cc80-cc19-11ea-9093-0f7747ab82b6.png">
										</c:forEach>
										${rating.tot_avg }
									</div>
									<!-- 상세별점 -->
									<div class="review_count01">
										<ul>
											<li>커리큘럼 <c:forEach var="index" begin="1"
													end="${rating.curr_avg }">
													<img
														src="https://user-images.githubusercontent.com/65140754/86704557-f98df180-c04f-11ea-98d7-6ef52adba462.png">
												</c:forEach> <c:forEach var="index" begin="1"
													end="${5-rating.curr_avg }">
													<img
														src="https://user-images.githubusercontent.com/65140754/88132019-57f2cc80-cc19-11ea-9093-0f7747ab82b6.png">
												</c:forEach>
											</li>
											<li>준비성 <c:forEach var="index" begin="1"
													end="${rating.ready_avg }">
													<img
														src="https://user-images.githubusercontent.com/65140754/86704557-f98df180-c04f-11ea-98d7-6ef52adba462.png">
												</c:forEach> <c:forEach var="index" begin="1"
													end="${5-rating.ready_avg }">
													<img
														src="https://user-images.githubusercontent.com/65140754/88132019-57f2cc80-cc19-11ea-9093-0f7747ab82b6.png">
												</c:forEach>
											</li>
											<li>친절도 <c:forEach var="index" begin="1"
													end="${rating.kind_avg }">
													<img
														src="https://user-images.githubusercontent.com/65140754/86704557-f98df180-c04f-11ea-98d7-6ef52adba462.png">
												</c:forEach> <c:forEach var="index" begin="1"
													end="${5-rating.kind_avg }">
													<img
														src="https://user-images.githubusercontent.com/65140754/88132019-57f2cc80-cc19-11ea-9093-0f7747ab82b6.png">
												</c:forEach>
											</li>
											<li>시간준수 <c:forEach var="index" begin="1"
													end="${rating.time_avg }">
													<img
														src="https://user-images.githubusercontent.com/65140754/86704557-f98df180-c04f-11ea-98d7-6ef52adba462.png">
												</c:forEach> <c:forEach var="index" begin="1"
													end="${5-rating.time_avg }">
													<img
														src="https://user-images.githubusercontent.com/65140754/88132019-57f2cc80-cc19-11ea-9093-0f7747ab82b6.png">
												</c:forEach>
											</li>
										</ul>
									</div>
									<br>
									<!-- 리뷰 목록 -->
									<div class="review_list" id="bookmarkReview">
										<div id="innerReviewDiv">
											<c:forEach var="rlist" items="${rlist }">
												<ul>
													<li><dl>
															<dt>
																<p class="profile_img"
																	style="height: 86px; background-size: cover; background-position: center; 
																	background-image: url(${cp}/mypageImg/getimg?pro_num=${rlist.pfv.pro_num});"></p>
																<p class="name">${rlist.miv.mb_name }</p>
															</dt>
															<dd>${rlist.review_content }</dd>
															<dd class="date">
																<fmt:formatDate value="${rlist.review_regdate }"
																	pattern="yyyy-MM-dd" />
															</dd>

														</dl></li>
												</ul>
											</c:forEach>
										</div>
									</div>
									<!-- 리뷰페이징 -->
									<div id="paging">
										<ul class='pagination justify-content-center'
											style='margin: 20px 0'>
											<c:choose>
												<c:when test="${rpu.pageNum > rpu.startPageNum}">
													<li class="page-item"><a class="page-link"
														href="${cp }/classDetail/detail?pageNum=${rpu.pageNum-1 }&class_num=${class_num}">이전</a></li>
												</c:when>
												<c:otherwise>
													<li class="page-item disabled"><a class="page-link"
														href="#">이전</a></li>
												</c:otherwise>
											</c:choose>
											<c:forEach var='i' begin='${rpu.startPageNum }'
												end='${rpu.endPageNum }'>
												<c:choose>
													<c:when test='${i==rpu.pageNum}'>
														<li class="page-item active"><a class="page-link"
															href='${cp }/classDetail/detail?pageNum=${i}&class_num=${class_num}'
															style='background: #7185bb; color: white;'>${i } </a></li>
													</c:when>
													<c:otherwise>
														<li class="page-item"><a class="page-link"
															href='${cp }/classDetail/detail?pageNum=${i}&class_num=${class_num}'>${i }
														</a></li>
													</c:otherwise>
												</c:choose>
											</c:forEach>
											<c:choose>
												<c:when test="${rpu.totalPageCount>rpu.pageNum }">
													<li class="page-item"><a class="page-link"
														href="${cp }/classDetail/detail?pageNum=${rpu.pageNum+1 }&class_num=${class_num}">다음</a></li>
												</c:when>
												<c:otherwise>
													<li class="page-item disabled"><a class="page-link"
														href="#">다음</a></li>
												</c:otherwise>
											</c:choose>
										</ul>
									</div>
								</c:if>
								<c:if test="${empty rlist}">
									<h3>작성된 리뷰 없음</h3>
								</c:if>
								<!-- ///리뷰페이징끝 -->
							</div>
						</div>
						<!-- //4.리뷰 -->
						<!-- 5.qna -->
						<div class="class_detail detail_sec_bor" id="qna">
							<div class="sec01">
								<h1 class="t_info">Q&amp;A</h1>
								<textarea type="text" id="qna_content"
									class="md-textarea form-control" rows="4"></textarea>
								<c:choose>
									<c:when test="${empty ml_num}">
										<div class="btn_write">
											<a onclick="alert('로그인이 필요합니다'); " href="${cp}/login/main">
												문의하기</a>
										</div>
									</c:when>
									<c:otherwise>
										<div class="btn_write">
											<a href="javascript:void(0);" id="btn_write_qna">문의하기</a>
										</div>
									</c:otherwise>
								</c:choose>

								<!-- qna 리스트 시작 -->
								<div class="qna_wrap"></div>
							</div>
						</div>
						<!-- ///qna -->
					</div>
					<!--// class wrap -->
				</div>
				<!-- 왼쪽수업정보끝 -->
				<!-- 시간&날짜/ 결제창 -->
				<div class="col-md-4 remote">
					<div class="remote_wrap">
						<div class="class_type">
							<c:if test="${cdv.class_form==0 }">
								<h3>오프라인수업</h3>
							</c:if>
							<c:if test="${cdv.class_form==1 }">
								<h3>온라인수업</h3>
							</c:if>
						</div>
						<c:if test="${empty dlist }">
							<div class="card-header">
								예정된 수업 일정이 없습니다
							</div>
						</c:if>
						<c:forEach var="dlist" items="${dlist }" varStatus="index">
							<div class="accordion" id="accordionExample">
								<div class="card">
									<div class="card-header">
										<a class="collapsed card-link" data-toggle="collapse"
											data-parent="#accordionExample"
											href="#card-element-${index.count}">
											<div class="date">
												<fmt:formatDate value="${dlist.class_date}" pattern="yyyy-MM-dd" />
											</div> 
											<c:if test="${cdv.class_form==0 }">
													&nbsp;&nbsp; ${dlist.class_startTime}~ ${dlist.class_endTime }
													</c:if> <c:if test="${cdv.class_form==1 }">
														&nbsp;&nbsp; ${dlist.class_month}개월 과정
													</c:if>
										</a>
									</div>
									<div id="card-element-${index.count}" class="collapse">
										<div class="card-body">
											<c:if test="${empty dlist.list}">
													원데이 클래스 입니다
											</c:if>
											<c:forEach var="vo" items="${dlist.list}">
												<div class="ch">
													<div class="date">
														<font style="color: #ff936f;">${vo.time_cnt}회</font> :
														<fmt:formatDate value="${vo.class_date}"
															pattern="yyyy-MM-dd" />
													</div>
													&nbsp;&nbsp; ${vo.class_startTime } ~ ${vo.class_endTime }
												</div>
											</c:forEach>
										</div>
									</div>
								</div>
							</div>

						</c:forEach>
						<c:forEach var="vo" items="${dlist}" varStatus="index">
							<c:if test="${index.last }">
							<div class="tutor_t">
								<dl class="tutor_txt">
									<dt>
										<div
											style="background: #000; z-index: 0; width: 100%; height: 100%; background-size: cover; background-position: center; background-image: url('${cp}/mypageImg/getimg?pro_num=${cdv.pro_num}');">
										</div>
									</dt>
									<dd>${vo.class_comment}</dd>
								</dl>
							</div>
							</c:if>
						</c:forEach>
						<c:if test="${cdv.class_form==0 }">
							${cdv.class_address }
							<div id="map" style="width: 450px; height: 250px;"></div>
						</c:if>
						<div class="price">
							<div class="hp1">
								<b>￦${cdv.class_price}원</b> / 시간
							</div>
							<div class="tp1">￦${cdv.class_price*cdv.class_count*cdv.class_hour}/
								총 ${cdv.class_count}회 ${cdv.class_hour}시간</div>
						</div>
						<c:choose>
							<c:when test="${empty dlist}">
								<div class="btn_pay disabled" onclick="alert('신청가능한 수업이 없습니다');">
									수업 신청하기
								</div>
							</c:when>
							<c:otherwise>
								<div class="btn_pay" onclick="payAuth(${class_num })">
									수업 신청하기
								</div>
							</c:otherwise>
						</c:choose>
					</div>
				</div>
				<!-- //시간&날짜/ 결제창 -->
			</div>
		</div>
	</div>
</div>
<script>
	//카카오 지도 api
	var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
	mapOption = {
		center : new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
		level : 3, // 지도의 확대 레벨
		draggable: false
	};

	//지도를 생성합니다    
	var map = new kakao.maps.Map(mapContainer, mapOption);

	//주소-좌표 변환 객체를 생성합니다
	var geocoder = new kakao.maps.services.Geocoder();

	//주소로 좌표를 검색합니다
	geocoder.addressSearch('${cdv.class_address}',
	function(result, status) {
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
				content : '<div style="width:150px;text-align:center;padding:6px 0;">${cdv.class_address}</div>'
			});
				infowindow.open(map, marker);
				// 지도의 중심을 결과값으로 받은 위치로 이동시킵니다 
				map.setCenter(coords);
		}
	});
</script>