$(function() {
	loads();
	var rowInstance = null;

	//分页插件
	var totalPages = $("#pageCount").val() || 0;


})
	function refresh(curPage) {
		var pageNum = curPage;
		$.ajax({
			type : 'post',
			url : '/regular-manage/dqTargetListRefresh.do',
			cache : false,
			dataType : 'html',
			data : {
				pageNum : pageNum
			},
			success : function(data) {
				$("#regular_manage_list_table tbody").html();
				$("#regular_manage_list_table tbody").html(data);
				rowInstance = call_rowSelect_wizard("table-row-select");
			}
		})
     }
function loads(){
	$.getScript("script/common/call.common.wizard.js",function(){
		//行选择器
		rowInstance = call_rowSelect_wizard("table-row-select");
		// 颜色选择器
		call_colorpicker_wizard("table-colorpicker");
		
		//分页插件
		call_laypage_wizard('laypage_pageNum');
		call_alert_wizard;
	});
	call_datepicker_wizard();
	$("#modal-nodata").on('shown.bs.modal',function(){
		$.getScript("script/common/call.common.wizard.js",function(){
			//下拉框选择器
			call_chosenSelect_wizard();
			//spinner插件
		//	call_spinner_wizard('yearRate');
		//	call_spinner_wizard('targetYearRate');
		});
	})
	$("#regular-submit").on("click", function() {
		regularSubmit();
	});
	
	$("#regular-modify").on("click", function() {
		regularModify();
	});
	
	$("#select-regular-manage-list").on("click", function() {
		selectRegularManageList();
	});
	
	
	targetIconItems();
	actAutoIdItems();

	
	$("#uyearRate").on("change",function(){
		var yearRate = $("#uyearRate").val();
		if(yearRate!=''){
			var yearRate2 = Number(yearRate);
			var num=Number(yearRate2/360).toFixed(10);
			$("#udayRate").val(num.substring(0,num.lastIndexOf('.')+7))
		}
	});
	
	$("#yearRate").on("input",function(){
		var yearRate = $("#yearRate").val();
		if(yearRate!=''){
			var yearRate2 = Number(yearRate);
			var num=Number(yearRate2/360).toFixed(10);
			$("#dayRate").val(num.substring(0,num.lastIndexOf('.')+7))
		}
	});


	$("#changeBtn").click(function() {
		var idList = rowInstance.getSelectIDs();
		var enumDqtargetState = rowInstance.getSelectCeilData("enumDqtargetState");
		
		if (idList.length > 1) {
			call_alert_wizard("只能选择一行数据");
			return false;
		} else if( idList.length == 0){
			call_alert_wizard("请先选择一行数据");
			return false;
		} else if (enumDqtargetState.trim()!='录入中') {
			call_alert_wizard;
			return false;

		} else {
			var targetId = idList[0];
			$.ajax({
				type : 'post',
				url : '/regular-manage/selectDqTarget.do',
				async : false,
				dataType : 'json',
				data : {
					"targetId":targetId
				},
				success : function(obj) {
					if(obj.flag){
						var model = obj.data;
						$("#utargetName").val(model.targetName);
						$("#upicCode").attr('src',model.targetIcon); 
						$("#utargetAmount").val(model.targetAmount);
						$("#uunitAmount").val(model.unitAmount);
						$("#uminAmount").val(model.minAmount);
						$("#ubeginDate").val(getNowFormatDate(new Date(model.beginDate)));
						$("#uendDate").val(getNowFormatDate(new Date(model.endDate)));
						$("#uyearRate").val(model.yearRate);
						$("#udayRate").val(model.dayRate);
						$("#usellerName").val(model.sellerName);
						$("#udqContent").val(model.dqContent);				        
						$("#utargetIcon option").val(model.targetIcon).text(model.picRemark);
						$("#uactAutoId option").val(model.actAutoId).text(model.actName);
						$("#utargetId").val(model.sTargetId);
						$("#uenumDqtargetState").val(model.enumDqtargetState);
						utargetIconItems(model.targetIcon,model.picRemark);
						uactAutoIdItems(model.actAutoId,model.actName);
					}else{
						call_alert_wizard(obj.message);
					}
				},
				error : function() {
					call_alert_wizard('系统错误，请联系管理员');
				}
			});
		}

	});

}

