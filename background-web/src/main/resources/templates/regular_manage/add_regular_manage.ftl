<div id="modal-nodata" class="modal fade">
                        <div class="modal-dialog">
                            <div class="modal-content">
                            	<div class="modal-header no-padding">
                                	<div class="table-header">
													<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
														<span class="white">&times;</span>
													</button>
													     <i class="fa fa-hand-o-down bigger-125 ace-icon" style="margin-right: 5px;"></i>
												                            添加定期标的
												</div>
                         
                                </div>
                                <div class="modal-body">
                                    <form class="form-horizontal" role="form" id="activity_manage_form">
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right green"
                                                   for="form-field-1">标的名称</label>

                                            <div class="col-sm-6">
                                                <input type="text" class="form-control" placeholder="标的名称"
                                                       id="targetName" name="targetName"/>
                                            </div>
                                           
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right green"
                                                   for="form-field-2">图片</label>

                                            <div class="col-sm-6">
                                            <select id="targetIcon" name="targetIcon" class="chosen-select selsize" data-placeholder="请选择">
						                       	 <option value ="0">请选择</option>
           								    </select>

                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right green"
                                                   for="form-field-2">加息活动</label>

                                            <div class="col-sm-6">
                                             <select id="actAutoId" name="actAutoId" class="chosen-select selsize" data-placeholder="请选择">
						                       	 <option value ="0">请选择</option>
           								    </select>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right green"
                                                   for="form-field-3">标的金额</label>

                                            <div class="col-sm-6">
                                                <input type="text" class="form-control" placeholder="标的金额"
                                                       id="targetAmount" name="targetAmount"/>
                                            </div>
                                           
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right green"
                                                   for="form-field-5">单位递增金额</label>

                                            <div class="col-sm-6">
                                                <input type="text" class="form-control" placeholder="单位递增金额"
                                                       id="unitAmount" name="unitAmount"/>
                                            </div>
                                           
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right green"
                                                   for="form-field-5">起购金额</label>

                                            <div class="col-sm-6">
                                                <input type="text" class="form-control" placeholder="起购金额"
                                                       id="minAmount" name="minAmount"/>
                                            </div>

                                        </div>
                                         <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right green"
                                                   for="form-field-6">起息日</label>
											<div class="col-sm-6" style="padding-left: 12px;">
                                                <input type="text" class="form-control date-picker" placeholder="起息日"
                                                       id="beginDate" name="beginDate" data-date-format="yyyy-mm-dd" style="padding-left: 12px;"/>
                                            </div>
                                        
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right green"
                                                   for="form-field-7">结息日</label>
											<div class="col-sm-6" style="padding-left: 12px;">
                                                <input type="text" class="form-control date-picker" placeholder="结息日"
                                                       id="endDate" name="endDate" data-date-format="yyyy-mm-dd" style="padding-left: 12px;"/>
                                            </div>
                                        </div>
                                        
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right green"
                                                   for="form-field-4">基础年利率(%)</label>

                                            <div class="col-sm-6">
                                                <input type="text" class="form-control" placeholder="基础年利率(%)"
                                                       id="yearRate" name="yearRate"/>
                                            </div>

                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right green"
                                                   for="form-field-5">基础天利率(%)</label>

                                            <div class="col-sm-6">
                                                <input type="number" class="form-control" placeholder="基础天利率(%)"
                                                       id="dayRate" name="dayRate" disabled="disabled"/>
                                            </div>

                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right green"
                                                   for="form-field-1">债权方</label>

                                            <div class="col-sm-6">
                                                <input type="text" class="form-control" placeholder="债权方"
                                                       id="sellerName" name="sellerName"/>
                                            </div>

                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right green"
                                                   for="form-field-5">内容</label>

                                            <div class="col-sm-6">
                                                <textarea  style="width:100%;height:100px;" type="text" class="form-control" placeholder="内容"
                                                       id="dqContent" name="dqContent"/>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                                <div class="modal-footer clearfix">
                                    <div class="center">
                                        <button type="button" class="btn btn-sm btn-success" id="regular-submit">
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