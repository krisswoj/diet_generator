package pl.krzysiek.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.krzysiek.dao.IAccountRepository;
import pl.krzysiek.domain.Account;


import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class AccountService {


    @Autowired
    IAccountRepository accountRepository;

    public List<Account> findAll() {
        List<Account> retList = new ArrayList<>();
        for(Account acc : accountRepository.findAll()){
            retList.add(acc);
        }
        return retList;
    }

    public void addAccount(Account acc){
        accountRepository.save(acc);
    }

    public Account getById(long id){
        Account acc = accountRepository.findById(id);
        return acc;
    }

    public Integer checkNickExists(String name){
        String userId;
        try{
            Account account = accountRepository.findByName(name);
            userId = String.valueOf(account.getId());
        }
        catch (Exception ex){
            return 0;
        }
        return 1;
    }

    public Integer checkEmailExists(String email){
        String userId;
        try{
            Account account = accountRepository.findByEmail(email);
            userId = String.valueOf(account.getId());
        }
        catch (Exception ex){
            return 0;
        }
        return 1;
    }
}
