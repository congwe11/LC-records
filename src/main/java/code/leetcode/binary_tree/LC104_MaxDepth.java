package code.leetcode.binary_tree;

/**
 * @author Congw
 * 2023/6/13 10:09
 */
public class LC104_MaxDepth {

    public int maxDepth(TreeNode root) {
        int res = 0;
        // Deque<TreeNode> que = new LinkedList<>();
        // int deep = 0;
        // if (root != null) que.offer(root);

        // while (!que.isEmpty()) {
        //     int len = que.size();
        //     for (int i=0; i<len; i++) {
        //         TreeNode node = que.pollFirst();
        //         if(node.left != null) que.offer(node.left);
        //         if(node.right != null) que.offer(node.right);
        //     }

        //     deep++;
        // }
        // return deep;

        if (root == null) return 0;

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return 1 + Math.max(leftDepth, rightDepth);
    }
}
