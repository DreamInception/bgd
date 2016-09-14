<div id="modal-nodata" class="modal fade">
                        <div class="modal-dialog">
                            <div class="modal-content">
                            	<div class="modal-header no-padding">
                                	<div class="table-header">
													<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
														<span class="white">&times;</span>
													</button>
													     <i class="fa fa-hand-o-down bigger-125 ace-icon" style="margin-right: 5px;"></i>
												                              添加债权
												</div>
                         
                                </div>
                                <div class="modal-body">
                                    <form class="form-horizontal" role="form" id="target_manage_form">
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right green"
                                                   for="form-field-1">债权类型</label>
                                            <div class="col-sm-6">
                                              <select id="enumDebtType" name="enumDebtType" class="chosen-select selsize" data-placeholder="请选择">
						                       	 <option value ="0">债权转让</option>
           										 </select>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right green"
                                                   for="form-field-2">债权名称</label>

                                            <div class="col-sm-6">
                                                <input type="text" class="form-control" placeholder="债权名称"
                                                       id="debtName" name="debtName"/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right green"
                                                   for="form-field-3">债权金额</label>

                                            <div class="col-sm-6">
                                                <input type="number" class="form-control" placeholder="债权金额"
                                                       id="debtAmount" name="debtAmount"/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right green"
                                                   for="form-field-6">还款日期</label>

                                            <div class="col-sm-6">
                                            <input type="text" class="form-control date-picker" placeholder="还款日期"
                                                       id="repayDate" name="repayDate" data-date-format="yyyy-mm-dd" style="padding-left: 12px;"/>
                                                
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right green"
                                                   for="form-field-4">优先级</label>

                                            <div class="col-sm-6">
                                                <input type="number" class="form-control" placeholder="优先级"
                                                       id="debtLevel" name="debtLevel"/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right green"
                                                   for="form-field-5">债权来源</label>

                                            <div class="col-sm-6">
                                                <textarea  type="text" class="form-control" placeholder="债权来源"
                                                       id="debtFrom" name="debtFrom"/>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                                <div class="modal-footer clearfix">
                                    <div class="center">
                                        <button type="button" class="btn btn-sm btn-success" id="hq-debt-submit">
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