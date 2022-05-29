package binaryTree;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/***
 * Leetcode 149
 */
public class BinaryTreePreorderTraversal {

    public static List<Integer> preorderTraversal(TreeNode root) {
        TreeNode curNode=root;
        List<Integer> results = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        //when it comes to the last node, stack will be empty, and curNode(right) will be null
        while(curNode!=null || stack.size()!=0){
            while(curNode!=null){
                stack.push(curNode);
                results.add(curNode.val);
                curNode=curNode.left;
            }
            curNode=stack.pop();
            curNode=curNode.right;
        }

        return results;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left=null;
        treeNode.right=new TreeNode(2);
        treeNode.right.left=new TreeNode(3);
        System.out.println(Arrays.toString(preorderTraversal(treeNode).toArray()));
    }
}
