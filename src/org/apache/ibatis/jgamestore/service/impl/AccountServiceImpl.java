package org.apache.ibatis.jgamestore.service.impl;

import org.apache.ibatis.jgamestore.domain.Account;
import org.apache.ibatis.jgamestore.persistence.DaoConfig;
import org.apache.ibatis.jgamestore.persistence.iface.AccountDao;
import org.apache.ibatis.jgamestore.service.AccountService;

import com.ibatis.dao.client.DaoManager;

public class AccountServiceImpl implements AccountService {

  private AccountDao accountDao;

  public AccountServiceImpl() {
    DaoManager daoMgr = DaoConfig.getDaoManager();
    this.accountDao = (AccountDao) daoMgr.getDao(AccountDao.class);
  }

  public AccountServiceImpl(AccountDao accountDao) {
    this.accountDao = accountDao;
  }

  /* (non-Javadoc)
 * @see org.apache.ibatis.jgamestore.service.impl.IAccountService#getAccount(java.lang.String)
 */
public Account getAccount(String username) {
    return accountDao.getAccount(username);
  }

  /* (non-Javadoc)
 * @see org.apache.ibatis.jgamestore.service.impl.IAccountService#getAccount(java.lang.String, java.lang.String)
 */
public Account getAccount(String username, String password) {
    return accountDao.getAccount(username, password);
  }

  /* (non-Javadoc)
 * @see org.apache.ibatis.jgamestore.service.impl.IAccountService#insertAccount(org.apache.ibatis.jgamestore.domain.Account)
 */
public void insertAccount(Account account) {
    accountDao.insertAccount(account);
  }

  /* (non-Javadoc)
 * @see org.apache.ibatis.jgamestore.service.impl.IAccountService#updateAccount(org.apache.ibatis.jgamestore.domain.Account)
 */
public void updateAccount(Account account) {
    accountDao.updateAccount(account);
  }

}
