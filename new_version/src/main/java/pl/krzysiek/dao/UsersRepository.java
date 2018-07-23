package pl.krzysiek.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.krzysiek.domain.Users;

import java.util.List;

public interface UsersRepository extends JpaRepository<Users, Integer> {
    List<Users> findByName(String name);

}
