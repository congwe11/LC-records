package code.test.source;

public class ExceptionHandlingExample {
    public static void main(String[] args) {
        try {
            // 可能会抛出异常的代码块
            int result = divide(10, 0);
            System.out.println("结果：" + result);
        } catch (ArithmeticException e) {
            // 捕获并处理异常
            System.err.println("发生除零异常：" + e.getMessage());
        } finally {
            // 可选的finally块，无论是否发生异常都会执行的代码
            System.out.println("无论是否发生异常，都会执行这里的代码");
        }

        // 程序继续执行
        System.out.println("程序继续执行...");
    }

    // 定义一个方法，可能会抛出ArithmeticException异常
    public static int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("除数不能为零");
        }
        return a / b;
    }

}
