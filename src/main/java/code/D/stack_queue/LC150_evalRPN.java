package code.D.stack_queue;

import java.util.*;

public class LC150_evalRPN {

    public static void main(String[] args) {
        LC150_evalRPN s = new LC150_evalRPN();
        String[] tokens = new String[]{"2","1","+","3","*"};
        System.out.println(s.evalRPN(tokens));
    }
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        
        for (int i = 0; i < tokens.length; i++) {
            String x = tokens[i];
            if (x.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            } else if (x.equals("-")) {
                stack.push( - stack.pop() + stack.pop());
            } else if (x.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else if (x.equals("/")) {
                int x1 = stack.pop();
                int x2 = stack.pop();
                stack.push(x2 / x1);
            } else {
                stack.push(Integer.valueOf(tokens[i]));
            }
        }
        return stack.pop();
    }
}
