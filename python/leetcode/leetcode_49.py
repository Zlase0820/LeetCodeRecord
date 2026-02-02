# https://leetcode.cn/problems/group-anagrams/description/?envType=study-plan-v2&envId=top-100-liked

from typing import List
from collections import defaultdict


class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        result_dict = defaultdict(list)
        for centense in strs:
            sort_centense = "".join(sorted(centense))
            result_dict[sort_centense].append(centense)
        return list(result_dict.values())


def main() -> None:
    solution = Solution()
    test_list = [
        [["eat", "tea", "tan", "ate", "nat", "bat"], [["bat"],["nat","tan"],["ate","eat","tea"]]],
        [[""],[[""]]],
        [["a"],[["a"]]]
    ]
    for input, answer in test_list:
        result = solution.groupAnagrams(input)
        print(f"the input is: {input}, the output is: {result}, the answer is: {answer}")


if __name__ == "__main__":
    main()

