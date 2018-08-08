package pl.krzysiek.services;

import pl.krzysiek.domain.CalorieCalculator;

import java.util.List;

public interface CalculatorService {

    public List<CalorieCalculator> listAll();

    List<CalorieCalculator> listAllForUser();

    public CalorieCalculator addNew(CalorieCalculator calorieCalculator);
    public Integer caloricDemand(CalorieCalculator calorieCalculator);
}
