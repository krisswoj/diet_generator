package pl.krzysiek.domain;

import javax.persistence.*;

@Entity
@Table(name = "users", schema = "tau", catalog = "")
public class Users {

    private int id;
    private String name;
    private int age;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    @Column(name = "age")
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public Users() {
    }

    public Users(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Users(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Users(String name, int age) {
        this.name = name;
        this.age = age;
    }
}


