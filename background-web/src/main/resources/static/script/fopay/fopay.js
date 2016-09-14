  
$(function() {
	loads();
	
	var rowInstance = null;
	
	$.getScript("script/common/call.common.wizard.js",function(){
		//行选择器
		rowInstance = call_rowSelect_wizard("table-row-select");
		// 颜色选择器
		call_colorpicker_wizard("table-colorpicker");
		
		//分页插件
		call_laypage_wizard('laypage_pageNum');
		//spinner插件
		call_spinner_wizard('appendYearRate');
		call_spinner_wizard('appendDayCount');
		call_datepicker_wizard();
	});

	

});

//资金退回
function assetBack(applicationId){
	$.ajax({
		url:'/withdraw/assetBack/'+applicationId+'.do',
		type:'POST',
		success:function(result){
			alert(result.msg);
			refresh(1);
			rowInstance = call_rowSelect_wizard("table-row-select");
		},
		error:function(){
			alert("系统错误");
			refresh(1);
			rowInstance = call_rowSelect_wizard("table-row-select");
			
		}
	});
}

//刷新页面
function refresh(curPage){
	var pageNum = curPage;
		$.ajax({
			url:'/withdraw/refresh.do',
			type:'post',
			cache : false,
			dataType : 'html',
			data : {
				pageNum : pageNum
			},
			success:function(data){
				$("#list_tablet body").html("");
	   				$("#list_table tbody").html("");
	   				$("#list_table tbody").html(data);
	   				rowInstance = call_rowSelect_wizard("table-row-select");
			},
			error: function(){
	        		//alert("fail to load "+jumpUrl+" page");
     	}
		});
}
function fopay(applicationId){
    	$.ajax({
    		url:'/withdraw/fopay/'+applicationId+'.do',
    		type:'POST',
    		success:function(result){
    			alert(result.msg);
    			refresh(1);
    			rowInstance = call_rowSelect_wizard("table-row-select");
    		},
    		error:function(){
    			alert("系统错误");
    			//window.location.href="/withdraw//refresh.do";
    			refresh(1);
    			rowInstance = call_rowSelect_wizard("table-row-select");
    			
    		}
    	});
    	
    	}
function alertMsg(applicationId){
	$.ajax({
		url:'/withdraw/alertMsg/'+applicationId+'.do',
		type:'POST',
		success:function(result){
			alert(result.msg);
			refresh(1);
			rowInstance = call_rowSelect_wizard("table-row-select");
		},
		error:function(){
			alert("系统错误");
			//window.location.href="/withdraw//refresh.do";
			refresh(1);
			rowInstance = call_rowSelect_wizard("table-row-select");
			
		}
	});
}
	
