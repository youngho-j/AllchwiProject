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
	<div id="updateNotice" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header" style="background-color: #ff936f">
					<h4 class="modal-title" style="color: #fff">공지사항 수정</h4>
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true" style="color: #fff">&times;</button>
				</div>
				<div class="modal-body">
					<form action="${cp}/community/notice/updateOkNotice" method="post">
						<input type="hidden" name="notice_num" value="${ntv.notice_num}">
						<div class="form-group">
							<label for="notice_regdate" class="control-label">작 성 일</label> 
							<input type="text" class="form-control" readonly value="<fmt:formatDate value="${ntv.notice_regdate}"
						pattern="yyyy-MM-dd HH:mm" />">
						</div>
						<div class="form-group">
							<label for="notice_title" class="control-label">제    목</label> 
							<input type="text" class="form-control" name="notice_title" value="${ntv.notice_title}">
						</div>
						<div class="form-group">
							<label for="notice_content" class="control-label">내    용</label>
							<textarea class="form-control" name="notice_content"
								style="resize: none" rows="12">${ntv.notice_content}</textarea>
						</div>
						<div style="float: right;">
							<input type="submit" class="btn btn-primary" value="수정" style="margin-right: 10px;">
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