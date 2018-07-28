package pl.krzysiek.services;

import org.springframework.stereotype.Service;
import pl.krzysiek.domain.FoodIngredient;
import pl.krzysiek.domain.ReadyMealDetails;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReadyMealServiceImpl implements ReadyMealService {

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
}
