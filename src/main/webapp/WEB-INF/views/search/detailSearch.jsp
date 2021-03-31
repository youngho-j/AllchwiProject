<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script src="${cp}/resources/vendor/jquery/jquery.min.js"></script>
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.22.2/moment.min.js"></script>
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/tempusdominus-bootstrap-4/5.0.1/js/tempusdominus-bootstrap-4.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/tempusdominus-bootstrap-4/5.0.1/css/tempusdominus-bootstrap-4.min.css" />
<link rel="stylesheet"
	href="${cp}/resources/css/search/detailSearch.css">
<script>


</script>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
 
  <div class="collapse navbar-collapse" id="navbarNavDropdown">
    <ul class="navbar-nav"> 
    <!-- big_category -->
      <c:forEach var="blist" items="${bigcalte_list }"> 
     	 <li class="nav-item dropdown">
      		<div class="nav-link dropdown-toggle" role="button" aria-haspopup="true" aria-expanded="false">
	          	<a href="${cp }/list/search?bcategory_num=${blist.bcategory_num}">${blist.bcategory_name }</a>
	       	</div>
	      <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
    <!-- 선택한 big_category에 해당하는 small_category -->
      		<c:forEach var="slist" items="${smallcate_list }"> 
	      		<c:if test="${blist.bcategory_num == slist.bcategory_num }">
					<a class="dropdown-item" href="${cp}/list/search?scategory_num=${slist.scategory_num}">${slist.scategory_name}</a>	        			
				</c:if>
	     	</c:forEach>
	      </div>
	    </li>		
      </c:forEach>
    </ul>
    
	    <p>
		  <a class="btn btn-primary" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
		    	상세검색
		  </a>
		</p>
		
	  </div>
</nav>

