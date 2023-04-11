package binaryTree;
//leetcode submit region begin(Prohibit modification and deletion)
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
class PseudoPalindromicPathsInABinaryTree {
    private int[] path = new int[10];
    private int res = 0;
    public int pseudoPalindromicPaths (TreeNode root) {
        traverse(root);
        return  res;
    }

    public void traverse(TreeNode root){
        if(root==null) return;
        path[root.val]++;
        if(root.left==null && root.right==null){
            int oddCount = 0;
            for(int count:path){
                if(count%2!=0) oddCount++;
            }
            if(oddCount<=1) res++;
            path[root.val]--;
            return;
        }
        traverse(root.left);
        traverse(root.right);
        path[root.val]--;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
