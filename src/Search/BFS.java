package Search;

import binaryTree.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

public class BFS {
    public static void bfs(TreeNode node){
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(node);
        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();
            if(cur.left!=null)
                queue.add(cur.left);
            if(cur.right!=null)
                queue.add(cur.right);
        }

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
        bfs(treeNode);
    }
}
