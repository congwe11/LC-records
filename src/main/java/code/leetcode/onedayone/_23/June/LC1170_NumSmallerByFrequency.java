package code.leetcode.onedayone._23.June;

/**
 * @author Congw
 * 2023/6/10 17:18
 */
public class LC1170_NumSmallerByFrequency {

    public static int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] count = new int[12];
        for (String s : words) {
            count[f(s)]++;
        }
        for (int i = 9; i >= 1; i--) {
            count[i] += count[i + 1];
        }
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String s = queries[i];
            res[i] = count[f(s) + 1];
        }
        return res;

        /*
        int[] words_fre = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            words_fre[i] = f(words[i]);
        }

        int[] res = new int[queries.length];
        for(int i = 0; i < queries.length; i++) {
            int fre = f(queries[i]);
            int s_fre = 0;
            for(int j=0; j < words_fre.length; j++) {
                if (fre < words_fre[j]) {
                    s_fre++;
                }
            }
            res[i] = s_fre;
        }
        return res;*/
    }

    private static int f(String word) {
        int cnt = 0;
        char min_ch = 'z';
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (ch < min_ch) { // 遇到 更小的 字母 直接更新min_ch
                min_ch = ch;
                cnt = 0;
            }
            if (min_ch == ch){
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        String[] queries = new String[]{"bbb","cc"};
        String[] words = new String[]{"a","aa","aaa","aaaa"};

        int[] res = numSmallerByFrequency(queries, words);

        for (int re : res) {
            System.out.println("re = " + re);
        }
    }
}
