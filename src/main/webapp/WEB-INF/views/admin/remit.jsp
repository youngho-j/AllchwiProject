<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script type="text/javascript" src="${cp }/resources/js/jquery-3.5.1.js"></script>

<div class="container-fluid">
	<div id="content-wrapper" class="d-flex flex-column">
		<div class="breadcrumb">
			<h2>송금승인신청</h2>
			<div style="margin-left: 65%;">
				<form action="${cp }/admin/remit" class="form-inline" style="display: inline-block">
					<select class="form-control col-2" name="field"
						style="display: inline-block; width: 700px;">
						<option value="tutor_nickname"
							<c:if test="${field == 'tutor_nickname'}">selected</c:if>>강사이름</option>
						<option value="class_title"
							<c:if test="${field == 'class_title'}">selected</c:if>>수업제목</option>
						<option value="ml_num" <c:if test="${field == 'ml_num'}">selected</c:if>>회원번호</option>
					</select> 
					<input class="form-control mr-sm-2" type="text" name="keyword" />
					<button class="btn btn-primary my-2 my-sm-0" type="submit">
						검색</button>
				</form>
			</div>
		</div>

		<table class="table table-hover table-bordered">
			<thead class="thead-dark">
				<tr>
					<th>회원번호</th>
					<th>강사이름</th>
					<th style="width:300px">수업제목</th>
					<th>신청금액</th>
					<th>은행명/계좌번호</th>
					<th>신청일</th>
					<th>신청상태</th>
					<th>송금 승인</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="vo" items="${list }">
					<tr>
						<td>${vo.ml_num}</td>
						<td>${vo.tutor_nickname}</td>
						<td>${vo.class_title}</td>
						<td><fmt:formatNumber value="${vo.rem_pay}" pattern="#,###" />원</td>
						<td>${vo.rem_bank} / ${vo.rem_account }</td>
						<td><fmt:formatDate value="${vo.rem_regdate }"
									pattern="yyyy-MM-dd" /></td>
						<c:choose>
							<c:when test="${vo.rem_status == 0}">
								<td>승인대기</td>
							</c:when>
							<c:otherwise>
								<td>승인완료 </td>
							</c:otherwise>
						</c:choose>
						
						<td><c:choose>
								<c:when test="${vo.rem_status == 0}">
									<button type="button" class="btn btn-success"
										data-toggle="modal" data-target="#myModal"
										onclick="getModal('${vo.pay_num}','${vo.tutor_nickname }','${vo.rem_pay }','${vo.class_title }','${vo.rem_revenue }')">승인</button>
								</c:when>
								<c:otherwise>
									<button type="button" class="btn btn-dark" disabled>승인 완료</button>
								</c:otherwise>
							</c:choose></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>


		<div>
			<ul class="pagination justify-content-center" style="margin: 20px 0">
				<c:choose>
					<c:when test="${pu.startPageNum>1 }">
						<li class="page-item"><a class="page-link"
							href="${cp }/admin/remit?pageNum=${pu.startPageNum-1 }&field=${field}&keyword=${keyword}">이전</a></li>
					</c:when>
					<c:otherwise>
						<li class="page-item disabled"><a class="page-link" href="#">이전</a></li>
					</c:otherwise>
				</c:choose>



				<c:forEach var="i" begin="${pu.startPageNum}"
					end="${pu.endPageNum }">
					<c:choose>
						<c:when test="${pu.pageNum==i}">
							<li class="page-item active"><a class="page-link"
								href="${cp }/admin/remit?pageNum=${i }&field=${field}&keyword=${keyword}">${i }</a></li>
						</c:when>
						<c:otherwise>
							<li class="page-item"><a class="page-link"
								href="${cp }/admin/remit?pageNum=${i }&field=${field}&keyword=${keyword}">${i }</a></li>
						</c:otherwise>
					</c:choose>
				</c:forEach>




				<c:choose>
					<c:when test="${pu.totalPageCount>pu.endPageNum }">
						<li class="page-item"><a class="page-link"
							href="${cp }/admin/remit?pageNum=${pu.endPageNum+1 }&field=${field}&keyword=${keyword}">다음</a></li>
					</c:when>
					<c:otherwise>
						<li class="page-item disabled"><a class="page-link" href="#">다음</a></li>
					</c:otherwise>
				</c:choose>
			</ul>
		</div>

	</div>
</div>

<!-- The Modal -->
<div class="modal" id="myModal">
	<div class="modal-dialog">
		<div class="modal-content">

			<!-- Modal Header -->
			<div class="modal-header">
				<h4 class="modal-title">송금승인</h4>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>

			<!-- Modal body -->
			<div class="modal-body" id="modal-body">Modal body..</div>

			<!-- Modal footer -->
			<div class="modal-footer">


			</div>

		</div>
	</div>
</div>

<script>





	function getModal(pay_num, tutor_nickname, rem_pay,class_title,rem_revenue) {	
		$("div [class='modal-footer']").empty();
		$("#modal-body").text(
				tutor_nickname + "님의 " + rem_pay + "원을  송금신청을 수락하시겠습니까?");

		$("div [class='modal-footer']")
				.append(
						"<button type='button' class='btn btn-success' data-dismiss='modal' onclick=\"accept('"+ pay_num + "','"+tutor_nickname+"','"+rem_pay+"','"+class_title+"','"+rem_revenue+"')\">네</button>");
		$("div [class='modal-footer']")
				.append(
						"<button type='button' class='btn btn-danger' data-dismiss='modal'>아니오</button>")
	}

	function accept(pay_num,tutor_nickname,rem_pay,class_title,rem_revenue) {	
	
		
		
		location.href = "${cp}/admin/receiptAccept?pay_num=" + pay_num+"&tutor_nickname="+tutor_nickname+"&class_title="+class_title+"&rem_pay="+rem_pay+"&rem_revenue="+rem_revenue;		
		

	}
</script>