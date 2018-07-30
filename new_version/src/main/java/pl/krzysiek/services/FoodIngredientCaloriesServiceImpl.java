package pl.krzysiek.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.krzysiek.dao.IFoodIngredientCaloriesRepository;

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
}
