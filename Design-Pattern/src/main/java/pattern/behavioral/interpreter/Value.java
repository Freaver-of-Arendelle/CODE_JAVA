package pattern.behavioral.interpreter;

/**
 * @author Freaver
 * @date 5/4/2021 16:24
 */
public class Value extends AbstractExpression{
    private int value;

    public Value(int value) {
        this.value = value;
    }

    @Override
    public int interpret(Context context) {
        return value;
    }

    @Override
    public String toString() {
        return Integer.toString(value);
    }
}
