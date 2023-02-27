package binaryTree;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/***
 * Leetcode 149
 * Preorder traversal -> push the node then add it to the result
 */
public class BinaryTreePreorderTraversal {

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        if(root==null) return results;
        Stack<TreeNode> stack = new Stack<>();
        //Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        //when it comes to the last node, stack will be empty
        while(!stack.empty()){
            TreeNode cur = stack.pop();
            results.add(cur.val);
            if(cur.right!=null)
                stack.push(cur.right);
            if(cur.left!=null)
                stack.push(cur.left);
        }

        return results;
    }

    /***
     * Stack
     * @param root
     * @return
     */
    public static List<Integer> preorderTraversalRecursive(TreeNode root){
        List<Integer> arr = new ArrayList<Integer>();
        preorder(root,arr);
        return arr;
    }
    public static void preorder(TreeNode root, List<Integer> arr){
        if(root==null) return;
        arr.add(root.val);
        preorder(root.left,arr);
        preorder(root.right,arr);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left=null;
        treeNode.right=new TreeNode(2);
        treeNode.right.left=new TreeNode(3);
        System.out.println(Arrays.toString(preorderTraversal(treeNode).toArray()));
    }
}
