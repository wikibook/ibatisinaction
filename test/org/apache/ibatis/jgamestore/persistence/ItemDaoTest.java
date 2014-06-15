package org.apache.ibatis.jgamestore.persistence;

import org.apache.ibatis.jgamestore.domain.DomainFixture;
import org.apache.ibatis.jgamestore.domain.Item;
import org.apache.ibatis.jgamestore.domain.LineItem;
import org.apache.ibatis.jgamestore.domain.Order;
import org.apache.ibatis.jgamestore.persistence.iface.ItemDao;


public class ItemDaoTest extends BasePersistenceTest {

  private static final String MUTABLE_ITEM_ID = "007-PS2";
  private static final String READ_ONLY_ITEM_ID = "007-XBOX";
  private static final String PRODUCT_ID = "AA-01";

  private ItemDao itemDao = (ItemDao) daoMgr.getDao(ItemDao.class);

  public void testShouldFindItemByID() {
    assertNotNull(itemDao.getItem(READ_ONLY_ITEM_ID));
  }

  public void testShouldListTwoItemsForGivenProduct() {
    assertEquals(2, itemDao.getItemListByProduct(PRODUCT_ID).size());
  }

  public void testShouldVerifyItemIsInStock() {
    assertTrue("Expected item to be in stock.", itemDao.isItemInStock(READ_ONLY_ITEM_ID));
  }

  public void testShouldVerifyItemIsOutOfStock() {
    Order order = DomainFixture.newTestOrder();
    itemDao.updateAllQuantitiesFromOrder(order);
    assertFalse("Expected item to be out of stock.", itemDao.isItemInStock(MUTABLE_ITEM_ID));
  }

  public void testShouldUpdateInventoryForItem() {
    Item item = itemDao.getItem(MUTABLE_ITEM_ID);
    int inventory = item.getQuantity();
    Order order = DomainFixture.newTestOrder();
    inventory -= ((LineItem)order.getLineItems().get(0)).getQuantity();
    itemDao.updateAllQuantitiesFromOrder(order);
    item = itemDao.getItem(MUTABLE_ITEM_ID);
    assertEquals(inventory, item.getQuantity());
  }

}
