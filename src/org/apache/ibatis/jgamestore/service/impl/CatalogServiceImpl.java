package org.apache.ibatis.jgamestore.service.impl;

import java.util.List;

import org.apache.ibatis.jgamestore.domain.Category;
import org.apache.ibatis.jgamestore.domain.Item;
import org.apache.ibatis.jgamestore.domain.Product;
import org.apache.ibatis.jgamestore.domain.ProductSearchCriteria;
import org.apache.ibatis.jgamestore.persistence.DaoConfig;
import org.apache.ibatis.jgamestore.persistence.iface.CategoryDao;
import org.apache.ibatis.jgamestore.persistence.iface.ItemDao;
import org.apache.ibatis.jgamestore.persistence.iface.ProductDao;
import org.apache.ibatis.jgamestore.service.CatalogService;

import com.ibatis.common.util.PaginatedList;
import com.ibatis.dao.client.DaoManager;

public class CatalogServiceImpl implements CatalogService {

  private CategoryDao categoryDao;
  private ItemDao itemDao;
  private ProductDao productDao;

  public CatalogServiceImpl() {
    DaoManager daoManager = DaoConfig.getDaoManager();
    categoryDao = (CategoryDao) daoManager.getDao(CategoryDao.class);
    productDao = (ProductDao) daoManager.getDao(ProductDao.class);
    itemDao = (ItemDao) daoManager.getDao(ItemDao.class);
  }

  public CatalogServiceImpl(CategoryDao categoryDao, ItemDao itemDao, ProductDao productDao) {
    this.categoryDao = categoryDao;
    this.itemDao = itemDao;
    this.productDao = productDao;
  }

  /* (non-Javadoc)
 * @see org.apache.ibatis.jgamestore.service.impl.ICatalogService#getCategoryList()
 */
public List getCategoryList() {
    return categoryDao.getCategoryList();
  }

  /* (non-Javadoc)
 * @see org.apache.ibatis.jgamestore.service.impl.ICatalogService#getCategory(java.lang.String)
 */
public Category getCategory(String categoryId) {
    return categoryDao.getCategory(categoryId);
  }

  /* (non-Javadoc)
 * @see org.apache.ibatis.jgamestore.service.impl.ICatalogService#getProduct(java.lang.String)
 */
  public Product getProduct(String productId) {
    return productDao.getProduct(productId);
  }

  /* (non-Javadoc)
   * @see org.apache.ibatis.jgamestore.service.impl.ICatalogService#getProductListByCategory(java.lang.String)
   */
  public PaginatedList getProductListByCategory(String categoryId) {
    return productDao.getProductListByCategory(categoryId);
  }

  /* (non-Javadoc)
   * @see org.apache.ibatis.jgamestore.service.impl.ICatalogService#getProductListByCategory(java.lang.String)
   */
  public List getNewestProductList() {
    return productDao.getNewestProductList();
  }

  /* (non-Javadoc)
   * @see org.apache.ibatis.jgamestore.service.impl.ICatalogService#searchProductList(java.lang.String)
   */
  public PaginatedList searchProductList(String keywords) {
    return productDao.searchProductList(keywords);
  }

  /* (non-Javadoc)
   * @see org.apache.ibatis.jgamestore.service.impl.ICatalogService#searchProductList(java.lang.String)
   */
  public PaginatedList searchProductList(ProductSearchCriteria productSearch) {
    return productDao.searchProductList(productSearch);
  }
  
  
  /* (non-Javadoc)
   * @see org.apache.ibatis.jgamestore.service.impl.ICatalogService#getItemListByProduct(java.lang.String)
   */
  public PaginatedList getItemListByProduct(String productId) {
    return itemDao.getItemListByProduct(productId);
  }

  /* (non-Javadoc)
   * @see org.apache.ibatis.jgamestore.service.impl.ICatalogService#getItem(java.lang.String)
   */
  public Item getItem(String itemId) {
    return itemDao.getItem(itemId);
  }

  /* (non-Javadoc)
   * @see org.apache.ibatis.jgamestore.service.impl.ICatalogService#isItemInStock(java.lang.String)
   */
  public boolean isItemInStock(String itemId) {
    return itemDao.isItemInStock(itemId);
  }

}