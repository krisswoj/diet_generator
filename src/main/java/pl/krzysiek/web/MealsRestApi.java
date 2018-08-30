package pl.krzysiek.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.krzysiek.dao.IFoodIngredientsRepository;
import pl.krzysiek.dao.IReadyMealsRepository;
import pl.krzysiek.domain.FoodIngredient;
import pl.krzysiek.domain.ReadyMeal;
import pl.krzysiek.services.*;

import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.*;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Transactional
@RestController
public class MealsRestApi {

    @Autowired
    FoodIngredientsService foodIngredientsService;

    @Autowired
    IFoodIngredientsRepository foodIngredientsRepository;

    @Autowired
    IReadyMealsRepository readyMealsRepository;

    @Autowired
    ReadyMealService readyMealService;

    @RequestMapping(value ="/take-meals", method = GET)
    public List<ReadyMeal> getReadyMeals() throws SQLException {
        return readyMealService.findAll();
    }

    @RequestMapping(path = "/ingredients-list-all", method = RequestMethod.GET)
    public List<FoodIngredient> getFoodIngredients(){
        return foodIngredientsService.listAll();
    }

    @RequestMapping(value = "/take_meal/{id}", method = RequestMethod.GET)
    public ReadyMeal getReadReal(@PathVariable("id") int id) {
        return readyMealsRepository.findByMealId(id);
    }

    @RequestMapping(value = "/ingredients-by-id/{id}")
    @ResponseBody
    public List<FoodIngredient> listById(@PathVariable("id") int id) throws SQLException{
        return foodIngredientsRepository.findAllByCategory(id);
    }

    @RequestMapping(value = "/xml-add", method = RequestMethod.GET)
    public List<FoodIngredient> addByXml(){
        return (List<FoodIngredient>) foodIngredientsService.loadIngredients("upload-dir/ingredients.xml", "ingredient");
    }
}
