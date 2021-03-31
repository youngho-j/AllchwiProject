<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<link rel="stylesheet" href="${cp}/resources/css/myClass/myClassList.css">

<div class="container">
		<!--MyTItleBox head-->
		<div class="title-box">
		    <h1>내 수강 목록</h1>
		    <ul>
		        <li id="offline" class="cursor on"><a href="${cp}/mypage/myClassList">오프라인</a></li>
		        <li id="online" class="cursor"><a href="${cp}/mypage/myClassList?class_form=1">온라인</a></li>
		    </ul>
		</div>		
		<div class="my-class-list">
			<c:forEach var="vo" items="${list}">
			<div class="class-box">
				<div class="class-info"> 
					<div class="image" style="text-align: center;">
						<img src="${cp}/classImg/getimg?cover_num=${vo.cover_num }">
					</div>
					<div class="information-box">
						<div>신청일시: ${vo.apply_regdate }
						<c:choose>
						<c:when test="${vo.apply_auth==0 }">
							<div class="apply-auth button_gray" onclick="apply_detail(${vo.apply_num},${vo.class_num})">승인대기</div>
						</c:when>
						<c:otherwise>						
							<div class="apply-auth button_gray" onclick="apply_detail(${vo.apply_num},${vo.class_num})">승인완료</div>
						</c:otherwise>
						</c:choose>
						</div>
						<h3 onclick="location.href='${cp}/classDetail/detail?class_num=${vo.class_num }'" 
						style="overflow: hidden;text-overflow: ellipsis;white-space: nowrap;">${vo.class_title }</h3>
						<div class="stars-box">
							<font class="class-type">
							<c:choose>
								<c:when test="${vo.class_form=='0' }">
								오프라인
								</c:when>
								<c:otherwise>
								온라인
								</c:otherwise>
							</c:choose>
							</font>&nbsp;|&nbsp; &nbsp;
							<font class="class-stars">
								<c:set var="grade" value="${vo.class_rating+((vo.class_rating%1>0.5)?(1-(vo.class_rating%1))%1:-(vo.class_rating%1))}" />
								<c:forEach var="num" begin="1" end="5" step="1">
									<c:choose>
										<c:when test="${num  <= grade}">
											<img src="${cp }/resources/img/star.png" width="15px">
										</c:when>
										<c:otherwise>
											<img src="${cp }/resources/img/star_gray.png" width="15px">
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</font>
							<span>	(${vo.class_rating })</span>						
						</div>
						<div class="start-date">
							<font>결제일 : ${vo.pay_regdate }</font>&nbsp;|&nbsp;
							<font>수업 시작일 : <fmt:formatDate value="${vo.class_date }" pattern="yyyy-MM-dd"/> &nbsp;&nbsp;${vo.class_startTime }</font>&nbsp;|&nbsp; 
							<font>${vo.scategory_name} </font>
						</div>
						<jsp:useBean id="today" class="java.util.Date" />
						<fmt:formatDate var="now" value="${today}" pattern="yyyy-MM-dd" />
						<fmt:formatDate var="startDate" value="${vo.class_date }" pattern="yyyy-MM-dd" />
						<c:if test="${startDate <= now && vo.class_finish == '0' && vo.apply_auth=='1' }">
							<div class="review-fold cursor on" onclick="classFinish('${vo.apply_num}')" style="display: inline-block; float: left; margin-right: 20px;">수강완료
							</div>
						</c:if>
						<c:if test="${vo.class_finish!='0'}">
							<div class="review-fold cursor on" onclick="showModal(${vo.class_num})">리뷰작성
							</div>
						</c:if>
						<c:if test="${vo.class_form=='1'}">
							<a href="${cp}/onclass/community?class_num=${vo.class_num}" target="_blank">
							<div class="button_gray cursor on" style="float: left;">커뮤니티</div></a>
						</c:if>
						<div class="price"><font>￦</font><fmt:formatNumber type="number" maxFractionDigits="3" value="${vo.class_fee }" /></div>
					</div>
				</div>
			</div>
			</c:forEach>
			
			<div style="padding-top:100px">
				<ul class="pagination justify-content-center" style="margin: 20px 0">
				<c:choose>
					<c:when test="${pu.startPageNum>1 }">
						<li class="page-item"><a class="page-link"
							href="${cp }/mypage/myClassList?pageNum=${pu.startPageNum-1 }&class_form=${class_form}">이전</a></li>
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
								href="${cp }/mypage/myClassList?pageNum=${i }&class_form=${class_form}">${i }</a></li>
						</c:when>
						<c:otherwise>
							<li class="page-item"><a class="page-link"
								href="${cp }/mypage/myClassList?pageNum=${i }&class_form=${class_form}">${i }</a></li>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				
				<c:choose>
					<c:when test="${pu.totalPageCount>pu.endPageNum }">
						<li class="page-item"><a class="page-link"
							href="${cp }/mypage/myClassList?pageNum=${pu.endPageNum+1 }&class_form=${class_form}">다음</a></li>
					</c:when>
					<c:otherwise>
						<li class="page-item disabled"><a class="page-link" href="#">다음</a></li>
					</c:otherwise>
				</c:choose>
			</ul>
			</div>
		</div>
		<div class="container">
			<div class="modal-container"></div>
		</div>
