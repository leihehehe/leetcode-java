package bitOperation;

//leetcode submit region begin(Prohibit modification and deletion)
class MinFlipsSolution {
    public int minFlips(int a, int b, int c) {
        int res = 0;
        for(int i = 0;i<31;i++){
            if(c==0 && a==0 && b==0) break;
            int q = a&1;
            int w = b&1;
            int e = c&1;
            if((q | w) != e){
                if(e==1){
                    res++;
                }else{
                    res+=q+w;
                }
            }
            a>>=1;
            b>>=1;
            c>>=1;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
