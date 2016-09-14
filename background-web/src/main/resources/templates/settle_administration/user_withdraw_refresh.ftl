     <#if resultList??>
        <#list resultList as u>
           <tr data-selectrow="unselected">
               <td data-name="applicationId" class="hidden">${u.applicationId}</td>
               <td data-name="realName">${(u.realName)!""}</td>
               <td data-name="userMobile">${(u.userMobile)!""}</td>
               <td data-name="amount">${(u.amount)!""}</td>
               <td data-name="enumRedeemState">
               <#if u.enumRedeemState == 0>
          		申请中
          		<#elseif u.enumRedeemState == 100>
          		系统审核通过
          		<#elseif u.enumRedeemState == 200>
          		赎回成功
          		<#elseif u.enumRedeemState == -100>
          		资金异常
          	   </#if>
               </td>
               <td data-name="remark">${(u.remark)!""}</td>
               <td data-name="createTime">${(u.createTime?string("yyyy-MM-dd HH:mm:ss"))!""}</td>
               <td data-name="enumRedeemState">
            <#if u.enumRedeemState == 100>
          		<input id="btn" type="button" class="btn btn-primary" onclick="pass('${(u.applicationId)!""}');" value="通过" />
          	</#if></td>
           </tr>
         </#list>
     </#if>
     
     