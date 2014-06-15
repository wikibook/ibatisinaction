<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<div class="heading3">Advanced Search</div>
<div id="AdvancedSearch">
<html:form action="/searchProducts.shtml">
<table>
<tr>
<td class="label">Select Category:</td>
<td><html:select property="productSearch.categoryIds" multiple="true">
<html:optionsCollection property="dropDownCategoryList" value="categoryId" label="name" />
</html:select></td>
</tr>
<tr>
<td class="label">Product Name:</td>
<td><html:text property="productSearch.productName"/></td>
</tr>
<tr>
<td class="label">Product Description:</td>
<td><html:text property="productSearch.productDescription"/></td>
</tr>
<tr>
<td class="label">Item Name:</td>
<td><html:text property="productSearch.itemName"/></td>
</tr>
<tr>
<td class="label">Item Description:</td>
<td><html:text property="productSearch.itemDescription"/></td>
</tr>
</table>
<html:submit styleClass="SearchButton" value="Search"/>
<html:hidden property="searchLevel" value="a"/>
</html:form>
</div>