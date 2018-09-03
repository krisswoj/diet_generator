package pl.krzysiek.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.krzysiek.domain.Account;
import pl.krzysiek.domain.FoodIngredient;

import java.util.List;

@Repository
public interface IFoodIngredientsRepository extends CrudRepository<FoodIngredient, Integer> {

    FoodIngredient findById(int id);

    List<FoodIngredient> findAllByCategory(int category);

    @Query(nativeQuery = true, value = "drop table tau.food_ingredient")
    void dropFoodIngredientsTable();

    @Query(nativeQuery = true, value = "CREATE TABLE `food_ingredient` (`id` int(11) NOT NULL AUTO_INCREMENT, `amount_carbs` double DEFAULT NULL, `amount_fats` double DEFAULT NULL, `amount_protins` double DEFAULT NULL, `name` varchar(255) DEFAULT NULL, PRIMARY KEY (`id`))")
    void createTable();
}
