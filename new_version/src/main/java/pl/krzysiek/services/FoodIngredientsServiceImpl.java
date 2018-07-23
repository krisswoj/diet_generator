package pl.krzysiek.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.krzysiek.dao.IFoodIngredientsRepository;
import pl.krzysiek.domain.food.FoodIngredient;

import java.util.ArrayList;
import java.util.List;

@Service("food_ingredients")
@Transactional
public class FoodIngredientsServiceImpl implements FoodIngredientsService {

    static String ingredientsFile = "upload-dir/ingredients.xml";

    @Autowired
    IFoodIngredientsRepository foodIngredientsRepository;
    @Autowired
    ReaderXMLFilesService readerXMLFilesService;
    @Autowired
    FoodIngredientsService foodIngredientsService;

    @Override
    public List<FoodIngredient> listAll() {
        List<FoodIngredient> counts = new ArrayList<>();
        foodIngredientsRepository.findAll().forEach(counts::add);
        return counts;
    }

    @Override
    public FoodIngredient addNew(FoodIngredient foodIngredient) {
        java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
        foodIngredient.setCreatedDate(date);
        return foodIngredientsRepository.save(foodIngredient);
    }

    @Override
    public Integer loadIngredients(String xmlFile, String xmlID){

        Integer amountAddedFoodIngredients = 0;
        List<ArrayList<String>> list = readerXMLFilesService.readXMLFilesF(ingredientsFile, xmlID);

        for (List<String> list2 : list) {
            FoodIngredient foodIngredient = new FoodIngredient();

            foodIngredient.setName(list2.get(0));
            foodIngredient.setDescription(list2.get(1));
            foodIngredient.setCategory(Integer.parseInt(list2.get(2)));
            foodIngredient.setSubcategory(Integer.parseInt(list2.get(3)));
            foodIngredient.setAmount_protins(Integer.parseInt(list2.get(4)));
            foodIngredient.setAmount_carbs(Integer.parseInt(list2.get(5)));
            foodIngredient.setAmount_fats(Integer.parseInt(list2.get(6)));

            foodIngredientsService.addNew(foodIngredient);
            amountAddedFoodIngredients++;
        }
        return amountAddedFoodIngredients;
    }

}
