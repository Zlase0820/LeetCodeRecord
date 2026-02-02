# https://leetcode.cn/problems/longest-consecutive-sequence/description/?envType=study-plan-v2&envId=top-100-liked


from typing import List


class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        s_full = set(nums)
        max_length = 0

        for num in s_full:
            # 剪枝: 遍历必须要从最小的值开始往后遍历，找到特定序列的最小值
            if num-1 in s_full:
                continue    

            cur_length = 0
            temp_num = num
            while temp_num in s_full:
                temp_num += 1
                cur_length += 1
                if cur_length > max_length:
                    max_length = cur_length
        
        return max_length


def main() -> None:
    solution = Solution()
    material = [
        [[1],1],
        [[100,4,200,1,3,2],4],
        [[0,3,7,2,5,8,4,6,0,1],9],
        [[1,0,1,2],3]
    ]
    for nums, answer in material:
        results = solution.longestConsecutive(nums)
        print(f"the input nums is: {nums}, the output is: {results}, the answer is: {answer}")

if __name__ == "__main__":
    main()



