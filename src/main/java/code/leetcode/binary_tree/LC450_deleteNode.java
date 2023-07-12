package code.leetcode.binary_tree;

/**
 * @author Congw
 * 2023/7/12 22:50
 */
public class LC450_deleteNode {
    public TreeNode deleteNode(TreeNode root, int key) {
        //1 root == null, 未找到key节点
        if (root == null) return null;
        // 找到节点
        if (root.val == key) {
            //2 如果key节点左子树为空，直接返回右子树
            if (root.left == null) return root.right;
            //3 如果key节点右子树为空，直接返回左子树
            if (root.right == null) return root.left;
            //4 如果 左右子树不为空，左子树头节点 放到右子树最左面节点的左孩子上，返回删除节点的右孩子为根节点
            TreeNode temp = root.right;
            while (temp.left != null) {
                temp = temp.left;
            }

            temp.left = root.left;
            root = root.right;
            return root;
        }

        if (root.val > key) root.left = deleteNode(root.left, key);
        if (root.val < key) root.right = deleteNode(root.right, key);

        return root;
    }
}
