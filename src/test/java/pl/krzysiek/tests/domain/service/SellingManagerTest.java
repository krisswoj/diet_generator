package pl.krzysiek.tests.domain.service;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestExecutionListeners;
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
import pl.krzysiek.domain.FoodIngredient;
import pl.krzysiek.domain.ReadyMeal;
import pl.krzysiek.domain.ReadyMealDetails;
import pl.krzysiek.services.FoodCreatorImpl;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;


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
public class SellingManagerTest {

	@Autowired
	private FoodCreatorImpl foodCreator;


	private final String NAME_1 = "Tomasz";
	private final String PASSWORD_1 = "testowe_haslo";


	@Test
	public void addClientCheck() {

		Account account = new Account();
		account.setName(NAME_1);
		account.setPassword(PASSWORD_1);

		foodCreator.addAccount(account);

		Account accountByName = foodCreator.findAccountByName(NAME_1);

		assertEquals(NAME_1, accountByName.getName());
		assertEquals(PASSWORD_1, accountByName.getPassword());

		accountByName.setName("Roman");
		foodCreator.updateClient(accountByName);
		assertEquals("Roman", foodCreator.findAccountByName(accountByName.getName()).getName());
	}

	@Test
    public void addNewMeal(){

        Account account = new Account();
        account.setName("Marek");
        account.setPassword("marekarek");
        foodCreator.addAccount(account);

		ReadyMeal readyMeal = new ReadyMeal();
		readyMeal.setTitle("Spaghetti Bolognese2");
		readyMeal.setReadyMealAccount(account);


        List<FoodIngredient> foodIngredientList = new ArrayList<>();
        foodIngredientList.add(new FoodIngredient(1, 66.0, 10.0, 12.0, "Makaron zbozowy"));
        foodIngredientList.add(new FoodIngredient(2, 2.0, 20.0, 20.0, "Mieso wolowe"));
        foodIngredientList.add(new FoodIngredient(3, 3.0, 4.0, 5.0, "Cebula"));
        foodIngredientList.add(new FoodIngredient(4, 10.0, 15.0, 20.0, "Sos pomidorowy"));

        List<ReadyMealDetails> readyMealDetailsList = new ArrayList<>();
        for(FoodIngredient foodIngredient : foodIngredientList){
        	readyMealDetailsList.add(new ReadyMealDetails(65.0, readyMeal, foodCreator.addNewIngredient(foodIngredient)));
		}

		readyMeal.setReadyMealReadyMealDetails(readyMealDetailsList);

        foodCreator.addNewReadMeal(readyMeal);

		assertEquals(foodCreator.findReadyMealByTitle("Spaghetti Bolognese2"), readyMeal);
		assertEquals(foodCreator.findReadyMealById(readyMeal.getMealId()).getReadyMealReadyMealDetails()
				.get(foodCreator.findReadyMealById(readyMeal.getMealId()).getReadyMealReadyMealDetails().size()-1).getReadyMealDetailsFoodIngredient(),
				foodIngredientList.get(foodIngredientList.size()-1));
    }

    @Test
	public void updateIngredient(){

		Account account = new Account();
		account.setName("Marek");
		account.setPassword("marekarek");
		foodCreator.addAccount(account);

		ReadyMeal readyMeal = new ReadyMeal();
		readyMeal.setTitle("Testowe danie");
		readyMeal.setReadyMealAccount(account);


		List<FoodIngredient> foodIngredientList = new ArrayList<>();
		foodIngredientList.add(new FoodIngredient(1, 66.0, 10.0, 12.0, "Makaron zbozowy"));
		foodIngredientList.add(new FoodIngredient(2, 2.0, 20.0, 20.0, "Mieso wolowe"));
		foodIngredientList.add(new FoodIngredient(3, 3.0, 4.0, 5.0, "Cebula"));
		foodIngredientList.add(new FoodIngredient(4, 10.0, 15.0, 20.0, "Sos pomidorowy"));

		List<ReadyMealDetails> readyMealDetailsList = new ArrayList<>();
		for(FoodIngredient foodIngredient : foodIngredientList){
			readyMealDetailsList.add(new ReadyMealDetails(65.0, readyMeal, foodCreator.addNewIngredient(foodIngredient)));
		}

		readyMeal.setReadyMealReadyMealDetails(readyMealDetailsList);

		foodCreator.addNewReadMeal(readyMeal);

		readyMeal.getReadyMealReadyMealDetails().get(readyMeal.getReadyMealReadyMealDetails().size()-1).setGramsPortion(70.0);

		foodCreator.updateReadyMeal(readyMeal);

		assertEquals(foodCreator.findReadyMealById(readyMeal.getMealId()).getReadyMealReadyMealDetails()
				.get(foodCreator.findReadyMealById(readyMeal.getMealId()).getReadyMealReadyMealDetails().size()-1).getGramsPortion(),
				(Double) 70.0);

	}

	@Test
	public void deleteIngredientFromMealList(){

		Account account = new Account();
		account.setName("Jarek");
		account.setPassword("jarekmarek");
		foodCreator.addAccount(account);

		ReadyMeal readyMeal = new ReadyMeal();
		readyMeal.setTitle("Schabowe");
		readyMeal.setReadyMealAccount(account);

		List<FoodIngredient> foodIngredientList = new ArrayList<>();
		foodIngredientList.add(new FoodIngredient(1, 66.0, 10.0, 12.0, "Makaron zbozowy"));
		foodIngredientList.add(new FoodIngredient(2, 2.0, 20.0, 20.0, "Mieso wolowe"));
		foodIngredientList.add(new FoodIngredient(3, 3.0, 4.0, 5.0, "Cebula"));
		foodIngredientList.add(new FoodIngredient(4, 10.0, 15.0, 20.0, "Sos pomidorowy"));

		List<ReadyMealDetails> readyMealDetailsList = new ArrayList<>();
		for(FoodIngredient foodIngredient : foodIngredientList){
			readyMealDetailsList.add(new ReadyMealDetails(65.0, readyMeal, foodCreator.addNewIngredient(foodIngredient)));
		}

		readyMeal.setReadyMealReadyMealDetails(readyMealDetailsList);
		foodCreator.addNewReadMeal(readyMeal);
		readyMeal.getReadyMealReadyMealDetails().remove(readyMeal.getReadyMealReadyMealDetails().size()-1);
		foodCreator.updateReadyMeal(readyMeal);

		assertNotSame(foodCreator.findReadyMealById(readyMeal.getMealId()).getReadyMealReadyMealDetails().size(), foodIngredientList.size());
	}
}
