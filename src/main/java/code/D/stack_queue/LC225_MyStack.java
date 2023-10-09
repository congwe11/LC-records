package code.D.stack_queue;

import java.util.*;

public class LC225_MyStack {
    Deque<Integer> que;

    public LC225_MyStack() {
        que = new ArrayDeque<>();
    }
    
    public void push(int x) {
        que.offerFirst(x);
    }
    
    public int pop() {
        int size = que.size();

        for (int i = 0; i < size - 1; i++) {
            que.offerFirst(que.pollLast());
        }
        return que.pollLast();
    }
    
    public int top() {
        return que.peekFirst();
    }
    
    public boolean empty() {
        return que.isEmpty();
    }
}
