package org.apache.ibatis.jgamestore.service;

import org.apache.ibatis.jgamestore.domain.Account;

public interface AccountService {

    public abstract Account getAccount(String username);

    public abstract Account getAccount(String username, String password);

    public abstract void insertAccount(Account account);

    public abstract void updateAccount(Account account);

}