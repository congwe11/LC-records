package code.leetcode.binary_tree;

import java.util.*;

/**
 * @author Congw
 * 2023/6/9 15:56
 */
public class LC144_PreorderTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preTraversal(root, res);
        return res;
    }
    public void preTraversal(TreeNode root, List<Integer> res) {
        if (root == null) return;
        res.add(root.val);
        preTraversal(root.left, res);
        preTraversal(root.right, res);
    }

    // 非递归解法，借助栈
    public List<Integer> preorderTraversalNoRecursion(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> st = new LinkedList<>();
        if (root != null) st.push(root);

        while (!st.isEmpty()) {
            TreeNode node = st.peek();
            if (node != null) {
                st.pop();
                // 入栈时左右节点调换下顺序，出栈就是先左后右了
                if (node.right != null) st.push(node.right);
                if (node.left != null) st.push(node.left);
                st.push(node);
                st.push(null);
            } else {
                st.pop();
                node = st.pop();
                res.add(node.val);
            }
        }
        return res;
    }
}
