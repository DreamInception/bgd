     <#if resultList??>
        <#list resultList as result>
           <tr data-selectrow="unselected" data-rownum="${result_index}">
               <td data-name="poolAutoId">${(result.pool_auto_id?c)!""}</td>
               <td data-name="debtName">${(result.debt_name)!""}</td>
               <td data-name="enumDebtType">
               <#switch result.enum_debt_type>
				  <#case 0>
				   债权转让
				    <#break>
               </#switch>
               <td data-name="buyAmount">${(result.buy_amount?c)!""}</td>
               <td data-name="repayDate">${(result.current_amount?c)!""}</td>
               <td>
               <#switch result.sell_user_id>
				  <#case 0>
				   系统持有
				    <#break>
				    <#default>
				  ${(result.sell_user_id?c)!""}
               </#switch>
               </td>
               <td data-name="repayDate">${(result.repay_date?string("yyyy-MM-dd"))!""}</td>
               <td data-name="createTime">${(result.create_time?string("yyyy-MM-dd HH:mm:ss"))!""}</td>
           </tr>
         </#list>
     </#if>
 <input type="hidden" name="pageCount" id="pageCount" value="${page.pageCount}" />
     