<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<c:set var="cart" value="${cartBean.cart}"/>
<div class="heading3">Checkout Summary</div>
<div id="CartView">
  <html:link styleClass="ZLink" page="/viewCart.shtml">Return to Shopping Cart</html:link>
  <div>&nbsp;</div>
  <table border="0" cellpadding="0" cellspacing="1" style="border: 1px solid black; padding: 5px">
    <tr>
      <td style="background-color: #ccc; border-bottom: 1px border black; padding: 3px;">Item ID</td>
      <td style="background-color: #ccc; border-bottom: 1px border black; padding: 3px;">Product ID</td>
      <td style="background-color: #ccc; border-bottom: 1px border black; padding: 3px;">Description</td>
      <td style="background-color: #ccc; border-bottom: 1px border black; padding: 3px;">In Stock?</td>
      <td style="background-color: #ccc; border-bottom: 1px border black; padding: 3px;">Quantity</td>
      <td style="background-color: #ccc; border-bottom: 1px border black; padding: 3px;">List Price</td>
      <td style="background-color: #ccc; border-bottom: 1px border black; padding: 3px;">Total Cost</td>
    </tr>
    <c:forEach var="cartItem" items="${cart.cartItems}">
    <tr>
      <td style="padding: 3px;" align="left"><html:link styleClass="ZLink" paramId="itemId" paramName="cartItem" paramProperty="item.itemId" page="/viewItem.shtml"><c:out value="${cartItem.item.itemId}"/></html:link></td>
      <td style="padding: 3px;"><c:out value="${cartItem.item.productId}"/></td>
      <td style="padding: 3px;">
        <c:out value="${cartItem.item.attribute1}"/>
        <c:out value="${cartItem.item.attribute2}"/>
        <c:out value="${cartItem.item.attribute3}"/>
        <c:out value="${cartItem.item.attribute4}"/>
        <c:out value="${cartItem.item.attribute5}"/>
        <c:out value="${cartItem.item.product.name}"/>
      </td>
      <td style="padding: 3px;"><c:out value="${cartItem.inStock}"/></td>
      <td style="padding: 3px;"><c:out value="${cartItem.quantity}"/></td>
      <td style="padding: 3px;"><fmt:formatNumber value="${cartItem.item.listPrice}" pattern="$#,##0.00"/></td>
      <td style="padding: 3px;"><fmt:formatNumber value="${cartItem.total}" pattern="$#,##0.00"/></td>
    </tr>
    </c:forEach>
  </table>
  <table>
    <tr>
      <td colspan="7">Sub Total: <fmt:formatNumber value="${cart.subTotal}" pattern="$#,##0.00"/></td>
    </tr>
  </table>

  <div style="clear: left;"><html:link styleClass="ZLink" page="/newOrderForm.shtml">Continue&gt;&gt;</html:link></div>
</div>