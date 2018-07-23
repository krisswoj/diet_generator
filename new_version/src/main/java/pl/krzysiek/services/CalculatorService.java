package pl.krzysiek.services;

import pl.krzysiek.domain.food.CalorieCalculator;

import java.util.List;

public interface CalculatorService {

    public List<CalorieCalculator> listAll();
    public CalorieCalculator addNew(CalorieCalculator calorieCalculator);
    public Integer caloricDemand(CalorieCalculator calorieCalculator);
}
