package pl.krzysiek.services;

import pl.krzysiek.domain.ReadyMealDetails;

import java.util.List;

public interface FoodIngredientCaloriesService {

    Integer carbsCalories();
    Integer protinsCalories();
    Integer fatCalories();

    Double carbsGramsAmount(Double totallyGramsPortion, Double amountCarbsIngredient);
    Double protinsGramsAmount(Double totallyGramsPortion, Double amountProtinsIngredient);
    Double fatGramsAmount(Double totallyGramsPortion, Double amountFatsIngredient);
    Double kcalAmount(Double gramsPortion, Double amountCarbs, Double amountProtins, Double amountFats);

    Double totalCarbsGramsAmount(List<ReadyMealDetails> readyMealDetails);
    Double totalProtinsGramsAmount(List<ReadyMealDetails> readyMealDetails);
    Double totalFatsGramsAmount(List<ReadyMealDetails> readyMealDetails);
    Double totalKcalGramsAmount(List<ReadyMealDetails> readyMealDetails);
}
