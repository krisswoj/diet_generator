package pl.krzysiek.services;

import pl.krzysiek.domain.ReadyMealDetails;

import java.util.List;

public interface ReadyMealService {

    public List<ReadyMealDetails> converterDataFromForm(Integer[] gramsPortion, Integer[] food_ingredient_id);


}
