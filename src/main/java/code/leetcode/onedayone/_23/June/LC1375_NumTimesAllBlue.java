package code.leetcode.onedayone._23.June;

/**
 * @author Congw
 * 2023/6/14 17:26
 */
public class LC1375_NumTimesAllBlue {

    public int numTimesAllBlue(int[] flips) {
        // [1,i] 内的所有位都是 1，这等价于「前 i 次翻转中下标的最大值等于 i」。
        // [1,i] 中共i个数，如果前 i 次翻转中最大值的下标等于i（因为每次只能翻转一个数），表示反转了i个数
        // 最大翻转的下标为i， 即，前i个数都被反转了。
        int ans = 0, right = 0;
        for (int i = 0; i < flips.length; i++) {
            right = Math.max(right, flips[i]);
            if (right == i+1) {
                ans++;
            }
        }
        return ans;
    }

    public int numTimesAllBlue1(int[] flips) {
        int n = flips.length;
        int[] binary = new int[n];
        int res = 0;
        for (int i=0; i < flips.length; i++) {
            int idx = flips[i] - 1;
            binary[idx] = 1;
            if (isPrefix(binary)) {
                res++;
            }
        }
        return res;
    }

    private boolean isPrefix(int[] binary) {
        int flag = 0;
        if (binary[0] == 0) {
            return false;
        }
        for (int i=0; i<binary.length - 1; i++) {
            if (binary[i] != binary[i+1]) {
                flag++;
            }
            if (flag > 1) {
                return false;
            }
        }
        return true;
    }
}
