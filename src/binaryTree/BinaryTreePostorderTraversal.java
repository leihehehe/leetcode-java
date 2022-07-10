package binaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostorderTraversal {
    //postorder traversal:-> right, left, root
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        TreeNode cur = root;
        TreeNode prev = null;
        while(cur!=null || !stack.empty()){
            while(cur!=null){
                stack.push(cur);
                cur=cur.left;
            }
            if(!stack.empty()){
                cur = stack.pop();
                if(cur.right!=null && prev!=cur.right){
                    stack.push(cur);
                    cur=cur.right;
                }else{
                    res.add(cur.val);
                    prev=cur;
                    cur=null;
                }
            }
        }
        return res;
    }
    public List<Integer> postorderTraversalRecursive(TreeNode root){
        List<Integer> res = new ArrayList<>();
        postorder(root,res);
        return  res;
    }
    public void postorder(TreeNode root, List<Integer> res){
        if(root==null) return;
        postorder(root.left,res);
        postorder(root.right,res);
        res.add(root.val);
    }
}
