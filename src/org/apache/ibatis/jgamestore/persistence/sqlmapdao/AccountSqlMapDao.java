package org.apache.ibatis.jgamestore.persistence.sqlmapdao;

import org.apache.ibatis.jgamestore.domain.Account;
import org.apache.ibatis.jgamestore.persistence.iface.AccountDao;

import com.ibatis.dao.client.DaoManager;

public class AccountSqlMapDao extends BaseSqlMapDao implements AccountDao {

  public AccountSqlMapDao(DaoManager daoManager) {
    super(daoManager);
  }

  public Account getAccount(String username) {
    return (Account) queryForObject("Account.getAccountByUsername", username);
  }

  public Account getAccount(String username, String password) {
    Account account = new Account();
    account.setUsername(username);
    account.setPassword(password);
    return (Account) queryForObject("Account.getAccountByUsernameAndPassword", account);
  }

  public void insertAccount(Account account) {
    update("Account.insertAccount", account);
    update("Account.insertProfile", account);
    update("Account.insertSignon", account);
  }

  public void updateAccount(Account account) {
    update("Account.updateAccount", account);
    update("Account.updateProfile", account);

    if (account.getPassword() != null && account.getPassword().length() > 0) {
      update("Account.updateSignon", account);
    }
  }


}
