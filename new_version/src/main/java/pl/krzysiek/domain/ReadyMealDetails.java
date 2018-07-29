package pl.krzysiek.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "ready_meal_details", schema = "tau", catalog = "")
public class ReadyMealDetails {
    private int id;
    private Integer gramsPortion;
    private ReadyMeal readyMealByMealId;
    private FoodIngredient foodIngredientByFoodIngredientId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "grams_portion")
    public Integer getGramsPortion() {
        return gramsPortion;
    }

    public void setGramsPortion(Integer gramsPortion) {
        this.gramsPortion = gramsPortion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReadyMealDetails that = (ReadyMealDetails) o;
        return id == that.id &&
                Objects.equals(gramsPortion, that.gramsPortion);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, gramsPortion);
    }

    @ManyToOne
    @JoinColumn(name = "meal_id", referencedColumnName = "meal_id")
    @JsonBackReference
    public ReadyMeal getReadyMealByMealId() {
        return readyMealByMealId;
    }

    public void setReadyMealByMealId(ReadyMeal readyMealByMealId) {
        this.readyMealByMealId = readyMealByMealId;
    }

    @ManyToOne
    @JoinColumn(name = "food_ingredient_id", referencedColumnName = "id")
    @JsonBackReference
    public FoodIngredient getFoodIngredientByFoodIngredientId() {
        return foodIngredientByFoodIngredientId;
    }

    public void setFoodIngredientByFoodIngredientId(FoodIngredient foodIngredientByFoodIngredientId) {
        this.foodIngredientByFoodIngredientId = foodIngredientByFoodIngredientId;
    }
}
