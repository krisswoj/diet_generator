package pl.krzysiek.services;

import pl.krzysiek.domain.CalorieCalculator;

import java.util.List;

public interface CalculatorService {

    List<CalorieCalculator> listAll();

    List<CalorieCalculator> listAllForUser();

    CalorieCalculator addNew(CalorieCalculator calorieCalculator);

    Integer caloricDemand(CalorieCalculator calorieCalculator);
}
