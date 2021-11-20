package pattern.creational.prototype.deep_clone;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author Freaver
 * @date 4/28/2021 18:49
 */
public class CitationTest {

    public static void main(String[] args) throws Exception {
        Citation c1 = new Citation();

        Student student = new Student();

        student.setName("Zhang");
        c1.setStudent(student);

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:\\CODE\\CODE_JAVA\\Design-Pattern\\src\\main\\java\\pattern\\creational\\prototype\\deep_clone\\a.dat"));

        oos.writeObject(c1);

        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D:\\CODE\\CODE_JAVA\\Design-Pattern\\src\\main\\java\\pattern\\creational\\prototype\\deep_clone\\a.dat"));

        Citation c2 = (Citation) ois.readObject();

        ois.close();

        Student student2 = c2.getStudent();
        student2.setName("Li");

        c1.show();
        c2.show();
    }
}
