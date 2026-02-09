# https://leetcode.cn/problems/merge-intervals/description/?envType=study-plan-v2&envId=top-100-liked

from typing import List


class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        """
            按照0位置排序，处理好边界即可
        """
        result = []
        # 要重点记录一下python中在collections中进行排序的lambda表达式的排序方式
        intervals.sort(key= lambda x:x[0])  
        key = intervals[0]
        for index in range(len(intervals)-1):
            # 确认是否有交集
            if intervals[index][0] <= key[1]:
                key = [key[0], max(key[1], intervals[index][1])]
                continue
            result.append(key)
            key = intervals[index]

        # 处理尾部边界
        if intervals[-1][0] <= key[1]:
            key = [key[0], max(key[1], intervals[-1][1])]
            result.append(key)
        else:
            result.append(key)
            result.append(intervals[-1])

        return result


def main() -> None:
    test = [
        [[[1,3]],[[1,3]]],
        [[[1,3],[2,6],[8,10],[15,18]],[[1,6],[8,10],[15,18]]],
        [[[1,4],[4,5]],[[1,5]]],
        [[[4,7],[1,4]],[[1,7]]]
    ]
    solution = Solution()
    for input,answer in test:
        output = solution.merge(input)
        print(f"the input is: {input}, the answer is: {answer}, the output is: {output}")


if __name__ == "__main__":
    main()
