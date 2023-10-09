package code.test.source;

/**
 * @author Congw
 * 2023/6/13 11:45
 */
public class exception {

    public static void main(String[] args) {
        System.out.println(test1()); // 2
    }
    public static int test1() {
        int i = 0;
        try {
            i = 2;
            return i;
        } finally {
            i = 3;
        }
    }

}
