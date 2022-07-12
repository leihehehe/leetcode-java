package binaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/***
 * Leetcode 102
 */
public class BinaryTreeLevelOrderTraversal {
    /***
     * Method 1: dfs recursion
     */
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        //dfs
        if(root==null) return result;
        dfs(root,0);
        return result;
    }

    public void dfs(TreeNode node, int level){
        //result.size 1 -> level 0
        if(result.size()==level)
            result.add(new ArrayList<Integer>());
        if(node==null) return;
        result.get(level).add(node.val);
        if(node.left!=null)
            dfs(node.left,level+1);
        if(node.right!=null)
            dfs(node.right,level+1);
    }

    /***
     * Method 2: bfs iteration
     */

    public List<List<Integer>> levelOrderBFS(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null) return res;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for(int i =0;i<size;i++){
                TreeNode cur = queue.poll();
                level.add(cur.val);
                if(cur.left!=null)
                    queue.add(cur.left);
                if(cur.right!=null)
                    queue.add(cur.right);
            }
            res.add(level);
        }
        return res;
    }
}
