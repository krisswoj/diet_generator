package pl.krzysiek.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "ready_meal_details", schema = "tau", catalog = "")
public class ReadyMealDetails {
    private Integer id;
    private Double gramsPortion;
    private ReadyMeal readyMealDetailsReadyMeal;
    private FoodIngredient readyMealDetailsFoodIngredient;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "grams_portion")
    public Double getGramsPortion() {
        return gramsPortion;
    }

    public void setGramsPortion(Double gramsPortion) {
        this.gramsPortion = gramsPortion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReadyMealDetails that = (ReadyMealDetails) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(gramsPortion, that.gramsPortion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, gramsPortion);
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonBackReference
    public ReadyMeal getReadyMealDetailsReadyMeal() {
        return readyMealDetailsReadyMeal;
    }

    public void setReadyMealDetailsReadyMeal(ReadyMeal readyMealDetailsReadyMeal) {
        this.readyMealDetailsReadyMeal = readyMealDetailsReadyMeal;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonBackReference
    public FoodIngredient getReadyMealDetailsFoodIngredient() {
        return readyMealDetailsFoodIngredient;
    }

    public void setReadyMealDetailsFoodIngredient(FoodIngredient readyMealDetailsFoodIngredient) {
        this.readyMealDetailsFoodIngredient = readyMealDetailsFoodIngredient;
    }

    public ReadyMealDetails() {
    }

    public ReadyMealDetails(Double gramsPortion, ReadyMeal readyMealDetailsReadyMeal, FoodIngredient readyMealDetailsFoodIngredient) {
        this.gramsPortion = gramsPortion;
        this.readyMealDetailsReadyMeal = readyMealDetailsReadyMeal;
        this.readyMealDetailsFoodIngredient = readyMealDetailsFoodIngredient;
    }

    public ReadyMealDetails(ReadyMeal readyMealDetailsReadyMeal, FoodIngredient readyMealDetailsFoodIngredient) {
        this.readyMealDetailsReadyMeal = readyMealDetailsReadyMeal;
        this.readyMealDetailsFoodIngredient = readyMealDetailsFoodIngredient;
    }
}
