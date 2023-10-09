package code.D.bin_tree;

public class LC226_invertTree {
    public TreeNode invertTree(TreeNode root) {

        return invert(root);

        // return root;
    }

    private TreeNode invert(TreeNode root) {
        if (root == null) return null;

        root.left = invert(root.right);
        root.right = invert(root.left);
        return root;
    }
}
