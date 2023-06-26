package code.leetcode.binary_tree;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Congw
 * 2023/6/22 8:32
 */
public class LC_constructMaximumBinaryTree {

    Map<Integer, Integer> map = new HashMap<>();
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        return traversal(nums, 0, nums.length);
    }

    private TreeNode traversal(int[] nums, int start, int end) {
        if (start >= end) {
            return null;
        }
        int max = 0;

        for (int i = start; i < end; i++) {
            max = Math.max(max, nums[i]);
        }
        int rootIndex = map.get(max);
        TreeNode root = new TreeNode(max);

        root.left = traversal(nums, start, rootIndex);
        root.right = traversal(nums, rootIndex+1, end);
        return root;
    }


    public TreeNode traversal1(int[] nums, int leftIndex, int rightIndex) {
        // if (rightIndex - leftIndex < 1) {
        //     return null;
        // }
        if (leftIndex >= rightIndex) return null;   // 没有元素了

        if (rightIndex - leftIndex == 1) {  // 数组大小为1，说明为叶子节点
            return new TreeNode(nums[leftIndex]);
        }
        int maxIndex = leftIndex; //最大值所在位置
        int maxVal = nums[maxIndex];
        for (int i = leftIndex + 1; i < rightIndex; i++) {
            if (nums[i] > maxVal) {
                maxVal = nums[i];
                maxIndex = i;
            }
        }
        TreeNode root = new TreeNode(maxVal);
        // 根据maxIndex划分左右子树
        root.left = traversal(nums, leftIndex, maxIndex);
        root.right = traversal(nums, maxIndex + 1, rightIndex);
        return root;
    }
}
