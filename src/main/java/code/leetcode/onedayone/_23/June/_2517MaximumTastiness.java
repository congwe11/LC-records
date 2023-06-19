package code.leetcode.onedayone._23.June;

import java.util.Arrays;

/**
 *  最大甜蜜度
 *  二分法
 */
public class _2517MaximumTastiness {

    public int maximumTastiness(int[] price, int k) {
        Arrays.sort(price);

        int n = price.length;

        int left = 0; //最小甜蜜度为0
        int right = price[n-1] - price[0]; // 最大甜蜜度：最大价格 - 最小价格
        int mid;
        int ans = 0;

        // 每次校验的区间是 [left, right]
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (check(price, k, mid)) {
                // 校验成功，说明有k个价格能够满足甜蜜度大于mid，那么可以尝试搜索更大的甜蜜度
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    private boolean check(int[] price, int k, int tastiness) {
        // 统计满足差值大于tastiness的价格数，初始price[0]肯定要选择
        int count = 1;
        int prev = price[0];
        for (int i=1; i<price.length; i++) {
            // 当前价格和记录的前一个价格的差值大于tastiness，说明当前价格能够被选择，选择数量+1
            // 更新前一个价格为当前价格。因为价格是升序排序，与当前价格距离越近的一定差值越小。因此只要记录最后选中的价格，只要当前价格和最后选中的价格的差值大于tastiness
            // 其他更早选中的价格的差值肯定更大，组成的礼盒的甜蜜度一定是大于tastiness的
            if (price[i] - prev >= tastiness) {
                count++;
                prev = price[i];
            }
        }
        return count >= k; // 如果组成礼盒的糖果个数大于等于k，说明至少有k个价格能够满足甜蜜度大于等于tastiness
    }
}
