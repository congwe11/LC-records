package code.D.stack_queue;

import java.util.*;

public class LC20_isValid {

    public boolean isValid(String s) {
        Deque<Character> st = new ArrayDeque<>();

        // 如果遇见左括号就压入一个对应的右括号，
        // 遇见右括号，就弹出一个栈顶元素比对

        for (int i = 0; i < s.length(); i++) {
            if ('(' == s.charAt(i)) st.push(')');
            else if (s.charAt(i) == '{') st.push('}');
            else if (s.charAt(i) == '[') st.push(']');
            else {
                if (st.isEmpty()) return false;
                if (st.pop() != s.charAt(i)) {
                    return false;
                }
            }
        }
        return st.isEmpty();
    }

    public static void main(String[] args) {
        LC20_isValid s = new LC20_isValid();

        System.out.println(s.isValid("([{}])"));
    }
    
}
