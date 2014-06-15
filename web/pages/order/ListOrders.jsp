<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<div class="heading3">My Orders</div>
<div>&nbsp;</div>
<div id="Order">
<table border="0" cellpadding="0" cellspacing="1" style="border: 1px solid black; padding: 5px">
  <tr>
  <td style="background-color: #ccc; border-bottom: 1px border black; padding: 3px;">Order ID</td>
  <td style="background-color: #ccc; border-bottom: 1px border black; padding: 3px;">Date</td>
  <td style="background-color: #ccc; border-bottom: 1px border black; padding: 3px;">Total Price</td>
  </tr>

  <c:forEach var="order" items="${orderBean.orderList}">
    <tr>
      <td><html:link styleClass="ZLink" paramId="orderId" paramName="order" paramProperty="orderId" page="/viewOrder.shtml">
        <c:out value="${order.orderId}" /></html:link></td>
      <td><fmt:formatDate value="${order.orderDate}" pattern="yyyy/MM/dd hh:mm:ss"/></td>
      <td><fmt:formatNumber value="${order.totalPrice}" pattern="$#,##0.00"/></td>
    </tr>
  </c:forEach>
</table>

<c:if test="${orderBean.orderListFirstPage != true}">
  <a class="ZLink" href="switchOrderPage.shtml?pageDirection=previous">&lt;&lt; Previous</a>
</c:if>
<c:if test="${orderBean.orderListLastPage != true}" >
  <a class="ZLink" href="switchOrderPage.shtml?pageDirection=next">Next &gt;&gt;</a>
</c:if>
</div>
<div>&nbsp;</div>