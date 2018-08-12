package pl.krzysiek.domain;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "rods", catalog = "tau")
public class Rods {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String brand;
    private String model;
    private Integer price;
    private String optional_information;

    public void setid(int id) { this.id = id; }

    public Integer getid() {
        return id;
    }

    public String getbrand() {
        return brand;
    }

    public void setbrand(String brand) {
        this.brand = brand;
    }

    public String getmodel() {
        return model;
    }

    public void setmodel(String model) {
        this.model = model;
    }

    public Integer getprice() {
        return price;
    }

    public void setprice(Integer price) {
        this.price = price;
    }

    public String getOptional_information() { return optional_information; }

    public void setOptional_information(String optional_information) { this.optional_information = optional_information; }
}
