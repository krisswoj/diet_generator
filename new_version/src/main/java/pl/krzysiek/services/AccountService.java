package pl.krzysiek.services;

import pl.krzysiek.domain.Account;

import java.util.List;


public interface AccountService {

    public List<Account> findAll();
    public void addAccount(Account acc);
    public Account getById(int id);
    public Integer checkNickExists(String name);
    public int checkPassword(String email, String password);
    public Integer checkEmailExists(String email);
    public Account findUserByEmail(Account account);
}
