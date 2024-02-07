package weeklyContest.binaryTree;
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

import binaryTree.TreeNode;

import java.util.ArrayDeque;
/**
 * Medium
 * 双周赛 102
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class CousinsInBinaryTreeII {
    public TreeNode replaceValueInTree(TreeNode root) {
        //BFS
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        root.val = 0;
        queue.addFirst(root);
        while(!queue.isEmpty()){
            int sum = 0;
            int size =  queue.size();
            for(int i = 0;i<size;i++){
                //这里我们想要的是单纯的遍历，而不是pop
                TreeNode node = queue.removeFirst();
                if(node.left!=null){
                    sum+=node.left.val;
                }
                if(node.right!=null){
                    sum+=node.right.val;
                }
                queue.addLast(node);
            }

            for(int i = 0;i<size;i++){
                //下面再开始pop
                TreeNode node = queue.removeFirst();
                int left = node.left!=null?node.left.val:0;
                int right = node.right!=null?node.right.val:0;

                if(node.left!=null){
                    node.left.val = sum - left- right;
                    queue.addLast(node.left);
                }
                if(node.right!=null){
                    node.right.val = sum - left - right;
                    queue.addLast(node.right);
                }

            }
        }
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
