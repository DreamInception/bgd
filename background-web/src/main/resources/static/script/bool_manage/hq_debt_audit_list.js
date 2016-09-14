$(function() {
	loads();
})

/**
 * 查询
 * 
 * @returns {Boolean}
 */
function selectDebtAuditList() {
	var debtId = $("#debtId").val();
	var debtName = $("#pDebtName").val();

	if (debtId != null && debtId != "") {
		debtId = debtId.trim();
	}
	if (debtName != null && debtName != "") {
		debtName = debtName.trim();
	}
	$.ajax({
		type : 'post',
		url : '/bool-manage/hqDebtAuditList.do',
		async : false,
		dataType : 'html',
		data : {
			"debtId" : debtId,
			"debtName" : debtName
		},
		success : function(data) {
			$("#modal-nodata").modal('hide');
			$(".modal-backdrop").hide();
			$(".main-content").html();
			$(".main-content").html(data);
			loads();
		},
		error : function() {
			alert('系统错误，请联系管理员');
		}
	});
}

/**
 * 驳回
 * @param debtId
 */
function reject(debtId) {
	if (confirm("确定此操作吗")) {
		$.ajax({
			type : 'post',
			url : '/bool-manage/reject.do',
			async : true,
			dataType : 'html',
			data : {
				"debtId" : debtId
			},
			success : function(data) {
				if (!data.match("^\{(.+:.+,*){1,}\}$")) {
					$(".main-content").html();
					$(".main-content").html(data);
					loads();
				} else {
					//通过这种方法可将字符串转换为对象
					var rdata = jQuery.parseJSON(data);
					alert(rdata.message);
					loads();
				}
			},
			error : function() {
				alert('系统错误，请联系管理员');
			}
		});
	}
}

/**
 * 通过
 * @param debtId
 */
function adopt(debtId) {
	if (confirm("确定此操作吗")) {
		$.ajax({
			type : 'post',
			url : '/bool-manage/adopt.do',
			async : true,
			dataType : 'html',
			data : {
				"debtId" : debtId
			},
			success : function(data) {
				if (!data.match("^\{(.+:.+,*){1,}\}$")) {
					$(".main-content").html();
					$(".main-content").html(data);
					loads();
				} else {
					//通过这种方法可将字符串转换为对象
					var rdata = jQuery.parseJSON(data);
					alert(rdata.message);
					loads();
				}
			},
			error : function() {
				alert('系统错误，请联系管理员');
			}
		});
	}
}

function loads() {
	var rowInstance = null;
	$.getScript("script/common/call.common.wizard.js",function(){
		//行选择器
		rowInstance = call_rowSelect_wizard("table-row-select");
		// 颜色选择器
		call_colorpicker_wizard("table-colorpicker");
		
		//分页插件
		call_laypage_wizard('laypage_pageNum');
	});
	

	$("#select_debt_audit_list").on("click", function() {
		selectDebtAuditList();
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
				$("#target_manage_tab table>tbody").html();
				$("#target_manage_tab table>tbody").html(data);
				rowInstance = call_rowSelect_wizard("table-row-select");
			}
		})
	}
}