package pl.krzysiek.tests.domain.service;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;
import pl.krzysiek.domain.Account;
import pl.krzysiek.services.FoodCreator;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@Rollback
@Commit
@Transactional(transactionManager = "txManager")
@TestExecutionListeners({
    DependencyInjectionTestExecutionListener.class,
    DirtiesContextTestExecutionListener.class,
    TransactionalTestExecutionListener.class,
    DbUnitTestExecutionListener.class })
public class ReadyMealDBUnitTest {


	@Autowired
	FoodCreator foodCreator;

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
