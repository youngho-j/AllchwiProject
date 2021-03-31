<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
.container {
    max-width: 1040px;
    margin: 0 auto;
    margin-top: 50px;
}
.h2 {
    font-weight: 500;
    font-size: 26px;
    line-height: 1.45;
    letter-spacing: -0.6px;
    display: inline-block;
}
.mb30 {
    margin-bottom: 30px;
}
.media{
	background-color: black;
}
.title{
	margin: 10px;
	border-bottom: 1px solid #e4e4e4
}
.playVideo{
	margin: 10px 10px 10px 10px;
	padding-bottom :20px;
	border-bottom: 1px solid #e4e4e4
}
.cont{
	margin: 10px;
	padding-bottom: 30px;
	border-bottom: 1px solid #e4e4e4
	
}
.listBtn{
	float: right;
}

</style>
<div class="container">
	<div class="title">
		<button type="button" class="btn btn-primary listBtn" onclick="location.href='${cp}/community/mediaList'" >목록</button>
		<h2 class="h2 mb30">${vo.online_title }</h2>	
	</div>
	<div class=playVideo id="vodCurri">
		<video width="100%" height="500px" class="media"  controls autoplay="autoplay" id="video" >
       		<source src="${cp}/video/${vo.online_file}" type="video/mp4">
      		Your browser does not support the video tag.
     	</video>
	</div>
	<div class="cont">
		${vo.online_content}
	</div>
	<input type="hidden" id="online_num" value="${vo.online_num }">
</div>


<script type="text/javascript">
	
var video = $('#video').get(0);

video.onloadeddata = function() {
	
	var savaTime = ${view_point};
	if(savaTime > 0){
		video.pause();
		if(confirm("이어보기가 가능합니다.") == false){
			savaTime = 0;
		}
		
	}
	video.currentTime = savaTime;
	video.play();
};
	
$(window).bind('beforeunload',function(e){
	var saveTime = parseInt($('#video')[0].currentTime);

	if(saveTime > 180){
		var fd = new FormData();
		fd.append('saveTime', saveTime);
		fd.append('online_num', $('#online_num').val());
		
		//브라우저에서 지원하는 비동기 서버통신
		navigator.sendBeacon('${cp}/community/saveTime', fd);
	}
});


</script>