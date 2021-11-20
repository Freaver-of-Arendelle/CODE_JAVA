import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Family> families = new ArrayList<Family>();
        List<Person> members = new ArrayList<Person>();
        List<Person> members2 = new ArrayList<Person>();
        // List<Person> members2 = new ArrayList<Person>();
        int id;
        String name;
        String gender;
        String address;
        String address2;
        int counter = 0;
        int i = 1;
        int j;

        address = in.nextLine();
        while (true) {
            id = in.nextInt();
            if (id != -1) {
                name = in.next();
                gender = in.next();
                members.add(new Person(id, name, gender));
            } else {
                families.add(new Family(address, members));
                in.nextLine();
                in.nextLine();
                break;
            }

        }
        Scanner in1 = new Scanner(System.in);
        address2 = in1.nextLine();
        while (true) {
            id = in1.nextInt();
            if (id != -1) {
                name = in1.next();
                gender = in1.next();
                members2.add(new Person(id, name, gender));
            } else {
                families.add(new Family(address2, members2));
                break;
            }
        }

        for (Family family : families) {
            System.out.println(family.address);
            System.out.println(i++);
            for (Person person : family.members) {
                System.out.println(person.toString());
            }
        }
    }

}

class Person {
    private int id;
    private String name;
    private String gender;

    public Person(int id, String name, String gender) {
        this.id = id;
        this.name = name;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return id + "-" + name + "-" + gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

class Family {
    String address;
    List<Person> members = new ArrayList<Person>();

    public Family(String address, List<Person> members) {
        this.address = address;
        this.members = members;
    }

    void addMember(Person member) {
        this.members.add(member);
    }

}