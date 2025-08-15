[题目传送门](https://leetcode.cn/problems/unique-substrings-in-wraparound-string/)


完了，芭比Q了，我没有做出来，我现在这么菜吗？？？？

解题思路：  
    
- 第一步：在p中找到当前坐标在s中是否存在
- 第二步：将所有的下标计算子串的数量  
- 第三步：去重
  
例子1：  
s="..abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz.."  
p="zab"

dp[0]表示z，在s中存在，则dp[0]=1  
dp[1]表示za,确实在s中存在，所以dp[1]=2  
dp[2]表示zab,确实在s中存在，所以dp[2]=3  
那么dp则表示从0-2都是子数组，所以用set给子数组去重，得到6个子串

  
  
  
例子2：  
s="..abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz.."  
p="cac"

dp[0]表示c，在s中存在，则dp[0]=1  
dp[1]表示ca,确实在s中不存在，所以dp[1]=1  
dp[2]表示ac,确实在s中不存在，所以dp[2]=1  
那么dp则表示从0-2都是子数组，所以有子数组c，a，c，去重后为c和a



例子3：  
s="..abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz.."  
p="aabb"

重点在于去重，可以设置一个长度为26的数组，这个数组表示以这个字符结尾的最长的串的长度，通过这种方式即可完成去重  

