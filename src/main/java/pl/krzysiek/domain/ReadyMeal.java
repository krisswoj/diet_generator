package pl.krzysiek.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "ready_meal", schema = "tau", catalog = "")
public class ReadyMeal {
    private Integer mealId;
    private Integer category;
    private Timestamp createdDate;
    private String description;
    private String title;
    private Timestamp updateDate;
    private Account readyMealAccount;
    private List<ReadyMealDetails> readyMealReadyMealDetails;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "meal_id")
    public Integer getMealId() {
        return mealId;
    }

    public void setMealId(Integer mealId) {
        this.mealId = mealId;
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
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
        ReadyMeal readyMeal = (ReadyMeal) o;
        return Objects.equals(mealId, readyMeal.mealId) &&
                Objects.equals(category, readyMeal.category) &&
                Objects.equals(createdDate, readyMeal.createdDate) &&
                Objects.equals(description, readyMeal.description) &&
                Objects.equals(title, readyMeal.title) &&
                Objects.equals(updateDate, readyMeal.updateDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mealId, category, createdDate, description, title, updateDate);
    }

    @OneToMany(mappedBy = "readyMealDetailsReadyMeal", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    public List<ReadyMealDetails> getReadyMealReadyMealDetails() {
        return readyMealReadyMealDetails;
    }

    public void setReadyMealReadyMealDetails(List<ReadyMealDetails> readyMealReadyMealDetails) {
        this.readyMealReadyMealDetails = readyMealReadyMealDetails;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonBackReference
    public Account getReadyMealAccount() {
        return readyMealAccount;
    }

    public void setReadyMealAccount(Account readyMealAccount) {
        this.readyMealAccount = readyMealAccount;
    }
}
