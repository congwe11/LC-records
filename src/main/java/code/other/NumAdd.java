package code.other;

/**
 * @author Congw
 * 2023/6/8 16:44
 */
public class NumAdd {

    // 不使用+的加法
    public static int addWithoutAdd(int a, int b) {
        int sum;
        int carry;
        while (b != 0) {
            sum = a^b;
            carry = (a&b) << 1;
            a = sum;
            b = carry;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(addWithoutAdd(1, 2));
    }
}
