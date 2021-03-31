<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
.title-box {
	position: relative;
	padding-top: 60px;
	border-bottom: 1px solid #e4e4e4;
	margin-bottom: 40px;
	overflow: hidden;
}

.title-box h1 {
	float: left;
	font-size: 26px;
	color: #333;
	line-height: 1.85;
	padding-bottom: 10px;
}

.btn_write {
	padding: 10px 20px;
	border-radius: 10px;
	background-color: #ff936f;
	float: right;
	color: white;
	margin-top: 10px;
}

.qna_wrap {
	width: 80%;
	margin: auto;
	background: #eaecf4;
	padding: 80px;
	
}
.qna_list ul li {
	border-bottom: 1px solid #e5e5e5;
	padding: 10px 0;
	cursor: default;
}

.qna_list ul {
	margin-right: 40px;
}

.qna_box{
	
    margin-top: 70px
}
.qna_list {
	border: 1px solid #d4cdcd;
	margin-top: 65px;
	background: white;
}

.reply_box {
	margin-top: 20px;
}

#reply_send {
	width: 100px;
	height: 85px;
	margin-top: -15px;
	margin-left: 24px;
}
.btn{
	width: 100px;
	height: 85px;
	margin-left: 24px;
}
.reply_box {
	margin-top: 20px;
}

#reply_send {
	width: 100px;
	height: 85px;
	margin-top: -15px;
	margin-left: 24px;
}
.editbtn{
	float: right;
    margin-top: -22px;
    color: #4e73df;
}
</style>
<div class="container">
	<div class="title-box">
		<h1>Q&amp;A</h1>
	</div>
	<div class="qna_wrap">
	<input type="hidden" id="commu_num" value="${commuInfo.commu_num }"> 
	<input type="hidden" id="ml_num" value="${ml_num }"> 
		<div class="write_box">
			<textarea type="text" id="qna_content"
				class="md-textarea form-control" rows="4"></textarea>
	
			<div class="btn_write">
				<a href="javascript:void(0);" id="write_qna">문의하기</a>
			</div>
		</div>
		<!-- qna 리스트 시작 -->
		<div class="qna_box"></div>
	</div>
</div>
<script>
$(function(){
	qnaList(1);

});
$(document).on('click', '#write_qna', function () {
	var qna_content = $('#qna_content').val();
	var commu_num = $('#commu_num').val( );
	var ml_num = $('#ml_num').val();
	if(qna_content== '' ){
		alert('내용을 작성해주세요');
	}else{
		commu_num=commu_num;
		ml_num=ml_num;
		if (ml_num=='') {
			alert('로그인이 필요합니다');
		}else {
			$.post('${cp}/community/insertQna', {
				commu_num: commu_num,
				ml_num: ml_num,
				qna_content:qna_content,
				qna_lev: '0'
			}, function (data,res) {
				if (res=='success') {
					qnaList(1);
					alert('문의등록 성공');
					$("#qna_content").val("");
				} else {				
					alert('문의실패');
				}
			});
		}
	}
});
//qna목록
function qnaList(pageNum){
	var commu_num = $('#commu_num').val();
	 $.getJSON("${cp}/community/qnalist?commu_num="+ commu_num+"&pageNum="+pageNum, function(data){
	  var str = "";
	  var qlist=data.qlist;
	  var pu=data.pu;
	  var ml_num = $('#ml_num').val();
	  $(qlist).each(function(i){
	   var qna_regdate = new Date(qlist[i].qna_regdate);
	   qna_regdate = qna_regdate.toLocaleDateString("ko-US");
	   str += "<div class='qna_list'>" 
		 + "<ul>"
		 + "<li>"
		 + "<input type='hidden' id='qna_ref' value='"+qlist[i].qna_ref+"'>"
	     + "<dl>"
	     + "<dt>"
	     + "<p class='profile_img' style='width: 50px; height: 50px; background-size: cover; background-position: center;"
	     + " background-image: url(${cp}/mypageImg/getimg?pro_num="+qlist[i].pfv.pro_num+");"
	     + " border-radius: 50%;'></p>"
	     + "<p class='name'>"+qlist[i].miv.mb_name+"</p>"
	     + "</dt>"
	     + "<div class='qna_content' id='qna_content"+qlist[i].qna_num+"'>" + qlist[i].qna_content  + "</dd>"
	     + "<dd class='date'>" + qna_regdate + "</dd>"
	     + "</dl>";
	     if(ml_num==qlist[i].ml_num){
	    	 str+= "<div class='editbtn' id='editbtn"+qlist[i].qna_num+"'>"
			 + "<a type='button' onclick='editBox("+qlist[i].qna_num+")'>수정</a>"
			 + "<a type='button' onclick='delQna("+qlist[i].qna_num+")'>&nbsp&nbsp삭제</a>"
			 + "</div>";
	     }
	     str+= "</li>"
	     + "<a type='button' class='showreply' onclick='replyList("+qlist[i].qna_ref+")' data-toggle='collapse' data-target='#reply"+this.qna_ref +"'>"
		 + "댓글보기</a>"
		 +"<div class='reply_box collapse' id='reply"+qlist[i].qna_ref+"'>"
		 +"<table>"
		 +"<tr>"
		 +"<td>"
		 +"<form>"
		 +"<div class='form-group'>"
		 +"<textarea class='form-control reply_content' id='reply_content"+qlist[i].qna_ref+"' cols='60' rows='3'></textarea>"
		 +"</form>"
		 +"</td>"
		 +"<td>"
		 +"<input type='button' id='reply_send' onclick='sendReply("+qlist[i].qna_ref+")' class='btn btn-primary' value='등록'>"
		 +"</td>"
		 +"</tr>"
		 +"</table>"
		 +"</div>"
		 +"<div class='reply_list' id='reply"+qlist[i].qna_ref+"'>"
		 +"<ul>"
		 +"</ul>"
		 +"</div>"
		 +"</div>"
		 +"</ul>"
		 +"</div>";
		
	  });
	  if(qlist!=''){
		  str+="<div id='paging'>"
			  + "<ul class='pagination justify-content-center' style='margin: 20px 0'>"
			      if(pageNum > pu.startPageNum){
			    	  str+="<li class='page-item'>" 
			    		  +"<a class='page-link' onclick='currPage("+(pageNum- 1)+")'>이전</a></li>";
			      }else{
			    	  str+= "<li class='page-item disabled'>" 
		    	  		+"<a class='page-link' href='#'>이전</a></li>"; 
			      }
		  
		  for (var j = pu.startPageNum; j <= pu.endPageNum; j++) {                                    
		      if(j == pageNum) {
		         str+="<li class='page-item'>"  
		        	 +"<a class='page-link active' style='background:#7185bb; color:white;'>"+j+"</a></li>";
		      } else {
		    	  str+= "<li class='page-item' onclick='currPage("+j+")'>"
		    	  		+"<a class='page-link'>"+j+"</a>"
		    	  		+"</li>";
		         
		      }
	      }      
			  if(pu.totalPageCount>pageNum){
		    	  str+="<li class='page-item'>" 
		    		  +"<a class='page-link' onclick='currPage("+(pageNum+ 1)+")'>다음</a></li>";
		      }else{
		    	  str+= "<li class='page-item disabled'>" 
			  		+"<a class='page-link' href='#'>다음</a></li>"; 
		      }
		  +"</ul>"
		  +"</div>";
		}
	
	  	$(".qna_box").html(str);
	 });
}
function currPage(pageNum){
	qnaList(pageNum);
}
//qna답변 작성

