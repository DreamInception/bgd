<input id="pageCount" type="hidden" value="${pageCount!""}" />
    <#if resultList??>
      <#list resultList as rl>
	      <tr data-selectrow="unselected">
	      		<td>${rl.app_version_id}</td>
	      		<td><img src="${rl.pic_url}" height="100" width="50" /></td>
                <td>${rl.app_client}</td>
                <td>${rl.app_version_int}</td>
                <td>${rl.app_version_str}</td>
                <td>
                	<#switch rl.enum_app_version_state>
	                	<#case 0>
	                		录入中<a class="btn btn-primary pull-right" href="javascript:setState(${rl.app_version_id?c},100)" role="button">提交审核</a>
	                	<#break>
	                	<#case 100>
	                		审核中
	                	<#break>
	                	<#case 200>
	                		正式
	                	<#break>
                	</#switch>
                </td>
                <td>${rl.is_must?string("是","否")}</td>
                <td>${rl.remark}</td>
                <td>${rl.create_time}</td>
	      </tr>
      </#list>
    </#if>
