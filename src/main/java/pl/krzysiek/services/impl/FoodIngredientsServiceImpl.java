package pl.krzysiek.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.krzysiek.dao.IFoodIngredientsRepository;
import pl.krzysiek.domain.Account;
import pl.krzysiek.domain.FoodIngredient;
import pl.krzysiek.domain.ReadyMealDetails;
import pl.krzysiek.domain.enums.CalorieAmount;
import pl.krzysiek.services.FoodIngredientsService;
import pl.krzysiek.services.ReaderXMLFilesService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class FoodIngredientsServiceImpl implements FoodIngredientsService {

    private final static String ingredientsFile = "upload-dir/ingredients.xml";

//    @Autowired
//    IFoodIngredientsRepository foodIngredientsRepository;
    @Autowired
    ReaderXMLFilesService readerXMLFilesService;
    @Autowired
    FoodIngredientsService foodIngredientsService;

    @Resource
    private IFoodIngredientsRepository foodIngredientsRepository;

    @Override
    public List<FoodIngredient> listAll() {
        return (List<FoodIngredient>) foodIngredientsRepository.findAll();
    }

    @Override
    public FoodIngredient addNew(FoodIngredient foodIngredient) {
        java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
        foodIngredient.setCreatedDate(date);
        return foodIngredientsRepository.save(foodIngredient);
    }

    public FoodIngredient getById(int id) {
        return foodIngredientsRepository.findById(id);
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
        return foodIngredientsRepository.saveAll(foodIngredientList);
    }

    @Override
    public Double nutritionGramsAmount(Double totallyGramsPortion, Double nutritionAmount) {
        return ((totallyGramsPortion * (nutritionAmount / 10) / 10));
    }

    @Override
    public Double kcalAmount(Double gramsPortion, Double amountCarbs, Double amountProtins, Double amountFats) {
        return (nutritionGramsAmount(gramsPortion, amountCarbs) * CalorieAmount.CARBS.getValue()
                + (nutritionGramsAmount(gramsPortion, amountProtins) * CalorieAmount.PROTINS.getValue()
                + (nutritionGramsAmount(gramsPortion, amountFats) * CalorieAmount.FATS.getValue())));
    }

    @Override
    public Double totalCarbsGramsAmount(List<ReadyMealDetails> readyMealDetails) {
        Double result = 0.00;
        for (ReadyMealDetails meal : readyMealDetails) {
            result += nutritionGramsAmount(meal.getGramsPortion(), meal.getReadyMealDetailsFoodIngredient().getAmountCarbs());
        }
        return result;
    }

    @Override
    public Double totalProtinsGramsAmount(List<ReadyMealDetails> readyMealDetails) {
        Double result = 0.00;
        for (ReadyMealDetails meal : readyMealDetails) {
            result += nutritionGramsAmount(meal.getGramsPortion(), meal.getReadyMealDetailsFoodIngredient().getAmountProtins());
        }
        return result;
    }

    @Override
    public Double totalFatsGramsAmount(List<ReadyMealDetails> readyMealDetails) {
        Double result = 0.00;
        for (ReadyMealDetails meal : readyMealDetails) {
            result += nutritionGramsAmount(meal.getGramsPortion(), meal.getReadyMealDetailsFoodIngredient().getAmountFats());
        }
        return result;
    }

    @Override
    public Double totalKcalGramsAmount(List<ReadyMealDetails> readyMealDetails) {
        Double result = 0.00;
        for (ReadyMealDetails meal : readyMealDetails) {
            result += ((nutritionGramsAmount(meal.getGramsPortion(), meal.getReadyMealDetailsFoodIngredient().getAmountCarbs() * CalorieAmount.CARBS.getValue())
                    + (nutritionGramsAmount(meal.getGramsPortion(), meal.getReadyMealDetailsFoodIngredient().getAmountProtins() * CalorieAmount.PROTINS.getValue()))
                    + nutritionGramsAmount(meal.getGramsPortion(), meal.getReadyMealDetailsFoodIngredient().getAmountFats()) * CalorieAmount.FATS.getValue()));
        }
        return result;
    }


    @Override
    public FoodIngredient saveFoodIngredient(FoodIngredient foodIngredient) {
        return foodIngredientsRepository.save(foodIngredient);
    }

    @Override
    public void deleteFoodIngredient(FoodIngredient foodIngredient) {
        foodIngredientsRepository.delete(foodIngredient);
    }

    @Override
    public FoodIngredient updateFoodIngredient(FoodIngredient foodIngredient) {
        return foodIngredientsRepository.save(foodIngredient);
    }

    @Override
    public List<FoodIngredient> saveListOfFoodIngredients(List<FoodIngredient> foodIngredients){
        return (List<FoodIngredient>) foodIngredientsRepository.saveAll(foodIngredients);
    }

    @Override
    public void dropFoodIngredientTable() {
        foodIngredientsRepository.dropFoodIngredientsTable();
    }

    /**
     * This setter method should be used only by unit tests.
     */

    public void setFoodIngredientsRepository(IFoodIngredientsRepository foodIngredientsRepository)
    {
        this.foodIngredientsRepository = foodIngredientsRepository;
    }



}
