package org.apache.ibatis.jgamestore.presentation;


import org.apache.ibatis.jgamestore.service.impl.AccountServiceImpl;
import org.apache.ibatis.jgamestore.service.impl.OrderServiceImpl;
import org.jmock.cglib.MockObjectTestCase;

public class OrderBeanTest extends MockObjectTestCase {

  public void testFoo() {
    OrderBean bean = new OrderBean(new AccountServiceImpl(), new OrderServiceImpl());
  }

}
