import java.util.InputMismatchException;

import java.util.Scanner;

//从键盘输入数，判断，是double型则输出。通过循环变量退出do-while循环

//若不是，则系统提示异常，该异常被catch语句捕获。catch语句用来显示数据输入错误提示信息。

//并提示用户重新输入，然后通过循环变量使do-while循环继续执行。 要求用户重新输入

//其中 Scanner中的方法 String nextline()的作用是：

//扫描当前行，并返回跳过的输入信息。由此。。。定是Scanner类的方法

public class h {
    public static void main(String[] args) {
        Scanner c = new Scanner(System.in);

        boolean a = false;

        do {
            try {
                System.out.println("请输入数据：");

                double x = c.nextDouble();

                System.out.println(x);

                a = false;

            } catch (InputMismatchException A) {
                System.out.println("数据输入无效，请重新输入");

                System.out.println("message:" + A);

                // a=true;//如果省略了这最关键的一步，

                // 那么程序无法继续执行，它会终止。因为异常虽被捕捉了。但是还是错误的

                // 所以这里要修改默认值，即让程序继续执行下去，让循环变量为true,使之有效！！！

                String b = c.nextLine();// nextline()方法是扫描器执行当前行，返回跳过的输入信息是Scanner类的方法

            }

        } while (a = true);// 我在这里修改了下程序。本来这里是对于正确输入是退出(while(a);)，不会继续下去。

    }// a=true时。它在do循环外面。所以无论输入对否。它会继续循环下去。干嘛输入对了一次就不输入了。

}// 程序的运行也会有偶然性。有时候，有的bug在中间，而不是开始的时候。多验证输入几次，增强准确性

//
