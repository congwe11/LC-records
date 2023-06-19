package code.leetcode.stack_queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class _0020isValid {
    public boolean isValid(String s) {

        Deque<Character> que = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') que.push(')');
            else if (ch == '{') que.push('}');
            else if (ch == '[') que.push(']');
            else {
                if(que.isEmpty() || que.peek() != ch) {
                    return false;
                }
                que.pop();
            }
        }
        return que.isEmpty();
    }
}
