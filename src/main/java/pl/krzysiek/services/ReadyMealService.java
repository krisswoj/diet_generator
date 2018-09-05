package pl.krzysiek.services;

import pl.krzysiek.domain.ReadyMeal;
import pl.krzysiek.domain.ReadyMealDetails;

import java.util.List;

public interface ReadyMealService {

    void createReadyMeal(ReadyMeal readyMeal, Double[] gramsPortion, Integer[] food_ingredient_id);
    ReadyMeal saveReadyMeal(ReadyMeal readyMeal);
    List<ReadyMeal> findAll();


}
