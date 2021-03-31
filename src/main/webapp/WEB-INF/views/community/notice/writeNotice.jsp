<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta content="charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title></title>
</head>
<body>
	<div id="writeNotice" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header" style="background-color: #ff936f">
					<h4 class="modal-title" style="color: #fff">공지사항 작성</h4>
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true" style="color: #fff">&times;</button>
				</div>
				<div class="modal-body">
					<form action="${cp}/community/notice/insertNotice" method="post">
						<input type="hidden" name="commu_num" value="${commu.commu_num}">
						<input type="hidden" name="class_num" value="${commu.class_num}">
						<div class="form-group">
							<label for="notice_title" class="control-label">제    목</label> 
							<input type="text" class="form-control" name="notice_title">
						</div>
						<div class="form-group">
							<label for="notice_content" class="control-label">내    용</label>
							<textarea class="form-control" name="notice_content"
								style="resize: none" rows="12"></textarea>
						</div>
						<div style="float: right;">
							<input type="submit" class="btn btn-primary" value="작성" style="margin-right: 10px;">
							<button type="button" class="btn btn-danger"
								data-dismiss="modal">닫기</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>