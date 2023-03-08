package binaryTree;

import java.util.LinkedList;
import java.util.List;

/**
 * leetcode 95
 */
public class UniqueBinarySearchTreesII {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new LinkedList<>();

        return build(1,n);
    }
    List<TreeNode> build(int l, int r) {
        List<TreeNode> res = new LinkedList<>();
        if(l>r){
            res.add(null);
            return res;
        }
        for(int i = l; i <= r; i++) {
            List<TreeNode> leftTree = build(l,i-1);
            List<TreeNode> rightTree = build(i+1,r);
            for (TreeNode left : leftTree) {
                for (TreeNode right : rightTree) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            }
        }

        return res;
    }
}
