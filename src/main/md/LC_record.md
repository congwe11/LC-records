| 题目 | 标签 | 解法 |
| --- | --- | --- |
| [1851. 包含每个查询的最小区间](https://leetcode.cn/problems/minimum-interval-to-include-each-query/description/) |`数组`  `优先队列` `排序` `离线查询`| ... |
| [538. 把二叉搜索树转换为累加树](https://leetcode.cn/problems/convert-bst-to-greater-tree/) |`二叉树`  `中序` `前节点`| ... |
| [77. 组合](https://leetcode.cn/problems/combinations/submissions/) |`数组`  `组合` `回溯`| ... |


## 回溯
**回溯模板**
```Java
// 回溯模板
void backtracking(参数) {
    if (终止条件) {
        存放结果;
        return;
    }

    for (选择：本层集合中元素（树中节点孩子的数量就是集合的大小）) {
        处理节点;
        backtracking(路径，选择列表); // 递归
        回溯，撤销处理结果;
    }
}

```
### 77. 组合
回溯三部曲：

- 递归函数的返回值和参数
- 回溯函数的终止条件
- 单层搜索的过程
想象一个树形结果

参数中需要一个`startIndex`确定每层遍历的起始位置
终止条件，当子列表长度满足时记录结果并返回
依次遍历每一层，`for (int i=startIndex; i<n; i++) : backTracking(n, k, i + 1)`

剪枝：
- 已选择元素个数： path.size()
- 还需要：k - path.size()
- 所以集合 n 中 至多的要从 n - path.size() + 1 开始遍历, （包括起始节点）

```Java
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    
    public List<List<Integer>> combine(int n, int k) {
        backTracking(n, k, 1);
        return res;
    }

    public void backTracking(int n, int k, int startIndex) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i <= n - (k - path.size()) + 1; i++) {
            path.add(i);
            backTracking(n, k, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
```

```Java
class Solution {
    int pre = 0;
    public TreeNode convertBST(TreeNode root) {
        traversal(root);

        return root;
    }
    
    public void traversal(TreeNode root) {
        if (root == null) return;

        traversal(root.right);
        pre += root.val;
        root.val = pre;
        traversal(root.left);
    }
}
```

```python
class Solution:
    def sortedArrayToBST(self, nums: List[int]) -> Optional[TreeNode]:

        root = self.traversal(nums, 0, len(nums) - 1)
        return root

    
    def traversal(self, nums, l, r):
        if l > r: return None
        
        mid = (l + r) // 2
        root = TreeNode(nums[mid])
        root.left = self.traversal(nums, l, mid - 1)
        root.right = self.traversal(nums, mid + 1, r)

        return root
```


```java
class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]); // 区间升序排序
        int[][] qs = new int[queries.length][2];
        for (int i = 0; i < queries.length; i++) {
            qs[i][0] = queries[i];
            qs[i][1] = i;
        }

        Arrays.sort(qs, (a, b) -> a[0] - b[0]); // 查询升序排序（离线查询）
        int[] res = new int[qs.length];
        Arrays.fill(res, -1);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]); // 区间大小升序排序， 每次只取对头元素[0]即可
        int i = 0; // 记录intervals处理的位置
        for (int[] q: qs) {
            int x = q[0], j = q[1];
            // 左端点小于等于 x 的都是候选
            while (i < intervals.length && intervals[i][0] <= x) {
                pq.offer(new int[]{intervals[i][1] - intervals[i][0] + 1, intervals[i][0], intervals[i++][1]});
            }

            // 右端点 < x 的，与当前查询无交集，由于对queries排序了， 后续的q 只会越来越大，不可能与这些区间有交集
            while (!pq.isEmpty() && pq.peek()[2] < x) pq.poll();

            if (!pq.isEmpty()) res[j] = pq.peek()[0];
        }

        return res;
    }
}

public int[] minInterval(int[][] intervals, int[] queries) {
        // 记录 intervals 每个区间的长度，遍历时使用
        // 遍历 intervals 的每个区间，比较 queries[x] 是否在区间内，
        // 记录长度，取最小值, 但是暴力法会超时

        int[] lens = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            lens[i] = intervals[i][1] - intervals[i][0] + 1;
        }

        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int query = queries[i];
            int a = Integer.MAX_VALUE;
            for (int j = 0; j < intervals.length; j++) {
                if (query < intervals[j][0] || query > intervals[j][1]) {
                    continue;
                } else {
                    a = Math.min(a, lens[j]);
                    if (a <= 1) break;
                }
            }

            res[i] = a == Integer.MAX_VALUE ? -1 : a;
        }

        return res;
    }
```
