package org.apache.ibatis.jgamestore.persistence.iface;

import org.apache.ibatis.jgamestore.domain.Order;

import com.ibatis.common.util.PaginatedList;

public interface OrderDao {

  PaginatedList getOrdersByUsername(String username);

  Order getOrder(int orderId);

  void insertOrder(Order order);

}
