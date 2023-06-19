package code.leetcode.string;

public class _0459RepeatedSubstringPattern {
    public static boolean repeatedSubstringPattern(String s) {
        // return (s + s).indexOf(s, 1) != s.length();
        int n = s.length();

        int[] next = new int[s.length()];
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

        if (next[n - 1] != -1 && n % (n - (next[n-1] + 1)) == 0) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "ababab";
        System.out.println(repeatedSubstringPattern(s));
    }

}
