package weeklyContest.binaryTree;
//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Medium
 * Weekly Contest 335
 */


class KthLargestLevelSum {
    public long kthLargestLevelSum(TreeNode root, int k) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        //从小到大
        PriorityQueue<Long> pq = new PriorityQueue<>(k, (a, b) -> a.compareTo(b));
        while (!queue.isEmpty()) {
            int sz = queue.size();
            long sum = 0;
            for (int i = 0; i < sz; i++) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            if (pq.size() < k) {
                pq.offer(sum);
            } else if (sum > pq.peek()) {
                //现在的第k大比现在的sum小，说明他以后不再是第k大
                //[2,5,7,8]
                pq.poll();
                pq.offer(sum);
            }

        }
        if (pq.size() < k) {
            return -1;
        }

        return pq.peek();
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
