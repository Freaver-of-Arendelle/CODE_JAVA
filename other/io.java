import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class io {

    public static void fileWriter(Person person) throws Exception {
        PrintWriter printWriter = new PrintWriter(new FileOutputStream("Person.dat", true));
        String name = person.getName();
        int age = person.getAge();
        printWriter.print(name);
        printWriter.print("-");
        printWriter.print(age);
        // printWriter.print("|");
        printWriter.close();
        // fos.close();
    }

    public static void fileOutputStreamWriter(Person person) throws Exception {
        FileOutputStream fos = new FileOutputStream("Person.dat", true);
        String name = person.getName();
        // byte[] byteName = name.getBytes();
        Integer age = person.getAge();

        fos.write(name.getBytes());
        fos.write("-".getBytes());
        fos.write(age.toString().getBytes());
        fos.write("|".getBytes());

        fos.close();
    }

    public static Person fileInputStreamReader(String string) throws Exception {
        FileInputStream fis = new FileInputStream(string);
        char[] bytes = new char[10];
        char[] chars = new char[10];
        int i = 0;
        while (true) {
            char c = (char) fis.read();
            if (c == '-') {
                break;
            } else {
                chars[i] = c;
                i++;
            }
        }
        String name = chars.toString();
        i = 0;
        while (true) {
            char c = (char) fis.read();
            if (c == '|') {
                break;
            } else {
                bytes[i] = c;
                i++;
            }
        }
        int age = Integer.parseInt(bytes.toString());
        Person person = Person.getSingleton();
        person.setName(name);
        person.setAge(age);
        fis.close();
        return person;

    }

    public static void objectWriter(Person person) throws Exception {

        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("PersonObject.dat"));
        outputStream.writeObject(person);
        outputStream.close();
    }

    public static Person objectReader(String string) throws Exception {
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(string));
        Person person = (Person) inputStream.readObject();
        inputStream.close();
        return person;
    }

    public static Person fileReader(String string) throws Exception {
        // Scanner in = new Scanner(new FileInputStream(string));

        BufferedReader bufferedReader = new BufferedReader(new FileReader(string));


        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), "-");
        String name = stringTokenizer.nextToken();
        int age = Integer.parseInt(stringTokenizer.nextToken());
        Person person = Person.getSingleton();
        person.setName(name);
        person.setAge(age);
        bufferedReader.close();
        return person;

    }

    // public static void dataWriter(Person person) throws Exception {
    //     FileWriter
    // }
    public static void main(String[] args) throws Exception {

        Person person = Person.getSingleton();
        person.setAge(100);
        person.setName("A");
        fileWriter(person);
        Person newPerson = fileReader("Person.dat");
        // Person person2 = Person.getSingleton();
        // person.setAge(200);
        // person.setName("B");
        // fileWriter(person2);

        
        // Person newPerson2 = fileReader("Person.dat");
        System.out.println(newPerson);
        // System.out.println(newPerson2);


    }

}
