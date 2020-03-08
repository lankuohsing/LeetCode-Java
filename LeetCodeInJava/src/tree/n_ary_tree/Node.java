package tree.n_ary_tree;

import java.util.ArrayList;
import java.util.List;

public class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}

class Solution559 {
    public int maxDepth(Node root) {
        List<Integer> maxDepth = new ArrayList<Integer>();
        maxDepth.add(0);
        List<Integer> depth = new ArrayList<Integer>();
        depth.add(0);
        dfs(maxDepth, depth, root);
        return maxDepth.get(0);
    }

    public void dfs(List<Integer> maxDepth, List<Integer> depth, Node root) {
        if (root != null) {
            depth.set(0, depth.get(0) + 1);
            if (root.children == null || root.children.size() == 0) {
                maxDepth.set(0, depth.get(0) > maxDepth.get(0) ? depth.get(0) : maxDepth.get(0));
            } else {
                for (Node child : root.children) {
                    List<Integer> depth1 = new ArrayList<Integer>(depth);
                    dfs(maxDepth, depth1, child);
                }
            }
        }
    }
}
