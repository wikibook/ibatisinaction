package org.apache.ibatis.jgamestore.persistence.iface;

import java.util.List;

import org.apache.ibatis.jgamestore.domain.Product;
import org.apache.ibatis.jgamestore.domain.ProductSearchCriteria;

import com.ibatis.common.util.PaginatedList;

public interface ProductDao {

  PaginatedList getProductListByCategory(String categoryId);
  
  List getNewestProductList();

  Product getProduct(String productId);

  PaginatedList searchProductList(String keywords);
  
  PaginatedList searchProductList(ProductSearchCriteria productSearch);

}
