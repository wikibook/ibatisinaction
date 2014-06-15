package org.apache.ibatis.jgamestore.service.impl;

import org.apache.ibatis.jgamestore.domain.LineItem;
import org.apache.ibatis.jgamestore.domain.Order;
import org.apache.ibatis.jgamestore.persistence.DaoConfig;
import org.apache.ibatis.jgamestore.persistence.iface.ItemDao;
import org.apache.ibatis.jgamestore.persistence.iface.OrderDao;
import org.apache.ibatis.jgamestore.persistence.iface.SequenceDao;
import org.apache.ibatis.jgamestore.service.OrderService;

import com.ibatis.common.util.PaginatedList;
import com.ibatis.dao.client.DaoManager;

public class OrderServiceImpl implements OrderService {

  private DaoManager daoManager;

  private ItemDao itemDao;
  private OrderDao orderDao;
  private SequenceDao sequenceDao;

  public OrderServiceImpl() {
    daoManager = DaoConfig.getDaoManager();
    itemDao = (ItemDao) daoManager.getDao(ItemDao.class);
    sequenceDao = (SequenceDao) daoManager.getDao(SequenceDao.class);
    orderDao = (OrderDao) daoManager.getDao(OrderDao.class);
  }

  public OrderServiceImpl(DaoManager daoManager, ItemDao itemDao, OrderDao orderDao, SequenceDao sequenceDao) {
    this.daoManager = daoManager;
    this.itemDao = itemDao;
    this.orderDao = orderDao;
    this.sequenceDao = sequenceDao;
  }

  /* (non-Javadoc)
 * @see org.apache.ibatis.jgamestore.service.impl.IOrderService#insertOrder(org.apache.ibatis.jgamestore.domain.Order)
 */
public void insertOrder(Order order) {
    try {
      // Get the next id within a separate transaction
      order.setOrderId(getNextId("ordernum"));

      daoManager.startTransaction();

      itemDao.updateAllQuantitiesFromOrder(order);
      orderDao.insertOrder(order);

      daoManager.commitTransaction();
    } finally {
      daoManager.endTransaction();
    }
  }

  /* (non-Javadoc)
 * @see org.apache.ibatis.jgamestore.service.impl.IOrderService#getOrder(int)
 */
public Order getOrder(int orderId) {
    Order order = null;

    try {
      daoManager.startTransaction();

      order = orderDao.getOrder(orderId);

      for (int i = 0; i < order.getLineItems().size(); i++) {
        LineItem lineItem = (LineItem) order.getLineItems().get(i);
        lineItem.setItem(itemDao.getItem(lineItem.getItemId()));
      }

      daoManager.commitTransaction();
    } finally {
      daoManager.endTransaction();
    }

    return order;
  }

  /* (non-Javadoc)
 * @see org.apache.ibatis.jgamestore.service.impl.IOrderService#getOrdersByUsername(java.lang.String)
 */
public PaginatedList getOrdersByUsername(String username) {
    return orderDao.getOrdersByUsername(username);
  }

  /* (non-Javadoc)
 * @see org.apache.ibatis.jgamestore.service.impl.IOrderService#getNextId(java.lang.String)
 */
public int getNextId(String key) {
    return sequenceDao.getNextId(key);
  }


}
