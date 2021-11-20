package pattern.creational.prototype.shallow_clone;

/**
 * @author Freaver
 * @date 4/28/2021 19:47
 */
public class Student {

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
