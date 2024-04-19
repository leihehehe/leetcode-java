package stackAndDeque.monotonic;

import java.util.ArrayDeque;

//leetcode submit region begin(Prohibit modification and deletion)
class CanSeePersonsCount {
    public int[] canSeePersonsCount(int[] heights) {

        //逆序遍历，如果左边的人挡住了右边的人，那么右边这个人再也不会被左边人的左边的人看到了
        //所以这是递增单调栈（从入口处来说的话）
        //另外一个人只能看见一个比自己高的人
        //总结只能看见比他矮且单调递增的数，遇见比他高的，就停止，并算一次。
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int n = heights.length;
        int[] ans = new int[n];
        for(int i = n-1;i>=0;i--){
            while(!stack.isEmpty() && stack.peek()<=heights[i]){
                stack.pop();
                ans[i]++;
            }
            //只能看见一个比自己高的
            if(!stack.isEmpty()){
                ans[i]++;
            }
            stack.push(heights[i]);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
