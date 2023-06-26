package code.leetcode.LC;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Congw
 * 2023/6/21 17:30
 */
public class LC13_romanToInt {

    Map<Character, Integer> map = new HashMap<>() {{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};
    public int romanToInt(String s) {
        int res = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            int value = map.get(s.charAt(i));

            if (i < n-1 && value < map.get(s.charAt(i+1))) {
                res -= value;
            } else {
                res += value;
            }
        }
        return res;
    }
}
