package code.leetcode.LC;

/**
 * @author Congw
 * 2023/6/15 22:22
 */
public class LC191_HammingWeight {
    public int hammingWeight(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            System.out.println(i + " : " + (n & (1 << i)));
            if ((n & (1 << i)) > 0) {
                res++;
            }
        }
        System.out.println("res = " + res);
        return res;
    }

    public static void main(String[] args) {
        LC191_HammingWeight solution = new LC191_HammingWeight();
        solution.hammingWeight(-3);
    }
}
