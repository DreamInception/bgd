$(function() {
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
	});
	$("#modal-hasdata").on("shown.bs.modal",function(){
		call_fileUpload_wizard();
	});
	//局部刷新
	function refresh(curPage){
	  var pageNum = curPage;
	  $.ajax({
		type: 'POST',
		url: '/sys-img/refresh.do',
		cache: false,
		dataType: 'html',
		async : false,
		data: {
			'pageNum': pageNum
		},
	  	success: function(data){
	  		$("#list_table tbody").html();
	  		$("#list_table tbody").html(data);
	  		rowInstance = call_rowSelect_wizard("table-row-select");
	  		commonJs();
	  	}
	  })
	}
	$("#changeBtn").click(function() {
		var idList = rowInstance.getSelectIDs();

		if (idList.length > 1) {
			alert("只能选择一行数据");
			return false;
		} else if (idList.length == 0) {
			alert("请先选择一行数据");
			return false;
		} else {

			$.ajax({
				url : '/sys-img/selectByPrimaryKey.do?cmsAutoId=' + idList,
				type : 'POST',
				dataType : 'json',
				cache : true,
				async : false,
				success : function(result) {
					if (result.flag) {
						$("#autoId").val(result.data.autoId);
						$("#picCode-edit").val(result.data.picCode);
						$("#remark-edit").val(result.data.remark);

					} else {
						alert(result.message);
					}
				},
				error : function(data) {
					alert("查找失败");
				}
			});
		}

	});

	$("#removeBtn").click(
			function() {
				var idList = rowInstance.getSelectIDs();

				if (idList.length > 1) {
					alert("只能选择一行数据");
				} else if (idList.length == 0) {
					alert("请先选择一行数据");
				} else {

					$.ajax({
						url : '/sys-img/deleteByPrimaryKey.do?cmsAutoId='
								+ idList,
						type : 'POST',
						dataType : 'html',
						cache : true,
						async : false,
						success : function(data) {
							$(".main-content").html();
							$(".main-content").html(data);
							commonJs();
						},
						error : function(data) {
							alert("删除失败");
						}
					});
				}

			});



})



//添加表单异步提交
function insertForm(){
  var formData = new FormData($( "#insertForm" )[0]);
  $.ajax({
    url: '/sys-img/insert.do' ,
    type: 'POST',
    data: formData,
    dataType: 'html',
    async: false,
    cache: false,
    contentType: false,
    processData: false,
    success: function (data){
    		$("#modal-nodata").modal('hide');
    		$(".modal-backdrop").hide();
	    	$(".main-content").html();
        	$(".main-content").html(data);
        
    },
    error: function (data){
        alert("上传失败");
        $(".main-content").html();
        $(".main-content").html(data);
    }
  });
}

//清空添加表单
function resetInsertForm(){
	$("#picCode").val();
	$("#remark").val();
}

//清空编辑表单
function resetEditForm(){
	$("#picCode-edit").val();
	$("#remark-edit").val();
}

//修改图片异步提交
function editForm(){
  var formData = new FormData($( "#editForm" )[0]);
  $.ajax({
    url: '/sys-img/edit.do',
    type: 'POST',
    data: formData,
    dataType: 'html',
    async: false,
    cache: false,
    contentType: false,
    processData: false,
    success: function (data){
    		$("#modal-nodata").modal('hide');
    		$(".modal-backdrop").hide();
	    	$(".main-content").html();
        	$(".main-content").html(data);

    },
    error: function (data){
        alert("上传失败");
        $(".main-content").html();
        $(".main-content").html(data);
    }
  });
}

