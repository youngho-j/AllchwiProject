<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript" src="${cp }/resources/js/jquery-3.5.1.js"></script>
<script type="text/javascript"
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=74ead0f99ba4773dfee212b68149ffb7&libraries=services"></script>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>클래스 리스트</title>

<!-- Custom fonts for this template-->
<link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet"
	type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template-->
<link href="css/sb-admin-2.min.css" rel="stylesheet">
<style type="text/css">
.btnRight {
	float: right;
	margin-left: 10px;
}
</style>
</head>


<div id="content-wrapper" class="d-flex flex-column"
	style="height: 800px;">
	<div id="content" class="container-fluid">

		<div class="breadcrumb">
			<h2>미등록 수업 심사</h2>
			<div style="margin-left: 65%;">
				<form action="${cp }/admin/confirmClass" class="form-inline"
					style="display: inline-block">
					<select class="form-control col-2" name="field"
						style="display: inline-block; width: 700px;">
						<option value="class_title"
							<c:if test="${field == 'class_title'}">selected</c:if>>수업제목</option>
						<option value="tutor_nickname"
							<c:if test="${field == 'tutor_nickname'}">selected</c:if>>강사이름</option>
						<option value="class_address"
							<c:if test="${field == 'class_address'}">selected</c:if>>장소</option>
					</select> <input class="form-control mr-sm-2" type="text" name="keyword" />
					<button class="btn btn-primary my-2 my-sm-0" type="submit">검색</button>
				</form>
			</div>
		</div>


		<!-- Begin Page Content -->
		<div style="float: center;">
			<c:choose>
				<c:when test="${list.size()>0 }">
					<c:forEach var="vo" items="${list }">
						<div class="row" style="width: 600px; display: inline-block; float: left; margin-left: 40px; margin-bottom: 20px;">
							<div class="col-md-12">
								<div class="card">
									<h5 class="card-header" style="text-align: center;">
										${vo.class_title }
										<button type="button" class="btn btn-primary" onclick="getDetail('${vo.class_num}')" data-toggle="modal" data-target="#myModal3">상세정보</button>	
									</h5>

									<div class="card-body" style="height: 188px;">
										<div style="display: inline-block;">
											<img src="${cp }/classImg/getimg?cover_num=${vo.cover_num }"
												style="width: 160px; height: 173px; margin-top: -130px;">
										</div>
										<div style="display: inline-block; margin-left: 60px;">
											<p>강사명: ${vo.tutor_nickname }</p>
											<p>장소: ${vo.class_address }</p>
											<p>신청인원: ${vo.people }명 / 위시인원: ${vo.wish_count }명</p>
											<a href="#" class="btn btn-success btn-icon-split"
												onclick="getModal('${vo.class_num}')" data-toggle="modal"
												data-target="#myModal"> <span class="icon text-white-50">
													<i class="fas fa-check"></i>
											</span> <span class="text">심사완료</span>
											</a> <a href="#" class="btn btn-danger btn-icon-split"
												onclick="getModal2('${vo.class_num}','${vo.id }')"
												data-toggle="modal" data-target="#myModal2"> <span
												class="icon text-white-50"> <i
													class="fas fa-exclamation-triangle"></i></span> <span class="text">심사반려</span>
											</a>
										</div>
									</div>
								</div>
							</div>
						</div>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<div style="text-align: center">검색 결과가 없습니다.</div>
				</c:otherwise>
			</c:choose>
		</div>



	</div>
	<div>
		<ul class="pagination justify-content-center" style="margin: 20px 0">
			<c:choose>
				<c:when test="${pu.startPageNum>1 }">
					<li class="page-item"><a class="page-link"
						href="${cp }/admin/confirmClass?pageNum=${pu.startPageNum-1 }&field=${field}&keyword=${keyword}">이전</a></li>
				</c:when>
				<c:otherwise>
					<li class="page-item disabled"><a class="page-link" href="#">이전</a></li>
				</c:otherwise>
			</c:choose>



			<c:forEach var="i" begin="${pu.startPageNum}" end="${pu.endPageNum }">
				<c:choose>
					<c:when test="${pu.pageNum==i}">
						<li class="page-item active"><a class="page-link"
							href="${cp }/admin/confirmClass?pageNum=${i }&field=${field}&keyword=${keyword}">${i }</a></li>
					</c:when>
					<c:otherwise>
						<li class="page-item"><a class="page-link"
							href="${cp }/admin/confirmClass?pageNum=${i }&field=${field}&keyword=${keyword}">${i }</a></li>
					</c:otherwise>
				</c:choose>
			</c:forEach>




			<c:choose>
				<c:when test="${pu.totalPageCount>pu.endPageNum }">
					<li class="page-item"><a class="page-link"
						href="${cp }/admin/confirmClass?pageNum=${pu.endPageNum+1 }&field=${field}&keyword=${keyword}">다음</a></li>
				</c:when>
				<c:otherwise>
					<li class="page-item disabled"><a class="page-link" href="#">다음</a></li>
				</c:otherwise>
			</c:choose>
		</ul>
	</div>


