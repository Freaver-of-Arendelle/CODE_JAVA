package pattern.structural.flyweight.demo;

import java.util.HashMap;

/**
 * @author Freaver
 * @date 4/28/2021 23:28
 */
public class BoxFactory {
    private static HashMap<String, AbstractBox> map;

    private BoxFactory() {
        map = new HashMap<>();
        AbstractBox iBox = new IBox();
        AbstractBox lBox = new LBox();
        AbstractBox oBox = new OBox();
        map.put("I", iBox);
        map.put("L", lBox);
        map.put("O", oBox);
    }

    public static final BoxFactory getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private static class SingletonHolder {
        private static final BoxFactory INSTANCE = new BoxFactory();
    }

    public AbstractBox getShape(String key) {
        return map.get(key);
    }



}
