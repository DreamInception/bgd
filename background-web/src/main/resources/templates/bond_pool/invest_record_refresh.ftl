<input id="pageCount" type="hidden" value="${pageCount!""}" />
    <#if resultList??>
      <#list resultList as rl>
	      <tr data-selectrow="unselected">
	      		<td>${rl.buyTime?string("yyyy-MM-dd")}</td>
                <td>${rl.currentAmount}</td>
                <td>${rl.userNum}</td>
	      </tr>
      </#list>
    </#if>
