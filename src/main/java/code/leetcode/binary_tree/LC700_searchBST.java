package code.leetcode.binary_tree;

/**
 * @author Congw
 * 2023/7/4 16:36
 */
public class LC700_searchBST {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) return root;

        if (val < root.val) return searchBST(root.left, val);
        else return searchBST(root.right, val);

    }
}
