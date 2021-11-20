package pattern.behavioral.memento.black_box;


/**
 * @author Freaver
 * @date 5/3/2021 19:17
 */
public class Client {

    public static void main(String[] args) {
        System.out.println("================Before================");
        GameRole gameRole = new GameRole();
        gameRole.init();
        gameRole.show();

        RoleStateCaretaker roleStateCaretaker = new RoleStateCaretaker();
        roleStateCaretaker.setMemento(gameRole.saveState());

        System.out.println("================After================");
        gameRole.fight();
        gameRole.show();

        System.out.println("================Recover================");
        gameRole.recoverState(roleStateCaretaker.getMemento());
        gameRole.show();




    }
}
