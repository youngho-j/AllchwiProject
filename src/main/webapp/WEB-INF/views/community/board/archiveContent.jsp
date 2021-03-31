<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script type="text/javascript" src="${cp }/resources/js/jquery-3.5.1.js"></script>
<script type="text/javascript" src="${cp}/resources/vendor/bootstrap/js/bootstrap.js"></script>
<style>
#top {
	float: right;
}
#top > p{
	margin: 5px;
}
#download {
	float: right;
	margin-top: 10px;
}
#bottom {
	clear: right;
	margin-top: 10px;
}
</style>
<div class="container">
	<div class="jumbotron" style="padding: 2rem;">
		<div>
			<h4>${vo.room_title }</h4>
			<c:if test="${ml_num == commu_ml_num}">			
				<button type="button" id="updateBtn" class="btn btn-success">수정</button>
				<button type="button" id="deleteBtn" class="btn btn-secondary">삭제</button>
			</c:if>

			<div id="top">
				<p>
					등록일 :
					<fmt:formatDate value="${vo.room_regdate}"
						pattern="yyyy-MM-dd HH:mm" />
				</p>
				<p>조회수 : ${vo.room_view}</p>
			</div>
		</div>
		<hr class="my-4" style="clear: right; margin: 0px">
		<div class="card card-body" style="height: 15rem; margin-top: 25px">
			<div style="white-space: pre"><p id="room_con">${vo.room_content}</p></div>
			
			<input type="hidden" id="room_num" value="${vo.room_num }">
			<input type="hidden" id="save_filename" value="${vo.save_filename }">
			<input type="hidden" id="horsehead" value="${vo.horsehead }">
			<input type="hidden" id="org_filename" value="${vo.org_filename }">
				
		</div>
		
		
		
		<div id="download">
			<c:choose>
				<c:when test="${vo.filesize != 0 }">
					<p style="display: inline;">다운로드 &nbsp; </p><a href="${cp }/community/download?room_num=${vo.room_num }" style="text-decoration: none; color: blue;">${vo.org_filename } /${vo.filesize }바이트 </a>
				</c:when>
				<c:otherwise>
					<p>다운로드할 파일이 존재하지 않습니다.</p>
				</c:otherwise>
			</c:choose>
		</div>
		
		
		
		<div id="bottom">
			<c:choose>
				<c:when test="${prev != null }">
					<strong>이전글</strong>&nbsp&nbsp <a href="${cp }/community/archiveDetail?room_num=${prev.room_num }">${prev.room_title }</a>
				</c:when>
				<c:otherwise>
					<strong>이전글이 존재하지 않습니다.</strong>
				</c:otherwise>
			</c:choose>
			
			

			<hr class="my-2">
			<c:choose>
				<c:when test="${next != null }">
					<strong>다음글</strong>&nbsp&nbsp <a href="${cp}/community/archiveDetail?room_num=${next.room_num }">${next.room_title }</a>
				</c:when>
				<c:otherwise>
					<strong>다음글이 존재하지 않습니다.</strong>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
</div>

<script>
	$("#deleteBtn").click(function(){
		var room_num = $("#room_num").val();
		var save_filename = $("#save_filename").val();
		location.href="${cp}/community/archiveDelete?room_num="+room_num+"&save_filename="+save_filename;
	});
	
	$("#updateBtn").click(function(){
		var room_num = $("#room_num").val();
		var save_filename = $("#save_filename").val();
		var org_filename = $("#org_filename").val();
		var room_title = $("h4").text();
		var room_content = $("#room_con").text();
		var horsehead = $("#horsehead").val();
		
		location.href="${cp}/community/archiveUpdate?room_num="+room_num+"&save_filename="+save_filename+"&room_title="
				+room_title+"&room_content="+room_content+"&horsehead="+horsehead+"&org_filename="+org_filename;		
	});

	
</script>