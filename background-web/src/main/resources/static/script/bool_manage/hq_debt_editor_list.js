$(function() {
	loads();
})

/**
 * 查询
 * 
 * @returns {Boolean}
 */
function selectDebtEditorList() {
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
		url : '/bool-manage/hqDebtEditorList.do',
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
			call_alert_wizard('系统错误，请联系管理员');
		}
	});
}

/**
 * 添加
 */
function hqDebtSubmit() {
	var enumDebtType = $("#enumDebtType").val();
	var debtName = $("#debtName").val();
	var debtAmount = $("#debtAmount").val();
	var repayDate = $("#repayDate").val();
	var debtLevel = $("#debtLevel").val();
	var debtFrom = $("#debtFrom").val();

	if (enumDebtType == null || enumDebtType == "" || debtName == null
			|| debtName == "" || debtAmount == null || debtAmount == ""
			|| repayDate == null || repayDate == "" || debtLevel == null
			|| debtLevel == "" || debtFrom == null || debtFrom == "") {
		return false;
	}

	$.ajax({
		type : 'post',
		url : '/bool-manage/addHqDebt.do',
		async : true,
		dataType : 'html',
		data : {
			"enumDebtType" : enumDebtType,
			"debtName" : debtName,
			"debtAmount" : debtAmount,
			"repayDate" : repayDate,
			"debtLevel" : debtLevel,
			"debtFrom" : debtFrom
		},
		success : function(data) {
			if (!data.match("^\{(.+:.+,*){1,}\}$")) {
				$("#modal-nodata").modal('hide');
				$(".modal-backdrop").hide();
				$(".main-content").html();
				$(".main-content").html(data);
				loads();
			} else {
				// 通过这种方法可将字符串转换为对象
				var rdata = jQuery.parseJSON(data);
				call_alert_wizard(rdata.message);
				loads();
			}
		},
		error : function() {
			call_alert_wizard('系统错误，请联系管理员');
		}
	});
}

/**
 * 修改
 */
function hqDebtModify() {
	if (confirm("确定此操作吗")) {
		var enumDebtType = $("#uenumDebtType").val();
		var debtName = $("#udebtName").val();
		var debtAmount = $("#udebtAmount").val();
		var repayDate = $("#urepayDate").val();
		var debtLevel = $("#udebtLevel").val();
		var debtFrom = $("#udebtFrom").val();
		var debtId = $("#udebtId").val();

		$.ajax({
			type : 'post',
			url : '/bool-manage/modifyHqDebt.do',
			async : true,
			dataType : 'html',
			data : {
				"enumDebtType" : enumDebtType,
				"debtName" : debtName,
				"debtAmount" : debtAmount,
				"repayDate" : repayDate,
				"debtLevel" : debtLevel,
				"debtFrom" : debtFrom,
				"debtId" : debtId
			},
			success : function(data) {
				if (!data.match("^\{(.+:.+,*){1,}\}$")) {
					$("#modal-nodata").modal('hide');
					$(".modal-backdrop").hide();
					$(".main-content").html();
					$(".main-content").html(data);
					loads();
				} else {
					// 通过这种方法可将字符串转换为对象
					var rdata = jQuery.parseJSON(data);
					call_alert_wizard(rdata.message);
					loads();
				}
			},
			error : function() {
				call_alert_wizard('系统错误，请联系管理员');
			}
		});
	}
	a
}

/**
 * 申请上架
 * @param onSale
 * @param actAutoId
 */
function enumDebtState(debtId) {
	if (confirm("确定此操作吗")) {
		$.ajax({
			type : 'post',
			url : '/bool-manage/enumDebtState.do',
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
					call_alert_wizard(rdata.message);
					loads();
				}
			},
			error : function() {
				call_alert_wizard('系统错误，请联系管理员');
			}
		});
	}
}
function refresh(curPage) {
	var pageNum = curPage;
	$.ajax({
		type : 'post',
		url : '/bool-manage/hqDebtEditorList.do',
		cache : false,
		dataType : 'html',
		data : {
			pageNum : pageNum
		},
		success : function(data) {
			$("#hq_debt_editor_list_table tbody").html();
			$("#hq_debt_editor_list_table tbody").html(data);
			rowInstance = call_rowSelect_wizard("table-row-select");
		}
	})
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
	
	$("#modal-nodata").on('shown.bs.modal',function(){
		$.getScript("script/common/call.common.wizard.js",function(){
			//下拉框选择器
			call_chosenSelect_wizard();
			//spinner插件
			call_spinner_wizard('targetAmount');
			call_spinner_wizard('targetYearRate');
			call_datepicker_wizard();
		});
	})
	$("#select_debt_editor_list").on("click", function() {
		selectDebtEditorList();
	});

	$("#hq-debt-submit").on("click", function() {
		hqDebtSubmit();
	});

	$("#hq-debt-modify").on("click", function() {
		hqDebtModify();
	});
	
	$("#targetYearRate").on("input",function(){
		var yearRate = $("#targetYearRate").val();
		if(yearRate!=''){
			var yearRate2 = Number(yearRate);
			var num=Number(yearRate2/360).toFixed(10);
			$("#targetDayRate").val(num.substring(0,num.lastIndexOf('.')+7))
		}
	});

	$("#changeBtn").click(function() {
		var idList = rowInstance.getSelectIDs();
		var enumDebtType = rowInstance.getSelectCeilData("enumDebtType");
		var debtName = rowInstance.getSelectCeilData("debtName");
		var debtAmount = rowInstance.getSelectCeilData("debtAmount");
		var repayDate = rowInstance.getSelectCeilData("repayDate");
		var debtLevel = rowInstance.getSelectCeilData("debtLevel");
		var debtFrom = rowInstance.getSelectCeilData("debtFrom");

		if (idList.length > 1) {
			call_alert_wizard("只能选择一行数据");
			return false;
		} else if (idList.length == 0) {
			call_alert_wizard("请先选择一行数据");
			return false;
		} else if((enumDebtType!=null||enumDebtType!="")&&(enumDebtType.trim()!="已上架"||enumDebtType.trim()!="已还款")){
			call_alert_wizard("该状态下不可以修改");
			return false;
		} else {
			$("#udebtId").val(idList[0]);
			$("#uenumDebtType").val(enumDebtType);
			$("#udebtName").val(debtName);
			$("#udebtAmount").val(debtAmount);
			$("#urepayDate").val(repayDate);
			$("#udebtLevel").val(debtLevel);
			$("#udebtFrom").val(debtFrom);
		}

	});
	


}