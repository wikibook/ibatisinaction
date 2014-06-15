<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<table border="0" cellpadding="0" cellspacing="0" width="100%">
    <tr>
        <td width="30%">
        <a class="Normal" href="http://ibatis.apache.org">Powered By iBatis</a><br/>
        &copy;2006&nbsp;Apache Software Foundation
        </td>
        <td width="70%">
        <c:if test="${accountBean != null && accountBean.authenticated == true && accountBean.account.bannerOption == true}">
            <c:out value="${accountBean.account.bannerName}" escapeXml="false" />
        </c:if>
        </td>
    </tr>
</table>