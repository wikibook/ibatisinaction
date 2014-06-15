package org.apache.ibatis.jgamestore.presentation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.apache.ibatis.jgamestore.domain.Account;
import org.apache.ibatis.jgamestore.domain.Category;
import org.apache.ibatis.jgamestore.service.AccountService;
import org.apache.ibatis.jgamestore.service.CatalogService;
import org.apache.ibatis.jgamestore.service.ServiceFactory;
import org.apache.struts.beanaction.ActionContext;
import org.apache.struts.beanaction.BeanActionException;

import com.ibatis.common.util.PaginatedList;

public class AccountBean extends AbstractBean {

  private static final List LANGUAGE_LIST;
  private static final List CATEGORY_LIST;

  private AccountService accountService;
  private CatalogService catalogService;

  private Account account;
  private String repeatedPassword;
  private String pageDirection;
  private String validation;
  private String authError;
  private PaginatedList myList;
  private boolean authenticated = false;
  private String x;
  private String y;
  
  static {
    
    CatalogService catalogService = 
        (CatalogService)ServiceFactory
        .getInstance()
        .getService(CatalogService.class);
      
    List langList = new ArrayList();
    langList.add("english");
    langList.add("japanese");
    LANGUAGE_LIST = Collections.unmodifiableList(langList);
    
    Iterator categoryIt = 
        catalogService.getCategoryList().iterator();
    
    List catList = new ArrayList();
    
    while(categoryIt.hasNext())
    {
        
        Category catalog = 
            (Category)categoryIt.next();
        
        catList.add(new NameValueBean(catalog.getName(),catalog.getCategoryId()));
        
    }
    
    CATEGORY_LIST = catList;//Collections.unmodifiableList(catList);
  }

  public AccountBean() {
    this (
      (AccountService)ServiceFactory.getInstance().getService(AccountService.class),
      (CatalogService)ServiceFactory.getInstance().getService(CatalogService.class));
  }

  public AccountBean(AccountService accountService, CatalogService catalogService) {
    account = new Account();
    this.accountService = accountService;
    this.catalogService = catalogService;
  }

  public String getUsername() {
    return account.getUsername();
  }

  public void setUsername(String username) {
    account.setUsername(username);
  }

  public String getPassword() {
    return account.getPassword();
  }

  public void setPassword(String password) {
    account.setPassword(password);
  }

  public PaginatedList getMyList() {
    return myList;
  }

  public void setMyList(PaginatedList myList) {
    this.myList = myList;
  }

  public String getRepeatedPassword() {
    return repeatedPassword;
  }

  public void setRepeatedPassword(String repeatedPassword) {
    this.repeatedPassword = repeatedPassword;
  }

  public Account getAccount() {
    return account;
  }

  public void setAccount(Account account) {
    this.account = account;
  }


  public List getLanguages() {
    return LANGUAGE_LIST;
  }

  public List getCategories() {
    return CATEGORY_LIST;
  }

  public String getPageDirection() {
    return pageDirection;
  }

  public void setPageDirection(String pageDirection) {
    this.pageDirection = pageDirection;
  }

  public String getValidation() {
    return validation;
  }

  public void setValidation(String validation) {
    this.validation = validation;
  }

  public String newAccount() {
    try {
        
      Account accountTemp = accountService.getAccount(account.getUsername());
      
      if(null != accountTemp) {
          setMessage("An account already exists with the username you provided.");
          return FAILURE;
      }
      
      boolean validated = true;
      List validationMessages = new ArrayList();
      
      //validate new account fields
      if(isEmpty(account.getUsername())) 
      {
          validationMessages.add("<div>User ID is empty</div>");
          validated = false;
          
      }
      
      boolean verifyPass = true;
      if(isEmpty(account.getPassword()))
      {
          validationMessages.add("<div>Password is empty</div>");
          verifyPass=false;
      }
      
      if(verifyPass && (!account.getPassword().equals(getRepeatedPassword())))
      {
          validationMessages.add("<li>Passwords do not match</li>");
          verifyPass=false;
      }
      
      if(!validated) {
          StringBuffer errorMessageCompilation = new StringBuffer("");
          
          for (Iterator iter = validationMessages.iterator(); iter.hasNext();) 
          {
            errorMessageCompilation.append(iter.next());
          }

          setMessage(errorMessageCompilation.toString());
      }
      
      if(!validated) {    
          return FAILURE;
      } else {
          accountService.insertAccount(account);
          account = accountService.getAccount(account.getUsername());
          myList = catalogService.getProductListByCategory(account.getFavouriteCategoryId());
          authenticated = true;
          repeatedPassword = null;
          return SUCCESS;
      }
    } catch (Exception e) {
      throw new BeanActionException ("There was a problem creating your Account Information.  Cause: " + e, e);
    }
  }

