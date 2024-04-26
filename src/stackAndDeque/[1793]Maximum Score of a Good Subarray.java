package stackAndDeque;

import java.util.ArrayDeque;

//leetcode submit region begin(Prohibit modification and deletion)
class MaximumScoreSolution1 {
    public int maximumScore(int[] nums, int k) {
        int n = nums.length;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        //last smaller element
        int[] left = new int[n];
        for(int i = 0;i<n;i++){
            while(!stack.isEmpty() && nums[stack.peek()]>=nums[i]){
                stack.pop();
            }
            left[i]=stack.isEmpty()?-1:stack.peek();
            stack.push(i);
        }
        stack.clear();
        //from right to left: last smaller element
        int[] right = new int[n];
        for(int i = n-1;i>=0;i--){
            while(!stack.isEmpty() && nums[stack.peek()]>=nums[i]){
                stack.pop();
            }
            right[i]=stack.isEmpty()?n:stack.peek();
            stack.push(i);
        }
        int res = 0 ;
        for(int i = 0;i<n;i++){
            int l = left[i];
            int r = right[i];
            //l and r are the smaller elements, so k should be included
            if (l >= k || r <= k) {
                continue;
            }
            res = Math.max((r-l-1)* nums[i],res);
        }
        return res;
    }
}
class MaximumScoreSolution2 {
    public int maximumScore(int[] nums, int k) {
        int n = nums.length;
        int ans = nums[k], minH = nums[k];
        int l = k, r = k;
        for (int i = 0; i < n - 1; i++) { // 循环 n-1 次
            //移动左边的情况是要么左边面积更大，要么r移动不了了
            if (r == n - 1 || l > 0 && nums[l - 1] > nums[r + 1]) {
                minH = Math.min(minH, nums[--l]);
            } else {
                minH = Math.min(minH, nums[++r]);
            }
            ans = Math.max(ans, minH * (r - l + 1));
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
