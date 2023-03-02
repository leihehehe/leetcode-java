package binaryTree;

/**
 * Leetcode 450
 */
public class DeleteNodeInaBST {
    public TreeNode deleteNode(TreeNode root, int key) {

        return delete(root,key);
    }

    /**
     * Version 1
     * @param root
     * @param key
     * @return
     */
    public TreeNode delete(TreeNode root, int key){
        if(root==null) return null;
        if(root.val==key){
            if(root.left == null) return root.right;
            if(root.right== null) return root.left;
            TreeNode minNode = root.right;
            while(minNode.left!=null) minNode = minNode.left;
            minNode.left = root.left;
            return root.right;
        }else if(key<root.val) root.left= delete(root.left,key);
        else if(key>root.val)  root.right=delete(root.right,key);
        return root;
    }

    /**
     * Version 2
     * @param root
     * @param key
     * @return
     */
    public TreeNode delete2(TreeNode root, int key){
        if(root==null) return null;
        if(root.val==key){
            //only right child
            if(root.left == null) return root.right;
            if(root.right== null) return root.left;
            TreeNode maxNode = root.left;
            while(maxNode.right!=null) maxNode = maxNode.right;
            maxNode.right = root.right;
            return root.left;
        }else if(key<root.val) root.left= delete(root.left,key);
        else if(key>root.val)  root.right=delete(root.right,key);
        return root;
    }
}
