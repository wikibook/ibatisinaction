<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>

<c:set var="cart" value="${cartBean.cart}"/>
<div class="heading3" align="left">Shopping Cart</div>
<div id="CartView">
<html:link styleClass="ZLink" page="/index.shtml">Return to Home</html:link>
<div style="clear: left;">&nbsp;</div>
<c:choose>
  <c:when test="${cart.numberOfItems == 0}">
    <div id="Errors">Your cart is empty.</div>
  </c:when>
  <c:otherwise>
  <html:form action="/updateCartQuantities.shtml" method="post">
  <table border="0" cellpadding="0" cellspacing="1" style="border: 1px solid black; padding: 5px">
    <tr>
      <td style="background-color: #ccc; border-bottom: 1px border black; padding: 3px;">Item ID</td>
      <td style="background-color: #ccc; border-bottom: 1px border black; padding: 3px;">Product ID</td>
      <td style="background-color: #ccc; border-bottom: 1px border black; padding: 3px;">Description</td>
      <td style="background-color: #ccc; border-bottom: 1px border black; padding: 3px;">In Stock?</td>
      <td style="background-color: #ccc; border-bottom: 1px border black; padding: 3px;">Quantity</td>
      <td style="background-color: #ccc; border-bottom: 1px border black; padding: 3px;">List Price</td>
      <td style="background-color: #ccc; border-bottom: 1px border black; padding: 3px;">Total Cost</td>
      <td style="background-color: #ccc; border-bottom: 1px border black; padding: 3px;">&nbsp;</td>
    </tr>
    <c:forEach var="cartItem" items="${cart.cartItems}">
    <tr>
      <td style="padding: 3px;" align="left"><html:link styleClass="ZLink" paramId="itemId" paramName="cartItem" paramProperty="item.itemId" page="/viewItem.shtml"><c:out value="${cartItem.item.itemId}"/></html:link></td>
      <td><c:out value="${cartItem.item.productId}"/></td>
      <td style="padding: 3px;">
        <c:out value="${cartItem.item.attribute1}"/>
        <c:out value="${cartItem.item.attribute2}"/>
        <c:out value="${cartItem.item.attribute3}"/>
        <c:out value="${cartItem.item.attribute4}"/>
        <c:out value="${cartItem.item.attribute5}"/>
        <c:out value="${cartItem.item.product.name}"/>
      </td>
      <td style="padding: 3px;"><c:choose><c:when test="${cartItem.inStock eq true}">Yes</c:when><c:otherwise>No</c:otherwise></c:choose></td>
      <td style="padding: 3px;"><input type="text" size="3" name="<c:out value="${cartItem.item.itemId}"/>"value="<c:out value="${cartItem.quantity}"/>"/></td>
      <td style="padding: 3px;"><fmt:formatNumber value="${cartItem.item.listPrice}" pattern="$#,##0.00"/></td>
      <td style="padding: 3px;"><fmt:formatNumber value="${cartItem.total}" pattern="$#,##0.00"/></td>
      <td style="padding: 3px;"><html:link styleClass="ZLink" paramId="workingItemId" paramName="cartItem" paramProperty="item.itemId" page="/removeItemFromCart.shtml">Remove</html:link></td>
    </tr>
    </c:forEach>
  </table>
  <table>
    <tr>
      <td colspan="7">Sub Total: <fmt:formatNumber value="${cart.subTotal}" pattern="$#,##0.00"/></td>
      <td>&nbsp;</td>
    </tr>
  </table>
  <input type="submit" name="update" value="Update Cart"/>&nbsp;<html:link styleClass="ZLink" page="/checkout.shtml">Proceed to Checkout &gt;&gt;</html:link>
</html:form>

  <c:if test="${accountBean != null}">
      <c:if test="${accountBean.authenticated == true && accountBean.account.listOption == true}">
          <%@ include file="IncludeMyList.jsp" %>
      </c:if>
  </c:if>
  </c:otherwise>
</c:choose>
</div>