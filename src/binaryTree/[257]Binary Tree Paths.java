package binaryTree;//leetcode submit region begin(Prohibit modification and deletion)


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class BinaryTreePaths {
    List<String> res = new ArrayList<>();
    LinkedList<String> path = new LinkedList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        traverse(root);
        return res;
    }

    public void traverse(TreeNode root) {
        if (root == null) return;
        path.addLast(root.val + "");
        if (root.left == null && root.right == null) {
            res.add(String.join("->", path));
            path.removeLast();
            return;
        }
        traverse(root.left);
        traverse(root.right);
        path.removeLast();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
