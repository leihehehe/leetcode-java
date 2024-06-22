package hashtable;

//leetcode submit region begin(Prohibit modification and deletion)
class NumIdenticalPairsSolution {
    public int numIdenticalPairs(int[] nums) {
        int n = nums.length;
        int[] map = new int[101];
        int res = 0;
        for(int i = 0;i<n;i++){
            int value = nums[i];
            res+=map[value];
            map[value]+=1;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
