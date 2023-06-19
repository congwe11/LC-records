package code.bishi.柠檬微趣;

import java.util.*;

/**
 * @author Congw
 * 2023/6/11 22:06
 */
public class Solution {

    /*
    对于特定的模式 pattern 以及特等的字符串 str，
    判断str中的非空单词是否能和 patter中的字符一一对应，注意这里的一一对应是双向的。
    */
    public boolean testMatch(String pattern, String str) {

        String[] words = str.split(" ");
        if (pattern.length() != words.length) {
            return false;
        }
        Map<Character, String> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            char key = pattern.charAt(i);
            if (map.containsKey(key)) {
                // 存在key
                if (!map.get(key).equals(words[i])) {
                    return false;
                }
            } else {
                // 不存在key
                if (map.containsValue(words[i])) {
                    return false;
                } else {
                    map.put(key, words[i]);
                }
            }
        }
        return true;
    }

    /*给定一个正整数N， 通过调整个位数的顺序得到一个新的正整数M，并且M>N，返回最小的M。如果不存在这样的数，则返回-1；*/
    public int testMoreNum(int N) {
        // 将数字N转化为字符数组
        char[] digits = String.valueOf(N).toCharArray();
        int i = digits.length - 2;

        // 从右往左遍历数字，找到第一个较小的数
        while (i >= 0 && digits[i] >= digits[i+1]) {
            i--;
        }

        if (i < 0) return -1;

        // 从右侧找到第一个大于 digits[i] 的数
        int j = digits.length - 1;
        while (digits[j] <= digits[i]) {
            j--;
        }

        // 交换 j 和 i
        char temp = digits[i];
        digits[i] = digits[j];
        digits[j] = temp;

        Arrays.sort(digits, i+1, digits.length);

        int M = Integer.parseInt(new String(digits));
        return M;
    }

    /*对于给定正整数数组A和给定正整数T，请在A中找出两个连续子数组，这两个子数组不能相交，
    并且两个子数组的和相等且为T。可能会有多种方案，请返回两个子数组长度和的最小值。如果无法找到这样的方案，返回-1。*/
    public int findMinSubarraySum(int[] A, int T) {

        if (A == null || A.length == 0) return -1;
        List<Integer> res = new ArrayList<>();
        int left = 0, sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            if (sum >= T) {
                while (sum >= T) {
                    if (sum > T) {
                        sum -= A[left];
                        left++;
                    } else {
                        res.add(i - left + 1);
                        left = i + 1;
                        sum = 0;
                    }
                }
            }
        }

        if (res.size() < 2) return -1;
        Collections.sort(res);
        return res.get(0) + res.get(1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        /*boolean res = solution.testMatch("effe", "good bad bad good");
        System.out.println("res = " + res);*/

        // System.out.println(solution.testMoreNum(1243));

        // System.out.println(solution.findMinSubarraySum(new int[]{2, 2, 1, 4, 3}, 3));
    }
}
