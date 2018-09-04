package com.example.shdemo.service;

import com.example.shdemo.domain.Account;
import com.example.shdemo.domain.FoodIngredient;
import com.example.shdemo.domain.ReadyMeal;
import com.example.shdemo.domain.ReadyMealDetails;

import java.io.Serializable;
import java.util.List;

public interface FoodCreator {

    void addAccount(Account account);

    Integer addNewIngredient(FoodIngredient foodIngredient);

    Integer addNewReadMeal(ReadyMeal readyMeal);

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

    Integer addIngrefient(FoodIngredient foodIngredient);

    ReadyMeal createReadyMeal(Account account, List<FoodIngredient> foodIngredientList);

    List<ReadyMeal> getAllReadyMeal();


}
