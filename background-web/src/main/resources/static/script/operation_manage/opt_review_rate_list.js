$(function() {
	// 日期选择器
	$('.date-picker').datepicker({
		autoclose : true,
		todayHighlight : true
	})
	// show datepicker when clicking on the icon
	.next().on("click", function() {
		$(this).prev().focus();
	});

	loads();
	var rowInstance = null;
	$.getScript("script/common/call.common.wizard.js",function(){
		//行选择器
		rowInstance = call_rowSelect_wizard("table-row-select");
		// 颜色选择器
		call_colorpicker_wizard("table-colorpicker");
		
		//分页插件
		call_laypage_wizard('laypage_pageNum');
	});
	function refresh(curPage) {

		var pageNum = curPage;
		$.ajax({
			type : 'post',
			url : '/activity-manage/selectActivityManageListRefresh.do',
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
})

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
			alert("只能选择一行数据");

		} else if (idList.length == 0) {
			alert("请先选择一行数据");

		} else {
			alert("idList==========" + idList);
			var result = rowInstance.getSelectCeilData("nextPayDate");
			alert("select ceil data==============" + result);
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
			alert('系统错误，请联系管理员');
		}
	});
}

/**
 * 添加活动
 */
function insertForm() {
	alert($('#insertForm').serialize());
	$.ajax({
		type : 'POST',
		url : '/opt-rate-coupon/insert.do',
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
			alert('系统错误，请联系管理员');
		}
	});
}

/**
 * 通过审核
 * 
 * @param onSale
 * @param actAutoId
 */
function pass(autoId) {
	if (confirm("确定此操作吗")) {
		$.ajax({
			type : 'POST',
			url : '/opt-rate-coupon/pass.do',
			async : true,
			dataType : 'html',
			data : {
				"autoId" : autoId
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
}

/**
 * 拒绝申请
 * @param autoId
 */
function denie(autoId) {
	if (confirm("确定此操作吗")) {
		$.ajax({
			type : 'POST',
			url : '/opt-rate-coupon/denie.do',
			async : true,
			dataType : 'html',
			data : {
				"autoId" : autoId
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
}

// 根据手机号查询用户
function searchUser() {
	var userMobile = $("#userMobile").val();
	$.ajax({
		type : 'POST',
		url : '/opt-rate-coupon/selectByUserMobile.do',
		async : true,
		dataType : 'json',
		data : {
			"userMobile" : userMobile
		},
		success : function(result) {
			if (result.flag == true) {
				$("#userId").val(result.data.user_id);
				if(result.data.user_name!=""){
					$("#userName").val(result.data.user_name);
				}else{
					$("#userName").val("无姓名");
				}
				alert(result.message);
				activeLink("insertbtn", "javascript:insertForm()");
			} else {
				alert(result.message);
			}
		},
		error : function() {
			alert('系统错误，请联系管理员');
		}
	});
}

// 启用提交按钮
function activeLink(link, href) {
	$("#" + link).attr("href", href);
	$("#" + link).removeAttr("disabled");
}

// 禁用超链接
function delLink(link) {
	$("#" + link).attr("disabled", true);
	$("#" + link).removeAttr("href");
}