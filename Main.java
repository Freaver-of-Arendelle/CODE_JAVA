public class Main {
    public static void main(String[] args) {
        Person p1 = new Person();

        Person p2 = new Person("Jerry", 'M', 1990);

        Person p3 = new Person("Jane", 'F', 2000);

        p1.showMe();

        p2.showMe();

        p3.showMe();
    }
    
}

class Person {
    String name = "";
    char gender;
    int number = 0;

    public void showMe() {
        String gender = null;
        if (this.gender == 'M')
            gender = "male";
        else if (this.gender == 'F')
            gender = "female";
        else
            gender = "unknown";

        String str = name + "-" + gender + "-" + number;
        System.out.println(str);
    }

    public Person(String name, char gender, int number) {
        this.name = name;
        this.gender = gender;
        this.number = number;
    }

    public Person() {
    }
}
