     <#if resultList??>
        <#list resultList as result>
           <tr data-selectrow="unselected" data-rownum="${result_index}">
               <td data-name="debtId">${(result.debt_id?c)!""}</td>
               <td data-name="enumDebtType">${(result.enum_debt_type)!""}</td>
               <td data-name="debtName">${(result.debt_name)!""}</td>
               <td data-name="debtAmount">${(result.debt_amount?c)!""}</td>
               <td data-name="repayDate">${(result.repay_date?string("yyyy-MM-dd"))!""}</td>
               <td data-name="debtLevel">${(result.debt_level?c)!""}</td>
               <td data-name="debtFrom">${(result.debt_from)!""}</td>
               <td>
                <#switch result.enum_debt_state>
				  <#case 100>
				   待审核
				    <#break>
				  <#case 200>
				    已上架
				   <#break>
				  <#case 300>
				    已还款
				   <#break>
				  <#default>
				    录入 
                </#switch>
                </td>
               <td data-name="createTime">${(result.create_time?string("yyyy-MM-dd HH:mm:ss"))!""}</td>
               <td>
               <#switch result.enum_debt_state>
				 <#case 0>
				   <a id="enumDebtStateBtn" href="javascript:;" onclick="enumDebtState('${(result.debt_id?c)!""}')">申请上架</a>
				<#break>
                </#switch>
               </td>
           </tr>
         </#list>
     </#if>
 <input type="hidden" name="pageCount" id="pageCount" value="${page.pageCount}" />
     