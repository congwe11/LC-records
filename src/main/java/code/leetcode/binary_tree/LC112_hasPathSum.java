package code.leetcode.binary_tree;

/**
 * @author Congw
 * 2023/6/20 23:16
 */
public class LC112_hasPathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;

        targetSum -= root.val;
        if (targetSum == 0 && root.left == null && root.right == null) {
            return true;
        }

        boolean leftSum = hasPathSum(root.left, targetSum);

        boolean rightSum = hasPathSum(root.right, targetSum);

        return leftSum || rightSum;
    }
}
