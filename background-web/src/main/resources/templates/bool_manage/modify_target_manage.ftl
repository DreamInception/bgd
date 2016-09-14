<div id="modal-hasdata" class="modal fade">
                        <div class="modal-dialog">
                            <div class="modal-content">
                               <div class="modal-header no-padding">
                                	<div class="table-header">
													<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
														<span class="white">&times;</span>
													</button>
													     <i class="fa fa-hand-o-down bigger-125 ace-icon" style="margin-right: 5px;"></i>
													           修改标的
												</div>
                         
                                </div>
                                <div class="modal-body">
                                    <form class="form-horizontal" role="form" id="target_manage_form">
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right green"
                                                   for="form-field-1">标的名称</label>

                                            <div class="col-sm-6">
                                                <input type="text" class="form-control" placeholder="标的名称"
                                                       id="utargetName" name="utargetName"/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right green"
                                                   for="form-field-2">加息活动</label>&nbsp;&nbsp;

                                            
                                                <select id="uactAutoId" name="uactAutoId"  data-placeholder="请选择">
						  		                   <option value ="0">请选择</option>
						                        </select>
                                            
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right green"
                                                   for="form-field-2">标的金额</label>

                                            <div class="col-sm-6">
                                                <input type="number" class="form-control" placeholder="标的金额"
                                                       id="utargetAmount" name="utargetAmount"/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right green"
                                                   for="form-field-4">基础年利率(%)</label>

                                            <div class="col-sm-6">
                                                <input type="number" class="form-control" placeholder="基础年利率(%)"
                                                       id="utargetYearRate" name="utargetYearRate"/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right green"
                                                   for="form-field-5">基础天利率(%)</label>

                                            <div class="col-sm-6">
                                                <input type="number" class="form-control" placeholder="基础天利率(%)"
                                                       id="utargetDayRate" name="utargetDayRate" disabled="disabled"/>
                                            </div>
                                        </div>
                                        <input type="hidden" class="form-control" placeholder="标的ID" id="utargetId" name="utargetId"/>                     
                                    </form>
                                </div>
                                <div class="modal-footer clearfix">
                                    <div class="center">
                                        <button type="button" class="btn btn-sm btn-success" id="target-submit">
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