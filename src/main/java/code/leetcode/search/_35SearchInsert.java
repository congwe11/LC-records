package code.leetcode.search;

public class _35SearchInsert {

    public static int searchInsert(int[] nums, int target) {
        int l=0, r=nums.length-1;
        int mid = 0;
        int ans = nums.length;

        while (l <= r) {
            mid = l + ((r - l) >> 1);
            if (target <= nums[mid]) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,5,7};
        int target = 0;
//        int target = 8;
        //int target = 6;
        System.out.println(searchInsert(nums, target));
    }
}
