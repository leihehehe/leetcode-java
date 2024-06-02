package bitOperation;

//leetcode submit region begin(Prohibit modification and deletion)
class CountBits {
    public int[] countBits(int n) {
        int[] res = new int[n+1];
        //偶数的末尾-> 0
        //奇数的末尾-> 1
        for(int i = 1;i<=n;i++){
            //x如果为偶数，那么x中1的个数=x/2中1的个数
            //x如果为奇数，那么x中1的个数=x-1中1的个数+1
            if(i%2==0){
                res[i] = res[i/2];
            }else{
                res[i] = res[i-1]+1;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
