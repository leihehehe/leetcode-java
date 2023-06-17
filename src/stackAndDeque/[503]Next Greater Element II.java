package stackAndDeque;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

//leetcode submit region begin(Prohibit modification and deletion)
class NextGreaterElementII {
    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        Arrays.fill(res,-1);
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i =0;i<2*nums.length;i++){
            int index = i%nums.length;
            int num = nums[index];
            while(!stack.isEmpty() && num>nums[stack.peek()]){
                int lastIndex = stack.pop();
                res[lastIndex] = nums[index];
            }
            stack.push(index);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
