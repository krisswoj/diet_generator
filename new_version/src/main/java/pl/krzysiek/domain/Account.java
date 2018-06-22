package pl.krzysiek.domain;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private long id;

    @Column(name = "name")
    @NotEmpty(message = "Wprowadz swoje imie")
    private String name;


    @Column(name = "surname")
    @NotEmpty(message = "Wprowadz swoje nazwisko")
    private String surname;

    @Column(name = "email")
    @NotEmpty(message = "Wprowadz swoj adres e-mail")
    @Email(message = "Wprowadź poprawny adres e-mail")
    private String email;

    @Column(name = "password")
    @NotEmpty(message = "Wprowadź hasło")
    private String password;

    public Account(int id, String name, String surname, String email, String password) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
    }

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
}
