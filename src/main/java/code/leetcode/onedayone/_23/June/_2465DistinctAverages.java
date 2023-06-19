package code.leetcode.onedayone._23.June;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class _2465DistinctAverages {

    public static int distinctAverages(int[] nums) {
        Arrays.sort(nums);
        int l = 0, r = nums.length - 1;
        Set<Double> set = new HashSet<>();
        Double avg;
        while (l < r) {
            // Double avg = (double) (nums[l] + ((nums[r] - nums[l]) >> 1));
            // int 转 double 小数抹除
            avg = ((double) nums[l] + (double) nums[r]) / 2;

            set.add(avg);
            l++;
            r--;
        }
        return set.size();
    }

    public static void main(String[] args) {

        int[] nums = new int[]{9,5,7,8,7,9,8,2,0,7};
        int i = distinctAverages(nums);
        System.out.println("i = " + i);
    }
}
