package org.apache.ibatis.jgamestore.persistence;


import java.math.BigDecimal;

import org.apache.ibatis.jgamestore.domain.DomainFixture;
import org.apache.ibatis.jgamestore.domain.Order;
import org.apache.ibatis.jgamestore.persistence.iface.OrderDao;

public class OrderDaoTest extends BasePersistenceTest {

  private OrderDao orderDao = (OrderDao) daoMgr.getDao(OrderDao.class);

  private static final String USERNAME = "NewUsername";
  private static final String SEQUENCE_NAME = "ordernum";

  public void testShouldInsertNewOrderWithLineItems () {
    Order expected = DomainFixture.newTestOrder();
    int nextId = 900001;
    expected.setOrderId(nextId);
    orderDao.insertOrder(expected);
    Order actual = orderDao.getOrder(nextId);
    assertNotNull(actual);
    assertEquals(1, actual.getLineItems().size());
    assertEquals(new BigDecimal("99.99"), actual.getTotalPrice());
  }

  public void testShouldListASingleOrderForAUser () {
    Order expected = DomainFixture.newTestOrder();
    int nextId = 900002;
    expected.setOrderId(nextId);
    expected.setUsername(USERNAME);
    orderDao.insertOrder(expected);
    assertEquals(1, orderDao.getOrdersByUsername(USERNAME).size());
  }



}
