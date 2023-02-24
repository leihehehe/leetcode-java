package binaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

/**
 * Leetcode offer 32
 */
public class PrintABinaryTreeFromTopToBottom {
    /**
     * Time: O(N)
     * Space: O(N)
     * @param root
     * @return
     */
    public int[] levelOrder(TreeNode root) {
        if(root==null) return new int[0];
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        ArrayList<Integer> temp = new ArrayList<>();
        while(!queue.isEmpty()){
            TreeNode curNode = queue.poll();
            temp.add(curNode.val);
            if(curNode.left!=null) queue.add(curNode.left);
            if(curNode.right!=null) queue.add(curNode.right);
        }
        int size = temp.size();
        int[] res = new int[size];
        for(int i = 0;i<size;i++){
            res[i]=temp.get(i);
        }
        return res;
    }
}
