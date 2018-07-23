package pl.krzysiek.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import pl.krzysiek.domain.food.FoodIngredient;
import pl.krzysiek.domain.food.ReadyMeal;
import pl.krzysiek.domain.food.ReadyMealDetails;
import pl.krzysiek.services.FoodIngredientsService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ReadyMealController {

    @Autowired
    FoodIngredientsService foodIngredientsService;

    @RequestMapping(value = "/create_meal", method = RequestMethod.GET)
    public ModelAndView createMealForm(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("successMessage", "none");
        modelAndView.addObject("ingredientsS", new ReadyMealDetails());
        modelAndView.addObject("ingredients", foodIngredientsService.listAll());

        modelAndView.setViewName("food_views/create_meal_form");
        return modelAndView;
    }

    @RequestMapping(value = "/create_meal", params = "grams_portion", method = RequestMethod.POST)
    public ModelAndView createMealForm(@RequestParam("grams_portion") String grams_portion) {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("ingredientsS", new ReadyMealDetails());
        modelAndView.addObject("ingredients", new FoodIngredient());
        modelAndView.setViewName("food_views/create_meal_form");
        System.out.println("Chuj wie co wypluje: " + grams_portion);
        return modelAndView;
    }
}
