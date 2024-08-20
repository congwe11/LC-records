import java.util.PriorityQueue;

class Solution {

// 现在是3-branch

    public static int halveArray(int[] nums) {
        PriorityQueue<Double> pq = new PriorityQueue<Double>((a, b) -> b.compareTo(a));
        double sum = 0;
        for (int num : nums) {
            pq.offer((double) num);
            sum += num;
        }

        double half = sum / 2;
        int res = 0;
        double sum2 = 0.0;

        while (sum2 < half) {
            double x = pq.poll();
            sum2 += x / 2;
            pq.offer(x / 2);
            res++;
        }

        return res;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{5,19,8,1};

//        int i = halveArray(a);
//        System.out.println("i = " + i);

        PriorityQueue<Double> pq = new PriorityQueue<>(Double::compareTo);
        for (int num : nums) {
            pq.offer((double) num);
        }

        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }

    }
}