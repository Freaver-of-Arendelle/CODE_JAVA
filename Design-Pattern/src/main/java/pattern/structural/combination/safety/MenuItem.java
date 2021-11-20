package pattern.structural.combination.safety;

/**
 * @author Freaver
 * @date 4/28/2021 23:22
 */
public class MenuItem extends MenuComponent {
    public MenuItem(String name, int level) {
        this.name = name;
        this.level = level;
    }

    @Override
    public void print() {
        for (int i = 0; i < level; i++) {
            System.out.print("--");
        }

        System.out.println(name);
    }
}
