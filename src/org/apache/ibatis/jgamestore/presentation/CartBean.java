package org.apache.ibatis.jgamestore.presentation;


import java.util.Iterator;
import java.util.Map;

import org.apache.ibatis.jgamestore.domain.Cart;
import org.apache.ibatis.jgamestore.domain.CartItem;
import org.apache.ibatis.jgamestore.domain.Item;
import org.apache.ibatis.jgamestore.service.CatalogService;
import org.apache.ibatis.jgamestore.service.ServiceFactory;
import org.apache.struts.beanaction.ActionContext;

public class CartBean extends AbstractBean {

  private CatalogService catalogService;

  private Cart cart = new Cart();
  private String workingItemId;
  private String pageDirection;

  public CartBean() {
    this ((CatalogService)ServiceFactory.getInstance().getService(CatalogService.class));
  }

  public CartBean(CatalogService catalogService) {
    this.catalogService= catalogService;
  }

  public Cart getCart() {
    return cart;
  }

  public void setCart(Cart cart) {
    this.cart = cart;
  }

  public String getWorkingItemId() {
    return workingItemId;
  }

  public void setWorkingItemId(String workingItemId) {
    this.workingItemId = workingItemId;
  }

  public String getPageDirection() {
    return pageDirection;
  }

  public void setPageDirection(String pageDirection) {
    this.pageDirection = pageDirection;
  }

  public String addItemToCart() {
    if (cart.containsItemId(workingItemId)) {
      cart.incrementQuantityByItemId(workingItemId);
    } else {
      // isInStock is a "real-time" property that must be updated
      // every time an item is added to the cart, even if other
      // item details are cached.
      boolean isInStock = catalogService.isItemInStock(workingItemId);
      Item item = catalogService.getItem(workingItemId);
      cart.addItem(item, isInStock);
    }

    return SUCCESS;
  }

  public String removeItemFromCart() {

    Item item = cart.removeItemById(workingItemId);

    if (item == null) {
      setMessage("Attempted to remove null CartItem from Cart.");
      return FAILURE;
    } else {
      return SUCCESS;
    }
  }

  public String updateCartQuantities() {
    Map parameterMap = ActionContext.getActionContext().getParameterMap();

    Iterator cartItems = getCart().getAllCartItems();
    while (cartItems.hasNext()) {
      CartItem cartItem = (CartItem) cartItems.next();
      String itemId = cartItem.getItem().getItemId();
      try {
        int quantity = Integer.parseInt((String) parameterMap.get(itemId));
        getCart().setQuantityByItemId(itemId, quantity);
        if (quantity < 1) {
          cartItems.remove();
        }
      } catch (Exception e) {
        //ignore parse exceptions on purpose
      }
    }

    return SUCCESS;
  }

  public String viewCart() {
    return SUCCESS;
  }

  public void clear() {
    cart = new Cart();
    workingItemId = null;
    pageDirection = null;
  }

}
