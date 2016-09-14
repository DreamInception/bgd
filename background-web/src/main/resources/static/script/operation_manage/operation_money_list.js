$(function() {
	var rowInstance = null;
	loads();
	
	$.getScript("script/common/call.common.wizard.js", function() {
		// 行选择�
		rowInstance = call_rowSelect_wizard("table-row-select");
		// 颜色选择�
		call_colorpicker_wizard("table-colorpicker");

		// 分页插件
		call_laypage_wizard('laypage_pageNum');
		// 日期选择�
		call_datepicker_wizard();
	});
});
function refresh(curPage) {
	var pageNum = curPage;
	$.ajax({
		type : 'post',
		url : '/opt-money-coupon/refresh.do',
		cache : false,
		dataType : 'html',
		data : {
			pageNum : pageNum
		},
		success : function(data) {
			$("#operation_money_list_table tbody").html();
			$("#operation_money_list_table tbody").html(data);
			rowInstance = call_rowSelect_wizard("table-row-select");
		}
	});
}

function loads() {
	$("#activity-submit").on("click", function() {
		activitySubmit();
	});

	$("#select_activity_list").on("click", function() {
		selectActivityList();
	});

	$('.aptPos').fadeIn("slow", function() {
		$(this).fadeOut(3000);
	});

	$("#changeBtn").click(function() {
		var idList = rowInstance.getSelectIDs();

		if (idList.length > 1) {
			call_alert_wizard("只能选择一行数据");

		} else if (idList.length == 0) {
			call_alert_wizard("请先选择一行数据");

		} else {
			call_alert_wizard("idList==========" + idList);
			var result = rowInstance.getSelectCeilData("nextPayDate");
			call_alert_wizard("select ceil data==============" + result);
		}

	});
}

/**
 * 
 * @returns {Boolean}
 */
function selectActivityList() {
	var actAutoId = $("#actAutoId").val();
	var actName = $("#pActName").val();

	$.ajax({
		type : 'post',
		url : '/activity-manage/selectActivityManageList.do',
		async : false,
		dataType : 'html',
		data : {
			"actAutoId" : actAutoId,
			"actName" : actName
		},
		success : function(data) {
			$("#modal-nodata").modal('hide');
			$(".modal-backdrop").hide();
			$(".main-content").html();
			$(".main-content").html(data);
			loads();
		},
		error : function() {
			call_alert_wizard('系统错误，请联系管理员');
		}
	});
}

/**
 * 添加活动
 */
function insertForm() {
	$.ajax({
		type : 'POST',
		url : '/opt-money-coupon/insert.do',
		async : true,
		dataType : 'html',
		data : $('#insertForm').serialize(),
		success : function(data) {
			$("#modal-nodata").modal('hide');
			$(".modal-backdrop").hide();
			$(".main-content").html();
			$(".main-content").html(data);
			delLink("insertbtn");
			loads();
		},
		error : function() {
			call_alert_wizard('系统错误，请联系管理员');
		}
	});
}

/**
 * 申请审核
 * 
 * @param onSale
 * @param actAutoId
 */
function apply(autoId, enumSendgiftState) {
	if (confirm("确定此操作吗")) {
		$.ajax({
			type : 'POST',
			url : '/opt-money-coupon/edit.do',
			async : true,
			dataType : 'html',
			data : {
				"autoId" : autoId,
				"enumSendgiftState" : enumSendgiftState
			},
			success : function(data) {
				$("#modal-nodata").modal('hide');
				$(".modal-backdrop").hide();
				$(".main-content").html();
				$(".main-content").html(data);
				loads();
			},
			error : function() {
				call_alert_wizard('系统错误，请联系管理员');
			}
		});
	}
}

// 根据手机号查询用�
function searchUser() {
	var userMobile = $("#userMobile").val();
	$.ajax({
		type : 'POST',
		url : '/opt-money-coupon/selectByUserMobile.do',
		async : true,
		dataType : 'json',
		data : {
			"userMobile" : userMobile
		},
		success : function(result) {
			if (result.flag == true) {
				$("#userId").val(result.data.userId);
				if (result.data.realName != "") {
					$("#userName").val(result.data.realName);
				} else {
					$("#userName").val("无姓名");
				}
				call_alert_wizard(result.message);
				activeLink("insertbtn", "javascript:insertForm()");
			} else {
				call_alert_wizard(result.message);
			}
		},
		error : function() {
			call_alert_wizard('系统错误，请联系管理员');
		}
	});
}

// 启用提交按钮
function activeLink(link, href) {
	$("#" + link).attr("href", href);
	$("#" + link).removeAttr("disabled");
}

// 禁用超链�
function delLink(link) {
	$("#" + link).attr("disabled", true);
	$("#" + link).removeAttr("href");
}

// 清空添加表单
function resetInsertForm() {
	$("#userMobile").val("");
	$("#userId").val("");
	$("#userName").val("");
	$("#amount").val("");
	$("#yearRate").val("");
	$("#dayCount").val("");
	$("#endDate").val("");
	$("#minAmount").val("");
	$("#minDays").val("");
	$("#remark").val("");
}

// 清空编辑表单
function resetEditForm() {
	$("#userMobile-edit").val("");
	$("#userId-edit").val("");
	$("#userName-edit").val("");
	$("#amount-edit").val("");
	$("#yearRate-edit").val("");
	$("#dayCount-edit").val("");
	$("#endDate-edit").val("");
	$("#minAmount-edit").val("");
	$("#minDays-edit").val("");
	$("#remark-edit").val("");
}