package pl.krzysiek.tests.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import pl.krzysiek.dao.IFoodIngredientsRepository;
import pl.krzysiek.domain.FoodIngredient;
import pl.krzysiek.services.FoodIngredientsService;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;


@RunWith(SpringRunner.class)
@Rollback
@Commit
@SpringBootTest
@Transactional
public class FoodIngredientServicesTest {

    @Autowired
    IFoodIngredientsRepository foodIngredientsRepository;

    @Autowired
    FoodIngredientsService foodIngredientsService;


    @Test
    public void addNewIngredient(){

        FoodIngredient foodIngredientBefore = new FoodIngredient(23.0, 45.0, 65.0, "tyrtbfvedc");
        FoodIngredient returnedFoodIngredient = foodIngredientsService.addNew(foodIngredientBefore);

        assertEquals(foodIngredientsService.getById(returnedFoodIngredient.getId()).getName(), returnedFoodIngredient.getName());
    }

    @Test
    public void updateFoodIngredient() {
        FoodIngredient foodIngredientToSave = new FoodIngredient(1, 44.0, 23.0, 60.0, "Makaron");
        FoodIngredient foodIngredientAfterUpdate = new FoodIngredient(1, 44.0, 23.0, 60.0, "Makaron Jasminowy");

        FoodIngredient addedFoodIngredient = foodIngredientsService.saveFoodIngredient(foodIngredientToSave);
        assertEquals(addedFoodIngredient, foodIngredientToSave);

        foodIngredientToSave.setName("Makaron Jasminowy");

        FoodIngredient updateded = foodIngredientsService.updateFoodIngredient(foodIngredientToSave);
        assertEquals(foodIngredientAfterUpdate, updateded);
    }

    @Test
    public void checkDelete(){

        List<FoodIngredient> foodIngredientList = new ArrayList<>();
        foodIngredientList.add(new FoodIngredient(1, 44.0, 23.0, 60.0, "Mak34aron"));
        foodIngredientList.add(new FoodIngredient(2, 44.0, 23.0, 60.0, "Ma34ka"));
        foodIngredientList.add(new FoodIngredient(3, 44.0, 23.0, 60.0, "Mie467568so"));
        foodIngredientList.add(new FoodIngredient(4, 44.0, 23.0, 60.0, "Mi34od"));


        List<FoodIngredient> addedList = foodIngredientsService.saveListOfFoodIngredients(foodIngredientList);

        assertEquals(addedList, foodIngredientList);

        FoodIngredient foodIngredientToRemove = foodIngredientList.get(foodIngredientList.size()-2);

        foodIngredientsService.deleteFoodIngredient(foodIngredientToRemove);

        List<FoodIngredient> afterDeletedList = foodIngredientsService.listAll();
        assertFalse(afterDeletedList.contains(foodIngredientToRemove));

    }
}
