package org.apache.ibatis.jgamestore.service;


import org.apache.ibatis.jgamestore.domain.Account;
import org.apache.ibatis.jgamestore.domain.DomainFixture;
import org.apache.ibatis.jgamestore.persistence.iface.AccountDao;
import org.apache.ibatis.jgamestore.service.impl.AccountServiceImpl;
import org.jmock.Mock;
import org.jmock.MockObjectTestCase;

public class AccountServiceTest extends MockObjectTestCase {

  public void testShouldVerifyGetAccountIsCalledByUsername() {
    Mock mock = mock(AccountDao.class);

    mock.expects(once())
        .method("getAccount")
        .with(NOT_NULL)
        .will(returnValue(new Account()));

    AccountService accountService = new AccountServiceImpl((AccountDao) mock.proxy());
    accountService.getAccount("cbegin");
  }

  public void testShouldVerifyGetAccountIsCalledByUsernameAndPassword() {
    Mock mock = mock(AccountDao.class);

    mock.expects(once())
        .method("getAccount")
        .with(NOT_NULL, NOT_NULL)
        .will(returnValue(new Account()));

    AccountService accountService = new AccountServiceImpl((AccountDao) mock.proxy());
    accountService.getAccount("cbegin","PASSWORD");
  }

  public void testShouldVerifyInsertAccountIsCalled() {
    Mock mock = mock(AccountDao.class);

    mock.expects(once())
        .method("insertAccount")
        .with(NOT_NULL);

    AccountService accountService = new AccountServiceImpl((AccountDao) mock.proxy());
    accountService.insertAccount(DomainFixture.newTestAccount());
  }

  public void testShouldVerifyUpdateAccountIsCalled() {
    Mock mock = mock(AccountDao.class);

    mock.expects(once())
        .method("updateAccount")
        .with(NOT_NULL);

    AccountService accountService = new AccountServiceImpl((AccountDao) mock.proxy());
    accountService.updateAccount(DomainFixture.newTestAccount());
  }

}
