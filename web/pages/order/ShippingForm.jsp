<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<div class="heading3">Shipping Address</div>
<div id="Order">
  <html:form action="/newOrder.shtml" styleId="orderBean" method="post">
    <table>
      <tr>
        <td class="label">First name:</td>
        <td><html:text name="orderBean" property="order.shipToFirstName"/></td>
      </tr>
      <tr>
        <td class="label">Last name:</td>
        <td><html:text name="orderBean" property="order.shipToLastName"/></td>
      </tr>
      <tr>
        <td class="label">Address 1:</td>
        <td><html:text size="40" name="orderBean" property="order.shipAddress1"/></td>
      </tr>
      <tr>
        <td class="label">Address 2:</td>
        <td><html:text size="40" name="orderBean" property="order.shipAddress2"/></td>
      </tr>
      <tr>
        <td class="label">City: </td>
        <td><html:text name="orderBean" property="order.shipCity"/></td>
      </tr>
      <tr>
        <td class="label">State:</td>
        <td><html:text size="4" name="orderBean" property="order.shipState"/></td>
      </tr>
      <tr>
        <td class="label">Zip:</td>
        <td><html:text size="10" name="orderBean" property="order.shipZip"/></td>
      </tr>
      <tr>
        <td class="label">Country:</td>
        <td><html:text size="15" name="orderBean" property="order.shipCountry"/></td>
      </tr>
    </table>
    <input type="submit" name="submit" value="Continue">
  </html:form>
</div>