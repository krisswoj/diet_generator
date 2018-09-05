package pl.krzysiek.services;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;
import pl.krzysiek.configuration.RestConfiguration;
import pl.krzysiek.configuration.RestInitializer;
import pl.krzysiek.configuration.SecurityConfiguration;
import pl.krzysiek.configuration.WebMvcConfig;
import pl.krzysiek.domain.Account;
import pl.krzysiek.services.FoodCreator;
import pl.krzysiek.services.FoodCreatorImpl;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {RestConfiguration.class, RestInitializer.class, SecurityConfiguration.class, WebMvcConfig.class})
@Rollback
@Commit
@Transactional
@TestExecutionListeners({
    DependencyInjectionTestExecutionListener.class,
    DirtiesContextTestExecutionListener.class,
    TransactionalTestExecutionListener.class,
    DbUnitTestExecutionListener.class })
@Import(FoodCreatorImpl.class)
public class ReadyMealDBUnitTest {

	@Autowired
	private FoodCreatorImpl foodCreator;

	@Test
	@DatabaseSetup("/fullData.xml")
	@ExpectedDatabase(value = "/addPersonData.xml", 
	assertionMode = DatabaseAssertionMode.NON_STRICT)
	public void getClientCheck() throws Exception {
	    assertEquals(2, foodCreator.getAllAccounts().size());
        
        Account a = new Account();
        a.setName("Krzysiek");
        a.setPassword("testowe_haslo");

        foodCreator.addAccount(a);
        assertEquals(3, foodCreator.getAllAccounts().size());

    }
}
