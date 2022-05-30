package binaryTree;

/***
 * DFS: pre-order, inorder, post-order
 */
public class RecursiveTree {
    public static void traverseTree(TreeNode treeNode){
        if(treeNode==null) {
            return;
        }
            System.out.println(treeNode.val);
            traverseTree(treeNode.left);
            traverseTree(treeNode.right);

    }

    /***
     * pre-order traverse tree
     * "pre-order" means in front of "left" and "right"
     * root - left - right
     * @param root
     */
    public static void preOrderTraverse(TreeNode root){
        if(root==null) {
            return;
        }
        System.out.println(root.val);
        traverseTree(root.left);
        traverseTree(root.right);
    }

    /***
     * in-order traverse tree
     * "pre-order" means between "left" and "right"
     * left - root - right
     * @param root
     */
    public static void inOrderTraverse(TreeNode root){
        if(root==null){
            return;
        }
        inOrderTraverse(root.left);
        System.out.println(root.val);
        inOrderTraverse(root.right);

    }

    /***
     * post-order traverse
    * "pre-order" means in front of "left" and "right"
     * left - right - root
     * @param root
     */
    public static void postOrderTraverse(TreeNode root){
        if(root==null){
            return;
        }
        postOrderTraverse(root.left);
        postOrderTraverse(root.right);
        System.out.println(root.val);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left=null;
        root.right=new TreeNode(2);
        root.right.left=new TreeNode(3);
        postOrderTraverse(root);
    }
}
