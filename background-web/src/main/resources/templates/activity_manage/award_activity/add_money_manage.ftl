	<div class="widget-box col-sm-6 widget-color-blue collapsed" id="widget-box-tyj">
   					<div class="widget-header">
   						<h5 class="widget-title bigger lighter">
										<i class="ace-icon fa fa-table"></i>
											体验金列表
							</h5>
   						<div class="widget-toolbar">
   							<a data-action="reload" href="#"><i class="ace-icon fa fa-refresh"></i></a>
   							<a data-action="fullscreen" class="orange2" href="#"><i class="ace-icon fa fa-expand"></i></a>
   							<a data-action="collapse" href="#"><i class="ace-icon fa fa-chevron-up"></i></a>
   							<a data-action="close" href="#"><i class="ace-icon fa fa-times"></i></a>
						</div>
   					</div>
            		<div class="widget-body">
            			<div class="widget-main no-padding">
            			<form class="form-horizontal" style="margin-top:12px;" role="form" id="activity_manage_form">
            			 <input type="hidden" name="mactId" id="mactId" value="" />
            			                <div class="form-group pos-rel">
                                            <label class="col-sm-3 control-label no-padding-right green"
                                                   for="add-year-rate">体验金金额</label>
                                            <div class="col-sm-6" style="padding-left: 12px;">
                                                 <input type="text" class="form-control" placeholder="体验金金额"
                                                       id="act-amount" name="act-amount"/>
                                            </div>
                                            <div class="mark-pos" style="right: 170px;">
                                            *
                                            </div>
                                        </div>
                                        <div class="form-group pos-rel">
                                            <label class="col-sm-3 control-label no-padding-right green"
                                                   for="add-year-rate">加息年利率</label>
                                            <div class="col-sm-6" style="padding-left: 12px;">
                                                 <input type="text" class="form-control" placeholder="加息年利率"
                                                       id="add-year-rate" name="add-year-rate"/>
                                            </div>
                                            <div class="mark-pos" style="right: 170px;">
                                            *
                                            </div>
                                        </div>
                                        <div class="form-group pos-rel">
                                            <label class="col-sm-3 control-label no-padding-right green"
                                                   for="add-day-rate">加息天利率</label>
   											<div class="col-sm-6" style="padding-left: 12px;">
                                                  <input type="text" class="form-control" placeholder="加息天利率"
                                                       id="add-day-rate" name="add-day-rate" disabled="disabled"/>
                                            </div>
                                            <div class="mark-pos" style="right: 170px;">
                                            *
                                            </div>
                                        </div>
                                        <div class="form-group pos-rel">
                                            <label class="col-sm-3 control-label no-padding-right green"
                                                   for="add-rate-days">加息天数</label>

                                            <div class="col-sm-6">
                                                <input type="text" class="form-control" placeholder="加息天数"
                                                       id="add-rate-days" name="add-rate-days"/>
                                            </div>
                                            <div class="mark-pos" style="right: 170px;">
                                            *
                                            </div>
                                        </div>
                                        <div class="form-group pos-rel">
                                            <label class="col-sm-3 control-label no-padding-right green"
                                                   for="during-days">有效天数</label>
                                            <div class="col-sm-6" style="padding-left: 12px;">
                                                 <input type="text" class="form-control" placeholder="有效天数"
                                                       id="during-days" name="during-days"/>
                                            </div>
                                            <div class="mark-pos" style="right: 170px;">
                                            *
                                            </div>
                                        </div>
                                        <div class="form-group pos-rel">
                                            <label class="col-sm-3 control-label no-padding-right green"
                                                   for="min-money">最低投资金额</label>
   											<div class="col-sm-6" style="padding-left: 12px;">
                                                  <input type="text" class="form-control" placeholder="最低投资金额"
                                                       id="min-money" name="min-money"/>
                                            </div>
                                            <div class="mark-pos" style="right: 170px;">
                                            *
                                            </div>
                                        </div>
                                         <div class="form-group pos-rel">
                                            <label class="col-sm-3 control-label no-padding-right green"
                                                   for="min-days">最低投资天数</label>
   											<div class="col-sm-6" style="padding-left: 12px;">
                                                  <input type="text" class="form-control" placeholder="最低投资天数"
                                                       id="min-days" name="min-days"/>
                                            </div>
                                            <div class="mark-pos" style="right: 170px;">
                                            *
                                            </div>
                                        </div>
                                    </form>
                          <table class="table table-bordered table-row-select2" style="display:none;" id="ram_tyj_table">
                            <thead>
                            <tr class="table-row">
                                <th>体验金金额</th>
                                <th>加息年利率</th>
                                <th>加息天利率</th>
                                <th>加息天数</th>
                                <th>有效天数</th>
                                <th>最低投资金额</th>
                                <th>最低投资天数</th>
                                <th>操作</th>
                            </tr>
                            </thead>
                            <tbody>
                             </tbody>
                        </table>
            			</div>
            		</div>
            		<div class="widget-toolbox padding-12 clearfix  table-bottom-btns">
   						<button class="btn btn-sm btn-primary" id="add-tyj-btn">
   						<i class="ace-icon fa fa-plus icon-on-right"></i>
      								添加
      						
   						</button>
                        <div class="pull-right">
   						
                                        <button type="button" class="btn btn-sm btn-danger">
                                            <i class="fa fa-undo align-top bigger-125 ace-ic"></i>
                                            取消
                                        </button>
                         </div>
            			</div>
					</div>
            		 <!-- /.widget-box -->