package pl.krzysiek.domain.food;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "food_ingredient", catalog = "tau")
public class FoodIngredient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    private String name;
    private String description;
    private int category;
    private int subcategory;
    private double amount_protins;
    private double amount_carbs;
    private double amount_fats;
    @Temporal(TemporalType.TIMESTAMP)
    private Date created_date;
    @Temporal(TemporalType.TIMESTAMP)
    private Date update_date;

    public FoodIngredient() {
    }

    public long getid() {
        return id;
    }

    public void setid(long id) {
        this.id = id;
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

    public Date getcreated_date() {
        return created_date;
    }

    public void setcreated_date(Date created_date) {
        this.created_date = created_date;
    }

    public Date getupdate_date() {
        return update_date;
    }

    public void setupdate_date(Date update_date) {
        this.update_date = update_date;
    }
}
