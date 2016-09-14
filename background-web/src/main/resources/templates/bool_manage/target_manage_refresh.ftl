     <#if resultList??>
        <#list resultList as result>
           <tr data-selectrow="unselected" data-rownum="${result_index}">
               <td data-name="targetId">${(result.target_id?c)!""}</td>
               <td data-name="targetName">${(result.target_name)!""}</td>
               <td data-name="targetAmount">${(result.target_amount)!""}</td>
               <td data-name="targetBidAmount">${(result.target_bid_amount?c)!""}</td>
               <td data-name="targetYearRate">${(result.target_year_rate?c)!""}</td>
               <td data-name="targetDayRate">${(result.target_day_rate?c)!""}</td>
               <td data-name="enumTargetState">
               <#if result.enum_target_state == 0>
                                                                                                     编辑中
               <#elseif result.enum_target_state == 100>
                                                                                                    待上架
               <#elseif result.enum_target_state == 200>
                                                                                                   已上架
               <#else>
                                                                                                   满标
               </#if>
               </td>
               <td data-name="onsaleTime">${(result.onsale_time?string("yyyy-MM-dd"))!""}</td>
               <td data-name="createTime">${(result.create_time?string("yyyy-MM-dd HH:mm:ss"))!""}</td>
           </tr>
         </#list>
     </#if>
 <input type="hidden" name="pageCount" id="pageCount" value="${page.pageCount}" />
     