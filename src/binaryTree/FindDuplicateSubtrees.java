package binaryTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Leetcode 652
 */
public class FindDuplicateSubtrees {
    Map<String,Integer> store = new HashMap<>();
    List<TreeNode> res = new ArrayList<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        serialize(root);
        return res;
    }
    public String serialize(TreeNode root){
        if(root==null) return "#";
        String left = serialize(root.left);
        String right = serialize(root.right);
        String cur = root.val+","+left+","+right;
        if(store.containsKey(cur)){
            if(store.get(cur)==1) {
                res.add(root);
                store.put(cur,2);
            }
        }else{
            store.put(cur,1);
        }
        return cur;
    }
}
