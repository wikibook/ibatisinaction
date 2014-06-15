package org.apache.ibatis.jgamestore.persistence;

import org.apache.ibatis.jgamestore.domain.Account;
import org.apache.ibatis.jgamestore.domain.DomainFixture;
import org.apache.ibatis.jgamestore.persistence.iface.AccountDao;


public class AccountDaoTest extends BasePersistenceTest {

  private AccountDao acctDao = (AccountDao)daoMgr.getDao(AccountDao.class);

  public void testShouldFindDefaultUserAccountByUsername () throws Exception {
    Account acct = acctDao.getAccount("j2ee");
    assertNotNull(acct);
  }

  public void testShouldFindDefaultUserAccountByUsernameAndPassword () throws Exception {
    Account acct = acctDao.getAccount("j2ee", "j2ee");
    assertNotNull(acct);
  }

  public void testShouldInsertNewAccount () throws Exception {
    Account acct = DomainFixture.newTestAccount();
    acctDao.insertAccount(acct);
    acct = acctDao.getAccount("cbegin");
    assertNotNull(acct);
  }

  public void testShouldUpdateAccountEmailAddress () throws Exception {
    String newEmail = "new@email.com";
    Account acct = acctDao.getAccount("j2ee");
    acct.setEmail(newEmail);
    acctDao.updateAccount(acct);
    acct = acctDao.getAccount("j2ee");
    assertNotNull(acct);
    assertEquals(newEmail,acct.getEmail());
  }

}
