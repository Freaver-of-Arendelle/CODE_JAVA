import org.junit.jupiter.api.Test;

import java.util.Deque;
import java.util.LinkedList;

class Demo2 {

    @Test
    void test() {
        Demo2 demo2 = new Demo2();
        demo2.simplifyPath("/a//b////c/d//././/..");
    }

    public String simplifyPath(String path) {
        // 双端队列
        Deque<String> queue = new LinkedList<>();
        // 分割字符
        String[] res = path.split("/");
        for (int i = 0; i < res.length; i++) {
            String s = res[i];
            if (s.equals(".") || s.equals("")) {
                continue;
            } else if (s.equals("..")) {
                if (!queue.isEmpty()) {
                    queue.pollLast();
                }
            } else {
                queue.offer(s);
            }
        }
        // 拼接
        StringBuilder sb = new StringBuilder("/");
        while (!queue.isEmpty()) {
            sb.append(queue.poll());
            if (!queue.isEmpty()) {
                sb.append("/");
            }
        }
        // 判空
        return sb.toString().equals("") ? "/" : sb.toString();
    }
}

