package pl.krzysiek.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import pl.krzysiek.dao.ICalculatorRepository;
import pl.krzysiek.domain.CalorieCalculator;
import pl.krzysiek.services.CalculatorService;

import javax.validation.Valid;

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
        modelAndView.addObject("successMessage", "Dziekuje, twoje zapotrzebowanie kaloryczne to"  + calculatorService.caloricDemand(calorieCalculator));
        modelAndView.addObject("calculator", new CalorieCalculator());
        modelAndView.setViewName("calculator/calculator_outside");
        return modelAndView;
    }

    @RequestMapping(value = "/calculator", method = RequestMethod.GET)
    public ModelAndView calculatorOutside(){
        ModelAndView modelAndView = new ModelAndView();
        CalorieCalculator calorieCalculator = new CalorieCalculator();
        modelAndView.addObject("calculator", calorieCalculator);
        modelAndView.setViewName("calculator/calculator_outside");
        return modelAndView;
    }
}
