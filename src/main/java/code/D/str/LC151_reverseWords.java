package code.D.str;

public class LC151_reverseWords {
    public String reverseWords(String s) {
        // 1 删除首尾和单词间多余空格
        // 2 反转整个字符串
        // 3 反转单个单词
        
        StringBuilder sb = removeSpaces(s);
        reverseString(sb, 0, sb.length() - 1);
        reverseEachWord(sb);

        return sb.toString();
    }

    private void reverseEachWord(StringBuilder sb) {
        int l = 0, r = 0;
        int n = sb.length();

        while (r < n) {
            while (sb.charAt(r) != ' ') r++;
            reverseString(sb, l, r - 1);
            l = r + 1;
            r = l + 1;
        }
    }

    private StringBuilder removeSpaces(String s) {

        StringBuilder sb = new StringBuilder();
        // 1 删除首尾
        int l = 0, r = s.length() - 1;
        while (s.charAt(l) == ' ') l++;
        while (s.charAt(r) == ' ') r--;
        // 2 单词间
        while (l < r) {
            if (s.charAt(l) != ' ' || s.charAt(l-1) != ' ') {
                sb.append(s.charAt(l));
            }
            l++;
        }

        
        return sb;
    }

    public void reverseString(StringBuilder s, int l, int r) {
        // int l = 0, r = s.length()-1;
        while (l < r) {
            char temp = s.charAt(l);
            s.setCharAt(l, s.charAt(r));
            s.setCharAt(r, temp);
            l++;
            r--;
        }
    }
}
