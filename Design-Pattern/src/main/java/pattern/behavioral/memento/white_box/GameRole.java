package pattern.behavioral.memento.white_box;

/**
 * @author Freaver
 * @date 5/3/2021 19:11
 */
public class GameRole {

    private int vit;
    private int atk;
    private int def;

    public void init() {
        this.atk = 100;
        this.def = 100;
        this.vit = 100;
    }

    public void fight() {
        this.vit = 0;
        this.atk = 0;
        this.def = 0;
    }

    public RoleStateMemento saveState( ) {
        return new RoleStateMemento(vit, atk, def);
    }

    public void recoverState(RoleStateMemento roleStateMemento) {
        this.vit = roleStateMemento.getVit();
        this.atk = roleStateMemento.getAtk();
        this.def = roleStateMemento.getDef();
    }

    public void show() {
        System.out.println("Vitality: "+ atk);
        System.out.println("Attack: " + atk);
        System.out.println("Defend: " + def) ;
    }
}
