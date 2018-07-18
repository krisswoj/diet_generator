package pl.krzysiek.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import pl.krzysiek.dao.IFoodIngredientsRepository;
import pl.krzysiek.domain.FoodIngredients;
import pl.krzysiek.services.FoodIngredientsService;

import javax.validation.Valid;

@Controller
@SessionAttributes("food_ingredients")
public class FoodIngredientsController {

    @Autowired
    private FoodIngredientsService foodIngredientsService;

    @Autowired
    private IFoodIngredientsRepository foodIngredientsRepository;

    @RequestMapping(value = "/show_food_ingredients", method = RequestMethod.GET)
    public ModelAndView showFoodIngeredients(Model model){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("counts", foodIngredientsService.listAll());
        modelAndView.setViewName("food_views/list");

        return modelAndView;
    }

    @RequestMapping(value = "/add_food_ingredient", method = RequestMethod.GET)
    public ModelAndView addFood(){
        ModelAndView modelAndView = new ModelAndView();
        FoodIngredients foodIngredients = new FoodIngredients();
        modelAndView.addObject("food_ingredient", foodIngredients);
        modelAndView.setViewName("food_views/add_to_list");
        return modelAndView;
    }

    @RequestMapping(value = "/add_food_ingredient", method = RequestMethod.POST)
    public  ModelAndView addFood(@Valid FoodIngredients foodIngredients){
        ModelAndView modelAndView = new ModelAndView();
        foodIngredientsService.addNew(foodIngredients);
        modelAndView.addObject("successMessage", "Dziekujemy, składnik zostal dodany");
        modelAndView.addObject("food_ingredient", new FoodIngredients());
        modelAndView.setViewName("food_views/add_to_list");
        return modelAndView;
    }
}