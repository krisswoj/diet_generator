package pl.krzysiek.domain.food;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "ready_meal_details", catalog = "tau")
public class ReadyMealDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "meal_id")
    private long meal_id;

    @Column(name = "ingredient_id")
    private long ingredient_id;

    private int grams_portion;

    public ReadyMealDetails() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getMeal_id() {
        return meal_id;
    }

    public void setMeal_id(long meal_id) {
        this.meal_id = meal_id;
    }

    public long getIngredient_id() {
        return ingredient_id;
    }

    public void setIngredient_id(long ingredient_id) {
        this.ingredient_id = ingredient_id;
    }

    public int getGrams_portion() {
        return grams_portion;
    }

    public void setGrams_portion(int grams_portion) {
        this.grams_portion = grams_portion;
    }
}
