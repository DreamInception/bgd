<input id="pageCount" type="hidden" value="${pageCount}" />
    <#if resultList??>
      <#list resultList as rl>
	      <tr data-selectrow="unselected">
	      		<td>${rl.targetName!""}</td>
                <td>${rl.userMobile}&nbsp;&nbsp;${rl.userName}</td>
                <td>${rl.buyAmount}</td>
                <td>${rl.currentAmount}</td>
                <td>${rl.yearRate}</td>
                <td>${rl.nextAppendDate}</td>
                <td>${rl.nextPayDate}</td>
                <td>${rl.buyTime}</td>
	      </tr>
      </#list>
    </#if>
