package pl.krzysiek.services;

import pl.krzysiek.domain.FoodIngredient;

import java.util.List;

public interface FoodIngredientsService {

    public List<FoodIngredient> listAll();
    public FoodIngredient addNew(FoodIngredient foodIngredient);
    public Iterable<FoodIngredient> loadIngredients(String xmlFile, String xmlID);

}
