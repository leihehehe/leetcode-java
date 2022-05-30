package binaryTree;

/***
 * Lintcode 481
 */
public class BinaryTreeLeafSum {

    int sum=0;

    public int leafSum(TreeNode treeNode) {
        sum=0;
        traverseTree(treeNode);
        return sum;
    }

    private void traverseTree(TreeNode root){
        if(root==null){
            return;
        }
        if(root.left==null&&root.right==null){
            sum+=root.val;
        }
        traverseTree(root.left);
        traverseTree(root.right);
    }


}
