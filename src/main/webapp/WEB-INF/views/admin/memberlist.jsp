<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>SB Admin 2 - Tables</title>
<script type="text/javascript" src="${cp }/resources/js/jquery-3.5.1.js"></script>

<!-- Custom fonts for this template -->
<link href="${cp }/resources/vendor/fontawesome-free/css/all.min.css"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${cp }/resources/css/sb-admin-2.min.css" rel="stylesheet">

<!-- Custom styles for this page -->
<link
	href="${cp }/resources/vendor/datatables/dataTables.bootstrap4.min.css"
	rel="stylesheet">

</head>



<!-- Page Wrapper -->
<div id="wrapper">
	<!-- Content Wrapper -->
	<div id="content-wrapper" class="d-flex flex-column">

		<!-- Main Content -->
		<div id="content">

			<!-- Begin Page Content -->
			<div class="container-fluid">

				<!-- Page Heading -->
				<h1 class="h3 mb-2 text-gray-800">회원관리</h1>


				<!-- DataTales Example -->
				<div class="card shadow mb-4">
					<div class="card-header py-3">
						<h6 class="m-0 font-weight-bold text-primary">회원리스트</h6>
					</div>
					<div class="card-body">
						<div class="table-responsive">
							<table class="table table-bordered table-hover" id="dataTable" width="100%" cellspacing="0">
								<thead class="thead-dark">
									<tr>
										<th>회원코드</th>
										<th>이름</th>
										<th>아이디</th>
										<th>등록일</th>
										<th>수강중인 클래스</th>
										<th>전체 클래스</th>
										<th>추방</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="vo" items="${list }">
										<tr>
											<td>${vo.ml_num}</td>
											<c:choose>
												<c:when test="${vo.mb_name==null}">
													<td>${vo.mb_nickname}</td>
												</c:when>
												<c:otherwise>
													<td>${vo.mb_name}</td>
												</c:otherwise>
											</c:choose>
											<td>${vo.id}</td>
											<td><fmt:formatDate value="${vo.mb_regdate }" pattern="yyyy-MM-dd" /></td>
											<td>${vo.nowclass }개</td>
											<td>${vo.totclass }개</td>
											<td><c:choose>
													<c:when test="${vo.mb_auth == 1}">
														<button type="button" class="btn btn-dark"
															onclick="getModal('${vo.id}','${vo.ml_num }')"
															data-toggle="modal" data-target="#myModal" disabled>추방된
															회원</button>
													</c:when>
													<c:otherwise>
														<button type="button" class="btn btn-danger"
															onclick="getModal('${vo.id}','${vo.ml_num }')"
															data-toggle="modal" data-target="#myModal">추방</button>
													</c:otherwise>
												</c:choose></td>


										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>

			</div>
			<!-- /.container-fluid -->

		</div>
		<!-- End of Main Content -->


	</div>
	<!-- End of Content Wrapper -->

</div>
<!-- End of Page Wrapper -->

<!-- Scroll to Top Button-->
<a class="scroll-to-top rounded" href="#page-top"> <i
	class="fas fa-angle-up"></i>
</a>




<div class="modal" id="myModal">
	<div class="modal-dialog">
		<div class="modal-content">

			<!-- Modal Header -->
			<div class="modal-header">
				<h4 class="modal-title">회원 추방</h4>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>

			<!-- Modal body -->
			<div class="modal-body" id="modal-body"></div>

			<!-- Modal footer -->

			<div class="modal-footer">
				<!-- 
				<button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
				 -->
			</div>

		</div>
	</div>
</div>


<script type="text/javascript">
	function getModal(id, ml_num) {
		$("div [class='modal-footer']").empty();
		$("#modal-body").text(id + ml_num + "님 을 추방하시겠습니까?");

		$("div [class='modal-footer']")
				.append(
						"<button type='button' class='btn btn-success' data-dismiss='modal' onclick=del('"
								+ ml_num + "')>네</button>");

		$("div [class='modal-footer']")
				.append(
						"<button type='button' class='btn btn-danger' data-dismiss='modal'>아니오</button>")
	}

	function del(ml_num) {
		location.href = "${cp}/admin/memberlist/delete?ml_num=" + ml_num;
	}

	$(document).ready(function() {
		$('#dataTable').dataTable({
			"language" : {
				"info" : "전체  _PAGES_ 페이지 중 _PAGE_  ",
				"sSearch": "검색:",
				"sZeroRecords": "검색 결과가 없습니다.",
				"sLengthMenu": "_MENU_ 개씩 보여주기",
				"infoFiltered": "",
				"infoEmpty": "",
				
				"paginate": {
					 "previous": "이전",
					 "next": "다음"
				}				
				
			}
		});

				

	});
</script>



		

</body>
</html>






