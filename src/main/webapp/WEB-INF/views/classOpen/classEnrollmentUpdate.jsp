<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link rel="stylesheet" href="${cp}/resources/css/classEnrollment/classEnrollment.css">
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="//dapi.kakao.com/v2/maps/sdk.js?appkey=${appkey}&libraries=services"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="${cp}/resources/js/classEnrollment/classEnrollment.js"></script>
<link id="cp" data-contextPath="${cp}"/>
<script>

	function deleteCert(val)
	{
	    $('#certs').append("<input type='hidden' value="+val+" name='deleteCert[]'>");
	}

	$(function(){
		$.ajax({
		    type: "post",
		    dataType: "json",
		    url: "${cp}/class/classUpdate",
		    data: {class_num: '${list.class_num}'},
		    success: function(data) {
		    	
		    	$(data.coverList).each(function(i,vo){
		    		var oImg = ($('<div>').attr('id', 'img-cover'+i)
		    				.addClass('cover_img')
		    				.css({'background-image':"url('${cp}/classImg/getimg?cover_num="+ vo.cover_num+"')"})
		    				.attr('data-value',vo.cover_num)
		    			).on({
		    				'click': function() { onImageupdate(vo.cover_num , i) }
		    			});

		    			oImg.append($('<img>').attr('src',"${cp}/classImg/getimg?cover_num="+ vo.cover_num)
		    				.css({'width':'0','height':'0'})										
		    			);

		    			$('#fileList').append(oImg);
		    			indexIncrement();
		    	});
		    	
		    	$(data.curriList).each(function(i,vo){
		    		
		    		$('#curries').append("<div class='curri inner1' id='Curri"+ (i+1) +"'>" +
    						"<div class='index'>" +
    						"<b>"+ (i+1)  +"</b>회차" +
    						"</div>" +
    						"<div class='box'>" +
    						"<textarea class='basic len980 form-control' placeholder='커리큘럼을 입력해 주세요.'  " +
    						"id='Curriculum"+ (i+1)  +"' name='curriculum[]'>"+ vo.curri_content +"</textarea>"+
    						"</div></div>" 
    						);
		    	});
		    	
		    	if(data.class_form == 0){
		    		rd(0,0);		    		
		    	}else{
		    		rd(0,1);
		    	}
		    	
		    	if(data.class_min >=1 && data.class_max > 1){
		    		rd(1,1);
		    	}else{
		    		rd(1,0);
		    	}
		    		
		    	var bcategory_num = data.bcategory_num;
		    	var scategory_num = data.scategory_num;
				$.ajax({
				    type: "post",
				    dataType: "json",
				    url: "${cp}/class/category",
				    data: {bcategory_num: bcategory_num},
				    success: function(data) {
				    	$("#CateSub").empty();
				    	$("#CateSub").append("<option value='0'>수업 대표 카테고리를 선택해주세요</option>");		
				    	$(data).each(function(i,scate){
				    		if(scategory_num == scate.scategory_num){			    			
								$("#CateSub").append("<option value='"+scate.scategory_num+"'selected >"+scate.scategory_name+"</option>");		
				    		}else{		    		
								$("#CateSub").append("<option value='"+scate.scategory_num+"'>"+scate.scategory_name+"</option>");		
				    		}
						});
				    }
				});
		    	
		    }
		});
		updateCalculation();
		
		// 등록 완료 버튼 
		$('#UpdateBtnNext').on('click',function (e) {
			
		    e.preventDefault();
		    // 부족한 내용 체크 후 객체아이디 저장 변수
			var eventLoc = "";
			
			//커리큘럼 횟수
			var curri = $('#TotalTimes').val();
			
			if($('#TutorInfo').val().length<35 ){ 
				$('#TutorInfo').addClass('on');
				eventLoc = "#TutorInfo";
			}else{
				$('#TutorInfo').removeClass('on');
			}
			
			if($('#Introduction').val().length<35 ){ 
				$('#Introduction').addClass('on');
				if(eventLoc == ""){eventLoc = "#Introduction"};
			}else{
				$('#Introduction').removeClass('on');
			}
			
			if($('#Target').val().length<35 ){ 
				$('#Target').addClass('on');
				if(eventLoc == ""){eventLoc = "#Target"};
			}else{
				$('#Target').removeClass('on');
			}
			 
			// 회차별 수업내용 validation
			for(var i = 1 ; i <= curri ; i++){
				if($('#Curriculum'+i).val().length < 35){
					$('#Curriculum'+i).addClass('on');
					if(eventLoc == ""){eventLoc = "#Curriculum"+i};
				}else{
					$('#Curriculum'+i).removeClass('on');
				}				
			}
		
			if(eventLoc != ""){
				alert('튜터님 수업에 대해 조금 더 알려주세요.');
				$(eventLoc).addClass('on').focus();
				return false;
			}
			$('#frm-classUpdate').submit();
			return true;
		});
		
		$('#frm-classUpdate').submit(function (e) {
			e.preventDefault();
			//미리 생성해 놓은 값 중에서 값이 없는 건 disabled
	        $("input[type=text]").each(function() {
	            if($(this).val() == "") {
	                $(this).attr("disabled",true);
	            }
	        });
	        $("input[type=file]").each(function() {
	            if($(this).val() == "") {
	                $(this).attr("disabled",true);
	            }
	        });
			
			var formData = new FormData(this);
			
			var images = $('#fileList img');
			
			formData.append('ImageCnt', images.length);
			
			if(images.length < 1){
				alert('커버 사진을 업로드 하세요');
				return false;
			}
			for (var i = 0; i < images.length; i++) {
				if(typeof  $(images[i]).data('fileData') != 'undefined'){
					formData.append('images', $(images[i]).data('fileData'));				
				}
			}
			
			$.ajax({
				type: 'POST',
				url: '${cp}/class/enrollmentUpdate',
				contentType: false,
				data: formData,
				dataType : 'text',
				processData: false,
				success: function (data) {			
					alert("return success");
					if(data=='success'){
						location.href ="${cp}/class/classBoard?class_num=${list.class_num}";
					}else{
						location.href="${cp}/error";
					}
				}
			});
			
		});		
	});
	
