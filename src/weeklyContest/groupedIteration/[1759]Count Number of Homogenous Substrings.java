package weeklyContest.groupedIteration;

//leetcode submit region begin(Prohibit modification and deletion)
class CountHomogenous {
    private final int MODULO = 1000000007;
    public int countHomogenous(String s) {
        int i = 0, n = s.length();
        long res = 0;
        while(i<n){
            int start = i;
            i++;
            while(i<n && s.charAt(i) == s.charAt(i-1)){
                i++;
            }
            int len = i-start;
            res += (long)(1+len)*len/2 % MODULO;
            //4+3+2+1 => (1+4)*4/2
        }
        return (int)(res% MODULO);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
