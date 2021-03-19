import java.util.Scanner;
import java.util.Vector;

public class test {
    public static void main(String[] args) {
        Vector<Integer> n = new Vector<>();
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            n.add(in.nextInt());
        }
        in.close();
        Num num = new Num(n);
        num.printSort();
    }
}

class Num {
    Vector<Integer> n = new Vector<>();

    public Num(Vector<Integer> n) {
        this.n = n;
    }

    public void printSort() {
        n.sort(null);
        System.out.println(n);
    }
}
