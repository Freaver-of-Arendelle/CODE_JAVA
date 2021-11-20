package pattern.behavioral.template;

/**
 * @author Freaver
 * @date 4/29/2021 13:35
 */
public class ConcreteClass_BaoCai extends AbstractClass{
    @Override
    public void pourVegetable() {
        System.out.println("Baocai");

    }

    @Override
    public void pourSauce() {
        System.out.println("Lajiao");
    }
}
