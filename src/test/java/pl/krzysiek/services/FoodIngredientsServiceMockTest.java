package pl.krzysiek.services;

import org.junit.Before;
import org.junit.Test;
import pl.krzysiek.dao.IFoodIngredientsRepository;
import pl.krzysiek.domain.FoodIngredient;
import pl.krzysiek.services.impl.FoodIngredientsServiceImpl;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyCollectionOf;
import static org.mockito.Mockito.*;

public class FoodIngredientsServiceMockTest {

    private FoodIngredientsServiceImpl foodIngredientsService;

    private IFoodIngredientsRepository foodIngredientsRepositoryMock;

    @Before
    public void setUp(){
        foodIngredientsService = new FoodIngredientsServiceImpl();
        foodIngredientsRepositoryMock = mock(IFoodIngredientsRepository.class);
        foodIngredientsService.setFoodIngredientsRepository(foodIngredientsRepositoryMock);
    }

    @Test
    public void addFoodIngredient(){
        FoodIngredient foodIngredientAfter = new FoodIngredient(23.0, 45.0, 65.0, "Makaron");

        when(foodIngredientsRepositoryMock.save(any(FoodIngredient.class))).thenReturn(foodIngredientAfter);
        FoodIngredient returned = foodIngredientsService.saveFoodIngredient(new FoodIngredient());
        assertEquals(foodIngredientAfter, returned);
        verify(foodIngredientsRepositoryMock, times(1)).save(any(FoodIngredient.class));
    }

    @Test
    public void updateFoodIngredient(){
        FoodIngredient foodIngredientToSave = new FoodIngredient(1, 44.0, 23.0, 60.0, "Makaron");
        FoodIngredient foodIngredientAfterUpdate = new FoodIngredient(1, 44.0, 23.0, 60.0, "Makaron Jasminowy");

        when(foodIngredientsRepositoryMock.save(any(FoodIngredient.class))).thenReturn(foodIngredientToSave);
        FoodIngredient addedFoodIngredient = foodIngredientsService.saveFoodIngredient(new FoodIngredient());
        assertEquals(addedFoodIngredient, foodIngredientToSave);

        foodIngredientToSave.setName("Makaron Jasminowy");
        when(foodIngredientsRepositoryMock.save(foodIngredientToSave)).thenReturn(foodIngredientAfterUpdate);

        FoodIngredient updateded = foodIngredientsService.updateFoodIngredient(foodIngredientToSave);
        assertEquals(foodIngredientToSave, updateded);
        verify(foodIngredientsRepositoryMock, times(2)).save(any(FoodIngredient.class));

    }

    @Test
    public void deleteTest(){
        List<FoodIngredient> foodIngredientList = new ArrayList<>();
        foodIngredientList.add(new FoodIngredient(1, 44.0, 23.0, 60.0, "Makaron"));
        foodIngredientList.add(new FoodIngredient(2, 44.0, 23.0, 60.0, "Maka"));
        foodIngredientList.add(new FoodIngredient(3, 44.0, 23.0, 60.0, "Mieso"));
        foodIngredientList.add(new FoodIngredient(4, 44.0, 23.0, 60.0, "Miod"));

        when(foodIngredientsRepositoryMock.saveAll(anyCollectionOf(FoodIngredient.class))).thenReturn(foodIngredientList);

        List<FoodIngredient> addedList = foodIngredientsService.saveListOfFoodIngredients(new ArrayList<FoodIngredient>());

        assertEquals(addedList, foodIngredientList);

        foodIngredientsService.deleteFoodIngredient(foodIngredientList.get(foodIngredientList.size()-1));

        verify(foodIngredientsRepositoryMock, times(1)).delete(any(FoodIngredient.class));
    }

}
