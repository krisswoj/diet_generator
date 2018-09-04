package pl.krzysiek.tests.domain;


import org.junit.After;
import org.junit.Test;
import org.junit.Before;
import pl.krzysiek.domain.User;
import pl.krzysiek.repository.UserFactory;
import pl.krzysiek.repository.UserRepository;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;


import java.sql.SQLException;

public class UserTest {

    UserRepository userRepository;

    @Test
    public void isSaved() {
        User user = new User();
        assertNotNull(user);
    }

    @Test
    public void getById() throws SQLException {
        int idToFind = userRepository.getAll().size() - 1;
        assertNotNull(userRepository.getById(idToFind));
    }

    @Test
    public void addUser() throws SQLException {
        User user = new User();
        user.setName("Krzysztof xgfhcjgkhl");
        user.setAge(23);
        int userId = userRepository.addUser(user);
        System.out.println("Wartosc userId: " + userId);
        assertNotNull(userRepository.getById(userRepository.getAll().size() - 1));
    }


    @Test
    public void deleteUser() throws SQLException {

        int userOne = userRepository.getById(userRepository.getAll().size()-2).getId();
        int userTwo = userRepository.getById(userRepository.getAll().size()-3).getId();

        assertThat(userRepository.getById(userOne), not(equalTo(null)));

        int ageUserTwo = userRepository.getById(userTwo).getAge();

        userRepository.deleteUser(userRepository.getById(userRepository.getAll().size()-2));

        assertEquals(userRepository.getById(userTwo).getAge(), ageUserTwo);
    }

    @Test
    public void updateUser() throws SQLException {


        User mainUser = new User("Szymek", 57);
        int idMainUser = userRepository.addUser(mainUser);
        User userToUpdate = new User("new age for test1", 666);

        int userAgeBeforeUpdate = mainUser.getAge();

        userRepository.updateUser(idMainUser, userToUpdate);
        User mainUserAfterupdate = userRepository.getById(idMainUser);

        assertNotEquals(userAgeBeforeUpdate, userToUpdate.getAge());
        assertEquals(mainUserAfterupdate.getAge(), userToUpdate.getAge());
    }


    @Test
    public void getAll() {
        assertNotNull(userRepository.getAll());
    }

    @Before
    public void createData() {
        userRepository = UserFactory.getInstance();
        User szymek = new User();
        User tomek = new User();
        User mateusz = new User();

        szymek.setName("Szymon");
        szymek.setAge(263);

        tomek.setName("Tomasz");
        tomek.setAge(11);

        mateusz.setName("Mateusz");
        mateusz.setAge(45);

        userRepository.addUser(szymek);
        userRepository.addUser(tomek);
        userRepository.addUser(mateusz);
        
    }

    @After
    public void dropTable() throws SQLException{
        userRepository.dropTable();
    }
}