<#if resultList?size != 0>
 <#list resultList as result>
           <tr data-selectrow="unselected" data-rownum="${result_index}">
               <td data-name="targetId">${result.target_id?c}</td>
               <td data-name="targetName">${(result.target_name)!""}</td>
               <td data-name="targetIcon"><img src="${(result.target_icon)!""}"  alt="图片" /></td>
               <td data-name="targetAmount">${(result.target_amount?c)!""}</td>
               <td data-name="buyAmount">${(result.buy_amount?c)!""}</td>
               <td data-name="unitAmount">${(result.unit_amount?c)!""}</td>
               <td data-name="minAmount">${(result.min_amount?c)!""}</td>
               <td data-name="beginDate">${(result.begin_date?string("yyyy-MM-dd"))!""}</td>
               <td data-name="endDate">${(result.end_date?string("yyyy-MM-dd"))!""}</td>
               <td data-name="yearRate">${(result.year_rate?c)!""}</td>
               <td data-name="dayRate">${(result.day_rate?c)!""}</td>
               <td data-name="onsaleTime">${(result.onsale_time?string("yyyy-MM-dd HH:mm:ss"))!""}</td>
               <td data-name="fullsaleTime">${(result.fullsale_time?string("yyyy-MM-dd HH:mm:ss"))!""}</td>
               <td data-name="enumDqtargetState">
               <#switch result.enum_dqtarget_state>
				  <#case 100>
				    待审核
				  <#break>
				  <#case 200>
				   待上架
				  <#break>
				  <#case 300>
				  预上架
				  <#break>
				  <#case 400>
				  已上架
				  <#break>
				  <#case 500>
				  满标待审
				  <#break>
				  <#case 600>
				  生息中
				  <#break>
				  <#case 700>
				  已结息
				  <#break>
				  <#default>
				  录入中
               </#switch>
               </td>
               <td data-name="createTime">${(result.create_time?string("yyyy-MM-dd HH:mm:ss"))!""}</td>
              <td>
               <#switch result.enum_dqtarget_state>
				 <#case 0>
				   <a id="enumDqtargetStateBtn" href="javascript:;" onclick="enumDqtargetState('${result.target_id?c}')">提交审核</a>
				<#break>
                </#switch>
                <a id="" href="javascript:;" onclick="fullScale('${result.target_id?c}')">满标</a>
               </td>
           </tr>
         </#list>
</#if>
<input type="hidden" name="pageCount" id="pageCount" value="${page.pageCount}" />  