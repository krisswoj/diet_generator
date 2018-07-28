package pl.krzysiek.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
import java.util.ArrayList;
import java.util.List;

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

    @RequestMapping(value = "/create_meal", method = RequestMethod.GET)
    public ModelAndView createMealForm() {
        ModelAndView modelAndView = new ModelAndView();

//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        Account account = new Account();
//        account = accountRepository.findByName(auth.getName());
//        System.out.println("co wydrukuje auth get name user id: " + account.getUserId() + " a teraz email: " + account.getEmail());

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

        Account account = new Account();
        account.setUserId(5);

        readyMeal.setAccountByUserId(account);

        readyMeal.setTitle("Przykladowy danie numer 2");
        readyMeal.setDescription("Przykladowy opis dla dania numer 2");

        readyMeal.setReadyMealDetailsList(readyMealService.converterDataFromForm(gramsPortion, food_ingredient_id));

        readyMealsRepository.save(readyMeal);

        modelAndView.setViewName("food_views/create_meal_form");
        return modelAndView;
    }
}
