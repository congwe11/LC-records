package code.leetcode.binary_tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Congw
 * 2023/7/5 11:42
 */
public class LC501_findMode {
    List<Integer> resList;
    int count;
    int maxCount;
    TreeNode pre;

    public int[] findMode(TreeNode root) {
        resList = new ArrayList<>();
        maxCount = 0;
        count = 0;
        pre = null;
        traversal(root);
        int[] res = new int[resList.size()];
        for (int i = 0; i < resList.size(); i++) {
            res[i] = resList.get(i);
        }
        return res;
    }

    private void traversal(TreeNode root) {
        if (root == null) return;

        traversal(root.left);

        int rootValue = root.val;
        if (pre == null || rootValue != pre.val) {
            count = 1;
        } else {
            count++;
        }
        if (count > maxCount) {
            resList.clear();
            resList.add(rootValue);
            maxCount = count;
        } else if (count == maxCount) {
            resList.add(rootValue);
        }

        pre = root;

        traversal(root.right);
    }
}
