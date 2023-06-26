package code.other;

/**
 * @author Congw
 * 2023/6/9 15:02
 */
public class view {

    public static int countNumbers() {
        boolean[] numbers = new boolean[1997]; // 初始化布尔数组
        int count = 0;

        for (int i = 1; i <= 1997; i++) {
            if (!numbers[i - 1]) { // 当前数未被选中
                for (int j = i + 1; j <= 1997; j++) {
                    if (!numbers[j - 1] && (i + j) % 22 == 0) {
                        numbers[j - 1] = true;
                        count++;
                    }
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int maxCount = countNumbers();
        System.out.println("最多能选出的数的个数：" + maxCount);
    }
}
