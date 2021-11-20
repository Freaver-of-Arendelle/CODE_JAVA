import java.util.List;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class test {
    static List<Student> students = new ArrayList<>();
    static {
        try {
             PrintWriter printWriter = new PrintWriter("Student2.dat", StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        students.add(new Student("A", 1, 10));
        students.add(new Student("B", 2, 10));
        students.add(new Student("C", 3, 10));
        students.add(new Student("D", 4, 10));
        try (PrintWriter out = new PrintWriter("Student.dat", StandardCharsets.UTF_8))  {
        for (var c : students) {
            printwriter
            out.println(c.toString() + "|"+ " ");
            // System.out.println(c);
        }

        }
        
    }
}
