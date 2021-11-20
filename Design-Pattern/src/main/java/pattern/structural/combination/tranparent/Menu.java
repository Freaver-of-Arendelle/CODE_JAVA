package pattern.structural.combination.tranparent;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Freaver
 * @date 4/28/2021 23:18
 */
public class Menu extends MenuComponent {

    private List<MenuComponent> menuComponentList = null;

    public Menu(String name, int level) {
        this.name = name;
        this.level = level;
        menuComponentList = new ArrayList<>();
    }

    @Override
    public void add(MenuComponent menuComponent) {
        menuComponentList.add(menuComponent);
    }

    @Override
    public void remove(MenuComponent menuComponent) {
        menuComponentList.remove(menuComponent);
    }

    @Override
    public MenuComponent getChild(int i) {
        return menuComponentList.get(i);
    }

    @Override
    public void print() {
        for (int i = 0; i < level; i++) {
            System.out.print("--");
        }
        System.out.println(name);

        for (MenuComponent menuComponent : menuComponentList) {
            menuComponent.print();
        }
    }
}
