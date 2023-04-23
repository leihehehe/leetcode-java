package binaryTree;
//leetcode submit region begin(Prohibit modification and deletion)


import java.util.HashMap;
import java.util.Map;

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
class ConstructBinaryTreeFromPreorderAndPostorderTraversal {
    Map<Integer,Integer> map = new HashMap<>();
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        for(int i = 0;i<postorder.length;i++){
            map.put(postorder[i],i);
        }
        return build(preorder,0, preorder.length-1,postorder,0, postorder.length-1);
    }

    public TreeNode build(int[] preorder, int preStart, int preEnd, int[] postorder, int postStart, int postEnd){
        if(preStart>preEnd) return null;
        if(preStart==preEnd) return  new TreeNode(preorder[preStart]);
        int rootVal = preorder[preStart];
        int leftVal = preorder[preStart+1];
        int index = map.get(leftVal);
        int leftSize = index-preStart+1;
        TreeNode root = new TreeNode(rootVal);
        root.left = build(preorder,preStart+1,preStart+leftSize,postorder,postStart,index);
        root.right = build(preorder,preStart+leftSize+1,preEnd,postorder,index+1,preEnd-1);
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
