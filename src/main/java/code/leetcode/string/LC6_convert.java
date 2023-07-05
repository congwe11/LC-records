package code.leetcode.string;

/**
 * @author Congw
 * 2023/7/2 17:06
 */
public class LC6_convert {
    public String convert(String s, int numRows) {
        StringBuilder[] res = new StringBuilder[numRows];
        for (int i = 0; i < res.length; i++) {
            res[i] = new StringBuilder();
        }

        int j = 0, flag = -1;
        for (int i = 0; i < s.length(); i++) {
            res[j].append(s.charAt(i));
            if (j == 0 || j == numRows - 1) flag = - flag;
            j += flag;
        }

        for (int i = 1; i < res.length; i++) {
            res[0].append(res[i]);
        }
        return res[0].toString();
    }
}
