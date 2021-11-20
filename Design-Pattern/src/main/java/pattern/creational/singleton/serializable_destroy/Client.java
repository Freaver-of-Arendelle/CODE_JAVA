package pattern.creational.singleton.serializable_destroy;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author Freaver
 * @date 4/27/2021 22:39
 */
public class Client {

    public static void main(String[] args) throws Exception{
        writeObjectToFile();
        readObjectFromFile();
//        writeObjectToFile();
        readObjectFromFile();

    }


    public static void readObjectFromFile() throws Exception {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D:\\CODE\\CODE_JAVA\\Design-Pattern\\src\\main\\java\\pattern\\singleton\\serializable_destroy\\test.dat"));

        Singleton instance = (Singleton) ois.readObject();

        System.out.println(instance);

        ois.close();


    }

    public static void writeObjectToFile() throws Exception {
        Singleton instance = Singleton.getInstance();

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:\\CODE\\CODE_JAVA\\Design-Pattern\\src\\main\\java\\pattern\\singleton\\serializable_destroy\\test.dat"));

        oos.writeObject(instance);

        oos.close();
    }
}
