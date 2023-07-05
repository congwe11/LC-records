import java.util.HashMap;
import java.util.Map;

/**
 * @author Congw
 * 2023/6/28 15:27
 */
public class mianshi {

    public boolean test1(int x) {

        String s = String.valueOf(x);
        char[] chs = s.toCharArray();
        int l = 0, r = chs.length - 1;
        while (l < r) {
            if (chs[l] != chs[r]) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }


    public int test2(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int l = 0;
        int res = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                l = Math.max(l, map.get(ch) + 1);
            }
            map.put(ch, i);
            res = Math.max(res, i - l + 1);
        }

        return res;
    }
}
