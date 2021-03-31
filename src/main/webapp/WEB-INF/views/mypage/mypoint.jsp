<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script type="text/javascript" src="${cp}/resources/js/jquery-3.5.1.js"></script>
<link rel="stylesheet"
	href="${cp }/resources/css/mypage/mypointForm.css">
<div class="container">
	<!--point head-->
	<div class="pointHead">
		<h1>내 포인트</h1>
	</div>
	<!--point body-->
	<div class="container">
		<div class="inner-cont" style="padding-top: 0">
			<div class="label-title">이름 [ID]</div>
			<div class="contents">
			<!-- a사용되거나 적립된 목록이 없을 경우 session에 저장된 mem 값을 꺼내서 출력 -->
			<c:choose>
				<c:when test="${list.size() > 0 }">
					${list[0].mb_name} [ ${list[0].id} ]
				</c:when>
				<c:otherwise>
					${mem.mb_name} [ ${mem.id} ]
				</c:otherwise>
			</c:choose>
			</div>
		</div>
		<div class="inner-cont" style="padding-top: 0">
			<div class="label-title">현재 보유 포인트</div>
			<div class="contents">
				<b>${total}</b> point
			</div>
		</div>
		<div class="inner-cont">
			<div>
				<!-- 버튼클릭시 post방식으로 이동하여 결과 가져오도록 처리 -->
				<button class="btn btn-outline-secondary" name='sortBtn' value="null">전체 내역</button>
				<button class="btn btn-outline-secondary" name='sortBtn' value="u">사용 내역</button>
				<button class="btn btn-outline-secondary" name='sortBtn' value="s">적립 내역</button>
			</div>
		</div>
		<div class="inner-cont">
			<div id="table">
				<table class="table">
					<thead class="thead-dark">
						<!-- 제목 컬럼 사이즈 고정 -->
						<tr>
							<th scope="col" style="width: 310px;">일자</th>
							<th scope="col" style="width: 350px;">포인트 적립/사용 내역</th>
							<th scope="col" style="width: 176px;">포인트</th>
						</tr>
					</thead>
					<tbody id="tb">
						<!-- 회원의 포인트 적립 사용리스트 foreach로 출력 -->
						<c:choose>
						<c:when test="${list.size() > 0 }">
						<!-- test="${vo.point_type eq 'u'.charAt(0)}" char형식 비교 s: 적립포인트 / u: 사용포인트-->
						<!-- fmt 사용하여 날짜 출력 형식 변경 -->
						<c:forEach var="vo" items="${list}">
							<tr>
								<td><fmt:formatDate value="${vo.point_regdate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
								<td>${vo.point_name }</td> 
								<c:choose>
									<c:when test="${vo.point_type eq 'u'.charAt(0)}">
										<td style="color: red">-${vo.point }</td>
									</c:when>
									<c:otherwise>
										<td style="color: blue">+${vo.point }</td>
									</c:otherwise>
								</c:choose>
							</tr>
						</c:forEach>
						</c:when>
						<c:otherwise>
							<tr>
								<td colspan="3" style="text-align: center">
									검색된 결과가 없습니다.
								</td>
							</tr>
						</c:otherwise>
						</c:choose>
					</tbody>
				</table>
			</div>
		</div>
		<div class="inner-cont" style="text-align: center;">
			<ul class="pagination justify-content-center" style="margin: 20px 0">
			<!-- 이전페이지로 이동 버튼 생성 / 넘어갈수 없을 경우 disabled 처리 -->
			<c:choose>
				<c:when test="${pu.startPageNum > 1 }">
					<li class="page-item">
						<a class="page-link" href="${cp }/mypage/pointForm?pageNum=${pu.startPageNum -1}">이전</a>
					</li>
				</c:when>
				<c:otherwise>
					<li class="page-item disabled">
						<a class="page-link">이전</a>
					</li>
				</c:otherwise>
			</c:choose>
			<!-- 페이징 처리 -->
			<c:forEach var="i" begin="${pu.startPageNum}" end="${pu.endPageNum}">
				<c:choose>
					<c:when test="${pu.pageNum==i}">
						<li class="page-item active">
						<a class="page-link" href="${cp }/mypage/pointForm?pageNum=${i}">${i}</a>
						</li>
					</c:when>
					<c:otherwise>
						<li class="page-item">
						<a class="page-link" href="${cp }/mypage/pointForm?pageNum=${i}">${i}</a>
						</li>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<!-- 다음페이지로 이동 버튼 생성 / 넘어갈 수 없을 경우 disabled 처리 -->
			<c:choose>
				<c:when test="${pu.endPageNum < pu.totalPageCount }">
					<li class="page-item">
						<a class="page-link" href="${cp }/mypage/pointForm?pageNum=${pu.endPageNum +1}">다음</a>
					</li>
				</c:when>
				<c:otherwise>
					<li class="page-item disabled">
						<a class="page-link">다음</a>
					</li>
				</c:otherwise>
			</c:choose>
			</ul>
		</div>
		<div style="padding-top: 400px"></div>
	</div>
</div>
<script type="text/javascript">
	//a 버튼 클릭시 this를 통해 현재 버튼의 value 값을 pointType에 담아줌 / 포인트 전체출력, 사용포인트 출력, 적립포인트 출력
	$("button[name='sortBtn']").on('click',function(){
		var pointType = $(this).val();
		//a 동적으로 form을 생성하여 파라미터 값을 보내줌.
		var form = document.createElement("form");
		form.setAttribute("charset", "utf-8");
		form.setAttribute("method", "post");
		form.setAttribute("action", "${cp}/mypage/pointForm");
		//a 파라미터 값이 null이 아닌 경우 히든 input을 생성하여 값을 넣음.
		if(pointType != 'null'){
		var hiddenPointType = document.createElement("input");
		hiddenPointType.setAttribute("type", "hidden");
		hiddenPointType.setAttribute("name", "pointType");
		hiddenPointType.setAttribute("value", pointType);
		//a 폼에 히든 input 추가 
		form.appendChild(hiddenPointType);
		}
		//a body부분에 폼을 붙이고 페이지 이동
		document.body.appendChild(form);
		form.submit();
		
		/* get방식
		if(pointType == 'null'){
			location.href = "${cp}/mypage/pointForm";
		} else {
			location.href = "${cp}/mypage/pointForm?pointType=" + pointType;		
		}
		*/
	});
</script>