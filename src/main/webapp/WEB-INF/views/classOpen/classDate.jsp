<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<link rel="stylesheet" href="${cp}/resources/css/classEnrollment/classDate.css">
<link id="cp" data-contextPath="${cp}"/>
<script>
	var updateCnt = 0;
	function add_date(){
		url = "${cp}/class/dateModal";
		$('#regiDate').attr('src', url);
		
		setTimeout(
			function() 
			{
				$('#dim').show();
				$('#dim2').show();
			}, 300);						
		}
	
	function cls_date(){
		$('#dim').hide();
		$('#dim2').hide();
	}
		
	
	function fold(elm){
		if($(elm).children('.subtext').css('display')=='none'){
				$(elm).siblings('.certificate.class').removeClass('on').find('.subtext').hide();
				$(elm).children('.subtext').toggle("slow");
				$(elm).addClass('on');
		}else{
			$(elm).removeClass('on').find('.subtext').hide();
		}
	}
	
	function getClassDate(val){
		
		var startDate1 = $("#regiDate").contents().find('#startDate1').val();
		
		var div = $("<div id='certifi' class='certificate class' onclick='fold(this)''></div>").appendTo('#certifiArr')
		
		if(val == '0'){
			
			var startTime1 = $("#regiDate").contents().find('#startTime1').val();
			var startDate1 = $("#regiDate").contents().find('#startDate1').val();
			var endTime1 = $("#regiDate").contents().find('#endTime1').val();
			var classTime1 = $("#regiDate").contents().find('#classTime1').text();
			
			
			
			if(startDate1 ==''){
				alert("시작일자를 입력해주세요");
				$("#regiDate").contents().find('#startDate1').focus();
				div.remove();
				return;
			}
			
			if(classTime1 == '' || endTime1 ==''){
				alert("시작시간를 입력해주세요");
				$("#regiDate").contents().find('#startTime1').focus();
				div.remove();
				return;
			}
			
			
			div.append("<div class='intext'>"+
					startDate1 + classTime1 +
					"<img src='${cp}/resources/img/icon_down.png' class='dwn'>"+ 
					"<img src='${cp}/resources/img/icon_up.png' class='up'>"+
				"</div>"+
				"<div class='verify left10' onclick='cntDown();$(this).parent().remove();'>"+
					"<img src='${cp}/resources/img/icon_del_bk.png'>삭제"+
				"</div>");
			
			div.append("<input type='hidden' class='cal' name='startDate[]' value='"+ startDate1 +"'>");
			div.append("<input type='hidden' class='cal' name='startTime[]' value='"+ startTime1 +"'>");
			div.append("<input type='hidden'  class='cal' name='endTime[]' value='"+ endTime1 +"'>");
			let subtext = $("<div class='subtext'></div>").appendTo(div);
			
			var classCount = $("#regiDate").contents().find('#classCount').val();
			for(let i=2; i<=classCount;i++){
				let startDate = $("#regiDate").contents().find('#startDate'+i).val();
				let startTime = $("#regiDate").contents().find('#startTime'+i).val();
				let endTime = $("#regiDate").contents().find('#endTime'+i).val();
				let classTime = $("#regiDate").contents().find('#classTime'+i).text();
				

				if(startDate ==''){
					alert(i+"회차 시작일자를 입력해주세요");
					$("#regiDate").contents().find('#classTime'+i).focus();
					subtext.remove();
					return;
				}
				
				if(startTime == '' || endTime ==''){
					alert(i+"회차시작시간를 입력해주세요");
					$("#regiDate").contents().find('#startTime'+i).focus();
					subtext.remove();
					return;
				}
				
				
				subtext.append("<div class='ch'>"+
					"<font>"+i+"회</font> : "+ startDate + classTime +
				"</div>")
				
				subtext.append("<input type='hidden' class='cal' name='startDate[]' value='"+ startDate +"'>");
				subtext.append("<input type='hidden' class='cal' name='startTime[]' value='"+ startTime +"'>");
				subtext.append("<input type='hidden' class='cal' name='endTime[]' value='"+ endTime +"'>");
			}
		}else{
			var monthDate = $("#regiDate").contents().find('#monthDate').val();
			if(startDate1 ==''){
				alert("시작일자를 입력해주세요");
				$("#regiDate").contents().find('#startDate1').focus();
				div.remove();
				return;
			}
			
			if(monthDate == null || monthDate == ''){
				alert("개월을 입력해주세요");
				$("#regiDate").contents().find('#monthDate').focus();
				div.remove();
				return;
			}
			div.append("<div class='intext'>"+
					startDate1 +"&ensp;&ensp;&ensp;&ensp;&ensp;" + monthDate + "개월"+
				"</div>"+
				"<div class='verify left10' onclick='cntDown();$(this).parent().remove();'>"+
					"<img src='${cp}/resources/img/icon_del_bk.png'>삭제"+
				"</div>");
			div.append("<input type='hidden' class='cal' name='startDate[]' value='"+ startDate1 +"'>");
			div.append("<input type='hidden' class='cal' name='monthDate[]' value='"+ monthDate +"'>");
		}
		updateCnt++;
		cls_date();
	}
	
	
	// 새로 추가한 일정 삭제하면 업로드 카운트 감소.
	function cntDown(){
		updateCnt--;
	}
	
	function del_cal(dateNum){
		
		let delInput = document.createElement("input");
		$(delInput).attr('type','hidden');
		$(delInput).attr('name','delDate');
		$(delInput).val(dateNum);
		$('#certifiArr').append(delInput);
	}
	
	$(function(){
		var cp = $('#cp').attr('data-contextPath');
		
		$('#frm-data').submit(function(e){
			e.preventDefault();
			
			var formData = new FormData(this);
			formData.append('updateCnt',updateCnt);
			$.ajax({
				type: 'POST',
				url: cp +'/class/classInsert',
				data: formData,
				contentType: false,
				processData: false,
				dataType : 'text',
				success: function (data) {			
					if(data=='success'){
						location.href =cp+"/class/classBoard?class_num=${class_num}";
					}else{
						location.href=cp+"/error";
					}
				}
			});							
		});
		
	});
	
