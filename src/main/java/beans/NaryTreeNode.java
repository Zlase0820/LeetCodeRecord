package beans;

import java.util.ArrayList;
import java.util.List;

public class NaryTreeNode {
    public int num;
    public List<NaryTreeNode> child;

    public NaryTreeNode() {
        this.child = new ArrayList<>();
    }

    public NaryTreeNode(int num) {
        this.num = num;
        this.child = new ArrayList<>();
    }

    public NaryTreeNode(int num, List<NaryTreeNode> list) {
        this.num = num;
        this.child = list;
    }
}
