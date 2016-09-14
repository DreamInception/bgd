$(function() {
	loads();
	$.getScript("script/common/call.common.wizard.js", function() {
		// 行选择器
		call_rowSelect_wizard("table-row-select");
		// 颜色选择器
		call_colorpicker_wizard("table-colorpicker");

		// 分页插件
		// call_laypage_wizard('laypage_pageNum');
	})
	
});

// 通过审核
function pass(applicationId) {
	$.ajax({
		url : "/userWithdraw/loan/" + applicationId,
		type : "post",
		success : function(result) {
			if (result.flag) {
				alert("提交成功");
			} else {
				alert("提交失败");
			}
			queryWithdraw();
		},
		error : function() {
			alert("系统错误");
			// window.location.href="/userWithdraw/queryWithdraw";
			queryWithdraw();
		}
	})
}

//刷新页面
function queryWithdraw() {
	$.ajax({
		url : '/userWithdraw/queryWithdrawRefresh',
		type : 'post',
		success : function(data) {
			$("#tbody").html("");
			$("#tbody").html(data);
		},
		error : function() {
			alert("fail to load " + jumpUrl + " page");
		}
	});
}