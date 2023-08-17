package binaryTree;
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/

import java.util.ArrayList;

class ConvertBinarySearchTreeToSortedDoublyLinkedList {
    ArrayList<Node> list = new ArrayList<>();
    public Node treeToDoublyList(Node root) {
        if(root==null) return root;
        dfs(root);
        for(int i = 0;i<list.size();i++){
            Node cur = list.get(i);
            Node next = list.get((i+1)%list.size());
            cur.right = next;
            next.left = cur;
        }
        return list.get(0);
    }
    public void dfs(Node root){
        if(root==null) return;
        dfs(root.left);
        list.add(root);
        dfs(root.right);
    }
}
