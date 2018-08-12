package pl.krzysiek.domain.food;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Entity
@Table(name = "calorie_calculator", catalog = "tau")
public class CalorieCalculator {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "sex")
//    @NotEmpty(message = "Wprowadz swoja plec")
    private int sex;

    @Column(name = "weight")
//    @NotEmpty(message = "Wprowadz swoja wage")
    private int weight;

    @Column(name = "height")
//    @NotEmpty(message = "Wprowadz swoj wzrost")
    private int height;

    @Column(name = "age")
//    @NotEmpty(message = "Wprowadz swoj wiek")
    private int age;

    @Column(name = "planned_effort")
//    @NotEmpty(message = "Okresl przewidywany wysilek fizyczny")
    private int planned_effort;

    @Column(name = "body_goal")
//    @NotEmpty(message = "Okresl swoj cel")
    private int body_goal;

    @Column(name = "user_id")
    private long user_id;

    @Column(name = "body_type")
    private int body_type;

    @Column(name = "calories_demand")
    private int calories_demand;

    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created_date;

    @Column(name = "update_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date update_date;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getplanned_effort() {
        return planned_effort;
    }

    public void setplanned_effort(int planned_effort) {
        this.planned_effort = planned_effort;
    }

    public int getbody_goal() {
        return body_goal;
    }

    public void setbody_goal(int body_goal) {
        this.body_goal = body_goal;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
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

    public int getBody_type() {
        return body_type;
    }

    public void setBody_type(int body_type) {
        this.body_type = body_type;
    }

    public int getcalories_demand() {
        return calories_demand;
    }

    public void setcalories_demand(int calories_demand) {
        this.calories_demand = calories_demand;
    }
}
