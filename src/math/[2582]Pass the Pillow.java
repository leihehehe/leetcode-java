package math;

//leetcode submit region begin(Prohibit modification and deletion)
class PassThePillow {
    public int passThePillow(int n, int time) {
        //到达端点需要n-1的时间
        //t = time mod n-1
        //剩下的//
        //time/n-1是偶数的话，是正向 -> t+1
        //time/n-1是奇数的话，是逆向 -> n-t
        int t = time % (n-1);
        if(time/(n-1)%2==0) return t+1;
        return n-t;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
