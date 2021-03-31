<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="${cp }/resources/favicon/favicon.ico">
<title>AllChwi!_Community</title>
<!-- Bootstrap core JavaScript-->
<script src="${cp}/resources/vendor/jquery/jquery.min.js"></script>
<script
	src="${cp}/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Core plugin JavaScript-->
<script src="${cp}/resources/vendor/jquery-easing/jquery.easing.min.js"></script>

<!-- Custom scripts for all pages-->
<script src="${cp}/resources/js/sb-admin-2.min.js"></script>
<!-- Custom fonts for admin template-->
<link href="${cp}/resources/vendor/fontawesome-free/css/all.min.css"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for admin template-->
<link href="${cp}/resources/css/sb-admin-2.min.css" rel="stylesheet">
<style>
a,span{
	color: inherit;
	font-size: inherit;
	font-weight: inherit;
	line-height: inherit;
	text-decoration: none;
}

a:hover  {
	color: inherit;
	text-decoration: none;
}
li {
	list-style: none;
}

</style>
</head>

<body id="page-top">
	<!-- Page Wrapper -->
	<div id="wrapper">
		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">
			<!-- Main Content -->
			<div id="content">
				<!-- 헤더 -->
				<div id="header">
					<tiles:insertAttribute name="header" />
				</div>
				<!-- 메인 -->
				<div class="container-fluid" style="width: 80%">
					<div id="body">
						<tiles:insertAttribute name="body" />
					</div>

				</div>
			</div>
			<!-- 메인 끝 -->

			<!-- Footer -->
			<footer class="sticky-footer bg-white">
				<div class="container my-auto">
					<div class="copyright text-center my-auto">
						<div id="footer">
							<tiles:insertAttribute name="footer" />
						</div>
					</div>
				</div>
			</footer>
			<!-- End of Footer -->
		</div>
		<!-- End of Content Wrapper -->
	</div>
	<!-- End of Page Wrapper -->

</body>
</html>