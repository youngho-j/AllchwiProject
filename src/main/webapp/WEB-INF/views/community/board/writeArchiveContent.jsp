<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="container">


	<div class="jumbotron">
		<h4>자료올리기</h4>
		<hr class="my-4">
		<div class="card card-body">
			<form method="post" enctype="multipart/form-data" action="${cp }/community/writeContentOk">
	
				<div class="form-group">
					<label for="exampleFormControlInput1">글제목</label> <input
						type="text" name="room_title" class="form-control" id="exampleFormControlInput1"
						placeholder="글제목을 입력해주세요.">
				</div>
				<div class="form-group">
					<label for="exampleFormControlSelect1">말머리를 선택해 주세요.</label> 
					<select name="horsehead" class="form-control" name="room_content" id="exampleFormControlSelect1">
						<option value=1>과제</option>
						<option value=2>참고자료</option>
						<option value=3>수업자료</option>
					</select>
				</div>
				
				<div class="form-group">
					<label for="exampleFormControlTextarea1">글내용</label>
					
					<textarea class="form-control" name="room_content" id="exampleFormControlTextarea1"
						rows="3"></textarea>
				</div>
		 
				<div class="form-group">
					<label for="exampleFormControlFile1">파일 업로드</label> <input
						type="file" name="file1" class="form-control-file" id="exampleFormControlFile1">
				</div>	
		
				<button type="submit" class="btn btn-primary">등록</button>
			</form>
		</div>
	</div>
</div>