</script>
<div class="tutor_cont">	
	<div class="dim" id="dim" style="display: none;"></div>
	<div class="dim2" id="dim2" style="display: none;">
		<iframe id="regiDate" name="regiDate" frameborder="0" width="100%" height="100%"></iframe>
	</div>
		<div class="title_box right">
			<h3>장소/일정</h3>
			<span class="pink">*</span>필수
		</div>
		<form id="frm-data">
			<input type="hidden" name="class_num" value="${class_num}">  
			<input type="hidden" name="class_count" value="${class_count}">  
			<input type="hidden" name="class_form" value="${class_form}">  
			<div class="box">
			<div class="title">수업시작일</div>  
			<div class="cont">
				<div class="inner1">
					<div class="gray5 title">수업 시작일을 알려주세요</div>
					<div id="certifiArr">
						<c:forEach var="date" items="${list}">
						
							<div id="certifi" class="certificate class" onclick="fold(this)">
								<div class="intext">
									<c:choose>
										<c:when test="${class_form=='0'}">
											<fmt:formatDate value="${date.class_date}" pattern="yyyy-MM-dd"/>&ensp;&ensp; ${date.class_startTime } ~ ${date.class_endTime }
											<img src="${cp}/resources/img/icon_down.png" class="dwn"> 
											<img src="${cp}/resources/img/icon_up.png" class="up">
										</c:when>
										<c:otherwise>
											<fmt:formatDate value="${date.class_date}" pattern="yyyy-MM-dd"/>&ensp;&ensp; ${date.class_month }개월										
										</c:otherwise>
									</c:choose>
								</div>
								<div class="verify left10" onclick="del_cal('${date.date_num}');$(this).parent().remove();">
									<img src="${cp}/resources/img/icon_del_bk.png">삭제
								</div>
								<div class="subtext">
								<c:forEach var="vo" items="${date.list}">
									<div class="ch">
										<font>${vo.time_cnt}회</font> : 
										<fmt:formatDate value="${vo.class_date}" pattern="yyyy-MM-dd"/> ${vo.class_startTime } ~ ${vo.class_endTime }
									</div>
								</c:forEach>
								</div>
							</div>
							
						</c:forEach>
					</div>
					<div class="plus button" style="margin-top:20px" onclick="add_date()">
						<img src="${cp}/resources/img/icon_add_wh.png"> 수업일정 추가
					</div>
				</div>
			</div>
		</div>
		<div class="box">	
			<div class="title"><b class="pink">*</b> 장소 및 추가비용 코멘트<br>
			</div>
			<div class="cont">
				<textarea class="basic len980 hei190" placeholder="스터디룸, 준비물 등 추가 비용이 있는 경우 반드시 적어주세요." id="class_comment" name="class_comment"></textarea>
			</div>
		</div>
		<div class="box">
			<div class="title"><b class="pink">*</b> 신청 학생에게 보낼 메시지</div>
			<div class="cont">
				<textarea class="basic len980 hei190" placeholder="수강생과 수업 연결 시에 메시지가 전달됩니다." id="class_msg" name="class_msg"></textarea>
			</div>
		</div>
		<div class="box">
			<button id="sendBtn" type="submit" class="next button" >저장하기</button>
		</div>
		</form>
</div>