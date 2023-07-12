package code.leetcode.binary_tree;

/**
 * @author Congw
 * 2023/7/6 10:00
 */
public class LC236_lowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 后续遍历
        // 先找到p 和 q

        if (root == p || root == q || root == null) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);

        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) return root;
        if (left == null) return right;
        return left;
    }
}
