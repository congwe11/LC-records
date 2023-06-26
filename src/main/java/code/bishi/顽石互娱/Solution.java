package code.bishi.顽石互娱;

import java.util.*;

/**
 * @author Congw
 * 2023/6/21 17:29
 */
public class Solution {
    public int CalProperty (int baseVal, String[] effects) {
        // write code here

        List<Integer> N = new ArrayList<>();
        List<Double> P = new ArrayList<>();

        for (String effect : effects) {
            char first = effect.charAt(0);
            if (first == 'N') {
                N.add(Integer.parseInt(effect.substring(1)));
            } else {
                Double val = Double.parseDouble(effect.substring(1));
                P.add(val / 100);
            }
        }

        double res = 0.0;

        Double base = (double) baseVal;
        for (Integer n : N) {
            base += n;
        }

        Double present = 1.0;
        for (Double p : P) {
            present += p;
        }

        res = present * base;

        int resInt = (int) res;

        double sufix = res - resInt;

        return sufix > 0.5 ? resInt + 1 : resInt;
    }

    public static void getInfo() {

        Scanner in = new Scanner(System.in);
        List<String> logs = new ArrayList<>();
        while (in.hasNextLine()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            String s = in.nextLine();
            if (s.equals("")) break;
            logs.add(s);
            System.out.println("logs = " + logs.size());
        }

        Map<String, Integer> map = new HashMap<>();

        for (String log : logs) {
            String[] result = log.split(",");
            if (result.length != 4) {
                continue;
            }
            // id : 1, 状态：2
            String id = result[1];
            char[] chars = id.toCharArray();

            boolean isNumber = true;
            for (char n : chars) {
                if (n < '0' || n > '9') {
                    isNumber = false;
                    break;
                }
            }
            if (!isNumber) continue;

            String status = result[2];

            if ("login".equals(status)) {
                map.put(id, map.getOrDefault(id, 0) + 1);
            }
        }


        for (Map.Entry<String, Integer> m : map.entrySet()) {
            System.out.println(m.getKey() + "," + m.getValue());
        }

    }

    public static void main(String[] args) {
        getInfo();
    }

}
