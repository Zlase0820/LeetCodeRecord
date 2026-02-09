# https://leetcode.cn/problems/maximum-subarray/?envType=study-plan-v2&envId=top-100-liked

from typing import List


class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        """
            增加一个sums，作为nums数组加和的值，那么答案就是 sum[j] - sum[i] 的最大值，注意处理一下边界即可
        """
        min_num = nums[0]
        max_num = nums[0]

        # 处理加和
        sums = []
        sums.append(nums[0])
        for index in range(1, len(nums)):
            sums.append(sums[index-1] + nums[index])

        # 遍历取得最大值
        for index in range(1, len(sums)):
            max_num = max(max_num, max(sums[index] - min_num, sums[index]))
            min_num = min(min_num, sums[index])

        return max_num


def main() -> None:
    test = [
        [[-2,1],1],
        [[-1,-2,-3,-4],-1],
        [[-2,1,-3,4,-1,2,1,-5,4],6],
        [[1],1],
        [[5,4,-1,7,8],23]
    ]
    solution = Solution()
    for input,answer in test:
        output = solution.maxSubArray(input)
        print(f"the input is {input}, the output is {output}, the answer is {answer}")


if __name__ == "__main__":
    main()


