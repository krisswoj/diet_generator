package pl.krzysiek.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.krzysiek.domain.Account;

@Repository
public interface IAccountRepository extends CrudRepository<Account, Integer> {

    Account findById(long id);
    Account findByName(String nick);
    Account findByEmail(String email);


}