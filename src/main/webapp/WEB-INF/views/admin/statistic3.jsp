<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
					<li class="breadcrumb-item"><a href="${cp }/admin/statistic3">카테고리
							점유율</a></li>
					<li class="breadcrumb-item"><a href="${cp }/admin/statistic2">인기수업 TOP10</a></li>
				</ol>
			</nav>

			<button type="button" class="btn btn-success" style="margin-left: 983px" 
			onclick="fnExcelReport('table','category count')">엑셀 파일 다운로드</button>

			<div id="donutchart" style="width: 1146px; height: 500px;"></div>
			<div id="table_div" style="width: 1146px;">
				<table id="table" class="table table-hover table-bordered"
					style="text-align: center">
					<thead class="thead-dark">
						<tr>
							<th scope="col">카테고리</th>
							<th scope="col">카테고리 갯수</th>
						</tr>
					</thead>
					<tbody id="tb">

					</tbody>
				</table>

			</div>
		</div>
	</div>
</div>


<script type="text/javascript">
	google.charts.load("current", {packages : [ "corechart" ] });
	google.charts.setOnLoadCallback(drawChart);

	function drawChart() {
		$.getJSON({
			url : "${cp}/admin/statisticAjax3",
			success : function(data) {
				var array = new Array();
				array[0] = [ '카테고리명', '카테고리갯수' ];
				$(data).each(function(i, arr) {
					var subArray = [arr.bcategory_name,arr.cate_count ];
						if (data.length - 1 != i) { //마지막 열 데이터 담지 않기// 같지 않을때까지 넣는다.
							array[++i] = subArray;
						}else{
							++i;
						}
								
					//alert(data.length +":"+i);
					var bcategory_name = arr.bcategory_name;
					var cate_count = arr.cate_count;
					var trs = $("<tr></tr>").appendTo("#tb");
								
					if(data.length == i ){
						$(trs).append("<td class='table-active'>합계:</td>");
						$(trs).append("<td class='table-active'>" + cate_count+ "개</td>");			
					}else{
						$(trs).append("<td>" + bcategory_name + "</td>");
						$(trs).append("<td>" + cate_count + "개</td>");
					}		
				});
				var data2 = google.visualization.arrayToDataTable(array);
					var options = {
						title : '카테고리별 비중',
						pieHole : 0.4,
					};
				var chart = new google.visualization.PieChart(document.getElementById('donutchart'));
				chart.draw(data2, options);
			}
		});
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