</div>
<!-- End of Page Wrapper -->

<!-- Scroll to Top Button-->
<a class="scroll-to-top rounded" href="#page-top"> <i
	class="fas fa-angle-up"></i>
</a>

<!-- The Modal -->
<div class="modal" id="myModal">
	<div class="modal-dialog">
		<div class="modal-content">

			<!-- Modal Header -->
			<div class="modal-header">
				<h4 class="modal-title">수업심사</h4>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>

			<!-- Modal body -->
			<div class="modal-body" id="modal-body">해당 수업을 승인 하시겠습니까?</div>

			<!-- Modal footer -->
			<div class="modal-footer" id="modal-footer">
				<button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
			</div>
		</div>
	</div>
</div>



<!-- 수업 거절 모달-->
<div class="modal" id="myModal2">
	<div class="modal-dialog">
		<div class="modal-content">

			<!-- Modal Header -->
			<div class="modal-header">
				<h4 class="modal-title">수업 반려</h4>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>

			<!-- Modal body -->
			<div class="modal-body" id="modal-body2">거절</div>
		</div>
	</div>
</div>


<!-- 수업디테일 모달 -->
<div class="modal" id="myModal3">
  <div class="modal-dialog modal-xl">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title" style="text-align: center ">수업 세부내용</h4>
        <button type="button" class="close" data-dismiss="modal">&times;</button>
      </div>

      <!-- Modal body -->
      <div class="modal-body" id="class_detail">
        Modal body..
      </div>

      <!-- Modal footer -->
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-dismiss="modal">닫기</button>
      </div>

    </div>
  </div>
</div>







<script>
	//class_num을 받아 새화면에 수업정보 띄우는 모달 (ajax통신으로 화면단 불러옴)
	function getDetail(class_num){
		$.ajax({
			url:"${cp}/admin/classDetail",
			data: {class_num:class_num},
			dataType:"text",
			success:function(data){
				$("#class_detail").html(data);	//id에 화면 띄워줌
				
				//모달 생성시 css깨지는거 수정
				$(".card-body").find("img").css("margin-top","0px")
				$(".card-body").css("height","230px")
				
				$(".card-body").find("img").css("margin-top", "-130px");
				$(".card-body").css("height", "188px");
				$(".card").css("width", "100%");
			}
		});
	}

	function getModal(class_num) {
		$("#modal-footer").empty();

		$("#modal-footer")
				.append(
						"<button type='button' class='btn btn-success' data-dismiss='modal' onclick=accept('"
								+ class_num + "')>네</button>");

		$("#modal-footer")
				.append(
						"<button type='button' class='btn btn-danger' data-dismiss='modal'>아니오</button>")

	}
	function accept(class_num) {
		location.href = "${cp}/admin/acceptClass?class_num=" + class_num;
	}

	function getModal2(class_num, id) {

		$("#modal-body2").empty();

		var modalForm = $("<form action='${cp}/admin/denyClass'/>").appendTo(
				"#modal-body2");
		$(modalForm)
				.append(
						"<textarea rows='5' cols='50' id='msg' placeholder='거절 사유를 입력해주세요. 메일로 전송됩니다.' style='outline:none; border:none; resize:none'></textarea>");
		$(modalForm).append("<input type='hidden' name='id' value='"+id+"'>");
		$(modalForm).append("<hr>");
		$(modalForm)
				.append(
						"<button type='button' class='btn btn-danger btnRight' data-dismiss='modal'>닫기</button>");
		$(modalForm).append(
				"<input type='submit' class='btn btn-success btnRight' onclick=\"deny('"+ class_num + "','"+id+"')\" value='심사 반려'>");

	}
	function deny(class_num,id) {
		var msg = $("#msg").val();
		location.href = "${cp}/admin/denyClass?class_num=" + class_num+"&id="+id+ "&msg="+msg;
	}
</script>





