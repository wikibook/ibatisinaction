package org.apache.ibatis.jgamestore.persistence;

import org.apache.ibatis.jgamestore.persistence.iface.ProductDao;

public class ProductDaoTest extends BasePersistenceTest {

  private ProductDao productDao = (ProductDao)daoMgr.getDao(ProductDao.class);

  public void testShouldFindSpecificProductByID() {
    assertNotNull(productDao.getProduct("AA-01"));
  }

  public void testShouldListProductsForACategory() {
    assertEquals(4, productDao.getProductListByCategory("SPORTS").size());
  }

  public void testShouldListNewProducts() {
    assertEquals(5, productDao.getNewestProductList().size());
  }
  
  public void testShouldFindAllProductsContainingKeyword() {
    assertEquals(1, productDao.searchProductList("snow").size());
  }

}
