package code.leetcode.stack_queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class _0150EvalRPN {
    public int evalRPN(String[] tokens) {
        Deque<Integer> que = new ArrayDeque<>();

        for (String s : tokens) {
            if ("+".equals(s)) { // leetcode 内置jdk的问题，不能使用==判断字符串是否相等
                que.push(que.pop() + que.pop());
            } else if ("-".equals(s)) {
                que.push(- que.pop() + que.pop());
            } else if ("*".equals(s)) {
                que.push(que.pop() * que.pop());
            } else if ("/".equals(s)) {
                int n2 = que.pop();
                int n1 = que.pop();
                que.push(n1 / n2);
            } else {
                que.push(Integer.valueOf(s));
            }
        }
        return que.pop();
    }
}
