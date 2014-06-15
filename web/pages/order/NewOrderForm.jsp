<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>

<c:choose>
<c:when test="${accountBean == null || accountBean.authenticated == false}">
<div class="heading3">Sign In</div>
<div id="Order">
<html:form method="POST" action="/signon">
<table>
<c:set var="authError" value="${accountBean.authError}"/>
<c:if test="${not empty authError}">
<tr><td colspan="2"><p><font color="red"><c:out value="${authError}" /></font></p></td></tr>
</c:if>
<tr>
<td class="label">Username</td>
<td><html:text property="username" styleClass="inputtext" style="text-align: right;"/></td>
</tr>
<tr>
<td class="label">Password</td>
<td><html:password property="password" styleClass="inputpassword" style="text-align: right;"/></td>
</tr>
<tr><td height="21" width="182"><input type="submit" name="submit" value="Sign In"/></td></tr>
</table>
</html:form>
</div>
</c:when>

<c:otherwise>
<div id="Order">
  <html:form action="/newOrder.shtml" styleId="orderBean" method="post">
  <div>&nbsp;</div>
  <div class="heading3">Payment Details</div>
  <table>
    <tr>
      <td class="label">Card Type:</td>
      <td>
      <html:select name="orderBean" property="order.cardType">
        <html:options name="orderBean" property="creditCardTypes"/>
      </html:select>
      </td>
    </tr>
    <tr>
      <td class="label">Card Number:</td>
      <td><html:text name="orderBean" property="order.creditCard"/>* Use a fake number!</td>
    </tr>
    <tr>
      <td class="label">Expiry Date (MM/YYYY):</td>
      <td><html:text name="orderBean" property="order.expiryDate"/></td>
    </tr>
  </table>
  <div>&nbsp;</div>
  <div class="heading3">Billing Address</div>
  <table>
    <tr>
      <td class="label">First name:</td>
      <td><html:text name="orderBean" property="order.billToFirstName"/></td>
    </tr>
    <tr>
      <td class="label">Last name:</td>
      <td><html:text name="orderBean" property="order.billToLastName"/></td>
    </tr>
    <tr>
      <td class="label">Address 1:</td>
      <td><html:text size="40" name="orderBean" property="order.billAddress1"/></td>
    </tr>
    <tr>
      <td class="label">Address 2:</td>
      <td><html:text size="40" name="orderBean" property="order.billAddress2"/></td>
    </tr>
    <tr>
      <td class="label">City: </td>
      <td><html:text name="orderBean" property="order.billCity"/></td>
    </tr>
    <tr>
      <td class="label">State:</td>
      <td><html:text size="4" name="orderBean" property="order.billState"/></td>
    </tr>
    <tr>
      <td class="label">Zip:</td>
      <td><html:text size="10" name="orderBean" property="order.billZip"/></td>
    </tr>
    <tr>
      <td class="label">Country:</td>
      <td><html:text size="15" name="orderBean" property="order.billCountry"/></td>
    </tr>
    <tr>
      <td colspan=2><html:checkbox name="orderBean" property="shippingAddressRequired"/> Ship to different address...</td>
    </tr>
  </table>

    <input type="submit" name="submit" value="Continue">

  </html:form>
</div>
</c:otherwise>
</c:choose>
