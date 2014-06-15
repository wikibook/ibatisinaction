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