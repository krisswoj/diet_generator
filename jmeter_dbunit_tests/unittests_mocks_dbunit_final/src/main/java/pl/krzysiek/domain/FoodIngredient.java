package pl.krzysiek.domain;

import javax.persistence.*;
import java.util.Objects;

//@NamedQuery(name = "foodingredient.all", query = "Select f from food_ingredient f")
@Entity
@Table(name = "food_ingredient")
public class FoodIngredient {
    private Integer id;
    private Integer amountCarbs;
    private Integer amountFats;
    private Integer amountProtins;
    private String name;

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
    @Column(name = "amount_carbs")
    public Integer getAmountCarbs() {
        return amountCarbs;
    }

    public void setAmountCarbs(Integer amountCarbs) {
        this.amountCarbs = amountCarbs;
    }

    @Basic
    @Column(name = "amount_fats")
    public Integer getAmountFats() {
        return amountFats;
    }

    public void setAmountFats(Integer amountFats) {
        this.amountFats = amountFats;
    }

    @Basic
    @Column(name = "amount_protins")
    public Integer getAmountProtins() {
        return amountProtins;
    }

    public void setAmountProtins(Integer amountProtins) {
        this.amountProtins = amountProtins;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FoodIngredient that = (FoodIngredient) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(amountCarbs, that.amountCarbs) &&
                Objects.equals(amountFats, that.amountFats) &&
                Objects.equals(amountProtins, that.amountProtins) &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, amountCarbs, amountFats, amountProtins, name);
    }

    public FoodIngredient() {
    }

    public FoodIngredient(Integer id, Integer amountCarbs, Integer amountFats, Integer amountProtins, String name) {
        this.id = id;
        this.amountCarbs = amountCarbs;
        this.amountFats = amountFats;
        this.amountProtins = amountProtins;
        this.name = name;
    }
}
