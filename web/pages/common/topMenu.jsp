<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<c:set var="menuCategoryId" scope="page" value="${catalogBean.categoryId}"/>

<div style="width: 100%; background-image: url(images/topmenubkg.gif); float: left;">

<c:choose>
<c:when test="${empty menuCategoryId}">
<c:set var="menuStyle" scope="page" value="background-color: #B30000; padding-top: 8px; padding-left: 10px; padding-right: 10px; height: 21px; border-bottom: 1px solid #B30000; border-right: 1px solid black; float: left; color: #ffffff;"/>
<c:set var="categoryColor" scope="request" value="#B30000"/>
<c:set var="linkClass" value="ActiveTabLink"/>
</c:when>
<c:otherwise>
<c:set var="menuStyle" scope="page" value="background-color: #f2f2f2; padding-top: 8px; padding-left: 10px; padding-right: 10px; height: 21px; border-bottom: 1px solid black; border-right: 1px solid black; float: left;"/>
<c:set var="linkClass" value="TabLink"/>
</c:otherwise>
</c:choose>

<div style="<c:out value="${menuStyle}"/>">
<a href="." class="<c:out value="${linkClass}"/>">Home</a>
</div>
<c:forEach items="${menuHelper.categoryList}" var="menuItem" varStatus="status">

<c:choose>
<c:when test="${menuItem.categoryId eq menuCategoryId}">
<c:set var="menuStyle" scope="page" value="background-color: ${menuItem.color}; padding-top: 8px; padding-left: 10px; padding-right: 10px; height: 21px; border-bottom: 1px solid ${menuItem.color}; border-right: 1px solid black; float: left; color: #ffffff;"/>
<c:set var="categoryColor" scope="request" value="${menuItem.color}"/>
<c:set var="linkClass" value="ActiveTabLink"/>
</c:when>
<c:otherwise>
<c:set var="menuStyle" scope="page" value="background-color: #f2f2f2; padding-top: 8px; padding-left: 10px; padding-right: 10px; height: 21px; border-bottom: 1px solid black; border-right: 1px solid black; float: left;"/>
<c:set var="linkClass" value="TabLink"/>
</c:otherwise>
</c:choose>

<div style="<c:out value="${menuStyle}"/>">
<a class="<c:out value="${linkClass}"/>" href="viewCategory.shtml?categoryId=<c:out value="${menuItem.categoryId}"/>"><c:out value="${menuItem.name}"/></a>
</div>
</c:forEach>
</div>