package pattern.behavioral.memento.black_box;


/**
 * @author Freaver
 * @date 5/3/2021 19:17
 */
public class RoleStateCaretaker {
    private Memento memento;

    public Memento getMemento() {
        return memento;
    }

    public void setMemento(Memento memento) {
        this.memento = memento;
    }
}
