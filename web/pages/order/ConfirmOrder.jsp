<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<div class="heading3">Confirmation</div>
Please confirm the information below and then press continue...
<div id="Order">
  <div>&nbsp;</div>
  <div class="heading3">Order: <fmt:formatDate value="${orderBean.order.orderDate}" pattern="yyyy/MM/dd hh:mm:ss"/></div>
  <div>&nbsp;</div>
  <div class="heading3">Billing Address</div>
  <table>
    <tr>
      <td class="label">First name:</td>
      <td><c:out value="${orderBean.order.billToFirstName}"/></td>
    </tr>
    <tr>
      <td class="label">Last name:</td>
      <td><c:out value="${orderBean.order.billToLastName}"/></td>
    </tr>
    <tr>
      <td class="label">Address 1:</td>
      <td><c:out value="${orderBean.order.billAddress1}"/></td>
    </tr>
    <tr>
      <td class="label">Address 2:</td>
      <td><c:out value="${orderBean.order.billAddress2}"/></td>
    </tr>
    <tr>
      <td class="label">City:</td>
      <td><c:out value="${orderBean.order.billCity}"/></td>
    </tr>
    <tr>
      <td class="label">State:</td>
      <td><c:out value="${orderBean.order.billState}"/></td>
    </tr>
    <tr>
      <td class="label">Zip:</td>
      <td><c:out value="${orderBean.order.billZip}"/></td>
    </tr>
    <tr>
      <td class="label">Country:</td>
      <td><c:out value="${orderBean.order.billCountry}"/></td>
    </tr>
  </table>
  <div>&nbsp;</div>
  <div class="heading3">Shipping Address</div>
  <table>
    <tr>
      <td class="label">First name:</td>
      <td><c:out value="${orderBean.order.shipToFirstName}"/></td>
    </tr>
    <tr>
      <td class="label">Last name:</td>
      <td><c:out value="${orderBean.order.shipToLastName}"/></td>
    </tr>
    <tr>
      <td class="label">Address 1:</td>
      <td><c:out value="${orderBean.order.shipAddress1}"/></td>
    </tr>
    <tr>
      <td class="label">Address 2:</td>
      <td><c:out value="${orderBean.order.shipAddress2}"/></td>
    </tr>
    <tr>
      <td class="label">City:</td>
      <td><c:out value="${orderBean.order.shipCity}"/></td>
    </tr>
    <tr>
      <td class="label">State:</td>
      <td><c:out value="${orderBean.order.shipState}"/></td>
    </tr>
    <tr>
      <td class="label">Zip:</td>
      <td><c:out value="${orderBean.order.shipZip}"/></td>
    </tr>
    <tr>
      <td class="label">Country:</td>
      <td><c:out value="${orderBean.order.shipCountry}"/></td>
    </tr>
  </table>
  <html:link styleClass="ZLink" page="/newOrderForm.shtml">&lt;&lt;Back to Address</html:link>&nbsp;<html:link styleClass="ZLink" page="/newOrder.shtml?confirmed=true">Confirm&gt;&gt;</html:link>
</div>