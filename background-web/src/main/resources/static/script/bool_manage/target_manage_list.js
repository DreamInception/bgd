$(function() {
	loads();	
})

/**
 * 查询
 * 
 * @returns {Boolean}
 */
function selectTargetList() {
	var targetId = $("#targetId").val();
	var targetName = $("#pTargetName").val();

	$.ajax({
		type : 'post',
		url : '/bool-manage/selectTargetManageList.do',
		async : false,
		dataType : 'html',
		data : {
			"targetId" : targetId,
			"targetName" : targetName
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
function targetSubmit() {
	var targetName = $("#targetName").val();
	var targetAmount = $("#targetAmount").val();
	var targetYearRate = $("#targetYearRate").val();
	var targetDayRate = $("#targetDayRate").val();
	var actAutoId = $("#actAutoId").val();
	var targetYearRate2 = Number(targetYearRate);
	if(targetYearRate2>9.999999){
		call_alert_wizard('年化利率不能大于9.999999');
	}
	$.ajax({
		type : 'post',
		url : '/bool-manage/addTarget.do',
		async : true,
		dataType : 'html',
		data : {
			"targetName" : targetName,
			"targetAmount" : targetAmount,
			"targetYearRate" : targetYearRate,
			"targetDayRate" : targetDayRate,
			"actAutoId" : actAutoId
		},
		success : function(data) {
			if (!data.match("^\{(.+:.+,*){1,}\}$")) {
				$("#modal-nodata").modal('hide');
				$(".modal-backdrop").hide();
				$(".main-content").html();
				$(".main-content").html(data);
		
			} else {
				// 通过这种方法可将字符串转换为对象
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
function targetState() {
	var enumTargetState = $("input[name='uenumTargetState']:checked").val();
	var stargetId = $("#stargetId").val();
	if (confirm("确定此操作吗")) {
		$.ajax({
			type : 'post',
			url : '/bool-manage/targetState.do',
			async : true,
			dataType : 'html',
			data : {
				"enumTargetState" : enumTargetState,
				"targetId" : stargetId
			},
			success : function(data) {
				if (!data.match("^\{(.+:.+,*){1,}\}$")) {
					$("#modal-state").modal('hide');
					$(".modal-backdrop").hide();
					$(".main-content").html();
					$(".main-content").html(data);
		
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
}


function actAutoIdItems(){  
	$.ajax({  
        url: "/bool-manage/getActAutoIdItems.do", 
        type: "post",  
        dataType: "json",  
        contentType: "application/json",  
        traditional: true,  
        success: function (data) {
        	$("#actAutoId").html("<option value ='0'>请选择</option>");
            for (var i in data) {
                var jsonObj =data[i];  
                var optionstring = "";  
                $("#actAutoId").html();
                $("#actAutoId").append("<option value="+ jsonObj.act_auto_id+">"+ jsonObj.act_name+"</option>");
            }
        },  
        error: function (msg) {  
        	call_alert_wizard("系统错误，请联系管理员");  
        }  
    });         
}

function uactAutoIdItems(actName,actAutoId){  
	$.ajax({  
        url: "/bool-manage/getActAutoIdItems.do", 
        type: "post",  
        dataType: "json",  
        contentType: "application/json",  
        traditional: true,  
        success: function (data) {
        	$("#uactAutoId").html("<option value ='0'>请选择</option>");
            for (var i in data) {
                var jsonObj =data[i];  
                var optionstring = "";  
                $("#uactAutoId").append("<option value="+ jsonObj.act_auto_id+">"+ jsonObj.act_name+"</option>");
            }
            $("#uactAutoId").find("option[text="+actName+"]").attr("selected",true);
			$("#uactAutoId").val(actAutoId);
        },  
        error: function (msg) {  
        	call_alert_wizard("系统错误，请联系管理员");  
        }  
    });         
}

function loads() {
	var rowInstance = null;
	
	$("#targetYearRate").on("input",function(){
		var targetYearRate = $("#targetYearRate").val();
		if(targetYearRate!=''){
			var targetYearRate2 = Number(targetYearRate);
			var num=Number(targetYearRate2/360).toFixed(10);
			$("#targetDayRate").val(num.substring(0,num.lastIndexOf('.')+7))
		}
	});
	
	$("#select_target_list").on("click", function() {
		selectTargetList();
	});

	$("#target-state").on("click", function() {
		targetState();
	});
	
	$("#target-submit").on("click", function() {
		targetSubmit();
	});
	$("#modal-nodata").on('shown.bs.modal',function(){
		$.getScript("script/common/call.common.wizard.js",function(){
			//下拉框选择器
			call_chosenSelect_wizard();
			//spinner插件
		//	call_spinner_wizard('targetAmount');
		//	call_spinner_wizard('targetYearRate');
		});
	})
   
	$.getScript("script/common/call.common.wizard.js",function(){
		//行选择器
		rowInstance = call_rowSelect_wizard("table-row-select");
		// 颜色选择器
		call_colorpicker_wizard("table-colorpicker");
		
		//分页插件
		call_laypage_wizard('laypage_pageNum');
	});

	actAutoIdItems();
	

	$("#changeBtn").click(function() {
		var idList = rowInstance.getSelectIDs();
		var enumTargetState = rowInstance.getSelectCeilData("enumTargetState");
		if (idList.length > 1) {
			call_alert_wizard("只能选择一行数据");
			return false;
		} else if (idList.length == 0) {
			call_alert_wizard("请先选择一行数据");
			return false;
		} else if(enumTargetState!=''&&enumTargetState.trim()!='编辑中') {
			call_alert_wizard("该状态下不能修改");
			return false;
		} else {
			var id = idList[0];
			$.ajax({
				type : 'post',
				url : '/bool-manage/selectHqTarget.do',
				async : false,
				dataType : 'json',
				data : {
					"targetId":id
				},
				success : function(data) {
					$("#utargetName").val(data.targetName);
					$("#utargetAmount").val(data.targetAmount);
					$("#utargetYearRate").val(data.targetYearRate);
					$("#utargetDayRate").val(data.targetDayRate);
					$("#utargetId").val(data.sTargetId);
					if(data.actAutoId==null||data.actAutoId==''){
						$("#uactAutoId").html("<option value ='0'>请选择</option>");
					}else{
						uactAutoIdItems(data.actName,data.actAutoId);
					}
				},
				error : function() {
					call_alert_wizard('系统错误，请联系管理员');
				}
			});
		}
	});

	$("#targetStateBtn").click(
			function() {
				var idList = rowInstance.getSelectIDs();

				if (idList.length > 1) {
					call_alert_wizard("只能选择一行数据");
					return false;

				} else if (idList.length == 0) {
					call_alert_wizard("请先选择一行数据");
					return false;
				} else {
					var enumTargetState = rowInstance.getSelectCeilData("enumTargetState");
					var targetName = rowInstance.getSelectCeilData("targetName");
					var targetId = rowInstance.getSelectCeilData("targetId");

					if(enumTargetState!=''&&enumTargetState!=null){
						enumTargetState = enumTargetState.trim();
					}
					
					if(targetName!=''&&targetName!=null){
						targetName = targetName.trim();
					}
					
					if(targetId!=''&&targetId!=null){
						targetId = targetId.trim();
					}
					
					if (enumTargetState == '编辑中') {
						$("input[name='uenumTargetState'][value='0']").attr("checked",true);
					} else if (enumTargetState == '待上架') {
						$("input[name='uenumTargetState'][value='100']").attr("checked",true);
						$("input[name='uenumTargetState'][value='0']").attr("disabled",true);
					} else if(enumTargetState == '已上架'){
						$("input[name='uenumTargetState'][value='200']").attr("checked",true); 
						$("input[name='uenumTargetState'][value='0']").attr("disabled",true);
						$("input[name='uenumTargetState'][value='100']").attr("disabled",true);
					}else {
						$("input[name='uenumTargetState'][value='300']").attr("checked",true); 
						$("input[name='uenumTargetState'][value='0']").attr("disabled",true);
						$("input[name='uenumTargetState'][value='100']").attr("disabled",true);
						$("input[name='uenumTargetState'][value='200']").attr("disabled",true);
					};
					$("#modal-state").on("shown.bs.modal",function(){
						$("#stargetName").val(targetName);
						$("#stargetId").val(idList);
					})
					
				}							
			});
}
function refresh(curPage) {
	var pageNum = curPage;
	$.ajax({
		type : 'post',
		url : '/bool-manage/selectTargetManageListRefresh.do',
		cache : false,
		dataType : 'html',
		data : {
			pageNum : pageNum
		},
		success : function(data) {
			$("#target_manage_list_table tbody").html();
			$("#target_manage_list_table tbody").html(data);
			rowInstance = call_rowSelect_wizard("table-row-select");
		}
	})
}
