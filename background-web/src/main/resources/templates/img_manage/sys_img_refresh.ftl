<input id="pageCount" type="hidden" value="${pageCount!""}" />
    <#if resultList??>
      <#list resultList as rl>
	      <tr data-selectrow="unselected">
	      		<td>${rl.autoId}</td>
	      		<td>${rl.picCode}</td>
                <td><img src="${rl.picUrl}" height="50" width="50" /></td>
                <td>${rl.remark}</td>
	      </tr>
      </#list>
    </#if>
