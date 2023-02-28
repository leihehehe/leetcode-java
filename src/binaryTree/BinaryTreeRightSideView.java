package binaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Leetcode 199
 */
public class BinaryTreeRightSideView {
    /**
     * Method 1: bfs
     * Time complexity: O(N)
     * Space complexity: O(N)
     * @param root
     * @return
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root==null) return res;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0;i<size;i++){
                TreeNode cur = queue.poll();
                if(i==size-1) res.add(cur.val);
                if(cur.left!=null) queue.offer(cur.left);
                if(cur.right!=null) queue.offer(cur.right);
            }
        }
        return res;
    }

    /**
     * Method 2: dfs
     * Time complexity: O(N)
     * Space complexity: O(N)
     */
    private int depth=0;
    List<Integer> res = new ArrayList<>();
    public List<Integer> rightSideViewMethod2(TreeNode root) {
        dfs(root);
        return res;
    }
    public void dfs(TreeNode root){
        if(root==null) return;
        depth++;
        //if no node at the level has been visited, currnt node will be the one that we can see from the right side of the tree.
        if(res.size()<depth) res.add(root.val);
        dfs(root.right);
        dfs(root.left);
        depth--;
    }
}
