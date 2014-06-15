package org.apache.ibatis.jgamestore.persistence.sqlmapdao;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.apache.ibatis.jgamestore.domain.Product;
import org.apache.ibatis.jgamestore.domain.ProductSearchCriteria;
import org.apache.ibatis.jgamestore.persistence.iface.ProductDao;

import com.ibatis.common.util.PaginatedList;
import com.ibatis.dao.client.DaoManager;

public class ProductSqlMapDao extends BaseSqlMapDao implements ProductDao {

  public ProductSqlMapDao(DaoManager daoManager) {
    super(daoManager);
  }

  public PaginatedList getProductListByCategory(String categoryId) {
    return queryForPaginatedList("Product.getProductListByCategory", categoryId, PAGE_SIZE);
  }

  public List getNewestProductList() {
    return queryForList("Product.getNewestProductList", null);
  }
  
  public Product getProduct(String productId) {
    return (Product) queryForObject("Product.getProduct", productId);
  }

  public PaginatedList searchProductList(String keywords) {
    Object parameterObject = new KeywordSearchTokenizer(keywords);
    return queryForPaginatedList("Product.searchProducts", parameterObject, PAGE_SIZE);
  }

  public PaginatedList searchProductList(ProductSearchCriteria productSearch) {
    return queryForPaginatedList("Product.searchProductsWithProductSearch", productSearch, PAGE_SIZE);
  }

  public class KeywordSearchTokenizer {
      
    List keywordList = new ArrayList();

    public KeywordSearchTokenizer(String keywords) {
      StringTokenizer splitter = new StringTokenizer(keywords, " ", false);
      while (splitter.hasMoreTokens()) {
        keywordList.add("%" + splitter.nextToken() + "%");
      }
    }

    public List getKeywordList() {
      return keywordList;
    }
  }
  
}
