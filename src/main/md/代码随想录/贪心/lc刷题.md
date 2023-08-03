## 376. 摆动序列

```Python
class Solution:
    def wiggleMaxLength(self, nums: List[int]) -> int:

        if len(nums) == 1:
            return 1

        preDiff = 0
        curDiff = 0
        res = 1

        for i in range(0, len(nums) - 1):
            curDiff = nums[i+1] - nums[i]
            if (preDiff >= 0 and curDiff < 0) or (preDiff <= 0 and curDiff > 0):
                preDiff = curDiff
                res += 1
        
        return res
```

## 53. 最大子数组和

贪心
```Python
class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        res = float('-inf')
        count = 0
        for i in range(len(nums)): # 区间累计最大值，不断更新区间的终止位置
            count += nums[i]
            res = max(res, count)
            if (count < 0):
                count = 0   # < 0 更新左区间
        return res
```

动态规划
```Python
class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        dp = [0] * len(nums)
        dp[0] = nums[0]

        for i in range(1, len(nums)):
            dp[i] = max(dp[i-1] + nums[i], nums[i])
        
        return dp[len(nums) - 1]
```