<%@ page contentType="text/html" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<jsp:useBean 
  id="menuHelper"
  scope="application" 
  class="org.apache.ibatis.jgamestore.presentation.helper.MenuHelper"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">

<link rel="StyleSheet" href="css/jgamestore.css" type="text/css" media="screen"/>

<head>
  <meta name="generator"
        content="HTML Tidy for Linux/x86 (vers 1st November 2002), see www.w3.org"/>
  <title>JGameStore Demo</title>
  <meta content="text/html; charset=windows-1252" http-equiv="Content-Type"/>
  <meta http-equiv="Cache-Control" content="max-age=0"/>
  <meta http-equiv="Cache-Control" content="no-cache"/>
  <meta http-equiv="expires" content="0"/>
  <meta http-equiv="Expires" content="Tue, 01 Jan 1980 1:00:00 GMT"/>
  <meta http-equiv="Pragma" content="no-cache"/>
  <link rel="icon" href="/jgamestore/favicon.ico" type="image/x-icon" />
  <link rel="shortcut icon" href="/jgamestore/favicon.ico" type="image/x-icon" />
</head>
<body>
<tiles:insert attribute="header" flush="false" />
<table border="0" cellpadding="0" cellspacing="0" width="100%">
    <tr>
      <td valign="top" class="LeftContent" rowspan="2" width="182"><tiles:insert attribute="left" flush="false"/></td>
      <td height="20" class="ContentTop" align="right">
        <table border="0" cellpadding="0" cellspacing="0"><tr>
          <td class="ContentTop"><img src="images/spacer.gif" height="20" width="2"/></td>
          <td class="ContentTop"><html:link styleClass="Normal" action="advancedSearch">Advanced Search</html:link>&nbsp;</td>
          <td class="ContentTop"><html:form method="post" action="/searchProducts.shtml">
            <table height="20" cellpadding="0" cellspacing="0" border="0"><tr>
            <td class="ContentTop"><html:hidden property="searchLevel" value="s"/><input type="text" class="inputtext" name="keyword" size="14"/></td>
            <td class="ContentTop">&nbsp;</td>
            <td class="ContentTop"><input class="inputsubmit" type="submit" name="SearchButton" value="Search"/></td>
            <td class="ContentTop">&nbsp;</td>
            </tr></table></html:form></td>
        </tr></table>
      </td>
    </tr>
    <tr>
      <td class="Content" width="100%" valign="top">
      <tiles:insert attribute="topMenu" flush="false"/>
      <html:errors/>
      <c:if test="${not empty message}">
      <div id="Errors"><c:out value="${message}" escapeXml="false"/></div>
      </c:if>
      <c:if test="${errors != null && not empty errors}">
      <c:forEach var="error" items="${errors}">
      <c:out value="${error}"/>
      </c:forEach>
      </c:if>
      <div id="BodyWrapper"><tiles:insert attribute="body" flush="false" /></div>
      </td>
    </tr>
</table>
<tiles:insert attribute="footer" flush="false" />
</body>
</html>