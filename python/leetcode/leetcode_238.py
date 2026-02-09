# https://leetcode.cn/problems/product-of-array-except-self/description/?envType=study-plan-v2&envId=top-100-liked


from typing import List

class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        """
            创建两个矩阵，分别存储nums从左到右/从右到左，不包含自己的乘积
        """
        left_times = [1]*len(nums)
        right_times = [1]*len(nums)
        result_list = []

        for index in range(1, len(nums)):
            left_times[index] = left_times[index - 1] * nums[index - 1]
            
        # python 中for循环的用法需要熟练一下
        for index in range(len(nums)-2, -1, -1):
            right_times[index] = right_times[index + 1] * nums[index + 1]

        for index in range(len(nums)):
            result_list.append(left_times[index]*right_times[index])

        return result_list


def main() -> None:
    test = [
        [[1,2,3,4],[24,12,8,6]],
        [[-1,1,0,-3,3],[0,0,9,0,0]]
    ]
    solution = Solution()
    for input,answer in test:
        output = solution.productExceptSelf(input)
        print(f"the input is: {input}, the output is: {output}, the answer is: {answer}")


if __name__ == "__main__":
    main()
