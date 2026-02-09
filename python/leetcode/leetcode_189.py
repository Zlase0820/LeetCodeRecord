# https://leetcode.cn/problems/rotate-array/description/?envType=study-plan-v2&envId=top-100-liked


from typing import List

class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
            简单方案: 设一个list[k]的数组，移动k个值，用另外k个值补位
            取巧方案：
                1,2,3,4,5,6,7 右轮询3次 5,6,7,1,2,3,4
                如果仔细看可以发现规律，将这组数字逆序 7,6,5,4,3,2,1
                按照轮询次数进行切分    7,6,5 | 4,3,2,1  
                再将结果进行逆序        5,6,7 | 1,2,3,4 
                注意，当前场景无法处理不移动的情况
        """
        k = k % len(nums)
        if k == 0:
            return
        self.reverse(nums, 0, len(nums) - 1)
        self.reverse(nums, 0, k - 1)
        self.reverse(nums, k, len(nums) - 1)

    def reverse(self, nums: List[int], left:int, right:int) -> None:
        for index in range(left, int(left + (right - left)/2) + 1):
            temp = nums[index]
            nums[index] = nums[right - index + left]
            nums[right - index + left] = temp


def main() -> None:
    test = [
        [[1,2],0,[1,2]],
        [[1,2,3,4,5,6,7],1,[5,6,7,1,2,3,4]],
        [[-1,-100,3,99],2,[3,99,-1,-100]]
    ]
    solution = Solution()
    for input, key, answer in test:
        origin_input = list(input)
        solution.rotate(input, key)
        print(f"the origin input is: {origin_input}, the key is: {key}, the answer is:{answer}, the output is: {input}")


if __name__ == "__main__":
    main()

