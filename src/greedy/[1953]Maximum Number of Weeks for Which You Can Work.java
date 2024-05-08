package greedy;

//leetcode submit region begin(Prohibit modification and deletion)
class NumberOfWeeksSolution {
    public long numberOfWeeks(int[] milestones) {
        long max = milestones[0];
        int n = milestones.length;
        long sum = 0;
        for(int i = 0;i<n;i++){
            sum+=milestones[i];
            max = Math.max(milestones[i],max);
        }
        if(max-1>sum-max) return (sum-max)*2+1;
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
