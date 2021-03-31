<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<style>
.card {
	width: 440px;
	background: white;
}

.remote {
	width: 100%;
    background: whitesmoke;
}

.roundImg {
	width: 200px;
	height: 200px;
	border-radius: 50%;
}

.info {
	line-height: 150%;
	margin-top: 20px;
}

.info ul li {
	width: 140px;
	text-align: center;
	float: left;
	padding-top: 50px;
	list-style: none;
}

.btn_wishlist img {
	width: 20px;
}

.info ul li.ar {
	background:
		url(https://user-images.githubusercontent.com/65140754/86689111-a9a82e00-c041-11ea-8aea-c02eb0d1bfd2.png)
		center top no-repeat;
}

.info ul li.hu {
	background:
		url(https://user-images.githubusercontent.com/65140754/86689750-3fdc5400-c042-11ea-87f2-fe8364438ff3.png)
		center top no-repeat;
}

.info ul li.gr {
	background:
		url(https://user-images.githubusercontent.com/65140754/86689737-3c48cd00-c042-11ea-95b3-593fb577963b.png)
		center top no-repeat;
}

.info ul li.ohu {
	background:
		url(https://user-images.githubusercontent.com/65140754/86689728-3b17a000-c042-11ea-9861-55fe8f7cd520.png)
		center top no-repeat;
}

#container_detail {
	width: 100%;
	padding: 50px 0 50px 0;
	letter-spacing: 0;
}

.class_wrap {
	float: left;
	background: whitesmoke;
	padding: 0 80px 0 80px;
}

#container_detail .class_navi {
	background: white;
	color: gray;
	z-index: 1;
	border-bottom: 1px solid #999;
}

#container_detail .class_navi ul li a.on {
	color: #ff936f;
	font-weight: bold;
	font-size: 20px;
	border-bottom: 2px solid #ff936f;
}

#container_detail .class_navi ul li {
	width: 180px;
	display: inline-block;
	text-align: center;
	font-size: 20px;
	padding: 20px 0 20px 0;
}

li {
	list-style: none;
}

.btn_wishlist {
	padding: 10px 12px;
	border-radius: 10px;
	background-color: #ff936f;
	float: right;
	color: white;
	margin-top: 9px;
}

.btn_pay {
	padding: 10px 160px;
	border-radius: 10px;
	background-color: #7185bb;
	margin-top: 9px;
	font-size: 30px;
	color: white;
}

