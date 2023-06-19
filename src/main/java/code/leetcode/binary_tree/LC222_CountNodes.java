package code.leetcode.binary_tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Congw
 * 2023/6/13 10:53
 */
public class LC222_CountNodes {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;

        return countNodes(root.left) + countNodes(root.right) + 1;
    }

    public int countNodes2(TreeNode root) {
        int res = 0;
        Deque<TreeNode> que = new LinkedList<>();

        if (root != null) que.offerLast(root);

        while (!que.isEmpty()) {
            int len = que.size();
            for (int i = 0; i < len; i++) {
                TreeNode node = que.pollFirst();
                res++;
                if (node.left != null) que.offerLast(node.left);
                if (node.right != null) que.offerLast(node.right);
            }
        }
        return res;
    }
}
