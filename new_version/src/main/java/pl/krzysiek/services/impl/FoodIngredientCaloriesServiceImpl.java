package pl.krzysiek.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.krzysiek.dao.IFoodIngredientCaloriesRepository;
import pl.krzysiek.domain.FoodIngredientCalories;
import pl.krzysiek.domain.ReadyMealDetails;
import pl.krzysiek.services.FoodIngredientCaloriesService;

import java.util.List;

@Service
public class FoodIngredientCaloriesServiceImpl implements FoodIngredientCaloriesService {


    @Autowired
    IFoodIngredientCaloriesRepository foodIngredientCaloriesRepository;

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
        return ((totallyGramsPortion*(amountCarbsIngredient/10)/10));
    }

    @Override
    public Double protinsGramsAmount(Double totallyGramsPortion, Double amountProtinsIngredient) {
        return ((totallyGramsPortion*(amountProtinsIngredient/10)/10));
    }

    @Override
    public Double fatGramsAmount(Double totallyGramsPortion, Double amountFatsIngredient) {
        return ((totallyGramsPortion*(amountFatsIngredient/10)/10));
    }

    @Override
    public Double kcalAmount(Double gramsPortion, Double amountCarbs, Double amountProtins, Double amountFats){
        return (carbsGramsAmount(gramsPortion, amountCarbs)*carbsCalories())+(protinsGramsAmount(gramsPortion, amountProtins)*protinsCalories())+(fatGramsAmount(gramsPortion,amountFats)*fatCalories());
    }

    @Override
    public Double totalCarbsGramsAmount(List<ReadyMealDetails> readyMealDetails) {
        Double result = 0.00;
        for (ReadyMealDetails meal:readyMealDetails) {
            result += carbsGramsAmount(meal.getGramsPortion(), meal.getFoodIngredientByFoodIngredientId().getAmountCarbs());
        }
        return result;
    }

    @Override
    public Double totalProtinsGramsAmount(List<ReadyMealDetails> readyMealDetails) {
        Double result = 0.00;
        for (ReadyMealDetails meal:readyMealDetails) {
            result += protinsGramsAmount(meal.getGramsPortion(), meal.getFoodIngredientByFoodIngredientId().getAmountProtins());
        }
        return result;
    }

    @Override
    public Double totalFatsGramsAmount(List<ReadyMealDetails> readyMealDetails) {
        Double result = 0.00;
        for (ReadyMealDetails meal:readyMealDetails) {
            result += fatGramsAmount(meal.getGramsPortion(), meal.getFoodIngredientByFoodIngredientId().getAmountFats());
        }
        return result;
    }

    @Override
    public Double totalKcalGramsAmount(List<ReadyMealDetails> readyMealDetails) {
        Double result = 0.00;
        for (ReadyMealDetails meal:readyMealDetails) {
            result += ((carbsGramsAmount(meal.getGramsPortion(), meal.getFoodIngredientByFoodIngredientId().getAmountCarbs()*carbsCalories())
                    +(protinsGramsAmount(meal.getGramsPortion(), meal.getFoodIngredientByFoodIngredientId().getAmountProtins()*protinsCalories()))
                    +fatGramsAmount(meal.getGramsPortion(), meal.getFoodIngredientByFoodIngredientId().getAmountFats())*fatCalories()));
        }
        return result;
    }

}
