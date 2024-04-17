package stackAndDeque;

import java.util.ArrayDeque;
import java.util.Deque;

//leetcode submit region begin(Prohibit modification and deletion)
class TrapSolution1 {
    public int trap(int[] height) {
        //前后缀
        int n = height.length;
        int[] preMax = new int[n];
        int[] postMax = new int[n];
        preMax[0] = height[0];
        postMax[n-1] = height[n-1];
        for(int i = 1,j=n-2;i<n & j>=0;i++,j--){
            preMax[i] =  Math.max(preMax[i-1],height[i]);
            postMax[j] = Math.max(postMax[j+1],height[j]);
        }
        int ans = 0;
        for(int i = 0;i<n;i++){
            ans+= Math.min(preMax[i], postMax[i])-height[i];
        }
        return ans;

    }
}
class TrapSolution2 {
    public int trap(int[] height) {
        //前后缀
        int n = height.length;
        int preMax= 0, sufMax = 0;
        int l = 0, r = n-1;
        int ans = 0;
        while(l<r){
            preMax = Math.max(preMax,height[l]);
            sufMax = Math.max(sufMax,height[r]);
            if(preMax<sufMax){
                ans+=preMax-height[l];
                l++;
            }else{
                ans+=sufMax - height[r];
                r--;
            }
        }
        return ans;

    }
}
class TrapSolution3 {
    public int trap(int[] height) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int n = height.length;
        int ans = 0;
        for(int i = 0;i<n;i++){
            while(!stack.isEmpty()&& height[stack.peek()]<height[i]){
                int midIndex = stack.pop();
                if(stack.isEmpty()){
                    break;
                }
                int leftIndex = stack.peek();
                int width = i-leftIndex-1;
                ans+=width*(Math.min(height[leftIndex],height[i]) - height[midIndex]);
            }
            stack.push(i);
        }
        return ans;
    }
}

//leetcode submit region end(Prohibit modification and deletion)
