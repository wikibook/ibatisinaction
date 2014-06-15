package org.apache.ibatis.jgamestore.service;

import java.util.List;

import org.apache.ibatis.jgamestore.domain.Category;
import org.apache.ibatis.jgamestore.domain.Item;
import org.apache.ibatis.jgamestore.domain.Product;
import org.apache.ibatis.jgamestore.domain.ProductSearchCriteria;

import com.ibatis.common.util.PaginatedList;

public interface CatalogService {

    public abstract List getCategoryList();

    public abstract Category getCategory(String categoryId);

    public abstract Product getProduct(String productId);

    public abstract PaginatedList getProductListByCategory(String categoryId);

    public abstract List getNewestProductList();
    
    public abstract PaginatedList searchProductList(String keywords);
    
    public abstract PaginatedList searchProductList(ProductSearchCriteria productSearch);

    public abstract PaginatedList getItemListByProduct(String productId);

    public abstract Item getItem(String itemId);

    public abstract boolean isItemInStock(String itemId);

}