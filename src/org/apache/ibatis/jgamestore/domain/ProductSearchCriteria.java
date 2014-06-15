package org.apache.ibatis.jgamestore.domain;

public class ProductSearchCriteria {

    private String[] categoryIds = new String[]{};
    private String   productName;
    private String   productDescription;
    private String   itemName;
    private String   itemDescription;
    
    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public boolean isItemProperties() {
        return 
          (null != itemName &&  
          !itemName.trim().equals("")) || 
          (null != itemDescription && 
          !itemDescription.trim().equals(""));
    }
    
    public ProductSearchCriteria() {
    }
    
    public String[] getCategoryIds() {
        return categoryIds;
    }

    public void setCategoryIds(String[] categories) {
        this.categoryIds = categories;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

}
