package com.example.shdemo.service;

import com.example.shdemo.domain.Account;
import com.example.shdemo.domain.FoodIngredient;
import com.example.shdemo.domain.ReadyMeal;

import java.util.List;

public interface FoodCreator {

    void addAccount(Account account);

    void updateClient(Account account);

    List<Account> getAllAccounts();

    void deleteAccount(Account account);

    Account findAccountByName(String name);

    Integer addIngrefient(FoodIngredient foodIngredient);

    List<FoodIngredient> getAllFoodIngredients();

    ReadyMeal createReadyMeal(Account account, List<FoodIngredient> foodIngredientList);

    List<ReadyMeal> getAllReadyMeal();


}
