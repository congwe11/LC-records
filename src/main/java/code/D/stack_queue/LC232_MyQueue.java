package code.D.stack_queue;

import java.util.*;

public class LC232_MyQueue {
    Deque<Integer> st1;
    Deque<Integer> st2;

    public LC232_MyQueue() {
        st1 = new ArrayDeque<>();
        st2 = new ArrayDeque<>();
    }
    
    public void push(int x) {
        st1.addFirst(x);
    }
    
    public int pop() {
        if (!st2.isEmpty()) {
            return st2.pollFirst();
        } else {
            while (!st1.isEmpty()) {
                st2.addFirst(st1.pollFirst());
            }
            return st2.pollFirst();
        }
    }
    
    public int peek() {
        int res = this.pop();
        st2.addFirst(res);
        return res;
    }
    
    public boolean empty() {
        return st1.isEmpty() && st2.isEmpty();
    }
}
