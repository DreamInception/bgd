		<div class="breadcrumbs" id="breadcrumbs">
            <!-- breadcrumbs goes here -->
            <ul class="breadcrumb">
                <li><i class="fa fa-home home-icon"></i> <a href="#">Home</a></li>
                <li><a href="#"> 用户管理</a></li>
                <li class="active">版本审核</li>
            </ul>
        </div>

        <div class="page-content">
              <!-- setting box goes here if needed -->
<div class="page-content-area">
			<div class="page-header">
			  <h1 class="green">版本审核</h1>
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
                  			
            <div class="row">
                <div class="col-xs-12">
              
                        <table class="table table-bordered table-row-select" id="list_table">
                            <thead>
                            <tr>
                            	<th>ID</th>
                            	<th>图片</th>
						        <th>APP类型</th>
						        <th>版本数值</th>
						        <th>版本编码</th>
						        <th>版本状态</th>
						        <th>是否强制更新</th>
						        <th>版本备注</th>
						        <th>创建时间</th>
                            </tr>
                            </thead>
                            <tbody>
                       			<#include "versioin_review_refresh.ftl"/>
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
												         添加活动图
												</div>
                         
                                </div>
                                 <div class="modal-body">
                                    <form id="insertForm" class="form-horizontal" action="/activity-img/insert.do" role="form" enctype="multipart/form-data" method="post">
                                    	<div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right green"
                                                   for="form-field-2">图片编码</label>

                                            <div class="col-sm-6">
                                                <input type="text" class="form-control" id="picCode" name="picCode"
                                   					value="" placeholder="编码为固定类型的系列参数，如：INDEX">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right green"
                                                   for="form-field-1">上传图片</label>

                                            <div class="col-sm-6">
                                                <input type="file" class="form-control fileUpload" id="file" name="file"
                                   						value="" placeholder="请选择需要上传的图片">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right green"
                                                   for="form-field-2">描述</label>

                                            <div class="col-sm-6">
                                                <input type="text" class="form-control" id="remark" name="remark"
                                   					value="" placeholder="描述">
                                            </div>
                                        </div>

                                    
                                </div>
                                <div class="modal-footer clearfix">
                                    <div class="center">
                                        <a href="javascript:insertForm();" class="btn btn-sm btn-success">
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
        
        <div id="modal-hasdata" class="modal fade">
                        <div class="modal-dialog">
                            <div class="modal-content">
                            	<div class="modal-header no-padding">
                                	<div class="table-header">
													<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
														<span class="white">&times;</span>
													</button>
													     <i class="fa fa-hand-o-down bigger-125 ace-icon" style="margin-right: 5px;"></i>
												             修改活动图
												</div>
                         
                                </div>
                                <div class="modal-body">
                                <#if result??>
                                    <form id="editForm" class="form-horizontal" action="/activity-img/insert.do" role="form" enctype="multipart/form-data" method="post">
                                    <input type="hidden" id="actAutoId" name="cmsAutoId" value="${result.cmsAutoId}">
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right green"
                                                   for="form-field-1">上传图片</label>

                                            <div class="col-sm-6">
                                                <input type="file" class="form-control" id="file-edit" name="file"
                                   						value="" placeholder="请选择需要上传的图片">
                                   						
                                   				<img src="${result.picSrc}" height="100" width="200" />
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right green"
                                                   for="form-field-2">描述</label>

                                            <div class="col-sm-6">
                                                <input type="text" class="form-control" id="remark-edit" name="remark"
                                   					value="${result.remark}" placeholder="描述">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right green"
                                                   for="form-field-3">是否需要登录</label>

                                            <div id="isLoginDiv" class="col-sm-6">
						                            <input id="isLoginA" type="radio" name="isLogin" value="true"/>是
													<input id="isLoginB" type="radio" name="isLogin" value="false" />否 
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right green"
                                                   for="form-field-4">是否本地应用打开</label>

                                            <div class="col-sm-6">
                                                <#if result.isAppOpen==true>
						                            <input type="radio" name="isAppOpen" value="true" checked="checked" />是
													<input type="radio" name="isAppOpen" value="false" />否 
												<#else>
													<input type="radio" name="isAppOpen" value="true" />是
													<input type="radio" name="isAppOpen" value="false" checked="checked" />否 
												</#if>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right green"
                                                   for="form-field-5">外跳链接</label>

                                            <div class="col-sm-6">
                                                <input type="text" class="form-control" id="h5Url-edit" name="h5Url" value="${result.h5Url}" placeholder="外跳链接">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right green"
                                                   for="form-field-6">android关键字</label>

                                            <div class="col-sm-6">
                                                <input type="text" id="androidKey-edit" name="androidKey" class="form-control" value="${result.androidKey}"/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right green"
                                                   for="form-field-7">ios关键字</label>

                                            <div class="col-sm-6">
                                                <input type="text" id="iosKey-edit" name="iosKey" class="form-control datePicker" value="${result.iosKey}"/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3"
                                                   for="form-field-8">排序</label>

                                            <div class="col-sm-6">
                                                <input type="text" id="sort-edit" name="sort" value="${result.sort}"/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3"
                                                   for="form-field-8">是否显示</label>

                                            <div class="col-sm-6">
                                                <#if result.isShow==true>
						                            <input type="radio" name="isShow" value="true" checked="checked" />是
													<input type="radio" name="isShow" value="false" />否 
												<#else>
													<input type="radio" name="isShow" value="true" />是
													<input type="radio" name="isShow" value="false" checked="checked" />否 
												</#if>
                                            </div>
                                        </div>

                                    
                                </div>
                                <div class="modal-footer clearfix">
                                    <div class="center">
                                        <a href="javascript:editForm();" class="btn btn-sm btn-success">
                                            <i class="fa fa-cloud-upload align-top bigger-125 ace-icon"></i>
                                            修改
                                        </a>
                                        <a href="javascript:resetEditForm();" class="btn btn-sm btn-danger">
                                            <i class="fa fa-undo align-top bigger-125 ace-ic"></i>
                                           重置
                                        </a>
                                    </div>
                                </div>
                                </form>
                                </#if>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- /.col -->
            </div>
            <!-- /.row -->

        </div>
        <!-- /.page-content -->
