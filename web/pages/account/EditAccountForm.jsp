<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>

<div id="Account">

  <html:form method="post" action="/editAccount.shtml">

    <html:hidden name="accountBean" property="validation" value="edit"/>
    <html:hidden name="accountBean" property="username"/>
    <div class="heading3">User Information</div>

    <table>
      <tr>
        <td class="label">User ID:</td><td><c:out value="${accountBean.username}"/></td>
      </tr><tr>
      <td class="label">New password:</td><td><html:password name="accountBean" property="password"/></td>
    </tr><tr>
      <td class="label">Repeat password:</td><td><html:password name="accountBean" property="repeatedPassword"/></td>
    </tr>
    </table>
    
    <%@ include file="IncludeAccountFields.jsp" %>

    <input type="submit" name="submit" value="Save Account Information"/>

  </html:form>
  <div>&nbsp;</div>
  <html:link styleClass="ZLink" page="/listOrders.shtml">My Orders</html:link>
  <div>&nbsp;</div>
</div>