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
    private int mealId;
    private Integer category;
    private String title;
    private String description;
    private Timestamp createdDate;
    private Timestamp updateDate;
    private Account accountByUserId;
    private List<ReadyMealDetails> readyMealDetailsList;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "meal_id")
    public int getMealId() {
        return mealId;
    }

    public void setMealId(int mealId) {
        this.mealId = mealId;
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
    @Column(name = "category")
    public Integer getCategory() { return category; }

    public void setCategory(Integer category) { this.category = category; }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public ReadyMeal() {
    }

    @OneToMany(cascade = CascadeType.ALL)
    @JsonManagedReference
    public List<ReadyMealDetails> getReadyMealDetailsList() {
        return readyMealDetailsList;
    }

    public void setReadyMealDetailsList(List<ReadyMealDetails> readyMealDetailsList) {
        this.readyMealDetailsList = readyMealDetailsList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ReadyMeal)) return false;
        ReadyMeal readyMeal = (ReadyMeal) o;
        return getMealId() == readyMeal.getMealId() &&
                Objects.equals(getTitle(), readyMeal.getTitle()) &&
                Objects.equals(getDescription(), readyMeal.getDescription()) &&
                Objects.equals(getCreatedDate(), readyMeal.getCreatedDate()) &&
                Objects.equals(getUpdateDate(), readyMeal.getUpdateDate()) &&
                Objects.equals(getCategory(), readyMeal.getCategory()) &&
                Objects.equals(getAccountByUserId(), readyMeal.getAccountByUserId());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getMealId(), getTitle(), getDescription(), getCreatedDate(), getUpdateDate(), getAccountByUserId(), getCategory());
    }

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
    public Account getAccountByUserId() {
        return accountByUserId;
    }

    public void setAccountByUserId(Account accountByUserId) {
        this.accountByUserId = accountByUserId;
    }
}
