package pl.krzysiek.services;

import pl.krzysiek.domain.FoodIngredient;
import pl.krzysiek.domain.ReadyMealDetails;

import java.util.List;

public interface FoodIngredientsService {

    public List<FoodIngredient> listAll();

    public FoodIngredient getById(int id);

    public FoodIngredient addNew(FoodIngredient foodIngredient);

    public Iterable<FoodIngredient> loadIngredients(String xmlFile, String xmlID);

    Double nutritionGramsAmount(Double totallyGramsPortion, Double nutritionAmount);

    Double kcalAmount(Double gramsPortion, Double amountCarbs, Double amountProtins, Double amountFats);

    Double totalCarbsGramsAmount(List<ReadyMealDetails> readyMealDetails);

    Double totalProtinsGramsAmount(List<ReadyMealDetails> readyMealDetails);

    Double totalFatsGramsAmount(List<ReadyMealDetails> readyMealDetails);

    Double totalKcalGramsAmount(List<ReadyMealDetails> readyMealDetails);

    FoodIngredient saveFoodIngredient(FoodIngredient foodIngredient);

    void deleteFoodIngredient(FoodIngredient foodIngredient);

    FoodIngredient updateFoodIngredient(FoodIngredient foodIngredient);

    List<FoodIngredient> saveListOfFoodIngredients(List<FoodIngredient> foodIngredients);

    void dropFoodIngredientTable();

}
