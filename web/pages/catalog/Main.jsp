<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>

<c:set var="productList" value="${catalogBean.newestProductList}"/>
<div class="PageHeader" style="background-color: <c:out value="${categoryColor}"/>;" >Newest Products</div>
<div id="Main">
  <table width="100%" border="0" cellpadding="0" cellspacing="0">
    <!-- <tr><td colspan="2" class="PageHeader">Newest Products</td></tr>  -->
    <c:forEach var="product" items="${productList}">
      <tr>
        <td width="128" style="border-bottom: 1px solid #ccc" align="center">
          <html:link paramId="productId" paramName="product" paramProperty="productId" page="/viewProduct.shtml"><c:out value="${product.image}" escapeXml="false"/></html:link><br/>
          <html:link styleClass="Normal" paramId="productId" paramName="product" paramProperty="productId" page="/viewProduct.shtml">View Items</html:link>
        </td>
        <td align="left" style="border-bottom: 1px solid #ccc">
          <html:link styleClass="ZLink" paramId="productId" paramName="product" paramProperty="productId" page="/viewProduct.shtml"><c:out value="${product.name}"/></html:link>
        </td>
      </tr>
    </c:forEach>
  </table>
</div>