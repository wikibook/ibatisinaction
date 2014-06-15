<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<table border="0" cellpadding="0" cellspacing="0" width="100%">
  <tr>
    <td class="Header" width="50%"><html:link styleClass="Normal" page="/index.shtml"><img src="images/logo-topbar.gif" /></html:link></td>
    <td class="TopRightMenu" width="50%" align="right" valign="top">

      <html:link styleClass="Normal" page="/viewCart.shtml">Cart</html:link>
      
      <c:if test="${accountBean != null && accountBean.authenticated == true}">
          <!-- <img align="middle" src="images/separator.gif"/> -->|
          <html:link styleClass="Normal" page="/signoff.shtml">Sign Out</html:link>
          <!-- <img align="middle" src="images/separator.gif"/> -->|
          <html:link styleClass="Normal" page="/editAccountForm.shtml">My Account</html:link>
      </c:if>

      <!-- <img align="middle" src="images/separator.gif"/> -->|
      
      <a class="Normal" target="_blank" href="help.html">?</a>
    </td>
  </tr>
</table>