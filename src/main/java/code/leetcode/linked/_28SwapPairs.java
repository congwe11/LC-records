package code.leetcode.linked;

public class _28SwapPairs {

    // 递归
    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next ==null) return head;

        ListNode next = head.next;

        ListNode newNode = swapPairs(next.next);

        next.next = head;
        head.next = newNode;

        return next;
    }

    // 遍历
    public static ListNode swapPairs1(ListNode head) {
        ListNode preHead = new ListNode(0, head);
        ListNode pre = preHead;
        ListNode cur = head;
        ListNode nex = head;
        while (cur != null && cur.next != null) {
            nex = cur.next;
            ListNode temp = nex.next;
            pre.next = nex;
            nex.next = cur;
            cur.next = temp;

            // 更新
            pre = cur;
            cur = temp;
            nex = cur;
        }
        return preHead.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));

        swapPairs(head);

    }
}
