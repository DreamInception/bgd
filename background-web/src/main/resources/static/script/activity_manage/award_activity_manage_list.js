$(function() {
	loads();
	var rowInstance = null;
	$.getScript("script/common/call.common.wizard.js", function() {
		// 行选择器
		rowInstance = call_rowSelect_wizard("table-row-select");
		// 颜色选择器
		call_colorpicker_wizard("table-colorpicker");
		// 分页插件
		call_laypage_wizard('laypage_pageNum');
		call_datepicker_wizard();
		call_chosenSelect_wizard();
	});
	$("#addCouponBtn").click(function() {
		var idList = rowInstance.getSelectIDs();

		if (idList.length > 1) {
			call_alert_wizard("只能选择一行数据");
		} else if (idList.length == 0) {
			call_alert_wizard("请先选择一行数据");
		} else {
			$("#mactId").val(idList[0]);
			$('#widget-box-cou').widget_box('show');
		}
	});
	$("#addTyjBtn").click(function() {
		var idList = rowInstance.getSelectIDs();

		if (idList.length > 1) {
			call_alert_wizard("只能选择一行数据");
		} else if (idList.length == 0) {
			call_alert_wizard("请先选择一行数据");
		} else {
			$("#mactId").val(idList[0]);
			$('#widget-box-tyj').widget_box('show');
		}
	});
	$("#awardOnsaleBtn").click(function() {
		var idList = rowInstance.getSelectIDs();

		if (idList.length > 1) {
			call_alert_wizard("只能选择一行数据");
		} else if (idList.length == 0) {
			call_alert_wizard("请先选择一行数据");
		} else {
			var actAutoId = idList[0];
			var isOnsale = rowInstance.getSelectCeilData("isOnsale");
			var countAmci = Number(rowInstance.getSelectCeilData("countAmci"));
			var countArci = Number(rowInstance.getSelectCeilData("countArci"));
			if (countAmci = 0 && countArci == 0) {
				call_alert_wizard('请添加体验金配置或者加息券配置');
				return false;
			} else {
				if (isOnsale == '是') {
					isOnsale = false;
				} else {
					isOnsale = true;
				}
			}
			call_confirm_wizard(actAutoId,isOnsale);
		
		}
	});
	$("#widget-box").on("shown.ace.widget", function() {
		// 下拉框选择器
		call_chosenSelect_wizard();
	});
});

function refresh(curPage) {
	var pageNum = curPage;
	$.ajax({
		type : 'post',
		url : '/activity-manage/selectAwardActivityManageListRefresh.do',
		cache : false,
		dataType : 'html',
		data : {
			pageNum : pageNum
		},
		success : function(data) {
			$("#act_reg_gift_manage_list_table tbody").html();
			$("#act_reg_gift_manage_list_table tbody").html(data);
			rowInstance = call_rowSelect_wizard("table-row-select");
		}
	})
}

function loads() {
	$("#select_reg_activity_list").on("click", function() {
		selectRegActivityManageList();
	});
	$("#award-activity-submit").on("click", function() {
		regActivitySubmit();
	});

	$("#add-tyj-btn").on("click", function() {
		var actId = $("#mactId").val();
		if (actId == null || actId == '') {
			call_alert_wizard('请选择活动');
			return false;
		}
		actMoneyCouponItemSubmit();
	});

	$("#add-coupon-btn").on("click", function() {
		var actId = $("#mactId").val();
		if (actId == null || actId == '') {
			call_alert_wizard('请选择活动');
			return false;
		}
		actRateCouponItemSubmit();
	});

	$("#add-year-rate").on("input", function() {
		var yearRate = $("#add-year-rate").val();
		if (yearRate != '') {
			var yearRate2 = Number(yearRate);
			var num = Number(yearRate2 / 360).toFixed(10);
			$("#add-day-rate").val(num.substring(0, num.lastIndexOf('.') + 7))
		}
	});
	$("#add-year-rate2").on("input", function() {
		var yearRate = $("#add-year-rate2").val();
		if (yearRate != '') {
			var yearRate2 = Number(yearRate);
			var num = Number(yearRate2 / 360).toFixed(10);
			$("#add-day-rate2").val(num.substring(0, num.lastIndexOf('.') + 7))
		}
	});

}

