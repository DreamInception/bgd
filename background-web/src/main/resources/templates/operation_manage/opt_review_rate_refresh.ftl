     <#if resultList??>
        <#list resultList as result>
           <tr data-selectrow="unselected">
               <td data-name="autoId">${result.auto_id}</td>
               <td data-name="userId">${result.user_id?c}</td>
               <td data-name="yearRate">${(result.year_rate?c)!""}</td>
               <td data-name="dayRate">${(result.day_rate?c)!""}</td>
               <td data-name="dayCount">${result.day_count!""}</td>
               <td data-name="endDate">${result.end_date!""}</td>
               <td data-name="minAmount">${result.min_amount!""}</td>
               <td data-name="minDays">${result.min_days}</td>
               <td data-name="enumSendgiftState">
               <#if result.enum_sendgift_state == 0>
               	录入中
               	<#elseif result.enum_sendgift_state == 100>
               	待审核
               	 <a href="javascript:pass(${result.auto_id});" class="btn btn-sm btn-danger">
                                            <i class="fa fa-undo align-top bigger-125 ace-ic"></i>
                                           通过
                                        </a>
                  <a href="javascript:denie(${result.auto_id});" class="btn btn-sm btn-danger">
                                            <i class="fa fa-undo align-top bigger-125 ace-ic"></i>
                                           驳回
                                        </a>
               	<#else>
               	审核通过
               </#if>
               </td>
               <td data-name="sendAdminid">${result.send_adminid?c}</td>
               <td data-name="auditAdminid">${result.audit_adminid?c}</td>
               <td data-name="remark">${result.remark}</td>
               <td data-name="createTime">${result.create_time}</td>
           </tr>
         </#list>
     </#if>     
<input id="pageCount" type="hidden" value="${pageCount!""}" />
     