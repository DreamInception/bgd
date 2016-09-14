$(function() {
	loads();
	var rowInstance = null;
	rowInstance2 = null;
	$.getScript("script/common/call.common.wizard.js", function() {
		// 行选择器
		rowInstance = call_rowSelect_wizard("table-row-select");
		// 颜色选择器
		call_colorpicker_wizard("table-colorpicker");
		// 分页插件
		call_laypage_wizard('laypage_pageNum');
	
		call_chosenSelect_wizard();
	});
	$("#modal-nodata").on("shown.bs.modal",function(){
		call_datepicker_wizard();
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
	
	$("#modifyBtn").click(function() {
		var idList = rowInstance.getSelectIDs();
		if (idList.length > 1) {
			call_alert_wizard("只能选择一行数据");
		} else if (idList.length == 0) {
			call_alert_wizard("请先选择一行数据");
		} else {
			$("#umactId").val(idList[0].trim());
			$("#uactName").val(rowInstance.getSelectCeilData("actName").trim());
			$("#ubeginDate").val(rowInstance.getSelectCeilData("beginDate").trim());
			$("#uendDate").val(rowInstance.getSelectCeilData("endDate").trim());
		}
	});
	$("#checkBtn").click(function() {
		var idList = rowInstance.getSelectIDs();
		if (idList.length > 1) {
			call_alert_wizard("只能选择一行数据");
			return false;
		} else if (idList.length == 0) {
			call_alert_wizard("请先选择一行数据");
			return false;
		} else {
			var id = idList[0].trim();
			selectCouponItems(id);
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
	$("#regOnsaleBtn").click(function() {
		var idList = rowInstance.getSelectIDs();

		if (idList.length > 1) {
			call_alert_wizard("只能选择一行数据");
		} else if (idList.length == 0) {
			call_alert_wizard("请先选择一行数据");
		} else {
			//alert(idList);
			var actAutoId = idList[0];
			var isOnsale = rowInstance.getSelectCeilData("isOnsale");
			var endDate = rowInstance.getSelectCeilData("endDate");
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
			call_confirm_wizard(actAutoId,isOnsale,endDate);
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
		url : '/activity-manage/selectRegActivityManageListRefresh.do',
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
	$("#reg-activity-submit").on("click", function() {
		regActivitySubmit();
	});
	$("#reg-activity-modify").on("click", function() {
		regActivityModify();
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
			//loads();
			rowInstance = call_rowSelect_wizard("table-row-select");
		},
		error : function() {
			call_alert_wizard('系统错误，请联系管理员');
		}
	});
}

function onSale(actAutoId, isOnsale,endDate) {
	$.ajax({
		type : 'post',
		url : '/activity-manage/regOnsale.do',
		async : true,
		dataType : 'json',
		data : {
			"actAutoId" : actAutoId,
			"isOnsale" : isOnsale,
			"endDate" : endDate
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
		url : '/activity-manage/addRegActivity.do',
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

function regActivityModify(){
	var actAutoId = $("#umactId").val();
	var cactName = $("#uactName").val();
	var cbeginDate = $("#ubeginDate").val();
	var cendDate = $("#uendDate").val();
	$.ajax({
		type : 'post',
		url : '/activity-manage/modifyRegActivity.do',
		async : true,
		dataType : 'html',
		data : {
			"actAutoId" : actAutoId,
			"actName" : cactName,
			"beginDate" : cbeginDate,
			"endDate" : cendDate
		},
		success : function(data) {
			if (!data.match("^\{(.+:.+,*){1,}\}$")) {
				$("#modal-nodata2").modal('hide');
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

function selectCouponItems(id) {
	$.ajax({
		type : 'post',
		url : '/activity-manage/selectCouponItems.do',
		async : true,
		dataType : 'html',
		data : {
			"actAutoId" : id
		},
		success : function(data) {
			$("#regCheckModal").html();
			$("#regCheckModal").html(data);
			rowInstance = call_rowSelect_wizard("table-row-select");
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
			"enumActType" : "0",
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
			"enumActType" : "0",
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