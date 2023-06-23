package binaryTree;

import java.util.HashMap;
import java.util.Map;

/***
 * Leetcode 106
 */
class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    /**
     * Method 1
     */
    //inorder = [9,3,15,20,7]
    //           l ro   r
    //          pS ls      pE
    //postorder = [9,15,7,20,3]
    //             l r       ro
    //            pS         pE
    Map<Integer,Integer> indexes = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for(int i =0;i<inorder.length;i++){
            indexes.put(inorder[i],i);
        }
        return build(inorder,0,inorder.length-1,postorder,0,postorder.length-1);
    }

    public TreeNode build(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd){
        if(inStart>inEnd) return null;
        int val = postorder[postEnd];
        TreeNode root = new TreeNode(val);
        //index in inorder
        int index = indexes.get(val);
        int leftSize = index-inStart;
        root.left = build(inorder,inStart,index-1,postorder,postStart,postStart+leftSize-1);
        root.right = build(inorder,index+1,inEnd,postorder,postStart+leftSize,postEnd-1);
        return root;
    }

    /**
     * Method 2
     */
    private int[] inorder;
    private int[] postorder;
    private int postIndex;
    Map<Integer,Integer> storeMap = new HashMap<Integer,Integer>();
    public TreeNode buildTreeMethod2(int[] inorder, int[] postorder) {
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
