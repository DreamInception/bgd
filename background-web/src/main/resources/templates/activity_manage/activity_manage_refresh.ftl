     <#if resultList??>
        <#list resultList as result>
           <tr data-selectrow="unselected" data-rownum="${result_index}">
               <td data-name="actAutoId">${result.act_auto_id}</td>
               <td data-name="actName">${(result.act_name)!""}</td>
               <td data-name="appendLable">${(result.append_lable)!""}</td>
               <td data-name="appendYearRate">${(result.append_year_rate?c)!""}</td>
               <td data-name="appendDayRate">${(result.append_day_rate?c)!""}</td>
               <td data-name="appendDayCount">${(result.append_day_count?c)!""}</td>
               <td data-name="beginDate">${(result.begin_date?string("yyyy-MM-dd"))!""}</td>
               <td data-name="endDate">${(result.end_date?string("yyyy-MM-dd"))!""}</td>
               <td data-name="isOnsale">${result.is_onsale?string("是","否")}</td>
               <td data-name="onSale">
               <#if result.is_onsale == true>
                  <a id="onSaleBtn" href="javascript:;" onclick="call_confirm_wizard(0,'${result.act_auto_id}')">下架</a>
                             
               <#else>
                   <a id="onSaleBtn" href="javascript:;" onclick="call_confirm_wizard(1,'${result.act_auto_id}')">上架</a>
               </#if>                                                                                  
               </td>
           </tr>
         </#list>
     </#if>     
 <input type="hidden" name="pageCount" id="pageCount" value="${(page.pageCount)!""}" />
     