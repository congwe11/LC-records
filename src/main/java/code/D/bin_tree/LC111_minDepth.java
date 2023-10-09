package code.D.bin_tree;

import java.util.*;

public class LC111_minDepth {
    // 递归法
    public int minDepth(TreeNode root) {
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

    // 迭代法，层序遍历
    public int minDepth2(TreeNode root) {
        if (root == null) return 0;

        Deque<TreeNode> que = new LinkedList<>();

        int depth = 1;

        que.offer(root);
        while (!que.isEmpty()) {
            int len = que.size();

            while (len-- > 0) {
                TreeNode node = que.poll();
                if (node.left == null && node.right == null) {
                    return depth;
                } else {
                    if (node.left != null) que.offer(node.left);
                    if (node.right != null) que.offer(node.right);
                }
            }
            depth++;
        }
        return depth;
    }
}
