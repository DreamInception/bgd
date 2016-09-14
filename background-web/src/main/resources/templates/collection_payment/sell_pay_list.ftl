		<div class="breadcrumbs" id="breadcrumbs">
            <!-- breadcrumbs goes here -->
             <ul class="breadcrumb">
                <li><i class="fa fa-home home-icon"></i> <a href="#">Home</a></li>
                <li><a href="#"> 清算管理</a></li>
                <li class="active">收取赎回金</li>
            </ul>
        </div>

        <div class="page-content">
            <!-- setting box goes here if needed -->
<div class="page-content-area">
			<div class="page-header">
			  <h1 class="green">收取赎回金 </h1>
			</div>
			
            <div class="row">
                <div class="col-xs-12 widget-container-col">
                	<div class="widget-box widget-color-blue">
                	<div class="widget-header">
                				<h5 class="widget-title bigger lighter">
										<i class="ace-icon fa fa-table"></i>
											Tables & Colors
								</h5>

								<div class="widget-toolbar widget-toolbar-light no-border">
										<select id="table-colorpicker" class="hide">
											<option selected="" data-class="blue" value="#307ECC">#307ECC</option>
											<option data-class="blue2" value="#5090C1">#5090C1</option>
											<option data-class="blue3" value="#6379AA">#6379AA</option>
											<option data-class="green" value="#82AF6F">#82AF6F</option>
											<option data-class="green2" value="#2E8965">#2E8965</option>
											<option data-class="green3" value="#5FBC47">#5FBC47</option>
											<option data-class="red" value="#E2755F">#E2755F</option>
											<option data-class="red2" value="#E04141">#E04141</option>
											<option data-class="red3" value="#D15B47">#D15B47</option>
											<option data-class="orange" value="#FFC657">#FFC657</option>
											<option data-class="purple" value="#7E6EB0">#7E6EB0</option>
											<option data-class="pink" value="#CE6F9E">#CE6F9E</option>
											<option data-class="dark" value="#404040">#404040</option>
											<option data-class="grey" value="#848484">#848484</option>
											<option data-class="default" value="#EEE">#EEE</option>
										</select>
								</div>
                	</div>
                  	<div class="widget-body">
                  		<div class="widget-main no-padding">
                  			
            <div class="row">
                <div class="col-xs-12">
                        <table class="table table-bordered" id="bond_list_table">
                            <thead>
                            <tr>
                                <th class="hidden">ID</th>
                                  <th>标题</th>
						          <th>代收新浪单号</th>
								  <th>新浪用户标识</th>
								  <th>标识类型</th>
								  <th>金额</th>
								  <th>状态</th>
								  <th>操作备注</th>
								  <th>创建时间</th>
                            </tr>
                            </thead>
                            <tbody id="tbody">
                       			<#include "sell_pay_refresh.ftl"/>
                             </tbody>
                        </table>
                        <div class="clearfix table-bottom-btns">
                            <button id="newBtn" class="btn btn-sm btn-success" data-toggle="modal"
                                    data-target="#modal-data">
                                <i class="fa fa-pencil align-top bigger-125 ace-icon"></i>
                                新增
                            </button>
                            <button id="changeBtn" class="btn btn-sm btn-primary" data-toggle="modal"
                                    data-target="#modal-hasdata">
                                <i class="fa fa-pencil-square-o align-top bigger-125 ace-icon">
                                </i>
                                修改
                            </button>
                            <button id="removeBtn" class="btn btn-sm btn-danger">
                                <i class="fa fa-trash-o align-top bigger-125 ace-icon">
                                </i>
                                删除
                            </button>
							<aside id="bond_bottom_pageNum" class="bond_bottom_pageNum pull-right"></aside>
                        </div>
                    </div>
                      <!-- /.widget-main -->
                   </div>
       				 <!-- /.widget-body -->
        			</div>
        			<!-- /.widget-box -->
                  </div>
            <!-- /.col -->
                </div>
            <!-- /.row -->
			</div>
			 <!-- /.page-content-area -->
        </div>
<!-- /.page-content -->
				<div id="modal-data" class="modal fade">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header md-head">
                                 	赎回代收
                                </div>
                                <div class="modal-body">
                                    <form class="form-horizontal" role="form">
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right green"
                                                   for="form-field-1">账户可用余额</label>

                                            <div class="col-sm-6">
                                                <lable id="balance" name="balance"  class="form-control"></lable>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right green"
                                                   for="form-field-2">中间账户余额</label>

                                            <div class="col-sm-6">
                                               <lable id="accountAmount" name="accountAmount"  class="form-control"></lable>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right green"
                                                   for="form-field-3">错误信息</label>

                                            <div class="col-sm-6">
                                            <lable id="error" name="error"  class="form-control"></lable>
                                                
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right green"
                                                   for="form-field-4">标题</label>

                                            <div class="col-sm-6">
                                                <input type="text" id="title" name="title" class="form-control" />
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right green"
                                                   for="form-field-5">金额</label>

                                            <div class="col-sm-6">
                                               <input type="text" id="amount" name="amount" class="form-control" />
                                            </div>
                                        </div>
                                    </form>
                                </div>
                                <div class="modal-footer clearfix">
                                    <div class="center">
                                        <button type="button" id="confirm" class="btn btn-sm btn-success">
                                            <i class="fa fa-cloud-upload align-top bigger-125 ace-icon"></i>
                                            提交
                                        </button>
                                        <button type="button" id="cancel" class="btn btn-sm btn-danger">
                                            <i class="fa fa-undo align-top bigger-125 ace-ic"></i>
                                            取消
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- /.col -->
            </div>
            <!-- /.row -->

        </div>
        <!-- /.page-content -->


    
    





    <script type="text/javascript">
  
  	$(function(){
  		$("#newBtn").on("click",function(){
  			$.ajax({
  				url:'/collectionPayment/toSellPayAdd',
  				type:'post',
  				success:function(data){
  					$("#balance").html(data.balance);
  					$("#accountAmount").html(data.amount);
  					$("#error").html(data.error==null?'无':data.error);
  				},
  				error:function(data){
  					alert("系统错误");
  				}
  			});
  		});
  		$("#cancel").on("click",function(){
  			$("#title").val("");
    		$("#amount").val("");
  			$("#modal-data").modal('hide');
    		$(".modal-backdrop").hide();
  		});
  		 $("#confirm").on("click",function(){
    	var title = $("#title").val();
    	var amount = $("#amount").val();
    	$.ajax({
    		url:"/collectionPayment/saveSellPay",
    		data:{"title":title,"amount":amount},
    		type:"post",
    		success:function(result){
    			alert(result.msg);
    			sellPayRefresh();
    		},
    		error:function(){
    			alert("系统错误");
    		}
    	});
    });
  	});
  	 function sellPayRefresh(){
   		$.ajax({
   			url:'/collectionPayment/sellPayRefresh',
   			type:'post',
   			success:function(data){
   				$("#tbody").html("");
   				$("#tbody").html(data);
   				$("#title").val("");
    		$("#amount").val("");
  			$("#modal-data").modal('hide');
    		$(".modal-backdrop").hide();
   			},
   			error: function(){
        		alert("fail to load "+jumpUrl+" page");
        	}
   		});
   }
</script>
    


