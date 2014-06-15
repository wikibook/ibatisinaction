package org.apache.ibatis.jgamestore.persistence;

import junit.framework.TestCase;

import com.ibatis.dao.client.DaoManager;

public class BasePersistenceTest extends TestCase {
  protected DaoManager daoMgr = PersistenceFixture.getDaoManager();

  public void testDummy() {
    //to avoid warnings
  }

}
