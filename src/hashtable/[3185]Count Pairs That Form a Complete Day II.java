package hashtable;

//leetcode submit region begin(Prohibit modification and deletion)
class CountCompleteDayPairsSolution {
    public long countCompleteDayPairs(int[] hours) {
        int[] r = new int [24];
        long ans = 0;
        for(int i = 0;i<hours.length;i++){
            int target = (24 - hours[i]%24)%24;
            ans+= r[target];
            r[hours[i]%24] ++;
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
