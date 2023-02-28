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

    private int count;
    /**
     * Method 2: recursive method
     * Time complexity: O(logN^2)
     * Time complexity: O(logN)
     * @param root
     * @return
     */
    public int countNodesMethod2(TreeNode root) {
        recursive(root);
        return count;

    }

    public void recursive(TreeNode curNode) {
        if (curNode == null) {
            return;
        }
        int h1=0, h2=0;
        TreeNode node = curNode;
        //logN
        while(node!=null){
            node = node.left;
            h1++;
        }
        node = curNode;
        //logN
        while(node!=null){
            node = node.right;
            h2++;
        }
        if(h1==h2){
            count+=(int)Math.pow(2,h1)-1;
        }else{
            count++;
            //logN
            recursive(curNode.left);
            recursive(curNode.right);
        }
    }
}
