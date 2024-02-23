package weeklyContest.binarySearch;

//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Medium
 * Biweekly Contest 100
 */
class RepairCars {
    public long repairCars(int[] ranks, int cars) {
        int n = ranks.length;
        long minR = ranks[0];
        for(int i = 0;i<n;i++){
            minR = Math.min(minR,ranks[i]);
        }
        long r = minR * cars * cars;
        long l = 0;
        while(l<r){
            long mid = (l+r) >> 1;
            if(check(ranks,cars,mid)){
                r = mid;
            }else{
                l = mid+1;
            }
        }
        return l;
    }
    /**
     能否在维修完
     */
    public boolean check(int[] ranks, int cars, long target){
        //对于每个rank我们要满足: r * n * n<=target
        //因为对于每个rank来说，他可能一个人就把target维修完了，也有可能维修数量少于target
        // n = sqrt(target/r)
        // sum代表能修多少车
        long sum = 0;
        for(int i = 0;i<ranks.length;i++){
            sum+= Math.sqrt(target / ranks[i]);
        }
        return sum>=cars;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
