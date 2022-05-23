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

        // 起始位置直接砍掉
        forest.get(0).set(0, 1);
        List<Integer> trees = getNums(forest);

        // 如果trees为空，说明没有树，可以直接返还完成，为0
        if (trees.size() == 0) {
            return 0;
        }

        // 正常行走
        int step = 0;
        int tempStep;
        int[] fromLocation = {0, 0};
        int[] toLocation;
        int[][] arrayForest = getArrayForest(forest);
        for (int i = 1; i < trees.size(); i++) {
            toLocation = findTreeLocation(forest, trees.get(i));
            System.out.println("from:" + fromLocation[0] + "," + fromLocation[1] + " to " + toLocation[0] + "," + toLocation[1]);
            tempStep = goStep(arrayForest, fromLocation, toLocation) - 1;
            System.out.println("step:" + tempStep + "  count: " + i);
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

    // goStep 利用传染模型即可
    private int goStep(int[][] arrayForest, int[] fromLocation, int[] toLocation) {
        int[][] forest = copyForest(arrayForest);
        int row = fromLocation[0];
        int col = fromLocation[1];
        forest[row][col] = 1;
        recursion(forest, row - 1, col); // 上
        recursion(forest, row + 1, col); // 下
        recursion(forest, row, col - 1); // 左
        recursion(forest, row, col + 1); // 右
        return forest[toLocation[0]][toLocation[1]];
    }

    // 传染模型，重新赋值forest
    private void recursion(int[][] forest, int row, int col) {
        // 超过边界
        if (row < 0 || row >= forest.length || col < 0 || col >= forest[0].length) {
            return;
        }

        // 如果直接在沼泽，就返还
        if (forest[row][col] == -1) {
            return;
        }

        // 如果已经被遍历过则直接跳过
        if (forest[row][col] > 0) {
            return;
        }

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
            up = forest[row][col - 1];
        }
        if (col + 1 < forest[0].length && forest[row][col + 1] > 0) {
            up = forest[row][col + 1];
        }

        // 赋值
        forest[row][col] = Math.min(Math.min(up, down), Math.min(left, right)) + 1;

        // 递归
        recursion(forest, row - 1, col); // 上
        recursion(forest, row + 1, col); // 下
        recursion(forest, row, col - 1); // 左
        recursion(forest, row, col + 1); // 右
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

    // 将全部树进行升序遍历
    private List<Integer> getNums(List<List<Integer>> forest) {
        List<Integer> list = new ArrayList<>();
        for (List<Integer> temp1 : forest) {
            for (Integer temp2 : temp1) {
                if (temp2 != 0) {
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

}
