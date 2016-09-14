<div class="breadcrumbs" id="breadcrumbs">
            <!-- breadcrumbs goes here -->
            <ul class="breadcrumb">
                <li><i class="fa fa-home home-icon"></i> <a href="">Home</a></li>
                <li><a href="#">活动管理</a></li>
                <li class="active">邀请活动列表</li>
            </ul>
</div>
<div class="page-content">
<!-- setting box goes here if needed -->
		<div class="page-content-area">
			<div class="page-header">
			  <h1 class="green">邀请活动列表</h1>
			  <button id="refreshBtn" class="btn btn-sm btn-danger refreshBtn" style="margin-top: 5px;" onclick="reload()">
                                <i class="fa fa-refresh align-top bigger-125 ace-icon white"></i>
                                刷新
              </button>
			</div>
			
            <div class="row">
                <div class="col-sm-6 widget-container-col">
                	<div class="widget-box widget-color-blue">
                	<div class="widget-header">
                				<h5 class="widget-title bigger lighter">
										<i class="ace-icon fa fa-list-alt"></i>
											活动列表
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
                    			<button id="select_reg_activity_list" class="btn btn-sm btn-warning" data-toggle="modal">
                                <i class="fa fa-search align-top bigger-125 ace-icon"></i>
                                	查询
                            </button>
                			</aside>
                        <table class="table table-bordered table-row-select" id="act_reg_gift_manage_list_table">
                            <thead>
                            <tr>
                                <th>ID</th>
                                <th>活动名称</th>
                                <th>开始日期</th>
                                <th>截止日期</th>
                                <th>体验金券数</th>
                                <th>加息券数</th>
                                <th>是否上架</th>
                            </tr>
                            </thead>
                            <tbody>
                       			<#include "award_activity_manage_refresh.ftl"/>
                             </tbody>
                        </table>
                        <div class="clearfix table-bottom-btns">
                            <button id="newBtn" class="btn btn-sm btn-success" data-toggle="modal"
                                    data-target="#modal-nodata">
                                <i class="fa fa-pencil align-top bigger-125 ace-icon"></i>
                                新增
                            </button>
                            <button id="checkBtn" class="btn btn-sm btn-inverse" data-toggle="modal"
                                    data-target="#awardCheckModal">
                                <i class="fa fa-pencil-square-o align-top bigger-125 ace-icon"></i>
                               查看卡券                 
                            </button>
                             <button id="addTyjBtn" class="btn btn-sm btn-primary" data-toggle="modal"
                                    data-target="#couponData">
                                <i class="fa fa-pencil-square-o align-top bigger-125 ace-icon"></i>
                               添加体验金      
                            </button>
                            <button id="addCouponBtn" class="btn btn-sm btn-purple" data-toggle="modal"
                                    data-target="#couponData">
                                <i class="fa fa-pencil-square-o align-top bigger-125 ace-icon"></i>
                                添加加息券       
                            </button>
                            <button id="awardOnsaleBtn" class="btn btn-sm btn-danger">
                                <i class="fa fa-trash-o align-top bigger-125 ace-icon">
                                </i>
                                上/下架
                            </button>
							<aside id="laypage_pageNum" class="bond_bottom_pageNum pull-right"></aside>
                        </div>
                    </div>
                       <!-- /.widget-main -->
                   </div>
       				 <!-- /.widget-body -->
        			</div>
        			<!-- /.widget-box -->
                     <#include "add_award_activity_manage.ftl"/>
		   
                  </div>
            <!-- /.col -->
              	<!-- 体验金列表  -->
            <#include "../award_activity/add_money_manage.ftl"/>
            	   <!-- 加息券列表  -->
            <#include "../award_activity/add_rate_manage.ftl"/> 
			  		
                </div>
            <!-- /.row -->
      

            		
            
			</div>
			 <!-- /.page-content-area -->
        </div>
        <!-- /.page-content -->
           <#include "award_select_activity_table.ftl"> 