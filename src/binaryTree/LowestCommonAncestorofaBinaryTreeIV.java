package binaryTree;

import java.util.HashSet;

/**
 * Leetcode 1676
 */
public class LowestCommonAncestorofaBinaryTreeIV {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        HashSet<Integer> values = new HashSet<>();
        for(int i = 0;i<nodes.length;i++) values.add(nodes[i].val);
        return findDescendent(root,values);
    }

    public TreeNode findDescendent(TreeNode root, HashSet<Integer> nodes){
        if(root==null) return null;
        if(nodes.contains(root.val)) return root;
        TreeNode left = findDescendent(root.left,nodes);
        TreeNode right = findDescendent(root.right,nodes);
        if(left!=null && right!=null) return root;
        return left!=null?left:right;
    }
}
