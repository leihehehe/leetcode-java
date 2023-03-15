package binaryTree;

/**
 * Leetcode 1650
 */
public class LowestCommonAncestorOfABinaryTreeIII {
    public Node lowestCommonAncestor(Node p, Node q) {
        Node node1 = p;
        int lenP = 0,lenQ=0;
        while(node1!=null){
            lenP++;
            node1=node1.parent;
        }
        Node node2 = q;
        while(node2!=null){
            lenQ++;
            node2=node2.parent;
        }
        node1=p;
        node2=q;
        if(lenP>lenQ){
            int diff = lenP- lenQ;
            for(int i =0;i<diff;i++) node1 = node1.parent;
        }else{
            int diff = lenQ- lenP;
            for(int i =0;i<diff;i++) node2 = node2.parent;
        }

        while(node1!=node2){
            node1=node1.parent;
            node2=node2.parent;
        }
        return node1;
    }
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;
    };
}
