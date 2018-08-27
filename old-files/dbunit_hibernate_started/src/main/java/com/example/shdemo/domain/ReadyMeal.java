package com.example.shdemo.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "ready_meal")
public class ReadyMeal {
    private Integer mealId;
    private String title;
    private Account accountByUserId;
    private List<ReadyMealDetails> readyMealDetailsList;

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

    public ReadyMeal() {
    }

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonManagedReference
    @JoinColumn(name = "meal_id", referencedColumnName = "meal_id")
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
                Objects.equals(getAccountByUserId(), readyMeal.getAccountByUserId());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getMealId(), getTitle(), getAccountByUserId());
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
