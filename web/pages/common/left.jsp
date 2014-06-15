<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>

<c:choose>

<c:when test="${accountBean == null || accountBean.authenticated == false}">
<html:form method="POST" action="/signon">
<table width="182" cellpadding="0" cellspacing="0">
<tr><td style="border-bottom: 1px solid black; background: url('images/loginbkg.gif'); padding-right: 5px" align="right">
<c:set var="authError" value="${accountBean.authError}"/>
<c:if test="${not empty authError}">
<p><font color="red"><c:out value="${authError}" /></font></p>
</c:if>
Username<br/>
<html:text property="username" styleClass="inputtext" style="text-align: right;"/><br/>
Password<br/>
<html:password property="password" styleClass="inputpassword" style="text-align: right;"/><br/>
&nbsp;
</td></tr>
<tr><td height="21" width="182"><html:image property="" src="images/signinbutton.gif" /></td></tr>
</table>
</html:form>
<table width="182" cellpadding="0" cellspacing="0">
<tr><td height="21" width="182"><html:link action="/newAccountForm"><img src="images/registernewbutton.gif" height="21" width="182" border="0"/></html:link></td></tr>  
</table>
</c:when>

<c:otherwise>
<table width="182" height="21" cellpadding="0" cellspacing="0">
<tr><td style="height: 21px; border-bottom: 1px solid black; background: url('images/loginbkg.gif'); padding-right: 5px" align="right">
Welcome <c:out value="${accountBean.account.firstName}"/>
</td></tr>
<tr><td height="21" width="182"><html:link action="/signoff"><img src="images/signoutbutton.gif" height="21" width="182" border="0"/></html:link></td></tr>
</table>
</c:otherwise>

</c:choose>

<table width="182" cellpadding="0" cellspacing="0">
<tr><td height="21" width="182" class="LeftContent" style="text-align: right; padding-right: 5px; font-weight: bold">
<a href="." class="Normal">Home</a><br/>
<c:forEach items="${menuHelper.categoryList}" var="menuItem">
<a class="Normal" href="viewCategory.shtml?categoryId=<c:out value="${menuItem.categoryId}"/>"><c:out value="${menuItem.name}"/></a><br/>
</c:forEach>
</td></tr>
<tr><td height="13" width="182"><img src="images/leftnavsep.gif" height="13" width="182" border="0"/></td></tr>
</table>