package code.D.stack_queue;

import java.util.*;

public class LC71_simplifyPath {
    
    public String simplifyPath(String path) {
        String[] paths = path.split("/");
        Deque<String> st = new LinkedList<>();

        for (String name: paths) {
            if ("..".equals(name)) {
                if (!st.isEmpty()) st.pollLast();
            } else if (name.length() > 0 && !".".equals(name)) {
                st.offerLast(name);
            }
        }

        StringBuilder res = new StringBuilder();
        if (st.isEmpty()) {
            res.append("/");
        } else {
            while(!st.isEmpty()) {
                res.append("/");
                res.append(st.pollFirst());
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        LC71_simplifyPath s = new LC71_simplifyPath();
        System.out.println(s.simplifyPath("/a/./b/../../c/"));
    }
}
