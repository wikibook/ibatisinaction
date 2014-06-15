package org.apache.ibatis.jgamestore.service;

import org.apache.ibatis.jgamestore.domain.DomainFixture;
import org.apache.ibatis.jgamestore.domain.Order;
import org.apache.ibatis.jgamestore.persistence.iface.ItemDao;
import org.apache.ibatis.jgamestore.persistence.iface.OrderDao;
import org.apache.ibatis.jgamestore.persistence.iface.SequenceDao;
import org.apache.ibatis.jgamestore.service.impl.OrderServiceImpl;
import org.jmock.Mock;
import org.jmock.MockObjectTestCase;

import com.ibatis.common.util.PaginatedArrayList;
import com.ibatis.dao.client.DaoManager;

public class OrderServiceTest extends MockObjectTestCase {

  public void testShouldCallGetOrderOnOrderDao() {

    Mock orderDao = mock(OrderDao.class);
    orderDao.expects(once())
        .method("getOrder")
        .with(NOT_NULL)
        .will(returnValue(new Order()));

    Mock daoManager = mock(DaoManager.class);
    daoManager.expects(once())
        .method("startTransaction")
        .withNoArguments();

    daoManager.expects(once())
        .method("commitTransaction")
        .withNoArguments();

    daoManager.expects(once())
        .method("endTransaction")
        .withNoArguments();

    OrderService service = new OrderServiceImpl((DaoManager)daoManager.proxy(), null, (OrderDao) orderDao.proxy(), null);
    service.getOrder(1);

  }

  public void testShouldCallGetOrdersByUsernameOnOrderDao() {
    Mock orderDao = mock(OrderDao.class);
    orderDao.expects(once())
        .method("getOrdersByUsername")
        .with(NOT_NULL)
        .will(returnValue(new PaginatedArrayList(5)));
    OrderService service = new OrderServiceImpl(null, null, (OrderDao) orderDao.proxy(), null);
    service.getOrdersByUsername("j2ee");
  }

  public void testShouldCallInsertOrderOnOrderDao() {

    Mock seqDao = mock(SequenceDao.class);
    seqDao.expects(once())
        .method("getNextId")
        .with(NOT_NULL)
        .will(returnValue(1));

    Mock orderDao = mock(OrderDao.class);
    orderDao.expects(once())
        .method("insertOrder")
        .with(NOT_NULL);

    Mock itemDao = mock(ItemDao.class);
    itemDao.expects(once())
        .method("updateAllQuantitiesFromOrder")
        .with(NOT_NULL);

    Mock daoManager = mock(DaoManager.class);
    daoManager.expects(once())
        .method("startTransaction")
        .withNoArguments();

    daoManager.expects(once())
        .method("commitTransaction")
        .withNoArguments();

    daoManager.expects(once())
        .method("endTransaction")
        .withNoArguments();

    OrderService service = new OrderServiceImpl((DaoManager)daoManager.proxy(), (ItemDao) itemDao.proxy(), (OrderDao) orderDao.proxy(), (SequenceDao) seqDao.proxy());
    service.insertOrder(DomainFixture.newTestOrder());

  }

  public void testShouldCallGetNextIdOnSequenceDao() {

    Mock seqDao = mock(SequenceDao.class);
    seqDao.expects(once())
        .method("getNextId")
        .with(NOT_NULL)
        .will(returnValue(1));

    OrderService service = new OrderServiceImpl(null, null, null, (SequenceDao) seqDao.proxy());
    service.getNextId("ordernum");

  }

}
