package pl.krzysiek.services;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import pl.krzysiek.configuration.RestConfiguration;
import pl.krzysiek.configuration.RestInitializer;
import pl.krzysiek.configuration.SecurityConfiguration;
import pl.krzysiek.configuration.WebMvcConfig;
import pl.krzysiek.domain.Users;


import static org.junit.Assert.*;

@SpringBootTest(classes = {RestConfiguration.class, RestInitializer.class, SecurityConfiguration.class, WebMvcConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class, DbUnitTestExecutionListener.class})
//@Import(UsersServiceImpl.class)
public class UserDbunitTest {

    @Autowired
    private UsersServiceImpl userRepository;

    @Test
    @DatabaseSetup("ds-0.xml")
    @ExpectedDatabase(assertionMode = DatabaseAssertionMode.NON_STRICT, value = "ds-1.xml")
    public void testCreateRead() throws Exception {

        Users user = new Users("Arkadiusz", 29);
        userRepository.saveUser(user);
        assertEquals(userRepository.findById(user.getId()).getName(), "Arkadiusz");
    }


    @Test
    @DatabaseSetup("ds-0.xml")
    @ExpectedDatabase(assertionMode = DatabaseAssertionMode.NON_STRICT, value = "ds-2.xml")
    public void checkUpdate() throws Exception {

        Users user = userRepository.findById(1);
        assertNotSame(27, user.getAge());
        user.setAge(27);
        userRepository.updateUser(user);
        assertEquals(user.getAge(), 27);
    }

    @Test
    @DatabaseSetup("ds-0.xml")
    @ExpectedDatabase(assertionMode = DatabaseAssertionMode.NON_STRICT, value = "ds-3.xml")
    public void checkDelete() throws Exception {

        int userAmount = userRepository.getAll().size();
        Users users = userRepository.findById(userAmount - 1);

        userRepository.deleteUser(userRepository.findById(userAmount));
        userRepository.deleteUser(userRepository.findById(userAmount - 1));

        assertNotEquals(userAmount, userRepository.getAll().size());
        assertFalse(userRepository.getAll().contains(users));

    }
}
