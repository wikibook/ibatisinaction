<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<div>&nbsp;</div>
<div class="heading3">Account Information</div>
    <table>
      <tr>
        <td class="label">First name:</td><td><html:text name="accountBean" property="account.firstName"/></td>
      </tr><tr>
      <td class="label">Last name:</td><td><html:text name="accountBean" property="account.lastName"/></td>
    </tr><tr>
      <td class="label">Email:</td><td><html:text size="40" name="accountBean" property="account.email"/></td>
    </tr><tr>
      <td class="label">Phone:</td><td><html:text name="accountBean" property="account.phone"/></td>
    </tr><tr>
      <td class="label">Address 1:</td><td><html:text size="40" name="accountBean" property="account.address1"/></td>
    </tr><tr>
      <td class="label">Address 2:</td><td><html:text size="40" name="accountBean" property="account.address2"/></td>
    </tr><tr>
      <td class="label">City:</td><td><html:text name="accountBean" property="account.city"/></td>
    </tr><tr>
      <td class="label">State:</td><td><html:text size="4" name="accountBean" property="account.state"/></td>
    </tr><tr>
      <td class="label">Zip:</td><td><html:text size="10" name="accountBean" property="account.zip"/></td>
    </tr><tr>
      <td class="label">Country:</td><td><html:text size="15" name="accountBean" property="account.country"/></td>
    </tr>
    </table>
    <div>&nbsp;</div>
    <div class="heading3">Profile Information</div>
    
    <table>
      <tr>
        <td class="label">Language Preference:</td><td>
        <html:select name="accountBean" property="account.languagePreference">
          <html:options name="accountBean" property="languages"/>
        </html:select></td>
      </tr><tr>
      <td class="label">Favourite Category:</td><td>
      <html:select name="accountBean" property="account.favouriteCategoryId">
        <html:optionsCollection name="accountBean" property="categories" label="name" value="value"/>
      </html:select></td>
    </tr><tr>
      <td class="label">Enable MyList</td><td><html:checkbox name="accountBean" property="account.listOption"/></td>
    </tr><tr>
      <td class="label">Enable MyBanner</td><td><html:checkbox name="accountBean" property="account.bannerOption"/></td>
    </tr>
    </table>