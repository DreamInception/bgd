<div id="modal-nodata2" class="modal fade">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header md-head">
                                    修改债权
                                </div>
                                <div class="modal-body">
                                    <form class="form-horizontal" role="form" id="target_manage_form">
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right green"
                                                   for="form-field-1">债权类型</label>
                                            <div class="col-sm-6">
                                                <select name="enumDebtType" id="uenumDebtType">
						  		                   <option value ="0">债权转让</option>
						                        </select>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right green"
                                                   for="form-field-2">债权名称</label>

                                            <div class="col-sm-6">
                                                <input type="text" class="form-control" placeholder="债权名称"
                                                       id="udebtName" name="debtName"/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right green"
                                                   for="form-field-3">债权金额</label>

                                            <div class="col-sm-6">
                                                <input type="number" class="form-control" placeholder="债权金额"
                                                       id="udebtAmount" name="debtAmount"/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right green"
                                                   for="form-field-6">还款日期</label>

                                            <div class="col-sm-6">
                                                <input type="text" class="form-control" placeholder="还款日期"
                                                       id="urepayDate" name="repayDate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'});" onclur=''/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right green"
                                                   for="form-field-4">优先级</label>

                                            <div class="col-sm-6">
                                                <input type="number" class="form-control" placeholder="优先级"
                                                       id="udebtLevel" name="debtLevel"/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right green"
                                                   for="form-field-5">债权来源</label>

                                            <div class="col-sm-6">
                                                <textarea  type="text" class="form-control" placeholder="债权来源"
                                                       id="udebtFrom" name="debtFrom"/>
                                            </div>
                                        </div>
                                        <input type="hidden" class="form-control" id="udebtId" name="udebtId"/>
                                    </form>
                                </div>
                                <div class="modal-footer clearfix">
                                    <div class="center">
                                        <button type="button" class="btn btn-sm btn-success" id="hq-debt-modify">
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