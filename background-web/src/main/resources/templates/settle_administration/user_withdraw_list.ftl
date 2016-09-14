		<div class="breadcrumbs" id="breadcrumbs">
            <!-- breadcrumbs goes here -->
            <ul class="breadcrumb">
                <li><i class="fa fa-home home-icon"></i> <a href="#">首页</a></li>
                <li><a href="#">清算管理</a></li>
                <li class="active">用户赎回申请记录</li>
            </ul>
        </div>

        <div class="page-content">
            <!-- setting box goes here if needed -->
	<div class="page-header">
			  <h1 class="green">用户赎回申请记录 </h1>
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
                                <th>用户姓名</th>
                                <th>手机号</th>
                                <th>赎回金额</th>
                                <th>状态</th>
                                <th>注释</th>
                                <th>创建时间</th>
                                <th>操作</th>
                            </tr>
                            </thead>
                            <tbody id="tbody">
                       			<#include "user_withdraw_refresh.ftl"/>
                            </tbody>
                        </table>
                        <div class="clearfix table-bottom-btns">
							<aside id="bond_bottom_pageNum" class="bond_bottom_pageNum pull-right"></aside>
                        </div>
                    </div>

                    
                    </div>
                </div>
                <!-- /.col -->
            </div>
            <!-- /.row -->
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

    


