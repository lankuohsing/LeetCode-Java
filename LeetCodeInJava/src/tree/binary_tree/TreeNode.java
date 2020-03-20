package tree.binary_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

}

/*
 * 二叉树的中序遍历
 */
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

/*
 * 二叉树的层次遍历
 */
class Solution102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levels = new LinkedList<List<Integer>>();
        int depth = 0;
        getLevels(root, depth, levels);
        return levels;
    }

    // 广度优先遍历
    public void getLevels(TreeNode root, int depth, List<List<Integer>> levels) {
        if (root != null) {
            if (levels.size() == depth) {
                levels.add(new LinkedList<Integer>());

            }
            levels.get(depth).add(root.val);

            getLevels(root.left, depth + 1, levels);

            getLevels(root.right, depth + 1, levels);

        }

    }
}

/*
 * 翻转二叉树
 */
class Solution226 {
    public TreeNode invertTree(TreeNode root) {
        TreeNode root1 = root;
        invertTreeNotRecursive(root1);
        return root1;
    }

    public void invertTreeRecursive(TreeNode root) {
        if (root != null) {
            TreeNode tempNode = root.left;
            root.left = root.right;
            root.right = tempNode;
            invertTreeRecursive(root.left);
            invertTreeRecursive(root.right);
        }
    }

    public void invertTreeNotRecursive(TreeNode root) {
        Stack<TreeNode> stack1 = new Stack<TreeNode>();
        while (true) {
            while (root != null) {
                TreeNode tempNode = root.left;
                root.left = root.right;
                root.right = tempNode;
                stack1.push(root);
                root = root.left;
            }
            if (stack1.isEmpty()) {
                break;
            }
            root = stack1.pop();
            root = root.right;

        }
    }
}
