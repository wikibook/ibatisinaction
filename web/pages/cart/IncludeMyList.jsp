<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<div style="clear: left;">&nbsp;</div>
<c:set var="myList" value="${accountBean.myList}"/>
<c:if test="${myList != null && not empty myList}">
  <div class="heading3">Game Favorites</div>
  <p>
    Shop for more of your favorite games here.
  </p>
  <ul>
    <c:forEach var="product" items="${myList}">
      <li><html:link styleClass="ZLink" paramId="productId" paramName="product" paramProperty="productId" page="/viewProduct.shtml">
        <c:out value="${product.name}"/></html:link>
      (<c:out value="${product.productId}"/>)</li>
    </c:forEach>
  </ul>

  <p>
    <c:if test="${accountBean.myListFirstPage != true}">
      <a class="ZLink" href="switchMyListPage.shtml?pageDirection=previous&account.listOption=<c:out value="${accountBean.account.listOption}"/>&account.bannerOption=<c:out value="${accountBean.account.bannerOption}"/>">&lt;&lt;Prev</a>
    </c:if>
    <c:if test="${accountBean.myListLastPage != true}">
      <a class="ZLink" href="switchMyListPage.shtml?pageDirection=next&account.listOption=<c:out value="${accountBean.account.listOption}"/>&account.bannerOption=<c:out value="${accountBean.account.bannerOption}" />">Next &gt;&gt;</a>
    </c:if>
  </p>

</c:if>




