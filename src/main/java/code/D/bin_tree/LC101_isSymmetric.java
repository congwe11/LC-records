package code.D.bin_tree;

public class LC101_isSymmetric {
    // 对称二叉树
    public boolean isSymmetric(TreeNode root) {
        // 递归法
        return compare(root.left, root.right);
    }

    private boolean compare(TreeNode left, TreeNode right) {
        if (left != null && right == null) return false;
        else if (left == null && right != null) return false;
        else if (left == null && right == null) return true;
        else if (left.val != right.val) return false;

        boolean outSide = compare(left.left, right.right);
        boolean inSide = compare(left.right, right.left);

        return outSide && inSide;
    }
}
