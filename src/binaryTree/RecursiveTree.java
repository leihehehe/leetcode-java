package binaryTree;

public class RecursiveTree {
    public static void traverseTree(TreeNode treeNode){
        if(treeNode!=null) {
            System.out.println(treeNode.val);
            traverseTree(treeNode.left);
            traverseTree(treeNode.right);
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left=null;
        treeNode.right=new TreeNode(2);
        treeNode.right.left=new TreeNode(3);
        traverseTree(treeNode);
    }
}
