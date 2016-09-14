$(function(){
			// 定义跳转页面所对应的脚本文件，
			var scriptFiles = {
					'hqUserList.do': 'script/hqUserList.js',
					'/activity-img/selectPageList.do': 'script/activity_manage/activity_img_list.js',
					'/banner/bannerList.do': 'script/banner_manage/banner_list.js',
					'/sys-img/selectPageList.do': 'script/img_manage/sys_img_list.js',
				    '/activityManageList.do': 'script/activity_manage/activity_img_list.js',
				    '/hqUser/getUserPageList.do': 'script/bond_pool/user_invest_list.js',
				    '/hqUser/investRecordPageList.do': 'script/bond_pool/invest_record_list.js',
				    '/activity-manage/activityManageList.do': 'script/activity_manage/activity_manage_list.js',
				    '/bool-manage/targetManageList.do':'script/bool_manage/target_manage_list.js',
				    '/bool-manage/hqDebtEditorList.do':'script/bool_manage/hq_debt_editor_list.js',
				    '/bool-manage/hqDebtAuditList.do':'script/bool_manage/hq_debt_audit_list.js',
				    '/bool-manage/hqDebtPoolList.do':'script/bool_manage/hq_debt_pool_list.js',
				    '/regular-manage/dqTargetList.do':'script/regular_manage/regular_manage_list.js',
				    '/opt-money-coupon/selectPageList.do':'script/operation_manage/operation_money_list.js',
				    '/regular-manage/dqTargetAuditList.do':'script/regular_manage/regular_audit_manage_list.js',
				    '/opt-money-coupon/selectReviewList.do':'script/operation_manage/opt_review_money_list.js',
				    '/opt-rate-coupon/selectPageList.do':'script/operation_manage/operation_rate_list.js',
				    '/opt-rate-coupon/selectReviewList.do':'script/operation_manage/opt_review_rate_list.js',
				    '/app-version/versionPageList.do': 'script/version_manage/version_list.js',
				    '/app-version/reviewList.do': 'script/version_manage/version_review_list.js',
				    '/userWithdraw/queryWithdraw': 'script/settle_administration/user_withdraw_list.js',
				    '/withdraw/selectPageList.do':'script/fopay/fopay.js',
				    '/activity-manage/regActivityManageList.do': 'script/activity_manage/reg_activity_manage_list.js',
				    '/activity-manage/awardActivityManageList.do': 'script/activity_manage/award_activity_manage_list.js'				    
			};
			var defaultPage = function(){
				var defaultUrl = '/activity-manage/activityManageList.do';
				$.ajax({
					type: 'get',
        			url: defaultUrl,
        			cache: false,
        			dataType: 'html',
        			async: true,
        			success: function(data){
        				$(".main-content").html(data);
        				var path = document.location.href;
        				var startIndex = scriptFiles[defaultUrl].lastIndexOf('/')+1;
    					var endIndex = scriptFiles[defaultUrl].lastIndexOf('.js');
    					var addString = scriptFiles[defaultUrl].substring(startIndex,endIndex);
    					var regExp = eval("/\\["+addString+"]/ig");
      				if(!path.match(regExp)){
      						
        					 document.location.href = path.substring(0,path.indexOf('#')) + '#'+addString;
        				}
        				// 动态加载js文件
        				loadJsFile(scriptFiles[defaultUrl]);
        				
        			},
        			error: function(){
        				alert("fail to load "+jumpUrl+" script");
        			}	
				})
			}();
		
	
			
	
			$("a[data-link='pageLink']").click(function(){
        		var new_active = $(this).parent();
           		$(".nav-list li.active").removeClass("active");
        		new_active.addClass("active").parents('.nav-list li').addClass('active');
        		
        		var jumpUrl = $(this).data("forward");
        		$.ajax({
        			type: 'get',
        			url: jumpUrl,
        			cache: false,
        			dataType: 'html',
        			async: true,
        			success: function(data){
        				$(".main-content").html();
        				$(".main-content").html(data);
        				var path = document.location.href;
        				var startIndex = scriptFiles[jumpUrl].lastIndexOf('/')+1;
    					var endIndex = scriptFiles[jumpUrl].lastIndexOf('.js');
    					var addString = scriptFiles[jumpUrl].substring(startIndex,endIndex);
    					var regExp = eval("/\\["+addString+"]/ig");
      				if(!path.match(regExp)){
      						
        					 document.location.href = path.substring(0,path.indexOf('#')) + '#'+addString;
        				}
        				// 动态加载js文件
        				loadJsFile(scriptFiles[jumpUrl]);
        				
        				
        			},
        			error: function(){
        				alert("fail to load "+jumpUrl+" page");
        			}	
        		});
      		});
    	});

function loadJsFile(filename){
	if(!filename){
		return;
	}
	var curScript = document.getElementById("dynamic_Script");
	if(curScript== null){
		var script = document.createElement("script");
		script.setAttribute('id','dynamic_Script');
		script.setAttribute("type","text/javascript");
		script.setAttribute("src",filename);
		var head = document.getElementsByTagName('head')[0];
		head.appendChild(script);
	}else{
		 $("#dynamic_Script").remove();
		 var script = document.createElement("script");
			script.setAttribute('id','dynamic_Script');
			script.setAttribute("type","text/javascript");
			script.setAttribute("src",filename);
			var head = document.getElementsByTagName('head')[0];
			head.appendChild(script);
	}
}
