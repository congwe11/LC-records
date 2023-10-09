package code.D.hash;

import java.util.*;

public class LC18_fourSum {

    public static void main(String[] args) {
        int[] nums = new int[]{1,0,-1,0,-2,2};
        List<List<Integer>> res = fourSum(nums, 0);
        System.out.println(res);
    }
    public static List<List<Integer>> fourSum(int[] nums, int target) { 
        
        List<List<Integer>> res = new ArrayList<>();

        int n = nums.length;
        if (n < 4) return res;

        Arrays.sort(nums);

        for (int i = 0; i < n-3; i++) {
            if (nums[i] > 0 && nums[i] > target) break;

            if (i > 0 && nums[i-1] == nums[i]) continue;

            for (int j = i+1; j < n-2; j++) {
                if (j > i+1 && nums[j-1] == nums[j]) continue;

                int l = j + 1, r = n-1;

                long lsum = (long) nums[i] + nums[j] + nums[l] + nums[l+1];
                long rsum = (long) nums[i] + nums[j] + nums[r] + nums[r-1];
                if (lsum > target) break;
                if (rsum < target) continue;

                while (l < r) {
                    long sum = (long) nums[i] + nums[j] + nums[l] + nums[r];

                    if (sum < target) l++;
                    else if (sum > target) r--;
                    else {
                        res.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        while (l < r && nums[l] == nums[l+1]) l++;
                        while (l < r && nums[r] == nums[r-1]) r--;

                        l++;
                        r--;
                    }
                }
            }
        }
        return res;
    }
}
