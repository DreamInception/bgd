<div id="modal-state" class="modal fade">
                        <div class="modal-dialog">
                            <div class="modal-content">
                            	<div class="modal-header no-padding">
                                	<div class="table-header">
													<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
														<span class="white">&times;</span>
													</button>
													     <i class="fa fa-hand-o-down bigger-125 ace-icon" style="margin-right: 5px;"></i>
												                     标的列表
												</div>
                         
                                </div>
                                <div class="modal-body">
                                    <form class="form-horizontal" role="form" id="target_manage_form">
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right green"
                                                   for="form-field-1">标的名称</label>

                                            <div class="col-sm-6">
                                                <input type="text" class="form-control" placeholder="标的名称"
                                                       id="stargetName" name="stargetName"/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right green"
                                                   for="form-field-8">标的状态</label>

                                            <div class="col-sm-6" id="radio">
                                            	<label>
                                                        <input type="radio" name="uenumTargetState" value="0" class="ace" id="uenumTargetState"/>
                                                        <span class="lbl" style="padding-left:10px;"> 录入</span>
                                                </label>
                                                <label>
                                                        <input type="radio" name="uenumTargetState" value="100" class="ace" id="uenumTargetState"/>
                                                     	<span class="lbl" style="padding-left:10px;"> 待上架</span>
                                                </label> 
                                                <label>   	                                                                                                         
													<input type="radio" name="uenumTargetState" value="200" class="ace" id="uenumTargetState"/>
                                                    <span class="lbl" style="padding-left:10px;"> 上架</span>
                                                </label>  
                                                 <label>
                                                    <input type="radio" name="uenumTargetState" value="300" class="ace" id="uenumTargetState"/>
                                                    <span class="lbl" style="padding-left:10px;"> 满标</span>
                                                 </label>
                                            </div>
                                        </div>
                                        <input type="hidden" name="stargetId" id="stargetId" value=""> 
                                    </form>
                                </div>
                                <div class="modal-footer clearfix">
                                    <div class="center">
                                        <button type="button" class="btn btn-sm btn-success" id="target-state">
                                            <i class="fa fa-cloud-upload align-top bigger-125 ace-icon"></i>
                                            提交
                                        </button>
                                        <button type="button" class="btn btn-sm btn-danger">
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