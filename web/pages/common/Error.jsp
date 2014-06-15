<%@ page import="java.io.PrintWriter" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>

<c:choose>

<c:when test="${empty BeanActionException && empty message}">
<p><div class="heading3">Something happened...</div>
<b>But no further information was provided.</b><p/>
</c:when>

<c:when test="${not empty BeanActionException}">

<p>
<div class="heading3">Error!</div>
<b><c:out value="${BeanActionException.class.name}"/></b>
<c:out value="${BeanActionException.message}"/>
<p/>
<p>
  <h4>Stack</h4>
  <pre>
    <%
      Exception e = (Exception) request.getAttribute("BeanActionException");
      e.printStackTrace(new PrintWriter(out));
    %>
  </pre>
</p>

</c:when>

<c:otherwise>
This should never happen :)
</c:otherwise>

</c:choose>