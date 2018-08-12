package pl.krzysiek.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.krzysiek.dao.IFoodIngredientsRepository;
import pl.krzysiek.domain.Account;
import pl.krzysiek.domain.FoodIngredient;
import pl.krzysiek.services.FoodIngredientsService;
import pl.krzysiek.services.ReaderXMLFilesService;

import java.util.ArrayList;
import java.util.List;

@Service
//@Transactional
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

    public FoodIngredient getById(int id) {
        FoodIngredient acc = foodIngredientsRepository.findById(id);
        return acc;
    }

    @Override
    public Iterable<FoodIngredient> loadIngredients(String xmlFile, String xmlID) {

        List<ArrayList<String>> list = readerXMLFilesService.readXMLFilesF(ingredientsFile, xmlID);

        List<FoodIngredient> foodIngredientList = new ArrayList<>();

        for (List<String> list2 : list) {
            FoodIngredient foodIngredient = new FoodIngredient();

            foodIngredient.setName(list2.get(0));
            foodIngredient.setDescription(list2.get(1));
            foodIngredient.setCategory(Integer.parseInt(list2.get(2)));
            foodIngredient.setSubcategory(Integer.parseInt(list2.get(3)));
            foodIngredient.setAmountProtins(Double.parseDouble(list2.get(4)));
            foodIngredient.setAmountCarbs(Double.parseDouble(list2.get(5)));
            foodIngredient.setAmountFats(Double.parseDouble(list2.get(6)));

            foodIngredientList.add(foodIngredient);
        }

        System.out.println(foodIngredientList);
        return foodIngredientsRepository.saveAll(foodIngredientList);
    }

}
