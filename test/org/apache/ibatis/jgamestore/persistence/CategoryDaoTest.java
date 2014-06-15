package org.apache.ibatis.jgamestore.persistence;

import org.apache.ibatis.jgamestore.persistence.iface.CategoryDao;

public class CategoryDaoTest extends BasePersistenceTest {

  private CategoryDao catDao = (CategoryDao)daoMgr.getDao(CategoryDao.class);

  public void testShouldVerifyCategoryListContainsFiveItems () {
    assertEquals(5, catDao.getCategoryList().size());
  }

  public void testShouldFindCategoryByID () {
    assertNotNull(catDao.getCategory("SPORTS"));
  }

}
