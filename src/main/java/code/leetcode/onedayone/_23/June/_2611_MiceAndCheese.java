package code.leetcode.onedayone._23.June;

import java.util.Arrays;

/**
 * @author Congw
 * 2023/6/7 9:53
 */
public class _2611_MiceAndCheese {

    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        int n = reward1.length;
        int ans = 0;
        int[] diffs = new int[n];
        for (int i = 0; i < n; i++) {
            ans += reward2[i];
            diffs[i] = reward1[i] - reward2[i];
        }
        Arrays.sort(diffs);
        for (int i = 1; i <= k; i++) {
            ans += diffs[n - i];
        }

        return ans;
    }
}
