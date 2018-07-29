package pl.krzysiek.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import pl.krzysiek.dao.IAccountRepository;
import pl.krzysiek.dao.IFoodIngredientsRepository;
import pl.krzysiek.dao.IReadyMealsRepository;
import pl.krzysiek.domain.Account;
import pl.krzysiek.domain.FoodIngredient;
import pl.krzysiek.domain.ReadyMeal;
import pl.krzysiek.domain.ReadyMealDetails;
import pl.krzysiek.services.FoodIngredientsService;
import pl.krzysiek.services.ReadyMealService;

import javax.validation.Valid;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class ReadyMealController {

    @Autowired
    FoodIngredientsService foodIngredientsService;

    @Autowired
    IFoodIngredientsRepository foodIngredientsRepository;

    @Autowired
    IReadyMealsRepository readyMealsRepository;

    @Autowired
    ReadyMealService readyMealService;

    @Autowired
    IAccountRepository accountRepository;

    @RequestMapping(value = "/create_meal", method = GET)
    public ModelAndView createMealForm() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("ingredientsList", foodIngredientsService.listAll());
        modelAndView.addObject("ingredientsForm", new ReadyMeal());
        modelAndView.setViewName("food_views/create_meal_form");
        return modelAndView;
    }

    @RequestMapping(value = "/create_meal", method = RequestMethod.POST)
    public ModelAndView createMealFormm(@Valid ReadyMeal readyMeal,
                                        @RequestParam("gramsPortion") Integer[] gramsPortion,
                                        @RequestParam("food_ingredient_id") Integer[] food_ingredient_id)  {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("ingredientsForm", new ReadyMeal());
        modelAndView.addObject("ingredientsList", foodIngredientsService.listAll());
        readyMeal.setReadyMealDetailsList(readyMealService.converterDataFromForm(gramsPortion, food_ingredient_id));

        if(readyMealService.saveReadyMeal(readyMeal)){
            modelAndView.addObject("message", "Danie dodano do bazy danych");
        }
        else{
            modelAndView.addObject("message", "Przepraszamy, danie nie zostalo dodane - sprobuj ponownie");
        }
        modelAndView.setViewName("food_views/create_meal_form");
        return modelAndView;
    }

//    @RequestMapping(value = "/show_all_meals", method = GET)
//    public ModelAndView showReadyMeals(){
//
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.addObject("readyMealsList", readyMealsRepository.findAll());
//
//        return modelAndView;
//    }

//    @RequestMapping(value ="/take-meals", method = GET)
//    public Iterable<ReadyMeal> getReadyMeals() throws SQLException {
//        return readyMealsRepository.findAll();
//    }
}
