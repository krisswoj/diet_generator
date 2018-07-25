package pl.krzysiek.domain;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "food_ingredient", schema = "tau", catalog = "")
public class FoodIngredient {
    private int id;
    private String name;
    private String description;
    private Integer category;
    private Integer subcategory;
    private Integer amountProtins;
    private Integer amountCarbs;
    private Integer amountFats;
    private Timestamp createdDate;
    private Timestamp updateDate;

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
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "category")
    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    @Basic
    @Column(name = "subcategory")
    public Integer getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(Integer subcategory) {
        this.subcategory = subcategory;
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

    @Basic
    @Column(name = "created_date")
    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    @Basic
    @Column(name = "update_date")
    public Timestamp getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Timestamp updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FoodIngredient that = (FoodIngredient) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(description, that.description) &&
                Objects.equals(category, that.category) &&
                Objects.equals(subcategory, that.subcategory) &&
                Objects.equals(amountProtins, that.amountProtins) &&
                Objects.equals(amountCarbs, that.amountCarbs) &&
                Objects.equals(amountFats, that.amountFats) &&
                Objects.equals(createdDate, that.createdDate) &&
                Objects.equals(updateDate, that.updateDate);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, description, category, subcategory, amountProtins, amountCarbs, amountFats, createdDate, updateDate);
    }
}
