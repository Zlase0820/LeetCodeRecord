package leetCode;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class LeetCode_675 {


    public int cutOffTree(List<List<Integer>> forest) {
        // 如果起始的位置是0，则置空
        if (forest.size() == 0 || forest.get(0).size() == 0 || forest.get(0).get(0) == 0) {
            return -1;
        }

        // 给树的高度进行排序
        List<Integer> trees = getNums(forest);

        // 如果trees为空，说明没有树，可以直接返还完成，为0
        if (trees.size() == 0) {
            return 0;
        }

        // 正常行走
        int step = 0;
        int tempStep;
        int[] fromLocation = {0, 0}; // 起始位置
        int[] toLocation;
        int[][] arrayForest = getArrayForest(forest);
        for (int i = 0; i < trees.size(); i++) {
            toLocation = findTreeLocation(forest, trees.get(i));
            tempStep = goStep(arrayForest, fromLocation, toLocation) - 1;
            if (tempStep < 0) {
                return -1;
            } else {
                step += tempStep;
            }
            fromLocation[0] = toLocation[0];
            fromLocation[1] = toLocation[1];
        }
        return step;
    }

    // goStep 利用传染模型，广度优先遍历
    private int goStep(int[][] arrayForest, int[] fromLocation, int[] toLocation) {
        int[][] forest = copyForest(arrayForest);
        int row = fromLocation[0];
        int col = fromLocation[1];
        forest[row][col] = 1;
        Queue<Integer[]> queue = new ArrayDeque<>();
        queue.add(new Integer[]{row - 1, col}); // 上
        queue.add(new Integer[]{row + 1, col}); // 下
        queue.add(new Integer[]{row, col - 1}); // 左
        queue.add(new Integer[]{row, col + 1}); // 右
        while (!queue.isEmpty()) {
            Integer[] unit = queue.poll();
            queue.addAll(recursion(forest, unit[0], unit[1]));
        }
        return forest[toLocation[0]][toLocation[1]];
    }

    // 传染模型之前写的有问题，重新赋值forest
    private Queue<Integer[]> recursion(int[][] forest, int row, int col) {
        Queue<Integer[]> queue = new ArrayDeque<>();

        // 超过边界
        if (row < 0 || row >= forest.length || col < 0 || col >= forest[0].length) {
            return queue;
        }

        // 如果直接在沼泽，就返还
        if (forest[row][col] == -1) {
            return queue;
        }

        // 如果已经被遍历过，需要到上下左右比较一下
        int up = Integer.MAX_VALUE;
        int down = Integer.MAX_VALUE;
        int left = Integer.MAX_VALUE;
        int right = Integer.MAX_VALUE;
        if (row - 1 >= 0 && forest[row - 1][col] > 0) {
            up = forest[row - 1][col];
        }
        if (row + 1 < forest.length && forest[row + 1][col] > 0) {
            down = forest[row + 1][col];
        }
        if (col - 1 >= 0 && forest[row][col - 1] > 0) {
            left = forest[row][col - 1];
        }
        if (col + 1 < forest[0].length && forest[row][col + 1] > 0) {
            right = forest[row][col + 1];
        }

        /**
         * 如果之前有过赋值，则只更新当前值
         */
        if (forest[row][col] > 0) {
            forest[row][col] = Math.min(forest[row][col], Math.min(Math.min(up, down), Math.min(left, right)) + 1);
        } else {
            forest[row][col] = Math.min(Math.min(up, down), Math.min(left, right)) + 1;
            queue.add(new Integer[]{row - 1, col}); // 上
            queue.add(new Integer[]{row + 1, col}); // 下
            queue.add(new Integer[]{row, col - 1}); // 左
            queue.add(new Integer[]{row, col + 1}); // 右
        }
        return queue;
    }

    // 二维数组深拷贝，用于传染模型,-1表示不能通过,0表示普通的树
    private int[][] copyForest(int[][] forest) {
        int[][] newForest = new int[forest.length][forest[0].length];
        for (int i = 0; i < forest.length; i++) {
            for (int j = 0; j < forest[0].length; j++) {
                if (forest[i][j] == 0) {
                    newForest[i][j] = -1;
                }
            }
        }
        return newForest;
    }

    // 将List<List<Integer>>变换成二维数组模式
    private int[][] getArrayForest(List<List<Integer>> forest) {
        int[][] arrayForest = new int[forest.size()][forest.get(0).size()];
        for (int i = 0; i < forest.size(); i++) {
            for (int j = 0; j < forest.get(0).size(); j++) {
                arrayForest[i][j] = forest.get(i).get(j);
            }
        }
        return arrayForest;
    }

    // 将全部树进行升序遍历，去除掉0和1
    private List<Integer> getNums(List<List<Integer>> forest) {
        List<Integer> list = new ArrayList<>();
        for (List<Integer> temp1 : forest) {
            for (Integer temp2 : temp1) {
                if (temp2 != 0 && temp2 != 1) {
                    list.add(temp2);
                }
            }
        }
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        return list;
    }

    // 给定一个树的高度，获取这个树的位置
    private int[] findTreeLocation(List<List<Integer>> forest, int high) {
        for (int row = 0; row < forest.size(); row++) {
            for (int col = 0; col < forest.get(row).size(); col++) {
                if (forest.get(row).get(col) == high) {
                    return new int[]{row, col};
                }
            }
        }
        return new int[]{0, 0};
    }


    @Test
    public void test1() {
        List<List<Integer>> forest = new ArrayList<>();
        ArrayList<Integer> arrayList1 = new ArrayList(Arrays.asList(new Integer[]{1, 2, 3}));
        forest.add(arrayList1);
        ArrayList<Integer> arrayList2 = new ArrayList(Arrays.asList(new Integer[]{0, 0, 4}));
        forest.add(arrayList2);
        ArrayList<Integer> arrayList3 = new ArrayList(Arrays.asList(new Integer[]{7, 6, 5}));
        forest.add(arrayList3);
        LeetCode_675 leetCode_675 = new LeetCode_675();
        Assert.assertEquals("test1 error", leetCode_675.cutOffTree(forest), 6);
    }

    @Test
    public void test2() {
        List<List<Integer>> forest = new ArrayList<>();
        ArrayList<Integer> arrayList1 = new ArrayList(Arrays.asList(new Integer[]{1, 2, 3}));
        forest.add(arrayList1);
        ArrayList<Integer> arrayList2 = new ArrayList(Arrays.asList(new Integer[]{0, 0, 0}));
        forest.add(arrayList2);
        ArrayList<Integer> arrayList3 = new ArrayList(Arrays.asList(new Integer[]{7, 6, 5}));
        forest.add(arrayList3);
        LeetCode_675 leetCode_675 = new LeetCode_675();
        Assert.assertEquals("test1 error", leetCode_675.cutOffTree(forest), -1);
    }

    @Test
    public void test3() {
        List<List<Integer>> forest = new ArrayList<>();
        ArrayList<Integer> arrayList1 = new ArrayList(Arrays.asList(new Integer[]{2, 3, 4}));
        forest.add(arrayList1);
        ArrayList<Integer> arrayList2 = new ArrayList(Arrays.asList(new Integer[]{0, 0, 5}));
        forest.add(arrayList2);
        ArrayList<Integer> arrayList3 = new ArrayList(Arrays.asList(new Integer[]{8, 7, 6}));
        forest.add(arrayList3);
        LeetCode_675 leetCode_675 = new LeetCode_675();
        Assert.assertEquals("test1 error", leetCode_675.cutOffTree(forest), 6);
    }

    @Test
    public void test4() {
        List<List<Integer>> forest = new ArrayList<>();
        ArrayList<Integer> arrayList1 = new ArrayList(Arrays.asList(new Integer[]{54581641, 64080174, 24346381, 69107959}));
        forest.add(arrayList1);
        ArrayList<Integer> arrayList2 = new ArrayList(Arrays.asList(new Integer[]{86374198, 61363882, 68783324, 79706116}));
        forest.add(arrayList2);
        ArrayList<Integer> arrayList3 = new ArrayList(Arrays.asList(new Integer[]{668150, 92178815, 89819108, 94701471}));
        forest.add(arrayList3);
        ArrayList<Integer> arrayList4 = new ArrayList(Arrays.asList(new Integer[]{83920491, 22724204, 46281641, 47531096}));
        forest.add(arrayList4);
        ArrayList<Integer> arrayList5 = new ArrayList(Arrays.asList(new Integer[]{89078499, 18904913, 25462145, 60813308}));
        forest.add(arrayList5);
        LeetCode_675 leetCode_675 = new LeetCode_675();
        Assert.assertEquals("test1 error", leetCode_675.cutOffTree(forest), 57);
    }

    @Test
    public void test5() {
        List<List<Integer>> forest = new ArrayList<>();
        ArrayList<Integer> arrayList1 = new ArrayList(Arrays.asList(new Integer[]{1, 3, 2}));
        forest.add(arrayList1);
        ArrayList<Integer> arrayList2 = new ArrayList(Arrays.asList(new Integer[]{0, 0, 4}));
        forest.add(arrayList2);
        ArrayList<Integer> arrayList3 = new ArrayList(Arrays.asList(new Integer[]{7, 6, 5}));
        forest.add(arrayList3);
        LeetCode_675 leetCode_675 = new LeetCode_675();
        Assert.assertEquals("test1 error", leetCode_675.cutOffTree(forest), 8);
    }

    @Test
    public void test6() {
        List<List<Integer>> forest = new ArrayList<>();
        ArrayList<Integer> arrayList1 = new ArrayList(Arrays.asList(new Integer[]{4, 6, 3}));
        forest.add(arrayList1);
        ArrayList<Integer> arrayList2 = new ArrayList(Arrays.asList(new Integer[]{8, 5, 7}));
        forest.add(arrayList2);
        ArrayList<Integer> arrayList3 = new ArrayList(Arrays.asList(new Integer[]{2, 10, 9}));
        forest.add(arrayList3);
        LeetCode_675 leetCode_675 = new LeetCode_675();
        Assert.assertEquals("test1 error", leetCode_675.cutOffTree(forest), 19);
    }


    @Test
    public void test7() {
        int[][] nums = {
                {6304, 8591, 1651, 4114, 407, 3998, 4382},
                {6614, 927, 235, 3358, 9086, 4986, 8284},
                {8505, 3117, 8012, 0, 5724, 3323, 6157},
                {8799, 3083, 8817, 5648, 3113, 8562, 8787},
                {2931, 4668, 4378, 3901, 8718, 9635, 41},
                {6223, 4425, 509, 0, 4855, 0, 0},
                {1685, 6117, 732, 9372, 9975, 6939, 6405},
                {4133, 9246, 4867, 0, 723, 9105, 9484},
                {2910, 2771, 8412, 2757, 8148, 7315, 5379}};
    }

    @Test
    public void test8() {
        List<List<Integer>> forest = new ArrayList<>();
        ArrayList<Integer> arrayList3 = new ArrayList(Arrays.asList(new Integer[]{15, 9, 5, 12, 14}));
        forest.add(arrayList3);
        ArrayList<Integer> arrayList4 = new ArrayList(Arrays.asList(new Integer[]{7, 6, 13, 17, 2}));
        forest.add(arrayList4);
        ArrayList<Integer> arrayList5 = new ArrayList(Arrays.asList(new Integer[]{3, 0, 8, 0, 0}));
        forest.add(arrayList5);
        ArrayList<Integer> arrayList6 = new ArrayList(Arrays.asList(new Integer[]{4, 16, 18, 11, 10}));
        forest.add(arrayList6);
        LeetCode_675 leetCode_675 = new LeetCode_675();
        Assert.assertEquals("test1 error", leetCode_675.cutOffTree(forest), 57);
    }

    @Test
    public void test9() {
        List<List<Integer>> forest = new ArrayList<>();
        ArrayList<Integer> arrayList3 = new ArrayList(Arrays.asList(new Integer[]{4, 2, 3}));
        forest.add(arrayList3);
        ArrayList<Integer> arrayList4 = new ArrayList(Arrays.asList(new Integer[]{0, 0, 1}));
        forest.add(arrayList4);
        ArrayList<Integer> arrayList5 = new ArrayList(Arrays.asList(new Integer[]{7, 6, 5}));
        forest.add(arrayList5);
        LeetCode_675 leetCode_675 = new LeetCode_675();
        Assert.assertEquals("test1 error", leetCode_675.cutOffTree(forest), 10);
    }

    @Test
    public void test10() {
        List<List<Integer>> forest = new ArrayList<>();
        ArrayList<Integer> arrayList3 = new ArrayList(Arrays.asList(new Integer[]{7, 0, 3299, 3212, 8228, 0, 1320}));
        forest.add(arrayList3);
        LeetCode_675 leetCode_675 = new LeetCode_675();
        Assert.assertEquals("test1 error", leetCode_675.cutOffTree(forest), -1);
    }

    @Test
    public void test11() {
        List<List<Integer>> forest = new ArrayList<>();
        ArrayList<Integer> arrayList1 = new ArrayList(Arrays.asList(new Integer[]{7}));
        forest.add(arrayList1);
        ArrayList<Integer> arrayList2 = new ArrayList(Arrays.asList(new Integer[]{0}));
        forest.add(arrayList2);
        ArrayList<Integer> arrayList3 = new ArrayList(Arrays.asList(new Integer[]{3299}));
        forest.add(arrayList3);
        ArrayList<Integer> arrayList4 = new ArrayList(Arrays.asList(new Integer[]{8228}));
        forest.add(arrayList4);
        ArrayList<Integer> arrayList5 = new ArrayList(Arrays.asList(new Integer[]{0}));
        forest.add(arrayList5);
        ArrayList<Integer> arrayList6 = new ArrayList(Arrays.asList(new Integer[]{1320}));
        forest.add(arrayList6);
        LeetCode_675 leetCode_675 = new LeetCode_675();
        Assert.assertEquals("test1 error", leetCode_675.cutOffTree(forest), -1);
    }
}






















