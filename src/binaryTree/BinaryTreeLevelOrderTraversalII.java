package binaryTree;

import java.util.*;

/**
 * Leetcode 107
 */
public class BinaryTreeLevelOrderTraversalII {
    /**
     * Time: O(N)
     * Space: O(N)
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null) return res;
        Deque<List<Integer>> resCover = new ArrayDeque<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> curLevel = new ArrayList<>();
            for(int i =0 ; i<size;i++){
                TreeNode curNode = queue.poll();
                curLevel.add(curNode.val);
                if(curNode.left!=null) queue.add(curNode.left);
                if(curNode.right!=null) queue.add(curNode.right);
            }
            resCover.push(curLevel);
        }
        while(!resCover.isEmpty()){
            res.add(resCover.pop());
        }

        return res;
    }
}
