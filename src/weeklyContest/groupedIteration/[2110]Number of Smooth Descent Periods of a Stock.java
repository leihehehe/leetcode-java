package weeklyContest.groupedIteration;

//leetcode submit region begin(Prohibit modification and deletion)
class GetDescentPeriods {
    public long getDescentPeriods(int[] prices) {
        //[3,2,1]
        int i = 0;
        int n = prices.length;
        //[3,2,1,4]
        // s     i

        //[3,2,1]
        //x = the number of elements = 3
        //x+x-1+x-2+..+1
        long res = 0;
        while(i<n){
            long start = i;
            i++;
            while(i<n && prices[i-1]-prices[i]==1){
                i++;
            }
            long len = i - start;
            res += (1+len) * len / 2;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
