<input id="pageCount" type="hidden" value="${pageCount!""}" />
    <#if resultList??>
      <#list resultList as rl>
	      <tr data-selectrow="unselected" data-rownum="${rl.cmsAutoId}">
	      		<td>${rl.cmsAutoId}</td>
                <td><img src="${rl.picSrc}" height="100" width="200" /></td>
                <td>${rl.remark}</td>
                <td>${rl.isLogin?string("是","否")}</td>
                <td>${rl.isAppOpen?string("是","否")}</td>
                <td>${rl.h5Url!""}</td>
                <td>${rl.androidKey!""}</td>
                <td>${rl.iosKey!""}</td>
                <td>${rl.sort}</td>
                <td>${rl.isShow?string("是","否")}</td>
	      </tr>
      </#list>
    </#if>
