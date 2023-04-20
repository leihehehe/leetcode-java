package binaryTree;
//leetcode submit region begin(Prohibit modification and deletion)

import java.util.HashSet;

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
class FindElementsInAContaminatedBinaryTree {
    HashSet<Integer> set = new HashSet<>();
    public FindElementsInAContaminatedBinaryTree(TreeNode root) {
        recover(root,0);
    }
    public void recover(TreeNode root, int value){
        if(root==null) return;
        root.val = value;
        set.add(root.val);
        recover(root.left,root.val*2+1);
        recover(root.right,root.val*2+2);
    }
    
    public boolean find(int target) {
        return set.contains(target);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */
//leetcode submit region end(Prohibit modification and deletion)
