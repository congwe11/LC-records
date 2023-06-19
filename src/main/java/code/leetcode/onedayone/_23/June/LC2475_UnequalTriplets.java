package code.leetcode.onedayone._23.June;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Congw
 * 2023/6/13 9:28
 */
public class LC2475_UnequalTriplets {
    public int unequalTriplets(int[] nums) {
        int res = 0;
        for (int i=0; i < nums.length - 2; i++) {
            for (int j=i+1; j < nums.length - 1; j++) {
                if (nums[i] == nums[j]) continue;

                for (int k = j+1; k < nums.length; k++) {
                    if (nums[k] != nums[i] && nums[k] != nums[j]) {
                        res++;
                    }
                }

            }
        }
        return res;
    }

    // 哈希
    // v 为当前元素的数目，t为以遍历元素的数目， t * v * (n - t - v)
    public int unequalTriplets1(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();
        for (Integer n : nums) {
            map.merge(n, 1, Integer::sum);
        }

        int t = 0, res = 0, n = nums.length;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            res += t * entry.getValue() * (n - t - entry.getValue());
            t += entry.getValue();
        }
        return res;
    }
}
