# https://leetcode.cn/problems/minimum-size-subarray-sum/description/

from typing import List

class Solution:
    def minSubArrayLen(self, target: int, nums: List[int]) -> int:
        sums = [0]*len(nums)
        sum = 0
        min_length = 100000
        for index in range(len(nums)):
            sum += nums[index] 
            sums[index] = sum
            while sum > target:
                
                    





def main() -> None:
    test = [
        [[2,3,1,2,4,3],7,2],
        [[1,4,4],4,1],
        [[1,1,1,1,1,1,1,1],11,0]
    ]
    solution = Solution()
    for nums,target,answer in test:
        output = solution.minSubArrayLen(target, nums)
        print(f"the input is: {nums} and {target}, the output is: {output}, the answer is: {answer}")


if __name__ == "__main__":
    main()
