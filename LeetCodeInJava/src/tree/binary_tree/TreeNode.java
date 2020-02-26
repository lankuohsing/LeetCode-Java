package tree.binary_tree;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

}

class Solution094 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> results = new ArrayList();
        while (root != null) {
            List<Integer> results1 = new ArrayList();
            results1 = inorderTraversal(root.left);
            results1.add(root.val);
            results = results1;
            results1 = inorderTraversal(root.right);
            results.addAll(results1);
            break;// must break, or it will be stuck in a infinite loop

        }
        return results;
    }
}
