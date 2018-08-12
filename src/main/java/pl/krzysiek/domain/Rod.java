package pl.krzysiek.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Rod {
    private int id;
    private String brand;
    private String model;
    private Integer price;
    private String optionalInformation;

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
    @Column(name = "brand")
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Basic
    @Column(name = "model")
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Basic
    @Column(name = "price")
    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Basic
    @Column(name = "optional_information")
    public String getOptionalInformation() {
        return optionalInformation;
    }

    public void setOptionalInformation(String optionalInformation) {
        this.optionalInformation = optionalInformation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rod rod = (Rod) o;
        return id == rod.id &&
                Objects.equals(brand, rod.brand) &&
                Objects.equals(model, rod.model) &&
                Objects.equals(price, rod.price) &&
                Objects.equals(optionalInformation, rod.optionalInformation);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, brand, model, price, optionalInformation);
    }
}
