package code.leetcode.stack_queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class _0239MaxSlidingWindow {

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n-k+1];
        int idx = 0;
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i=0; i<k; i++) {
            while(!deque.isEmpty() && nums[i] > deque.getLast()){
                deque.removeLast();
            }
            deque.add(nums[i]);
        }
        res[idx++] = deque.peek();

        for (int i=k; i<n; i++) {
            if(!deque.isEmpty() && nums[i-k] == deque.peek()) {
                deque.removeFirst();
            }
            while(!deque.isEmpty() && nums[i] > deque.getLast()) {
                deque.removeLast();
            }
            deque.add(nums[i]);

            res[idx++] = deque.peek();
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,1,2,0,5};

        maxSlidingWindow(nums, 3);
    }
}
