<div class="modal-dialog">
                            <div class="modal-content">
                                   <div class="modal-header no-padding">
                                	<div class="table-header">
													<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
														<span class="white">&times;</span>
													</button>
													     <i class="fa fa-hand-o-down bigger-125 ace-icon" style="margin-right: 5px;"></i>
													           注册送活动详情
									</div>
                         			</div>
                                <div class="modal-body">
                                	 <h3 class="orange">体验金券列表</h3>
                                	 <table class="table table-bordered table-row-select2" id="reg_tyj_win_tbale">
                            <thead>
                            <tr class="table-row">
                                <th type="hidden" class="col-sm-1">ID</th>
                                <th class="col-sm-1">类型</th>
                            	<th class="col-sm-2">体验金金额</th>
                                <th class="col-sm-1">加息年利率</th>
                                <th class="col-sm-1">加息天利率</th>
                                <th class="col-sm-1">加息天数</th>
                                <th class="col-sm-1	">有效天数</th>
                                <th class="col-sm-2">最低投资金额</th>
                                <th class="col-sm-2">最低投资天数</th>
                            </tr>
                            </thead>
                            <tbody>
                              <#if resultMoneyList??>
        <#list resultMoneyList as result>
           <tr data-selectrow="unselected" data-rownum="${result_index}">
               <td type="hidden" data-name="autoId">${(result.auto_id?c)!""}</td>
               <td data-name="enumActType">注册送</td>
               <td data-name="actAmount">${(result.act_amount?c)!""}</td>
               <td data-name="yearRate">${(result.year_rate?c)!""}</td>
               <td data-name="dayRate">${(result.day_rate?c)!""}</td>
               <td data-name="dayCount">${(result.day_count?c)!""}</td>
               <td data-name="validDayCount">${(result.valid_day_count?c)!""}</td>
               <td data-name="minAmount">${(result.min_amount?c)!""}</td>
               <td data-name="minDays">${(result.min_days?c)!""}</td>
           </tr>
         </#list>
     </#if>  
                             </tbody>
                        </table>
                        <h3 class="orange">加息券列表</h3>
                         <table class="table table-bordered table-row-select2" id="reg_cou_win_table">
                            <thead>
                            <tr class="table-row">
                                <th type="hidden" class="col-sm-1">ID</th>
                                <th class="col-sm-1">类型</th>
                                <th class="col-sm-2">加息年利率</th>
                                <th class="col-sm-2">加息天利率</th>
                                <th class="col-sm-1">加息天数</th>
                                <th class="col-sm-1">有效天数</th>
                                <th class="col-sm-2">最低投资金额</th>
                                <th class="col-sm-2">最低投资天数</th>
                            </tr>
                            </thead>
                            <tbody>
                            <#if resultRateList??>
        <#list resultRateList as result>
           <tr data-selectrow="unselected" data-rownum="${result_index}">
               <td type="hidden" data-name="autoId">${(result.auto_id?c)!""}</td>
               <td data-name="enumActType">注册送</td>
               <td data-name="yearRate">${(result.year_rate?c)!""}</td>
               <td data-name="dayRate">${(result.day_rate?c)!""}</td>
               <td data-name="dayCount">${(result.day_count?c)!""}</td>
               <td data-name="validDayCount">${(result.valid_day_count?c)!""}</td>
               <td data-name="minAmount">${(result.min_amount?c)!""}</td>
               <td data-name="minDays">${(result.min_days?c)!""}</td>
           </tr>
         </#list>
     </#if>  
                             </tbody>
                        </table>
                                </div>
                                <!--modal-content-->
                            </div>
                              <!--modal-dialog-->
                        </div>
                     <!--modal-window-->