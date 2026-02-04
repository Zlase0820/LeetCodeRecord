# https://leetcode.cn/problems/sliding-window-maximum/solutions/2499715/shi-pin-yi-ge-shi-pin-miao-dong-dan-diao-ezj6/?envType=study-plan-v2&envId=top-100-liked

from typing import List
from collections import deque


class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        """
            传统方案：每一个滑动窗口k内，遍历一遍，得到最大值，时间复杂度(n-k+1)k=nk，时间过长
            单调队列：维护一个队列，队列保留nums的下标，队头是nums[x]的最大值，后进入队列的如果比队头的大，后侧弹出，如果比队头小，入队。
                一旦队头位置在k框外侧，队头弹出。这样能保证队列长度<=k,队头是当前队列最大值。
        """
        answer = []
        queue = deque()
        left = 0
        right = k - 1

        for index in range(len(nums) + 1):
            if index >= k:
                answer.append(nums[queue[0]])
                left += 1
                if queue[0] < left:
                    queue.popleft()
                right += 1
                if right >= len(nums):
                    break

            while len(queue) != 0 and nums[queue[-1]] < nums[index]:
                queue.pop()
            if len(queue) == 0:
                queue.append(index)
                continue
            if nums[queue[-1]] >= nums[index]:
                queue.append(index)
            
        return answer


def main() -> None:
    test = [
        [[1,3,-1,-3,5,3,6,7],3,[3,3,5,5,6,7]],
        [[1],1,[1]]
    ]
    solution = Solution()
    for input, k, answer in test:
        output = solution.maxSlidingWindow(input,k)
        print(f"the input is:{input} and {k}, the output is: {output}, the answer is {answer}")


if __name__ == "__main__":
    main()



