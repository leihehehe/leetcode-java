package Search;

import binaryTree.TreeNode;

public class DFS {
    public static void dfs(TreeNode node){
        if(node==null) return;
        System.out.println(node.val);
        dfs(node.left);
        dfs(node.right);
    }

    /***
     *                 1
     *             4      2
     *                  3  5
     * @param args
     */
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left=new TreeNode(4);
        treeNode.right=new TreeNode(2);
        treeNode.right.left=new TreeNode(3);
        treeNode.right.right=new TreeNode(5);
        dfs(treeNode);
    }
}
