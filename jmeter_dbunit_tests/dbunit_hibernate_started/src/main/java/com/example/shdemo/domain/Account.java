package com.example.shdemo.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@NamedQueries({
        @NamedQuery(name = "account.all", query = "Select a from Account a"),
        @NamedQuery(name = "account.byName", query = "Select a from Account a where a.name = :name")})
public class Account {
    private Integer userId;
    private String name;
    private String password;
    private List<ReadyMeal> readyMeals;


    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @JsonManagedReference
    public List<ReadyMeal> getReadyMeals() { return readyMeals; }

    public void setReadyMeals(List<ReadyMeal> readyMeals) { this.readyMeals = readyMeals; }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public Account() {
    }

    public Account(String name, String password) {
        this.name = name;
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account)) return false;
        Account account = (Account) o;
        return getUserId() == account.getUserId() &&
                Objects.equals(getName(), account.getName()) &&
                Objects.equals(getPassword(), account.getPassword());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getUserId(), getName(), getPassword());
    }
}
