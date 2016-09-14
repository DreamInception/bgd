<div id="modal-hasdata" class="modal fade">
                        <div class="modal-dialog">
                            <div class="modal-content">
                            	<div class="modal-header no-padding">
                                	<div class="table-header">
													<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
														<span class="white">&times;</span>
													</button>
													     <i class="fa fa-hand-o-down bigger-125 ace-icon" style="margin-right: 5px;"></i>
												                        修改定期标的
												</div>
                         
                                </div>
                                <div class="modal-body">
                                    <form class="form-horizontal" role="form" id="uactivity_manage_form">
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right green"
                                                   for="form-field-1">标的名称</label>

                                            <div class="col-sm-6">
                                                <input type="text" class="form-control" placeholder="标的名称"
                                                       id="utargetName" name="targetName"/>
                                            </div>
                                            <div class="mark-pos">
                                            *
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right green"
                                                   for="form-field-2">图片</label>

                                            <div class="col-sm-6">
                                                <select id="utargetIcon" name="targetIcon">
						  		                   <option value ="0">请选择</option>
						                        </select>
						                        <img id="upicCode" src=""  alt="图片" />
                                            </div>
                                            <div class="mark-pos">
                                            *
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right green"
                                                   for="form-field-2">加息活动</label>

                                            <div class="col-sm-6">
                                                <select id="uactAutoId" name="uactAutoId">
						  		                   <option value ="0">请选择</option>
						  		                   
						                        </select>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right green"
                                                   for="form-field-3">标的金额</label>

                                            <div class="col-sm-6">
                                                <input type="number" class="form-control" placeholder="标的金额"
                                                       id="utargetAmount" name="targetAmount"/>
                                            </div>
                                            <div class="mark-pos">
                                            *
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right green"
                                                   for="form-field-5">单位递增金额</label>

                                            <div class="col-sm-6">
                                                <input type="number" class="form-control" placeholder="单位递增金额"
                                                       id="uunitAmount" name="unitAmount"/>
                                            </div>
                                            <div class="mark-pos">
                                            *
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right green"
                                                   for="form-field-5">起购金额</label>

                                            <div class="col-sm-6">
                                                <input type="number" class="form-control" placeholder="起购金额"
                                                       id="uminAmount" name="minAmount"/>
                                            </div>
                                            <div class="mark-pos">
                                            *
                                            </div>
                                        </div>
                                         <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right green"
                                                   for="form-field-6">起息日</label>

                                            <div class="col-sm-6">
                                                <input type="text" class="form-control" placeholder="起息日"
                                                       id="ubeginDate" name="beginDate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'});" onclur=''/>
                                            </div>
                                            <div class="mark-pos">
                                            *
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right green"
                                                   for="form-field-7">结息日</label>

                                            <div class="col-sm-6">
                                                <input type="text" class="form-control" placeholder="结息日"
                                                       id="uendDate" name="endDate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'});" onclur=''/>
                                            </div>
                                            <div class="mark-pos">
                                            *
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right green"
                                                   for="form-field-4">基础年利率(%)</label>

                                            <div class="col-sm-6">
                                                <input type="number" class="form-control" placeholder="基础年利率(%)"
                                                       id="uyearRate" name="yearRate"/>
                                            </div>
                                            <div class="mark-pos">
                                            *
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right green"
                                                   for="form-field-5">基础天利率(%)</label>

                                            <div class="col-sm-6">
                                                <input type="number" class="form-control" placeholder="基础天利率(%)"
                                                       id="udayRate" name="dayRate" disabled="disabled"/>
                                            </div>
                                            <div class="mark-pos">
                                            *
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right green"
                                                   for="form-field-1">债权方</label>

                                            <div class="col-sm-6">
                                                <input type="text" class="form-control" placeholder="债权方"
                                                       id="usellerName" name="sellerName"/>
                                            </div>
                                            <div class="mark-pos">
                                            *
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right green"
                                                   for="form-field-5">内容</label>

                                            <div class="col-sm-6">
                                                <textarea  style="width:100%;height:100px;" type="text" class="form-control" placeholder="内容"
                                                       id="udqContent" name="dqContent"/>
                                            </div>
                                            <div class="mark-pos">
                                            *
                                            </div>
                                        </div>
                                         <input type="hidden" class="form-control" placeholder="标的ID" id="utargetId" name="utargetId"/>
                                         <input type="hidden" class="form-control" placeholder="标的状态" id="uenumDqtargetState" name="uenumDqtargetState"/>
                                    </form>
                                </div>
                                <div class="modal-footer clearfix">
                                    <div class="center">
                                        <button type="button" class="btn btn-sm btn-success" id="regular-modify">
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