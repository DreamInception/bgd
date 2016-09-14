$(function() {
	var rowInstance = null;
	loads();
	//分页插件
	call_laypage_wizard('laypage_pageNum');
	$.getScript("script/common/call.common.wizard.js",function(){
		//行选择器
		rowInstance = call_rowSelect_wizard("table-row-select");
		// 颜色选择器
		call_colorpicker_wizard("table-colorpicker");
		//分页插件
		call_laypage_wizard('laypage_pageNum');
		call_datepicker_wizard();
	});

	

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
				$("#activity_manage_list_table tbody").html();
				$("#activity_manage_list_table tbody").html(data);
				rowInstance = call_rowSelect_wizard("table-row-select");
			}
		})
     }
function loads(){
	$("#activity-submit").on("click", function() {
		activitySubmit();
	});
	$("#select_reg_activity_list").on("click", function() {
		selectRegActivityManageList();
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
	
	$("#appendYearRate").on("input", function() {
		var yearRate = $("#appendYearRate").val();
		if (yearRate != '') {
			var yearRate2 = Number(yearRate);
			var num = Number(yearRate2 / 360).toFixed(10);
			$("#appendDayRate").val(num.substring(0, num.lastIndexOf('.') + 7))
		}
	});
}

/**
 * 
 * @returns {Boolean}
 */
function selectRegActivityManageList(){
	var actAutoId = $("#actAutoId").val();
	var actName = $("#pActName").val();
	$.ajax({
		type : 'post',
		url : '/activity-manage/selectRegActivityManageList.do',
		async : false,
		dataType : 'html',
		data : {
			"actAutoId" : actAutoId,
			"actName" : actName
		},
		success : function(data) {
			$("#act_reg_gift_manage_list_table tbody").html();
			$("#act_reg_gift_manage_list_table tbody").html(data);
			rowInstance = call_rowSelect_wizard("table-row-select");
		},
		error : function() {
			call_alert_wizard('系统错误，请联系管理员');
		}
	});
}

/**
 * 添加活动
 */
function activitySubmit() {

	var cactName = $("#actName").val();
	var cappendLable = $("#appendLable").val();
	var cappendYearRate = $("#appendYearRate").val();
	var cappendDayRate = $("#appendDayRate").val();
	var cappendDayCount = $("#appendDayCount").val();
	var cbeginDate = $("#beginDate").val();
	var cendDate = $("#endDate").val();
	var isOnsale = $("input[name='isOnsale']:checked").val();

	$.ajax({
		type : 'post',
		url : '/activity-manage/addActivity.do',
		async : true,
		dataType : 'html',
		data : {
			"actName" : cactName,
			"appendLable" : cappendLable,
			"appendYearRate" : cappendYearRate,
			"appendDayRate" : cappendDayRate,
			"appendDayCount" : cappendDayCount,
			"beginDate" : cbeginDate,
			"endDate" : cendDate,
			"isOnsale" : isOnsale
		},
		success : function(data) {
			if (!data.match("^\{(.+:.+,*){1,}\}$")) {
				$("#modal-nodata").modal('hide');
				$(".modal-backdrop").hide();
				$(".main-content").html();
				$(".main-content").html(data);
				rowInstance = call_rowSelect_wizard("table-row-select");
			} else {
				//通过这种方法可将字符串转换为对象
				var rdata = jQuery.parseJSON(data);
				call_alert_wizard(rdata.message);
		
			}
		},
		error : function() {
			call_alert_wizard('系统错误，请联系管理员');
		}
	});
}

/**
 * 上架 下架 活动
 * @param onSale
 * @param actAutoId
 */

function onSale(onSale, actAutoId) {
//	if (confirm("确定此操作吗")) {
		$.ajax({
			type : 'post',
			url : '/activity-manage/onSale.do',
			async : true,
			dataType : 'html',
			data : {
				"isOnsale" : onSale,
				"actAutoId" : actAutoId
			},
			success : function(data) {
				if (!data.match("^\{(.+:.+,*){1,}\}$")) {
					$(".main-content").html();
					$(".main-content").html(data);
					rowInstance = call_rowSelect_wizard("table-row-select");
				} else {
					//通过这种方法可将字符串转换为对象
					var rdata = jQuery.parseJSON(data);
					call_alert_wizard(rdata.message);
			
				}
			},
			error : function() {
				call_alert_wizard('系统错误，请联系管理员');
			}
		});
}