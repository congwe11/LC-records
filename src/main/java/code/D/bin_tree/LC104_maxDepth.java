package code.D.bin_tree;

public class LC104_maxDepth {
    // 二叉树最大深度
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    // N叉树的最大深度
    public int LC559_maxDepth(Node root) {

        if (root == null) return 0;
        int deep = 0;
        for (Node n: root.children) {
            deep = Math.max(deep, LC559_maxDepth(n) + 1);
        }
        return deep;

    }
}
