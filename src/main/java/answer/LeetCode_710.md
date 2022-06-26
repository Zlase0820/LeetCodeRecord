[题目传送门](https://leetcode.cn/problems/merge-intervals/)




解题思路：  
    
- 黑名单长度为s，我们从[0, N-s)中取随机值，这个随机值有可能在黑名单中，怎么办？  
- [0, N-s)内的元素，如果有i个在黑名单中，那么在[N-s, N)中，必定有i个元素不在黑名单中
- 对[0, N-s)中的黑名单元素和[N-s, N)中不在黑名单中的元素做映射m，必定可以一一对应，怎么对应倒是无所谓
- 从[0, N-s)中取随机值r，如果r不在黑名单中，直接返回；如果r在黑名单中，则m[r]一定不在黑名单，返回m[r]