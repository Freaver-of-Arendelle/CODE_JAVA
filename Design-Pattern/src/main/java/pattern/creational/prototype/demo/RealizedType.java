package pattern.creational.prototype.demo;

/**
 * @author Freaver
 * @date 4/28/2021 18:43
 */
public class RealizedType implements Cloneable{

    public RealizedType() {
        System.out.println("具体的原型对象创建完成！");
    }

    @Override
    protected RealizedType clone() throws CloneNotSupportedException {

        System.out.println("具体原型复制成功！");

        return (RealizedType)super.clone();
    }
}
