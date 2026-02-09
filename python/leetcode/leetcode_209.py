# https://leetcode.cn/problems/minimum-size-subarray-sum/description/

from typing import List

class Solution:
    def minSubArrayLen(self, target: int, nums: List[int]) -> int:
        return None

        
                    





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
