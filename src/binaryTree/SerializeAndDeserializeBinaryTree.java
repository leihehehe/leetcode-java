package binaryTree;

import java.util.LinkedList;

/**
 * Leetcode 297
 */
public class SerializeAndDeserializeBinaryTree {
    private String SEP = ",";
    private String NULL = "#";
    private StringBuilder sb= new StringBuilder();
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        traverse(root);
        return sb.toString();
    }

    private void traverse(TreeNode root){
        if(root==null){
            sb.append(NULL).append(SEP);
            return;
        }
        sb.append(root.val).append(SEP);
        traverse(root.left);
        traverse(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        LinkedList<String> nodes = new LinkedList<>();
        for (String s : data.split(SEP)) nodes.addLast(s);
        return build(nodes);
    }

    private TreeNode build(LinkedList<String> nodes){
        if(nodes.isEmpty()) return null;
        String first = nodes.removeFirst();
        if(first.equals(NULL)) return null;
        TreeNode root = new TreeNode(Integer.parseInt(first));

        root.left =  build(nodes);
        root.right =  build(nodes);
        return root;
    }
}
