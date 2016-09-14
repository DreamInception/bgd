<input id="pageCount" type="hidden" value="${pageCount!""}" />
    <#if resultList??>
      <#list resultList as rl>
	      <tr data-selectrow="unselected" data-rownum="${(rl.applicationId?c)!""}">
                 <td>${(rl.applicationId?c)!""}</td>
                <td>${(rl.userId?c)!""}</td>
                <td>${(rl.deductAmount)!""}</td>
                <td>${(rl.actualAmount)!""}</td>
                <td>${(rl.feeAmount)!""}</td>
 <td>
                <#if rl.enumWithdrawState == 0>
          		待系统审核
          		<#elseif rl.enumWithdrawState == 100>
          		待人审核
          		<#elseif rl.enumWithdrawState == 200>
          		已提交付款
          		<#elseif rl.enumWithdrawState == 300>
          		成功
          		<#elseif rl.enumWithdrawState == -100>
          		资金异常<input id="btn" type="button" class="btn btn-primary" onclick="alertMsg('${(rl.applicationId?c)!""}')" value="异常信息"/>
          	   <#elseif rl.enumWithdrawState == 400>
          		异常已处理

          	   </#if>
                </td>
                <td>${(rl.createTime?string("yyyy-MM-dd HH:mm:ss"))!""}</td>
                
                <td> <#if rl.enumWithdrawState == 100>
          	<input id="btn" type="button" class="btn btn-primary" onclick="fopay('${(rl.applicationId?c)!""}');" value="通过" />
          	</#if>
          	<#if rl.enumWithdrawState == -100>
          	<input id="btn" type="button" class="btn btn-primary" onclick="assetBack('${(rl.applicationId?c)!""}');" value="资金退回" />
          	</#if>
          	</td>
	      </tr>
      </#list>
    </#if>
