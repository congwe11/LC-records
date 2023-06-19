package code.leetcode.linked;

public class MyLinkedList {
    int size;

    ListNode head;

    public MyLinkedList() {
        this.size = 0;
        head = new ListNode();
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        ListNode cur = head;
        for (int i=0; i<=index; i++) {
            cur = cur.next;
        }
        return cur.val;
    }

    public void addAtHead(int val) {
        ListNode node = new ListNode(val, head.next);
        head.next = node;
        size++;
    }

    public void addAtTail(int val) {
        ListNode node = new ListNode(val);
        ListNode cur = head;
        for (int i=0; i<size; i++) {
            cur = cur.next;
        }
        cur.next = node;
        size++;
    }

    public void addAtIndex(int index, int val) {

        if (index > size) {
            return;
        }
        ListNode node = new ListNode(val);
        ListNode cur = head;
        for (int i=0; i<index; i++) {
            cur = cur.next;
        }
        node.next = cur.next;
        cur.next = node;
        size++;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        ListNode pre = head;
        for (int i=0; i<index; i++) {
            pre = pre.next;
        }
        pre.next = pre.next.next;
        size--;
    }
}

class main {
    public static void main(String[] args) {
        MyLinkedList obj = new MyLinkedList();
        int param_1 = obj.get(1);
        obj.addAtHead(1);
        obj.addAtTail(3);
        obj.addAtIndex(1,2);
        obj.deleteAtIndex(1);
        int i = obj.get(1);
    }
}
