package pl.krzysiek.tests.domain.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import pl.krzysiek.domain.Account;
import pl.krzysiek.domain.FoodIngredient;
import pl.krzysiek.domain.ReadyMeal;
import pl.krzysiek.domain.ReadyMealDetails;
import pl.krzysiek.services.AccountService;
import pl.krzysiek.services.FoodCreator;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

//@Ignore

@RunWith(SpringJUnit4ClassRunner.class)
@Rollback
@Commit
@Transactional(transactionManager = "txManager")
public class SellingManagerTest {

	@Autowired
	FoodCreator foodCreator;


	private final String NAME_1 = "Krzysiek";
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
		readyMeal.setTitle("Testowe danie");
		readyMeal.setReadyMealAccount(account);
        foodCreator.addNewReadMeal(readyMeal);

        List<FoodIngredient> foodIngredientList = new ArrayList<>();
        foodIngredientList.add(new FoodIngredient(1, 66.0, 10.0, 12.0, "Makaron zbozowy"));
        foodIngredientList.add(new FoodIngredient(2, 2.0, 20.0, 20.0, "Mieso wolowe"));
        foodIngredientList.add(new FoodIngredient(3, 3.0, 4.0, 5.0, "Cebula"));
        foodIngredientList.add(new FoodIngredient(4, 10.0, 15.0, 20.0, "Sos pomidorowy"));

        for(FoodIngredient foodIngredient : foodIngredientList){
        	foodCreator.addNewIngredient(foodIngredient);
        	foodCreator.addNewReadMealDetails(new ReadyMealDetails(55.0, readyMeal, foodIngredient));
		}

		assertEquals(foodCreator.findReadyMealDeatilsById(readyMeal.getMealId()).get(foodCreator.findReadyMealDeatilsById(readyMeal.getMealId()).size()-1).getReadyMealDetailsFoodIngredient().getName(), foodIngredientList.get(foodIngredientList.size()-1).getName());
		assertEquals(foodCreator.findReadyMealByTitle("Testowe danie"), readyMeal);
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
		foodCreator.addNewReadMeal(readyMeal);

		List<FoodIngredient> foodIngredientList = new ArrayList<>();
		foodIngredientList.add(new FoodIngredient(1, 66.0, 10.0, 12.0, "Makaron zbozowy"));
		foodIngredientList.add(new FoodIngredient(2, 2.0, 20.0, 20.0, "Mieso wolowe"));
		foodIngredientList.add(new FoodIngredient(3, 3.0, 4.0, 5.0, "Cebula"));
		foodIngredientList.add(new FoodIngredient(4, 10.0, 15.0, 20.0, "Sos pomidorowy"));

		List<ReadyMealDetails> readyMealDetailsList = new ArrayList<>();
		for(FoodIngredient foodIngredient : foodIngredientList){
			foodCreator.addNewIngredient(foodIngredient);
			foodCreator.addNewReadMealDetails(new ReadyMealDetails(55.0, readyMeal, foodIngredient));
			readyMealDetailsList.add(new ReadyMealDetails(55.0, readyMeal, foodIngredient));
		}

		ReadyMealDetails readyMealDetailsToUpdate = readyMealDetailsList.get(readyMealDetailsList.size()-1);
		readyMealDetailsToUpdate.setGramsPortion(70.0);

		foodCreator.updateReadyMealsDetails(readyMealDetailsToUpdate);

		assertEquals(foodCreator.findReadyMealDeatilsById(readyMeal.getMealId()).get(foodCreator.findReadyMealDeatilsById(readyMeal.getMealId()).size()-1).getGramsPortion(), (Integer) 70);
	}

	@Test
	public void deleteIngredientFromMealList(){

		Account account = new Account();
		account.setName("Marek");
		account.setPassword("marekarek");
		foodCreator.addAccount(account);
		ReadyMeal readyMeal = new ReadyMeal();
		readyMeal.setTitle("Testowe danie");
		readyMeal.setReadyMealAccount(account);
		foodCreator.addNewReadMeal(readyMeal);

		List<FoodIngredient> foodIngredientList = new ArrayList<>();
		foodIngredientList.add(new FoodIngredient(1, 66.0, 10.0, 12.0, "Makaron zbozowy"));
		foodIngredientList.add(new FoodIngredient(2, 2.0, 20.0, 20.0, "Mieso wolowe"));
		foodIngredientList.add(new FoodIngredient(3, 3.0, 4.0, 5.0, "Cebula"));
		foodIngredientList.add(new FoodIngredient(4, 10.0, 15.0, 20.0, "Sos pomidorowy"));

		List<ReadyMealDetails> readyMealDetailsList = new ArrayList<>();
		for(FoodIngredient foodIngredient : foodIngredientList){
			foodCreator.addNewIngredient(foodIngredient);
			foodCreator.addNewReadMealDetails(new ReadyMealDetails(55.0, readyMeal, foodIngredient));
			readyMealDetailsList.add(new ReadyMealDetails(55.0, readyMeal, foodIngredient));
		}

		foodCreator.deleteIngredientFromReadyMealList(foodCreator.findReadyMealDeatilsById(readyMeal.getMealId()).get(foodCreator.findReadyMealDeatilsById(readyMeal.getMealId()).size()-1));

		assertNotSame(foodCreator.findReadyMealDeatilsById(readyMeal.getMealId()), readyMealDetailsList.size());
	}
}