a, span {
	color: inherit;
	font-size: inherit;
	font-weight: inherit;
	line-height: inherit;
	text-decoration: none;
}
</style>
<div class="container-fluid" id="container_detail">
	<div class="row">
		<div class="col-md-12">
			<div class="row">
				<div class="col-md-8">
					<!-- carousel -->
					<div class="carousel slide" id="carousel">
						<ol class="carousel-indicators">
							<li data-slide-to="0" data-target="#carousel"></li>
							<li data-slide-to="1" data-target="#carousel"></li>
							<li data-slide-to="2" data-target="#carousel" class="active">
							</li>
						</ol>
						<div class="carousel-inner">
							<div class="carousel-item">
								<img class="d-block w-100" alt="Carousel1"
									src="${cp}/resources/img/수업소개이미지_1.png" />
							</div>
							<div class="carousel-item">
								<img class="d-block w-100" alt="Carousel2"
									src="${cp}/resources/img/수업소개이미지_2.png" />
							</div>
							<div class="carousel-item active">
								<img class="d-block w-100" alt="Carousel3"
									src="${cp}/resources/img/수업소개이미지_3.png" />
							</div>
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
					</div>
					<!-- //carousel -->
					
					<!-- class_navi -->
					<div id="class_navi" class="class_navi">
						<ul style="margin: 0">
							<li><a href="#sumary" class="on" id="sli">요약</a></li>
							<li><a href="#tutor" id="tli" class="">튜터</a></li>
							<li><a href="#Introduction" id="ili" class="">수업소개</a></li>
							<li><a href="#review" id="rli" class="">리뷰</a></li>
							<li><a href="#qna" id="qli" class="">문의</a></li>
						</ul>
					</div>
					<!-- class wrap -->
					<div class="class_wrap">
						<!--class_navi 내용  -->
						<!-- 1.요약 -->
						<div class="class_detail" id="sumary">
							<img alt="tutorprofile" class="roundImg" src="${cp}/resources/img/모찌.jpg" />
							<!-- 수업명 -->
							<span>
								<h3>정모찌의 실전산책</h3>
								<h3>모찌에게 배우는 진짜 산책</h3>
							</span>
							<!-- 별점 -->
							<div class="info">
								<a class="starimg"> <img
									src="https://user-images.githubusercontent.com/65140754/86704557-f98df180-c04f-11ea-98d7-6ef52adba462.png">
									<img
									src="https://user-images.githubusercontent.com/65140754/86704557-f98df180-c04f-11ea-98d7-6ef52adba462.png">
									<img
									src="https://user-images.githubusercontent.com/65140754/86704557-f98df180-c04f-11ea-98d7-6ef52adba462.png">
									<img
									src="https://user-images.githubusercontent.com/65140754/86704557-f98df180-c04f-11ea-98d7-6ef52adba462.png">
									<img
									src="https://user-images.githubusercontent.com/65140754/86704557-f98df180-c04f-11ea-98d7-6ef52adba462.png">
									(리뷰갯수)
								</a>
								<!-- 찜하기 -->
								<a href="#" class="btn_wishlist"> <!-- 예스찜 --> <img
									src="https://user-images.githubusercontent.com/65140754/86716818-8474e900-c05c-11ea-8c48-5764f4d57b28.png">
									<!-- 노찜 
												<img src="https://user-images.githubusercontent.com/65140754/86717485-2e547580-c05d-11ea-9dcf-27e47ad3f8e2.png">
												--> 찜하기
								</a>

								<!-- 기본정보 -->
								<div class="info">
									<ul>
										<li class="ar" id="regionAll">온라인</li>
										<li class="hu"><font color="#ff936f">3</font>시간/회</li>
										<li class="gr">최대인원:<font color="#ff936f">2~50</font>명
										</li>
										<li class="ohu"><font color="#ff936f">￦10,000</font>/시간</li>
									</ul>
								</div>
							</div>

						</div>
						<!-- 튜터소개 -->
						<div class="class_detail detail_sec_bor" id="tutorinfo">
							<div class="section01" id="tutor">
								<h1>튜터정보</h1>
								<div class="cert">
									<ul>
										<li class="com">숙명여자대학교 미디어학부</li>


										<li class="com">신분 인증 됨</li>


									</ul>
								</div>
								<div class="d_info04">

									안녕하세요! 빈피디입니다.<br> 저는 MCN 회사 비디오빌리지에서 빈피디로 활약하며<br>
									3만 구독자 채널이었던 &lt;걸스빌리지&gt; 채널을 50만 구독자 채널로 키워내고,<br> 신규
									채널이었던 &lt;스튜디오V&gt;를 3달 만에 10만 구독자 채널로 성장시켰습니다.<br> 또한
									여행박사에서는 다양한 트렌지션을 활용한 여행 콘텐츠를 제작하였습니다.<br> <br> 그간의
									노하우를 바탕으로 여러분들에게<br> 3시간 동안 쉽고 친절하게 프리미어 속성 과외를 해드리겠습니다!<br>
									소규모로 진행할 예정이기 때문에 궁금해 하시는 모든 것들을 옆에서 바로바로 알려드릴게요.<br> ★★최대
									2인 과외로 진행★★<br> <br> &lt;경력&gt;<br> - 2015~2018
									비디오빌리지 걸스빌리지, 스튜디오V PD<br> - 2018~2020 여행박사 영상 콘텐츠 제작 감독<br>
									- 2020~ 현재 브랜드사 유튜브 채널 담당 <br> <br> *2019 시청자미디어재단
									인천센터 &lt;크리에이터 되기&gt;, &lt;미디어로 바로 보는 세상&gt; 강연
								</div>
							</div>
						</div>

						<!-- 수업소개 -->
						<div class="class_detail detail_sec_bor" id="Introduction">
							<div class="section01">
								<h1>수업소개</h1>
								<div class="d_info04">
									♥ ♥ 프리미어 초보들에게 3시간만에 마법을 선사해드립니다.♥ ♥ <br> <br> 처음에
									켜자마자 잔뜩 겁을 먹게 되는 프리미어 패널들<br> 3시간 수업을 들은 이후에는 프리미어 작업환경이
									재밌게만 느껴지실 거예요.<br> <br> 3시간 동안 영상가져오기, 컷편집, 자막 삽입, 자막
									효과, 화면 전환, 효과음 삽입, BGM삽입, 영상 뽑는 방법 모두 알려드립니다.<br> 처음 프리미어를
									접하는 기초생분들에게 딱인 수업이죠. <br> 예능에서만 보던 효과들 이제 나도 할 수 있다! <br>
									실전으로 영상을 편집할 때 꼭 필요한 것부터 쏙쏙 알려드릴테니<br> 부담갖지 말고 신청해주세요!
								</div>
							</div>
						</div>
						<!-- 리뷰 -->
						<div class="class_detail detail_sec_bor" id="review">
							<div class="section01">
								<h1>리뷰(2)</h1>
								<a class="btn_st" id="btn-write-review">리뷰쓰기</a>
								<div class="review_box">
									<img
										src="https://front-img.taling.me/Content/Images/class/icon_star.png">
									<img
										src="https://front-img.taling.me/Content/Images/class/icon_star.png">
									<img
										src="https://front-img.taling.me/Content/Images/class/icon_star.png">
									<img
										src="https://front-img.taling.me/Content/Images/class/icon_star.png">
									<img
										src="https://front-img.taling.me/Content/Images/class/icon_star.png">
									5.0
								</div>

								<div class="review_count01">
									<ul>
										<li>커리큘럼 <img
											src="https://front-img.taling.me/Content/Images/class/icon_star.png">
											<img
											src="https://front-img.taling.me/Content/Images/class/icon_star.png">
											<img
											src="https://front-img.taling.me/Content/Images/class/icon_star.png">
											<img
											src="https://front-img.taling.me/Content/Images/class/icon_star.png">
											<img
											src="https://front-img.taling.me/Content/Images/class/icon_star.png">
										</li>
										<li>전달력 <img
											src="https://front-img.taling.me/Content/Images/class/icon_star.png">
											<img
											src="https://front-img.taling.me/Content/Images/class/icon_star.png">
											<img
											src="https://front-img.taling.me/Content/Images/class/icon_star.png">
											<img
											src="https://front-img.taling.me/Content/Images/class/icon_star.png">
											<img
											src="https://front-img.taling.me/Content/Images/class/icon_star.png">
										</li>
										<li>준비성 <img
											src="https://front-img.taling.me/Content/Images/class/icon_star.png">
											<img
											src="https://front-img.taling.me/Content/Images/class/icon_star.png">
											<img
											src="https://front-img.taling.me/Content/Images/class/icon_star.png">
											<img
											src="https://front-img.taling.me/Content/Images/class/icon_star.png">
											<img
											src="https://front-img.taling.me/Content/Images/class/icon_star.png">
										</li>
										<li>친절도 <img
											src="https://front-img.taling.me/Content/Images/class/icon_star.png">
											<img
											src="https://front-img.taling.me/Content/Images/class/icon_star.png">
											<img
											src="https://front-img.taling.me/Content/Images/class/icon_star.png">
											<img
											src="https://front-img.taling.me/Content/Images/class/icon_star.png">
											<img
											src="https://front-img.taling.me/Content/Images/class/icon_star.png">
										</li>
										<li>시간준수 <img
											src="https://front-img.taling.me/Content/Images/class/icon_star.png">
											<img
											src="https://front-img.taling.me/Content/Images/class/icon_star.png">
											<img
											src="https://front-img.taling.me/Content/Images/class/icon_star.png">
											<img
											src="https://front-img.taling.me/Content/Images/class/icon_star.png">
											<img
											src="https://front-img.taling.me/Content/Images/class/icon_star.png">
										</li>
									</ul>
								</div>
							</div>
						</div>
						<div class="class_detail detail_sec_bor" id="qna">
							<p>
								수업과 관련해서<br>궁금한 점이 있으세요?
							</p>
						</div>
					</div>
				</div>

				<!--// class wrap -->
				<!-- 시간&날짜/ 결제창 -->
				<div class="col-md-4 remote">
					<div class="row">
						<div class="col-md-12">
							<div id="card">
								<div class="card">
									<div class="card-header">
										<a class="collapsed card-link" data-toggle="collapse"
											data-parent="#card-1" href="#card-element-1">
											07.08(수)14:00~16:00 강남</a>
									</div>
									<div id="card-element-1" class="collapse show">
										<div class="card-body">상세장소 : 강사 공방</div>
									</div>
								</div>
								<div class="card">
									<div class="card-header">
										<a class="collapsed card-link" data-toggle="collapse"
											data-parent="#card-2" href="#card-element-2">
											07.08(수)14:00~16:00 강남</a>
									</div>
									<div id="card-element-2" class="collapse">
										<div class="card-body">상세장소 : 강사 공방</div>
									</div>
								</div>
							</div>
							<dl>
								<dt>강사한마디</dt>
								<dd>잘부탁드립니다</dd>

							</dl>
							<a href="#" class="btn_pay">결제하기</a>
						</div>
					</div>
				</div>
				<!-- //시간&날짜/ 결제창 -->
			</div>
		</div>
	</div>
</div>

<script>
	$(document).ready(function() {
		// Add smooth scrolling to all links in navbar + footer link
		$(".navbar a, footer a[href='#myPage']").on('click', function(event) {
			// Make sure this.hash has a value before overriding default behavior
			if (this.hash !== "") {
				// Prevent default anchor click behavior
				event.preventDefault();

				// Store hash
				var hash = this.hash;

				// Using jQuery's animate() method to add smooth page scroll
				// The optional number (900) specifies the number of milliseconds it takes to scroll to the specified area
				$('html, body').animate({
					scrollTop : $(hash).offset().top
				}, 900, function() {

					// Add hash (#) to URL when done scrolling (default click behavior)
					window.location.hash = hash;
				});
			} // End if
		});

		$(window).scroll(function() {
			$(".slideanim").each(function() {
				var pos = $(this).offset().top;

				var winTop = $(window).scrollTop();
				if (pos < winTop + 600) {
					$(this).addClass("slide");
				}
			});
		});
	})
</script>
