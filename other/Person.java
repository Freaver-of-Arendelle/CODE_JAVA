import java.io.Serializable;

public class Person implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private static Person singleton = null;

    private String name;
    private int age;

    private Person() {
    }

    public static Person getSingleton() {
        if (singleton == null) {
            synchronized (Person.class) {
                if (singleton == null) {
                    singleton = new Person();
                }
            }
        }
        return singleton;
    }

    public static void setSingleton(Person singleton) {
        Person.singleton = singleton;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person [age=" + age + ", name=" + name + "]";
    }

}
