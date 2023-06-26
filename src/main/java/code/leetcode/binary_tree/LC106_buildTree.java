package code.leetcode.binary_tree;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Congw
 * 2023/6/21 22:06
 */
public class LC106_buildTree {

    Map<Integer, Integer> map;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return findNode(inorder, 0, inorder.length, postorder, 0, postorder.length);
    }

    private TreeNode findNode(int[] inorder, int inStart, int inEnd,
                              int[] postorder, int postStart, int postEnd) {
        // 参数范围都是左闭右开
        if (inStart >= inEnd || postStart >= postEnd) {
            return null;
        }

        int rootIndex = map.get(postorder[postEnd - 1]); // 获取节点在后序数组中的位置
        TreeNode root = new TreeNode(inorder[rootIndex]);
        int lenOfLeft = rootIndex - inStart; // 保持中序数组中， 左边元素个数，用来确定后序数组的个数
        root.left = findNode(inorder, inStart, rootIndex,
                postorder, postStart, postStart + lenOfLeft);
        root.right = findNode(inorder, rootIndex+1, inEnd,
                postorder, postStart + lenOfLeft, postEnd - 1);
        return root;
    }
}
