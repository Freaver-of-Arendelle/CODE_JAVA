import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author Freaver
 * @date 06/29/2021 19:58
 */
public class Calculator {

    private static final int SIGNAL_ADD = 1;
    private static final int SIGNAL_SUB = 2;
    private static final int SIGNAL_MUL = 3;
    private static final int SIGNAL_DIV = 4;

    public static void main(String[] args) {
        final double[] dx = {0};
        final double[] dy = {0};
        final double[] danwser = {0};
        final int[] ssignal = {0};

        Frame frame = new Frame("Calculator");

        Label x = new Label("X");
        TextField input1 = new TextField(30);
        input1.addTextListener(e -> dx[0] = Double.parseDouble(input1.getText()));
        Box iBox1 = group(input1, x);

        Label y = new Label("Y");
        TextField input2 = new TextField(30);
        input2.addTextListener(e -> dy[0] = Double.parseDouble(input2.getText()));
        Box iBox2 = group(input2, y);

        Label ans = new Label("answer");
        TextField answer = new TextField(30);
        Box aBox = group(answer, ans);

        Button plus = new Button("+");
        plus.addActionListener(e -> ssignal[0] = 1);

        Button sub = new Button("-");
        sub.addActionListener(e -> ssignal[0] = 2);

        Button mul = new Button("*");
        mul.addActionListener(e -> ssignal[0] = 3);

        Button div = new Button("/");
        div.addActionListener(e -> ssignal[0] = 4);


        Box sBox = Box.createHorizontalBox();
        sBox.add(plus);
        sBox.add(sub);
        sBox.add(mul);
        sBox.add(div);


        Box hBox = Box.createHorizontalBox();
        hBox.add(iBox1);
        hBox.add(Box.createHorizontalStrut(10));
        hBox.add(iBox2);

        Box cBox = Box.createVerticalBox();
        cBox.add(hBox);
        cBox.add(Box.createVerticalGlue());
        cBox.add(sBox);
        frame.add(aBox, BorderLayout.NORTH);
        frame.add(cBox, BorderLayout.CENTER);

        Button ok = new Button("OK");
        ok.addActionListener(e -> {
            switch (ssignal[0]) {
                case SIGNAL_ADD:
                    danwser[0] = dx[0] + dy[0];
                    break;
                case SIGNAL_SUB:
                    danwser[0] = dx[0] - dy[0];
                    break;
                case SIGNAL_MUL:
                    danwser[0] = dx[0] * dy[0];
                    break;
                case SIGNAL_DIV:
                    danwser[0] = dx[0] / dy[0];
                    break;
            }
            answer.setText(String.valueOf(danwser[0]));
        });
        frame.add(ok, BorderLayout.SOUTH);

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        frame.pack();
        frame.setVisible(true);


    }

    public static Box group(TextField textField, Label label) {
        Box verticalBox = Box.createVerticalBox();
        verticalBox.add(label);
        verticalBox.add(textField);
        return verticalBox;
    }
}
