package com.example.shdemo.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import com.example.shdemo.domain.Account;
import com.example.shdemo.domain.FoodIngredient;
import com.example.shdemo.domain.ReadyMeal;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

//@Ignore

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/beans.xml" })
//@Rollback
//@Commit
//@Transactional(transactionManager = "txManager")
public class SellingManagerTest {

	@Autowired
	FoodCreator foodCreator;

	private final String NAME_1 = "Krzysiek";
	private final String PASSWORD_1 = "testowe_haslo";

	private final String NAME_2 = "Krzysiek";
	private final String PASSWORD_2 = "testowe_haslo";


//	private final String MODEL_1 = "126p";
//	private final String MAKE_1 = "Fiat";
//
//	private final String MODEL_2 = "Mondeo";
//	private final String MAKE_2 = "Ford";

	@Test
	public void addClientCheck() {

		List<Account> retrievedClients = foodCreator.getAllAccounts();
		// If there is a client with PIN_1 delete it
		for (Account account : retrievedClients) {
			System.out.println("Klient: " + account.getName() + " " + account.getPassword());
			if (account.getName().equals(NAME_1)) {
				foodCreator.deleteAccount(account);
			}
		}
		retrievedClients = foodCreator.getAllAccounts();

		Account account = new Account();
		account.setName(NAME_1);
		account.setPassword(PASSWORD_1);
		// ... other properties here

		// Pin is Unique
		foodCreator.addAccount(account);

		Account accountByName = foodCreator.findAccountByName(NAME_1);

		assertEquals(NAME_1, accountByName.getName());
		assertEquals(PASSWORD_1, accountByName.getPassword());

		accountByName.setName("Roman");
		foodCreator.updateClient(accountByName);
		assertEquals("Roman", foodCreator.findAccountByName(accountByName.getName()).getName());

		// ... check other properties here

	}

	@Test
    public void addNewMeal(){

        Account account = new Account();
        account.setName(NAME_1);
        account.setPassword(PASSWORD_1);

        foodCreator.addAccount(account);

        List<FoodIngredient> foodIngredientList = new ArrayList<>();
        foodIngredientList.add(new FoodIngredient(1, "Makaron zbozowy", 10, 66, 5));
        foodIngredientList.add(new FoodIngredient(2, "Mieso mielone", 23,8,30));
        foodIngredientList.add(new FoodIngredient(3, "Cebula", 4, 5, 6));
        foodIngredientList.add(new FoodIngredient(4, "Sos pomidorowy", 10, 30, 10));

        List<ReadyMeal> readyMealList = new ArrayList<>();
        readyMealList.add(foodCreator.createReadyMeal(account, foodIngredientList));

        account.setReadyMeals(readyMealList);

        foodCreator.updateClient(account);

    }



//	@Test
//	public void addCarCheck() {
//
//		Car car = new Car();
//		car.setMake(MAKE_1);
//		car.setModel(MODEL_1);
//		// ... other properties here
//
//		Long carId = sellingManager.addNewCar(car);
//
//		Car retrievedCar = sellingManager.findCarById(carId);
//		assertEquals(MAKE_1, retrievedCar.getMake());
//		assertEquals(MODEL_1, retrievedCar.getModel());
//		// ... check other properties here
//
//	}
//
//	@Test
//	public void sellCarCheck() {
//
//		Person person = new Person();
//		person.setFirstName(NAME_2);
//		person.setPin(PIN_2);
//		sellingManager.addClient(person);
//
//		Person retrievedPerson = sellingManager.findClientByPin(PIN_2);
//
//		Car car = new Car();
//		car.setMake(MAKE_2);
//		car.setModel(MODEL_2);
//
//		Long carId = sellingManager.addNewCar(car);
//
//		sellingManager.sellCar(retrievedPerson.getId(), carId);
//
//		List<Car> ownedCars = sellingManager.getOwnedCars(retrievedPerson);
//
//		assertEquals(1, ownedCars.size());
//		assertEquals(MAKE_2, ownedCars.get(0).getMake());
//		assertEquals(MODEL_2, ownedCars.get(0).getModel());
//	}

	// @Test -
	public void disposeCarCheck() {
		// Do it yourself
	}

}
