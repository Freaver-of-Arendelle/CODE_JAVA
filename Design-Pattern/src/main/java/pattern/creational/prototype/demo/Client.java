package pattern.creational.prototype.demo;

/**
 * @author Freaver
 * @date 4/28/2021 18:44
 */
public class Client {

    public static void main(String[] args) throws CloneNotSupportedException {
        RealizedType realizedType = new RealizedType();

        RealizedType clone = realizedType.clone();

        System.out.println("原型对象和克隆出来的是否是同一个对象？" + (realizedType == clone));
    }
}
