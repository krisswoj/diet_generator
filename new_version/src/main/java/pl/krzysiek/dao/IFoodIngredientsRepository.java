package pl.krzysiek.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.krzysiek.domain.FoodIngredients;

@Repository
public interface IFoodIngredientsRepository extends CrudRepository<FoodIngredients, Integer> {
}
