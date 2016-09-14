<div class="breadcrumbs" id="breadcrumbs">
            <!-- breadcrumbs goes here -->
            <ul class="breadcrumb">
                <li><i class="fa fa-home home-icon"></i> <a href="">Home</a></li>
                <li><a href="#">债权审核管理</a></li>
                <li class="active"><a href="javascript:;">债权审核列表</a></li>
            </ul>
        </div>

        <div class="page-content">
            <!-- setting box goes here if needed -->
		<div class="page-content-area">
			<div class="page-header">
			  <h1 class="green">债券审核列表 </h1>
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
                  			<span>债权ID</span>
                    			 <input type="text" name="debtId" id="debtId" value="${(params.debtId?c)!""}"}">
                    			<span>债权标题</span>
                    			<input type="text" name="pDebtName" id="pDebtName" value="${(params.debtName)!""}">
                    			<button id="select_debt_audit_list" class="btn btn-sm btn-warning" data-toggle="modal">
                                <i class="fa fa-search align-top bigger-125 ace-icon"></i>
                                	查询
                            </button>
                			</aside>
                        <table class="table table-bordered table-row-select" id="hq_debt_audit_list_table">
                            <thead>
                            <tr>
                                <th>ID</th>
                                <th>债权类型</th>
                                <th>债权名称</th>
                                <th>债权金额</th>
                                <th>还款日期</th>
                                <th>优先级</th>
                                <th>债权来源</th>
                                <th>债权状态</th>
                                <th>创建时间</th>
                                <th>管理</th>
                            </tr>
                            </thead>
                            <tbody>
                       			<#include "hq_debt_audit_refresh.ftl"/>
                             </tbody>
                        </table>
                        <div class="clearfix table-bottom-btns">
							<aside id="laypage_pageNum" class="bond_bottom_pageNum pull-right"></aside>
                        </div>
                    </div>          
            <!-- /.row -->
        </div>
        <!-- /.page-content -->
     <!-- /.widget-main -->
                   </div>
       				 <!-- /.widget-body -->
        			</div>
        		
                  </div>
            <!-- /.col -->
                </div>
            <!-- /.row -->
			</div>
			 <!-- /.page-content-area -->
        </div>
        <!-- /.page-content -->
    


