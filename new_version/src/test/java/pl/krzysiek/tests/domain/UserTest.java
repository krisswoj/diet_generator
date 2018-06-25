package pl.krzysiek.tests.domain;


import org.junit.Test;
import org.junit.Before;
import pl.krzysiek.domain.User;
import pl.krzysiek.repository.UserFactory;
import pl.krzysiek.repository.UserRepository;

import static org.junit.Assert.*;


import java.sql.SQLException;

public class UserTest {

    UserRepository userRepository;


    @Test
    public void czyZapisano() {
        User zapis = new User();
        assertNotNull(zapis);
    }

    @Test
    public void getById() throws SQLException {
        int idToFind = userRepository.getAll().size() - 1;
        assertNotNull(userRepository.getById(idToFind));
    }

    @Test
    public void addZawodyZapis() throws SQLException {
        User nowyZawodnik = new User();
        nowyZawodnik.setName("Krzysztof xgfhcjgkhl");
        nowyZawodnik.setAge(23);
        userRepository.addUser(nowyZawodnik);
        assertNotNull(userRepository.getById(userRepository.getAll().size() - 1));
    }


//    @Test
//    public void deleteZawodyZapis() throws SQLException {
//
//        int idPierwszegoZawodnika = userRepository.getById(userRepository.getAll().size()-2).getId();
//        int idDrugiegoZawodnika = userRepository.getById(userRepository.getAll().size()-3).getId();
//
//        assertThat(userRepository.getById(idPierwszegoZawodnika), not(equalTo(null)));
//
//        int wiekDrugiegoZawodnika = userRepository.getById(idDrugiegoZawodnika).getAge();
//
//        userRepository.deleteUser(idPierwszegoZawodnika);
//
//        assertNull(userRepository.getById(idPierwszegoZawodnika));
//        assertEquals(userRepository.getById(idDrugiegoZawodnika).getAge(), wiekDrugiegoZawodnika);
//    }

    @Test
    public void updateZawodyZapis() throws SQLException {


        int idPierwszegoZawodnika = userRepository.getById(userRepository.getAll().size() - 2).getId();
        int idDrugiegoZawodnika = userRepository.getById(userRepository.getAll().size() - 3).getId();
        int wiekDrugiegoZawodnika = userRepository.getById(idDrugiegoZawodnika).getAge();

        User newAgeForPierwszyZawodnik = new User();
        newAgeForPierwszyZawodnik.setName("new age for test1");
        newAgeForPierwszyZawodnik.setAge(666);

        userRepository.updateUser(idPierwszegoZawodnika, newAgeForPierwszyZawodnik);

        assertEquals(userRepository.getById(idPierwszegoZawodnika).getAge(), newAgeForPierwszyZawodnik.getAge());
        assertEquals(userRepository.getById(idDrugiegoZawodnika).getAge(), wiekDrugiegoZawodnika);
    }


    @Test
    public void getAll() {
        assertNotNull(userRepository.getAll());
    }

    @Before
    public void inicjacjaRepository() {
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

//    @After
//    public void dropTable() throws SQLException{
//        userRepository.dropTable();
//    }
}