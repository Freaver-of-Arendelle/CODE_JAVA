package pattern.behavioral.memento.black_box;


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

    private class RoleStateMemento implements Memento {
        private int vit;
        private int atk;
        private int def;

        public RoleStateMemento(int vit, int atk, int def) {
            this.vit = vit;
            this.atk = atk;
            this.def = def;
        }

        public int getVit() {
            return vit;
        }

        public void setVit(int vit) {
            this.vit = vit;
        }

        public int getAtk() {
            return atk;
        }

        public void setAtk(int atk) {
            this.atk = atk;
        }

        public int getDef() {
            return def;
        }

        public void setDef(int def) {
            this.def = def;
        }
    }

    public Memento saveState() {
        return new RoleStateMemento(vit, atk, def);
    }

    public void recoverState(Memento memento) {
        RoleStateMemento roleStateMemento = (RoleStateMemento) memento;
        this.vit = roleStateMemento.getVit();
        this.atk = roleStateMemento.getAtk();
        this.def = roleStateMemento.getDef();
    }

    public void show() {
        System.out.println("Vitality: " + atk);
        System.out.println("Attack: " + atk);
        System.out.println("Defend: " + def);
    }
}
