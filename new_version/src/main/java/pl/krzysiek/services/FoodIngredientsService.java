package pl.krzysiek.services;

import pl.krzysiek.domain.FoodIngredients;

import java.util.List;

public interface FoodIngredientsService {

    public List<FoodIngredients> listAll();
    public FoodIngredients addNew(FoodIngredients foodIngredients);
    public Integer loadIngredients();

}
