package code.jzOffer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Congw
 * 2023/6/26 20:47
 */
public class JZ20_isNumber {

    public boolean isNumber(String s) {
        return true;
    }

    public StringBuilder removeSpace(String s) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch != ' ') {
                sb.append(ch);
            }
        }
        return sb;
    }
}