<div class="collapse" id="collapseExample">

	  	<div class="jumbotron">

			<nav>
				<div class="nav nav-tabs" id="nav-tab" role="tablist">
					<a class="nav-item nav-link active" id="nav-home-tab"
						data-toggle="tab" href="#nav-home" role="tab"
						aria-controls="nav-home" aria-selected="true">오프라인</a> <a
						class="nav-item nav-link" id="nav-profile-tab" data-toggle="tab"
						href="#nav-profile" role="tab" aria-controls="nav-profile"
						aria-selected="false">온라인</a>
		
				</div>
			</nav>
			<div class="tab-content" id="nav-tabContent">
				<div class="tab-pane fade show active" id="nav-home" role="tabpanel"
					aria-labelledby="nav-home-tab">
					<form class="form-inline" action="${cp }/list/search">
					<!-- header 검색창을 통해 검색했을 때만 keyword가 나타나도록 ..-->
						<c:if test="${!empty keyword }">
							<p>
								<h5>" ${keyword } " 키워드로 상세 검색하기</h5>
						    </p>
						</c:if> 
				
						<br>
						<input type="hidden" name="keyword" value="${keyword }">
						<input type="hidden" name="scategory_num" value="${scategory_num }">
						<input type="hidden" name="bcategory_num" value="${bcategory_num }">
						<div class="label-1">
							지역
						</div> 
						<select class="custom-select my-1 mr-sm-2"
							id="BigLoc">
							<option selected value="0">선택</option>
								<c:forEach var="vo" items="${bloc_list }">
									<option value="${vo.bloc_num }">${vo.bloc_name }</option>
								</c:forEach>
						</select> 
						<select class="custom-select my-1 mr-sm-2" id="SmallLoc" name="sloc_num">
							<option value='0'>세부 지역 선택</option>
						</select> <br>
						<div class="label-1">
							기간
						</div> 
						<div class='col-md-3'>
							<div class="form-group">
								<div class="input-group date" id="datetimepicker7"
									data-target-input="nearest">
									<input type="text" class="form-control datetimepicker-input"
										data-target="#datetimepicker7" name="startDate" />
									<div class="input-group-append" data-target="#datetimepicker7"
										data-toggle="datetimepicker">
										<div class="input-group-text">
											<i class="fa fa-calendar"></i>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="text-div"><span class="text-1">~</span></div>
						<div class='col-md-3'>
							<div class="form-group">
								<div class="input-group date" id="datetimepicker8"
									data-target-input="nearest">
									<input type="text" class="form-control datetimepicker-input"
										data-target="#datetimepicker8"  name="endDate" /> 
									<div class="input-group-append" data-target="#datetimepicker8"
										data-toggle="datetimepicker">
										<div class="input-group-text">
											<i class="fa fa-calendar"></i>
										</div>
									</div>
								</div>
							</div>
						</div>
		
						<br>
						<input type="hidden" name="class_form" value="0">
						<button type="submit" class="btn btn-primary my-1"
							id="detailSearchBtnOffline">오프라인 수업찾기</button>
					</form>
		
				</div>
		
		
		
		
		
				<!-- @@@@@온라인 검색탭@@@@@@ -->
				<div class="tab-pane fade" id="nav-profile" role="tabpanel"
					aria-labelledby="nav-profile-tab">
					<form class="form-inline" action="${cp }/list/search">
						<c:if test="${!empty keyword }">
							<p><h5>" ${keyword } " 키워드로 상세 검색하기</h5></p>
						</c:if> 
						<br>
						<div class="label-1">
							기간
						</div> 
						<div class='col-md-3'>
							<div class="form-group">
								<div class="input-group date" id="datetimepicker9"
									data-target-input="nearest">
									<input type="text" class="form-control datetimepicker-input"
										data-target="#datetimepicker9" name="startDate" />
									<div class="input-group-append" data-target="#datetimepicker9"
										data-toggle="datetimepicker">
										<div class="input-group-text">
											<i class="fa fa-calendar"></i>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="text-div"><span class="text-1">~</span></div>
						<div class='col-md-3'>
							<div class="form-group">
								<div class="input-group date" id="datetimepicker10"
									data-target-input="nearest">
									<input type="text" class="form-control datetimepicker-input"
										data-target="#datetimepicker10"  name="endDate" /> 
									<div class="input-group-append" data-target="#datetimepicker10"
										data-toggle="datetimepicker">
										<div class="input-group-text">
											<i class="fa fa-calendar"></i>
										</div>
									</div>
								</div>
							</div>
						</div>
		
						<br>
						<div class="label-1">
							수업형태
						</div> 
						<div class="btn-group btn-group-toggle" data-toggle="buttons" style="display: inline-flex;">
							<label class="btn btn-secondary active"> 
								<input type="radio" name="class_month" value="1" checked> 1개월
							</label> 
							<label class="btn btn-secondary"> 
								<input type="radio" name="class_month" value="2"> 2개월
							</label> 
							<label class="btn btn-secondary"> 
								<input type="radio" name="class_month" value="3"> 3개월
							</label> 
						</div>
		
						<br><br>
						<input type="hidden" name="class_form" value="1">
						<button type="submit" class="btn btn-primary my-1"
							id="detailSearchBtnOnline">온라인 수업찾기</button>
					</form>
		
				</div>
			</div>

		</div>

	</div> 


<div class="jumbotron">
<h1>${bcategory_name }</h1>
<h3>${scategory_name }</h3>

