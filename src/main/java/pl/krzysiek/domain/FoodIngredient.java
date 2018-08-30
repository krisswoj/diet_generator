package pl.krzysiek.domain;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "food_ingredient", schema = "tau", catalog = "")
public class FoodIngredient {
    private Integer id;
    private Double amountCarbs;
    private Double amountFats;
    private Double amountProtins;
    private Integer category;
    private Timestamp createdDate;
    private String description;
    private String name;
    private Integer subcategory;
    private Timestamp updateDate;

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
    public Double getAmountCarbs() {
        return amountCarbs;
    }

    public void setAmountCarbs(Double amountCarbs) {
        this.amountCarbs = amountCarbs;
    }

    @Basic
    @Column(name = "amount_fats")
    public Double getAmountFats() {
        return amountFats;
    }

    public void setAmountFats(Double amountFats) {
        this.amountFats = amountFats;
    }

    @Basic
    @Column(name = "amount_protins")
    public Double getAmountProtins() {
        return amountProtins;
    }

    public void setAmountProtins(Double amountProtins) {
        this.amountProtins = amountProtins;
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
    @Column(name = "created_date")
    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
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
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return Objects.equals(id, that.id) &&
                Objects.equals(amountCarbs, that.amountCarbs) &&
                Objects.equals(amountFats, that.amountFats) &&
                Objects.equals(amountProtins, that.amountProtins) &&
                Objects.equals(category, that.category) &&
                Objects.equals(createdDate, that.createdDate) &&
                Objects.equals(description, that.description) &&
                Objects.equals(name, that.name) &&
                Objects.equals(subcategory, that.subcategory) &&
                Objects.equals(updateDate, that.updateDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, amountCarbs, amountFats, amountProtins, category, createdDate, description, name, subcategory, updateDate);
    }

    public FoodIngredient() {
    }
}
