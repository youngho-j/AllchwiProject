<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript" src="${cp }/resources/js/jquery-3.5.1.js"></script>
<style>
.imgBorder {
	border: 5px solid red;
}
</style>


<div class="container-fluid">
	<div id="content-wrapper" class="d-flex flex-column">
		<h4>이미지추가(아래 버튼을 클릭하여 이미지를 추가하세요.)</h4>

		<p>
			<a class="btn btn-primary" data-toggle="collapse"
				href="#collapseExample" role="button" aria-expanded="false"
				aria-controls="collapseExample"> 사진추가하기 </a>
		</p>
		<div class="collapse" id="collapseExample">
			<div class="jumbotron">
				<form method="post" action="${cp }/admin/insertPics"
					enctype="multipart/form-data" onsubmit="return validate();">



					<div class="form-group" id="certi">
						<label for="exampleFormControlFile1">파일 업로드</label> <input
							type="file" name="file1" id="file1" class="form-control-file"
							id="exampleFormControlFile1">
					</div>


					<button type="button" class="btn btn-primary" onclick='add_imgs()'>사진
						추가 업로드</button>
					<br> <br>
					<button type="submit" class="btn btn-primary"
						style="float: right; width: 200px;">등록</button>

				</form>

			</div>
		</div>
		<br>
		<br>
		<hr width = "100%" color = "black" size = "3">
			
		<h4>이미지 리스트(이미지를 클릭하여 선택)</h4>
		<div id="aa" style="width: 1208px;">
			<button type="button" id="prev" class="btn btn-outline-primary"
				disabled="disabled" onclick="prev()"
				style="float: left; height: 200px;">&lt;&lt;</button>
			<c:choose>
				<c:when test="${pu.totalRowCount > 5}">
					<button type="button" id="next" class="btn btn-outline-primary"
						onclick="next()" style="height: 200px; float: right">>></button>
				</c:when>
				<c:otherwise>
					<button type="button" id="next" class="btn btn-outline-primary"
						onclick="next()" disabled="disabled"
						style="height: 200px; float: right">&gt;&gt;</button>
				</c:otherwise>
			</c:choose>
			<div id="pics" style="text-align: center;">
				<c:forEach var="vo" items="${list}" varStatus="status">
					<div style="display: inline-block;">
						<img style="width: 200px; height: 200px;"
							src="${cp }/resources/mainPicsUpload/${vo.save_filename }"
							onclick="selectPics('${vo.save_filename }')"
							id="${vo.save_filename }"	
						>
						<p style="text-align: center;">${vo.org_filename }</p>
					</div>
				</c:forEach>
			</div>
		</div>


		<input type="hidden" value="${pu.pageNum}" id="pageNum"> 
		<input type="hidden" value="${pu.totalPageCount}" id="totalPageCount">
		

		<br>
		<hr width = "100%" color = "black" size = "3">
		
		<h4>선택된 이미지(더블클릭시 아래의 선택한 이미지 제거)</h4>
		<div id="imglist">
			
		</div>

		<div id="confirmBtn"></div>
		

	</div>
</div>


