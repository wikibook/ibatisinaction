package org.apache.ibatis.jgamestore.service;

import java.util.ArrayList;

import org.apache.ibatis.jgamestore.domain.Category;
import org.apache.ibatis.jgamestore.domain.Item;
import org.apache.ibatis.jgamestore.domain.Product;
import org.apache.ibatis.jgamestore.persistence.iface.CategoryDao;
import org.apache.ibatis.jgamestore.persistence.iface.ItemDao;
import org.apache.ibatis.jgamestore.persistence.iface.ProductDao;
import org.apache.ibatis.jgamestore.service.impl.CatalogServiceImpl;
import org.jmock.Mock;
import org.jmock.MockObjectTestCase;

import com.ibatis.common.util.PaginatedArrayList;

public class CatalogServiceTest extends MockObjectTestCase {

  public void testShouldCallGetCategoryOnCategoryDao() {

    Mock mock = mock(CategoryDao.class);

    mock.expects(once())
        .method("getCategory")
        .with(NOT_NULL)
        .will(returnValue(new Category()));

    CatalogService service = new CatalogServiceImpl((CategoryDao) mock.proxy(), null, null);
    service.getCategory("SPORTS");

  }

  public void testShouldCallGetCategoryListOnCategoryDao() {

    Mock mock = mock(CategoryDao.class);

    mock.expects(once())
        .method("getCategoryList")
        .withNoArguments()
        .will(returnValue(new ArrayList()));

    CatalogService service = new CatalogServiceImpl((CategoryDao) mock.proxy(), null, null);
    service.getCategoryList();

  }

  public void testShouldCallGetItemOnItemDao() {
    Mock mock = mock(ItemDao.class);

    mock.expects(once())
        .method("getItem")
        .with(NOT_NULL)
        .will(returnValue(new Item()));

    CatalogService service = new CatalogServiceImpl(null, (ItemDao) mock.proxy(), null);
    service.getItem("EST-1");

  }

  public void testShouldCallGetItemListByProductOnItemDao() {

    Mock mock = mock(ItemDao.class);

    mock.expects(once())
        .method("getItemListByProduct")
        .with(NOT_NULL)
        .will(returnValue(new PaginatedArrayList(5)));

    CatalogService service = new CatalogServiceImpl(null, (ItemDao) mock.proxy(), null);
    service.getItemListByProduct("FI-SW-01");

  }

  public void testShouldCallGetProductOnProductDao() {

    Mock mock = mock(ProductDao.class);

    mock.expects(once())
        .method("getProduct")
        .with(NOT_NULL)
        .will(returnValue(new Product()));

    CatalogService service = new CatalogServiceImpl(null, null, (ProductDao) mock.proxy());
    service.getProduct("FI-SW-01");

  }

  public void testShouldCallGetProductListByCategoryOnProductDao() {

    Mock mock = mock(ProductDao.class);

    mock.expects(once())
        .method("getProductListByCategory")
        .with(NOT_NULL)
        .will(returnValue(new PaginatedArrayList(5)));

    CatalogService service = new CatalogServiceImpl(null, null, (ProductDao) mock.proxy());
    service.getProductListByCategory("SPORTS");

  }

  public void testShouldCallGetNewProductListOnProductDao() {

      Mock mock = mock(ProductDao.class);

      mock.expects(once())
          .method("getNewestProductList")
          .will(returnValue(new PaginatedArrayList(4)));

      CatalogService service = new CatalogServiceImpl(null, null, (ProductDao) mock.proxy());
      service.getNewestProductList();

    }
  
  public void testShouldFindProductIsInStock() {
    Mock mock = mock(ItemDao.class);

    mock.expects(once())
        .method("isItemInStock")
        .with(NOT_NULL)
        .will(returnValue(true));

    CatalogService service = new CatalogServiceImpl(null, (ItemDao) mock.proxy(), null);

    assertTrue("Expected item to be in stock.", service.isItemInStock("EST-1"));

  }

  public void testCallSearchProductsOnProductDao() {
    Mock mock = mock(ProductDao.class);

    mock.expects(once())
        .method("searchProductList")
        .with(NOT_NULL)
        .will(returnValue(new PaginatedArrayList(5)));

    CatalogService service = new CatalogServiceImpl(null, null, (ProductDao) mock.proxy());
    service.searchProductList("dog");

  }


}
