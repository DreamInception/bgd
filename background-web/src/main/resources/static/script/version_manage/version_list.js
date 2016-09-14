$(function() {
	var rowInstance = null;
	$.getScript("script/common/call.common.wizard.js", function() {
		// 行选择器
		rowInstance = call_rowSelect_wizard("table-row-select");
		// 颜色选择器
		call_colorpicker_wizard("table-colorpicker");

		// 分页插件
		// call_laypage_wizard('laypage_pageNum');

	});
	$("#modal-nodata").on("shown.bs.modal", function() {
		call_fileUpload_wizard();
	})
	// 局部刷新
	function refresh(curPage) {
		var pageNum = curPage;
		$.ajax({
			type : 'POST',
			url : '/sys-img/refresh.do',
			cache : false,
			dataType : 'html',
			async : false,
			data : {
				'pageNum' : pageNum
			},
			success : function(data) {
				$("#list_table tbody").html();
				$("#list_table tbody").html(data);
				rowInstance = call_rowSelect_wizard("table-row-select");
				commonJs();
			}
		})
	}
});

// 添加表单提交
function insertForm() {
	var formData = new FormData($("#insertForm")[0]);
	$.ajax({
		url : '/app-version/insert.do',
		type : 'POST',
		data : formData,
		dataType : 'html',
		async : false,
		cache : false,
		contentType : false,
		processData : false,
		success : function(data) {
			$("#modal-nodata").modal('hide');
			$(".modal-backdrop").hide();
			$(".main-content").html();
			$(".main-content").html(data);
		},
		error : function(data) {
			call_alert_wizard("上传失败");
			$(".main-content").html();
			$(".main-content").html(data);
		}
	});
}

// 提交版本审核
function setState(appVersionId, enumAppVersionState) {
	$.ajax({
		url : '/app-version/setState.do',
		type : 'POST',
		data : {
			"appVersionId" : appVersionId,
			"enumAppVersionState" : enumAppVersionState
		},
		dataType : 'html',
		success : function(data) {
			$("#modal-hasdata").modal('hide');
			$(".modal-backdrop").hide();
			$(".main-content").html();
			$(".main-content").html(data);
		},
		error : function(data) {
			call_alert_wizard("提交失败");
			$(".modal-backdrop").hide();
			refresh(1);
		}
	});
}

// 修改图片异步提交
function editForm() {
	var formData = new FormData($("#editForm")[0]);
	$.ajax({
		url : '/activity-img/edit.do',
		type : 'POST',
		data : formData,
		dataType : 'html',
		async : false,
		cache : false,
		contentType : false,
		processData : false,
		success : function(data) {
			$("#modal-hasdata").modal('hide');
			$(".modal-backdrop").hide();
			$(".main-content").html();
			$(".main-content").html(data);

		},
		error : function(data) {
			call_alert_wizard("上传失败");
			$(".main-content").html();
			$(".main-content").html(data);
		}
	});
}