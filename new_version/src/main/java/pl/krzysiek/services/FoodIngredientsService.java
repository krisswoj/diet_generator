package pl.krzysiek.services;

import pl.krzysiek.domain.food.FoodIngredient;

import java.util.List;

public interface FoodIngredientsService {

    public List<FoodIngredient> listAll();
    public FoodIngredient addNew(FoodIngredient foodIngredient);
    public Integer loadIngredients(String xmlFile, String xmlID);

}
