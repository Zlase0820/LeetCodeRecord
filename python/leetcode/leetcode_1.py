# https://leetcode.cn/problems/two-sum/?envType=study-plan-v2&envId=top-100-liked


from dataclasses import dataclass
from typing import List


@dataclass
class NumUnit:
    number: int
    index: int


class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        results = []
        list_num = []

        for index in range(len(nums)):
            list_num.append(NumUnit(number = nums[index], index = index))
        list_num.sort(key = lambda x: x.number)

        left = 0
        right = len(nums) - 1
        while left < right:
            if list_num[left].number + list_num[right].number == target:
                results.append(list_num[left].index)
                results.append(list_num[right].index)
                break
            elif list_num[left].number + list_num[right].number > target:
                right = right - 1
            elif list_num[left].number + list_num[right].number < target:
                left = left + 1

        return results


def main() -> None:
    # test unit
    test_input = [
        [[2,7,11,15],9,[0,1]],
        [[3,2,4],6,[1,2]],
        [[3,3],6,[0,1]]
    ]
    
    solution = Solution()
    for lists, target, answer in test_input:
        results = solution.twoSum(nums=lists, target=target)
        print(f"the input number is {lists}, the target is {target}", 
                f"the answer is {answer}, the solution answer is {results}")


if __name__ == "__main__":
    main()