package dp;

import java.util.Arrays;

class PaintWallsSolution {
    int[][] memo;
    public int paintWalls(int[] cost, int[] time) {
        int n = cost.length;
        //根据下面的method，timeSpent不能大于i，也就是说不能大于n
        //因为可能存在负数（赊账），最小值可能为-n（所有墙都让免费工刷了）
        memo = new int[n][2*n+1];
        //这里赋值Integer.MAX_VALUE/2会超时，可能是因为除法计算
        for(int i = 0;i<memo.length;i++) Arrays.fill(memo[i],-1);
        return getMin(cost,time,n-1,0);
    }
    //表示[0,i]的答案
    public int getMin(int[] cost, int[] time, int i, int timeSpent){
        //timeSpent代表可以匀给free工人的时间(其实就是差值)，如果可以匀的时间>剩下的所有墙，直接返回cost 0（剩下的墙全部免费刷）
        //这里也可以写成if(i<0 && timeSpent>=0) return 0;
        if(timeSpent > i) return 0;
        if(i<0) return Integer.MAX_VALUE/2;
        int n = cost.length;
        if(memo[i][timeSpent+n]!=-1) return memo[i][timeSpent+n];
        //paid
        int paid = getMin(cost,time,i-1,timeSpent+time[i])+cost[i];
        //free -> 只耗费1 unit time
        //选free的时候，不能检查timeSpent是否>0，因为我们timeSpent的初始值是0，这样意味着第一次进入递归的时候，最后一堵墙一定不会选免费的，但实际上不是，第一次的选择都有可能。
        //而为什么不检查是可以的呢？因为这个timeSpent在中途是可以为负数的，只需要最后的timeSpent是>=0的即可
        int free = getMin(cost,time,i-1,timeSpent-1);
        return memo[i][timeSpent+n] = Math.min(paid,free);
    }

}
