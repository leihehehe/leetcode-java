package weeklyContest.simulation;

/**
 * Weekly Contest 390
 * Medium
 */
class MinOperations {
    public int minOperations(int k) {
        //m = 1+add
        //add的次数：m-1
        //copy的次数x：m*x+m = k
        //m*(x+1) = k
        //x = k/m -1 
        //总次数: m-1+(k/m-1)
        int ans = Integer.MAX_VALUE;
        for(int m = 1;m<=k;m++){
            //(k-1)/m保证向上取整，不管k是否为m的倍数
            ans = Math.min(ans,m-1+(k-1)/m);
        }
        return ans;
    }

}