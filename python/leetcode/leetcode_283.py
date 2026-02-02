# https://leetcode.cn/problems/move-zeroes/description/?envType=study-plan-v2&envId=top-100-liked

from typing import List

class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        zero_location = 0
        num_location = 0
        while zero_location<len(nums) and num_location<len(nums):
            if nums[zero_location] != 0:
                zero_location += 1
                continue
            if nums[num_location] == 0 or num_location < zero_location:
                num_location += 1
                continue

            temp = nums[zero_location]
            nums[zero_location] = nums[num_location]
            nums[num_location] = temp


def main() -> None:
    solution = Solution()
    test = [
        [[0,1,0,3,12],[1,3,12,0,0]],
        [[0],[0]],
        [[1,0],[1,0]]
    ]
    for nums, answer in test:
        solution.moveZeroes(nums)
        print(f"the output num is :{nums}, the answer is: {answer}")


if __name__ == "__main__":
    main()
