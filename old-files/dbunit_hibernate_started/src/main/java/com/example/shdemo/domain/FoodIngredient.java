package com.example.shdemo.domain;

import javax.persistence.*;
import java.util.Objects;

//@NamedQuery(name = "foodingredient.all", query = "Select f from food_ingredient f")
@Entity
@Table(name = "food_ingredient")
public class FoodIngredient {
    private Integer id;
    private String name;
    private Integer amountProtins;
    private Integer amountCarbs;
    private Integer amountFats;

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
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FoodIngredient that = (FoodIngredient) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(amountProtins, that.amountProtins) &&
                Objects.equals(amountCarbs, that.amountCarbs) &&
                Objects.equals(amountFats, that.amountFats);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, amountProtins, amountCarbs, amountFats);
    }

    public FoodIngredient(Integer id, String name, Integer amountProtins, Integer amountCarbs, Integer amountFats) {
        this.id = id;
        this.name = name;
        this.amountProtins = amountProtins;
        this.amountCarbs = amountCarbs;
        this.amountFats = amountFats;
    }

    public FoodIngredient(String name, Integer amountProtins, Integer amountCarbs, Integer amountFats) {
        this.name = name;
        this.amountProtins = amountProtins;
        this.amountCarbs = amountCarbs;
        this.amountFats = amountFats;
    }
}
