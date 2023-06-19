package code.leetcode.onedayone._23.June;

/**
 * @author Congw
 * 2023/6/5 23:45
 */
public class _2559_VowelStrings {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;

        // 构建前缀和数组：prefixSums[i+1] 表示从下标0开始到下标i，字符串是元音开头结尾的 总个数
        // 后面 对应区间内[i, j]的个数，可用prefixSums[j+1] - prefixSums[i] 得到

        int[] prefixSums = new int[n+1];
        for (int i=0; i<n; i++) {
            String s = words[i];
            if (isVowel(s.charAt(0)) && isVowel(s.charAt(s.length()-1))) {
                prefixSums[i+1] = prefixSums[i] + 1;
            } else {
                prefixSums[i+1] = prefixSums[i];
            }
        }

        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int start = queries[i][0], end = queries[i][1];
            res[i] = prefixSums[end+1] - prefixSums[start];
        }
        return res;
    }

    private boolean isVowel(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
            return true;
        }
        return false;
    }


}
