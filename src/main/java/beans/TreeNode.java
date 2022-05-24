package beans;

public class TreeNode {
    public Integer val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(Integer num) {
        this.val = num;
    }

    public TreeNode(Integer num, TreeNode left, TreeNode right) {
        this.val = num;
        this.left = left;
        this.right = right;
    }
}
