package beans;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int num) {
        this.val = num;
    }

    public TreeNode(int num, TreeNode left, TreeNode right) {
        this.val = num;
        this.left = left;
        this.right = right;
    }
}
