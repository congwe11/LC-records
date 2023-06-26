package code.bishi.数美科技;

/**
 * @author Congw
 * 2023/6/20 23:43
 */
public class Solution {

    // 找到第n个特殊数字
    public int findN(int n) {
        if (n == 1) return n;
        int count = 1;
        int num = 2;

        while (count != n) {
            if (num % 2 == 0 || num % 3 == 0 || num % 7 == 0) {
                count++;
                System.out.println("num = " + num);
            }
            num++;
        }
        return num - 1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.findN(1) = " + s.findN(1));
        System.out.println("s.findN(5) = " + s.findN(5));
        System.out.println("s.findN(10) = " + s.findN(10));

    }
}
