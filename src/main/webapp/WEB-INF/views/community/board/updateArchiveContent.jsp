<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	
<div class="container">


	<div class="jumbotron">
		<h4>글 수정하기</h4>
		<hr class="my-4">
		<div class="card card-body">
			<form method="post" enctype="multipart/form-data" action="${cp }/community/archiveUpdateOk">
	
				<div class="form-group">
					<label for="exampleFormControlInput1">글제목</label> <input
						type="text" name="room_title" class="form-control" id="exampleFormControlInput1"
						value="${vo.room_title}">
				</div>
				<div class="form-group">
					<label for="exampleFormControlSelect1">말머리를 선택해 주세요.</label> 
					<select name="horsehead" class="form-control" name="room_content" id="exampleFormControlSelect1">
						<option value=1 <c:if test="${vo.horsehead == 1}">selected</c:if>>과제</option>
						<option value=2 <c:if test="${vo.horsehead == 2}">selected</c:if>>참고자료</option>
						<option value=3 <c:if test="${vo.horsehead == 3}">selected</c:if>>수업자료</option>
					</select>
				</div>
				
				<div class="form-group">
					<label for="exampleFormControlTextarea1">글내용</label>
					
					<textarea class="form-control" name="room_content" id="exampleFormControlTextarea1"
						rows="3">${vo.room_content}</textarea>
				</div>
				
				<div class="form-group">
					<label for="exampleFormControlFile1">기존파일</label> 
					<p>${vo.org_filename}</p>
				</div>	
		 
				<div class="form-group">
					<label for="exampleFormControlFile1">파일 업로드</label> <input
						type="file" name="file1" class="form-control-file" id="exampleFormControlFile1">
				</div>
				<input type="hidden" name="prev_save_filename" value="${vo.save_filename }">
				<input type="hidden" name="room_num" value="${vo.room_num}">
					
				<button type="submit" class="btn btn-primary">수정</button>
			</form>
		</div>
	</div>
</div>