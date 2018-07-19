package pl.krzysiek.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.krzysiek.dao.IFoodIngredientsRepository;
import pl.krzysiek.domain.FoodIngredients;

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
    public List<FoodIngredients> listAll() {
        List<FoodIngredients> counts = new ArrayList<>();
        foodIngredientsRepository.findAll().forEach(counts::add);
        return counts;
    }

    @Override
    public FoodIngredients addNew(FoodIngredients foodIngredients) {
        java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
        foodIngredients.setCreatedDate(date);
        return foodIngredientsRepository.save(foodIngredients);
    }

    @Override
    public Integer loadIngredients() {

        Integer amountAddedFoodIngredients = 0;
        List<ArrayList<String>> list = readerXMLFilesService.readXMLFilesF(ingredientsFile, "ingredient");

        for (List<String> list2 : list) {
            FoodIngredients foodIngredients = new FoodIngredients();

            foodIngredients.setName(list2.get(0));
            foodIngredients.setDescription(list2.get(1));
            foodIngredients.setCategory(Integer.parseInt(list2.get(2)));
            foodIngredients.setSubcategory(Integer.parseInt(list2.get(3)));
            foodIngredients.setAmount_protins(Integer.parseInt(list2.get(4)));
            foodIngredients.setAmount_carbs(Integer.parseInt(list2.get(5)));
            foodIngredients.setAmount_fats(Integer.parseInt(list2.get(6)));

            foodIngredientsService.addNew(foodIngredients);
            amountAddedFoodIngredients++;
        }

        return amountAddedFoodIngredients;
    }

}
