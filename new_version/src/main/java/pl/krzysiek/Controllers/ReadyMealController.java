package pl.krzysiek.Controllers;

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
import pl.krzysiek.services.FoodIngredientCaloriesService;
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

    @Autowired
    FoodIngredientCaloriesService foodIngredientCaloriesService;

    @RequestMapping(value = "/create_meal", method = GET)
    public ModelAndView createMealForm() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("ingredientsList", foodIngredientsService.listAll());
        Rod rod = new Rod();
        modelAndView.addObject("rod", rod);
        modelAndView.addObject("ingredientsForm", new ReadyMeal());
        modelAndView.setViewName("food_views/create_meal_form");
        return modelAndView;
    }

//    @RequestMapping(value = "/create_meal", method = RequestMethod.POST)
//    public ModelAndView createMealFormm(@Valid ReadyMeal readyMeal, Rod rod, @RequestParam("grams") String grams)  {
//        ModelAndView modelAndView = new ModelAndView();
////        Rod rod = new Rod();
//        modelAndView.addObject("ingredientsForm", rod);
//        modelAndView.addObject("ingredientsForm", new ReadyMeal());
//        modelAndView.addObject("ingredientsList", foodIngredientsService.listAll());
////        readyMeal.setReadyMealDetailsList(readyMealService.converterDataFromForm(gramsPortion, food_ingredient_id));
//
//        System.out.println(grams);
//
//        if(readyMealService.saveReadyMeal(readyMeal)){
//            modelAndView.addObject("message", "Danie dodano do bazy danych");
//        }
//        else{
//            modelAndView.addObject("message", "Przepraszamy, danie nie zostalo dodane - sprobuj ponownie");
//        }
//        modelAndView.setViewName("food_views/create_meal_form");
//        return modelAndView;
//    }


    @RequestMapping(value = "/create_meal", method = RequestMethod.POST)
    public ModelAndView createMealFormm(@Valid ReadyMeal readyMeal,
                                        @RequestParam("gramsPortion") Double[] gramsPortion,
                                        @RequestParam("food_ingredient_id") Integer[] food_ingredient_id)  {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("ingredientsForm", new ReadyMeal());
        modelAndView.addObject("ingredientsList", foodIngredientsService.listAll());
        readyMeal.setReadyMealDetailsList(readyMealService.converterDataFromForm(gramsPortion, food_ingredient_id));

        readyMeal.setCategory(1);
        readyMeal.setDescription("jthtgerfed tgrfeds trhgefwdw tyhrgefwd htrgefwdq thregfw");
        readyMeal.setTitle("tergfwd rtgefdw rtgef trhgwe wtrge");

        if(readyMealService.saveReadyMeal(readyMeal)){
            modelAndView.addObject("message", "Danie dodano do bazy danych");
        }
        else{
            modelAndView.addObject("message", "Przepraszamy, danie nie zostalo dodane - sprobuj ponownie");
        }
        modelAndView.setViewName("food_views/create_meal_form");
        return modelAndView;
    }

    @RequestMapping(value = "/take-meal", method = RequestMethod.GET)
    public ModelAndView getReadReal(@RequestParam("id") int id){
        ModelAndView modelAndView = new ModelAndView();
        //@RequestParam("id") int id
        ReadyMeal readyMeal = readyMealsRepository.findByMealId(id);
        modelAndView.addObject("readyMealInfo", readyMeal);
        modelAndView.addObject("calories", foodIngredientCaloriesService);
        modelAndView.setViewName("food_views/single_meal");

        return modelAndView;
    }


}
