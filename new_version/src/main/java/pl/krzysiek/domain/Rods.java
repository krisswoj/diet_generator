package pl.krzysiek.domain;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "rods", catalog = "tau")
public class Rods {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int rod_id;
    private String rod_brand;
    private String rod_model;
    private Integer rod_price;
    private String optional_information;

    public void setRod_id(int rod_id) { this.rod_id = rod_id; }

    public Integer getRod_id() {
        return rod_id;
    }

    public String getRod_brand() {
        return rod_brand;
    }

    public void setRod_brand(String rod_brand) {
        this.rod_brand = rod_brand;
    }

    public String getRod_model() {
        return rod_model;
    }

    public void setRod_model(String rod_model) {
        this.rod_model = rod_model;
    }

    public Integer getRod_price() {
        return rod_price;
    }

    public void setRod_price(Integer rod_price) {
        this.rod_price = rod_price;
    }

    public String getOptional_information() { return optional_information; }

    public void setOptional_information(String optional_information) { this.optional_information = optional_information; }
}
