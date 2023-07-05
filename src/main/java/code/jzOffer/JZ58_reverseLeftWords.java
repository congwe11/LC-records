package code.jzOffer;

/**
 * @author Congw
 * 2023/6/24 0:04
 */
public class JZ58_reverseLeftWords {
    public String reverseLeftWords(String s, int n) {
        // abcdef -> bafedc -> cdefab
        // 先反转 [0,n-1], 再反转 [n, s.length - 1];

        char[] ch = s.toCharArray();

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
