package org.apache.ibatis.jgamestore.presentation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.jgamestore.domain.Account;
import org.apache.ibatis.jgamestore.domain.Order;
import org.apache.ibatis.jgamestore.service.AccountService;
import org.apache.ibatis.jgamestore.service.OrderService;
import org.apache.ibatis.jgamestore.service.ServiceFactory;
import org.apache.struts.beanaction.ActionContext;

import com.ibatis.common.util.PaginatedList;

public class OrderBean extends AbstractBean {

  private static final List CARD_TYPE_LIST;

  private AccountService accountService;
  private OrderService orderService;

  private Order order;
  private int orderId;
  private boolean shippingAddressRequired;
  private boolean confirmed;
  private PaginatedList orderList;
  private String pageDirection;

  static {
    List cardList = new ArrayList();
    cardList.add("Visa");
    cardList.add("MasterCard");
    cardList.add("American Express");
    CARD_TYPE_LIST = Collections.unmodifiableList(cardList);
  }

  public OrderBean() {
    this (
      (AccountService)ServiceFactory.getInstance().getService(AccountService.class),
      (OrderService)ServiceFactory.getInstance().getService(OrderService.class));
  }

  public OrderBean(AccountService accountService, OrderService orderService) {
    order = new Order();
    shippingAddressRequired = false;
    confirmed = false;
    this.accountService = accountService;
    this.orderService = orderService;
  }

  public int getOrderId() {
    return orderId;
  }

  public void setOrderId(int orderId) {
    this.orderId = orderId;
  }

  public Order getOrder() {
    return order;
  }

  public void setOrder(Order order) {
    this.order = order;
  }

  public boolean isShippingAddressRequired() {
    return shippingAddressRequired;
  }

  public void setShippingAddressRequired(boolean shippingAddressRequired) {
    this.shippingAddressRequired = shippingAddressRequired;
  }

  public boolean isConfirmed() {
    return confirmed;
  }

  public void setConfirmed(boolean confirmed) {
    this.confirmed = confirmed;
  }

  public List getCreditCardTypes() {
    return CARD_TYPE_LIST;
  }

  public List getOrderList() {
    return orderList;
  }

  public String getPageDirection() {
    return pageDirection;
  }

  public void setPageDirection(String pageDirection) {
    this.pageDirection = pageDirection;
  }

  public String newOrderForm() {
    Map sessionMap = ActionContext.getActionContext().getSessionMap();
    AccountBean accountBean = (AccountBean) sessionMap.get("accountBean");
    CartBean cartBean = (CartBean) sessionMap.get("cartBean");

    clear();
    if (accountBean == null || !accountBean.isAuthenticated()){
      return SUCCESS;
    } else if (cartBean != null) {
      Account account = accountService.getAccount(accountBean.getAccount().getUsername());
      order.initOrder(account, cartBean.getCart());
      return SUCCESS;
    } else {
      setMessage("An order could not be created because a cart could not be found.");
      return FAILURE;
    }
  }

  public String newOrder() {
    Map sessionMap = ActionContext.getActionContext().getSessionMap();

    if (shippingAddressRequired) {
      shippingAddressRequired = false;
      return SHIPPING;
    } else if (!isConfirmed()) {
      return CONFIRM;
    } else if (getOrder() != null) {

      orderService.insertOrder(order);

      CartBean cartBean = (CartBean)sessionMap.get("cartBean");
      cartBean.clear();

      setMessage("Thank you, your order has been submitted.");

      return SUCCESS;
    } else {
      setMessage("An error occurred processing your order (order was null).");
      return FAILURE;
    }
  }

  public String listOrders() {
    Map sessionMap = ActionContext.getActionContext().getSessionMap();
    AccountBean accountBean = (AccountBean) sessionMap.get("accountBean");
    orderList = orderService.getOrdersByUsername(accountBean.getAccount().getUsername());
    return SUCCESS;
  }

  public String switchOrderPage() {
    if ("next".equals(pageDirection)) {
      orderList.nextPage();
    } else if ("previous".equals(pageDirection)) {
      orderList.previousPage();
    }
    return SUCCESS;
  }


  public String viewOrder() {
    Map sessionMap = ActionContext.getActionContext().getSessionMap();
    AccountBean accountBean = (AccountBean) sessionMap.get("accountBean");

    order = orderService.getOrder(orderId);

    if (accountBean.getAccount().getUsername().equals(order.getUsername())) {
      return SUCCESS;
    } else {
      order = null;
      setMessage("You may only view your own orders.");
      return FAILURE;
    }
  }

  public void reset() {
    shippingAddressRequired = false;
  }

  public void clear() {
    order = new Order();
    orderId = 0;
    shippingAddressRequired = false;
    confirmed = false;
    orderList = null;
    pageDirection = null;
  }

  /*
   * HACK FOR JSP JSTL. GACK!!!
   */
  
  public boolean isOrderListFirstPage() {
      return orderList.isFirstPage();
  }
  
  public boolean isOrderListLastPage() {
      return orderList.isLastPage();
  }
  
}
