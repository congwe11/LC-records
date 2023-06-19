package code.test;

/**
 * @author Congw
 * 2023/6/7 16:41
 */
public class nextArray {

    public static void main(String[] args) {
        String s = "pwwkew";
        int[] next = getNext(s);
        for (int i : next) {
            System.out.println(i);
        }
    }

    public static int[] getNext(String s) {
        int[] next = new int[s.length()];
        int j = -1;
        next[0] = j;

        for (int i = 1; i < next.length; i++) {
            while (j > -1 && s.charAt(i) != s.charAt(j+1)) {
                j = next[j];
            }
            if (s.charAt(i) == s.charAt(j+1)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }
}
