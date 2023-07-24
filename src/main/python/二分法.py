
# nums 是非递减的，即 nums[i] <= nums[i + 1]

def lower_bound1(nums: list[int], target: int) -> int:
    left = 0
    right = len(nums) - 1    # 闭区间 [left, right]
    while left <= right:    # 区间不为空
        # left (right - left) / 2
        mid = (left + right) // 2
        if nums[mid] < target:
            left = mid + 1  # [mid + 1, right]
        else:
            right = mid - 1 # [left, mid - 1]
        return left
    
def lower_bound2(nums: list[int], target: int) -> int:
    left = 0
    right = len(nums)    # 左闭右开区间 [left, right)
    while left < right:    # 区间不为空
        # left (right - left) / 2
        mid = (left + right) // 2
        if nums[mid] < target:
            left = mid + 1  # [mid + 1, right)
        else:
            right = mid # [left, mid)
        return left # right

def lower_bound3(nums: list[int], target: int) -> int:
    left = -1
    right = len(nums)    # 左开右开区间 (left, right)
    while left + 1 < right:    # 区间不为空
        # left (right - left) / 2
        mid = (left + right) // 2
        if nums[mid] < target:
            left = mid  # (mid, right)
        else:
            right = mid # (left, mid)
        return right 
    
    