<script>
	var firstPic = null;
	var secondPic = null;
	var thirdPic = null;
	var arr = new Array(); 
	
	function selectPics(save_filename) {
		if($("#imglist").children().length==0){
		    arr[0]=save_filename;	
		}
		if($("#imglist").children().length==1){
			arr[1]=save_filename;
		}
		if($("#imglist").children().length==2){
			arr[2]=save_filename;
		}
		
		$("#confirmBtn").empty();
		if ($("#imglist").children().length <= 2) {		
				
			$("img[id='"+save_filename+"']").addClass("imgBorder");		// 테두리설정
			var img1 = $("<img style='width: 150px; height: 150px;' ondblclick=del(this,'"+save_filename+"')>").appendTo("#imglist"); 
			$(img1).prop("src","${cp}/resources/mainPicsUpload/" + save_filename );    	//선택된 이미지 칸에 추가		 			
		}
		
		if($("#imglist").children().length==3){
			alert("세가지 그림을 모두 선택하셨습니다.");
			firstPic = $("#imglist img:nth-child(1)").prop("src").split("/").reverse()[0];	//선택된 이미지는 3개 nth-child로 구분해 가져옴
			secondPic = $("#imglist img:nth-child(2)").prop("src").split("/").reverse()[0];
			thirdPic = $("#imglist img:nth-child(3)").prop("src").split("/").reverse()[0];
				
			$("#confirmBtn")
					.append(
							"<br><br><button type='button' style='width:240px;' class='btn btn-success'"
									+ "onclick=\"location.href='${cp}/admin/confirmPics?firstPic="
									+ firstPic + "&secondPic=" + secondPic
									+ "&thirdPic=" + thirdPic
									+ "'\">배너변경하기</button>");
		}
	}
	
	
	function del(img,save_filename){
		if($("#imglist").children().length==3){
			$("#confirmBtn").empty();
		}
		img.remove();
		$("img[id='"+save_filename+"']").removeClass("imgBorder"); 
		
		//이름을 가져와 배열서 지우기
		arr.splice(arr.indexOf(save_filename),1);
	}
	
	
	
	function content(data) {
		$("#pics").empty();
		$.each(data,function(i, pic) {
			var save_filename = pic.save_filename;
			var org_filename = pic.org_filename;

			var div = $("<div style='display:inline-block;'></div>").appendTo("#pics");
			$(div).append("<img style='width: 200px; height: 200px;' src='${cp }/resources/mainPicsUpload/"
							+ save_filename+ "' onclick=\"selectPics('"+ save_filename + "')\" id='"+save_filename+"'>");
			$(div).append("<p style='text-align: center;'>"+ org_filename + "</p>");
		});
		// empty후에 사라진 border유지 작업
		var qwe1= arr[0];
		var qwe2= arr[1];
		var qwe3= arr[2];	
		
		$("img[id='"+qwe1+"']").addClass("imgBorder"); 
		$("img[id='"+qwe2+"']").addClass("imgBorder"); 
		$("img[id='"+qwe3+"']").addClass("imgBorder"); 	
	}
	

	

	var pageNum = Number(document.getElementById("pageNum").value);
	var totalPageCount = Number(document.getElementById("totalPageCount").value);

	function prev() {
		$.ajax({
			url : "${cp}/admin/changePics2",
			dataType : "json",
			data : {
				"pageNum" : pageNum - 1,
			},
			success : function(data) {
				content(data);
			}
		})
		pageNum--;
		$("#pageNum").val(pageNum);
		button(pageNum);
	}

	function next() {
		$.ajax({
			url : "${cp}/admin/changePics2",
			dataType : "json",
			data : {
				"pageNum" : pageNum + 1,
			},

			success : function(data) {
				content(data);	
			}
		})
		pageNum++;
		$("#pageNum").val(pageNum);
		button(pageNum, totalPageCount);
	}

	function button(pageNum, totalPageCount) {
		if (pageNum == 1) {
			$("#prev").attr('disabled', true);
		} else {
			$("#prev").attr('disabled', false);
		}

		if (totalPageCount == pageNum) {
			$("#next").attr('disabled', true);
		} else {
			$("#next").attr('disabled', false);
		}
	}



	// 사진 추가 함수
	function add_imgs() {
		$('#certi')
				.append(
						"<label for='exampleFormControlFile1'>파일 업로드</label>"
								+ "<input type='file' name='file1' class='form-control-file'"+
						" id='exampleFormControlFile1'>");
	}

	function validate() {
		//alert(document.getElementsByName("file1").length+"배열 갯수");
		var file1 = document.getElementsByName("file1");

		for (var i = 0; i < file1.length; i++) {
			if (file1[i].value == null || file1[i].value == "") {
				alert("파일을 업로드 해주세요.");
				return false;
			}
		}
		return true;
	}

	
	
	
</script>


