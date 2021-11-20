import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Freaver
 * @Time 08/01/2021 00:57
 * @Description
 */
public class Test {
    private static List<BigInteger> list = new ArrayList<>();

    public static void f() {
        list.add(BigInteger.valueOf(3));
        list.add(BigInteger.valueOf(20));

        for (int i = 2; i < 251; i++) {
            BigInteger big = list.get(i - 1);
            big = big.multiply(BigInteger.valueOf(6));
            big = big.subtract(list.get(i - 2));

            big = big.add(BigInteger.valueOf(2));
            list.add(big);
        }
    }

    public static void main(String[] args) {
        f();
        int t;
        Scanner in = new Scanner(System.in);
        t = in.nextInt();
        for (int i = 0; i < t; i++) {
            BigInteger input;
            input = in.nextBigInteger();
            for (int j = 0; j < 251; j++) {
                if (list.get(j).compareTo(input) >= 0) {
                    System.out.println(list.get(j));
                    break;
                }

            }
        }

    }

}
