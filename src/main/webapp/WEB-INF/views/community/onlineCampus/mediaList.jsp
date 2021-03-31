<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<style>
.container {
    max-width: 1040px;
    margin: 0 auto;
    margin-top: 50px;
}
.sect-curri .h2 {
    position: relative;
}
.h2 {
    font-weight: 500;
    font-size: 26px;
    line-height: 1.45;
    letter-spacing: -0.6px;
}
.mb30 {
    margin-bottom: 30px;
}
.sect-curri .h2 span {
    position: absolute;
    right: 0;
    top: 8px;
    padding-left: 25px;
    font-size: 16px;
    background: url(https://front-img.taling.me/Content/Images/Vod/icon_vod_curriculum.png) no-repeat left center;
    background-size: 20px;
}
li {
    list-style: none;
}
.curriculum ol h3 {
    position: relative;
    padding: 15px 20px;
    font-size: 18px;
    letter-spacing: -0.45px;
    font-weight: 500;
    color: #fff;
    background-color: #393b42;
}
.curriculum ol .more-text {
    position: absolute;
    right: 20px;
    top: 15px;
    font-size: 14px;
    font-weight: normal;
}
ul {
    list-style: none;
    padding-left: 0px;
}
.curriculum .lecture li {
    margin: 30px 0;
    position: relative;
}
.curriculum .lecture li .thumb {
    display: inline-block;
    width: 272px;
    height: 160px;
}
.thumb {
    overflow: hidden;
    border-radius: 6px;
}
.curriculum .lecture li a {
    display: block;
    height: 100%;
}
.thumb img {
    width: 100%;
    height: 100%;
    -o-object-fit: cover;
    object-fit: cover;
}
.curriculum .lecture li .txt {
    float: right;
    width: -webkit-calc(100% - 306px);
    width: -moz-calc(100% - 306px);
    width: calc(100% - 306px);
    padding-left: 30px;
    padding-right: 20px;
    background: url(https://front-img.taling.me/Content/Images/Vod/icon_vod_curriculum.png) no-repeat left 8px;
    background-size: 20px 20px;
}
.curriculum .lecture li .tit {
    display: block;
    float: left;
    width: -webkit-calc(100% - 40px);
    width: -moz-calc(100% - 40px);
    width: calc(100% - 40px);
    font-size: 16px;
    color: #111;
    font-weight: bold;
    line-height: 32px;
}
.curriculum .lecture li .time {
    float: right;
    width: 40px;
    line-height: 32px;
    text-align: right;
}
.button_gray{
	padding: 9px;
    box-sizing: border-box;
    background: #393b42;
    text-align: center;
    font-size: 14px;
    color: #fff;
    border-radius: 4px;
    letter-spacing: -0.35px;
    width: 100px;
    height: 38px;
    float: right;
}
.cursor{
	cursor: pointer;
}
</style>
    
<div class="container">
<div class="container">
	<h2 class="h2 mb30">온라인 강의
	<c:if test="${commuInfo.ml_num==ml_num}">
		<div class="button_gray cursor" onclick="writeShow()">강의업로드</div>
	</c:if>
	</h2>
	<div class=curriculum id="vodCurri">
		<ol>
			<c:forEach var="vo" items="${list}">
				<fmt:formatNumber var="min" value="${vo.online_time/60}" pattern="0"/>
				<fmt:formatNumber var="sec" value="${vo.online_time%60}" pattern="00"/>
				<li class="lst">
					<h3>
						${vo.online_title }
						<c:if test="${commuInfo.ml_num==ml_num}">
							<div class="dropdown more-text">
					            <button type="button" style="margin-top: -10px;" class="btn btn-default dropdown toggle" data-toggle="dropdown">
								<svg class="cursor"  width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-three-dots-vertical" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
				 					 <path fill-rule="evenodd" d="M9.5 13a1.5 1.5 0 1 1-3 0 1.5 1.5 0 0 1 3 0zm0-5a1.5 1.5 0 1 1-3 0 1.5 1.5 0 0 1 3 0zm0-5a1.5 1.5 0 1 1-3 0 1.5 1.5 0 0 1 3 0z"/>
								</svg>
					            <span class="caret"></span></button>
					            <ul class="dropdown-menu" role="menu">
					                <li style="text-align: center; margin-bottom: 17px"><a href="#" onclick="updateShow(${vo.online_num})"><font style="font-size: 14px; color: black;">수업 수정</font></a></li>
					                <li style="text-align: center;"><a href="#" onclick="delClass(${vo.online_num});$(this).parent().parent().parent().parent().parent().remove()">
					                <font style="font-size: 14px; color: black;">수업 삭제</font></a></li>
					            </ul>
				       		</div>
			       		</c:if>
			        
					</h3>
					<div class="lecture">
						<ul>  
							<li>
								<div class="thumb">
									<a href="${cp}/community/video?online_num=${vo.online_num}">
									<img src="${cp}/onlineImg/getimg?online_num=${vo.online_num}" alt="">
									</a>
								</div>
								<div class="txt">
									<a href="${cp}/community/video?online_num${vo.online_num}">
									<span class="tit">${vo.online_title }</span>
									<span class="time">${min}:${sec}</span>
									</a>
									<p>${vo.online_content }</p>
								</div>
							</li>
						</ul>
					</div>
				</li>
			</c:forEach>
		</ol>
		<div style="padding-top:100px">
				<ul class="pagination justify-content-center" style="margin: 20px 0">
				<c:choose>
					<c:when test="${pu.startPageNum>1 }">
						<li class="page-item"><a class="page-link"
							href="${cp }/community/mediaList?pageNum=${pu.startPageNum-1 }">이전</a></li>
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
								href="${cp }/community/mediaList?pageNum=${i }">${i }</a></li>
						</c:when>
						<c:otherwise>
							<li class="page-item"><a class="page-link"
								href="${cp }/community/mediaList?pageNum=${i }">${i }</a></li>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				
				<c:choose>
					<c:when test="${pu.totalPageCount>pu.endPageNum }">
						<li class="page-item"><a class="page-link"
							href="${cp }/community/mediaList?pageNum=${pu.endPageNum+1 }">다음</a></li>
					</c:when>
					<c:otherwise>
						<li class="page-item disabled"><a class="page-link" href="#">다음</a></li>
					</c:otherwise>
				</c:choose>
			</ul>
			</div>
	</div>
</div>
	<div class="modal-container"></div>
</div>


<script>
function writeShow(){		
	var url = "${cp}/community/mediaModal";
	   $('.modal-container').load(url,function(result){
		$('#myModal').modal();
	});		
}
function updateShow(online_num){		
	var url = "${cp}/community/mediaModal?online_num="+online_num;
	   $('.modal-container').load(url,function(result){
		$('#myModal').modal({backdrop: 'static', keyboard: false});
	});		
}
function delClass(online_num){
	
	
	if( confirm("정말 삭제히시겠습니까?")==true){
		$.ajax({
		    type: "post",
		    dataType: "text",
		    url: "${cp}/community/onlineDelte",
		    data: {online_num: online_num},
		    success: function(data) {
		    	if(data == 'success'){
		    		alert('삭제 되었습니다.');
		    	}else{
		    		alert('삭제 실패!!!')
		    	}
		    }
		});
	}else{
		return;
	}
	
}

</script>