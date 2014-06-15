package org.apache.ibatis.jgamestore.persistence.iface;

import org.apache.ibatis.jgamestore.domain.Account;

public interface AccountDao {

  Account getAccount(String username);

  Account getAccount(String username, String password);

  void insertAccount(Account account);

  void updateAccount(Account account);

}