</script>
<div class="classOpen">
<div class="title_box">
	<!-- Nav 부트스트랩 목록 -->
	<h3>튜터 등록</h3>
	<div class="steps">
		<ul class="nav nav-pills mb-3" id="pills-tab" role="tablist">
			<li class="nav-item" role="presentation">
				<a class="nav-link active" id="pills-home-tab" data-toggle="pill" 
					href="#pills-info" role="tab" aria-selected="true">01기본정보</a>
			</li>
			<li class="nav-item" role="presentation">
				<a class="nav-link" id="pills-profile-tab" data-toggle="pill" href="#pills-title"
					role="tab" aria-selected="false">02제목/이미지</a>
			</li>
			<li class="nav-item" role="presentation">
				<a class="nav-link"	id="pills-contact-tab" data-toggle="pill" href="#pills-price"
					role="tab" aria-selected="false">03가격</a>
			</li>
			<li class="nav-item" role="presentation">
				<a class="nav-link"	id="pills-contact-tab" data-toggle="pill" href="#pills-class"
					role="tab" aria-selected="false">04수업</a>
			</li>
		</ul>
	</div>
</div>

<form method="POST" enctype="multipart/form-data" id="frm-classUpdate">
<input type="hidden" name="class_num" value="${list.class_num }">
<!-- 선택된 페이지 출력 -->
<div class="tab-content" id="pills-tabContent">
	<!-- 01튜터 기본정보 입력 페이지 -->
	<div class="tab-pane fade show active" id="pills-info" role="tabpanel">
		<div class="info1">
            <span class="pink">*</span>필수
        </div>
		<div class="box">
			<div class="title">
				튜터전화번호<b class="pink">*</b>
			</div>
			<div class="cont input-group col-5">
				<input type="text" id="phone" name="tutor_phone" class="form-control" placeholder="개인연락처를 - 없이 입력해주세요." value="${list.tutor_phone }"> 
			</div>
		</div>

	<div class="box">
		<div class="title">
			프로필사진<b class="pink">*</b>
		</div>
		<div class="cont">
			<div class="caution caution1">
				<b class="pink">주의</b><br> <span class="gray8">* 얼굴이 나오지
					않은 동물/캐릭터/단순배경사진/증명사진은 승인되지 않습니다.</span><br>
			</div>
			<div style="margin: 30px 0">
				<img class="upf_b" src="${cp}/resources/img/btn_pfimg.png">
				<div class="upf" id="picture-cover"
					style="background-image:url('${cp}/mypageImg/getimg?pro_num=${list.pro_num }')">
					<c:choose>
						<c:when test="${empty list.pro_num  }">
							<input type="hidden" id="ProfileImg" value="${cp}/resources/img/profile-defaultImg.jpg"> 					
						</c:when>
						<c:otherwise>
							<input type="hidden" id="ProfileImg" value="${cp}/mypageImg/getimg?pro_num=${list.pro_num }"> 					
						</c:otherwise>
					</c:choose>
					<input type="hidden" name="pro_num" value="${list.pro_num }"> 
					<input type="file" id="picture" name="picture" style="width: 150px; height: 130px; opacity: 0;">
				</div>
			</div>
		</div>
	</div>
	<div class="box">
		<div class="title">
			별명<b class="pink">*</b>
		</div>
        <div class="input-group col-5">
        	<input type="text" class="form-control" id="nickname" name="tutor_nickname" placeholder="튜터님의 정체성을 가장 잘 드러낼 수 있는 별명을 입력해주세요." value="${list.tutor_nickname }">
        </div>
    </div>
	<div class="box">
            <div class="title">인증<b class="pink">*</b></div>
            <div class="cont">
                <div class="caution caution2">
                    <div class="pink" style="padding-bottom:5px;font-weight:600;">인증 가이드</div>

                    <ul class="gray8">
                        <li>수강생들에게 신뢰를 주기 위해 신분 또는 학력 인증은 필수입니다.</li>
                        <li>파일은 jpg, png, gif, bmp등 이미지 파일만 가능합니다.</li>
                        <li>관리자 확인 후 업로드해주신 파일은 바로 삭제됩니다.</li>
                        <li>튜터등록은 내국인 또는 취업비자를 소지한 외국인만 가능합니다.</li>
                    </ul>
                </div>
                <div class="inner1">
                    <div class="certificate_title">
                    	자격증
	                    <font class="certificate_gray">
	                   		 날짜/자격증/주관사 공인 확인 가능한 자격증 사본
	                    </font>
                    </div>
                    <c:forEach var="cert" items="${list.certList}">
	                    <div class="certs" style="position:relative;">
	                       <input type="text" class="form-control col-8" placeholder="예) 토익900,HSK 6급,GTQ1급, 임상경력 등" value="${cert.certif_name }" style="display: inline-block;">
	                       <span class="verified left10" id="img-cover3-verified" style="display: inline-block;">인증대기중</span>
	                       <div class="verify left10" onclick="deleteCert('${cert.certif_num}');$(this).parent().remove();"><img src="https://front-img.taling.me/Content/Images/tutor/Images/icon_del_bk.png"> 삭제</div>
	                    </div>
                    </c:forEach>
                    <div id="certs">
	                    <div class="certificate" style="position: relative;">
	                    	<input type="text"  class="form-control col-8" name="certName[]" placeholder="예) 토익900,HSK 6급,GTQ1급, 임상경력 등" style="display: inline;">
	                        <div class="verify left10" style="position: absolute;">업로드</div>
	                        <input type="file" input-file="img-Cert0" name="cert[]" style="width:80px;height:50px;position:absolute;top:0;opacity:0;cursor:pointer; z-index: 2">
	                        <div style="padding-top:10px;" class="col-4">
	                            <img alt="" id="img-Cert0" style="float: none; margin: 0 auto; display:none ; overflow: hidden; max-width:400px;">
	                        </div>
	                    </div>
                    </div>
                    <div class="plus btn_hover" onclick='add_certificate()'>
                        <img src="${cp}/resources/img/icon_add_wh.png"> 자격증추가
                    </div>
                </div>
            </div>
        </div>
	    <div class="button_box">
	         <button type="button" onclick="nextClassPage(2)" class="btn btn-outline-danger">다음단계</button>
	    </div>
	</div>
	
	
	<!-- /////////////////// 02제목/이미지 페이지  /////////////////////-->
	<div class="tab-pane fade" id="pills-title" role="tabpanel">	
		<div class="info1">
            <span class="pink">*</span>필수
        </div>
        <div class="box">
        	<div class="title">수업등록지역<b class="pink">*</b></div>
        	<div class="cont">
        		<input type="text" class="form-control col-4" id="address" name="class_address" placeholder="수업 대표지역을 검색해주세요." readonly="readonly" value="${list.class_address}">
				<div id="map" style="width:100%;height:300px;margin-top:10px;display:none"></div>
        	</div>
        </div>
        
		<div class="box">
			<div class="title">수업카테고리<b class="pink">*</b></div>
			<div class="cont row">
				<select class="custom-select col-3" id="CateMain" name="cateMain">
					<option value="0">수업 대표 카테고리를 선택해주세요</option>
					<c:forEach var="vo" items="${bcate_list }">
						<option value="${vo.bcategory_num }"<c:if test="${list.bcategory_num == vo.bcategory_num }">selected</c:if>>${vo.bcategory_name }</option>
					</c:forEach>
				</select>
				<select class="custom-select col-3" id="CateSub" name="scategory_num">				
				</select>
			</div>
		</div>
		<div class="box" id="classBox">
		<div class="title">수업형태<b class="pink">*</b></div>
			<div class="cont">
				<div class="rds">
					<input type="hidden" value="0" name="class_form" id="classOption">
					<!--classOption 0이면 오프라인 / 1 이면 온라인-->
					<div class="rd"><label id="classOption0" onclick="rd(0,0)" class="on"></label>오프라인 클래스</div>
					<div class="rd"><label id="classOption1" onclick="rd(0,1)" class=""></label>온라인 수업</div>
				</div>
				<div class="inner3 gray5" id="classOption-info0" style="display: block;">
					* 다회차 수업일 때 올취 수강생들은 보통 <span class="pink">4~6회차 수업</span>을 선호합니다.<br>
					되도록 한 달 내에 끝낼 수 있도록 커리큘럼을 만들어주세요.
				</div>
				<div class="inner3 gray5" id="classOption-info1" style="display: none;">
				</div>
			</div>
		</div>
		<div class="box" id="groupBox">
			<div class="title">수업참여인원<b class="pink">*</b></div>
			<div class="cont">
				<div class="rds">
					<input type="hidden" value="0" name="groupOption" id="groupOption">
					<!--classOption 0이면 1:1 / 1 이면 그룹-->
					<div class="rd"><label id="groupOption0" onclick="rd(1,0)" class="on"></label>1:1 수업</div>
					<div class="rd"><label id="groupOption1" onclick="rd(1,1)" class=""></label>그룹수업</div>
				</div>
				<div class="inner2" style="display: block;" id="minmax">
					<select class="custom-select col-3" id="MinPerson" name="class_min">
						<option value="1">최소인원수</option>
						<c:forEach var="i" begin="1" end="30" step="1">
							<option value="${i}" <c:if test="${list.class_min==i }">selected</c:if>>${i }</option>
						</c:forEach>
					</select>
					 명 ~ 
					<select class="custom-select col-3" id="MaxPerson" name="class_max">
						<option value="1">최대인원수</option>
						<c:forEach var="i" begin="2" end="50" step="1">
							<option value="${i}" <c:if test="${list.class_min==i }">selected</c:if>>${i }</option>
						</c:forEach>
					</select>
					
					<div class="inner3">
						올취 수강생들이 선호하는 그룹수업은 평균적으로 <span class="pink">2~6인 내외</span>입니다.<br><br>
						* 그룹수업인데 일대일 수업도 가능한 경우, 수업소개 페이지에 별도 기재 부탁드립니다.<br>
						&nbsp;&nbsp;ex) 일대일 수업을 원하는 경우, 실시간톡으로 문의주세요.
					</div>
				</div>			
			</div>
		</div>
		<div class="box">
			<div class="title">수업제목<b class="pink">*</b></div>
			<div class="cont">
				<div class="inner1">
					<input type="text" class="form-control col-7" id="Title" name="class_title"  placeholder="수강생을 끌어당길 수 있는 개성넘치는 제목을 만들어 보세요." value="${list.class_title }">
				</div>
			</div>
		</div>
		
		<div class="box">
			<div class="title">커버이미지<b class="pink">*</b><br><br></div>
			<div class="cont">
				<div class="drag_cont">
					<div class="drag_box" id="dropZone">
						<div class="imgupbt" id="dragInfo">
							<img src="${cp}/resources/img/icon_img_area.png"><br><br>
							이미지를 드래그 해주세요
						</div>
					</div>
					<div class="right">
						<input type="file" id="imgnonefile" name="picture" accept="image/*" style="position: absolute;opacity:0;cursor:pointer; width: 120px;height: 50px;">
						<div class="plus button" id="imgUp" data-send="coverImage">
							<img src="${cp}/resources/img/icon_add_wh.png"> 이미지추가
						</div>
						<br>
						<div class="verify" style="margin:10px 0" onclick="deleteImage()">
							<img src="${cp}/resources/img/icon_del_bk.png"> 이미지삭제
						</div>
						<div style="margin-top:40px">
							<span class="pink">권장사항</span>
							<br><br>
							<span class="gray5">- <font class="pink">10MB 이하의</font> jpg,jpeg,png 파일<br></span>
						</div>
					</div>
				</div>
				<div style="display:inline;padding:2px 7px;border-radius:3px;position:absolute;background:#ff005a;color:#fff;font-size:12px;line-height:1;margin-top:8px;">
					첫 번째
				</div>
				<div style="overflow:hidden" id="fileList">
				</div>
			</div>
		</div>	
		<div class="button_box">
	         <button type="button" class="btn btn-outline-danger" id="secondNext" data-num="3">다음단계</button>
		</div>
	</div>
	
	<!-- ///////////////////////// 03겨격 /////////////////////// -->
	<div class="tab-pane fade" id="pills-price" role="tabpanel">
		<div class="info1">
            <span class="pink">*</span>필수
        </div>
        <div class="box">
			<div class="title">가격/시간/횟수<b class="pink">*</b></div>
			<div class="cont">
				<div class="inner1" style="margin:0">
					<div class="gray5 title">시간당 가격</div>
					<input type="text" id="UnitPrice" name="class_price" class="form-control col-4" placeholder="시간당 가격을 입력하세요" style="display: inline-block;" value="${list.class_price}">원
				</div>
				<div class="inner1">
					<div class="gray5 title">1회당 수업시간</div>
					<select class="custom-select col-4" id="Time" name="class_hour">
						<option value="0">1회당 수업시간을 선택하세요</option>
						<c:forEach var="i" begin="1" end="6" step="1">
							<option value="${i}" <c:if test="${list.class_hour eq i }">selected</c:if>>${i}시간</option>
						</c:forEach>
					</select>
					시간
				</div>
				<div class="inner1">
					<div class="gray5 title">총 수업횟수</div>			
									
						<select id="TotalTimes" name="class_count" class="custom-select col-4">
							<option value="0">총 수업횟수를 선택하세요</option>
							<c:forEach var="i" begin="1" end="12" step="1">
								<option value="${i}" <c:if test="${list.class_count eq i }">selected</c:if>>${i}회</option>
							</c:forEach>
						</select>회
				</div>

			</div>
		</div>
        <div class="box">
		<div class="title">총 수업가격<b class="pink"></b></div>
			<div class="cont">
				<div class="caution caution2" style="overflow:hidden">
					<font>
						<span id="calc-unit-price">0</span>원&nbsp;&nbsp;X&nbsp;&nbsp;
						<span id="calc-time">0</span>시간&nbsp;&nbsp;X&nbsp;&nbsp;
						<span id="calc-total-times">0</span>회
					</font>
					<div class="rs">
						총&nbsp;&nbsp;
						<font class="pink"><b>
							<span id="calc-result">0</span></b>원
						</font>
					</div>
				</div>
			</div>
		</div>
		<div class="button_box">
	         <button type="button" class="btn btn-outline-danger" id="thirdNext" data-num="4">다음단계</button>
		</div>
	</div>
	
	<!-- ////////////////////// 수업 상세입력 ///////////////////////// -->
	<div class="tab-pane fade" id="pills-class" role="tabpanel">
		<div class="box">
			<div class="title">튜터소개<b class="pink">*</b></div>
			<div class="cont" style="padding-top:15px">
				<div class="inner1">
					<textarea class="basic len980 form-control" placeholder="수강생은 튜터님에 대해 많은 관심을 가지고 있습니다. TIP을 참고하여 최대한 자세히 소개를 해주세요." id="TutorInfo" name="tutor_about">${list.tutor_about }</textarea>
				</div>
			</div>
		</div>	
		<div class="box">
			<div class="title">수업소개<b class="pink">*</b></div>
				<div class="cont">
					<div class="inner1">
						<textarea class="basic len980 form-control" placeholder="수업소개는 수강생이 가장 주의깊게 살펴보는 부분입니다. 수강생들이 수업에 대해 알 수 있도록 TIP의 질문을 반드시 포함하여 작성해주세요." id="Introduction" name="class_about">${list.class_about }</textarea>
					</div>
				</div>
			</div>
		<div class="box">
			<div class="title">수업대상<b class="pink">*</b></div>
			<div class="cont">
				<div class="inner1">
					<textarea class="basic len980 form-control" placeholder="TIP의 내용을 참고하여 튜터님의 수업을 수강하기에 적합한 수업대상에 대해 알려주세요. " id="Target" name="class_target">${list.class_target}</textarea>
				</div>
			</div>
		</div>
		<div class="box">
			<div class="title">커리큘럼<b class="pink">*</b></div>
			<div class="cont" id="curries">
			</div>
		</div>
		<div class="button_box">
	       	<button type="button" class="btn btn-outline-danger" id="UpdateBtnNext">튜터등록 완료</button>
		</div>
	</div>
</div>
</form>
</div>