//获取当前时间，格式YYYY-MM-DD
function getNowFormatDate(strTime) {
    var date = new Date(strTime);
    var seperator1 = "-";
    var year = date.getFullYear();
    var month = date.getMonth() + 1;
    var strDate = date.getDate();
    if (month >= 1 && month <= 9) {
        month = "0" + month;
    }
    if (strDate >= 0 && strDate <= 9) {
        strDate = "0" + strDate;
    }
    var currentdate = year + seperator1 + month + seperator1 + strDate;
    return currentdate;
}

function regularSubmit(){
	var targetName = $("#targetName").val();
	var targetIcon= $("#targetIcon").val();
	var targetAmount= $("#targetAmount").val();
	var unitAmount= $("#unitAmount").val();
	var minAmount = $("#minAmount").val();
	var beginDate= $("#beginDate").val();
	var endDate = $("#endDate").val();
	var yearRate= $("#yearRate").val();
	var dayRate= $("#dayRate").val();
	var sellerName= $("#sellerName").val();
	var dqContent= $("#dqContent").val();
	var actAutoId= $("#actAutoId").val();
	
	if(targetIcon=='0'){
		call_alert_wizard('请选择图片');
		return false;
	}
	
	$.ajax({
		type : 'post',
		url : '/regular-manage/addDqTarget.do',
		async : false,
		dataType : 'html',
		data : {
			"targetName" : targetName,
			"targetIcon" : targetIcon,
			"targetAmount" : targetAmount,
			"unitAmount" : unitAmount,
			"minAmount" : minAmount,
			"beginDate" : beginDate,
			"endDate" : endDate,
			"yearRate" : yearRate,
			"dayRate" : dayRate,
			"sellerName":sellerName,
			"dqContent":dqContent,
			"actAutoId":actAutoId
		},
		success : function(data) {
			if (!data.match("^\{(.+:.+,*){1,}\}$")) {
				$("#modal-nodata").modal('hide');
				$(".modal-backdrop").hide();
				$(".main-content").html();
				$(".main-content").html(data);
				rowInstance = call_rowSelect_wizard("table-row-select");
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


function regularModify(){
	var targetName = $("#utargetName").val();
	var targetAmount = $("#utargetAmount").val();
	var unitAmount = $("#uunitAmount").val();
	var minAmount = $("#uminAmount").val();
	var beginDate = $("#ubeginDate").val();
	var endDate = $("#uendDate").val();
	var yearRate = $("#uyearRate").val();
	var dayRate = $("#udayRate").val();
	var sellerName = $("#usellerName").val();
	var dqContent = $("#udqContent").val();				        
	var targetIcon = $("#utargetIcon").val();
	var actAutoId = $("#uactAutoId").val();
	var targetId = $("#utargetId").val();
	var targetId = $("#utargetId").val();
	var enumDqtargetState = $("#uenumDqtargetState").val();
	if(targetIcon=='0'){
		call_alert_wizard('请选择图片');
		return false;
	}
	
	$.ajax({
		type : 'post',
		url : '/regular-manage/modifyDqTarget.do',
		async : false,
		dataType : 'html',
		data : {
			"targetName" : targetName,
			"targetIcon" : targetIcon,
			"targetAmount" : targetAmount,
			"unitAmount" : unitAmount,
			"minAmount" : minAmount,
			"beginDate" : beginDate,
			"endDate" : endDate,
			"yearRate" : yearRate,
			"dayRate" : dayRate,
			"sellerName":sellerName,
			"dqContent":dqContent,
			"actAutoId":actAutoId,
			"targetId":targetId,
			"enumDqtargetState":enumDqtargetState
		},
		success : function(data) {
			if (!data.match("^\{(.+:.+,*){1,}\}$")) {
				$("#modal-hasdata").modal('hide');
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

function enumDqtargetState(targetId) {
	if (confirm("确定此操作吗")) {
		$.ajax({
			type : 'post',
			url : '/regular-manage/enumDqtargetState.do',
			async : true,
			dataType : 'html',
			data : {
				"targetId" : targetId
			},
			success : function(data) {
				if (!data.match("^\{(.+:.+,*){1,}\}$")) {
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

function fullScale(targetId) {
	if (confirm("确定此操作吗")) {
		$.ajax({
			type : 'post',
			url : '/regular-manage/fullScale.do',
			async : true,
			dataType : 'html',
			data : {
				"targetId" : targetId
			},
			success : function(data) {
				if (!data.match("^\{(.+:.+,*){1,}\}$")) {
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
function selectRegularManageList(){
	var targetId = $("#ptargetId").val();
	var targetName = $("#ptargetName").val();
	var startCreateTime = $("#pstartCreateTime").val();
	var endCreateTime = $("#pendCreateTime").val();
	
	
	$.ajax({
		type : 'post',
		url : '/regular-manage/selectDqTargetList.do',
		async : false,
		dataType : 'html',
		data : {
			"targetId" : targetId,
			"targetName" : targetName,
			"startCreateTime" : startCreateTime,
			"endCreateTime" : endCreateTime
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


function targetIconItems() {  
	$.ajax({  
	        url: "/regular-manage/getTargetIconItems.do", 
	        type: "post",  
	        dataType: "json",  
	        contentType: "application/json",  
	        traditional: true,  
	        success: function (data) {
	        	$("#targetIcon").html("<option value='0'>请选择</option>");
	            for (var i in data) {
	                var jsonObj =data[i];  
	                var optionstring = "";  
	                $("#targetIcon").html();
	                $("#targetIcon").append("<option value="+ jsonObj.pic_url+">"+ jsonObj.remark+"</option>");
	            }
	        },  
	        error: function (msg) {  
	            call_alert_wizard("系统错误，请联系管理员");  
	        }  
	    });           
	
} 

function utargetIconItems(otargetIcon,opicRemark) { 
	$.ajax({  
        url: "/regular-manage/getTargetIconItems.do", 
        type: "post",  
        dataType: "json",  
        contentType: "application/json",  
        traditional: true,  
        success: function (data) {
        	$("#utargetIcon").html("<option value='0'>请选择</option>");
            for (var i in data) {
                var jsonObj =data[i];  
                var optionstring = "";  
                $("#utargetIcon").append("<option value="+ jsonObj.pic_url+">"+ jsonObj.remark+"</option>");
            }
            $("#utargetIcon").find("option[text="+opicRemark+"]").attr("selected",true);
			$("#utargetIcon").val(otargetIcon);
        },  
        error: function (msg) {  
            call_alert_wizard("系统错误，请联系管理员");  
        }  
    });    
}

function uactAutoIdItems(oactAutoId,oactName) {  
	$.ajax({  
        url: "/regular-manage/getActAutoIdItems.do", 
        type: "post",  
        dataType: "json",  
        contentType: "application/json",  
        traditional: true,  
        success: function (data) {
        	$("#uactAutoId").html("<option value='0'>请选择</option>");
            for (var i in data) {
                var jsonObj =data[i];  
                var optionstring = "";  
                $("#uactAutoId").append("<option value="+ jsonObj.act_auto_id+">"+ jsonObj.act_name+"</option>");
            }
            $("#uactAutoId").find("option[text="+oactName+"]").attr("selected",true);
			$("#uactAutoId").val(oactAutoId);
        },  
        error: function (msg) {  
            call_alert_wizard("系统错误，请联系管理员");  
        }  
    });         
}

function actAutoIdItems() {  
		$.ajax({  
	        url: "/regular-manage/getActAutoIdItems.do", 
	        type: "post",  
	        dataType: "json",  
	        contentType: "application/json",  
	        traditional: true,  
	        success: function (data) {
	        	$("#actAutoId").html("<option value='0'>请选择</option>");
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