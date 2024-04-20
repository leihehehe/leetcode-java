package stackAndDeque.monotonic;

import java.util.ArrayDeque;

//leetcode submit region begin(Prohibit modification and deletion)
class MaximalRectangle {
    /**
     * 这道题和84、1793都差不多，都是是求最大矩形。我们可以把每一行都看作是矩形的底部
     * 用单调栈求最大值
     */
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] heights = new int[n];
        int res = 0;
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(matrix[i][j]=='1'){
                    heights[j]++;
                }else{
                    heights[j] = 0;
                }
            }
            res = Math.max(res,getMaxArea(heights));
        }
        return res;
    }
    public int getMaxArea(int[] heights){
        int n = heights.length;
        int[] left = new int[n];
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        //找到左边第一个更小元素，所以左边遍历的是答案
        for(int i = 0;i<n;i++){
            while(!stack.isEmpty() && heights[stack.peek()]>=heights[i]){
                stack.pop();
            }
            left[i] = stack.isEmpty()?-1:stack.peek();
            stack.push(i);
        }
        stack.clear();
        int[] right = new int[n];
        //找到右边第一个更小元素，倒序遍历，所以遍历的是答案
        for(int i = n-1;i>=0;i--){
            while(!stack.isEmpty() && heights[stack.peek()]>=heights[i]){
                stack.pop();
            }
            right[i] = stack.isEmpty()?n:stack.peek();
            stack.push(i);
        }
        int res = 0;
        for(int i = 0;i<n;i++){
            res = Math.max(res,heights[i] * (right[i]-left[i]-1));
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
