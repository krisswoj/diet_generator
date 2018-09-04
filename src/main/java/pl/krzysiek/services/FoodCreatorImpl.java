package pl.krzysiek.services;

import org.springframework.stereotype.Service;
import pl.krzysiek.dao.IAccountRepository;
import pl.krzysiek.dao.IFoodIngredientsRepository;
import pl.krzysiek.dao.IReadyMealDetailsRepository;
import pl.krzysiek.dao.IReadyMealsRepository;
import pl.krzysiek.domain.Account;
import pl.krzysiek.domain.FoodIngredient;
import pl.krzysiek.domain.ReadyMeal;
import pl.krzysiek.domain.ReadyMealDetails;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

@Service
public class FoodCreatorImpl implements FoodCreator {

    @Autowired
    private IFoodIngredientsRepository foodIngredientsRepository;

    @Autowired
    private IAccountRepository accountRepository;

    @Autowired
    private IReadyMealsRepository readyMealsRepository;

    @Autowired
    private IReadyMealDetailsRepository readyMealDetailsRepository;


    @Override
    public void addAccount(Account account) {
        accountRepository.save(account);
    }

    @Override
    public FoodIngredient addNewIngredient(FoodIngredient foodIngredient) {
        return foodIngredientsRepository.save(foodIngredient);
    }

    @Override
    public ReadyMeal addNewReadMeal(ReadyMeal readyMeal) {
        return readyMealsRepository.save(readyMeal);
    }

    @Override
    public void updateClient(Account account) {
        accountRepository.save(account);
    }

    @Override
    public void updateReadyMeal(ReadyMeal readyMeal) {
        readyMealsRepository.save(readyMeal);
    }

    @Override
    public Serializable addNewReadMealDetails(ReadyMealDetails readyMealDetails) {
        return (Serializable) readyMealDetailsRepository.save(readyMealDetails);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Account> getAllAccounts() {
        return (List<Account>) accountRepository.findAll();
    }

    @Override
    public void deleteAccount(Account account) {
        accountRepository.delete(account);

    }

    @Override
    public void deleteIngredientFromReadyMealList(ReadyMealDetails readyMealDetails){
        readyMealDetailsRepository.delete(readyMealDetails);
    }

    @Override
    public Account findAccountByName(String name) {
        return accountRepository.findByName(name);
    }

    @Override
    public ReadyMeal findReadyMealByTitle(String title) {
        return readyMealsRepository.findReadyMealByTitle(title);
    }

    @Override
    public List<ReadyMealDetails> findReadyMealDeatilsById(int mealId) {
        return readyMealDetailsRepository.findAllById(mealId);
    }

    @Override
    public void updateReadyMealsDetails(ReadyMealDetails readyMealDetails) {
        readyMealDetailsRepository.save(readyMealDetails);
    }

    @Override
    public FoodIngredient addIngrefient(FoodIngredient foodIngredient) {
        return foodIngredientsRepository.save(foodIngredient);
    }

    @Override
    public ReadyMeal createReadyMeal(Account account, List<FoodIngredient> foodIngredientList) {
        return null;
    }


    @Override
    public List<ReadyMeal> getAllReadyMeal() {
        return null;
    }
}
