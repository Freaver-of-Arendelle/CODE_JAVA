import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author Freaver
 * @date 07/06/2021 20:38
 */
public class Demo {
//    @Test
//    void test() {
//        Demo demo = new Demo();
//        demo.restoreIpAddresses("25525511113");
//    }


    List<String> res = new ArrayList<>();
    Deque<String> segments = new ArrayDeque<>(4);


    public List<String> restoreIpAddresses(String s) {

        int len = s.length();

        if (len > 12 || len< 4) {
            return res;
        }
        dfs(s, 0, 4, len);

        return res;
    }

    public void dfs(String s, int start, int remain, int len) {
        if (start == len) {
            if (remain == 0) {
                res.add(String.join(".", segments));
            }
            return;
        }

        for (int i = start; i < start + 3; i++) {
            if (i >= len) {
                break;
            }

            if (remain * 3 < len - i) {
                continue;
            }

            if (isValid(s, start, i)) {
                segments.addLast(s.substring(start, i + 1));
                dfs(s, i + 1, remain - 1, len);
                segments.removeLast();
            }

        }
    }

    public boolean isValid(String s, int start, int end) {
        if (s.charAt(0) == '0' && end - start > 0) {
            return false;
        }
        int addr = 0;
        for (int i = start; i <= end; i++) {
            addr = addr * 10 + s.charAt(i) - '0';
        }
        return addr >= 0 && addr <= 255;
    }
}
