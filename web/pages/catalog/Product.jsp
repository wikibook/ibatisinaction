<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>

<c:set var="category" value="${catalogBean.category}"/>
<c:set var="product" value="${catalogBean.product}"/>
<c:set var="itemList" value="${catalogBean.itemList}"/>
<div class="PageHeader" style="background-color: <c:out value="${categoryColor}"/>;"><c:out value="${product.name}"/></div>
<table width="100%" cellpadding="0" cellspacing="0" border="0">
  <!-- <tr><td colspan="2" class="PageHeader" style="background-color: <c:out value="${category.color}"/>;"><c:out value="${product.name}"/></td></tr>  -->
  <tr>
    <td colspan="2">
      <html:link paramId="categoryId" paramName="product" paramProperty="categoryId" page="/viewCategory.shtml" styleClass="BackLink">
      Return to <c:out value="${category.name}" />
      </html:link>
    </td>
  </tr>
  <tr>
    <td width="128">
      <c:out escapeXml="false" value="${product.image}"/>
    </td>
    <td valign="top" align="left" style="padding-top: 10px">
      <table border="0" cellpadding="0" cellspacing="1" style="border: 1px solid black; padding: 5px">
        <tr>
          <td style="background-color: #ccc; border-bottom: 1px border black; padding: 3px;">Name</td>  
          <td style="background-color: #ccc; border-bottom: 1px border black; padding: 3px;">Description</td>  
          <td style="background-color: #ccc; border-bottom: 1px border black; padding: 3px;">List Price</td>  
          <td style="background-color: #ccc; border-bottom: 1px border black; padding: 3px;">&nbsp;</td>
        </tr>
        
        <c:forEach var="item" items="${itemList}">
        <tr>
          <td style="padding: 3px;" align="left">
            <html:link styleClass="ZLink" paramId="itemId" paramName="item" paramProperty="itemId" page="/viewItem.shtml">
              <c:out value="${item.name}"/>
            </html:link>
          </td>
          <td style="padding: 3px;">
            <c:out value="${item.attribute1}"/>
            <c:out value="${item.attribute2}"/>
            <c:out value="${item.attribute3}"/>
            <c:out value="${item.attribute4}"/>
            <c:out value="${item.attribute5}"/>
          </td>
          <td style="padding: 3px;"><fmt:formatNumber value="${item.listPrice}" pattern="$#,##0.00"/></td>
          <td style="padding: 3px;">
            <html:link 
              styleClass="Button" paramId="workingItemId" 
              paramName="item" paramProperty="itemId" 
              page="/addItemToCart.shtml"><img src="images/addtocart.gif"/></html:link>
          </td>
        </tr>
        </c:forEach>
        
        <tr>
          <td colspan="4">
          <c:if test="${catalogBean.itemListFirstPage != true}">
            <a class="ZLink" href="switchItemListPage.shtml?pageDirection=previous">&lt;&lt; Prev</a>
          </c:if>
          <c:if test="${catalogBean.itemListLastPage != true}">
            <a class="ZLink" href="switchItemListPage.shtml?pageDirection=next">Next &gt;&gt;</a>
          </c:if>
          </td>
        </tr>
      </table>
    </td>
  </tr>
</table>