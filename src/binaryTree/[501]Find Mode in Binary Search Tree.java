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
class FindModeInBinarySearchTree {
    LinkedList<Integer> modes = new LinkedList<>();
    TreeNode prev;
    int maxCount = 0;
    int count = 1;
    public int[] findMode(TreeNode root) {

        traverse(root);
        int[] res = new int[modes.size()];
        for(int i = 0; i<res.length;i++){
            res[i] = modes.get(i);
        }
        return res;

    }

    public void traverse(TreeNode root){
        if(root==null){
            return;
        }
        traverse(root.left);
        if(prev!=null && prev.val==root.val){
            count++;
        }
        if(prev!=null && prev.val!=root.val){
            count = 1;
        }
        if(count>maxCount){
            modes.clear();
            modes.addLast(root.val);
            maxCount=count;
        } else if(count==maxCount){
            modes.addLast(root.val);
        }

        prev = root;
        traverse(root.right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
