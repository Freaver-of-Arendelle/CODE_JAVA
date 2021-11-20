import java.io.Serializable;

public class Employee implements Serializable{
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    String name;
    double Salary;
    // int year;
    // int month;
    // int day;

    public Employee(String name, double salary) {
        this.name = name;
        Salary = salary;
        // this.year = year;
        // this.month = month;
        // this.day = day;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return Salary;
    }

    @Override
    public String toString() {
        return "Employee [Salary=" + Salary + ", name=" + name + "]";
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(double salary) {
        Salary = salary;
    }

    // public String getHireDay() {
    // return year + "-" + month + "-" + day;
    // }

    public void raiseSalary(double salary) {
        this.Salary += salary;
    }

}
