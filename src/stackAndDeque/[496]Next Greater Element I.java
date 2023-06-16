package stackAndDeque;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class NextGreaterElement {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Deque<Integer> stack = new ArrayDeque<>();
        Map<Integer,Integer> map = new HashMap<>();
        for(int i =0;i<nums2.length;i++){
            while(!stack.isEmpty() && nums2[stack.peek()] < nums2[i]){
                int last = stack.pop();
                map.put(nums2[last],nums2[i]);
            }
            stack.push(i);
        }
        int[] res = new int[nums1.length];
        for(int i = 0;i<nums1.length;i++){
            res[i] = map.getOrDefault(nums1[i],-1);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
