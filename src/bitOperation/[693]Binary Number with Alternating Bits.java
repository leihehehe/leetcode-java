package bitOperation;

//leetcode submit region begin(Prohibit modification and deletion)
class HasAlternatingBitsSolution1 {
    public boolean hasAlternatingBits(int n) {
        int x = n^ (n>>1);
        return ((x+1) & x )==0;
    }
}
class HasAlternatingBitsSolution2 {
    public boolean hasAlternatingBits(int n) {
        int status = 0;
        if(n%2==0) status = 0;
        else status = 1;
        n>>=1;
        while(n>0){
            int bit = n&1;
            if((bit ^ status) == 0){
                return false;
            }
            n>>=1;
            status = bit;
        }
        return true;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
