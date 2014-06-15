package org.apache.ibatis.jgamestore.persistence.sqlmapdao;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.jgamestore.domain.Item;
import org.apache.ibatis.jgamestore.domain.LineItem;
import org.apache.ibatis.jgamestore.domain.Order;
import org.apache.ibatis.jgamestore.persistence.iface.ItemDao;

import com.ibatis.common.util.PaginatedList;
import com.ibatis.dao.client.DaoManager;

public class ItemSqlMapDao extends BaseSqlMapDao implements ItemDao {

  public ItemSqlMapDao(DaoManager daoManager) {
    super(daoManager);
  }

  public void updateAllQuantitiesFromOrder(Order order) {
    for (int i = 0; i < order.getLineItems().size(); i++) {
      LineItem lineItem = (LineItem) order.getLineItems().get(i);
      String itemId = lineItem.getItemId();
      Integer increment = new Integer(lineItem.getQuantity());
      Map param = new HashMap(2);
      param.put("itemId", itemId);
      param.put("increment", increment);
      update("Item.updateInventoryQuantity", param);
    }
  }

  public boolean isItemInStock(String itemId) {
    Integer i = (Integer) queryForObject("Item.getInventoryQuantity", itemId);
    return (i != null && i.intValue() > 0);
  }

  public PaginatedList getItemListByProduct(String productId) {
    return queryForPaginatedList("Item.getItemListByProduct", productId, PAGE_SIZE);
  }

  public Item getItem(String itemId) {
    Integer i = (Integer) queryForObject("Item.getInventoryQuantity", itemId);
    Item item = (Item) queryForObject("Item.getItem", itemId);
    item.setQuantity(i.intValue());
    return item;
  }

}
