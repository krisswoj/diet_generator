package pl.krzysiek.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import pl.krzysiek.dao.IFoodIngredientsRepository;
import pl.krzysiek.domain.FoodIngredient;
import pl.krzysiek.services.FoodIngredientsService;
import pl.krzysiek.services.ReaderXMLFilesService;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class FoodIngredientsController {

    @Autowired
    private FoodIngredientsService foodIngredientsService;


    @RequestMapping(path="/", method=RequestMethod.GET)
    public String goHome(){
        return "index";
    }


    @RequestMapping(value = "/show_food_ingredients", method = RequestMethod.GET)
    public ModelAndView showFoodIngeredients(Model model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("counts", foodIngredientsService.listAll());
        modelAndView.setViewName("food_views/list");

        return modelAndView;
    }

    @RequestMapping(value = "/add_food_ingredient", method = RequestMethod.GET)
    public ModelAndView addFood() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("food_ingredient", new FoodIngredient());
        modelAndView.setViewName("food_views/add_to_list");
        return modelAndView;
    }

    @RequestMapping(value = "/add_food_ingredient", params = "name", method = RequestMethod.POST)
    public ModelAndView addFood(@Valid FoodIngredient foodIngredient, @RequestParam("name") String name) {
        ModelAndView modelAndView = new ModelAndView();
        foodIngredientsService.addNew(foodIngredient);
        modelAndView.addObject("successMessage", "Dziekujemy, składnik zostal dodany");
        modelAndView.addObject("food_ingredient", new FoodIngredient());
        modelAndView.setViewName("food_views/add_to_list");
        return modelAndView;
    }

    @RequestMapping(value = "/add_food_ingredient", method = RequestMethod.POST)
    public ModelAndView addFoodByXML(@RequestParam("file") MultipartFile file) {
        ModelAndView modelAndView = new ModelAndView();
        foodIngredientsService.loadIngredients("none", "ingredient");
        modelAndView.addObject("successMessage", "Do bazy dodalismy: x skladnikow");
        modelAndView.addObject("food_ingredient", new FoodIngredient());
        modelAndView.setViewName("food_views/add_to_list");
        return modelAndView;
    }
}
