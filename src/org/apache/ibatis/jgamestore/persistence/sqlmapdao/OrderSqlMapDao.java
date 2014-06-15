package org.apache.ibatis.jgamestore.persistence.sqlmapdao;

import org.apache.ibatis.jgamestore.domain.LineItem;
import org.apache.ibatis.jgamestore.domain.Order;
import org.apache.ibatis.jgamestore.persistence.iface.OrderDao;

import com.ibatis.common.util.PaginatedList;
import com.ibatis.dao.client.DaoManager;

public class OrderSqlMapDao extends BaseSqlMapDao implements OrderDao {

  public OrderSqlMapDao(DaoManager daoManager) {
    super(daoManager);
  }

  public PaginatedList getOrdersByUsername(String username) {
    return queryForPaginatedList("Order.getOrdersByUsername", username, 10);
  }

  public Order getOrder(int orderId) {
    Order order = null;
    Object parameterObject = new Integer(orderId);
    order = (Order) queryForObject("Order.getOrder", parameterObject);
    order.setLineItems(queryForList("LineItem.getLineItemsByOrderId", new Integer(order.getOrderId())));
    return order;
  }

  public void insertOrder(Order order) {
    insert("Order.insertOrder", order);
    insert("Order.insertOrderStatus", order);
    for (int i = 0; i < order.getLineItems().size(); i++) {
      LineItem lineItem = (LineItem) order.getLineItems().get(i);
      lineItem.setOrderId(order.getOrderId());
      insert("LineItem.insertLineItem", lineItem);
    }
  }

}