</div>
<script type="text/javascript"> 

		//회원 신청서 정보 모달 띄우기
		function writeOk(class_num){		
			var url = "${cp}/review/modal?class_num="+class_num;
			   $('.modal-container').load(url,function(result){
				$('#myModal').modal();
			});		
		}
		
		// 리뷰작성 여부 체크
		function showModal(class_num){
			var check = true;
			$.ajax({
			    type: "post",
			    dataType: "text",
			    url: "${cp}/review/writeOk",
			    data: {class_num: class_num},
			    success: function(data) {
			    	if(data == 'success'){
			    		alert('이미 리뷰를 작성하셨습니다.');
			    	}else{
			    		writeOk(class_num);
			    	}
			    }
			});
			return check;
		}
		
		var pageNum = 1;
		
		
		$(function(){
			
			if('${class_form}'==1){
				$('#offline').removeClass('on');
				$('#online').addClass('on');
			}else if('${class_form}'==1){
				$('#online').removeClass('on');
				$('#offline').addClass('on');
			}
			
			
			$('#more-button').click(function(){
				if($('#more-button').attr('value')=='0'){
					$('#more-button').attr('value','1');
					$('.container .class-box').show();
					$('#more-button').find('#more-text').text('접기');
					$('#more-button').find('.up').show();
					$('#more-button').find('.down').hide();
				}else{
					$('#more-button').attr('value','0');
					$('.container .class-box').hide();
					$('.container .class-box').slice(0,4).show();
					$('#more-button').find('#more-text').text('더보기');
					$('#more-button').find('.down').show();
					$('#more-button').find('.up').hide();
				}
			});
		

		
		});
		
		function apply_detail(apply_num,class_num){
			var form = document.createElement("form");
			form.setAttribute("charset", "utf-8");
			form.setAttribute("method", "post");
			form.setAttribute("action", "${cp}/class/myapply");
			
			//a 파라미터 값이 null이 아닌 경우 히든 input을 생성하여 값을 넣음.
			var hiddenClassNum1 = document.createElement("input");
			hiddenClassNum1.setAttribute("type", "hidden");
			hiddenClassNum1.setAttribute("name", "apply_num");
			hiddenClassNum1.setAttribute("value", apply_num);
			
			var hiddenClassNum2 = document.createElement("input");
			hiddenClassNum2.setAttribute("type", "hidden");
			hiddenClassNum2.setAttribute("name", "class_num");
			hiddenClassNum2.setAttribute("value", class_num);

			//a 폼에 히든 input 추가 
			form.appendChild(hiddenClassNum1);
			form.appendChild(hiddenClassNum2);
			
			//a body부분에 폼을 붙이고 페이지 이동
			document.body.appendChild(form);
			form.submit();
		}
		
		function classFinish(apply_num){
			if (confirm("첫수업 완료시 수업완료를 해주세요.\n정말 완료하시겠습니까?") == true){    

				$.ajax({
				    type: "post",
				    dataType: "text",
				    url: "${cp}/mypage/finishUpdate",
				    data: {apply_num: apply_num},
				    success: function(data) {
				    	if(data == 'success'){
				    		alert('수업완료신청 되었습니다.');
				    		location.href = "${cp}/mypage/myClassList";
				    	}else{				    		
				    		alert('다시 신청해주세요!');
				    	}
				    }
				});

			}else{   //취소
			    return;
			}
		}
</script>