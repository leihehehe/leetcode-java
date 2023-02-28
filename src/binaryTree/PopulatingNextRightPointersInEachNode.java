package binaryTree;

/**
 * Leetcode 116
 */

// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
public class PopulatingNextRightPointersInEachNode {
    /**
     * Method 1
     * @param root
     * @return
     */
    public Node connect(Node root) {
        if(root==null) return null;
        traverse1(root);
        return root;
    }
    public void traverse1(Node node){
        if(node==null) return;
        if(node.left==null) return;
        node.left.next = node.right;
        node.right.next = node.next!=null?node.next.left:null;
        traverse1(node.left);
        traverse1(node.right);
    }

    /**
     * Method 2
     * @param root
     * @return
     */
    public Node connectMethod2(Node root) {
        if(root==null) return null;
        traverse2(root.left,root.right);
        return root;
    }
    public void traverse2(Node node1, Node node2){
        if(node1==null || node2==null) return;
        node1.next = node2;
        traverse2(node1.left,node1.right);
        traverse2(node2.left,node2.right);
        traverse2(node1.right,node2.left);
    }
}
