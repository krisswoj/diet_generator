package pl.krzysiek.domain;

import pl.krzysiek.domain.food.ReadyMeal;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "accounts", catalog = "tau")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private long id;

    private String name;
    private String surname;
    private String email;
    private String password;
    private int active;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private List<ReadyMeal> readyMeals;

    public Account() {
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public int getActive() { return active; }

    public void setActive(int active) { this.active = active; }

    public void setRoles(Set<Role> roles) { this.roles = roles; }

    public List<ReadyMeal> getReadyMeals() {
        return readyMeals;
    }

    public void setReadyMeals(List<ReadyMeal> readyMeals) {
        this.readyMeals = readyMeals;
    }
}
