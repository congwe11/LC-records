package code.leetcode.binary_tree;

/**
 * @author Congw
 * 2023/6/19 15:00
 */
public class LC404_sumOfLeftLeaves {

    public int sumOfLeftLeaves(TreeNode root) {
        /*
        * 左叶子的定义：父节点的左孩子不为空，左孩子的左右孩子为空，则该左孩子为左叶子节点。
        * 使用递归：
        * 1 参数+返回值：当前节点的左子树，左叶子的和
        * 2 结束条件：当前节点 == null
        * 3 递归逻辑：
        *   注意左叶子的判定条件
        * */
        if (root == null) return 0;

        int leftValue = sumOfLeftLeaves(root.left);
        if (root.left != null && root.left.left == null && root.left.right == null) {
            leftValue += root.left.val;
        }
        int rightValue = sumOfLeftLeaves(root.right);

        return leftValue + rightValue;
    }

    public int sumOfLeftLeaves1(TreeNode root) {
        if (root == null) return 0;
        int leftValue = 0;
        if (root.left != null && root.left.left == null && root.left.right == null) {
            leftValue = root.left.val;
        }
        return leftValue + sumOfLeftLeaves1(root.left) + sumOfLeftLeaves1(root.right);
    }
}
