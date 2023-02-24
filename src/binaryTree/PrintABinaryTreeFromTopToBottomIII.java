package binaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * leetcode offer 32
 */
public class PrintABinaryTreeFromTopToBottomIII {
    /**
     * Time: O(N)
     * Space: O(N)
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null) return res;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int layer = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> curLevel = new ArrayList<>();
            for(int i =0;i<size;i++){
                TreeNode cur = queue.poll();
                if(layer%2==0){
                    curLevel.add(cur.val);
                }else curLevel.add(0,cur.val);
                if(cur.left!=null) queue.offer(cur.left);
                if(cur.right!=null) queue.offer(cur.right);
            }
            res.add(curLevel);
            layer++;
        }
        return res;
    }
}
