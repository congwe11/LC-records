package code.leetcode.onedayone._23.June;

import code.leetcode.linked.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Congw
 * 2023/6/11 21:15
 */
public class LC1171_RemoveZeroSumSublists {

    public ListNode removeZeroSumSublists(ListNode head) {

        ListNode dummy = new ListNode(0, head);

        // HashMap存放 前缀和为 key, 节点值为 value
        // 首先，遍历一遍数组，构建map，如果前缀和相同则直接覆盖节点，
        // 其次，在遍历一遍数组，当前节点 node = seen.get(prefix).next, 直接越过了之间和为 0 的连续节点
        Map<Integer, ListNode> seen = new HashMap<>();
        int prefix = 0;
        for (ListNode node = dummy; node != null; node = node.next) {
            prefix += node.val;
            seen.put(prefix, node);
        }

        prefix = 0;
        for (ListNode node = dummy; node != null; node = node.next) {
            prefix += node.val;
            node.next = seen.get(prefix).next;
        }

        return dummy.next;
    }

    public ListNode removeZeroSumSublists2(ListNode head) {

        ListNode dummy = new ListNode(0, head);
        ListNode pre = dummy;
        ListNode cur = head;
        while (cur != null) {

            // 新建一个节点
            ListNode cyc = cur;
            int sum = 0;
            while (cyc != null) {
                sum += cyc.val;
                if (sum == 0) {
                    cur = cyc.next;
                    break;
                }
                cyc = cyc.next;
            }

            if (pre.next == cur) {
                // 没有更新节点
                cur = cur.next;
                pre = pre.next;
            } else { // 更新了节点
                pre.next = cur;
            }
        }

        return dummy.next;
    }
}
