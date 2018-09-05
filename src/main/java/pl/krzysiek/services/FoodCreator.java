package pl.krzysiek.services;

import pl.krzysiek.domain.Account;
import pl.krzysiek.domain.FoodIngredient;
import pl.krzysiek.domain.ReadyMeal;
import pl.krzysiek.domain.ReadyMealDetails;

import java.util.List;

public interface FoodCreator {

    void addAccount(Account account);

    FoodIngredient addNewIngredient(FoodIngredient foodIngredient);

    ReadyMeal addNewReadMeal(ReadyMeal readyMeal);

    void updateClient(Account account);

    ReadyMeal updateReadyMeal(ReadyMeal readyMeal);

    List<Account> getAllAccounts();

    void deleteAccount(Account account);

    void deleteIngredientFromReadyMealList(ReadyMealDetails readyMealDetails);

    Account findAccountByName(String name);

    ReadyMeal findReadyMealByTitle(String title);

    List<ReadyMealDetails> findReadyMealDeatilsById(int mealId);

    ReadyMeal findReadyMealById(int id);

    FoodIngredient addIngrefient(FoodIngredient foodIngredient);

    ReadyMeal addReadyMeal(ReadyMeal readyMeal);
}
