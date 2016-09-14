$(function() {
	var rowInstance = null;
	$.getScript("script/common/call.common.wizard.js", function() {
		// 行选择器
		rowInstance = call_rowSelect_wizard("table-row-select");
		// 颜色选择器
		call_colorpicker_wizard("table-colorpicker");

		// 分页插件
		call_laypage_wizard('laypage_pageNum');
	});
	$("#modal-nodata").on("shown.bs.modal", function() {
		call_fileUpload_wizard();
	});
	$("#modal-hasdata").on("shown.bs.modal", function() {
		call_fileUpload_wizard();
	});
	// 局部刷新
	function refresh(curPage) {
		var pageNum = curPage;
		$.ajax({
			type : 'POST',
			url : '/banner/refresh.do',
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
			}
		})
	}
});
$("#changeBtn").click(function() {
	var idList = rowInstance.getSelectIDs();

	if (idList.length > 1) {
		alert("只能选择一行数据");
		return false;
	} else if (idList.length == 0) {
		alert("请先选择一行数据");
		return false;
	} else {

		$.ajax({
			url : '/banner/selectByPrimaryKey.do?cmsAutoId=' + idList,
			type : 'POST',
			dataType : 'json',
			cache : true,
			async : false,
			success : function(result) {
				if (result.flag) {
					$("#cmsAutoId").val(result.data.cmsAutoId);
					$("#remark-edit").val(result.data.remark);
					if (result.data.isAppOpen == true) {
						$("#isAppOpenA").click();
					} else {
						$("#isAppOpenB").click();
					}
					$("#h5Url-edit").val();
					$("#androidKey-edit").val(result.data.androidKey);
					$("#iosKey-edit").val(result.data.iosKey);
					$("#sort-edit").val(result.data.sort);
					if (result.data.isShow == true) {
						$("#isShowA").click();
					} else {
						$("#isShowB").click();
					}

				} else {
					alert(result.message);
				}
			},
			error : function(data) {
				alert("查找失败");
			}
		});
	}

});

$("#removeBtn").click(function() {
	var idList = rowInstance.getSelectIDs();

	if (idList.length > 1) {
		alert("只能选择一行数据");
	} else if (idList.length == 0) {
		alert("请先选择一行数据");
	} else {

		$.ajax({
			url : '/banner/deleteByPrimaryKey.do?cmsAutoId=' + idList,
			type : 'POST',
			dataType : 'html',
			cache : true,
			async : false,
			success : function(data) {
				$(".main-content").html();
				$(".main-content").html(data);
				commonJs();
			},
			error : function(data) {
				alert("删除失败");
			}
		});
	}

});

// 添加表单提交
function insertForm() {
	var formData = new FormData($("#insertForm")[0]);
	$.ajax({
		url : '/banner/insert.do',
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
			$(".modal-backdrop").hide();
			$(".main-content").html();
			$(".main-content").html(data);
		}
	});
}

// 修改图片异步提交
function editForm() {
	var formData = new FormData($("#editForm")[0]);
	$.ajax({
		url : '/banner/edit.do',
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
			commonJs();
		},
		error : function(data) {
			alert("上传失败");
			$(".main-content").html();
			$(".main-content").html(data);
		}
	});
}

// 清空添加表单
function resetInsertForm() {
	$("#remark").val();
	$("#h5Url").val();
	$("#androidKey").val();
	$("#iosKey").val();
	$("#sort").val();
}

// 清空编辑表单
function resetEditForm() {
	$("#cmsAutoId").val();
	$("#remark-edit").val();
	$("#h5Url-edit").val();
	$("#androidKey-edit").val();
	$("#iosKey-edit").val();
	$("#sort-edit").val();
}

// 预加载js，用来恢复点击事件
function commonJs() {
	var rowSelect = $("#list_table").rowSelect({
		class : 'click-active',
		single : true
	});
	var rowInstance = rowSelect.data("rowSelect");
	$("#changeBtn").click(function() {
		var idList = rowInstance.getSelectIDs();

		if (idList.length > 1) {
			alert("只能选择一行数据");
			return false;
		} else if (idList.length == 0) {
			alert("请先选择一行数据");
			return false;
		} else {

			$.ajax({
				url : '/banner/selectByPrimaryKey.do?cmsAutoId=' + idList,
				type : 'POST',
				dataType : 'json',
				cache : true,
				async : false,
				success : function(result) {
					if (result.flag) {
						$("#cmsAutoId").val(result.data.cmsAutoId);
						$("#remark-edit").val(result.data.remark);
						if (result.data.isAppOpen == true) {
							$("#isAppOpenA").click();
						} else {
							$("#isAppOpenB").click();
						}
						$("#h5Url-edit").val();
						$("#androidKey-edit").val(result.data.androidKey);
						$("#iosKey-edit").val(result.data.iosKey);
						$("#sort-edit").val(result.data.sort);
						if (result.data.isShow == true) {
							$("#isShowA").click();
						} else {
							$("#isShowB").click();
						}

					} else {
						alert(result.message);
					}
				},
				error : function(data) {
					alert("查找失败");
				}
			});
		}

	});

	$("#removeBtn").click(function() {
		var idList = rowInstance.getSelectIDs();

		if (idList.length > 1) {
			alert("只能选择一行数据");
		} else if (idList.length == 0) {
			alert("请先选择一行数据");
		} else {

			$.ajax({
				url : '/banner/deleteByPrimaryKey.do?cmsAutoId=' + idList,
				type : 'POST',
				dataType : 'html',
				cache : true,
				async : false,
				success : function(data) {
					$(".main-content").html();
					$(".main-content").html(data);
				},
				error : function(data) {
					alert("删除失败");
				}
			});
		}
	});
}