<!-- 	<select class="custom-select my-1 mr-sm-2"
		id="inlineFormCustomSelectPref2">
		<option selected value="1">정확도순</option>
		<option value="2">최신순</option>
		<option value="3">인기순</option>
	</select> <br>

 -->
	<div class="row" id="searchList">

		<c:choose>
			<c:when test="${!empty list }">
				<c:forEach var="vo" items="${list }" varStatus="status">
				<div class='col-md-4'>
				<a href="${cp }/classDetail/detail?class_num=${vo.class_num }">
					<div class='card mb-4 shadow-sm'>
						<img class='bd-placeholder-img card-img-top' width='100%' height='225' xmlns='http://www.w3.org/2000/svg' 
						preserveAspectRatio='xMidYMid slice' focusable='false' role='img' aria-label='Placeholder: Thumbnail'
						src="${cp}/classImg/getimg?cover_num=${vo.cover_num}">
						<title>	${vo.class_title }</title>
						<div class='card-body'>
							<div class="classtitle-box">
								<text style="font-weight:bold;">${vo.class_title }</text>
							</div>
							<div class="profile_box">
                                <div class="profile">
                          			<img class="img-profile rounded-circle" src="${cp}/mypageImg/getimg?pro_num=${vo.pro_num}">
                                </div>
                                <div class="name">${vo.tutor_nickname }</div>
                                            
                            </div>
                            
							<p class='card-text' style="font-size: 0.9rem;"><fmt:formatDate value="${vo.class_date}" pattern="yyyy-MM-dd"/> 시작!</p>
							
							
							<div class='d-flex justify-content-between align-items-center'>
							<div class='btn-group'>
								
								
								<button type='button' class='btn btn-sm btn-outline-secondary'>
									${vo.bloc_name } ${vo.sloc_name }
								</button>
							</div>
							<div class="class_price"> &#8361 ${vo.class_price }</div>
							</div>
						</div>
					</div>
					</a>
				</div>
				
			</c:forEach>
			</c:when>
			<c:otherwise>
				<div class="col-md-12" style="text-align:center;padding:20%">
					<h2>검색 결과가 없습니다..</h2>
				</div>
			</c:otherwise>
		</c:choose>
	</div>

	<div style="padding-top:100px">
			<ul class="pagination justify-content-center" style="margin: 20px 0">
				<c:choose>
					<c:when test="${pu.startPageNum>1 }">
						<li class="page-item"><a class="page-link"
							href="${cp }/list/search?pageNum=${pu.startPageNum-1 }">이전</a></li>
					</c:when>
					<c:otherwise>
						<li class="page-item disabled"><a class="page-link" href="#">이전</a></li>
					</c:otherwise>
				</c:choose>
				
				<c:forEach var="i" begin="${pu.startPageNum }" end="${pu.endPageNum }">
					<c:choose>
						<c:when test="${i==pu.pageNum}">
							<li class="page-item active">
							<a class="page-link"
								href="${cp }/list/search?pageNum=${i}&scategory_num=${scategory_num}&bcategory_num=${bcategory_num}&keyword=${keyword}&sloc_num=${sloc_num}&class_form=${class_form}&class_month=${class_month}">
							${i }
							</a></li>
						</c:when>
						<c:otherwise>
							<li class="page-item">
							<a class="page-link"
								href="${cp }/list/search?pageNum=${i}&scategory_num=${scategory_num}&bcategory_num=${bcategory_num}&keyword=${keyword}&sloc_num=${sloc_num}&class_form=${class_form}&class_month=${class_month}">
							${i }
							</a></li>
						</c:otherwise>
					</c:choose>
					
				</c:forEach>
				
				<c:choose>
					<c:when test="${pu.totalPageCount>pu.endPageNum }">
						<li class="page-item"><a class="page-link"
							href="${cp }/list/search?pageNum=${pu.endPageNum+1 }">다음</a></li>
					</c:when>
					<c:otherwise>
						<li class="page-item disabled"><a class="page-link" href="#">다음</a></li>
					</c:otherwise>
				</c:choose>
			</ul>
		</div>

<input type="hidden" id="keyword" value="${keyword }">
</div>


<script>
	// date 형식에서 시간 삭제 
	$('#datetimepicker7').datetimepicker({
		format : 'YYYY-MM-DD'
	});
	$('#datetimepicker8').datetimepicker({
		format : 'YYYY-MM-DD'
	});
	$('#datetimepicker9').datetimepicker({
		format : 'YYYY-MM-DD'
	});
	
	$('#datetimepicker10').datetimepicker({
		format : 'YYYY-MM-DD'
	});
	
	
	
	//Big Location Select-Option
	$('#BigLoc').on('change',function(){
		var bloc_num = $(this).val();
		$.ajax({
		    type: "post",
		    dataType: "json",
		    url: "${cp}/locatrion/search",
		    data: {bloc_num: bloc_num},
		    success: function(data) {
		    	$("#SmallLoc").empty();
		    	$("#SmallLoc").append("<option value='0'>세부 지역 선택</option>");		
		    	$(data).each(function(i,sloc){				
					$("#SmallLoc").append("<option value='"+sloc.sloc_num+"'>"+sloc.sloc_name+"</option>");		
				});
		    }
		});
	});

			
	
</script>
