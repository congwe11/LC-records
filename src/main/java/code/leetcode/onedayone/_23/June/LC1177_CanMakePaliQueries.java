package code.leetcode.onedayone._23.June;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Congw
 * 2023/6/15 21:20
 */
public class LC1177_CanMakePaliQueries {

    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {

        int n = s.length();
        int[] count = new int[n+1];
        for (int i = 0; i < n; i++) {
            count[i+1] = count[i] ^ (1 << (s.charAt(i) - 'a'));
        }

        List<Boolean> res = new ArrayList<>();

        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0], r = queries[i][1], k = queries[i][2];
            int bits = 0, x = count[r + 1] ^ count[l];
            while (x > 0) {
                x &= x - 1;
                bits++;
            }
            res.add(bits <= k * 2 + 1);
        }
        return res;
    }

    public List<Boolean> canMakePaliQueries1(String s, int[][] queries) {

        int n = queries.length;
        List<Boolean> res = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int left = queries[i][0], right = queries[i][1], k = queries[i][2];
            if (isTrue(s, left, right, k)) {
                res.add(true);
            } else {
                res.add(false);
            }
        }

        return res;
    }

    private boolean isTrue(String s, int left, int right, int k) {
        while (left <= right) {
            char a = s.charAt(left);
            char b = s.charAt(right);

            if (k == 0 && a != b) {
                return false;
            } else if (a != b) {
                k--;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        LC1177_CanMakePaliQueries canMakePaliQueries = new LC1177_CanMakePaliQueries();

        String s = "abcb";
        int[][] queries = {{0, 3, 1}, {1, 1, 1}};
        List<Boolean> l = canMakePaliQueries.canMakePaliQueries(s, queries);
        for (Boolean aBoolean : l) {
            System.out.println(aBoolean);
        }

    }
}
