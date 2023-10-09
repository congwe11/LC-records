package code.D.bin_tree;

import java.util.*;

public class LC102_levelOrder {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(7, null, null);
        TreeNode node15 = new TreeNode(15, null, null);
        TreeNode node20 = new TreeNode(20, node15, node1);
        TreeNode node9 = new TreeNode(9, null, null);
        TreeNode node3 = new TreeNode(3, node9, node20);

        LC102_levelOrder s = new LC102_levelOrder();

        List<List<Integer>> levelOrder = s.levelOrder(node3); 
        Collections.reverse(levelOrder);
        System.out.println(levelOrder); 
        
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        Deque<TreeNode> que = new LinkedList<>();

        if (root != null) que.offerLast(root);
        

        while (!que.isEmpty()) {
            List<Integer> list = new ArrayList<>();

            que.offerLast(null);
            TreeNode node = que.poll();
            
            while (node != null) {
                list.add(node.val);

                if (node.left != null) que.offerLast(node.left);
                if (node.right != null) que.offerLast(node.right);

                node = que.poll();
            }
            res.add(list);
        }
        return res;
    }
}
