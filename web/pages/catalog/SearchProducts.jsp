<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<c:set var="productList" value="${catalogBean.productList}"/>
<div class="heading3">Search Results</div>
<div id="BackLink"><html:link styleClass="ZLink" page="/index.shtml">Return to Home</html:link></div>
<div id="Catalog">
  <table>
    <c:forEach var="product" items="${productList}">
      <tr>
        <td><html:link paramId="productId" paramName="product" paramProperty="productId" page="/viewProduct.shtml"><c:out escapeXml="false" value="${product.image}"/></html:link></td>
        <td><html:link styleClass="ZLink" paramId="productId" paramName="product" paramProperty="productId" page="/viewProduct.shtml"><c:out value="${product.name}"/></html:link></td>
      </tr>
    </c:forEach>
    <c:if test="${productList != null && !empty productList}">
    <tr>
      <td colspan="2">
        <c:if test="${catalogBean.productListFirstPage != true}">
          <a class="ZLink" href="switchSearchListPage.shtml?pageDirection=previous">&lt;&lt; Previous</a>
        </c:if>
        <c:if test="${catalogBean.productListLastPage != true}">
          <a class="ZLink" href="switchSearchListPage.shtml?pageDirection=next">Next &gt;&gt;</a>
        </c:if>
      </td>
    </tr>
    </c:if>
  </table>
</div>