<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>

<div id="NewAccount">

  <html:form action="/newAccount.shtml" method="post">

    <html:hidden name="accountBean" property="validation" value="new"/>

    <div class="heading3">User Information</div>
    <font color="#FF0000">* required fields</font>
    <table>
      <tr>
        <td class="label">User ID:</td><td><html:text name="accountBean" property="username"/>&nbsp;<font color="#FF0000">*</font></td>
      </tr><tr>
      <td class="label">New password:</td><td><html:password name="accountBean" property="password"/>&nbsp;<font color="#FF0000">*</font></td>
    </tr><tr>
      <td class="label">Repeat password:</td><td><html:password name="accountBean" property="repeatedPassword"/>&nbsp;<font color="#FF0000">*</font></td>
    </tr>
    </table>

    <%@ include file="IncludeAccountFields.jsp" %>

    <input type="submit" name="submit" value="Create Account"/>

  </html:form>

</div>