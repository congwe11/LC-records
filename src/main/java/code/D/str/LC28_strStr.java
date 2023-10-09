package code.D.str;

public class LC28_strStr {
    public int strStr(String haystack, String needle) {
        
        int[] next = new int[needle.length()];

        getNext(next, needle);

        int j = -1;
        for (int i = 0; i < haystack.length(); i++) {
            while (j > -1 && haystack.charAt(i) != needle.charAt(j+1)) {
                j = next[j];
            }
            if (haystack.charAt(i) == needle.charAt(j+1)) {
                j++;
            }
            if (j == needle.length() - 1) {
                return i - j;
            }
        }

        return -1; 
    }

    private void getNext(int[] next, String s) {
        int j = -1; // 初始化 next[0] = -1
        next[0] = j;
        // 定义两个指针i，j
        // j指向前缀的末尾，i指向后缀的末尾
        for (int i = 1; i < next.length; i++) {
            while (j > -1 && s.charAt(i) != s.charAt(j+1)) { // 后缀不相等的情况
                j = next[j]; // 回退
            }
            if (s.charAt(i) == s.charAt(j+1)) {
                j++; // 相等的情况
            }
            next[i] = j; 
        }
    }
}
