import org.junit.jupiter.api.Test;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;

/**
 * @author Freaver
 * @date 07/01/2021 20:56
 */
public class _121 {

    @Test
    void test() {
        _121 v = new _121();
        v.f();
    }

    public boolean f() {
        int x = 11;
        String s = String.valueOf(x);
        int i = 0;
        int j = s.length() - 1;
        while (i != j && i < s.length()) {


            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

}

    

