package code.leetcode.binary_tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Congw
 * 2023/7/4 16:51
 */
public class LC98_isValidBST {
    TreeNode max;
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;

        boolean left = isValidBST(root.left);

        if (max != null && max.val >= root.val) return false;
        max = root;

        boolean right = isValidBST(root.right);

        return left && right;
    }

    public boolean isValidBST1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);

        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) >= list.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    private void inorder(TreeNode root, List<Integer> list) {
        if (root == null) return;

        inorder(root, list);
        list.add(root.val);
        inorder(root, list);
    }
}
