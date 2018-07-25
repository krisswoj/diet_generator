package pl.krzysiek.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import pl.krzysiek.domain.FoodIngredient;
import pl.krzysiek.domain.ReadyMeal;
import pl.krzysiek.domain.ReadyMealDetails;
import pl.krzysiek.services.FoodIngredientsService;

@Controller
public class ReadyMealController {

    @Autowired
    FoodIngredientsService foodIngredientsService;

    @RequestMapping(value = "/create_meal", method = RequestMethod.GET)
    public ModelAndView createMealForm(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("successMessage", "none");
        modelAndView.addObject("ingredientsForm", new ReadyMeal());
        modelAndView.addObject("ingredientsList", foodIngredientsService.listAll());

        modelAndView.setViewName("food_views/create_meal_form");
        return modelAndView;
    }

//    @RequestMapping(value = "/create_meal", params = "grams_portion", method = RequestMethod.POST)
//    public ModelAndView createMealForm(@RequestParam("grams_portion") String grams_portion) {
//        ModelAndView modelAndView = new ModelAndView();
//
//        modelAndView.addObject("ingredientsForm", new ReadyMealDetails());
//        modelAndView.addObject("ingredientsList", new FoodIngredient());
//        modelAndView.setViewName("food_views/create_meal_form");
//        System.out.println("Chuj wie co wypluje: " + grams_portion);
//        return modelAndView;
//    }
}
