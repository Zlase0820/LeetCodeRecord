# https://leetcode.cn/problems/longest-substring-without-repeating-characters/description/?envType=study-plan-v2&envId=top-100-liked


from collections import deque

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        """
            使用队列，保留顺序，进入和弹出即可
            如果还要加速，可以在加一个set，查询的时候用set加速，弹出的时候同时弹出set和queue
        """
        q = deque()
        max_num = 0

        for temp_char in s:
            while temp_char in q:
                q.popleft()
            q.append(temp_char)
            max_num = max(max_num, len(q))
        return max_num


def main() -> None:
    input = [
        ["abcabcbb",3],
        ["bbbbb",1],
        ["pwwkew",3]
    ]
    solution = Solution()
    for string,answer in input:
        output = solution.lengthOfLongestSubstring(string)
        print(f"the input is: {string}, the output is {output}, the answer is: {answer}")

if __name__ == "__main__":
    main()


