package org.apache.ibatis.jgamestore.persistence.iface;

import org.apache.ibatis.jgamestore.domain.Item;
import org.apache.ibatis.jgamestore.domain.Order;

import com.ibatis.common.util.PaginatedList;

public interface ItemDao {

  void updateAllQuantitiesFromOrder(Order order);

  boolean isItemInStock(String itemId);

  PaginatedList getItemListByProduct(String productId);

  Item getItem(String itemId);

}
