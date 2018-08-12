package pl.krzysiek.domain.food;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "ready_meal", catalog = "tau")
public class ReadyMeal {

    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "meal_id")
    private long meal_id;

    @Column(name = "user_id")
    private long user_id;
    private String title;
    private String description;

    @Temporal(TemporalType.TIMESTAMP)
    private Date created_date;

    @Temporal(TemporalType.TIMESTAMP)
    private Date update_date;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "meal_id", referencedColumnName = "meal_id")
    private List<ReadyMealDetails> readyMealDetails;

    public ReadyMeal() {
    }

    public long getMeal_id() {
        return meal_id;
    }

    public void setMeal_id(long meal_id) {
        this.meal_id = meal_id;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getcreated_date() {
        return created_date;
    }

    public void setcreated_date(Date created_date) {
        this.created_date = created_date;
    }

    public Date getupdate_date() {
        return update_date;
    }

    public void setupdate_date(Date update_date) {
        this.update_date = update_date;
    }

    public List<ReadyMealDetails> getReadyMealDetails() {
        return readyMealDetails;
    }

    public void setReadyMealDetails(List<ReadyMealDetails> readyMealDetails) {
        this.readyMealDetails = readyMealDetails;
    }
}
