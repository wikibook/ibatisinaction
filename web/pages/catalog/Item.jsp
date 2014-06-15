<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>

<c:set var="product" value="${catalogBean.product}"/>
<c:set var="item" value="${catalogBean.item}"/>
<div class="PageHeader" style="background-color: <c:out value="${categoryColor}"/>;" align="left"><c:out value="${product.name}"/>:<c:out value="${item.name}"/></div>
  <table cellpadding="0" cellspacing="0" border="0" width="100%">
    <!-- <tr><td colspan="2" class="PageHeader" style="background-color: <c:out value="${category.color}"/>;" align="left"><c:out value="${product.name}"/>:<c:out value="${item.name}"/></td></tr> -->
    <tr>
      <td align="left" colspan="2"><html:link paramId="productId" paramName="product" paramProperty="productId" page="/viewProduct.shtml" styleClass="BackLink">Return to <c:out value="${product.name}"/></html:link></td>
    </tr>
    <tr>
      <td align="left" width="128">
        <c:out escapeXml="false" value="${product.image}"/>
      </td>
      <td valign="top" style="padding: 10px">
      <table width="100%" cellpadding="0" cellspacing="0" border="0">
        <tr><td align="left">
          <b><c:out value="${item.name}"/></b>
        </td></tr>
        <tr><td align="left">
          <b>
            <c:out value="${item.attribute1}"/>
            <c:out value="${item.attribute2}"/>
            <c:out value="${item.attribute3}"/>
            <c:out value="${item.attribute4}"/>
            <c:out value="${item.attribute5}"/>
          </b>
        </td></tr>
        <tr><td align="left">
          <c:out value="${product.name}"/>
        </td></tr>
        <tr><td align="left">
          <c:if test="${item.quantity <= 0}">
            Back ordered.
          </c:if>
          <c:if test="${item.quantity >= 1}">
            <c:out value="${item.quantity}"/> in stock.
          </c:if>
        </td></tr>
        <tr><td >
          <fmt:formatNumber value="${item.listPrice}" pattern="$#,##0.00"/>
        </td></tr>
        <tr><td align="left">
          <html:link styleClass="Button" paramId="workingItemId" paramName="item" paramProperty="itemId" page="/addItemToCart.shtml"><img src="images/addtocart.gif"/></html:link>
        </td></tr>
        </table>
        </td>
    </tr>
  </table>