# https://leetcode.cn/problems/set-matrix-zeroes/?envType=study-plan-v2&envId=top-100-liked

from typing import List

class Solution:
    def setZeroes(self, matrix: List[List[int]]) -> None:
        """
            原始使用空间是O(m+n)设立一个set，将横纵坐标存储起来
            如果考虑使用O(1)，则将第0行和第0列作为标识即可
            注意：边界问题需要考虑清楚
        """
        row_zero = False # 第0行都应该置0
        col_zero = False # 第0列都应该置0

        # 处理边界
        if matrix[0][0] == 0:
            row_zero = True
            col_zero = True
        else:
            for col in range(len(matrix[0])):
                if matrix[0][col] == 0:
                    row_zero = True
                    break
            for row in range(len(matrix)):
                if matrix[row][0] == 0:
                    col_zero = True
                    break
        
        # 非边界遍历
        for col in range(1,len(matrix[0])):
            for row in range(1,len(matrix)):
                if matrix[row][col] == 0:
                    matrix[0][col] = 0
                    matrix[row][0] = 0
        
        # 重置矩阵
        for row in range(1,len(matrix)):
            if matrix[row][0] == 0:
                for col in range(len(matrix[0])):
                    matrix[row][col] = 0
        for col in range(1,len(matrix[0])):
            if matrix[0][col] == 0:
                for row in range(len(matrix)):
                    matrix[row][col] = 0
        if row_zero:
            for col in range(len(matrix[0])):
                matrix[0][col] = 0
        if col_zero:
            for row in range(len(matrix)):
                matrix[row][0] = 0        


def main() -> None:
    test = [
        [[[1,0,3]],[[0,0,0]]],
        [[[1,1,1],[1,0,1],[1,1,1]],[[1,0,1],[0,0,0],[1,0,1]]],
        [[[0,1,2,0],[3,4,5,2],[1,3,1,5]],[[0,0,0,0],[0,4,5,0],[0,3,1,0]]]
    ]
    solution = Solution()
    for input, answer in test:
        origin_input = list(input)
        solution.setZeroes(input)
        print(f"the input is: {origin_input}, the output is: {input}, the answer is: {answer}")



if __name__ == "__main__":
    main()