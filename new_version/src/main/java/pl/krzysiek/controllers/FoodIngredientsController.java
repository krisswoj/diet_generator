package pl.krzysiek.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import pl.krzysiek.domain.FoodIngredient;
import pl.krzysiek.services.FoodIngredientsService;

import javax.validation.Valid;

@Controller
public class FoodIngredientsController {

    @Autowired
    private FoodIngredientsService foodIngredientsService;


    @RequestMapping(value = "/show-food-ingredients", method = RequestMethod.GET)
    public ModelAndView showFoodIngeredients(Model model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("counts", foodIngredientsService.listAll());
        modelAndView.setViewName("food_views/ingredient_list");

        return modelAndView;
    }

    @RequestMapping(value = "/add-food-ingredient", method = RequestMethod.GET)
    public ModelAndView addFood() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("food_ingredient", new FoodIngredient());
        modelAndView.setViewName("food_views/add_to_list_new_ingredient");
        return modelAndView;
    }

    @RequestMapping(value = "/add-food-ingredient", params = "name", method = RequestMethod.POST)
    public ModelAndView addFood(@Valid FoodIngredient foodIngredient, @RequestParam("name") String name) {
        ModelAndView modelAndView = new ModelAndView();
        foodIngredientsService.addNew(foodIngredient);
        modelAndView.addObject("successMessage", "Dziekujemy, składnik zostal dodany");
        modelAndView.addObject("food_ingredient", new FoodIngredient());
        modelAndView.setViewName("food_views/add_to_list_new_ingredient");
        return modelAndView;
    }

    @RequestMapping(value = "/add-food-ingredient", method = RequestMethod.POST)
    public ModelAndView addFoodByXML(@RequestParam("file") MultipartFile file) {
        ModelAndView modelAndView = new ModelAndView();
        foodIngredientsService.loadIngredients("none", "ingredient");
        modelAndView.addObject("successMessage", "Potwierdzamy dodanie skladnikow do bazy");
        modelAndView.addObject("food_ingredient", new FoodIngredient());
        modelAndView.setViewName("food_views/add_to_list_new_ingredient");
        return modelAndView;
    }
}
