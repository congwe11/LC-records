package code.leetcode.binary_tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Congw
 * 2023/6/9 16:38
 */
public class LC102_levelOrder {

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> resList = new ArrayList<>();

        // 使用队列辅助
        Deque<TreeNode> que = new LinkedList<>();

        if (root != null) que.addLast(root);

        while (!que.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int len = que.size();
            while (len > 0) {
                TreeNode node = que.pollFirst();
                list.add(node.val);
                if (node.left != null) que.addLast(node.left);
                if (node.right != null) que.addLast(node.right);
                len--;
            }
            resList.add(list);
        }
        return resList;
    }
}
