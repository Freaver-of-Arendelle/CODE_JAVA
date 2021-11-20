import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Freaver
 * @date 06/29/2021 21:21
 */
public class Encryption {


    public static String crypto(String clear, String key) {
        int Klength = key.length() - 1;
        int i = 0;
        int Clength = clear.length();
        char[] secret = new char[Clength];
        for (int j = 0; j < Clength; j++) {
            secret[j] = (char) (((clear.charAt(j) + key.charAt(i) - 97 * 2) % 26) + 97);
            if (i == Klength) {
                i = -1;
            }
            i++;
        }
        return Arrays.toString(secret);
    }

    public static String decrypt(String secret, String key) {
        int Klength = key.length() - 1;
        int i = 0;
        int Slength = secret.length();
        char[] clear = new char[Slength];
        for (int j = 0; j < Slength; j++) {
            clear[j] = (char) ((secret.charAt(j) - key.charAt(i) + 26) % 26 + 97);
            if (i == Klength) {
                i = -1;
            }
            i++;
        }
        return Arrays.toString(clear);
    }

    public static Box group(TextField textField, Label label) {
        Box verticalBox = Box.createVerticalBox();
        verticalBox.add(label);
        verticalBox.add(textField);
        return verticalBox;
    }


    public static void main(String[] args) {

        final String[] sclear = new String[1];
        final String[] skey = new String[1];

        Frame frame = new Frame("Encryptor");


        Label text = new Label("内容");
        TextField clearText = new TextField();
        clearText.addTextListener(e -> sclear[0] = clearText.getText());
        Box tBox = group(clearText, text);

        Label key = new Label("密钥");
        TextField keyText = new TextField();
        keyText.addTextListener(e -> skey[0] = keyText.getText());
        Box kBox = group(keyText, key);

        Box cBox = Box.createHorizontalBox();
        cBox.add(tBox);
        cBox.add(kBox);

        Button crypto = new Button("加密");
        crypto.addActionListener(e ->  {
            Label output = new Label(crypto(sclear[0], skey[0]));
            System.out.println(crypto(sclear[0], skey[0]));
            frame.add(output, BorderLayout.NORTH);
        });

        Button decrypt = new Button("解密");
        decrypt.addActionListener(e ->  {
            Label output = new Label(decrypt(sclear[0], skey[0]));
            frame.add(output, BorderLayout.NORTH);
        });

        Box sBox = Box.createHorizontalBox();
        sBox.add(crypto);
        sBox.add(decrypt);

        frame.add(cBox, BorderLayout.CENTER);
        frame.add(sBox, BorderLayout.SOUTH);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });






        frame.pack();
        frame.setVisible(true);



    }
}
