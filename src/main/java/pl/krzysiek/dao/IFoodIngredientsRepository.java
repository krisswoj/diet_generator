package pl.krzysiek.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.krzysiek.domain.FoodIngredient;

import java.util.List;

@Repository
public interface IFoodIngredientsRepository extends CrudRepository<FoodIngredient, Integer> {

    FoodIngredient findById(int id);
    List<FoodIngredient> findAllByCategory(int category);
}
