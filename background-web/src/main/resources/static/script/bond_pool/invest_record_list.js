$(function(){
	var rowInstance = null;
	$.getScript("script/common/call.common.wizard.js",function(){
		//行选择器
		rowInstance = call_rowSelect_wizard("table-row-select");
		// 颜色选择器
		call_colorpicker_wizard("table-colorpicker");
		
		//分页插件
	//	call_laypage_wizard('laypage_pageNum');
	});
});
	function refresh(curPage) {
		var pageNum = curPage;
		$.ajax({
			type : 'post',
			url : '/hqDebtEditorList.do',
			cache : false,
			dataType : 'html',
			data : {
				pageNum : pageNum
			},
			success : function(data) {
				$("#list_table tbody").html();
				$("#list_table tbody").html(data);
				rowInstance = call_rowSelect_wizard("table-row-select");
			}
		})
	}
	
	
	
	
	
	
	
	
	
	
	
	
	












