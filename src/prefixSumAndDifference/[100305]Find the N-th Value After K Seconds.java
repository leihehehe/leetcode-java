package prefixSumAndDifference;

class ValueAfterKSeconds {
    private final int MODULO = (int)1e9+7;
    public int valueAfterKSeconds(int n, int k) {
        long[] pre = new long[n];
        pre[0] = 1;
        while(k-- >=0){
            for(int i = 1;i<n;i++){
                pre[i] = (pre[i-1]+pre[i])%MODULO;
                pre[i]%=MODULO;
            }
        }
        return (int)pre[n-1];
    }
}
