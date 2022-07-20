package binaryTree;

import java.util.HashMap;
import java.util.Map;

/***
 * Leetcode 106
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    private int[] inorder;
    private int[] postorder;
    private int postIndex;
    Map<Integer,Integer> storeMap = new HashMap<Integer,Integer>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inorder=inorder;
        this.postorder=postorder;
        //put inorder<node,index> into a map
        for(int i = 0;i<inorder.length;i++){
            storeMap.put(inorder[i],i);
        }
        postIndex=postorder.length-1;
        return build(0,inorder.length-1);
    }
    public TreeNode build(int leftIndex, int rightIndex){
        if(leftIndex>rightIndex) return null;
        int rootVal = postorder[postIndex];
        TreeNode root = new TreeNode(rootVal);
        int inRootIndex = storeMap.get(rootVal);
        postIndex--;
        //build right tree first, cuz we are using the postorder traversal(right root would be accessed first when we access the node from the most right position)
        root.right = build(inRootIndex+1,rightIndex);
        root.left = build(leftIndex,inRootIndex-1);
        return root;
    }
}
