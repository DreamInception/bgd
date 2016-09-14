<div class="breadcrumbs" id="breadcrumbs">
            <!-- breadcrumbs goes here -->
            <ul class="breadcrumb">
                <li><i class="fa fa-home home-icon"></i> <a href="">Home</a></li>
                <li><a href="#">债权池管理</a></li>
                <li class="active">债权池列表</li>
            </ul>
        </div>
        <div class="page-content">
            <!-- setting box goes here if needed -->
          <div class="page-content-area">
			<div class="page-header">
			  <h1 class="green">债券池列表 </h1>
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
                			<ul class="table-top-content" id="dr_nav_tabs">
                    			<li>合计债权池数量：${resultMap.a!"0"}  &nbsp;&nbsp;合计债权数量：${resultMap.b!"0"}&nbsp;&nbsp;</li>
                    			<li>合计债权金额：${resultMap.c!"0"}  &nbsp;&nbsp;合计持有金额：${resultMap.d!"0"}&nbsp;&nbsp;</li>
                    			<li>合计转让用户：${resultMap.e!"0"}  &nbsp;&nbsp;合计系统转让用户：${resultMap.f!"0"}&nbsp;&nbsp;</li>
                			</ul>
                			<div>
                  				<span>开始时间</span>
                    			<input type="text" name="startCreateTime" id="startCreateTime" value="${(params.startCreateTime)!""}"}" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'});" onclur=''>
                    			<span>结束时间</span>
                    			<input type="text" name="endCreateTime" id="endCreateTime" value="${(params.endCreateTime)!""}"}" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'});" onclur=''>
                    			<button id="select_hq_debt_pool_list" class="btn btn-sm btn-warning" data-toggle="modal">
                                <i class="fa fa-search align-top bigger-125 ace-icon"></i>
                                	查询
                            	</button>
                            </div>
                			</aside>
      
            
               
                        <table class="table table-bordered table-row-select" id="hq_debt_pool_list_table">
                            <thead>
                            <tr>
                                <th>债权池编号</th>
                                <th>债权名称</th>
                                <th>债权类型</th>
                                <th>债权金额</th>
                                <th>持有金额</th>
                                <th>转让用户</th>
                                <th>还款日期</th>
                                <th>创建时间</th>
                            </tr>
                            </thead>
                            <tbody>
                       			<#include "hq_debt_pool_refresh.ftl"/>
                             </tbody>
                        </table>
                        <div class="clearfix table-bottom-btns">                       
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