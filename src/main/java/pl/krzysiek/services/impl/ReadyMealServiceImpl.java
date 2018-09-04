package pl.krzysiek.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import pl.krzysiek.dao.IAccountRepository;
import pl.krzysiek.dao.IFoodIngredientsRepository;
import pl.krzysiek.dao.IReadyMealsRepository;
import pl.krzysiek.domain.Account;
import pl.krzysiek.domain.FoodIngredient;
import pl.krzysiek.domain.ReadyMeal;
import pl.krzysiek.domain.ReadyMealDetails;
import pl.krzysiek.services.AccountService;
import pl.krzysiek.services.ReadyMealService;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReadyMealServiceImpl implements ReadyMealService {

    @Autowired
    IAccountRepository accountRepository;
    @Autowired
    IReadyMealsRepository readyMealsRepository;
    @Autowired
    AccountService accountService;
    @Autowired
    IFoodIngredientsRepository foodIngredientsRepository;


    @Override
    public void createReadyMeal(ReadyMeal readyMeal, Double[] gramsPortion, Integer[] food_ingredient_id) {

        List<ReadyMealDetails> readyMealDetailsList = new ArrayList<>();

        for (int i = 0; i < food_ingredient_id.length; i++) {
            if (gramsPortion[i] > 0) {
                readyMealDetailsList.add(new ReadyMealDetails(gramsPortion[i], readyMeal, foodIngredientsRepository.findById((int) food_ingredient_id[i])));
            }
        }
        readyMeal.setReadyMealReadyMealDetails(readyMealDetailsList);
    }


    @Override
    public Boolean saveReadyMeal(ReadyMeal readyMeal) {

        readyMeal.setReadyMealAccount(accountService.loggedUser());
        try {
            readyMealsRepository.save(readyMeal);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public List<ReadyMeal> findAll() {
        List<ReadyMeal> readyMealList = new ArrayList<>();
        for (ReadyMeal readyMeal : readyMealsRepository.findAll()) {
            readyMealList.add(readyMeal);
        }
        return readyMealList;
    }

}
