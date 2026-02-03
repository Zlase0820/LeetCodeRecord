# https://leetcode.cn/problems/find-all-anagrams-in-a-string/description/?envType=study-plan-v2&envId=top-100-liked


from typing import List

class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        """
            输入string范围只有26个字母，可以创建一个list下标是0-25，将p中出现字符数量放进去；
            按照滑动窗口，在len(p)范围内，每出现一个字符，对应位置数值-1。
            滑动窗口不断前行，每滑动一次如果满足list中所有值都为0，则该窗口满足条件。
        """
        output = []
        p_list = [0]*26

        if len(s) < len(p):
            return output

        for temp_char in p:
            p_list[ord(temp_char) - ord('a')] += 1

        # 进入第一轮数据(最右侧的一个暂时不添加，在循环里添加)
        for index in range(len(p)-1):
            p_list[ ord(s[index]) - ord('a') ] -= 1

        left = 0
        right = len(p) - 1
        while right < len(s):
            p_list[ord(s[right]) - ord('a')] -= 1
            right += 1

            if self.check(p_list):
                output.append(left)
            
            p_list[ ord(s[left]) - ord('a')] += 1
            left += 1
        return output
    
    def check(self, p_list: List[int]) -> bool:
        for num in p_list:
            if num != 0:
                return False
        return True


def main() -> None:
    test = [
        ["cbaebabacd","abc",[0,6]],
        ["abab","ab",[0,1,2]]
    ]
    solution = Solution()
    for s,p,answer in test:
        output = solution.findAnagrams(s,p)
        print(f"the input is: s={s}, p={p}; the output is: {output}; the answer is: {answer}")


if __name__ == "__main__":
    main()

