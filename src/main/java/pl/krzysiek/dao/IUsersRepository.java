package pl.krzysiek.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.krzysiek.domain.Users;

import java.util.List;

@Repository
public interface IUsersRepository extends CrudRepository<Users, Integer> {

    Users findById(int id);
}
