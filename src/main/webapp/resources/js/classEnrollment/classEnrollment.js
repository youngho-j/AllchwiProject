
////////  첫번째 페이지 JS //////////
$(function(){
	// 튜터프로필 설정 함수
	$('#picture').change(function(e) {
		// 선택한 그림의 file 객체를 가져온다.
		var file = (e.target).files[0];
		var reader = new FileReader();
		
		// file객체를 DataUrl로 파일을 읽는다.
		reader.readAsDataURL(file);
		
		// file객체 읽기가 성공하면 결과를 출력한다.
		reader.onload = function() {
		$('#picture-cover').css("background-image",
				"url('" + reader.result + "')");
		}
	});
	
	//자격증 파일 업로드 이벤트 함수
    $(document).on('change','[input-file]',function (e) {
        var file = e.target.files[0];
        var targetId = $(this).attr('input-file');
        var reader = new FileReader();        
        reader.onload = function() {
            $('#' + targetId).attr('src', reader.result);
            $('#' + targetId).show();
        }
        reader.readAsDataURL(file);
    });
    
    
    $('#firstNext').on('click',function (e) {
    	// contextPath 받기
        var cp = $('#cp').attr('data-contextPath');
        
        //버튼이벤트의 data-num 값 가져오기
        var num = $(this).attr('data-num');

        // 전화번호 입력 여부 확인
        if($('#phone').val() ==''){
        	alert('튜터 번호를 등록해주세요');
        	$('#phone').focus();
        	return false;
        }
        
        // 핸드폰번호 길이가 맞는지 확인
        if($('#phone').val().length != 11){
        	alert('튜터 번호를 정확하게 입력해주세요');
        	$('#phone').focus();
        	return false;
        }
        
        // 튜터 프로필 입력 여부 확인
        if($('#picture').val() == '' ){
            if($('#ProfileImg').attr == cp+'/resources/img/profile-defaultImg.jpg' ){
                alert('프로필사진을 등록해주세요');
                $('#picture').focus();
                return false;
            }
        }
        
        // 닉네임,별명 입력 여부 확인
        if($('#nickname').val() == '' ){ 
        	alert('별명을 입력하세요');
        	$('#Description').focus();
        	return false;
        	}
    	
        // 닉네임,별명 길이 제한
    	if($('#nickname').val().length>8){
    		alert('별명은 8자 이하로 써주세요');
    		$('#Description').focus();
    		return false;
    	}
    	var chk = true;
    	 $("input[name='certName[]']").each(function(){
    		 if($(this).val() == ""){
    			 $(this).focus();
    			chk = false;
    		 }
    	 });
    	 
    	 if(!chk){
    		 alert('자격증 명을 입력해주세요.');
    		 return;
    	 }
    	 

        // 입력 완료후 페이지 이동
        nextClassPage(num);
        return true;
    });
    
});

// 다음 페이지로 이동 함수
function nextClassPage(e){
	$('#pills-tab li:nth-child('+ e +') a').relatedTarget;
	$('#pills-tab li:nth-child('+ e +') a').tab('show');
	$('#pills-tab li:nth-child('+ (e-1) +') a').css("pointer-events","auto");
}

//자격증 FileUpload

// 자격증 태그네임번호
var certNum = 1;

// 자격증 DOM 추가 생성
function add_certificate(){
	// 자격증 업로드 태그 생성.
	$('#certs').append("<div class='certificate' style='position: relative;'>"
			+ "<input type='text' class='form-control col-8' name='certName[]' placeholder='예) 토익900,HSK 6급,GTQ1급, 임상경력 등' style='display: inline;'>"
			+ "<div class='verify left10' style='position: absolute;'>업로드</div>"
			+ "<input type='file'input-file='img-Cert"+certNum+"' name='cert[]' style='width:80px;height:50px;position:absolute;top:0;opacity:0;cursor:pointer; z-index: 2'>"
			+ "<div style='padding-top:10px;' class='col-4'>"
			+ "<img id='img-Cert"+ certNum +"' style='float: none; margin: 0 auto; display:none; overflow: hidden; max-width:400px;'>"
			+ "</div></div>");
	// 자격증 번호증가
	certNum++;
}

