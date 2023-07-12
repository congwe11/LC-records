package code.leetcode.binary_tree;

/**
 * @author Congw
 * 2023/7/6 16:09
 */
public class LC701_insertIntoBST {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        if (root.val > val) root.left = insertIntoBST(root.left, val);
        if (root.val < val) root.right = insertIntoBST(root.right, val);

        return root;
    }

    public TreeNode insertIntoBST_traversal(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        TreeNode parent = root;
        TreeNode cur = root;
        while (cur != null) {
            parent = cur;
            if (cur.val > val) cur = cur.left;
            else if (cur.val < val) cur = cur.right;
        }

        if (parent.val > val) parent.left = new TreeNode(val);
        else parent.right = new TreeNode(val);

        return root;
    }
}
