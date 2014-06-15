package org.apache.ibatis.jgamestore.presentation;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.jgamestore.domain.Account;
import org.apache.ibatis.jgamestore.domain.DomainFixture;
import org.apache.ibatis.jgamestore.service.AccountService;
import org.apache.ibatis.jgamestore.service.CatalogService;
import org.apache.ibatis.jgamestore.service.impl.AccountServiceImpl;
import org.apache.ibatis.jgamestore.service.impl.CatalogServiceImpl;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.beanaction.BeanAction;
import org.jmock.Mock;
import org.jmock.cglib.MockObjectTestCase;
import org.jmock.core.constraint.IsInstanceOf;

import com.ibatis.common.util.PaginatedArrayList;

public class AccountBeanTest extends MockObjectTestCase {

  public void testShouldSuccessfullyCallServicesToCreateNewAccount() {
    Account account = DomainFixture.newTestAccount();

    Mock accountServiceMock = mock(AccountServiceImpl.class);

    accountServiceMock
      .expects(atLeastOnce())
      .method("getAccount")
      .with(NOT_NULL)
      .will(onConsecutiveCalls(
            returnValue(null),
            returnValue(account)));
    
    accountServiceMock.expects(once())
        .method("insertAccount")
        .with(NOT_NULL);

    Mock catalogServiceMock = mock(CatalogServiceImpl.class);

    catalogServiceMock.expects(once())
        .method("getProductListByCategory")
        .with(NOT_NULL)
        .will(returnValue(new PaginatedArrayList(5)));

    AccountBean accountBean = new AccountBean((AccountService)accountServiceMock.proxy(), (CatalogService)catalogServiceMock.proxy());
    accountBean.setAccount(account);

    String result = accountBean.newAccount();
    assertEquals("success", result);
  }

  public void testShouldSuccessfullyCallServicesToUpdateExistingAccount() {
    Account account = DomainFixture.newTestAccount();
    account.setUsername("x");
    account.setPassword("x");

    Mock accountServiceMock = mock(AccountServiceImpl.class);

    accountServiceMock.expects(once())
        .method("updateAccount")
        .with(NOT_NULL);

    accountServiceMock.expects(once())
        .method("getAccount")
        .with(NOT_NULL)
        .will(returnValue(account));

    Mock catalogServiceMock = mock(CatalogServiceImpl.class);

    catalogServiceMock.expects(once())
        .method("getProductListByCategory")
        .with(NOT_NULL)
        .will(returnValue(new PaginatedArrayList(5)));

    AccountBean accountBean = new AccountBean((AccountService)accountServiceMock.proxy(), (CatalogService)catalogServiceMock.proxy());
    accountBean.setAccount(account);
    accountBean.setRepeatedPassword("x");

    String result = accountBean.editAccount();
    assertEquals("success", result);
  }

  public void testShouldCallEditAccountFormReturningSuccess() {
    Account account = DomainFixture.newTestAccount();
    Mock accountServiceMock = mock(AccountServiceImpl.class);
    accountServiceMock.expects(once())
        .method("getAccount")
        .with(NOT_NULL)
        .will(returnValue(account));
    Mock catalogServiceMock = mock(CatalogServiceImpl.class);
    AccountBean accountBean = new AccountBean((AccountService)accountServiceMock.proxy(), (CatalogService)catalogServiceMock.proxy());
    accountBean.setAccount(account);
    assertEquals("success", accountBean.editAccountForm());
  }

  public void testShouldSwitchPageDirection() {
    Account account = DomainFixture.newTestAccount();
    Mock accountServiceMock = mock(AccountServiceImpl.class);
    Mock catalogServiceMock = mock(CatalogServiceImpl.class);
    AccountBean accountBean = new AccountBean((AccountService)accountServiceMock.proxy(), (CatalogService)catalogServiceMock.proxy());
    accountBean.setAccount(account);
    accountBean.setMyList(new PaginatedArrayList(5));
    accountBean.setPageDirection("next");
    assertEquals("success",accountBean.switchMyListPage());
    accountBean.setPageDirection("previous");
    assertEquals("success",accountBean.switchMyListPage());
  }

  public void testShouldSignoffAccount() {
      
    Account account = DomainFixture.newTestAccount();
    
    Mock accountServiceMock = mock(AccountServiceImpl.class);
    accountServiceMock.expects(once())
        .method("getAccount")
        .with(NOT_NULL,NOT_NULL)
        .will(returnValue(account));
    
    Mock catalogServiceMock = mock(CatalogServiceImpl.class);
    catalogServiceMock.expects(once())
        .method("getProductListByCategory")
        .with(NOT_NULL)
        .will(returnValue(new PaginatedArrayList(5)));
    
    Mock response = mock(HttpServletResponse.class);
    response.expects(once())
        .method("sendRedirect")
        .with(new IsInstanceOf(String.class));
    
    Mock request = mock(HttpServletRequest.class);
    request.expects(once())
        .method("getHeader")
        .with(isA(String.class))
        .will(returnValue(""));

    request.expects(once())
    .method("setAttribute")
    .with(eq("BeanActionException"),isA(NullPointerException.class));
    
    AccountBean accountBean = new AccountBean((AccountService)accountServiceMock.proxy(), (CatalogService)catalogServiceMock.proxy());
    BeanAction mockBeanAction = new BeanAction();
    ActionMapping am = new ActionMapping();
    
    try {
        
        mockBeanAction.execute(
                am, accountBean, 
                (HttpServletRequest)request.proxy(), 
                (HttpServletResponse)response.proxy());
        
    } catch (Exception e) {
//      ignore this exception. execute is called to initialize the context.
    }
    
    accountBean.setAccount(account);
    accountBean.signon();

    assertEquals("success", accountBean.signoff());
    assertFalse(accountBean.isAuthenticated());
  }

