package tree.binary_tree;

import java.util.ArrayList;
import java.util.LinkedList;
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

/*
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。 输出: ["1->2->5", "1->3"]
 * 
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 * https://leetcode-cn.com/problems/binary-tree-paths/
 */
class Solution257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new LinkedList<String>();
        String path = "";
        constructPaths(root, path, paths);
        return paths;
    }

    // 深度优先遍历
    public void constructPaths(TreeNode root, String path, List<String> paths) {
        if (root != null) {
            path += Integer.toString(root.val);
            if (root.left == null && root.right == null) {
                paths.add(path);
                return;
            } else {
                path += "->";
                constructPaths(root.left, path, paths);
                constructPaths(root.right, path, paths);
            }
        }

    }
}
