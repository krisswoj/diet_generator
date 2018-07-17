package pl.krzysiek.domain;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "rods")
public class Rods {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "rod_id")
    private int rod_id;

    @Column(name = "rod_brand")
    @NotEmpty(message = "Wprowadz marke wedki")
    private String rod_brand;

    @Column(name = "rod_model")
    @NotEmpty(message = "Wprowadz model wedki")
    private String rod_model;

    @Column(name = "rod_price")
    private Integer rod_price;

    @Column(name = "optional_information")
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
