package pl.krzysiek.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.krzysiek.domain.Users;
import pl.krzysiek.domain.UsersContact;

public interface UsersContactRepository extends JpaRepository<UsersContact, Integer> {

    Users save(Users users);
}

