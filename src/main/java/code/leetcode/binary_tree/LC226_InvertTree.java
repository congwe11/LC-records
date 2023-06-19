package code.leetcode.binary_tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Congw
 * 2023/6/12 21:14
 */
public class LC226_InvertTree {

    // 深度优先遍历-递归
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        swap(root);
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }

    // 深度优先遍历-迭代
    public TreeNode invertTree1(TreeNode root) {
        Deque<TreeNode> st = new LinkedList<>();
        if (root != null) st.offerLast(root);
        while (!st.isEmpty()) {
            TreeNode node = st.pollFirst();
            if (node != null) {
                st.offerLast(null);
                st.offerLast(node);
                if (node.right != null) st.offerLast(node.right);
                if (node.left != null) st.offerLast(node.left);

            } else {
                node = st.pollFirst();
                swap(node);
            }
        }

        return root;
    }

    // 广度优先遍历-层次遍历
    public TreeNode invertTree2(TreeNode root) {
        Deque<TreeNode> que = new LinkedList<>();
        if (root != null) que.offerLast(root);
        while (!que.isEmpty()) {
            int len = que.size();
            for (int i=0; i<len; i++) {
                TreeNode node = que.pollFirst();
                swap(node);
                if (node.left != null) que.offerLast(node.left);
                if (node.right != null) que.offerLast(node.right);
            }
        }
        return root;
    }


    private void swap(TreeNode node) {
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
    }
}
