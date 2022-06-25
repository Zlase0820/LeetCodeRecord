[题目传送门](https://leetcode.cn/problems/merge-intervals/)




解题思路：  
有两种方案：  


- 使用DFS，但是这种方案有很多重复计算，会超时
```aidl

    // 这种思路超时，遍历的可能性太多了，有大量重复计算
    private int cost = Integer.MAX_VALUE;

    // 有约束条件的DFS
    public int minCost(int[][] costs) {
        dfs(costs, 0, 0, costs[0][0]);
        dfs(costs, 0, 1, costs[0][1]);
        dfs(costs, 0, 2, costs[0][2]);
        return cost;
    }

    private void dfs(int[][] costs, int row, int col, int sum) {
        if (col == 0 && row < costs.length - 1) {
            dfs(costs, row + 1, 1, sum + costs[row + 1][1]);
            dfs(costs, row + 1, 2, sum + costs[row + 1][2]);
        } else if (col == 1 && row < costs.length - 1) {
            dfs(costs, row + 1, 0, sum + costs[row + 1][0]);
            dfs(costs, row + 1, 2, sum + costs[row + 1][2]);
        } else if (col == 2 && row < costs.length - 1) {
            dfs(costs, row + 1, 0, sum + costs[row + 1][0]);
            dfs(costs, row + 1, 1, sum + costs[row + 1][1]);
        } else {
            if (sum < cost) {
                cost = sum;
            }
        }
    }


```


- 第二种方案，动态规划，每次基于本层找到上一层的最小值，那么最后一层就是整体的最小值