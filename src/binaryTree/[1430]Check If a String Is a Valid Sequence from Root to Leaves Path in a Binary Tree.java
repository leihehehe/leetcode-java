package binaryTree;
//leetcode submit region begin(Prohibit modification and deletion)

import java.util.LinkedList;

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
class CheckStringValidSequence {
    LinkedList<Integer> path = new LinkedList<>();
    boolean valid = false;
    public boolean isValidSequence(TreeNode root, int[] arr) {
        traverse(root,arr,0);
        return valid;
    }
    public void traverse(TreeNode root, int[] arr, int index){
        if(root==null || valid) return;
        if(index>=arr.length || arr[index]!=root.val){
            return;
        }
        path.addLast(root.val);
        if(root.left==null && root.right==null){
            if(index==arr.length-1){
                valid = true;
                return;
            }
        }

        traverse(root.left,arr,index+1);
        traverse(root.right,arr,index+1);
        path.removeLast();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
