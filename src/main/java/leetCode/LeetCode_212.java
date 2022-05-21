package leetCode;

import java.util.*;

public class LeetCode_212 {
    public static void main(String[] args) {
        LeetCode_212 leetCode_212 = new LeetCode_212();
        char[][] board = {
                {'a', 'b', 'c'},
                {'a', 'e', 'd'},
                {'a', 'f', 'g'}};
        String[] words = {"abcdefg", "gfedcbaaa", "eaabcdgfa", "befa", "dgc", "ade"};
        List<String> resultList = leetCode_212.findWords(board, words);
        System.out.println(resultList);
    }

    /**
     * 回溯法，不断递归
     * 每一个节点，需要向上，向左，向下，向右进行延伸。并且延伸过去之后不能在返回，所以需要一个记录矩阵
     * 不能剪枝：有可能延伸到 abc满足条件了，但是不能剪枝，因为有可能后续还有 abcde 也满足题意
     * 可以剪枝：根据长度，如果长度超出了指定的阈值，可以进行剪枝
     *
     * @param board 二维图
     * @param words 字符
     * @return 返还
     */
    public List<String> findWords(char[][] board, String[] words) {
        Set<String> set = new HashSet<>();
        List<String> wordList = Arrays.asList(words);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int[][] recordBoard = new int[board.length][board[0].length];
                set.addAll(createWords(board, recordBoard, i, j, wordList, ""));
            }
        }
        return new ArrayList<>(set);
    }

    private Set<String> createWords(char[][] board, int[][] recordBoard, int i, int j, List<String> words, String word) {
        Set<String> set = new HashSet<>();
        String wordName = word + board[i][j];
        int[][] recordBoardNew = copyArrays(recordBoard);
        recordBoardNew[i][j] = 1;
        if (words.contains(wordName)) {
            set.add(wordName);
        }
        // 字符长度不会超过10，可以进行剪枝
        if (word.length() >= 10) {
            return set;
        }

        // 如果上侧没有到头
        if (!(i == 0 || recordBoardNew[i - 1][j] == 1)) {
            set.addAll(createWords(board, recordBoardNew, i - 1, j, words, wordName));
        }

        // 如果下侧没有到头
        if (!(i == recordBoardNew.length - 1 || recordBoardNew[i + 1][j] == 1)) {
            set.addAll(createWords(board, recordBoardNew, i + 1, j, words, wordName));
        }

        // 如果左侧没有到头
        if (!(j == 0 || recordBoardNew[i][j - 1] == 1)) {
            set.addAll(createWords(board, recordBoardNew, i, j - 1, words, wordName));
        }

        // 如果右侧没有到头
        if (!(j == recordBoardNew[0].length - 1 || recordBoardNew[i][j + 1] == 1)) {
            set.addAll(createWords(board, recordBoardNew, i, j + 1, words, wordName));
        }
        return set;
    }

    private int[][] copyArrays(int[][] arrays) {
        int[][] copy = new int[arrays.length][arrays[0].length];
        for (int i = 0; i < arrays.length; i++) {
            System.arraycopy(arrays[i], 0, copy[i], 0, arrays[0].length);
        }
        return copy;
    }
}
