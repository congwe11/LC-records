package code.D.stack_queue;

import java.util.*;

public class LC239_maxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n-k+1];
        int idx = 0;

        Deque<Integer> que = new LinkedList<>();

        for (int i = 0; i < k; i++) {
            while (!que.isEmpty() && que.peekLast() < nums[i]) {
                que.pollLast();
            }
            que.offerLast(nums[i]);
        }
        res[idx++] = que.peekFirst();

        for (int i = k; i < n; i++) {
            
            if (que.peek() == nums[i-k]) {
                que.pop();
            }
            // 滑动窗口
            while (!que.isEmpty() && que.peekLast() < nums[i]) {
                que.pollLast();
            }
            que.offerLast(nums[i]);

            res[idx++] = que.peekFirst();
        }
        return res;
        
    }

    public static void main(String[] args) {
        LC239_maxSlidingWindow s = new LC239_maxSlidingWindow();
        int[] res = s.maxSlidingWindow(new int[]{1,3,1,2,0,5}, 3);
        for (int x : res) {
            System.out.println(x);
        }
    }
}
