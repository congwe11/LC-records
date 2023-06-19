package code.leetcode.other;

import java.util.HashMap;

/**
 * @author Congw
 * 2023/6/8 16:05
 */
public class CycleArray {

    int front = 0;
    int rear = 0;  // rear 指向的是队尾的下一个节点
    int size = 5;
    Object[] data = new Object[size];
    private boolean isEmpty() {
        return front == rear;
    }
    private boolean isOutIndex() {
        if (rear == size) {
            return true;
        }
        return false;
    }
    private void add(Object obj) {
        if (isOutIndex()) {
            rear = rear % size;
            front++;
        }
        data[rear++] = obj;
    }
    private Object get() {
        if (isEmpty()) {
            return null;
        }

        int temp = front;
        front = (front + 1) % size;
        return data[temp];
    }

    public static void main(String[] args) {
        CycleArray queue = new CycleArray();
        for (int i = 0; i < 11; i++) {
            queue.add(i);
        }
        for (int i = 0; i < 12; i++) {
            System.out.println("queue.get() = " + queue.get());
        }

        System.out.println("结束");
    }
}
