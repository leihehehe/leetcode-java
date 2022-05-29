package binaryTree;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/***
 * Leetcode 94
 * pop() -> add the node val to the results
 */
public class BinaryTreeInorderTraversal {
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> results=new ArrayList<>();
        Stack<TreeNode> nodeStack = new Stack<>();
        TreeNode curNode=root;
        while (curNode!=null || nodeStack.size()!=0){
            //check left
            while (curNode!=null){
                nodeStack.push(curNode);
                curNode=curNode.left;
            }
            //check right
            curNode=nodeStack.pop();
            results.add(curNode.val);
            curNode=curNode.right;
        }
        return results;
    }
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left=null;
        treeNode.right=new TreeNode(2);
        treeNode.right.left=new TreeNode(3);
        System.out.println(Arrays.toString(inorderTraversal(treeNode).toArray()));
    }
}
