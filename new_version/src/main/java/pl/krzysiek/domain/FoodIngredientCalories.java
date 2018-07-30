package pl.krzysiek.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "food_ingredient_calories", schema = "tau", catalog = "")
public class FoodIngredientCalories {
    private int idfoodIngredientCalories;
    private String foodIngredientType;
    private int foodIngredientCalories;

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
}
