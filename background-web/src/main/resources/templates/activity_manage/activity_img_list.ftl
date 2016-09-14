		<div class="breadcrumbs" id="breadcrumbs">
            <!-- breadcrumbs goes here -->
            <ul class="breadcrumb">
                <li><i class="fa fa-home home-icon"></i> <a href="#">Home</a></li>
                <li><a href="#"> CMS管理</a></li>
                <li class="active">活动图片管理</li>
            </ul>
        </div>

      <div class="page-content">
            <!-- setting box goes here if needed -->
<div class="page-content-area">
			<div class="page-header">
			  <h1 class="green">活动图片管理</h1>
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
						        <th>描述</th>
						        <th>是否需要登录</th>
						        <th>是否本地应用打开</th>
						        <th>外跳链接</th>
						        <th>安卓关键字</th>
						        <th>IOS关键字</th>
						        <th>排序</th>
						        <th>是否显示</th>
                            </tr>
                            </thead>
                            <tbody>
                       			<#include "activity_img_refresh.ftl"/>
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
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right green"
                                                   for="form-field-3">是否需要登录</label>

                                            <div class="col-sm-6">
                                               <label>
    											<input type="radio" id="isLogin" name="isLogin" class="ace" value="true" checked="checked" />
    											<span class="lbl" style="padding-left:20px;">&nbsp;&nbsp;是</span>
											</label>
											<label>
    											<input type="radio" id="isLogin" name="isLogin" class="ace" value="false" />
    											<span class="lbl" style="padding-left:20px;">&nbsp;&nbsp;否 </span>
											</label>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right green"
                                                   for="form-field-4">是否本地应用打开</label>

                                            <div class="col-sm-6">
											<label>
    											<input type="radio" id="isAppOpen" name="isAppOpen" class="ace" value="true" checked="checked" />
    											<span class="lbl" style="padding-left:20px;">&nbsp;&nbsp;是</span>
											</label>
											<label>
    											<input type="radio" id="isAppOpen" name="isAppOpen" class="ace" value="false" />
    											<span class="lbl" style="padding-left:20px;">&nbsp;&nbsp;否 </span>
											</label>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right green"
                                                   for="form-field-5">外跳链接</label>

                                            <div class="col-sm-6">
                                                <input type="text" class="form-control" id="h5Url" name="h5Url" value="" placeholder="外跳链接">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right green"
                                                   for="form-field-6">android关键字</label>

                                            <div class="col-sm-6">
                                                <input type="text" id="androidKey" name="androidKey" class="form-control" value=""/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right green"
                                                   for="form-field-7">ios关键字</label>

                                            <div class="col-sm-6">
                                                <input type="text" id="iosKey" name="iosKey" class="form-control datePicker" value=""/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right green"
                                                   for="sort">排序</label>

                                            <div class="col-sm-6">
                                                <input type="text" id="sort" name="sort" class="form-control datePicker" value=""/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right green"
                                                   for="form-field-7">是否显示</label>

                                            <div class="col-sm-6">
                                              <label>
    											<input type="radio" id="isShow" name="isShow" class="ace" value="true" checked="checked" />
    											<span class="lbl" style="padding-left:20px;">&nbsp;&nbsp;是</span>
											</label>
											<label>
    											<input type="radio" id="isShow" name="isShow" class="ace" value="false" />
    											<span class="lbl" style="padding-left:20px;">&nbsp;&nbsp;否 </span>
											</label>
                                              
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
                                    <form id="insertForm" class="form-horizontal" action="/activity-img/insert.do" role="form" enctype="multipart/form-data" method="post">
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
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right green"
                                                   for="form-field-3">是否需要登录</label>

                                            <div class="col-sm-6">
                                               <label>
    											<input type="radio" id="isLogin" name="isLogin" class="ace" value="true" checked="checked" />
    											<span class="lbl" style="padding-left:20px;">&nbsp;&nbsp;是</span>
											</label>
											<label>
    											<input type="radio" id="isLogin" name="isLogin" class="ace" value="false" />
    											<span class="lbl" style="padding-left:20px;">&nbsp;&nbsp;否 </span>
											</label>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right green"
                                                   for="form-field-4">是否本地应用打开</label>

                                            <div class="col-sm-6">
											<label>
    											<input type="radio" id="isAppOpen" name="isAppOpen" class="ace" value="true" checked="checked" />
    											<span class="lbl" style="padding-left:20px;">&nbsp;&nbsp;是</span>
											</label>
											<label>
    											<input type="radio" id="isAppOpen" name="isAppOpen" class="ace" value="false" />
    											<span class="lbl" style="padding-left:20px;">&nbsp;&nbsp;否 </span>
											</label>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right green"
                                                   for="form-field-5">外跳链接</label>

                                            <div class="col-sm-6">
                                                <input type="text" class="form-control" id="h5Url" name="h5Url" value="" placeholder="外跳链接">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right green"
                                                   for="form-field-6">android关键字</label>

                                            <div class="col-sm-6">
                                                <input type="text" id="androidKey" name="androidKey" class="form-control" value=""/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right green"
                                                   for="form-field-7">ios关键字</label>

                                            <div class="col-sm-6">
                                                <input type="text" id="iosKey" name="iosKey" class="form-control datePicker" value=""/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right green"
                                                   for="sort">排序</label>

                                            <div class="col-sm-6">
                                                <input type="text" id="sort" name="sort" class="form-control datePicker" value=""/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right green"
                                                   for="form-field-7">是否显示</label>

                                            <div class="col-sm-6">
                                              <label>
    											<input type="radio" id="isShow" name="isShow" class="ace" value="true" checked="checked" />
    											<span class="lbl" style="padding-left:20px;">&nbsp;&nbsp;是</span>
											</label>
											<label>
    											<input type="radio" id="isShow" name="isShow" class="ace" value="false" />
    											<span class="lbl" style="padding-left:20px;">&nbsp;&nbsp;否 </span>
											</label>
                                              
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
