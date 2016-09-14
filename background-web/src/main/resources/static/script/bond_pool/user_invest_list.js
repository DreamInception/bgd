$(function(){
	var rowInstance = null;
	$.getScript("script/common/call.common.wizard.js",function(){
		//行选择器
		rowInstance = call_rowSelect_wizard("table-row-select");
		// 颜色选择器
		call_colorpicker_wizard("table-colorpicker");
		
		//分页插件
		call_laypage_wizard('laypage_pageNum');
	});
	$("#modal-nodata").on("shown.bs.modal",function(){
		call_fileUpload_wizard();
	})

    $("#changeBtn").click(function(){
    	var idList = rowInstance.getSelectIDs();
    	
  		if(idList.length > 1){
  			alert("只能选择一行数据");
  		
  		}
  		else if(idList.length == 0){
  			alert("请先选择一行数据");
  			
  		}else{
  			alert("idList=========="+idList);
  			 $.ajax({
  			    url: '/activity-img/insert.do',
  			    type: 'POST',
  			    dataType: 'json',
  			    async: false,
  			    cache: false,
  			    contentType: false,
  			    processData: false,
  			    success: function (data){
	  			    $("#cmsAutoId").val(data.cms_auto_id);
	  			    $("#remark-edit").val(data.remark);
	  			    if(data.is_login==1){
	  			    	$("#isLoginA").val(data.remark);
	  			    }
		  			$("#h5Url-edit").val();
		  			$("#androidKey-edit").val(data.android_key);
		  			$("#iosKey-edit").val(data.ios_key);
		  			$("#sort-edit").val(data.sort);
  			    },
  			    error: function (data){
  			        alert("查找失败");
  			    }
  			  });
  		}
  		
   });
		
})
