<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script type="text/javascript" src="${cp }/resources/js/jquery-3.5.1.js"></script>

<script type="text/javascript"
	src="https://www.gstatic.com/charts/loader.js"></script>




<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">


			<nav>
				<ol class="breadcrumb">
					<li class="breadcrumb-item active"><a
						href="${cp }/admin/statistic1">월별 매출액</a></li>
					<li class="breadcrumb-item"><a href="${cp }/admin/statistic3">카테고리 점유율</a></li>	
					<li class="breadcrumb-item"><a href="${cp }/admin/statistic2">인기수업 TOP 10</a></li>
					
				</ol>
			</nav>




			<!-- 현재년도 -->
			<c:set var="now" value="<%=new java.util.Date()%>" />
			<c:set var="sysYear">
				<fmt:formatDate value="${now}" pattern="yyyy" />
			</c:set>

			<button type="button" id="twoyearsago" class="btn btn-outline-secondary">
				<c:out value="${sysYear-2}" />년
			</button>
			<button type="button" id="lastyear" class="btn btn-outline-secondary">
				<c:out value="${sysYear-1}" />년
			</button>
			<button type="button" id="thisyear" class="btn btn-outline-secondary active">
				<c:out value="${sysYear}" />년
			</button>
			<button type="button" class="btn btn-success"
				style="margin-left: 718px" onclick="fnExcelReport('table','monthly sales/revenue')">엑셀 파일 다운로드</button>



			<div id="chart_div" style="width: 1146px; height: 500px;"></div>
			<div id="table_div" style="width: 1146px; height: 690px;">
				<table id="table" class="table table-hover table-bordered" style="text-align: center">
					<thead class="thead-dark">
						<tr>
							<th scope="col">월</th>
							<th scope="col">월별 수익</th>
							<th scope="col">월별매출</th>
						</tr>
					</thead>
					<tbody id="tb">

					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>