function sendReply(qna_ref) {
	var reply_content=$("#reply_content"+qna_ref).val();
	var commu_num = $('#commu_num').val();
	var ml_num = $('#ml_num').val();
	if(reply_content== '' ){
		alert('내용을 작성해주세요');
	}else{
		let class_num = ${commuInfo.class_num}
		$.getJSON("${cp}/replyAuth", {
					ml_num : ml_num,
					class_num : class_num				
				}, function(data) {
					//댓글작성 권한 구분
					if (data.code == 'success') {
						console.log("성공");
						$.post('${cp}/community/qnareply', {
							commu_num: commu_num,
							ml_num: ml_num,
							qna_content: reply_content,
							qna_lev: '1',
							qna_ref: qna_ref
						}, function (data,res) {
							if (res=='success') {
								alert('답변등록 성공');
								$("#reply_content"+qna_ref).val("");
								replyList(qna_ref);
							} else {				
								alert('답변실패');
							}
						});
					} else {
						alert('답변은 튜터만 작성할 수 있습니다');
					}
		});
	}
		
}

//qna댓글목록불러오기
function replyList(qna_ref) {
	 var commu_num = $('#commu_num').val();
	 $.getJSON("${cp}/community/commlist?commu_num=" + commu_num + "&qna_ref=" + qna_ref
			 , function(data){
	  var str = "";
	  $(data).each(function(){
	    var qna_regdate = new Date(this.qna_regdate);
	    qna_regdate = qna_regdate.toLocaleDateString("ko-US");
	   str +="<li>"
		   	+"<dl>"
			+"<dt>"				
			+"<p class='profile_img' style='width:26px; height: 26px; background-size: cover; background-position: center;"					
			+ "background-image: url(${cp}/mypageImg/getimg?pro_num="+this.pro_num+")'>"
			+"<p class='name'>"+ this.tutor_nickname +"</p>"
			+"</dt>"					
			+"<dd>"+this.qna_content+"</dd>"
			+"<dd class='date'>"+ qna_regdate+ "</dd>"
			+"</dl>"		
			+"</li>"  
			+"</ul>"
			+"</div>";
	  });
	  $("#reply"+qna_ref+" ul").html(str);
	 });
}
function editBox(qna_num) {
	var str = "<table><tr><td>"
			+ "<textarea class='form-control edit_content' id='edit_content' cols='60' rows='3'>"
			+"</textarea></td>"
			+"<td><input type='button' onclick='editQna("+qna_num+")' class='btn btn-primary'" 
			+"value='수정하기'></td></tr></table>";
	 $("#editbtn"+qna_num).html(str);
}
//qna 수정
function editQna(qna_num) {
	var edit_content=$("#edit_content").val();
	if(edit_content== '' ){
		alert('수정할 내용을 작성해주세요');
	}else{
		$.post('${cp}/community/editQna', {
			qna_num:qna_num,
			qna_content:edit_content
		}, function (data,res) {
			if (res=='success') {
				qnaList(1);
				alert('수정성공');
				$("#qna_content").val("");
			} else {				
				alert('수정실패');
			}
		});
	}
	
}
//qna 삭제
function delQna(qna_num){
	$.ajax({
		url : "${cp }/community/delQna?qna_num="+qna_num,
		success : function(data) {
			if (data == "success") {
				alert("삭제성공");
				location.href = "${cp}/community/qna"
			} else {
				alert("삭제실패");
			}

		}
	});
}

</script>