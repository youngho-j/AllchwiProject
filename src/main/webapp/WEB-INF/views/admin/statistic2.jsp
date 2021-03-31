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
							점유율 </a></li>
					<li class="breadcrumb-item"><a href="${cp }/admin/statistic2">인기수업 TOP10</a></li>
				</ol>
			</nav>

			<button type="button" class="btn btn-success" style="margin-left: 872px" 
			onclick="fnExcelReport('table','TOP10 CLASSES')">엑셀 파일 다운로드</button>
				
			<div id="top_x_div" style="width: 1035px; height: 500px;"></div>
			<div id="table_div" style="width: 1035px;">
				<table id="table" class="table table-hover table-bordered"
					style="text-align: center">
					<thead class="thead-dark">
						<tr>
							<th scope="col" style="width:350px;">수업명</th>
							<th scope="col" style="width:200px;">좋아요 갯수</th>
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
	google.charts.load('current', {
		'packages' : [ 'bar' ]
	});
	google.charts.setOnLoadCallback(drawStuff);

	function drawStuff() {
		$.getJSON({
			url : "${cp}/admin/statisticAjax2",
			success : function(data) {
				var array = new Array();
				array[0] = [ '수업명', '좋아요 갯수' ];
				$(data).each(function(i, arr) {
					if(arr.title.length>20){
						arr.title = arr.title.substr(0, 20) + "..";
					}
					var subArray = [arr.title,arr.cnt ];
						
					array[++i] = subArray;
					var title = arr.title;
					var cnt = arr.cnt;
					
					var trs = $("<tr></tr>").appendTo("#tb");
								
					$(trs).append("<td>" + title + "</td>");
					$(trs).append("<td>" + cnt + "개</td>");
						

				});
				
				
				var data2 = new google.visualization.arrayToDataTable(array);

				var options = {
					title : 'Chess opening moves',
					width : 1035,
					legend : {
						position : 'none'
					},
					chart : {
						title : '올취 인기수업 TOP 10',
						subtitle : '인기도 by 좋아요 갯수'
					},
					bars : 'horizontal', // Required for Material Bar Charts.
					axes : {
						x : {
							0 : {
								side : 'top',
								label : '좋아요 갯수'
							}
						// Top x-axis.
						}
					},
					bar : {
						groupWidth : "90%"
					}
				};

				var chart = new google.charts.Bar(document
						.getElementById('top_x_div'));
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




