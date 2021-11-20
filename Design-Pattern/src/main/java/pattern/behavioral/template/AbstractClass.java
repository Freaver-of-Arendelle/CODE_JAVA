package pattern.behavioral.template;

/**
 * @author Freaver
 * @date 4/29/2021 13:32
 */
public abstract class AbstractClass {

    public final void cookProcess() {
        this.pourOil();
        this.heatOil();
        this.pourVegetable();
        this.pourSauce();
        this.fry();
    }

    public void pourOil() {
        System.out.println("Pour oil");
    }

    public void heatOil() {
        System.out.println("Heat oil");
    }

    public abstract void pourVegetable();

    public abstract void pourSauce();

    public void fry() {
        System.out.println("Fry");
    }


}
