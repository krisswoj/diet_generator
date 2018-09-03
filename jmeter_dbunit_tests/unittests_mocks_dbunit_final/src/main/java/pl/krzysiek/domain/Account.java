package pl.krzysiek.domain;

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
    private List<ReadyMeal> accountReadyMeal;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(userId, account.userId) &&
                Objects.equals(name, account.name) &&
                Objects.equals(password, account.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, name, password);
    }

    @OneToMany(mappedBy = "readyMealAccount", cascade = CascadeType.ALL)
    @JsonManagedReference
    public List<ReadyMeal> getAccountReadyMeal() {
        return accountReadyMeal;
    }

    public void setAccountReadyMeal(List<ReadyMeal> accountReadyMeal) {
        this.accountReadyMeal = accountReadyMeal;
    }
}
