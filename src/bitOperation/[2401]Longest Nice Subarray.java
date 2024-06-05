package bitOperation;

//leetcode submit region begin(Prohibit modification and deletion)
class LongestNiceSubarraySolution1 {
    public int longestNiceSubarray(int[] nums) {
        //如果两个数AND为0，那么可以理解为这两个数代表的二进制是没有交集的。
        //一段子数组中，任意两个数都没有交集，那说明数组中的任意一个数，与其他的数（并集）都没有交集。
        int n = nums.length;
        int res = 1;
        for(int i = 0;i<n;i++){
            int union = 0;
            for(int j = i;j<n;j++){
                int num = nums[j];
                if((num & union) == 0){
                    union |= num;
                    res = Math.max(res, j-i+1);
                }else{
                    break;
                }
            }
        }
        return res;
    }
}
class LongestNiceSubarraySolution2 {
    public int longestNiceSubarray(int[] nums) {
        int l = 0 , r = 0;
        int or = 0;
        int res = 0;
        while(r<nums.length){
            int toAdd = nums[r];
            r++;
            while((toAdd & or)!=0){
                or ^= nums[l];
                l++;
            }
            or|=toAdd;
            res = Math.max(r-l,res);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
