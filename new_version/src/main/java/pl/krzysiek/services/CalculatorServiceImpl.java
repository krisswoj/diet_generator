package pl.krzysiek.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.krzysiek.dao.ICalculatorRepository;
import pl.krzysiek.domain.food.CalorieCalculator;


import java.util.ArrayList;
import java.util.List;

@Service("calculator")
@Transactional
public class CalculatorServiceImpl implements CalculatorService {

    @Autowired
    ICalculatorRepository calculatorRepository;


    public List<CalorieCalculator> listAll() {
        List<CalorieCalculator> counts = new ArrayList<>();
        calculatorRepository.findAll().forEach(counts::add);
        return counts;
    }

    @Override
    public CalorieCalculator addNew(CalorieCalculator calorieCalculator) {
        java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
        calorieCalculator.setCreatedDate(date);
        calorieCalculator.setCaloriesDemand(caloricDemand(calorieCalculator));
        return calculatorRepository.save(calorieCalculator);
    }

    @Override
    public Integer caloricDemand(CalorieCalculator calorieCalculator) {
        Integer calculatedDemand;
        double bmr = 0;
        double tea = 0;
        double neat = 0;

        if (calorieCalculator.getSex() == 1) {
            bmr = ((9.99 * calorieCalculator.getWeight()) + (6.25 * calorieCalculator.getHeight()) - (4.92 * calorieCalculator.getAge()) - 161);
        }
        if (calorieCalculator.getSex() == 2) {
            bmr = ((9.99 * calorieCalculator.getWeight()) + (6.25 * calorieCalculator.getHeight()) - (4.92 * calorieCalculator.getAge()) + 15);
        }

        if (calorieCalculator.getPlannedEffort() == 1) {
            tea = ((60 * 8) / 7);
        }
        if (calorieCalculator.getPlannedEffort() == 2) {
            tea = ((2 * 60 * 8) / 7);
        }
        if (calorieCalculator.getPlannedEffort() == 3) {
            tea = ((4 * 60 * 8) / 7);
        }

        if (calorieCalculator.getBody_type() == 1) {
            neat = 700;
        }
        if (calorieCalculator.getBody_type() == 2) {
            neat = 200;
        }
        if (calorieCalculator.getBody_type() == 3) {
            neat = 500;
        }

        bmr = ((bmr + tea + neat) * 1.1);

        if (calorieCalculator.getBodyGoal() == 2) {
            bmr = (bmr - 300);
        }
        if (calorieCalculator.getBodyGoal() == 3) {
            bmr = (bmr + 300);
        }

        calculatedDemand = (int) bmr;

        return calculatedDemand;
    }

}
