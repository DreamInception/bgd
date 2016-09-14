     <#if resultList??>
        <#list resultList as result>
           <tr data-selectrow="unselected" data-rownum="${result_index}">
               <td data-name="actAutoId">${(result.actAutoId?c)!""}</td>
               <td data-name="actName">${(result.actName)!""}</td>
               <td data-name="beginDate">${(result.beginDate?string("yyyy-MM-dd"))!""}</td>
               <td data-name="endDate">${(result.endDate?string("yyyy-MM-dd"))!""}</td>
               <td data-name="countAmci">${(result.countAmci?c)!""}</td>
               <td data-name="countArci">${(result.countArci?c)!""}</td>
               <td data-name="isOnsale">${result.isOnsale?string("是","否")}</td>
           </tr>
         </#list>
     </#if>     
 <input type="hidden" name="pageCount" id="pageCount" value="${(page.pageCount)!""}" />
     