function selectRegActivityManageList() {
	var actAutoId = $("#actAutoId").val();
	var actName = $("#pActName").val();
	$.ajax({
		type : 'post',
		url : '/activity-manage/selectAwardActivityManageList.do',
		async : false,
		dataType : 'html',
		data : {
			"actAutoId" : actAutoId,
			"actName" : actName
		},
		success : function(data) {
			$("#act_reg_gift_manage_list_table tbody").html();
			$("#act_reg_gift_manage_list_table tbody").html(data);
			//loads();
			rowInstance = call_rowSelect_wizard("table-row-select");
		},
		error : function() {
			call_alert_wizard('系统错误，请联系管理员');
		}
	});
}

function onSale(actAutoId, isOnsale) {
	$.ajax({
		type : 'post',
		url : '/activity-manage/awardOnsale.do',
		async : true,
		dataType : 'json',
		data : {
			"actAutoId" : actAutoId,
			"isOnsale" : isOnsale
		},
		success : function(data) {
			if(data.flag){
				$("#actAutoId").val(data.data);
				selectRegActivityManageList();
			}else{
				call_alert_wizard(data.message);
			}
		},
		error : function() {
			call_alert_wizard('系统错误，请联系管理员');
		}
	});
}

function regActivitySubmit() {
	var cactName = $("#actName").val();
	var cbeginDate = $("#beginDate").val();
	var cendDate = $("#endDate").val();
	$.ajax({
		type : 'post',
		url : '/activity-manage/addAwardActivity.do',
		async : true,
		dataType : 'html',
		data : {
			"actName" : cactName,
			"beginDate" : cbeginDate,
			"endDate" : cendDate
		},
		success : function(data) {
			if (!data.match("^\{(.+:.+,*){1,}\}$")) {
				$("#modal-nodata").modal('hide');
				$(".modal-backdrop").hide();
				$("#act_reg_gift_manage_list_table tbody").html();
				$("#act_reg_gift_manage_list_table tbody").html(data);
				//loads();
				rowInstance = call_rowSelect_wizard("table-row-select");
			} else {
				// 通过这种方法可将字符串转换为对象
				var rdata = jQuery.parseJSON(data);
				call_alert_wizard(rdata.message);
				//loads();
			}
		},
		error : function() {
			call_alert_wizard('系统错误，请联系管理员');
		}
	});
}
function insertDataToTyj(actAmount,yearRate,dayRate,dayCount,validDayCount,minAmount,minDays){
	$("#ram_tyj_table").show();
	var tRow = $("<tr class='table-row'></tr>");
	tRow.appendTo("#ram_tyj_table tbody");
	tRow.append("<td>"+actAmount+"</td>");
	tRow.append("<td>"+yearRate+"</td>");
	tRow.append("<td>"+dayRate+"</td>");
	tRow.append("<td>"+dayCount+"</td>");
	tRow.append("<td>"+validDayCount+"</td>");
	tRow.append("<td>"+minAmount+"</td>");
	tRow.append("<td>"+minDays+"</td>");
	tRow.append("<td><a href='javascript:;' class='ram-tyj-row'>删除</a></td>");

	
	$(".ram-tyj-row").on("click",function(){
		$(this).closest("tr").remove();
	});
}
function actMoneyCouponItemSubmit() {
	var yearRate = $("#add-year-rate").val();
	var dayRate = $("#add-day-rate").val();
	var dayCount = $("#add-rate-days").val();
	var validDayCount = $("#during-days").val();
	var minAmount = $("#min-money").val();
	var minDays = $("#min-days").val();
	var actAmount = $("#act-amount").val();
	var actId = $("#mactId").val();
	if(yearRate==''||dayRate==''||dayCount==''||validDayCount==''||minAmount==''||minDays==''||actAmount==''||actId==''){
		call_alert_wizard("请检查是否有空数据");
		return false;
	}
	if (isNaN(yearRate)||isNaN(dayRate)||isNaN(dayCount)||isNaN(validDayCount)||isNaN(minAmount)||isNaN(minDays)||isNaN(actAmount)||isNaN(actId)) {
		call_alert_wizard("填写的数据必须为数字");
		return false;
	}
	if (yearRate >= 10) {
		call_alert_wizard("年利率不能大于10");
		return false;
	}
	insertDataToTyj(actAmount,yearRate,dayRate,dayCount,validDayCount,minAmount,minDays);
	$.ajax({
		type : 'post',
		url : '/activity-manage/addActMoneyCouponItem.do',
		async : true,
		dataType : 'json',
		data : {
			"actId" : actId,
			"enumActType" : "100",
			"actAmount" : actAmount,
			"yearRate" : yearRate,
			"dayRate" : dayRate,
			"dayCount" : dayCount,
			"validDayCount" : validDayCount,
			"minAmount" : minAmount,
			"minDays" : minDays
		},
		success : function(data) {
			call_alert_wizard(data.message);
		},
		error : function() {
			call_alert_wizard('系统错误，请联系管理员');
		}
	});
}
function insertDataToCou(yearRate,dayRate,dayCount,validDayCount,minAmount,minDays){
	$("#ram_cou_table").show();
	var tRow = $("<tr class='table-row'></tr>");
	tRow.appendTo("#ram_cou_table tbody");
	tRow.append("<td>"+yearRate+"</td>");
	tRow.append("<td>"+dayRate+"</td>");
	tRow.append("<td>"+dayCount+"</td>");
	tRow.append("<td>"+validDayCount+"</td>");
	tRow.append("<td>"+minAmount+"</td>");
	tRow.append("<td>"+minDays+"</td>");
	tRow.append("<td><a href='javascript:;' class='ram-coupon-row'>删除</a></td>");
	
	$(".ram-coupon-row").on("click",function(){
		$(this).closest("tr").remove();
	});
}
function actRateCouponItemSubmit() {
	var yearRate = $("#add-year-rate2").val();
	var dayRate = $("#add-day-rate2").val();
	var dayCount = $("#add-rate-days2").val();
	var validDayCount = $("#during-days2").val();
	var minAmount = $("#min-money2").val();
	var minDays = $("#min-days2").val();
	var actId = $("#mactId").val();
	if(yearRate==''||dayRate==''||dayCount==''||validDayCount==''||minAmount==''||minDays==''||actId==''){
		call_alert_wizard("请检查是否有空数据");
		return false;
	}
	if (isNaN(yearRate)||isNaN(dayRate)||isNaN(dayCount)||isNaN(validDayCount)||isNaN(minAmount)||isNaN(minDays)||isNaN(actId)) {
		call_alert_wizard("填写的数据必须为数字");
		return false;
	}
	if (yearRate >= 10) {
		call_alert_wizard("年利率不能大于10");
		return false;
	}
	insertDataToCou(yearRate,dayRate,dayCount,validDayCount,minAmount,minDays);
	$.ajax({
		type : 'post',
		url : '/activity-manage/addActRateCouponItem.do',
		async : true,
		dataType : 'json',
		data : {
			"actId" : actId,
			"enumActType" : "100",
			"yearRate" : yearRate,
			"dayRate" : dayRate,
			"dayCount" : dayCount,
			"validDayCount" : validDayCount,
			"minAmount" : minAmount,
			"minDays" : minDays
		},
		success : function(data) {
			call_alert_wizard(data.message);
		},
		error : function() {
			call_alert_wizard('系统错误，请联系管理员');
		}
	});
}