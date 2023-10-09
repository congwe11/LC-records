package code.D.bin_tree;

public class LC222_countNodes {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;

        return 1 + countNodes(root.left) + countNodes(root.right);
    }


    /**
     * 针对完全二叉树的解法
     *
     * 满二叉树的结点数为：2^depth - 1
     */
    public int countNodes2(TreeNode root) {
        if (root == null) return 0;
        TreeNode left = root.left, right = root.right;
        int leftDepth = 0, rightDepth = 0;

        while (left != null) {
            left = left.left;
            leftDepth++;
        } 
        while (right != null) {
            right = right.right;
            rightDepth++;
        }
        if (leftDepth == rightDepth) {
            return (2 << leftDepth) - 1; // 注意(2<<1) 相当于2^2，所以leftDepth初始为0
        }

        return countNodes2(root.left) + countNodes2(root.right) + 1;
    }
}
