# https://leetcode.cn/problems/subarray-sum-equals-k/description/?envType=study-plan-v2&envId=top-100-liked



from typing import List
from collections import defaultdict


class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        """
            1.前缀和: 设置一个sum值，表示从[0,i]范围内的加和，子序列(i,j)的加和，就是(0,j)-(0,i)的加和，最后两次遍历的时间复杂度是O(n^2)
            2.哈希表优化循环: 最后的循环可以改装成数字存储在Dict里边，原本是遍历sum[j] - sum[i] == k，可以修改成sum[j]-k=sum[i]，查看sum[i]是否在hash表中
            3.结合：如果先实现1在实现2难度会很大，还需要记录位置信息，最好是遍历一次时直接解决两个问题
        """
        result = 0
        sum = 0
        sums = [0]*len(nums)
        dict_hash = defaultdict(int)
        dict_hash[0] = 1

        for index in range(len(nums)):
            sum += nums[index]
            sums[index] = sum
            result += dict_hash.get(sums[index] - k, 0)
            dict_hash[sums[index]] += 1

        return result
    

def main() -> None:
    test = [
        [[0,0,0],0,6],
        [[-1,-1,1],0,1],
        [[1,1,1],2,2],
        [[1,2,3],3,2]

    ]
    solution = Solution()
    for input,k,answer in test:
        output = solution.subarraySum(input, k)
        print(f"the input is: {input} and {k}, the output is: {output}, the answer is: {answer}")

if __name__ == "__main__":
    main()




