package org.apache.ibatis.jgamestore.presentation;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.jgamestore.domain.Category;
import org.apache.ibatis.jgamestore.domain.Item;
import org.apache.ibatis.jgamestore.domain.Product;
import org.apache.ibatis.jgamestore.domain.ProductSearchCriteria;
import org.apache.ibatis.jgamestore.service.CatalogService;
import org.apache.ibatis.jgamestore.service.ServiceFactory;
import org.apache.struts.beanaction.BeanActionException;

import com.ibatis.common.util.PaginatedList;

public class CatalogBean extends AbstractBean {

  private static final Log log = LogFactory.getLog(CatalogBean.class);
  
  private static final String ADVANCED_SEARCH = "a";
  private static final String STANDARD_SEARCH = "s";
    
  private CatalogService catalogService;

  private String searchLevel;
  
  private String keyword;
  private String pageDirection;

  private String categoryId;
  private Category category;
  private PaginatedList categoryList;
  private List dropDownCategoryList;
  
  private String productId;
  private Product product;
  private PaginatedList productList;
  private List newestProductList;

  private String itemId;
  private Item item;
  private PaginatedList itemList;
  
  private ProductSearchCriteria productSearch;
  
  public CatalogBean() {
    this((CatalogService)ServiceFactory.getInstance().getService(CatalogService.class));
    this.category = new Category();
    this.product = new Product();
    this.item = new Item();
    this.productSearch = new ProductSearchCriteria();
  }

  public CatalogBean(CatalogService catalogService) {
    this.catalogService = catalogService;
  }

  public String getKeyword() {
    return keyword;
  }

  public void setKeyword(String keyword) {
    this.keyword = keyword;
  }

  public String getPageDirection() {
    return pageDirection;
  }

  public void setPageDirection(String pageDirection) {
    this.pageDirection = pageDirection;
  }

  public String getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(String categoryId) {
    this.categoryId = categoryId;
  }

  public String getProductId() {
    return productId;
  }

  public void setProductId(String productId) {
    this.productId = productId;
  }

  public String getItemId() {
    return itemId;
  }

  public void setItemId(String itemId) {
    this.itemId = itemId;
  }

  public Category getCategory() {
    return category;
  }

  public void setCategory(Category category) {
    this.category = category;
  }

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  public Item getItem() {
    return item;
  }

  public void setItem(Item item) {
    this.item = item;
  }

  public PaginatedList getCategoryList() {
    return categoryList;
  }

  public void setCategoryList(PaginatedList categoryList) {
    this.categoryList = categoryList;
  }

  public PaginatedList getProductList() {
    return productList;
  }

  public void setProductList(PaginatedList productList) {
    this.productList = productList;
  }

  public PaginatedList getItemList() {
    return itemList;
  }

  public void setItemList(PaginatedList itemList) {
    this.itemList = itemList;
  }

  public List getNewestProductList() {
      return newestProductList;
  }

  public void setNewestProductList(List newestProductList) {
      this.newestProductList = newestProductList;
  }

  public String getSearchLevel() {
      return searchLevel;
  }

  public void setSearchLevel(String searchLevel) {
      this.searchLevel = searchLevel;
  }
  
  public List getDropDownCategoryList() {
    return dropDownCategoryList;
  }

  public void setDropDownCategoryList(List dropDownCategoryList) {
    this.dropDownCategoryList = dropDownCategoryList;
  }
  
  public ProductSearchCriteria getProductSearch() {
    return productSearch;
  }

  public void setProductSearch(ProductSearchCriteria productSearch) {
    this.productSearch = productSearch;
  }
  
  public String index() {
    newestProductList = catalogService.getNewestProductList();
    this.categoryId="";
    return SUCCESS;
  }

  public String advancedSearch() {
    dropDownCategoryList = catalogService.getCategoryList();
    return SUCCESS;
  }
  
  public String viewCategory() {
    if (categoryId != null) {
      productList = catalogService.getProductListByCategory(categoryId);
      category = catalogService.getCategory(categoryId);
    }
    return SUCCESS;
  }

  public String viewProduct() {
    if (productId != null) {
      itemList = catalogService.getItemListByProduct(productId);
      product = catalogService.getProduct(productId);
      category = catalogService.getCategory(product.getCategoryId());
      categoryId = category.getCategoryId();
    }
    return SUCCESS;
  }

  public String viewItem() {
    item = catalogService.getItem(itemId);
    product = item.getProduct();
    return SUCCESS;
  }

  public String searchProducts() 
  { 
    boolean success = true;
    
    if(STANDARD_SEARCH.equals(searchLevel))
    {
      if (keyword == null || keyword.length() < 1) 
      {
        setMessage("Please enter a keyword to search for, then press the search button.");
      } 
      else 
      {
        productList = 
            catalogService.searchProductList(keyword.toLowerCase());
      }
    } 
    else if (ADVANCED_SEARCH.equals(searchLevel)) 
    {
        productList = 
            catalogService.searchProductList(productSearch);
    } 
    else
    {
        success = false;
    }
    
    if(success) {
        return SUCCESS;
    }
    else
    {
      throw new BeanActionException("Search Level Was Not Found");
    }
  }

  public String switchProductListPage() {
    if ("next".equals(pageDirection)) {
      productList.nextPage();
    } else if ("previous".equals(pageDirection)) {
      productList.previousPage();
    }
    return SUCCESS;
  }

  public String switchItemListPage() {
    if ("next".equals(pageDirection)) {
      itemList.nextPage();
    } else if ("previous".equals(pageDirection)) {
      itemList.previousPage();
    }
    return SUCCESS;
  }

  public void clear () {
    keyword = null;
    pageDirection = null;

    categoryId = null;
    category = new Category();
    categoryList = null;

    productId = null;
    product = new Product();
    productList = null;

    itemId = null;
    item = new Item();
    itemList = null;
  }
  
  public void reset() {
    productSearch = new ProductSearchCriteria();
  }
  
  /*
   * HACK FOR JSP JSTL. GACK!!!
   */

  public boolean isCategoryListFirstPage() {
      return categoryList.isFirstPage();
  }
  
  public boolean isCategoryListLastPage() {
      return categoryList.isLastPage();
  }

  public boolean isItemListFirstPage() {
      return itemList.isFirstPage();
  }
  
  public boolean isItemListLastPage() {
      return itemList.isLastPage();
  }

  public boolean isProductListFirstPage() {
      return productList.isFirstPage();
  }
  
  public boolean isProductListLastPage() {
      return productList.isLastPage();
  }

}
