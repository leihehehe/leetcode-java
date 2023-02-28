package binaryTree;

/**
 * Leetcode 222
 */
public class CountCompleteTreeNodes {
    /**
     * Method 1: recursive method
     * Time complexity: O(logN^2)
     * Time complexity: O(logN)
     * @param root
     * @return
     */
    public int countNodes(TreeNode root) {
        if(root==null) return 0;
        int h0 = 0, h1 = 0;
        TreeNode cur = root;
        while(cur!=null){
            h0++;
            cur= cur.left;
        }
        cur = root;
        while(cur!=null){
            h1++;
            cur= cur.right;
        }
        if(h0==h1) return (int)Math.pow(2,h0)-1;
        return 1+countNodes(root.left)+countNodes(root.right);
    }
}
