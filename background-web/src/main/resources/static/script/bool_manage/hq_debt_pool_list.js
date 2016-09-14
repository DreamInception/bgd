$(function() {	
  loads();	
})

function loads(){
	var rowInstance = null;
	$("#select_hq_debt_pool_list").on("click", function() {
		selectHqdebtPoolList();
	});
	$.getScript("script/common/call.common.wizard.js",function(){
		//行选择器
		rowInstance = call_rowSelect_wizard("table-row-select");
		// 颜色选择器
		call_colorpicker_wizard("table-colorpicker");
		
		//分页插件
		call_laypage_wizard('laypage_pageNum');
	});
	
}

function refresh(curPage) {	
	var pageNum = curPage;
	$.ajax({
		type : 'post',
		url : '/bool-manage/hqDebtPoolListRefresh.do',
		cache : false,
		dataType : 'html',
		data : {
			pageNum : pageNum
		},
		success : function(data) {
			$("#hq_debt_pool_list_table tbody").html();
			$("#hq_debt_pool_list_table tbody").html(data);
			rowInstance = call_rowSelect_wizard("table-row-select");	
		}
	})
 }

/**
 * 
 * @returns {Boolean}
 */
function selectHqdebtPoolList(){
	var startCreateTime = $("#startCreateTime").val();
	var endCreateTime = $("#endCreateTime").val();
	$.ajax({
		type : 'post',
		url : '/bool-manage/selectHqdebtPoolList.do',
		async : false,
		dataType : 'html',
		data : {
			"startCreateTime" : startCreateTime,
			"endCreateTime" : endCreateTime
		},
		success : function(data) {
			$("#hq_debt_pool_list_table tbody").html();
			$("#hq_debt_pool_list_table tbody").html(data);
				
		},
		error : function() {
			alert('系统错误，请联系管理员');
		}
	});
}