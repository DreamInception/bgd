<div id="preShelve-modal-nodata" class="modal fade">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header md-head">
                                    添加预上架时间
                                </div>
                                <div class="modal-body">
                                    <form class="form-horizontal" role="form" id="activity_manage_form"> 
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right green"
                                                   for="form-field-7">预上架时间</label>
<!--
                                            <div class="col-sm-6">
                                                       <input type="text" class="form-control date-picker" placeholder="预上架时间"
                                                       id="onsaleTime" name="onsaleTime" data-date-format="yyyy-mm-dd HH:mm:ss" style="padding-left: 12px;"/>
                                            </div>
                                            -->
                                            <div class="col-sm-6">
                                            <div class="input-group">
                  									  <input id="onsaleTime" name="onsaleTime" type="text" class="form-control" placeholder="预上架时间"  data-date-format="YYYY-MM-DD HH:mm:ss"/>
															<span class="input-group-addon">
																<i class="fa fa-clock-o bigger-110"></i>
															</span>
               								 </div>
               								 </div>
                                            <div class="mark-pos">
                                            *
                                            </div>
                                        </div>
                                        <input type="hidden" class="form-control" placeholder="标的ID" id="preShelveTargetId" name="preShelveTargetId"/>
                                    </form>
                                </div>
                                <div class="modal-footer clearfix">
                                    <div class="center">
                                        <button type="button" class="btn btn-sm btn-success" id="regular-pre-shelve-submit">
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