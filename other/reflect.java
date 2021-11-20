public class reflect {

    public static void main(String[] args) {
        Person p1 = Person.getSingleton();
        Person p2 = Person.getSingleton();

        System.out.println(p1.getClass() == p2.getClass());
    }

}