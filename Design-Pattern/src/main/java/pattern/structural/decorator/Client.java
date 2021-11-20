package pattern.structural.decorator;

/**
 * @author Freaver
 * @date 4/25/2021 23:39
 */
public class Client {
    public static void main(String[] args) {

        FastFood food = new FriedRice();

        System.out.println(food.getDesc() + " " + food.cost() + "Yuan");

        System.out.println("=================");

        FastFood food1 = new FriedRice();

        food1 = new Egg(food1);

        System.out.println(food1.getDesc() + " " + food1.cost() + "Yuan");

        System.out.println("=================");

        FastFood food2 = new FriedNoodles();

        food2 = new Bacon(food2);

        System.out.println(food2.getDesc() + " " + food2.cost() + "Yuan");
    }
}
