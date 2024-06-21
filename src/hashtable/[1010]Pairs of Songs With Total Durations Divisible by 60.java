package hashtable;

//leetcode submit region begin(Prohibit modification and deletion)
class NumPairsDivisibleBy60 {
    public int numPairsDivisibleBy60(int[] time) {
        // (time[i] + time[j])%60 == 0
        // time[i] % 60 + time[j] % 60 == 0
        int n = time.length;
        int[] rs = new int[60];
        //30, 30, 150, 90
        int res = 0;
        for(int i = 0;i<n;i++){
            int r = time[i]%60;
            int target = (60 - r)%60;
            res+= rs[target];
            rs[r]++;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
