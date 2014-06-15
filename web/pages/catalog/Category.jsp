<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>

<c:set var="category" value="${catalogBean.category}"/>
<c:set var="productList" value="${catalogBean.productList}"/>
<div colspan="2" class="PageHeader" style="background-color: <c:out value="${categoryColor}"/>;" align="left"><c:out value="${category.name}"/></div>
  <table width="100%">
<!--<tr><td colspan="2" class="PageHeader" style="background-color: <c:out value="${category.color}"/>;" align="left"><c:out value="${category.name}"/></td></tr>-->
    <tr>
      <td colspan="2" align="left"><html:link page="/index.shtml" styleClass="BackLink">Return to Home</html:link></td>
    </tr>
    <c:forEach var="product" items="${productList}">
    <tr>
      <td width="128" style="border-bottom: 1px solid #ccc" align="center">
        <html:link paramId="productId" paramName="product" paramProperty="productId" page="/viewProduct.shtml"><c:out value="${product.image}" escapeXml="false"/></html:link>
        <html:link styleClass="Normal" paramId="productId" paramName="product" paramProperty="productId" page="/viewProduct.shtml">View Items</html:link>
      </td>
      <td align="left" style="border-bottom: 1px solid #ccc">
        <html:link styleClass="ZLink" paramId="productId" paramName="product" paramProperty="productId" page="/viewProduct.shtml"><c:out value="${product.name}"/></html:link>
      </td>
    </tr>
    </c:forEach>
    
    <tr>
    <td colspan="2">
      <c:if test="${catalogBean.productListFirstPage != true}">
        <a class="ZLink" href="switchProductListPage.shtml?pageDirection=previous">&lt;&lt; Prev</a>
      </c:if>
      <c:if test="${catalogBean.productListLastPage != true}">
        <a class="ZLink" href="switchProductListPage.shtml?pageDirection=next">Next &gt;&gt;</a>
      </c:if>
    </td>
    </tr>
  </table>