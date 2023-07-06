package code.leetcode.binary_tree;

/**
 * @author Congw
 * 2023/7/5 11:24
 */
public class LC530_getMinimumDifference {

    TreeNode pre;
    int res = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {

        if (root == null) return 0;
        traversal(root);
        return res;
    }

    private void traversal(TreeNode root) {
        if (root == null) return;

        traversal(root.left);
        if (pre != null) {
            res = Math.min(res, root.val - pre.val);
        }
        pre = root;
        traversal(root.right);
    }
}
