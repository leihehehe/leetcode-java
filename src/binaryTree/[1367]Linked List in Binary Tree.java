package binaryTree;
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

import linkedList.ListNode;

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
class LinkedListInBinaryTree {
    public boolean isSubPath(ListNode head, TreeNode root) {
        if(head==null) return true;
        if(root==null) return false;
        if(check(head,root)) return true;
        return isSubPath(head,root.left) || isSubPath(head,root.right);
    }

    public boolean check(ListNode head, TreeNode root){
        if(head==null) return true;
        if(root==null) return false;
        if(head.val==root.val) return check(head.next,root.left) || check(head.next,root.right);
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
