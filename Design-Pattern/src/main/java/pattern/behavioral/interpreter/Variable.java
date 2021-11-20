package pattern.behavioral.interpreter;

/**
 * @author Freaver
 * @date 5/4/2021 16:29
 */
public class Variable extends AbstractExpression{

    private String name;

    public Variable(String name) {
        this.name = name;
    }

    @Override
    public int interpret(Context context) {
        return context.getValue(this);
    }

    @Override
    public String toString() {
        return name;
    }
}
