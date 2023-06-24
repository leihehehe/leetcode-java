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
class ConvertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        return constructTreeNode(nums, 0, nums.length-1);
    }

    public TreeNode constructTreeNode(int[] nums, int start, int end){
        if(start>end)
            return null;
        int mid = start+(end-start)/2;
        TreeNode root = new TreeNode(nums[mid]);
        TreeNode left = constructTreeNode(nums,start,mid-1);
        TreeNode right = constructTreeNode(nums,mid+1,end);
        root.left = left;
        root.right = right;
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