<!-- 어레이 한개 만들어놓고 어래이에 푸쉬로 -->
<script type="text/javascript">
	google.charts.load('current', {
		'packages' : [ 'corechart' ]
	});
	google.charts.setOnLoadCallback(drawChart);

	function drawChart() {
		var year = $("#thisyear").html();
		var thisyear = parseInt(year);
		var nextyear = thisyear + 1;

		$.getJSON({
			url : "${cp}/admin/statisticAjax1",
			data : {
				thisyear : thisyear,
				nextyear : nextyear
			},
			success : function(data) {
				getData(data);
			}
		});
	}

	$("#lastyear").click(function() {
		$("#twoyearsago").attr('class', "btn btn-outline-secondary");
		$("#lastyear").attr('class', "btn btn-outline-secondary active");
		$("#thisyear").attr('class', "btn btn-outline-secondary");

		google.charts.load('current', {
			'packages' : [ 'corechart' ]
		});
		google.charts.setOnLoadCallback(drawChart);

		function drawChart() {
			var year = $("#lastyear").html();
			var thisyear = parseInt(year);
			var nextyear = thisyear + 1;

			$.getJSON({
				url : "${cp}/admin/statisticAjax1",
				data : {
					thisyear : thisyear,
					nextyear : nextyear
				},
				success : function(data) {
					$("#chart_div").empty();
					getData(data);
				}
			});
		}

	});

	$("#twoyearsago").click(function() {
		$("#twoyearsago").attr('class', "btn btn-outline-secondary active");
		$("#lastyear").attr('class', "btn btn-outline-secondary");
		$("#thisyear").attr('class', "btn btn-outline-secondary");

		google.charts.load('current', {
			'packages' : [ 'corechart' ]
		});
		google.charts.setOnLoadCallback(drawChart);

		function drawChart() {
			var year = $("#twoyearsago").html();
			var thisyear = parseInt(year);
			var nextyear = thisyear + 1;

			$.getJSON({
				url : "${cp}/admin/statisticAjax1",
				data : {
					thisyear : thisyear,
					nextyear : nextyear
				},
				success : function(data) {
					$("#chart_div").empty();
					getData(data);
				}
			});
		}
	});

	$("#thisyear").click(function() {
		$("#twoyearsago").attr('class', "btn btn-outline-secondary");
		$("#lastyear").attr('class', "btn btn-outline-secondary");
		$("#thisyear").attr('class', "btn btn-outline-secondary active");

		google.charts.load('current', {
			'packages' : [ 'corechart' ]
		});
		google.charts.setOnLoadCallback(drawChart);

		function drawChart() {
			var year = $("#thisyear").html();
			var thisyear = parseInt(year);
			var nextyear = thisyear + 1;

			$.getJSON({
				url : "${cp}/admin/statisticAjax1",
				data : {
					thisyear : thisyear,
					nextyear : nextyear
				},
				success : function(data) {
					$("#chart_div").empty();
					getData(data);
				}
			});
		}
	});

	
	function getData(data) {
		var array = new Array();
		array[0] = [ '월별', '수익', '매출액' ];

		$("#tb").empty();
		$(data).each(function(i, arr) {
			var subArray = [ arr.month + "월", arr.monthlySum,arr.monthlyRevenue ];	
			if (data.length - 1 != i) { //마지막 열 데이터 담지 않기// 같지 않을때까지 넣는다.
					array[++i] = subArray;
			}
			// 여기서부터는 chart 아래 표
			var month = arr.month;
			var monthlySum = arr.monthlySum;
			var monthlyRevenue = arr.monthlyRevenue;
			monthlySum = addComma(monthlySum);
			monthlyRevenue = addComma(monthlyRevenue);
					
			var trs = $("<tr></tr>").appendTo("#tb");
				
			if (month == 0) {
				$(trs).append("<td class='table-active'>합계:</td>");
				$(trs).append(
						"<td class='table-active'>" + monthlySum+ "원</td>");
				$(trs).append("<td class='table-active'>" + monthlyRevenue+ "원</td>");
			} else {
				$(trs).append("<td>" + month + "월</td>");
				$(trs).append("<td>" + monthlySum + "원</td>");
				$(trs).append("<td>" + monthlyRevenue + "원</td>");
			}
		});
		var data2 = google.visualization.arrayToDataTable(array);
		var options = {
			title : '월별 실적  [단위:원]',
			hAxis : {
				title : '월별',
				titleTextStyle : {
					color : '#333'
				}
			},
			vAxis : {
				minValue : 0
			}
		};
		var chart = new google.visualization.AreaChart(document
				.getElementById('chart_div'));
		chart.draw(data2, options);
	}

	
	//숫자에 콤마 붙여주는 함수
	function addComma(num) {
		var regexp = /\B(?=(\d{3})+(?!\d))/g;
		return num.toString().replace(regexp, ',');
	}

	//엑셀파일 다운로드 함수
	function fnExcelReport(id, title) {
		var tab_text = '<html xmlns:x="urn:schemas-microsoft-com:office:excel">';
		tab_text = tab_text
				+ '<head><meta http-equiv="content-type" content="application/vnd.ms-excel; charset=UTF-8">';
		tab_text = tab_text
				+ '<xml><x:ExcelWorkbook><x:ExcelWorksheets><x:ExcelWorksheet>'
		tab_text = tab_text + '<x:Name>Test Sheet</x:Name>';
		tab_text = tab_text
				+ '<x:WorksheetOptions><x:Panes></x:Panes></x:WorksheetOptions></x:ExcelWorksheet>';
		tab_text = tab_text
				+ '</x:ExcelWorksheets></x:ExcelWorkbook></xml></head><body>';
		tab_text = tab_text + "<table border='1px'>";
		var exportTable = $('#' + id).clone();
		exportTable.find('input').each(function(index, elem) {
			$(elem).remove();
		});
		tab_text = tab_text + exportTable.html();
		tab_text = tab_text + '</table></body></html>';
		var data_type = 'data:application/vnd.ms-excel';
		var ua = window.navigator.userAgent;
		var msie = ua.indexOf("MSIE ");
		var fileName = title + '.xls';
		
		//Explorer 환경에서 다운로드
		if (msie > 0 || !!navigator.userAgent.match(/Trident.*rv\:11\./)) {
			if (window.navigator.msSaveBlob) {
				var blob = new Blob([ tab_text ], {
					type : "application/csv;charset=utf-8;"
				});
				navigator.msSaveBlob(blob, fileName);
			}
		} else {
			var blob2 = new Blob([ tab_text ], {
				type : "application/csv;charset=utf-8;"
			});
			var filename = fileName;
			var elem = window.document.createElement('a');
			elem.href = window.URL.createObjectURL(blob2);
			elem.download = filename;
			document.body.appendChild(elem);
			elem.click();
			document.body.removeChild(elem);
		}
	}
</script>



