package pattern.behavioral.interpreter;

import java.io.PipedReader;

/**
 * @author Freaver
 * @date 5/4/2021 16:26
 */
public class Plus extends AbstractExpression {

    private AbstractExpression left;
    private AbstractExpression right;

    public Plus(AbstractExpression left, AbstractExpression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int interpret(Context context) {
        return left.interpret(context) + right.interpret(context);
    }

    @Override
    public String toString() {
        return "( " + left.toString() + " + " + right.toString() + ")";
    }
}
