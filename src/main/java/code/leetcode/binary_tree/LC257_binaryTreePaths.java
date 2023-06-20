package code.leetcode.binary_tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Congw
 * 2023/6/19 14:40
 */
public class LC257_binaryTreePaths {

    public List<String> binaryTreePaths(TreeNode root) {
        /*
        * 递归 + 回溯，前序遍历
        * 参数和返回值：节点，路径数组，结果数组
        * 结束条件：找到叶子节点，回溯上一个节点
        * 逻辑：出入节点的左节点，继续递归，跳出递归 路径数组中删除最后一个节点（回溯）
        * */

        List<String> res = new ArrayList<>();

        if (root == null)  return res;

        List<Integer> paths = new ArrayList<>();
        traversal(root, paths, res);
        return res;
    }

    private void traversal(TreeNode root, List<Integer> paths, List<String> res) {
        paths.add(root.val);

        if (root.left == null && root.right == null) {
            // 输出
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < paths.size() - 1; i++) {
                sb.append(paths.get(i)).append("->");
            }
            sb.append(paths.get(paths.size() - 1));
            res.add(sb.toString());
        }

        if (root.left != null) {
            traversal(root.left, paths, res);
            paths.remove(paths.size() - 1);
        }
        if (root.right != null) {
            traversal(root.right, paths, res);
            paths.remove(paths.size() - 1);
        }
    }
}
