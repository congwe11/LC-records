package code.test.train;

public class SecondLargestInArray  {
    public static void main(String[] args) {
        // int[] numbers = {5, 2, 9, 8, 7, 9};
        int[] numbers = {1, 1, 2, 2, 1};

        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int number : numbers) {
            if (number > largest) {
                secondLargest = largest;
                largest = number;
            } else if (number > secondLargest && number != largest) {
                secondLargest = number;
            }
        }

        if (secondLargest != Integer.MIN_VALUE) {
            System.out.println("第一大的数是：" + largest);
            System.out.println("第二大的数是：" + secondLargest);
        } else {
            System.out.println("没有找到第二大的数");
        }
    }
}
