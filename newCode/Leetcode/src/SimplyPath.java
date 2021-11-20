import java.util.*;

/**
 * @author Freaver
 * @date 07/06/2021 19:15
 */
public class SimplyPath {

    public static void main(String[] args) {
        SimplyPath simplyPath = new SimplyPath();
        String s1 = simplyPath.simplifyPath("/a//b////c/d//././/..");
        String s2 = simplyPath.simplifyPath("/home/");
        String s3 = simplyPath.simplifyPath("/../");
        String s4 = simplyPath.simplifyPath("/home//foo/");
        String s5 = simplyPath.simplifyPath("/a/./b/../../c/");
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s4);
        System.out.println(s5);
    }

    public String simplifyPath(String path) {
        Deque<String> strings = new ArrayDeque<>();
        String[] split = path.split("/");
        int length = split.length;
        for (int i = 0; i < length; i++) {
            String s = split[i];
            if (s.equals(".") || s.equals("")) {
                continue;
            } else if (s.equals("..")) {
                if (!strings.isEmpty()) {
                    strings.pollLast();
                }
            } else {
                strings.offer(s);
            }
        }

        return "/" + String.join("/", strings);
    }
}
