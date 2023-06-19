package code.leetcode.binary_tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Congw
 * 2023/6/13 9:42
 */
public class LC101_IsSymmetric {
    // 递归
    public boolean isSymmetric(TreeNode root) {
        return compare(root.left, root.right);
    }

    private boolean compare(TreeNode left, TreeNode right) {
        if (left == null && right != null) return false;
        if (left != null && right == null) return false;
        if (left == null && right == null) return true;
        if (left.val != right.val) return true;

        // 比较外侧
        boolean compareOutside = compare(left.left, right.right);
        // 比较内测
        boolean compareInside = compare(left.right, right.left);

        return compareOutside && compareInside;

    }

    public boolean isSymmetric1(TreeNode root) {
        // 迭代法
        Deque<TreeNode> que = new LinkedList<>();
        que.offerFirst(root.left);
        que.offerLast(root.right);

        while(!que.isEmpty()) {
            TreeNode left = que.pollFirst();
            TreeNode right = que.pollLast();

            if (left == null && right == null) continue;

            if (left == null || right == null || left.val != right.val) {
                return false;
            }

            que.offerFirst(left.left);
            que.offerFirst(left.right);
            que.offerLast(right.right);
            que.offerLast(right.left);
        }
        return true;
    }
}
