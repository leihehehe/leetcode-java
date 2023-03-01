package binaryTree;

/**
 * Leetcode 654
 */
public class MaximumBinaryTree {
    /**
     * Time Complexity: O(n^2)
     * Space Complexity: O(n)
     * @param nums
     * @return
     */
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(nums,0,nums.length-1);
    }
    public TreeNode construct(int[] nums,int start, int end){
        if(nums.length==0) return null;
        if(start>end) return null;
        int maxNum = Integer.MIN_VALUE;
        int rootIndex = -1;
        //find the max value in the nums[]
        for(int i =start;i<=end;i++){
            if(nums[i]>maxNum){
                rootIndex=i;
                maxNum = nums[i];
            }
        }
        TreeNode root = new TreeNode(maxNum);
        TreeNode left = construct(nums,start,rootIndex-1);
        TreeNode right = construct(nums,rootIndex+1,end);
        root.left = left;
        root.right = right;
        return root;
    }
}
