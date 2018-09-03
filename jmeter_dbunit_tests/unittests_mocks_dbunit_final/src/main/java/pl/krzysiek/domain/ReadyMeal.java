package pl.krzysiek.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

//@NamedQuery(name = "readyMeal.byChuj", query = "Select r from ReadyMeal r where r.title = :titla")


@Entity
@NamedQueries({
        @NamedQuery(name = "readyMeal.byTitle", query = "Select r from ReadyMeal r where r.title = :title"),
        @NamedQuery(name = "readyMealDeatils.byId", query = "Select r from ReadyMealDetails r where r.readyMealDetailsReadyMeal.mealId = :mealId")})
@Table(name = "ready_meal")
public class ReadyMeal {
    private Integer mealId;
    private String title;
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
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReadyMeal readyMeal = (ReadyMeal) o;
        return Objects.equals(mealId, readyMeal.mealId) &&
                Objects.equals(title, readyMeal.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mealId, title);
    }

    @OneToMany(mappedBy = "readyMealDetailsReadyMeal", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
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