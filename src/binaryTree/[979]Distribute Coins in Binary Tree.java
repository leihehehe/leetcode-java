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
class DistributeCoinsInBinaryTree {

    public int distributeCoins(TreeNode root) {
        getCoins(root);

        return res;
    }
    //记录的是操作数
    int res;
    //需要多少硬币来达到1(有正负，正数代表多出的硬币，负数代表缺少的硬币)
    public int getCoins(TreeNode root){
        if(root==null){
            return 0;
        }
        int left = getCoins(root.left);
        int right = getCoins(root.right);
        //这里res把解决左右子树硬币不平衡所需的步骤数加进来，当到整个数的root节点的时候，也就平衡了，不需要加节点自身需要移除的硬币，因为根据题意，整个数的节点value是等于节点个数的，意思就是每个节点一定能被凑成精确的1个硬币, 所以轮到根节点的时候，他应该已经凑成1了，不需要任何操作
        res+= Math.abs(left)+Math.abs(right);
        return root.val-1+left+right;

    }

}
//leetcode submit region end(Prohibit modification and deletion)
