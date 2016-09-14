<div id="modal-nodata" class="modal fade">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header no-padding">
                                	<div class="table-header">
													<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
														<span class="white">&times;</span>
													</button>
													     <i class="fa fa-hand-o-down bigger-125 ace-icon" style="margin-right: 5px;"></i>
													           新增活动
												</div>
                         
                                </div>
                                <div class="modal-body">
                                    <form class="form-horizontal" role="form" id="activity_manage_form">
                                        <div class="form-group pos-rel">
                                            <label class="col-sm-3 control-label no-padding-right green"
                                                   for="form-field-1">活动名称</label>

                                            <div class="col-sm-6">
                                                <input type="text" class="form-control" placeholder="活动名称"
                                                       id="actName" name="actName"/>
                                            </div>
                                            <div class="mark-pos">
                                            *
                                            </div>
                                        </div>
                                        <div class="form-group pos-rel">
                                            <label class="col-sm-3 control-label no-padding-right green"
                                                   for="form-field-2">加息标签</label>

                                            <div class="col-sm-6">
                                                <input type="text" class="form-control" placeholder="加息标签"
                                                       id="appendLable" name="appendLable"/>
                                            </div>
                                            <div class="mark-pos">
                                            *
                                            </div>
                                        </div>
                                        <div class="form-group pos-rel">
                                            <label class="col-sm-3 control-label no-padding-right green"
                                                   for="form-field-3">加息年利率(%)</label>

                                            <div class="col-sm-6">
                                                <input type="text" class="form-control" placeholder="加息年利率(%)"
                                                       id="appendYearRate" name="appendYearRate"/>
                                            </div>
                                            <div class="mark-pos">
                                            *
                                            </div>
                                        </div>
                                        <div class="form-group pos-rel">
                                            <label class="col-sm-3 control-label no-padding-right green"
                                                   for="form-field-4">加息天利率(%)</label>

                                            <div class="col-sm-6">
                                                <input type="number" class="form-control" placeholder="加息天利率(%)"
                                                       id="appendDayRate" name="appendDayRate" disabled="disabled"/>
                                            </div>
                                            <div class="mark-pos">
                                            *
                                            </div>
                                        </div>
                                        <div class="form-group pos-rel">
                                            <label class="col-sm-3 control-label no-padding-right green"
                                                   for="form-field-5">加息天数</label>

                                            <div class="col-sm-6">
                                                <input type="text" class="form-control" placeholder="加息天数"
                                                       id="appendDayCount" name="appendDayCount"/>
                                            </div>
                                            <div class="mark-pos">
                                            *
                                            </div>
                                        </div>
                                        <div class="form-group pos-rel">
                                            <label class="col-sm-3 control-label no-padding-right green"
                                                   for="form-field-6">开始日期</label>
                                            <div class="col-sm-6" style="padding-left: 12px;">
                                                <input type="text" class="form-control date-picker" placeholder="开始日期"
                                                       id="beginDate" name="beginDate" data-date-format="yyyy-mm-dd" style="padding-left: 12px;"/>
                                            </div>
                                        </div>
                                        <div class="form-group pos-rel">
                                            <label class="col-sm-3 control-label no-padding-right green"
                                                   for="form-field-7">截止日期</label>
   											<div class="col-sm-6" style="padding-left: 12px;">
                                                <input type="text" class="form-control date-picker" placeholder="截止日期"
                                                       id="endDate" name="endDate" data-date-format="yyyy-mm-dd" style="padding-left: 12px;"/>
                                            </div>
                                        </div>
                                        <div class="form-group ">
                                            <label class="col-sm-3 control-label no-padding-right green"
                                                   for="form-field-8">是否上架</label>

                                            <div class="col-sm-6">
                                            <label>
    											<input type="radio" id="isOnsale" name="isOnsale" class="ace" value="1" />
    											<span class="lbl" style="padding-left:20px;">&nbsp;&nbsp;上架</span>
											</label>
											<label>
    											<input type="radio" id="isOnsale" name="isOnsale" class="ace" value="0" />
    											<span class="lbl" style="padding-left:20px;">&nbsp;&nbsp;不上架</span>
											</label>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                                <div class="modal-footer clearfix">
                                    <div class="center">
                                        <button type="button" class="btn btn-sm btn-success" id="activity-submit">
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