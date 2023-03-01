package binaryTree;

import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode 105
 */
public class ConstructBinaryTreeFromPreOrderAndInorder {
    Map<Integer,Integer> indexes;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //preorder = [3, 9, 20, 15, 7]
        //          root l   r
        //inoder = [9,3,15,20,7]
        //         l root r
        indexes =  new HashMap<>();
        for (int i = 0; i < inorder.length; i++) indexes.put(inorder[i], i);
        return construct(preorder,inorder,0,preorder.length-1,0,inorder.length-1);
    }

    public TreeNode construct(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd){
        if(preStart>preEnd || inStart> inEnd) return null;
        //select root value
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);
        //get root index in inorder[] array
        int rootIndex = indexes.get(rootVal);
        int leftTreeSize = rootIndex-inStart;
        //left tree
        TreeNode l = construct(preorder,inorder,preStart+1,preStart+leftTreeSize,inStart,rootIndex-1);
        //right tree
        TreeNode r =construct(preorder,inorder,preStart+leftTreeSize+1,preEnd,rootIndex+1,inEnd);
        root.left = l;
        root.right = r;
        return root;
    }
}
