package fastjsonDemo;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Freaver
 * @Time 07/12/2021 12:49
 * @Description
 */
public class Person implements Serializable {

    @JSONField(name="AGE", serialize=false)
    private int age;

    @JSONField(name="LAST NAME", ordinal = 2)
    private String lastName;

    @JSONField(name="FIRST NAME", ordinal = 1)
    private String firstName;

    @JSONField(name="DATE OF BIRTH",  ordinal = 3)
    private Date dateOfBirth;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Person(int age, String lastName, String firstName, Date dateOfBirth) {
        this.age = age;
        this.lastName = lastName;
        this.firstName = firstName;
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }

    // 标准 getters & setters

}
