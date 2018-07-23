package pl.krzysiek.domain.food;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Entity
@Table(name = "calorie_calculator", catalog = "tau")
public class CalorieCalculator {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "calculator_id")
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

    @Column(name = "plannedEffort")
//    @NotEmpty(message = "Okresl przewidywany wysilek fizyczny")
    private int plannedEffort;

    @Column(name = "bodyGoal")
//    @NotEmpty(message = "Okresl swoj cel")
    private int bodyGoal;

    @Column(name = "user_id")
    private long user_id;

    @Column(name = "body_type")
    private int body_type;

    @Column(name = "caloriesDemand")
    private int caloriesDemand;

    @Column(name = "createdDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Column(name = "updateDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;

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

    public int getPlannedEffort() {
        return plannedEffort;
    }

    public void setPlannedEffort(int plannedEffort) {
        this.plannedEffort = plannedEffort;
    }

    public int getBodyGoal() {
        return bodyGoal;
    }

    public void setBodyGoal(int bodyGoal) {
        this.bodyGoal = bodyGoal;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public int getBody_type() {
        return body_type;
    }

    public void setBody_type(int body_type) {
        this.body_type = body_type;
    }

    public int getCaloriesDemand() {
        return caloriesDemand;
    }

    public void setCaloriesDemand(int caloriesDemand) {
        this.caloriesDemand = caloriesDemand;
    }
}