///////////////////////////////////////////////////////////

//////////// 두번째 페이지 JS /////////////////////

//지도컨테이더 div
var mapContainer = null;

$(function(){
	mapContainer = document.getElementById('map'), // 지도를 표시할 div
	mapOption = {
		center : new daum.maps.LatLng(37.537187, 127.005476), // 지도의 중심좌표
		level : 4
	// 지도의 확대 레벨
	};

	//지도를 미리 생성
	var map = new daum.maps.Map(mapContainer, mapOption);

	//지도 드래그 막기
	map.setDraggable(false);
	// 마우스 휠로 지도 확대,축소 가능여부를 설정합니다
	map.setZoomable(false);

	//주소-좌표 변환 객체를 생성
	var geocoder = new daum.maps.services.Geocoder();
	//마커를 미리 생성
	var marker = new daum.maps.Marker({
		position : new daum.maps.LatLng(37.537187, 127.005476),
		map : map
	});
	
	//주소 입력 input click 시 호출되는 함수
	$('#address').on('click',function() {
		new daum.Postcode({
			oncomplete : function(data) {
				var addr = data.address; // 최종 주소 변수

				// 주소 정보를 해당 필드에 넣는다.
				document.getElementById("address").value = addr;
				// 주소로 상세 정보를 검색
				geocoder.addressSearch(data.address, function(results, status) {
					// 정상적으로 검색이 완료됐으면
					if (status === daum.maps.services.Status.OK) {

						var result = results[0]; //첫번째 결과의 값을 활용

						// 해당 주소에 대한 좌표를 받아서
						var coords = new daum.maps.LatLng(result.y, result.x);
						// 지도를 보여준다.
						mapContainer.style.display = "block";
						map.relayout();
						// 지도 중심을 변경한다.
						map.setCenter(coords);
						// 마커를 결과값으로 받은 위치로 옮긴다.
						marker.setPosition(coords)
					}
				});
			}
		}).open();
	});
});

// 라디오 박스 선택 이벤트 함수
function rd(elm,val){	
	var num =val;
	var name = '';
	if(elm=='0'){//수업형태
		$('#classOption').val(num);
		name = "#classOption"+num;
		if(num){
			$('#classOption-info0').hide();
			$('#classOption-info1').show();
		}else{
			$('#classOption-info0').show();
			$('#classOption-info1').hide();
		}
		$('#classOption0').removeClass('on');$('#classOption1').removeClass('on');
	}
	else{//elm==1 // 수업참여인원

		$('#groupOption').val(num);
		name = "#groupOption"+num;
		$('#groupOption0').removeClass('on');$('#groupOption1').removeClass('on');

		if(num==0)
		{
			$('#minmax').hide();
		}
		else
		{
			$('#minmax').show();
		}
	}
	$(name).addClass('on');
}
// 라디오박스 init
$(function(){
	rd(0,0);
	rd(1,0);
});

// 파일 리스트 번호
var fileIndex = 0;
// 등록할 전체 파일 사이즈
var totalFileSize = 0;
// 파일 리스트
var fileList = new Array();
// 파일 사이즈 리스트
var fileSizeList = new Array();
// 등록 가능한 파일 사이즈 MB
var uploadSize = 10;
// 등록 가능한 총 파일 사이즈 MB
var maxUploadSize = 100;

var selectIndex = 0;

$(function (){
	// 파일 드롭 다운
	fileDropDown();
	
	// 이미지추가 버튼
	$('#imgnonefile').change(function (e) {
		var file = e.target.files[0];					
		innerImg(file, fileIndex)
		fileIndex++;
	});		
});

