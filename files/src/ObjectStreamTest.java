import java.io.*;

public class ObjectStreamTest {
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        var a = new Employee("A", 1);
        var b = new Manager("B", 2);
        b.setSecretary(a);
        var c = new Manager("C", 3);
        c.setSecretary(a);

        var staff = new Employee[3];

        staff[0] = a;
        staff[1] = b;
        staff[2] = c;

        try (var out = new ObjectOutputStream(new FileOutputStream("employee.dat"))) {
            out.writeObject(staff);
        }

        try (var in = new ObjectInputStream(new FileInputStream("employee.dat"))) {
            var newStaff = (Employee[]) in.readObject();
            // var newStaff1 = (Manager[]) in.readObject();

            newStaff[1].raiseSalary(10);

            for (Employee e : newStaff) {
                if (e instanceof Manager)
                    System.out.println((Manager)e);
                else
                    System.out.println(e);
            }
                // System.out.println(e);
            

            // for (Manager m : newStaff1)
                // System.out.println(m);
        }
    }

}