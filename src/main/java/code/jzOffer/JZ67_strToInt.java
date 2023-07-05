package code.jzOffer;

/**
 * @author Congw
 * 2023/7/2 15:35
 */
public class JZ67_strToInt {

    public int strToInt(String str) {

        if (str.isEmpty()) return 0;

        int index = 0, n = str.length(), res = 0, sign = 1;
        // 1 判断空格
        while (index < n && str.charAt(index) == ' ') {
            index++;
        }
        // 2 判断符号
        if (index < n && (str.charAt(index) == '+' || str.charAt(index) == '-')) {
            sign = str.charAt(index++) == '+' ? 1 : -1;
        }

        // 3 判断数字
        while (index < n && Character.isDigit(str.charAt(index))) {
            int digit = str.charAt(index) - '0';
            // 4 判断是否溢出
            if (res > (Integer.MAX_VALUE - digit) / 10) {
                // res * 10 + digit > MAX_VALUE ?
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + digit;
            ++index;
        }
        return res * sign;
    }
}
