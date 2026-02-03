# https://leetcode.cn/problems/trapping-rain-water/description/?envType=study-plan-v2&envId=top-100-liked


from typing import List

class Solution:
    def trap(self, height: List[int]) -> int:
        """
            O(n^2)算法，找到每一个位置向左和向右分别的最大值，就可以知道在当前位置上可获得的最大高度
            O(n)算法，动态规划。设置max_high_left和max_high_right，表示在这个点左侧最高的值和右侧最高的值
        """
        max_high_left = [0]*len(height)
        max_high_right = [0]*len(height)
        max_water = 0

        for index in range(1, len(height), 1):
            max_high_left[index] = max(height[index-1], max_high_left[index-1])
        
        for index in range(len(height)-2, -1, -1):
            max_high_right[index] = max(height[index+1], max_high_right[index+1])

        for index in range(len(height)):
            high = min(max_high_left[index], max_high_right[index])
            if height[index] < high:
                max_water += high - height[index]

        return max_water



def main() -> None:
    input = [
        [[1,2,3,1,2,1,3],4],
        [[0,1,0,2,1,0,1,3,2,1,2,1],6],
        [[4,2,0,3,2,5],9]
    ]
    solution = Solution()
    for nums,answer in input:
        output = solution.trap(nums)
        print(f"the input is: {nums}, the output is: {output}, the answer is: {answer}")

if __name__ == "__main__":
    main()