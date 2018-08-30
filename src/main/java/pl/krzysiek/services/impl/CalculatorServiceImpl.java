package pl.krzysiek.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.krzysiek.dao.ICalculatorRepository;
import pl.krzysiek.domain.CalorieCalculator;
import pl.krzysiek.services.AccountService;
import pl.krzysiek.services.CalculatorService;


import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class CalculatorServiceImpl implements CalculatorService {

    @Autowired
    ICalculatorRepository calculatorRepository;
    @Autowired
    AccountService accountService;


    public List<CalorieCalculator> listAll() {
        List<CalorieCalculator> counts = new ArrayList<>();
        calculatorRepository.findAll().forEach(counts::add);
        return counts;
    }

    @Override
    public List<CalorieCalculator> listAllForUser() {
        return calculatorRepository.findByCalorieCalculatorAccount(accountService.loggedUser());
    }

    @Override
    public CalorieCalculator addNew(CalorieCalculator calorieCalculator) {

        calorieCalculator.setCreatedDate((Timestamp) accountService.currentDate());
        calorieCalculator.setCaloriesDemand(caloricDemand(calorieCalculator));
        calorieCalculator.setCalorieCalculatorAccount(accountService.loggedUser());

        return calculatorRepository.save(calorieCalculator);
    }

    @Override
    public Integer caloricDemand(CalorieCalculator calorieCalculator) {
        double bmr = 0;
        double tea = 0;
        double neat = 0;

        switch (calorieCalculator.getSex()) {
            case 1:
                bmr = ((9.99 * calorieCalculator.getWeight()) + (6.25 * calorieCalculator.getHeight()) - (4.92 * calorieCalculator.getAge()) - 161);
                break;
            case 2:
                bmr = ((9.99 * calorieCalculator.getWeight()) + (6.25 * calorieCalculator.getHeight()) - (4.92 * calorieCalculator.getAge()) + 15);
                break;
        }

        switch (calorieCalculator.getPlannedEffort()) {
            case 1:
                tea = ((60 * 8) / 7);
                break;
            case 2:
                tea = ((2 * 60 * 8) / 7);
                break;
            case 3:
                tea = ((4 * 60 * 8) / 7);
                break;
        }

        switch ((calorieCalculator.getBodyType())) {
            case 1:
                neat = 700;
                break;
            case 2:
                neat = 200;
                break;
            case 3:
                neat = 500;
                break;
        }

        bmr = ((bmr + tea + neat) * 1.1);

        switch (calorieCalculator.getBodyGoal()) {
            case 1:
                bmr -= 300;
                break;
            case 2:
                bmr += 300;
                break;
        }
        return (int) bmr;
    }

}
