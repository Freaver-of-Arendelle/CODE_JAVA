package pattern.creational.prototype.deep_clone;

import java.io.Serializable;

/**
 * @author Freaver
 * @date 4/28/2021 19:47
 */
public class Student implements Serializable {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }
}
