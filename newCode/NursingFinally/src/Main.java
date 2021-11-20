import java.math.BigInteger;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        BigInteger[] res = new BigInteger[101];
        Scanner in = new Scanner(System.in);
        res[1] = BigInteger.valueOf(1);
        res[2] = BigInteger.valueOf(2);

        for (int i = 3; i <= 100; i++) {
            res[i] = res[i - 1].multiply(BigInteger.valueOf(4 * i - 2)).divide(BigInteger.valueOf(i + 1));
        }

        int input;
        while (in.hasNext()) {
            input = in.nextInt();
            System.out.println(res[input]);
        }
    }
}