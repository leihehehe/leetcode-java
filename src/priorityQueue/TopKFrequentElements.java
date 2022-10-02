package priorityQueue;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/***
 * Leetcode 347 Top K Frequent Elements
 */
public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> occurrences = new HashMap<>();
        for (int num : nums) {
            occurrences.put(num, occurrences.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] m, int[] n) {
                return m[1] - n[1];
            }
        });
        for (Map.Entry<Integer, Integer> cur : occurrences.entrySet()) {
            int num = cur.getKey(), count = cur.getValue();
            if (queue.size() == k) {
                if (count > queue.peek()[1]) {
                    queue.poll();
                    queue.offer(new int[]{num, count});
                }
            } else {
                queue.offer(new int[]{num, count});
            }
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = queue.poll()[0];
        }
        return result;
    }
}
