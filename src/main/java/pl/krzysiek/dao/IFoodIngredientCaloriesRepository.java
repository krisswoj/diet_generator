package pl.krzysiek.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.krzysiek.domain.FoodIngredientCalories;

@Repository
public interface IFoodIngredientCaloriesRepository extends CrudRepository<FoodIngredientCalories, Integer> {

}
