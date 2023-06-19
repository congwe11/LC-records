package code.leetcode.binary_tree;

/**
 * @author Congw
 * 2023/6/13 10:23
 */
public class LC111_MinDepth {

    public int minDepth(TreeNode root) {

        // if (root == null) return 0;
        // Deque<TreeNode> que = new LinkedList<>();
        // que.offer(root);
        // int depth = 0;

        // while (!que.isEmpty()) {
        //     int len = que.size();
        //     depth++;
        //     for (int i=0; i<len; i++) {
        //         TreeNode cur = que.pollFirst();
        //         //如果当前节点的左右孩子都为空，直接返回最小深度
        //         if (cur.left == null && cur.right == null) {
        //             return depth;
        //         }
        //         if (cur.left != null) que.offer(cur.left);
        //         if (cur.right != null) que.offer(cur.right);
        //     }
        // return depth;

        if (root == null) return 0;

        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);

        if (root.left == null && root.right != null) {
            return 1 + rightDepth;
        }
        if (root.left != null && root.right == null) {
            return 1 + leftDepth;
        }

        return 1 + Math.min(leftDepth, rightDepth);
    }
}
