<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta content="charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>신청서</title>
</head>
<body>
	<div id="myModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header" style="background-color: #8599ff">
					<h4 class="modal-title" style="color: #ffffff">수업신청서</h4>
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true" style="color: #ffffff">&times;</button>
				</div>
				<div class="modal-body">
					<form action="${cp}/myClass/classAcceptUpdate" method="post">
						<input type="hidden" name="apply_num" value="${cav.apply_num}">
						<input type="hidden" id="date_num" value="${cav.date_num}">
						<input type="hidden" id="ml_num" value="${cav.ml_num}">
						<!--a 신청자 스킬 레벨 choose 사용하여 조건 걸어줌 -->
						<div class="form-group">
							<label for="stu_lev" class="control-label">나의 스킬 레벨</label>
							<c:choose>
								<c:when test="${cav.stu_lev eq '1'}">
									<input type="text" class="form-control" id="stu_lev"
									 value="입문자" readonly>
								</c:when>
								<c:when test="${cav.stu_lev eq '2'}">
									<input type="text" class="form-control" id="stu_lev"
									 value="초/중급자" readonly>							
								</c:when>
								<c:otherwise>
									<input type="text" class="form-control" id="stu_lev"
									 value="상급자" readonly>	
								</c:otherwise>
							</c:choose>
						</div>
						<div class="form-group">
							<label for="stu_msg" class="control-label">튜터에게 전할 말</label>
							<textarea class="form-control" id="stu_msg" readonly
								style="resize: none">${cav.stu_msg}</textarea>
						</div>
						<div class="form-group">
							<label for="stu_phone" class="control-label">전화번호</label> <input
								type="text" class="form-control" id="stu_phone"
								value="${cav.stu_phone}" readonly>
						</div>
						<!-- 전화번호 형식 변경하여 출력 -->
						<div class="form-group">
							<label for="apply_regdate" class="control-label">신청일자</label> <input
								type="text" class="form-control" id="apply_regdate"
								value="<fmt:formatDate value="${cav.apply_regdate}" pattern="yyyy-MM-dd HH:mm:ss"/>" readonly>
						</div>
						<div style="float: right;">
							<input type="submit" class="btn btn-primary" value="승인" style="margin-right: 10px;">
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