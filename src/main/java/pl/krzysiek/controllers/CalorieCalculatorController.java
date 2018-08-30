package pl.krzysiek.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pl.krzysiek.dao.ICalculatorRepository;
import pl.krzysiek.domain.CalorieCalculator;
import pl.krzysiek.services.CalculatorService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CalorieCalculatorController {

    @Autowired
    ICalculatorRepository calculatorRepository;

    @Autowired
    CalculatorService calculatorService;

    @RequestMapping(value = "/calculator", method = RequestMethod.POST)
    public ModelAndView calculatorOutsideAdd(@Valid CalorieCalculator calorieCalculator){
        ModelAndView modelAndView = new ModelAndView();
        calculatorService.addNew(calorieCalculator);
        modelAndView.addObject("successMessage", (calculatorService.caloricDemand(calorieCalculator).toString()));
        modelAndView.addObject("calculator", new CalorieCalculator());
        modelAndView.setViewName("calculator/calculator_outside");
        return modelAndView;
    }

    @RequestMapping(value = "/calculator", method = RequestMethod.GET)
    public ModelAndView calculatorOutside(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("calculator", new CalorieCalculator());
        modelAndView.setViewName("calculator/calculator_outside");
        return modelAndView;
    }

    @RequestMapping(value = "/calorie-history", method = RequestMethod.GET)
    public ModelAndView calorieHistory(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("calculator", calculatorService.listAllForUser());
        modelAndView.setViewName("calculator/calorie_history_profile");
        return modelAndView;
    }
}
