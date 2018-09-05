package pl.krzysiek.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "account", schema = "tau", catalog = "")
public class Account {
    private Integer userId;
    private String name;
    private String surname;
    private String email;
    private String password;
    private Integer active;
    private Set<Role> userRole;
    private List<CalorieCalculator> accountCalorieCalculator;
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
    @NotEmpty(message = "*Please provide your name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "surname")
    @NotEmpty(message = "*Please provide your last name")
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Basic
    @Column(name = "email")
    @Email(message = "*Please provide a valid Email")
    @NotEmpty(message = "*Please provide an email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "password")
    @Length(min = 5, message = "*Your password must have at least 5 characters")
    @NotEmpty(message = "*Please provide your password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "active")
    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(userId, account.userId) &&
                Objects.equals(name, account.name) &&
                Objects.equals(surname, account.surname) &&
                Objects.equals(email, account.email) &&
                Objects.equals(password, account.password) &&
                Objects.equals(active, account.active);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, name, surname, email, password, active);
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_role", catalog = "", schema = "tau", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false), inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "role_id", nullable = false))
    @JsonBackReference
    public Set<Role> getUserRole() {
        return userRole;
    }

    public void setUserRole(Set<Role> userRole) {
        this.userRole = userRole;
    }

    @OneToMany(mappedBy = "calorieCalculatorAccount", cascade = CascadeType.ALL)
    @JsonManagedReference
    public List<CalorieCalculator> getAccountCalorieCalculator() {
        return accountCalorieCalculator;
    }

    public void setAccountCalorieCalculator(List<CalorieCalculator> accountCalorieCalculator) {
        this.accountCalorieCalculator = accountCalorieCalculator;
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