// 파일 드롭 다운
function fileDropDown(){
	// Drag div 영역
	var dropZone = $("#dropZone");
	//Drag기능 
	dropZone.on('dragenter',function(e){
		//이벤트 캡쳐링과 버블링에 있어 현재 이벤트 이후의 전파를 막습니다.
		e.stopPropagation();
		//이벤트를 취소할 수 있는 경우, 이벤트의 전파를 막지않고 그 이벤트를 취소합니다.
		e.preventDefault();
	});
	
	// dragleave : 드래그하는 요소나 텍스트 블록이 적합한 드롭 대상에서 벗어났을 때 발생한다.
	dropZone.on('dragleave',function(e){
		e.stopPropagation();
		e.preventDefault();
		// 드롭다운 영역 css
		dropZone.css('background-color','#FFFFFF');
	});
	dropZone.on('dragover',function(e){
		e.stopPropagation();
		e.preventDefault();
		// 드롭다운 영역 css
		dropZone.css('background-color','#E3F2FC');
	});
	dropZone.on('drop',function(e){								
		e.preventDefault();
		// 드롭다운 영역 css
		dropZone.css('background-color','#FFFFFF');
		
		var files = e.originalEvent.dataTransfer.files;
		if(files != null){
			if(files.length < 1){
				alert("폴더 업로드 불가");
				return;
			}
			selectFile(files);

		}else{
			alert("ERROR");
		}
	});								
}

// 파일 선택시
function selectFile(fileObject){
	var files = null;

	if(fileObject != null){
		// 파일 Drag 이용하여 등록시
		files = fileObject;
	}else{
		// 직접 파일 등록시
		//files = $('#multipaartFileList_' + fileIndex)[0].files;
	}
	
	// 다중파일 등록
	if(files != null){
		for(var i = 0; i < files.length; i++){
			// 파일 이름
			var fileName = files[i].name;
			var fileNameArr = fileName.split("\.");
			// 확장자
			var ext = fileNameArr[fileNameArr.length - 1];
			// 파일 사이즈(단위 :MB)
			var fileSize = files[i].size / 1024 / 1024;
			
			if($.inArray(ext, ['exe', 'bat', 'sh', 'java', 'php', 'html', 'js', 'css', 'xml']) >= 0){
				// 확장자 체크
				alert("등록 불가 확장자");
				break;
			}else if(fileSize > uploadSize){
				// 파일 사이즈 체크
				alert("용량 초과\n업로드 가능 용량 : " + uploadSize + " MB");
				break;
			}else{
				// 전체 파일 사이즈
				totalFileSize += fileSize;
				
				// 파일 배열에 넣기
				fileList[fileIndex] = files[i];
				
				// 파일 사이즈 배열에 넣기
				fileSizeList[fileIndex] = fileSize;

				// 업로드 파일 목록 생성
				innerImg(files[i], fileIndex);

				selectIndex = fileIndex;
				
				// 파일 번호 증가
				fileIndex++;
			}
		}
	}else{
		alert("ERROR");
	}
}

function onImage(val, num)
{
	$('#dropZone').css({'background':'url('+val+')', 'background-repeat' : 'no-repeat', 'background-position':'center' , 'background-size':'cover' , 'box-sizing':'border-box'});

	$('#dragInfo').hide();

	selectIndex = num;
}

function indexIncrement(){
	fileIndex++;
}

function onImageupdate(val, num)
{
	$('#dropZone').css({'background':"url('/classImg/getimg?cover_num="+ val +"')", 'background-repeat' : 'no-repeat', 'background-position':'center' , 'background-size':'cover' , 'box-sizing':'border-box'});
	$('#dragInfo').hide();
	selectIndex = num;
}

function deleteImage(){
	// 전체 파일 사이즈 수정
	totalFileSize -= fileSizeList[selectIndex];
	
	// 파일 배열에서 삭제
	delete fileList[selectIndex];
	
	// 파일 사이즈 배열 삭제
	delete fileSizeList[selectIndex];
	
	// 업로드 파일 테이블 목록에서 삭제
	var val = $("#img-cover" + selectIndex).attr("data-value")
	
	if(val != null){	
		$('#fileList').append("<input type='hidden' value="+val+" name='delCoverImg[]'>");
	}
	
	$("#img-cover" + selectIndex).remove();
	
	$('#dragInfo').show();

	$('#dropZone').css({'background':'url()', 'background-color':'#edf0f4', 'background-repeat' : 'no-repeat', 'background-position':'center' , 'background-size':'cover' , 'box-sizing':'border-box'});
}


