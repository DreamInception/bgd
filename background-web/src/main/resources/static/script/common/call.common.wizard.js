/*-------------- call rowselect wizard --------------------------------------*/
function call_rowSelect_wizard(id){
	var rowSelect = $("."+id).rowSelect({
		class : 'click-active',
		single : true,
		operation: 'click'
	});

	var rowInstance = rowSelect.data("rowSelect");
	return rowInstance;
}

/*-------------- call colorpicker wizard --------------------------------------*/
function call_colorpicker_wizard(id){
	$('#'+id).ace_colorpicker({pull_right:true}).on('change', function(){
	   var color_class = $(this).find('option:selected').data('class');
	   var new_class = 'widget-box';
	   if(color_class != 'default')  new_class += ' widget-color-'+color_class;
	   $(this).closest('.widget-box').attr('class', new_class);
	});
}
/*-------------- call laypage wizard --------------------------------------*/
function call_laypage_wizard(id){
	var totalPages = $("#pageCount").val() || 0;
	laypage({
		cont : id, // 分页的页码部分id
		pages : totalPages, //分页的总页数
		skin : '#428bca', //分页的皮肤颜色
		skip : false,
		first : '首页',
		last : '尾页',
//		curr : location.hash.replace('page=', ''), //当前的页码，并在当前浏览器地址栏中加上 page= pageNum
//		hash : 'page',
		jump : function(obj,first){
      		if(!first){
      			refresh(obj.curr);  // 传递当前的页码，ajax请求后台
      		}
      	}
	});
};
/*-------------- call chosenSelect wizard --------------------------------------*/
function call_chosenSelect_wizard(){
	 $('.chosen-select').chosen({
	        allow_single_deselect:true
//	        disable_search: true

	    });
	 $(".chosen-single").addClass("selsize");

		$(window).on('resize.chosen', function() {
		    //get its parent width
		    var w = $('.chosen-select').parent().width();
		    $('.chosen-select').siblings('.chosen-container').css({'width':w});
		}).triggerHandler('resize.chosen');
}
/*-------------- refresh page --------------------------------------*/
function reload(){
	var $curr = $(".submenu .active");
//	$(".nav-list li.active").removeClass("active");
//	$curr.addClass("active").parents(".nav-list li").addClass("active");
	if($curr){
		var url = $curr.children("a[data-link='pageLink']").attr("data-forward");
	}else{
		var url = '';
		return;
	}
//	var defaultUrl = '/activity-manage/activityManageList.do';
	$.ajax({
		type: 'get',
		url: url,
		cache: false,
		dataType: 'html',
		async: true,
		success: function(data){
			$(".main-content").html(data);
			console.log("refresh page success");
			var scriptfile = $("#dynamic_Script").attr("src");
			$.getScript(scriptfile);
			
		},
		error: function(){
			alert("fail to load "+jumpUrl+" script");
		}	
	})
};
/*-------------- spinner wizard--------------------------------------*/
function call_spinner_wizard(id){
	$('#'+id).ace_spinner({value:0,min:0,max:100,step:1, btn_up_class:'btn-success' , btn_down_class:'btn-danger',icon_up:'ace-icon fa fa-plus',icon_down:'ace-icon fa fa-minus'})
	.on('change', function(){
	  // alert(this.value);
	});
	$(".ace-spinner").css("width","100%");
}
/*-------------- confirm wizard--------------------------------------*/
function call_confirm_wizard(oper,seq,date){
	bootbox.confirm({
	    size: 'small',
	    message: "确定执行此操作吗？",
	    callback: function(result){ /* your callback code */
	        if(result){
	        	onSale(oper,seq,date);
	        }
	    }
	});

}
/*-------------- alert wizard--------------------------------------*/
function call_alert_wizard(msg){
	bootbox.alert({
	    size: 'small',
	    message: msg,
	    callback: function(){ /* your callback code */ }
	});

}
/*-------------- datepicker wizard--------------------------------------*/
function call_datepicker_wizard(){
	$('.date-picker').datepicker({
		autoclose : true,
		todayHighlight : true
	})
	// show datepicker when clicking on the icon
	.next().on("click", function() {
		$(this).prev().focus();
	});
}
/*-------------- fileUpload wizard--------------------------------------*/
function call_fileUpload_wizard(){
	$('.fileUpload').ace_file_input({
		no_file:'No File ...',
		btn_choose:'Choose',
		btn_change:'Change',
		droppable:false,
		onchange:null,
		thumbnail:false //| true | large
		//whitelist:'gif|png|jpg|jpeg'
		//blacklist:'exe|php'
		//onchange:''
		//
	});
	
}
