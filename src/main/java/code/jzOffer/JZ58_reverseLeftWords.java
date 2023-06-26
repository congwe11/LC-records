package code.jzOffer;

/**
 * @author Congw
 * 2023/6/24 0:04
 */
public class JZ58_reverseLeftWords {
    public String reverseLeftWords(String s, int n) {
        // abcdef -> cdefab
        // fedcba - cdefab

        char[] ch = s.toCharArray();
        // 1 先反转整个字符串
        // 2 在分别反转 前后两个字符串
        int l = 0, r = ch.length - 1;
        swap(ch, l, r);

        l = ch.length - n;
        r = ch.length - 1;
        swap(ch, l, r);

        l = 0;
        r = r - n;
        swap(ch, l, r);
        return new String(ch);
    }

    private void swap(char[] ch, int l, int r) {
        while (l < r) {
            ch[l] ^= ch[r];
            ch[r] ^= ch[l];
            ch[l] ^= ch[r];
            l++;
            r--;
        }
    }

    public static void main(String[] args) {
        JZ58_reverseLeftWords s = new JZ58_reverseLeftWords();

        s.reverseLeftWords("abcdefg", 2);

    }
}
