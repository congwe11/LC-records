package code.D.stack_queue;

import java.util.*;

/*Comparator接口说明:
 * 返回负数，形参中第一个参数排在前面；返回正数，形参中第二个参数排在前面
 * 对于队列：排在前面意味着往队头靠
 * 对于堆（使用PriorityQueue实现）：从队头到队尾按从小到大排就是最小堆（小顶堆），
 *                                从队头到队尾按从大到小排就是最大堆（大顶堆）--->队头元素相当于堆的根节点
 * */
public class LC347_topKFrequent {
    // 解法1：基于大顶堆实现
    public int[] topKFrequent1(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        //在优先队列中存储二元组(num,cnt),cnt表示元素值num在数组中的出现次数
        //出现次数按从队头到队尾的顺序是从大到小排,出现次数最多的在队头(相当于大顶堆)
        PriorityQueue<int[]> pq = new PriorityQueue<>((pair1, pair2)->(pair2[1] - pair1[1]));

        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            pq.add(new int[]{entry.getKey(), entry.getValue()});
        }
        
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = pq.poll()[0];
        }
        return res;
    }

    public int[] topKFrequent2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        //在优先队列中存储二元组(num,cnt),cnt表示元素值num在数组中的出现次数
        //出现次数按从队头到队尾的顺序是从小到大排,出现次数最低的在队头(相当于小顶堆)
        PriorityQueue<int[]> pq = new PriorityQueue<>((pair1, pair2)->(pair1[1] - pair2[1]));

        for (Map.Entry<Integer, Integer> entry: map.entrySet()) { //小顶堆只需要维持k个元素有序
            if (pq.size() < k) {
                pq.add(new int[]{entry.getKey(), entry.getValue()});
            } else {
                if (entry.getValue() > pq.peek()[1]) {
                    // 当前元素出现的次数 > 小顶堆的根节点 ((这k个元素中出现次数最少的那个)
                    pq.poll(); // 弹出队头，把当前元素入队，即把堆里出现次数最少的那个删除,留下出现次数多的 元素
                    pq.add(new int[]{entry.getKey(), entry.getValue()});
                }
            }
        }
        
        int[] res = new int[k];
        for (int i = k-1; i > -1; i--) {
            res[i] = pq.poll()[0];
        }
        return res;
    }


    public static void main(String[] args) {
        LC347_topKFrequent s = new LC347_topKFrequent();

        int[] res = s.topKFrequent2(new int[]{1, 1, 1, 2, 3, 3}, 3);
        for (int x : res) {
            System.out.println(x);
        }
    }
}
