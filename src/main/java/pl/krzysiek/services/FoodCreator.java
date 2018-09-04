package pl.krzysiek.services;

import pl.krzysiek.domain.Account;
import pl.krzysiek.domain.FoodIngredient;
import pl.krzysiek.domain.ReadyMeal;
import pl.krzysiek.domain.ReadyMealDetails;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface FoodCreator {

    void addAccount(Account account);

    FoodIngredient addNewIngredient(FoodIngredient foodIngredient);

    ReadyMeal addNewReadMeal(ReadyMeal readyMeal);

    void updateClient(Account account);

    void updateReadyMeal(ReadyMeal readyMeal);

    Serializable addNewReadMealDetails(ReadyMealDetails readyMealDetails);

    List<Account> getAllAccounts();

    void deleteAccount(Account account);

    void deleteIngredientFromReadyMealList(ReadyMealDetails readyMealDetails);

    Account findAccountByName(String name);

    ReadyMeal findReadyMealByTitle(String title);

    List<ReadyMealDetails> findReadyMealDeatilsById(int mealId);

    void updateReadyMealsDetails(ReadyMealDetails readyMealDetails);

    FoodIngredient addIngrefient(FoodIngredient foodIngredient);

    ReadyMeal createReadyMeal(Account account, List<FoodIngredient> foodIngredientList);

    List<ReadyMeal> getAllReadyMeal();


}
