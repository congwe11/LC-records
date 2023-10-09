package code.D.stack_queue;

import java.util.*;

public class LC1047_removeDuplicates {

    public static void main(String[] args) {
        LC1047_removeDuplicates s = new LC1047_removeDuplicates();

        System.out.println(s.removeDuplicates("abbaca"));
    }
    
    public String removeDuplicates(String s) {
        
        Deque<Character> st = new ArrayDeque<>();

        st.push(s.charAt(0));

        for (int i = 1; i < s.length(); i++) {
            if (!st.isEmpty() && s.charAt(i) == st.peek()) {
                st.pop();
            } else {
                st.push(s.charAt(i));
            }
        }

        String res = "";
        while (!st.isEmpty()) {
            res = st.pop() + res;
        }
        return res;
    }
    
    public String removeDuplicates2(String s) {
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (str.length() == 0 || str.charAt(str.length() - 1) == s.charAt(i)) {
                str.append(s.charAt(i));
            } else {
                str.deleteCharAt(str.length() - 1);
            }
        }
        return str.toString();
    }
}
