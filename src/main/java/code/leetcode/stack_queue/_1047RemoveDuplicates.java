package code.leetcode.stack_queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class _1047RemoveDuplicates {
    public static String removeDuplicates(String s) {

        Deque<Character> que = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        que.push(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!que.isEmpty() && que.peekLast() == ch) {
                que.removeLast();
            } else {
                que.offerLast(ch);
            }
        }
        while (!que.isEmpty()) {
            sb.append(que.pollFirst());
        }
        return sb.toString();
    }

    public String removeDuplicates1(String s) {
        // 直接拿Str 作为栈
        StringBuilder sb = new StringBuilder();
        int top = -1;
        for (int i=0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (top < 0 || sb.charAt(top) != ch) {
                sb.append(ch);
                top++;
            } else {
                sb.deleteCharAt(top);
                top--;
            }
        }
        return sb.toString();

    }

    public static void main(String[] args) {
        String s = "abbaca";
        String s1 = removeDuplicates(s);
        System.out.println("s1 = " + s1);
    }
}
