package stackAndDeque;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

//leetcode submit region begin(Prohibit modification and deletion)
class LargestRectangleAreaSolution1 {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        //找柱形左边的第一个更小值，所以答案在左边，我们需要在栈中保存答案
        for(int i = 0;i<n;i++){
            //如果出现了更小的元素，那么stack里的元素就不可能再是右边柱形的第一个最小值了，所以pop掉
            while(!stack.isEmpty() && heights[stack.peek()]>=heights[i]){
                stack.pop();
            }
            left[i]=!stack.isEmpty()?stack.peek():-1;
            stack.push(i);
        }
        int[] right = new int[n];
        stack.clear();
        //如果图形全是递增的话，可能找不到右边的更小值，所以我们可以初始化数组为n
        Arrays.fill(right,n);
        //找柱形右边的第一个更小值，所以答案在右边，我们遍历的是需要寻找答案的元素
        for(int i =0;i<n;i++){
            //找到答案了就pop
            while(!stack.isEmpty() && heights[stack.peek()]>heights[i]){
                right[stack.pop()] = i;
            }
            stack.push(i);
        }
        //计算面积
        int res = 0;
        for(int i = 0;i<n;i++){
            res = Math.max(res, heights[i] * (right[i]-left[i]-1));
        }
        return res;

    }
}
class LargestRectangleAreaSolution2 {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        int maxArea = 0;
        for(int i = 0;i<=heights.length;i++){
            int cur;
            if(i==heights.length){
                cur = 0;
            }else{
                cur = heights[i];
            }
            while(!stack.isEmpty() && cur<=heights[stack.peek()]){
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea,height*width);
            }
            stack.push(i);
        }
        return maxArea;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