  public void testShouldSignonAccount() {
      
    Account account = DomainFixture.newTestAccount();
    
    Mock accountServiceMock = mock(AccountServiceImpl.class);
    accountServiceMock.expects(once())
        .method("getAccount")
        .with(NOT_NULL,NOT_NULL)
        .will(returnValue(account));
    
    Mock catalogServiceMock = mock(CatalogServiceImpl.class);
    catalogServiceMock.expects(once())
        .method("getProductListByCategory")
        .with(NOT_NULL)
        .will(returnValue(new PaginatedArrayList(5)));
    
    Mock response = mock(HttpServletResponse.class);
    response.expects(once())
    .method("sendRedirect")
    .with(new IsInstanceOf(String.class));
    
    Mock request = mock(HttpServletRequest.class);
    request.expects(once())
    .method("getHeader")
    .with(isA(String.class))
    .will(returnValue(""));
    
    request.expects(once())
    .method("setAttribute")
    .with(eq("BeanActionException"),isA(NullPointerException.class));
    
    AccountBean accountBean = new AccountBean((AccountService)accountServiceMock.proxy(), (CatalogService)catalogServiceMock.proxy());
    
    BeanAction mockBeanAction = new BeanAction();
    
    try {
        mockBeanAction.execute(new ActionMapping(),accountBean,(HttpServletRequest)request.proxy(),(HttpServletResponse)response.proxy());
    } catch (Exception e) {
        // ignore this exception. execute is called to initialize the context. 
    }
    
    accountBean.setAccount(account);
    assertEquals(null, accountBean.signon());
    assertTrue(accountBean.isAuthenticated());
  }

  public void testShouldFailToSignonAccount() {
      
    Account account = DomainFixture.newTestAccount();
    
    Mock accountServiceMock = mock(AccountServiceImpl.class);
    accountServiceMock.expects(once())
        .method("getAccount")
        .with(NULL,NULL)
        .will(returnValue(null));
    
    Mock catalogServiceMock = mock(CatalogServiceImpl.class);
    
    Mock response = mock(HttpServletResponse.class);
    response.expects(once())
    .method("sendRedirect")
    .with(new IsInstanceOf(String.class));
    
    Mock request = mock(HttpServletRequest.class);
    request.expects(once())
    .method("getHeader")
    .with(isA(String.class))
    .will(returnValue(""));
    
    request.expects(once())
    .method("setAttribute")
    .with(eq("BeanActionException"),isA(NullPointerException.class));
    
    AccountBean accountBean = new AccountBean((AccountService)accountServiceMock.proxy(), (CatalogService)catalogServiceMock.proxy());
    
    BeanAction mockBeanAction = new BeanAction();
    
    try {
        mockBeanAction.execute(new ActionMapping(),accountBean,(HttpServletRequest)request.proxy(),(HttpServletResponse)response.proxy());
    } catch (Exception e) {
//      ignore this exception. execute is called to initialize the context.
    }
    
    assertEquals(null, accountBean.signon());
    assertFalse(accountBean.isAuthenticated());
  }

  public void testShouldGetCategories() {
    AccountBean bean = new AccountBean();
    List categories = bean.getCategories();

    assertTrue(assertContainsNameValue("Action/Adventure","ACTADV",categories));
    assertTrue(assertContainsNameValue("Children","CHILDREN",categories));
    assertTrue(assertContainsNameValue("Sports","SPORTS",categories));
    assertTrue(assertContainsNameValue("Strategy","STRATEGY",categories));
    assertTrue(assertContainsNameValue("Teen","TEEN",categories));
  }

  protected boolean assertContainsNameValue(String name, String value, List cateogryList) {
      
      boolean b = false;
      Iterator iter = cateogryList.iterator();
      
      while(iter.hasNext()) {
        NameValueBean element = (NameValueBean) iter.next();
        if(element.getName().equals(name) && element.getValue().equals(value)) {
            b = true;
            break;
        }
      }
      
      return b;
  }
  
  public void testShouldGetLanguages() {
    AccountBean bean = new AccountBean();
    List langs = bean.getLanguages();
    assertTrue(langs.contains("english"));
    assertTrue(langs.contains("japanese"));
  }

  public void testShouldResetBooleanOptions() {
    AccountBean bean = new AccountBean();
    bean.setAccount(DomainFixture.newTestAccount());
    bean.getAccount().setBannerOption(true);
    bean.getAccount().setListOption(true);
    bean.reset();
    assertFalse(bean.getAccount().isBannerOption());
    assertFalse(bean.getAccount().isListOption());
  }

  public void testShouldClearAccountBean() {
    Mock accountServiceMock = mock(AccountServiceImpl.class);
    Mock catalogServiceMock = mock(CatalogServiceImpl.class);
    AccountBean accountBean = new AccountBean((AccountService)accountServiceMock.proxy(), (CatalogService)catalogServiceMock.proxy());
    accountBean.setAccount(DomainFixture.newTestAccount());
    accountBean.setRepeatedPassword("something");
    accountBean.setPageDirection("F");
    accountBean.setMyList(new PaginatedArrayList(5));

    accountBean.clear();

    assertEquals(null, accountBean.getAccount().getFirstName());
    assertEquals(null, accountBean.getRepeatedPassword());
    assertEquals(null, accountBean.getPageDirection());
    assertEquals(null, accountBean.getMyList());
  }

}
