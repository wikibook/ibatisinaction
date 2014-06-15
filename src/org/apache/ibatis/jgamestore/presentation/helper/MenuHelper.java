package org.apache.ibatis.jgamestore.presentation.helper;

import java.util.List;

import org.apache.ibatis.jgamestore.service.CatalogService;
import org.apache.ibatis.jgamestore.service.ServiceFactory;

public class MenuHelper {
    
    CatalogService catalogService;
    
    public MenuHelper()
    {
        this.catalogService = 
            (CatalogService)ServiceFactory
            .getInstance()
            .getService(CatalogService.class);
    }
    
    public MenuHelper(CatalogService catalogService) {
        this.catalogService = catalogService;
    }
    
    public List getCategoryList() {
        List categoryList = catalogService.getCategoryList();
        return categoryList;
    }

}
