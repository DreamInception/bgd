<div class="breadcrumbs" id="breadcrumbs">
            <!-- breadcrumbs goes here -->
            <ul class="breadcrumb">
                <li><i class="fa fa-home home-icon"></i> <a href="">Home</a></li>
                <li><a href="#">运营管理</a></li>
                <li class="active">体验金券列表</li>
            </ul>
</div>
<div class="page-content">
<!-- setting box goes here if needed -->
		<div class="page-content-area">
			<div class="page-header">
			  <h1 class="green">赠送体验金券列表 </h1>
			    <button id="refreshBtn" class="btn btn-sm btn-danger refreshBtn" style="margin-top: 5px;" onclick="reload()">
                                <i class="fa fa-refresh align-top bigger-125 ace-icon white"></i>
                                刷新
              </button>
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
                  			<aside class='table-search-area'>
                  				<span>活动ID</span>
                    			<input type="text" name="actAutoId" id="actAutoId" value="${(params.actAutoId)!""}">
                    			<span>活动标题</span>
                    			<input type="text" name="pActName" id="pActName" value="${(params.actName)!""}">
                    			<button id="select_activity_list" class="btn btn-sm btn-warning" data-toggle="modal"
                                    data-target="#modal-nodata">
                                <i class="fa fa-search align-top bigger-125 ace-icon"></i>
                                	查询
                            </button>
                			</aside>
                        <table class="table table-bordered table-row-select" id="operation_money_list_table">
                            <thead>
                            <tr>
                                <th>ID</th>
                                <th>赠送用户</th>
                                <th>体验金金额</th>
                                <th>加息年利率</th>
                                <th>加息天利率</th>
                                <th>加息天数</th>
                                <th>有效期截止日期</th>
                                <th>激活最低投资金额</th>
                                <th>激活最低投资天数</th>
                                <th>赠送审核状态</th>
                                <th>赠送管理员</th>
                                <th>审核管理员</th>
                                <th>备注</th>
                                <th>创建时间</th>
                            </tr>
                            </thead>
                            <tbody>
                       			<#include "operation_money_refresh.ftl"/>
                             </tbody>
                        </table>
                        <div class="clearfix table-bottom-btns">
                            <button id="newBtn" class="btn btn-sm btn-success" data-toggle="modal"
                                    data-target="#modal-nodata">
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
							<aside id="laypage_pageNum" class="bond_bottom_pageNum pull-right"></aside>
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
        <div id="modal-nodata" class="modal fade">
                        <div class="modal-dialog">
                            <div class="modal-content">
                            	<div class="modal-header no-padding">
                                	<div class="table-header">
													<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
														<span class="white">&times;</span>
													</button>
													     <i class="fa fa-hand-o-down bigger-125 ace-icon" style="margin-right: 5px;"></i>
												             添加体验金券
												</div>
                         
                                </div>
                                <div class="modal-body">
                                    <form id="insertForm" class="form-horizontal" action="/opt-money-coupon/insert.do" role="form" method="post">
                                    	<input type="hidden" id="sendAdminid" name="sendAdminid" value="2016070518019111845"/>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right green"
                                                   for="form-field-1">用户手机</label>

                                            <div class="col-sm-6">
                                            	<div class="input-group input-group-sm">
                                                	<input type="text" id="userMobile" name="userMobile" class="form-control"
                                   						value="" placeholder="用户手机">
                                   					<a href="javascript:searchUser();" class="input-group-addon">
                                            			<i class="fa fa-search align-top bigger-110 ace-icon"></i>
                                            		</a>
                                            	</div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right green"
                                                   for="form-field-3">用户编号</label>

                                            <div class="col-sm-6">
                                                <input type="text" id="userId" name="userId" class="form-control"
                                   					value="" placeholder="用户编号" readonly="true">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right green"
                                                   for="form-field-3">用户姓名</label>

                                            <div class="col-sm-6">
                                                <input type="text" id="userName" name="userName" class="form-control"
                                   					value="测试" placeholder="用户姓名" readonly="true">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right green"
                                                   for="form-field-2">金额</label>

                                            <div class="col-sm-6">
                                                <input type="text" id="amount" name="amount" class="form-control"
                                   					value="" placeholder="金额">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right green"
                                                   for="form-field-3">年利率(样例：0.06)</label>

                                            <div class="col-sm-6">
                                                <input type="text" id="yearRate" name="yearRate" class="form-control"
                                   					value="0.06" placeholder="年利率">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right green"
                                                   for="form-field-4">赠送天数</label>

                                            <div class="col-sm-6">
                                                <input type="text" id="dayCount" name="dayCount" class="form-control"
                                   					value="" placeholder="赠送天数">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right green"
                                                   for="form-field-5">有效截止日期</label>

											<div class="col-sm-6">
												<div class="input-group input-group-sm">
 												<input class="form-control date-picker" id="endDate" name="endDate" type="text"
                               						data-date-format="yyyy-mm-dd" style="padding-left: 12px;"/>
        									 	<span class="input-group-addon">
             										<i class="fa fa-calendar bigger-110"></i>
         									 	</span>
												</div>
											</div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right green"
                                                   for="form-field-6">最低投资金额</label>

                                            <div class="col-sm-6">
                                                <input type="text" id="minAmount" name="minAmount"  class="form-control" value="" placeholder="最低投资金额"/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right green"
                                                   for="form-field-7">最少投资天数</label>

                                            <div class="col-sm-6">
                                                <input type="text" id="minDays" name="minDays"  class="form-control" value="" placeholder="最少投资天数"/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right green"
                                                   for="form-field-8">备注</label>

											<div class="col-sm-6">
                                                <input type="text" id="remark" name="remark"  class="form-control" value="" placeholder="备注"/>
                                            </div>
                                        </div>
                                    
                                </div>
                                <div class="modal-footer clearfix">
                                    <div class="center">
                                        <a id="insertbtn" disabled="disabled" class="btn btn-sm btn-success">
                                            <i class="fa fa-cloud-upload align-top bigger-125 ace-icon"></i>
                                            提交
                                        </a>
                                        <a href="javascript:resetInsertForm();" class="btn btn-sm btn-danger">
                                            <i class="fa fa-undo align-top bigger-125 ace-ic"></i>
                                           重置
                                        </a>
                                    </div>
                                </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- /.col -->
            </div>
            <!-- /.row -->

        </div>
        <!-- /.page-content -->
        
        <!-- /.page-content -->
        <div id="modal-hasdata" class="modal fade">
                        <div class="modal-dialog">
                            <div class="modal-content">
                            	<div class="modal-header no-padding">
                                	<div class="table-header">
													<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
														<span class="white">&times;</span>
													</button>
													     <i class="fa fa-hand-o-down bigger-125 ace-icon" style="margin-right: 5px;"></i>
												                 修改体验金券
												</div>
                         
                                </div>
                                <div class="modal-body">
                                    <form id="insertForm" class="form-horizontal" action="/opt-money-coupon/insert.do" role="form" method="post">
                                    	<input type="hidden" id="sendAdminid" name="sendAdminid" value="2016070518019111845"/>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right green"
                                                   for="form-field-1">用户手机</label>

                                            <div class="col-sm-6">
                                            	<div class="input-group input-group-sm">
                                                	<input type="text" id="userMobile-edit" name="userMobile" class="form-control"
                                   						value="" placeholder="用户手机">
                                   					<a href="javascript:searchUser();" class="input-group-addon">
                                            			<i class="fa fa-search align-top bigger-110 ace-icon"></i>
                                            		</a>
                                            	</div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right green"
                                                   for="form-field-3">用户编号</label>

                                            <div class="col-sm-6">
                                                <input type="text" id="userId-edit" name="userId" class="form-control"
                                   					value="" placeholder="用户编号" readonly="true">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right green"
                                                   for="form-field-3">用户姓名</label>

                                            <div class="col-sm-6">
                                                <input type="text" id="userName-edit" name="userName" class="form-control"
                                   					value="测试" placeholder="用户姓名" readonly="true">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right green"
                                                   for="form-field-2">金额</label>

                                            <div class="col-sm-6">
                                                <input type="text" id="amount-edit" name="amount" class="form-control"
                                   					value="" placeholder="金额">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right green"
                                                   for="form-field-3">年利率(样例：0.06)</label>

                                            <div class="col-sm-6">
                                                <input type="text" id="yearRate-edit" name="yearRate" class="form-control"
                                   					value="0.06" placeholder="年利率">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right green"
                                                   for="form-field-4">赠送天数</label>

                                            <div class="col-sm-6">
                                                <input type="text" id="dayCount-edit" name="dayCount" class="form-control"
                                   					value="" placeholder="赠送天数">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right green"
                                                   for="form-field-5">有效截止日期</label>

											<div class="col-sm-6">
												<div class="input-group input-group-sm">
 												<input class="form-control date-picker" id="endDate-edit" name="endDate" type="text"
                               						data-date-format="yyyy-mm-dd" style="padding-left: 12px;"/>
        									 	<span class="input-group-addon">
             										<i class="fa fa-calendar bigger-110"></i>
         									 	</span>
												</div>
											</div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right green"
                                                   for="form-field-6">最低投资金额</label>

                                            <div class="col-sm-6">
                                                <input type="text" id="minAmount-edit" name="minAmount"  class="form-control" value="" placeholder="最低投资金额"/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right green"
                                                   for="form-field-7">最少投资天数</label>

                                            <div class="col-sm-6">
                                                <input type="text" id="minDays-edit" name="minDays"  class="form-control" value="" placeholder="最少投资天数"/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right green"
                                                   for="form-field-8">备注</label>

											<div class="col-sm-6">
                                                <input type="text" id="remark-edit" name="remark"  class="form-control" value="" placeholder="备注"/>
                                            </div>
                                        </div>
                                    
                                </div>
                                <div class="modal-footer clearfix">
                                    <div class="center">
                                        <a id="insertbtn" disabled="disabled" class="btn btn-sm btn-success">
                                            <i class="fa fa-cloud-upload align-top bigger-125 ace-icon"></i>
                                            提交
                                        </a>
                                        <a href="javascript:resetEditForm();" class="btn btn-sm btn-danger">
                                            <i class="fa fa-undo align-top bigger-125 ace-ic"></i>
                                           重置
                                        </a>
                                    </div>
                                </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- /.col -->
            </div>
            <!-- /.row -->

        </div>
        <!-- /.page-content -->