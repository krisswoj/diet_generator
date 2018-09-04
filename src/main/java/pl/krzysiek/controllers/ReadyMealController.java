package pl.krzysiek.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import pl.krzysiek.dao.IAccountRepository;
import pl.krzysiek.dao.IFoodIngredientsRepository;
import pl.krzysiek.dao.IReadyMealsRepository;
import pl.krzysiek.domain.*;
import pl.krzysiek.domain.enums.Notifications;
import pl.krzysiek.services.FoodIngredientsService;
import pl.krzysiek.services.ReadyMealService;

import javax.validation.Valid;

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


    @RequestMapping(value = "/create-meal", method = GET)
    public ModelAndView createMealForm() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("ingredientsList", foodIngredientsService.listAll());
        modelAndView.addObject("ingredientsForm", new ReadyMeal());
        modelAndView.setViewName("food_views/create_meal_form");
        return modelAndView;
    }

    @RequestMapping(value = "/create-meal", method = RequestMethod.POST)
    public ModelAndView createMealFormm(@Valid ReadyMeal readyMeal,
                                        @RequestParam("gramsPortion") Double[] gramsPortion,
                                        @RequestParam("food_ingredient_id") Integer[] food_ingredient_id) {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("ingredientsForm", new ReadyMeal());
        modelAndView.addObject("ingredientsList", foodIngredientsService.listAll());

        readyMealService.createReadyMeal(readyMeal, gramsPortion, food_ingredient_id);

        if (readyMealService.saveReadyMeal(readyMeal)) {
            modelAndView.addObject("message", Notifications.SUCCESS_ADDED_MEAL);
        } else {
            modelAndView.addObject("message", Notifications.FAILED_ADDED_MEAL);
        }
        modelAndView.setViewName("food_views/create_meal_form");
        return modelAndView;
    }

    @RequestMapping(value = "/take-meal", method = RequestMethod.GET)
    public ModelAndView getReadReal(@RequestParam("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("readyMealInfo", readyMealsRepository.findByMealId(id));
        modelAndView.addObject("calories", foodIngredientsService);
        modelAndView.setViewName("food_views/single_meal_details");

        return modelAndView;
    }

    @RequestMapping(value = "/ready-meals-list", method = RequestMethod.GET)
    public ModelAndView ReadyMealsList(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("readyMealsList", readyMealsRepository.findAll());
        modelAndView.addObject("calories", foodIngredientsService);
        modelAndView.setViewName("food_views/ready_meals_list");
        return modelAndView;
    }
}
