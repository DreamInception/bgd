$(function() {
	loads();
	
	//分页插件
	var totalPages = $("#pageCount").val() || 0;
	var rowInstance = null;
	$.getScript("script/common/call.common.wizard.js",function(){
		//行选择器
		rowInstance = call_rowSelect_wizard("table-row-select");
		// 颜色选择器
		call_colorpicker_wizard("table-colorpicker");
		
		//分页插件
		call_laypage_wizard('laypage_pageNum');
		call_datepicker_wizard();
	});
	$("#preShelve-modal-nodata").on("shown.bs.modal",function(){
		 $('#onsaleTime').datetimepicker().next().on(ace.click_event, function(){
		        $(this).prev().focus();
		    });
	})
	  
})
	function refresh(curPage) {
		var pageNum = curPage;
		$.ajax({
			type : 'post',
			url : '/regular-manage/dqTargetAuditListRefresh.do',
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
	$("#select-regular-manage-list").on("click", function() {
		selectDqTargetAuditList();
	});
	
	$("#regular-pre-shelve-submit").on("click", function() {
		preShelve();
	});
	
	$("#regular-shelve-submit").on("click", function() {
		shelve();
	});
}

function reject(targetId) {
	if (confirm("确定此操作吗")) {
		$.ajax({
			type : 'post',
			url : '/regular-manage/reject.do',
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
				
			}
		});
	}
}

function adopt(targetId) {
	if (confirm("确定此操作吗")) {
		$.ajax({
			type : 'post',
			url : '/regular-manage/adopt.do',
			async : true,
			dataType : 'html',
			data : {
				"targetId" : targetId
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
				}
			},
			error : function() {
				
			}
		});
	}
}

function shelveAudit(targetId){
	$("#shelveTargetId").val(targetId);
}

function shelve(targetId) {
	if (confirm("确定此操作吗")) {
		$.ajax({
			type : 'post',
			url : '/regular-manage/shelve.do',
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
			}
		});
	}
}

function preShelveAudit(targetId){
	$("#preShelveTargetId").val(targetId);
}

function preShelve() {
	var targetId = $("#preShelveTargetId").val();
	var onsaleTime = $("#onsaleTime").val();
	if(onsaleTime==null||onsaleTime==''){
		call_datepicker_wizard()('预上架时间不能为空');
		return false;
	}
	if (confirm("确定此操作吗")) {
		$.ajax({
			type : 'post',
			url : '/regular-manage/preShelve.do',
			async : true,
			dataType : 'html',
			data : {
				"targetId" : targetId,
				"onsaleTime" : onsaleTime
			},
			success : function(data) {
				if (!data.match("^\{(.+:.+,*){1,}\}$")) {
					$("#preShelve-modal-nodata").modal('hide');
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
				
			}
		});
	}
}

function selectDqTargetAuditList(){
	var targetId = $("#ptargetId").val();
	var targetName = $("#ptargetName").val();
	var startCreateTime = $("#pstartCreateTime").val();
	var endCreateTime = $("#pendCreateTime").val();
	
	
	$.ajax({
		type : 'post',
		url : '/regular-manage/selectDqTargetAuditList.do',
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
			call_alert_wizard("系统错误，请联系管理员");
		}
	});
}