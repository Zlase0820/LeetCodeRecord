# https://leetcode.cn/problems/container-with-most-water/description/?envType=study-plan-v2&envId=top-100-liked

from typing import List


class Solution:
    def maxArea(self, height: List[int]) -> int:
        left = 0 
        right = len(height) - 1
        water = 0
        while left < right:
            cur_water = (right - left) * min(height[left], height[right])
            water = max(water, cur_water)
            if height[left] > height[right]:
                right -= 1
            else:
                left += 1
        return water
    

def main() -> None:
    test = [
        [[1,8,6,2,5,4,8,3,7],49],
        [[1,1],1]
    ]

    solution = Solution()
    for nums, answer in test:
        result = solution.maxArea(nums)
        print(f"the input is: {nums}, the output is: {result}, the answer is: {answer}")
    



if __name__ == "__main__":
    main()
