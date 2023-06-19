package code.leetcode.onedayone._23.June;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Congw
 * 2023/6/19 10:20
 */
public class LC1262_maxSumDivThree {
    // 贪心 + 逆向思维：按 % 3余数- 0,1,2 分成三组 a, b, c
    // 1 设 tot 为 nums 元素的和，
    // 2 如果 tot 整除 3， tot即为最大，返回
    // 3 如果 tot 不能整除 3， 分情况：
    //    3.1 如果 tot % 3 == 1：可以从 b 中选取最小的 1 个数，或者从 c 中选取最小的 2 个数
    //    3.2 如果 tot % 3 == 2: 可以从 b 中选取最小的 2 个数，或者从 c 中选取最小的 1 个数
    // 最后，得到结果

    public int maxSumDivThree(int[] nums) {

        // 使用 v[0], v[1], v[2] 分别表示 a, b, c
        List<Integer>[] v = new List[3];
        for (int i = 0; i < 3; i++) {
            v[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < nums.length; i++) {
            v[nums[i] % 3].add(nums[i]);
        }

        Collections.sort(v[1], (a, b) -> b - a);
        Collections.sort(v[2], (a, b) -> b - a);

        int tot = Arrays.stream(nums).sum();
        int remove = Integer.MAX_VALUE;

        if (tot % 3 == 0) {
            remove = 0;
        } else if (tot % 3 == 1) {
            if (v[1].size() >= 1) {
                remove = Math.min(remove, v[1].get(v[1].size() - 1));
            }
            if (v[2].size() >= 2) {
                remove = Math.min(remove, v[2].get(v[2].size() - 1) + v[2].get(v[2].size() - 2));
            }
        } else {
            if (v[1].size() >= 2) {
                remove = Math.min(remove, v[1].get(v[1].size() - 1) + v[1].get(v[1].size() - 2));
            }
            if (v[2].size() >= 1) {
                remove = Math.min(remove, v[2].get(v[2].size() - 1));
            }
        }
        return tot - remove;
    }

    public int maxSumDivThree1(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 3 == 0) {
            return sum;
        }

        ArrayList<Integer> a1 = new ArrayList<>();
        ArrayList<Integer> a2 = new ArrayList<>();
        for (int x : nums) {
            if (x % 3 == 1) a1.add(x);
            else if (x % 3 == 2) a2.add(x);
        }

        Collections.sort(a1);
        Collections.sort(a2);

        if (sum % 3 == 2) {
            ArrayList<Integer> temp = a1;
            a1 = a2;
            a2 = a1;
        }

        int ans = a1.isEmpty() ? 0 : sum - a1.get(0);
        if (a2.size() > 1) {
            ans = Math.max(ans, sum - a2.get(0) - a2.get(1));
        }
        return ans;
    }
}
