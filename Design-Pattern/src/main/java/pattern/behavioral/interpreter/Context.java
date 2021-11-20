package pattern.behavioral.interpreter;

import java.io.PipedReader;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Freaver
 * @date 5/4/2021 16:24
 */
public class Context {

    private final Map<Variable, Integer> map = new HashMap<>();

    public void assign(Variable variable, Integer integer) {
        map.put(variable, integer);
    }

    public int getValue(Variable variable) {
        return map.get(variable);
    }


}