  private boolean isEmpty(String valueA) {
      return null == valueA || "".equals(valueA.trim());
  }
  
  public String editAccountForm() {
    try {
      account = accountService.getAccount(account.getUsername());
      return SUCCESS;
    } catch (Exception e) {
      throw new BeanActionException ("There was a problem retrieving your Account Information. Cause: "+e, e);
    }
  }

  public String editAccount() {
    try {
        
      boolean validated = true;
      List validationMessages = new ArrayList();
    
      if(!isEmpty(account.getPassword()) && (!account.getPassword().equals(getRepeatedPassword())))
      {
        validationMessages.add("<li>Passwords do not match</li>");
        validated = false;
      }
    
      if(!validated) {
        StringBuffer errorMessageCompilation = new StringBuffer("");
        
        for (Iterator iter = validationMessages.iterator(); iter.hasNext();) 
        {
          errorMessageCompilation.append(iter.next());
        }

        setMessage(errorMessageCompilation.toString());
      }
      
      if (validated) {
          accountService.updateAccount(account);
          account = accountService.getAccount(account.getUsername());
          myList = catalogService.getProductListByCategory(account.getFavouriteCategoryId());
      }
      
      this.repeatedPassword = "";
      
      return SUCCESS;
      
    } catch (Exception e) {
      throw new BeanActionException ("There was a problem updating your Account Information. Cause: "+e, e);
    }
  }

  public String switchMyListPage () {
    if ("next".equals(pageDirection)) {
      myList.nextPage();
    } else if ("previous".equals(pageDirection)) {
      myList.previousPage();
    }
    return SUCCESS;
  }

  public String signon() {
      
    ActionContext ac = ActionContext.getActionContext();
    account = accountService.getAccount(account.getUsername(), account.getPassword());
    
    if (account == null ) {
      authError = "Invalid username or password.  Signon failed.";
      clear();
    } else {
      account.setPassword(null);
      myList = catalogService.getProductListByCategory(account.getFavouriteCategoryId());
      authenticated = true;
    }
    
    try {
        ac.getResponse().sendRedirect(ac.getRequest().getHeader("REFERER"));
    } catch (IOException e) {
        throw new BeanActionException ("There was a problem during signin: "+e, e);  
    }
    
    //return null because a redirect will be initiated during signon
    return null;
  }

  public String signoff() {
    clear();
    return SUCCESS;
  }

  public boolean isAuthenticated() {
    return authenticated;
  }

  public void reset() {
    if (account != null) {
      account.setBannerOption(false);
      account.setListOption(false);
    }
  }

  public void clear() {
    account = new Account();
    repeatedPassword = null;
    pageDirection = null;
    myList = null;
    authenticated = false;
  }

  public String getX() {
    return x;
  }

  public void setX(String x) {
    this.x = x;
  }

  public String getY() {
    return y;
  }

  public void setY(String y) {
    this.y = y;
  }

  public String getAuthError() {
    String _authError = authError;
    
    //Once the error has been read remove it
    authError="";
    
    return _authError;
  }

  public void setAuthError(String authError) {
    this.authError = authError;
  }

  /*
   * HACK FOR JSP JSTL. GACK!!!
   */

  public boolean isMyListFirstPage() {
      return myList.isFirstPage();
  }
  
  public boolean isMyListLastPage() {
      return myList.isLastPage();
  }
  
}
