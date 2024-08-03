package prefixSumAndDifference;

import java.util.ArrayList;
import java.util.List;

class MinMovesSolution {
    public int minMoves(int[] nums, int k) {
        List<Long> ones = new ArrayList<>();
        for(int i = 0;i<nums.length;i++){
            if(nums[i]==1) ones.add((long)i-(ones.size()+1));
        }
        //i,j,k->1在nums中的index
        //a,b,c->1在ones中的index
        //x->在nums中的index
        //|i - (x+a)| + |j-(x+b)| + |k - (x+c)|
        //|i-a-x| + |j-b-x| + |k-c-x|
        //这个绝对值要最小的话，需要找中位数，但这里要把(i-a)看作一个整体，这样就是跟我们以前做的中位数贪心题一样了
        //所以要找到中位数是(i-a)这样的数组中的中位数
        //|ones[a]-x| + |ones[b]-x| + |ones[c]-x| -> preSum - x*(i+1)
        //

        int n = ones.size();
        long[] preSum = new long[n+1];
        for(int i = 0;i<n;i++){
            preSum[i+1] = preSum[i]+ ones.get(i);
        }
        long res = Long.MAX_VALUE;
        for(int r=k-1;r<n;r++){
            //k = r-l+1 -> k个1
            int l = r-k+1;
            int mid = l+r>>1;
            long left = ones.get(mid) * (mid-l) - (preSum[mid]-preSum[l]);
            long right = (preSum[r+1]-preSum[mid+1]) - ones.get(mid) * (r - mid);
            res = Math.min(res,left+right);
        }
        return (int)res;
    }
}