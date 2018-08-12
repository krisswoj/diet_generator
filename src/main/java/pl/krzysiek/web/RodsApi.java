package pl.krzysiek.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.krzysiek.dao.IFoodIngredientsRepository;
import pl.krzysiek.dao.IReadyMealsRepository;
import pl.krzysiek.dao.IRodsRepository;
import pl.krzysiek.domain.FoodIngredient;
import pl.krzysiek.domain.ReadyMeal;
import pl.krzysiek.domain.Rod;
import pl.krzysiek.services.*;

import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.*;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Transactional
@RestController
public class RodsApi {


    @Autowired
    RodService rodsService;

    @Autowired
    IRodsRepository listRepository;

    @Autowired
    FoodIngredientsService foodIngredientsService;

    @Autowired
    IFoodIngredientsRepository foodIngredientsRepository;

    @Autowired
    IReadyMealsRepository readyMealsRepository;

    @Autowired
    ReadyMealService readyMealService;

    @Autowired
    FoodIngredientCaloriesService foodIngredientCaloriesService;

    @RequestMapping(value ="/take-meals", method = GET)
    public List<ReadyMeal> getReadyMeals() throws SQLException {
        return readyMealService.findAll();
    }

    @RequestMapping(path = "/ingredients-list-all", method = RequestMethod.GET)
    public List<FoodIngredient> getFoodIngredients(){
        return foodIngredientsService.listAll();
    }

    @RequestMapping(value = "/take_meal/{id}", method = RequestMethod.GET)
    public ReadyMeal getReadReal(@PathVariable("id") int id){
        ReadyMeal readyMeal = readyMealsRepository.findByMealId(id);
        return readyMeal;
    }

    @RequestMapping(value = "/rods-rest/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Rod getRod(@PathVariable("id") int id) throws SQLException {
        return listRepository.findById(id);
    }


    @RequestMapping(value = "/ingredients-by-id/{id}")
    @ResponseBody
    public List<FoodIngredient> listById(@PathVariable("id") int id) throws SQLException{
        return foodIngredientsRepository.findAllByCategory(id);
    }

    @RequestMapping(value = "/rods-rest", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Rod> getRods() throws SQLException {
        return rodsService.listAll();
    }

    @RequestMapping(value ="/rods-rest", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Rod addRod(@RequestBody Rod rod) {
        Rod addedRod = listRepository.save(rod);
        return addedRod;
    }

    @RequestMapping(value = "/rods-test", method = GET)
    @ResponseBody
    public String deleteRods(@RequestParam("id") int id) throws SQLException {
        listRepository.deleteById(id);
        return String.format("Wedka o id  #%d zostala usunieta", id);
    }

    @RequestMapping(value = "/rods-test/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteRodss(@PathVariable("id") int id) throws SQLException {
        listRepository.deleteById(id);
        return String.format("Wedka o id  #%d zostala usunieta", id);
    }

    @RequestMapping(value = "/rods-rest/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public Rod rodToUpdate(@PathVariable("id") int id, @RequestBody Rod rod){
        return rodsService.rodToUpdate(id, rod);
    }

    @RequestMapping(value = "/rods-update/{id}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Rod updateRods(@RequestBody Rod rod, @PathVariable("id") int id) throws SQLException{
        Rod addedRod = rod;
        addedRod.setId(id);
        return listRepository.save(addedRod);
    }

    @RequestMapping(value = "/extra-info", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Rod RodsWithExtraInfo(@RequestBody Rod rod) {
        Rod addedRecord = rodsService.createRodWithExtraInfo(rod);
        return addedRecord;
    }
}
