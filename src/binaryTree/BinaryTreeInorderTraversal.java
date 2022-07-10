package binaryTree;

import com.sun.source.tree.Tree;

import java.util.*;

/***
 * Leetcode 94
 * pop() -> add the node val to the results
 */
public class BinaryTreeInorderTraversal {
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();
        while(cur!=null || !stack.empty()){
            //left
            while(cur!=null){
                stack.push(cur);
                cur = cur.left;
            }
            //root and right
            if(!stack.empty()){
                cur = stack.pop();
                res.add(cur.val);
                cur = cur.right;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left=null;
        treeNode.right=new TreeNode(2);
        treeNode.right.left=new TreeNode(3);
        System.out.println(Arrays.toString(inorderTraversal(treeNode).toArray()));
    }

    public List<Integer> inorderTraversalRecursive(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        inorder(root,res);
        return res;
    }
    public void inorder(TreeNode node, List<Integer> res){
        if(node == null) return;
        if(node.left!=null)
            inorder(node.left,res);
        res.add(node.val);
        if(node.right!=null)
            inorder(node.right,res);
    }
}
