import java.util.ArrayList;
import java.util.List;

/**
 * @author Freaver
 * @date 07/13/2021 23:43
 * @description
 */
public class RestoreIP {

    public static void main(String[] args) {
        RestoreIP ip1 = new RestoreIP();
        RestoreIP ip2 = new RestoreIP();
        RestoreIP ip3 = new RestoreIP();
        RestoreIP ip4 = new RestoreIP();
        RestoreIP ip5 = new RestoreIP();
        List<String> list1 = ip1.restoreIpAddresses("25525511135");
        List<String> list2 = ip2.restoreIpAddresses("0000");
        List<String> list3 = ip3.restoreIpAddresses("1111");
        List<String> list4 = ip4.restoreIpAddresses("010010");
        List<String> list5 = ip5.restoreIpAddresses("101023");

        System.out.println(list1);
        System.out.println(list2);
        System.out.println(list3);
        System.out.println(list4);
        System.out.println(list5);
    }

    static final int SEG_COUNT = 4;
    List<String> ans = new ArrayList<String>();
    int[] segments = new int[SEG_COUNT];

    public List<String> restoreIpAddresses(String s) {
        segments = new int[SEG_COUNT];
        dfs(s, 0, 0);
        return ans;
    }

    public void dfs(String s, int segId, int segStart) {
        if (segId == SEG_COUNT) {
            if (segStart == s.length()) {
                StringBuffer ipAddr = new StringBuffer();
                for (int i = 0; i < SEG_COUNT; ++i) {
                    ipAddr.append(segments[i]);
                    if (i != SEG_COUNT - 1) {
                        ipAddr.append('.');
                    }
                }
                ans.add(ipAddr.toString());
            }
            return;
        }

        if (segStart == s.length()) {
            return;
        }

        if (s.charAt(segStart) == '0') {
            segments[segId] = 0;
            dfs(s, segId + 1, segStart + 1);
        }

        int addr = 0;
        for (int segEnd = segStart; segEnd < s.length(); ++segEnd) {
            addr = addr * 10 + (s.charAt(segEnd) - '0');
            if (addr > 0 && addr <= 0xFF) {
                segments[segId] = addr;
                dfs(s, segId + 1, segEnd + 1);
            } else {
                break;
            }
        }
    }

}
