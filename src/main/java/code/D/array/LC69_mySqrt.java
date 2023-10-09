package code.D.array;

public class LC69_mySqrt {
    
    public static void main(String[] args) {
        int x = 2147395599;

        x = mySqrt(x);
        System.out.println("LC69_mySqrt.main():" + x);
    }
    public static int mySqrt(int x) {
        
        if (x == 0 || x == 1) return x;
        int l = 0, r = x;
        while (l < r) {
            int mid = l + (r - l) / 2;

            if (mid * mid > x) {
                r = mid;
            } else if (mid * mid < x){
                l = mid + 1;
            } else {
                return mid;
            }
        }
        return l-1;
    }
}
