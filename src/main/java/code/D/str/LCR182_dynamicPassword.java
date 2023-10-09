package code.D.str;

public class LCR182_dynamicPassword {
    public static void main(String[] args) {
        String passward = "abcdef";
        int k = 2;
        String reString = dynamicPassword(passward, k);
        System.out.println(reString);
    }
    public static String dynamicPassword(String password, int target) {
        
        // 先反转前 target，
        // 后反转 target 之后的
        // 最后反转 全部
        int n = password.length();
        StringBuilder sb = new StringBuilder(password);

        reverseStr(sb, 0, target-1);
        reverseStr(sb, target, n-1);
        sb.reverse();
        return sb.toString();
    }

    private static void reverseStr(StringBuilder sb, int l, int r) {

        while (l < r) {
            char temp = sb.charAt(l);
            sb.setCharAt(l, sb.charAt(r));
            sb.setCharAt(r, temp);
            l++;
            r--;
        }
    }
}
