# https://leetcode.cn/problems/3sum/description/?envType=study-plan-v2&envId=top-100-liked

from typing import List
from collections import defaultdict


class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        """
            三数求和,a+b+c=0,置换成 a=-(b+c)
            先将数组排序,固定a,然后双指针遍历余下数组的左右两端，让其加和值为 -(b+c)
            剪枝,不论是最外层还是内层,如果每次移动后的值和之前的值一样,跳过这次计算
        """
        result = []
        nums.sort()
        # i是a，最小的值，且必须有b和c，所以a的取值上限就是n-2
        for i in range(len(nums)-2):

            # 剪枝，如果nums[i]最小值>0，则后边无需遍历
            if nums[i] > 0:
                break

            # 剪枝，如果nums[i]和nums[i-1]相同，则可以跳过本轮循环
            if i > 0 and nums[i] == nums[i-1]:
                continue
            
            left = i + 1
            right = len(nums) - 1
            while left < right:
                target_temp = -1 * (nums[left] + nums[right])
                if target_temp == nums[i]:
                    result.append([nums[i], nums[left], nums[right]])
                    left += 1
                    right -= 1
                    while left < right and nums[left] == nums[left-1]:
                        left += 1
                    while left < right and nums[right] == nums[right+1]:
                        right -=1
                elif target_temp > nums[i]:
                    left += 1
                    while left < right and nums[left] == nums[left-1]:
                        left += 1
                else:
                    right -= 1
                    while left < right and nums[right] == nums[right+1]:
                        right -=1
        return result


def main() -> None:
    test = [
        [[-100,-70,-60,110,120,130,160],[[-100,-60,160],[-70,-60,130]]],
        [[-1,0,1,2,-1,-4], [[-1,-1,2],[-1,0,1]]],
        [[0,1,1],[]],
        [[0,0,0],[[0,0,0]]],
        [[1,1,1],[[]]],
        [[0,0,0,0,0,0],[[0,0,0]]]
    ]
    solution = Solution()
    for input, answer in test:
        output = solution.threeSum(input)
        print(f"the input is: {input}, the output is: {output}，the answer is: {answer}")


if __name__ == "__main__":
    main()




