package pl.krzysiek.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.krzysiek.dao.IFoodIngredientCaloriesRepository;
import pl.krzysiek.domain.FoodIngredientCalories;
import pl.krzysiek.services.FoodIngredientCaloriesService;

@Service
public class FoodIngredientCaloriesServiceImpl implements FoodIngredientCaloriesService {

    @Autowired
    IFoodIngredientCaloriesRepository foodIngredientCaloriesRepository;

//    FoodIngredientCalories foodIngredientCalories = new FoodIngredientCalories();

    @Override
    public Integer carbsCalories() {
        return foodIngredientCaloriesRepository.findById(1).get().getFoodIngredientCalories();
    }

    @Override
    public Integer protinsCalories() {
        return foodIngredientCaloriesRepository.findById(2).get().getFoodIngredientCalories();
    }

    @Override
    public Integer fatCalories() {
        return foodIngredientCaloriesRepository.findById(3).get().getFoodIngredientCalories();
    }



    @Override
    public Double carbsGramsAmount(Double totallyGramsPortion, Double amountCarbsIngredient) {
//        foodIngredientCalories.setCarbsAmountStatic(foodIngredientCalories.getCarbsAmountStatic()+((totallyGramsPortion*(amountCarbsIngredient/10)/10)));
        return ((totallyGramsPortion*(amountCarbsIngredient/10)/10));
    }

    @Override
    public Double protinsGramsAmount(Double totallyGramsPortion, Double amountProtinsIngredient) {
//        foodIngredientCalories.setProtinsAmountStatic(foodIngredientCalories.getProtinsAmountStatic()+((totallyGramsPortion*(amountProtinsIngredient/10)/10)));
        return ((totallyGramsPortion*(amountProtinsIngredient/10)/10));
    }

    @Override
    public Double fatGramsAmount(Double totallyGramsPortion, Double amountFatsIngredient) {
//        foodIngredientCalories.setFatsAmountStatic(foodIngredientCalories.getFatsAmountStatic()+((totallyGramsPortion*(amountFatsIngredient/10)/10)));
//        System.out.println("Historia ilosc fat gram: " + foodIngredientCalories.getFatsAmountStatic());
        return ((totallyGramsPortion*(amountFatsIngredient/10)/10));
    }

    @Override
    public Double kcalAmount(Double gramsPortion, Double amountCarbs, Double amountProtins, Double amountFats){
        return (carbsGramsAmount(gramsPortion, amountCarbs)*carbsCalories())+(protinsGramsAmount(gramsPortion, amountProtins)*protinsCalories())+(fatGramsAmount(gramsPortion,amountFats)*fatCalories());
    }



}
