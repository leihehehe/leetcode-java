package binaryTree;
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
class SmallestStringStartingFromLeaf {
    private String res = null;
    public String smallestFromLeaf(TreeNode root) {
        traverse(root);
        return res;
    }
    private StringBuilder path = new StringBuilder();
    public void traverse(TreeNode root){
        if(root==null) return;
        path.append((char)('a'+root.val));
        if(root.left==null && root.right==null){
            path.reverse();
            String s = path.toString();
            if(res==null || res.compareTo(s)>0)
                res = s;
            path.reverse();
            path.deleteCharAt(path.length()-1);
            return;
        }
        traverse(root.left);
        traverse(root.right);
        path.deleteCharAt(path.length()-1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
