<div id="shelve-modal-nodata" class="modal fade">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header md-head">
                                    添加上架时间
                                </div>
                                <div class="modal-body">
                                    <form class="form-horizontal" role="form" id="activity_manage_form"> 
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right green"
                                                   for="form-field-7">上架时间</label>

                                            <div class="col-sm-6">
                                                <input type="text" class="form-control" placeholder="上架时间"
                                                       id="saleTime" name="saleTime" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'});" onclur=''/>
                                            </div>
                                            <div class="mark-pos">
                                            *
                                            </div>
                                        </div>
                                        <input type="hidden" class="form-control" placeholder="标的ID" id="shelveTargetId" name="shelveTargetId"/>
                                    </form>
                                </div>
                                <div class="modal-footer clearfix">
                                    <div class="center">
                                        <button type="button" class="btn btn-sm btn-success" id="regular-shelve-submit">
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