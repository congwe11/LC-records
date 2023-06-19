package code.leetcode.binary_tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Congw
 * 2023/6/9 15:56
 */
public class LC145_PostorderTraversal {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        traversal(root, res);
        return res;
    }
    public void traversal(TreeNode root, List<Integer> res) {
        if (root == null) return;
        traversal(root.left, res);
        traversal(root.right, res);
        res.add(root.val);
    }

    // 非递归解法，借助栈
    public List<Integer> preorderTraversalNoRecursion(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> st = new LinkedList<>();
        if (root != null) st.push(root);

        while (!st.isEmpty()) {
            TreeNode node = st.peek();
            if (node != null) {
                // st.pop();
                // 入栈时左右节点调换下顺序，出栈就是先左后右了
                // st.push(node);
                st.push(null);
                if (node.right != null) st.push(node.right);
                if (node.left != null) st.push(node.left);

            } else {
                st.pop();
                node = st.pop();
                res.add(node.val);
            }
        }
        return res;
    }
}
