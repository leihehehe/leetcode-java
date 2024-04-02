package binaryTree;
//leetcode submit region begin(Prohibit modification and deletion)

import binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class AllPossibleFBT {
    public List<TreeNode> allPossibleFBT(int n) {
        List<TreeNode> res = new ArrayList<>();
        if (n % 2 == 0) { // 完全二叉树的节点数必须是奇数
            return res;
        }
        if(n==1){
            res.add(new TreeNode(0));
            return res;
        }

        // 递归构造所有可能的左右子树
        for (int i = 1; i < n; i += 2) {
            List<TreeNode> leftTrees = allPossibleFBT(i);
            List<TreeNode> rightTrees = allPossibleFBT(n - i - 1);
            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {
                    TreeNode root = new TreeNode(0);  // 创建新的根节点
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
