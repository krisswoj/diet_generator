package pl.krzysiek.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import pl.krzysiek.dao.IAccountRepository;
import pl.krzysiek.dao.IReadyMealsRepository;
import pl.krzysiek.domain.Account;
import pl.krzysiek.domain.FoodIngredient;
import pl.krzysiek.domain.ReadyMeal;
import pl.krzysiek.domain.ReadyMealDetails;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReadyMealServiceImpl implements ReadyMealService {

    @Autowired
    IAccountRepository accountRepository;
    @Autowired
    IReadyMealsRepository readyMealsRepository;

    @Override
    public List<ReadyMealDetails> converterDataFromForm(Integer[] gramsPortion, Integer[] food_ingredient_id) {
        List<ReadyMealDetails> readyMealDetailsList = new ArrayList<ReadyMealDetails>();

        for(int i = 0; i<food_ingredient_id.length; i++){
            if(gramsPortion[i] > 0){
                ReadyMealDetails readyMealDetails = new ReadyMealDetails();
                FoodIngredient foodIngredient = new FoodIngredient();
                foodIngredient.setId(food_ingredient_id[i]);
                readyMealDetails.setGramsPortion(gramsPortion[i]);
                readyMealDetails.setFoodIngredientByFoodIngredientId(foodIngredient);
                readyMealDetailsList.add(readyMealDetails);
            }
        }
        return readyMealDetailsList;
    }

    @Override
    public Boolean saveReadyMeal(ReadyMeal readyMeal) {

        UserDetails userDetails =
                (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Account user = accountRepository.findByEmail(userDetails.getUsername());
        readyMeal.setAccountByUserId(user);
        try {
            readyMealsRepository.save(readyMeal);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public List<ReadyMeal> findAlle() {
        List<ReadyMeal> readyMealList = new ArrayList<>();
        for(ReadyMeal readyMeal : readyMealsRepository.findAll()){
            readyMealList.add(readyMeal);
        }

        return readyMealList;
    }

}
