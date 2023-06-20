package code.leetcode.binary_tree;

/**
 * @author Congw
 * 2023/6/19 11:31
 */
public class LC110_isBalanced {
    public boolean isBalanced(TreeNode root) {
        // 1 求左右子树的深度，差不超过 1
        /*
        * 1 递归三部曲
        *   1.1 确定参数和返回值： 树节点，当前树节点为根节点的树的深度
        *   1.2 跳出条件： 当前节点 为空
        *   1.3 递归逻辑：
        *       0 : 当前节点为空，返回 0；
        *       -1：表示左子树不满足平衡二叉树条件，直接返回-1；
        *       判断 左右子树是否为 -1；
        *       判断 左右子树高度差是否大于 1；
        *       返回 以传入节点为根节点的树的高度。
        * */

        return getHeight(root) != -1;
    }

    private int getHeight(TreeNode root) {
        if (root == null) return 0;

        int leftHeight = getHeight(root.left);
        if (leftHeight == -1) return -1;

        int rightHeight = getHeight(root.right);
        if (rightHeight == -1) return -1;

        if (Math.abs(rightHeight - leftHeight) > 1) return -1;

        return Math.max(leftHeight, rightHeight) + 1;
    }
}
