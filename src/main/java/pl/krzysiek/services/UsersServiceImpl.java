package pl.krzysiek.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.krzysiek.dao.IUsersRepository;
import pl.krzysiek.domain.Users;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
@Transactional
public class UsersServiceImpl {

    @Autowired
    private IUsersRepository usersRepository;

    public Users saveUser(Users users){
        return usersRepository.save(users);
    }

    public Users findById(int id){
        return usersRepository.findById(id);
    }

    public List<Users> getAll(){
        return (List<Users>) usersRepository.findAll();
    }

    public Users updateUser(Users users){
        return usersRepository.save(users);
    }

    public void deleteUser(Users users){
        usersRepository.delete(users);
    }
}
