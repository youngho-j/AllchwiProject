<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<style>
.star_rating {
	font-size: 0;
	letter-spacing: -4px;
	text-align: center;
}
.star_rating span{
	font-size: 16px;
	font-weight: bold;
	margin-right: 20px;
}
.star_rating a {
	font-size: 30px;
	letter-spacing: 0;
	display: inline-block;
	margin-left: 5px;
	color: #ccc;
	text-decoration: none;
}

.star_rating a:first-child {
	margin-left: 0;
}

.star_rating a.on {
	color: #ff936f;
}
.modal-footer {
	background-color: #ff936f;
	color: white;
}

</style>
<!-- 리뷰작성 모달 -->
<div id="myModal" class="modal fade" id="modalContactForm" tabindex="-1"
	role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header text-center">
				<h4 class="modal-title w-100 font-weight-bold">review</h4>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body mx-3">
				<div class="md-form mb-5">
					<p class="star_rating" id="curr_rating">
						<span>커리큘럼</span> <a href="#" class="on">★</a> <a href="#"
							class="on">★</a> <a href="#" class="on">★</a> <a href="#">★</a> <a
							href="#">★</a>
					</p>
					<p class="star_rating" id="ready_rating">
						<span>준비성</span> <a href="#" class="on">★</a> <a href="#"
							class="on">★</a> <a href="#" class="on">★</a> <a href="#">★</a> <a
							href="#">★</a>
					</p>
					<p class="star_rating" id="kind_rating">
						<span>친절도</span> <a href="#" class="on">★</a> <a href="#"
							class="on">★</a> <a href="#" class="on">★</a> <a href="#">★</a> <a
							href="#">★</a>
					</p>
  
					<p class="star_rating" id="time_rating">
						<span>시간준수</span> <a href="#" class="on">★</a> <a href="#"
							class="on">★</a> <a href="#" class="on">★</a> <a href="#">★</a> <a
							href="#">★</a>
					</p>

				</div>
				<label>리뷰작성</label>
				<div class="md-form">
					<textarea type="text" id="review_content" class="md-textarea form-control" rows="4"></textarea>
				</div>
			</div>
			<div class="modal-footer d-flex justify-content-center">
				<a href="javascript:void(0);" id="btn_write_review" class="btn_send">작성완료</a>
			</div>
		</div>
	</div>
</div>
<script>
$(document).on('click', '#btn_write_review', function () {
	var review_content = $('#review_content').val();
	var class_num = '${class_num}';
	var ml_num = '${ml_num}';
	var curr_rating = $("#curr_rating a.on").length;
	var ready_rating = $("#ready_rating a.on").length;
	var kind_rating = $("#kind_rating a.on").length;
	var time_rating = $("#time_rating a.on").length;
	if(review_content== '' ){
		alert('내용을 작성해주세요');
	}else{
		if (ml_num=='') {
			alert('로그인이 필요합니다');
		}else {
			$.post('${cp }/classDetail/insertreview', {
				class_num: class_num,
				ml_num: ml_num,
				curr_rating:curr_rating,
				ready_rating:ready_rating,
				kind_rating:kind_rating,
				time_rating:time_rating,
				review_content:review_content
			}, function (data,res) {
				if (res=='success') {
					alert('리뷰등록 성공');
					$('#myModal').modal('hide');
				} else {				
					alert('등록실패');
				}
			});
		}
	}
	
});
	$(".star_rating a").click(function() {
		$(this).parent().children("a").removeClass("on");
		$(this).addClass("on").prevAll("a").addClass("on");
		return false;
	});
</script>
<!-- 리뷰작성 모달 -->