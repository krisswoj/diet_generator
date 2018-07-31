package pl.krzysiek.services;

public interface FoodIngredientCaloriesService {

    Integer carbsCalories();
    Integer protinsCalories();
    Integer fatCalories();

    Double carbsGramsAmount(Double totallyGramsPortion, Double amountCarbsIngredient);
    Double protinsGramsAmount(Double totallyGramsPortion, Double amountProtinsIngredient);
    Double fatGramsAmount(Double totallyGramsPortion, Double amountFatsIngredient);
    Double kcalAmount(Double gramsPortion, Double amountCarbs, Double amountProtins, Double amountFats);
}
