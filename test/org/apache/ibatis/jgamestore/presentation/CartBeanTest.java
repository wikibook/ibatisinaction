package org.apache.ibatis.jgamestore.presentation;

import org.apache.ibatis.jgamestore.domain.Cart;
import org.apache.ibatis.jgamestore.domain.CartItem;
import org.apache.ibatis.jgamestore.domain.Item;
import org.apache.ibatis.jgamestore.service.CatalogService;
import org.apache.ibatis.jgamestore.service.impl.CatalogServiceImpl;
import org.apache.struts.beanaction.ActionContext;
import org.jmock.Mock;
import org.jmock.cglib.MockObjectTestCase;

public class CartBeanTest extends MockObjectTestCase {

  public void testShouldSuccessfullyReturnFromViewCart() {
    Mock catalogServiceMock = mock(CatalogServiceImpl.class);
    CartBean bean = new CartBean((CatalogService) catalogServiceMock.proxy());
    assertEquals("success", bean.viewCart());
  }

  public void testShouldClearAllCartData() {
    Mock catalogServiceMock = mock(CatalogServiceImpl.class);
    CartBean bean = new CartBean((CatalogService) catalogServiceMock.proxy());
    Cart cart = new Cart();
    bean.setCart(cart);
    bean.setWorkingItemId("not null");
    bean.setPageDirection("not null");
    bean.clear();
    assertFalse(cart == bean.getCart());
    assertNull(bean.getWorkingItemId());
    assertNull(bean.getPageDirection());
  }

  public void testShouldAddItemToCart() {
    Mock catalogServiceMock = mock(CatalogServiceImpl.class);
    catalogServiceMock.expects(atLeastOnce())
        .method("isItemInStock")
        .with(NOT_NULL)
        .will(returnValue(true));
    Item item = new Item();
    item.setItemId("AnID");
    catalogServiceMock.expects(atLeastOnce())
        .method("getItem")
        .with(NOT_NULL)
        .will(returnValue(item));
    CartBean bean = new CartBean((CatalogService) catalogServiceMock.proxy());
    bean.setWorkingItemId("SomeItem");
    assertEquals("success", bean.addItemToCart());
    CartItem cartItem = (CartItem)bean.getCart().getCartItemList().get(0);
    assertEquals(1,cartItem.getQuantity());
    assertEquals("success", bean.addItemToCart());
    assertEquals(2,cartItem.getQuantity());
  }

  public void testShouldFailToRemoveItemFromCart() {
    Mock catalogServiceMock = mock(CatalogServiceImpl.class);
    CartBean bean = new CartBean((CatalogService) catalogServiceMock.proxy());
    bean.setWorkingItemId("nonexistant");
    assertEquals("failure", bean.removeItemFromCart());
  }

  public void testShouldRemoveItemFromCart() {
    Mock catalogServiceMock = mock(CatalogServiceImpl.class);
    catalogServiceMock.expects(atLeastOnce())
        .method("isItemInStock")
        .with(NOT_NULL)
        .will(returnValue(true));
    Item item = new Item();
    item.setItemId("AnID");
    catalogServiceMock.expects(atLeastOnce())
        .method("getItem")
        .with(NOT_NULL)
        .will(returnValue(item));
    CartBean bean = new CartBean((CatalogService) catalogServiceMock.proxy());
    bean.setWorkingItemId("AnID");
    bean.addItemToCart();
    assertEquals("success", bean.removeItemFromCart());
  }

  public void testShouldUpdateCartQuantities() {
    Mock catalogServiceMock = mock(CatalogServiceImpl.class);
    catalogServiceMock.expects(atLeastOnce())
        .method("isItemInStock")
        .with(NOT_NULL)
        .will(returnValue(true));
    Item item = new Item();
    item.setItemId("AnID");
    catalogServiceMock.expects(atLeastOnce())
        .method("getItem")
        .with(NOT_NULL)
        .will(returnValue(item));
    CartBean bean = new CartBean((CatalogService) catalogServiceMock.proxy());
    bean.setWorkingItemId("AnID");
    bean.addItemToCart();

    ActionContext.getActionContext().getParameterMap().put("AnID", "5");

    assertEquals("success", bean.updateCartQuantities());
    CartItem cartItem = (CartItem)bean.getCart().getCartItemList().get(0);
    assertEquals(5,cartItem.getQuantity());
  }


}
