package code.leetcode.binary_tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Congw
 * 2023/6/19 15:43
 */
public class LC513_findBottomLeftValue {


    // 递归法
    int maxDepth = -1;
    int res = 0;
    public int findBottomLeftValue(TreeNode root) {
        /**
         * 层次遍历：只需要每次记录每层的第一个节点值即可
         */
        Deque<TreeNode> que = new LinkedList<>();
        if (root != null) que.offerLast(root);
        int res = 0;
        while (!que.isEmpty()) {
            int len = que.size();
            for (int i = 0; i < len; i++) {
                TreeNode node = que.pollFirst();
                // 记录第一个值
                if (i == 0) res = node.val;

                if (node.left != null) que.offerLast(node.left);
                if (node.right != null) que.offerLast(node.right);
            }
        }
        return res;
    }


    public int findBottomLeftValue1(TreeNode root) {

        res = root.val;
        findLeftValue(root, 0);
        return res;
    }

    public void findLeftValue(TreeNode root, int depth) {
        if (root == null) return;

        if (root.left == null && root.right == null) {
            if (depth > maxDepth) {
                res = root.val;
                maxDepth = depth;
            }
        }

        if (root.left != null)  findLeftValue(root.left, depth + 1);
        if (root.right != null)  findLeftValue(root.right, depth + 1);
    }
}
