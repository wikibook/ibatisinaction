<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>

<c:set var="order" value="${orderBean.order}"/>
<c:set var="itemList" value="${orderBean.order.lineItems}"/>

<div class="heading3">Receipt</div>
<div id="Order">
<html:link styleClass="ZLink" page="/index.shtml">Return to Home</html:link>
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
  <div>&nbsp;</div>
  <table border="0" cellpadding="0" cellspacing="1" style="border: 1px solid black; padding: 5px">
    <tr>
      <td style="background-color: #ccc; border-bottom: 1px border black; padding: 3px;">Item ID</td>
      <td style="background-color: #ccc; border-bottom: 1px border black; padding: 3px;">Description</td>
      <td style="background-color: #ccc; border-bottom: 1px border black; padding: 3px;">Quantity</td>
      <td style="background-color: #ccc; border-bottom: 1px border black; padding: 3px;">Price</td>
      <td style="background-color: #ccc; border-bottom: 1px border black; padding: 3px;">Total Cost</td>
    </tr>
    <c:forEach var="item" items="${itemList}">
      <tr>
        <td style="padding: 3px;" align="left"><html:link styleClass="ZLink" paramId="itemId" paramName="item" paramProperty="itemId" page="/viewItem.shtml"><c:out value="${item.itemId}"/></html:link></td>
        <td style="padding: 3px;">
            <c:out value="${item.item.attribute1}"/>
            <c:out value="${item.item.attribute2}"/>
            <c:out value="${item.item.attribute3}"/>
            <c:out value="${item.item.attribute4}"/>
            <c:out value="${item.item.attribute5}"/>
            <c:out value="${item.item.product.name}"/>
        </td>
        <td style="padding: 3px;"><c:out value="${item.quantity}"/></td>
        <td style="padding: 3px;"><fmt:formatNumber value="${item.unitPrice}" pattern="$#,##0.00"/></td>
        <td style="padding: 3px;"><fmt:formatNumber value="${item.total}" pattern="$#,##0.00"/></td>
      </tr>
    </c:forEach>
  </table>
  <table>
    <tr>
      <td colspan="5">Total: <fmt:formatNumber value="${order.totalPrice}" pattern="$#,##0.00"/></td>
    </tr>
  </table>
  <div>&nbsp;</div>
</div>