package pl.krzysiek.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "food_ingredients")
public class FoodIngredients {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ingredient_id")
    private long ingredient_id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "category")
    private int category;
    @Column(name = "subcategory")
    private int subcategory;
    @Column(name = "amount_protins")
    private double amount_protins;
    @Column(name = "amount_carbs")
    private double amount_carbs;
    @Column(name = "amount_fats")
    private double amount_fats;
    @Column(name = "createdDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Column(name = "updateDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;

    public long getIngredient_id() {
        return ingredient_id;
    }

    public void setIngredient_id(long ingredient_id) {
        this.ingredient_id = ingredient_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public int getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(int subcategory) {
        this.subcategory = subcategory;
    }

    public double getAmount_protins() {
        return amount_protins;
    }

    public void setAmount_protins(double amount_protins) {
        this.amount_protins = amount_protins;
    }

    public double getAmount_carbs() {
        return amount_carbs;
    }

    public void setAmount_carbs(double amount_carbs) {
        this.amount_carbs = amount_carbs;
    }

    public double getAmount_fats() {
        return amount_fats;
    }

    public void setAmount_fats(double amount_fats) {
        this.amount_fats = amount_fats;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}
