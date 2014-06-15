package org.apache.ibatis.jgamestore.presentation;

import org.apache.ibatis.jgamestore.domain.Category;
import org.apache.ibatis.jgamestore.domain.Item;
import org.apache.ibatis.jgamestore.domain.Product;
import org.apache.ibatis.jgamestore.service.CatalogService;
import org.apache.ibatis.jgamestore.service.impl.CatalogServiceImpl;
import org.jmock.Mock;
import org.jmock.cglib.MockObjectTestCase;

import com.ibatis.common.util.PaginatedArrayList;
import com.ibatis.common.util.PaginatedList;

public class CatalogBeanTest extends MockObjectTestCase {

  public void testShouldPopulateNewestProductsForViewing() 
  {
    Mock catalogServiceMock = mock(CatalogServiceImpl.class);
    catalogServiceMock.expects(once())
    .method("getNewestProductList")
    .will(returnValue(new PaginatedArrayList(4)));
    
    CatalogBean bean = new CatalogBean((CatalogService) catalogServiceMock.proxy());
    assertEquals("success", bean.index());
  }
    
    
  public void testShouldPopulateCategoryByIdForViewing() {
    Mock catalogServiceMock = mock(CatalogServiceImpl.class);
    catalogServiceMock.expects(once())
        .method("getCategory")
        .with(NOT_NULL)
        .will(returnValue(new Category()));
    catalogServiceMock.expects(once())
        .method("getProductListByCategory")
        .with(NOT_NULL)
        .will(returnValue(new PaginatedArrayList(4)));
    CatalogBean bean = new CatalogBean((CatalogService) catalogServiceMock.proxy());
    bean.setCategoryId("SPORTS");
    assertEquals("success", bean.viewCategory());
    assertNotNull(bean.getCategory());
    assertNotNull(bean.getProductList());
  }

  public void testShouldPopulateProductByIdForViewing() {
    Mock catalogServiceMock = mock(CatalogServiceImpl.class);
    
    Product prodX = new Product();
    prodX.setCategoryId("CATX");
    
    catalogServiceMock.expects(once())
        .method("getProduct")
        .with(NOT_NULL)
        .will(returnValue(prodX));
    
    catalogServiceMock.expects(once())
        .method("getItemListByProduct")
        .with(NOT_NULL)
        .will(returnValue(new PaginatedArrayList(4)));
    
    catalogServiceMock.expects(once())
        .method("getCategory")
        .with(NOT_NULL)
        .will(returnValue(new Category()));
    
    CatalogBean bean = new CatalogBean((CatalogService) catalogServiceMock.proxy());
    bean.setProductId("X");
    
    assertEquals("success", bean.viewProduct());
    assertNotNull(bean.getProduct());
    assertNotNull(bean.getItemList());
  }

  public void testShouldPopulateItemByIdForViewing() {
    Mock catalogServiceMock = mock(CatalogServiceImpl.class);
    catalogServiceMock.expects(once())
        .method("getItem")
        .with(NOT_NULL)
        .will(returnValue(new Item()));
    CatalogBean bean = new CatalogBean((CatalogService) catalogServiceMock.proxy());
    bean.setItemId("007-PS2");
    assertEquals("success", bean.viewItem());
    assertNotNull(bean.getItem());
  }

  public void testShouldReturnNullResults() {
    Mock catalogServiceMock = mock(CatalogServiceImpl.class);
    CatalogBean bean = new CatalogBean((CatalogService) catalogServiceMock.proxy());
    bean.setKeyword(null);
    bean.setSearchLevel("s");
    assertEquals("success", bean.searchProducts());
    assertNull(bean.getProductList());
  }

  public void testShouldSearchProductsByKeyword() {
    Mock catalogServiceMock = mock(CatalogServiceImpl.class);
    catalogServiceMock.expects(once())
        .method("searchProductList")
        .with(NOT_NULL)
        .will(returnValue(new PaginatedArrayList(4)));
    CatalogBean bean = new CatalogBean((CatalogService) catalogServiceMock.proxy());
    bean.setSearchLevel("s");
    bean.setKeyword("snow");
    assertEquals("success", bean.searchProducts());
    assertNotNull(bean.getProductList());
  }

  public void testShouldSwitchProductPageBackAndForth() {
    Mock catalogServiceMock = mock(CatalogServiceImpl.class);
    CatalogBean bean = new CatalogBean((CatalogService) catalogServiceMock.proxy());
    PaginatedList productList = new PaginatedArrayList(2);
    productList.add(new Product());
    productList.add(new Product());
    productList.add(new Product());
    productList.add(new Product());
    productList.add(new Product());
    bean.setProductList(productList);

    bean.setPageDirection("next");
    bean.switchProductListPage();
    assertEquals(1, productList.getPageIndex());
    bean.setPageDirection("previous");
    bean.switchProductListPage();
    assertEquals(0, productList.getPageIndex());
  }

  public void testShouldSwitchItemPageBackAndForth() {
    Mock catalogServiceMock = mock(CatalogServiceImpl.class);
    CatalogBean bean = new CatalogBean((CatalogService) catalogServiceMock.proxy());
    PaginatedList itemList = new PaginatedArrayList(2);
    itemList.add(new Item());
    itemList.add(new Item());
    itemList.add(new Item());
    itemList.add(new Item());
    itemList.add(new Item());
    bean.setItemList(itemList);

    bean.setPageDirection("next");
    assertEquals("success", bean.switchItemListPage());
    assertEquals(1, itemList.getPageIndex());
    bean.setPageDirection("previous");
    assertEquals("success", bean.switchItemListPage());
    assertEquals(0, itemList.getPageIndex());
  }

  public void testShouldClearCatalogBean() {
    Mock catalogServiceMock = mock(CatalogServiceImpl.class);
    CatalogBean bean = new CatalogBean((CatalogService) catalogServiceMock.proxy());
    bean.setKeyword("not null");
    bean.setPageDirection("not null");
    bean.setCategoryId("not null");
    bean.setProductId("not null");
    bean.setItemId("not null");
    bean.setCategory(new Category());
    bean.setProduct(new Product());
    bean.setItem(new Item());
    bean.setCategoryList(new PaginatedArrayList(2));
    bean.setProductList(new PaginatedArrayList(2));
    bean.setItemList(new PaginatedArrayList(2));
    bean.clear();
    assertNull(bean.getKeyword());
    assertNull(bean.getPageDirection());
    assertNull(bean.getCategoryId());
    assertNull(bean.getCategory().getCategoryId());
    assertNull(bean.getCategoryList());
    assertNull(bean.getProductId());
    assertNull(bean.getProduct().getProductId());
    assertNull(bean.getProductList());
    assertNull(bean.getItemId());
    assertNull(bean.getItem().getItemId());
    assertNull(bean.getItemList());
  }


}
