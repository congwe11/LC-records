package code.leetcode.string;

public class _0028StrStr {
    public int strStr(String haystack, String needle) {

        int[] next = new int[needle.length()];

        getNext(next, needle);

        int j = -1;
        for (int i=0; i<haystack.length(); i++) {
            while (j>-1 && haystack.charAt(i) != needle.charAt(j+1)) {
                j = next[j];
            }
            if (needle.charAt(j+1) == haystack.charAt(i)) {
                j++;
            }
            if (j == needle.length() - 1) {
                return i - j;
            }
        }
        return -1;
    }


    private void getNext(int[] next, String s) {
        int j = -1;
        next[0] = j;

        for (int i=1; i<s.length(); i++) {
            while (j > -1 && s.charAt(i) != s.charAt(j+1)) {
                j = next[j];
            }
            if (s.charAt(i) == s.charAt(j+1)) {
                j++;
            }
            next[i] = j;
        }
    }
}
