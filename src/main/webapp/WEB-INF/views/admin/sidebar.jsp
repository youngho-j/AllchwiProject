<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<style>
.btn-primary {
	color: #fff;
	background-color: #7185bb !important;
	border-color: #7185bb !important;
}

.bg-gradient-primary {
	background-color: #7185bb !important;
	background-image: none !important;
	background-size: cover;
}
</style>

<!-- Custom fonts for this template-->
<link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet"
	type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template-->
<link href="css/sb-admin-2.min.css" rel="stylesheet">

</head>

<body id="page-top">
	<!-- Page Wrapper -->
	<div id="wrapper">

		<!-- Sidebar -->
		<ul
			class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion"
			id="accordionSidebar">

			<!-- Sidebar - Brand -->
			<a class="sidebar-brand d-flex align-items-center justify-content-center"
				href="${cp }/admin/main">
				<div class="sidebar-brand-icon rotate-n-15">
					<i class="fas fa-fw fa-calculator"></i>
				</div>
				<div class="sidebar-brand-text mx-3">관리자페이지</div>
			</a>

			<!-- Divider -->
			<hr class="sidebar-divider my-0">


			<li class="nav-item active"><a class="nav-link"
				href="${cp }/admin/category"> <i
					class="far fa-fw fa-plus-square"></i> <span>카테고리추가</span></a></li>


			<li class="nav-item active"><a class="nav-link"
				href="${cp }/admin/memberlist"> <i
					class="fas fa-fw fa-clipboard-list"></i> <span>회원리스트</span></a></li>



			<!-- Nav Item - Pages Collapse Menu -->
			<li class="nav-item"><a class="nav-link collapsed" href="#"
				data-toggle="collapse" data-target="#collapseTwo"
				aria-expanded="true" aria-controls="collapseTwo"> <i
					class="fas fa-fw fa-chalkboard-teacher"></i> <span>수업관리</span>
			</a>
				<div id="collapseTwo" class="collapse" aria-labelledby="headingTwo"
					data-parent="#accordionSidebar">
					<div class="bg-white py-2 collapse-inner rounded">
						<h6 class="collapse-header">리스트:</h6>
						<a class="collapse-item" href="${cp }/admin/confirmClass">미등록
							수업 심사</a> <a class="collapse-item" href="${cp }/admin/manageClass">수업
							리스트</a>
					</div>
				</div></li>



			<!-- Divider -->
			<hr class="sidebar-divider">


			<li class="nav-item active"><a class="nav-link"
				href="${cp }/admin/payment"> <i
					class="fa fa-credit-card" aria-hidden="true"></i> <span>회원결제내역</span></a></li>


			<li class="nav-item active"><a class="nav-link"
				href="${cp }/admin/remit"> <i class="fas fa-fw fa-handshake"></i>
					<span>송금승인신청</span></a></li>


			<li class="nav-item active"><a class="nav-link"
				href="${cp }/admin/statistic1"> <i
					class="fas fa-fw fa-chart-pie"></i> <span>통계</span></a></li>


			<li class="nav-item active"><a class="nav-link"
				href="${cp }/admin/changePics"> <i
					class="far fa-image"></i> <span>배너 바꾸기</span></a></li>


			<!-- Sidebar Toggler (Sidebar) -->
			<div class="text-center d-none d-md-inline">
				<button class="rounded-circle border-0" id="sidebarToggle"></button>
			</div>

		</ul>
		<!-- End of Sidebar -->




	</div>
	<!-- End of Content Wrapper -->



	<!-- Scroll to Top Button-->
	<a class="scroll-to-top rounded" href="#page-top"> <i
		class="fas fa-angle-up"></i>
	</a>



</body>
</html>

