package stackAndDeque;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/***
 * Leetcode 496
 */
public class NextGreaterElementI {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Deque<Integer> stack = new ArrayDeque<>();
        Map<Integer,Integer> store = new HashMap<>();
        int[] res = new int[nums1.length];
        for(int i =0;i<nums2.length;i++){
            while(!stack.isEmpty()&&stack.peekLast()<nums2[i]){
                store.put(stack.removeLast(),nums2[i]);
            }
            stack.addLast(nums2[i]);
        }
        for(int i=0;i<nums1.length;i++){
            res[i]= store.getOrDefault(nums1[i], -1);
        }
        return res;
    }
}
