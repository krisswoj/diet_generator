package pl.krzysiek.services;

import pl.krzysiek.domain.ReadyMeal;
import pl.krzysiek.domain.ReadyMealDetails;

import java.util.List;

public interface ReadyMealService {

    List<ReadyMealDetails> converterDataFromForm(Double[] gramsPortion, Integer[] food_ingredient_id);
    Boolean saveReadyMeal(ReadyMeal readyMeal);
    List<ReadyMeal> findAlle();


}