function innerImg(files, num)
{
	var reader = new FileReader();											
	reader.readAsDataURL(files);
	var html = "";
	var on = "";
	
	reader.onload = function() {									
								
		var oImg = ($('<div>').attr('id', 'img-cover'+num)
			.addClass('cover_img')
			.css({'background-image':'url('+reader.result+')'})										
		).on({
			'click': function() { onImage(reader.result, num) }
		});

		oImg.append($('<img>').attr('src', reader.result)
			.data('fileData', files)
			.css({'width':'0','height':'0'})										
		);

		$('#fileList').append(oImg);										
		
		$('#dragInfo').hide();
		$('#dropZone').css({'background':'url('+reader.result+')', 'background-repeat' : 'no-repeat', 'background-position':'center' , 'background-size':'cover' , 'box-sizing':'border-box'});
	};						
}			


$(function(){
	$('#secondNext').on('click',function (e) {

		e.preventDefault();
	    
	    //버튼이벤트의 data-num 값 가져오기
	    var num = $(this).attr('data-num');
	    
		// 수업 제목 확인 
		if($('#Title').val() == '' ){ 
			alert('수업 이름을 입력하세요');
			$('#Title').focus();
			return false;
		}
		
		var pattern = /[`~!@#$%^&*|\\\'\";:\/?]/gi;
		if(pattern.test($('#Title').val()) == true){
			alert('제목에 특수문자를 입력하지 마세요');
			$('#Title').focus();
			return false;
		}
		
		// 지역 입력 여부확인
		if($('#address').val() == ''){
			alert('수업 지역을 선택해주세요.')
			$('#address').focus();
			return false;
		}
		
		
		// 인원선택 여부 확인 max min 체크
		if($('#groupOption').val()==1)
		{	
			var minp = parseInt($('#MinPerson').val());
			var maxp = parseInt($('#MaxPerson').val());

			if($('#MinPerson').val() == '' ){ 
				alert('그룹 최소인원수를 입력하세요');
				$('#MinPerson').focus();
				return false;
			}
			if($('#MaxPerson').val() == '' ){ 
				alert('그룹 최대인원수를 입력하세요');
				$('#MinPerson').focus();
				return false;
			}
			if(minp > maxp ){ 
				alert('그룹 최대인원수가 최소인원수보다 작습니다');
				$('#MinPerson').focus();
				return false;
			}
		}
		
		var images = $('#fileList img')
		
		if(images.length <1){
			alert('커버이미지를 업로드 해주세요');
			return false;
		}
		
		
		if($('#CateSub').val() == '' || $('#CateSub').val() == null){ 
			alert('카테고리를 선택하세요');
			$('#CateSub').focus();
			return false;
		}

/*		$("input[type=text]").each(function() {
			if($(this).val() == "") {				
				$(this).attr("disabled",true);
			}
		});*/
		nextClassPage(num);
		return true;
		
	});

});


/////////////////////////////////////////////////////////////////////////

///////////////// 세번째페이지 JS /////////////////////////////////////

function formatMoney(val) {
	if (val.length < 4)
		return val;
	return formatMoney(val.substring(0, val.length - 3)) + ',' + val.substring(val.length - 3, val.length);
}

function updateCalculation() { 		
	var unitPrice = Number($('#UnitPrice').val());
	var time = Number($('#Time').val());
	var totalTimes = Number($('#TotalTimes').val());

	var x = $('#TotalTimes').val();
	if(x && x.length > 0) {
		if(!$.isNumeric(x)) {
			x = x.replace(/[^0-9]/g,"");
		}
		$('#TotalTimes').val(x);
	}
	
	$('#calc-unit-price').text(formatMoney(unitPrice.toString()));
	$('#calc-time').text(time);
	$('#calc-total-times').text(totalTimes);

	$('#calc-result').text(formatMoney((unitPrice * time * totalTimes).toString()));

}

$(function(){
	
	$('#UnitPrice').on('change',function(){updateCalculation()});
	$('#Time').on('change',function(){updateCalculation()});
	$('#TotalTimes').on('change',function(){updateCalculation()});


	 $('#thirdNext').on('click',function (e) {
        e.preventDefault();
      //버튼이벤트의 data-num 값 가져오기
	    var num = $(this).attr('data-num');
	    
	    // 시간당 가격 입력 여부
		if($('#UnitPrice').val() == '' ){ 
			alert('시간당 가격을 입력하세요');
			$('#UnitPrice').focus();
			return false;
		}
		
		// 0원설정 할수 없게 체크
		if($('#UnitPrice').val() == '0' ){ 
			alert('0원으로 변경시 결제 취소됩니다.\n가격을 확인 바랍니다.');
			$('#UnitPrice').focus();
			return false;
		}
		if($('#Time').val() == '0' ){ 
			alert('1회 수업시간을 입력하세요');
			$('#Time').focus();
			return false;
		}
		if($('#TotalTimes').val() == '0' ){ 
			alert('총 수업횟수를 입력하세요');
			$('#TotalTimes').focus();
			return false;
		}
		nextClassPage(num);
		return true;
	});
	
	// 수업 횟수 지정시 상세페이지  append 이벤트
	$('#TotalTimes').on('change',function(){
		let cnt = $(this).val();
		$('#curries').empty();
		for (var i = 1; i <= cnt; i++) {
			$('#curries').append("<div class='curri inner1' id='Curri"+ i +"'>" +
						"<div class='index'>" +
						"<b>"+ i +"</b>회차" +
						"</div>" +
						"<div class='box'>" +
						"<textarea class='basic len980 form-control' placeholder='커리큘럼을 입력해 주세요.' " +
						"id='Curriculum"+ i +"' name='curriculum[]'></textarea>"+
						"</div></div>" 
						);
		}
	});
});
/////////////////////////////////////////////////////////////

////////////// 네번째 페이지 JS /////////////////////////

$(function(){
	
	// 등록 완료 버튼 
	$('#fourthNext').on('click',function (e) {
		
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
			$(eventLoc).add

			
			('on').focus();
			return false;
		}
		$('#frm-class').submit();
		return true;
	});
	
	$('#frm-class').submit(function (e) {
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
		
		var cp = $('#cp').attr('data-contextPath');
		var formData = new FormData(this);

		var images = $('#fileList img');
		
		formData.append('ImageCnt', images.length);
		
		if(images.length < 1){
			alert('커버 사진을 업로드 하세요');
			return false;
		}
		for (var i = 0; i < images.length; i++) {
			if(typeof  $(images[i]).data('fileData') == 'undefined')
			{										
				formData.append('images', $(images[i]).attr("src"));									
			}
			else
			{										
				formData.append('images', $(images[i]).data('fileData'));
			}
		}


		$.ajax({
			type: 'POST',
			url: cp +'/class/enrollmentInsert',
			contentType: false,
			data: formData,
			dataType : 'text',
			processData: false,
			success: function (data) {
				//alert("return success");
				if(data=='success'){
					location.href =cp+"/";
				}else{
					location.href=cp+"/error";
				}
			}
		});
		
	});
	
	// Small_Category change
	$('#CateMain').on('change',function(){
		var bcategory_num = $(this).val();
		var cp = $('#cp').attr('data-contextPath');
		$.ajax({
		    type: "post",
		    dataType: "json",
		    url: cp+"/class/category",
		    data: {bcategory_num: bcategory_num},
		    success: function(data) {
		    	$("#CateSub").empty();
		    	$("#CateSub").append("<option value='0'>수업 대표 카테고리를 선택해주세요</option>");		
		    	$(data).each(function(i,scate){				
					$("#CateSub").append("<option value='"+scate.scategory_num+"'>"+scate.scategory_name+"</option>");		
				});
		    }
		});
	});
	
});















