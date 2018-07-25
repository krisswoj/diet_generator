package pl.krzysiek.domain;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "calorie_calculator", schema = "tau", catalog = "")
public class CalorieCalculator {
    private int id;
    private Integer sex;
    private Integer weight;
    private Integer height;
    private Integer age;
    private Integer plannedEffort;
    private Integer bodyGoal;
    private Integer bodyType;
    private Integer caloriesDemand;
    private Timestamp createdDate;
    private Timestamp updateDate;
    private Account accountByUserId;

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
    @Column(name = "sex")
    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    @Basic
    @Column(name = "weight")
    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @Basic
    @Column(name = "height")
    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    @Basic
    @Column(name = "age")
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Basic
    @Column(name = "planned_effort")
    public Integer getPlannedEffort() {
        return plannedEffort;
    }

    public void setPlannedEffort(Integer plannedEffort) {
        this.plannedEffort = plannedEffort;
    }

    @Basic
    @Column(name = "body_goal")
    public Integer getBodyGoal() {
        return bodyGoal;
    }

    public void setBodyGoal(Integer bodyGoal) {
        this.bodyGoal = bodyGoal;
    }

    @Basic
    @Column(name = "body_type")
    public Integer getBodyType() {
        return bodyType;
    }

    public void setBodyType(Integer bodyType) {
        this.bodyType = bodyType;
    }

    @Basic
    @Column(name = "calories_demand")
    public Integer getCaloriesDemand() {
        return caloriesDemand;
    }

    public void setCaloriesDemand(Integer caloriesDemand) {
        this.caloriesDemand = caloriesDemand;
    }

    @Basic
    @Column(name = "created_date")
    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    @Basic
    @Column(name = "update_date")
    public Timestamp getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Timestamp updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CalorieCalculator that = (CalorieCalculator) o;
        return id == that.id &&
                Objects.equals(sex, that.sex) &&
                Objects.equals(weight, that.weight) &&
                Objects.equals(height, that.height) &&
                Objects.equals(age, that.age) &&
                Objects.equals(plannedEffort, that.plannedEffort) &&
                Objects.equals(bodyGoal, that.bodyGoal) &&
                Objects.equals(bodyType, that.bodyType) &&
                Objects.equals(caloriesDemand, that.caloriesDemand) &&
                Objects.equals(createdDate, that.createdDate) &&
                Objects.equals(updateDate, that.updateDate);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, sex, weight, height, age, plannedEffort, bodyGoal, bodyType, caloriesDemand, createdDate, updateDate);
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    public Account getAccountByUserId() {
        return accountByUserId;
    }

    public void setAccountByUserId(Account accountByUserId) {
        this.accountByUserId = accountByUserId;
    }
}
