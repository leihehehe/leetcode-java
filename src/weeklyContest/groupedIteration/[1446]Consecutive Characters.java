package weeklyContest.groupedIteration;

//leetcode submit region begin(Prohibit modification and deletion)
class MaxPowerSolution1 {
    public int maxPower(String s) {
        int max = 1, i = 0, n = s.length();
        while(i<n-1){
            int start = i;
            i++;
            while(i<n && s.charAt(i) == s.charAt(i-1)){
                i++;
            }
            max = Math.max(max, i-start);
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
