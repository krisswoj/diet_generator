package pl.krzysiek.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "food_ingredient_calories", schema = "tau", catalog = "")
public class FoodIngredientCalories {
    private int idfoodIngredientCalories;
    private String foodIngredientType;
    private int foodIngredientCalories;

//    private Double carbsAmountStatic;
//    private Double protinsAmountStatic;
//    private Double fatsAmountStatic;
//    private Double caloriesAmountStatic;

    @Id
    @Column(name = "idfood_ingredient_calories")
    public int getIdfoodIngredientCalories() {
        return idfoodIngredientCalories;
    }

    public void setIdfoodIngredientCalories(int idfoodIngredientCalories) {
        this.idfoodIngredientCalories = idfoodIngredientCalories;
    }

    @Basic
    @Column(name = "food_ingredient_type")
    public String getFoodIngredientType() {
        return foodIngredientType;
    }

    public void setFoodIngredientType(String foodIngredientType) {
        this.foodIngredientType = foodIngredientType;
    }

    @Basic
    @Column(name = "food_ingredient_calories")
    public int getFoodIngredientCalories() {
        return foodIngredientCalories;
    }

    public void setFoodIngredientCalories(int foodIngredientCalories) {
        this.foodIngredientCalories = foodIngredientCalories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FoodIngredientCalories that = (FoodIngredientCalories) o;
        return idfoodIngredientCalories == that.idfoodIngredientCalories &&
                foodIngredientCalories == that.foodIngredientCalories &&
                Objects.equals(foodIngredientType, that.foodIngredientType);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idfoodIngredientCalories, foodIngredientType, foodIngredientCalories);
    }

//    public Double getCarbsAmountStatic() {
//        return carbsAmountStatic;
//    }
//
//    public void setCarbsAmountStatic(Double carbsAmountStatic) {
//        this.carbsAmountStatic = carbsAmountStatic;
//    }
//
//    public Double getProtinsAmountStatic() {
//        return protinsAmountStatic;
//    }
//
//    public void setProtinsAmountStatic(Double protinsAmountStatic) {
//        this.protinsAmountStatic = protinsAmountStatic;
//    }
//
//    public Double getFatsAmountStatic() {
//        return fatsAmountStatic;
//    }
//
//    public void setFatsAmountStatic(Double fatsAmountStatic) {
//        this.fatsAmountStatic = fatsAmountStatic;
//    }
//
//    public Double getCaloriesAmountStatic() {
//        return caloriesAmountStatic;
//    }
//
//    public void setCaloriesAmountStatic(Double caloriesAmountStatic) {
//        this.caloriesAmountStatic = caloriesAmountStatic;
//    }
}
