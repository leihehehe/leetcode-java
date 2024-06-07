package bitOperation;

//leetcode submit region begin(Prohibit modification and deletion)
class MinEndSolution {
    public long minEnd(int n, int x) {
        long res = x;
        n--;
        for(int i = 0, pos = 0;(n>>pos)>0;i++){
            //这里必须用res>>i而不能用x>>i, 因为res是long的，而x是int的
            //我们的答案要求是long，所以用x的话可能会出现溢出
            if(((res>>i)&1)==0){
                //这个地方要转化成long
                long bit = ((n>>pos)&1);
                res |= (bit<<i);
                pos++;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
