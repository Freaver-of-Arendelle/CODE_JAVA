package pattern.creational.prototype.shallow_clone;

/**
 * @author Freaver
 * @date 4/28/2021 18:49
 */
public class CitationTest {

    public static void main(String[] args) throws CloneNotSupportedException {
        Citation c1 = new Citation();

        Student student = new Student();

        student.setName("Zhang");
        c1.setStudent(student);

        Citation c2 = c1.clone();
        Student student1 = c2.getStudent();
        student1.setName("Li");

        c1.show();
        c2.show();
    }
}
