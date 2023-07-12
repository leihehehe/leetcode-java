package dailyProblem;

//leetcode submit region begin(Prohibit modification and deletion)
class AlternatingDigitSum {
    public int alternateDigitSum(int n) {
        int sum = 0;
        int len = 0;
        while(n>0){
            len++;
            int cur = n%10;
            n = n/10;
            //偶数是+
            if(len%2==0){
                sum+=cur;
                //奇数是-
            }else{
                sum-=cur;
            }
        }
        if(len%2==0){
            return sum;
        }
        return -sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
