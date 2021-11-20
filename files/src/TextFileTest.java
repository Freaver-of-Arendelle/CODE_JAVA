import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class TextFileTest {
    public static void main(String[] args) throws IOException {
        var staff = new Employee[3];
        staff[0] = new Employee("A", 1);
        staff[1] = new Employee("B", 2);
        staff[2] = new Employee("C", 3);

        try (var out = new PrintWriter("employee.dat", StandardCharsets.UTF_8)) {
            writeData(staff, out);
        }

        try (var in = new Scanner(new FileInputStream("employee.dat"), "UTF-8")) {
            Employee[] newStaff = readData(in);

            for (Employee e : newStaff) {
                System.out.println(e);
            }
        }
    }

    private static void writeData(Employee[] employees, PrintWriter out) throws IOException {
        out.println(employees.length);

        for (Employee e : employees) {
            writeEmployee(out, e);
        }

    }

    public static void delete(File f) {
        
    }

    private static Employee[] readData(Scanner in) {
        int n = in.nextInt();
        in.nextLine();

        var employees = new Employee[n];
        for (int i = 0; i < n; i++) {
            employees[i] = readEmployee(in);
        }
        return employees;
    }

    public static void writeEmployee(PrintWriter out, Employee e) {
        out.println(e.getName() + "|" + e.getSalary());
    }

    public static Employee readEmployee(Scanner in) {
        String line = in.nextLine();
        String[] tokens = line.split("\\|");
        String name = tokens[0];
        double salary = Double.parseDouble(tokens[1]);
        // LocalDate hirDate = LocalDate.parse(tokens[2]);
        // int year = hirDate.getYear();
        // int month = hirDate.getMonthValue();
        // int day = hirDate.getDayOfMonth();
        return new Employee(name, salary);

    }
}

