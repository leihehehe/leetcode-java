package prefixSumAndDifference;

class ProductQueriesSolution1 {
    public int[] productQueries(int n, int[][] queries) {
        int[] res = new int[queries.length];
        int[] pre = new int[31];
        pre[0] = 1;
        int i = 0;
        int k = 0;
        int MOD = 1000000007;

        while(n>0){
            if((n&1)==1){
                pre[k+1] = (int)((long)pre[k] * (1<<i) % MOD);
                k++;
            }
            n = n>>1;
            i++;
        }
        for(int j = 0;j<queries.length;j++){
            int[] q = queries[j];
            res[j] = (int)((long)pre[q[1] + 1] * modInverse(pre[q[0]], MOD) % MOD);
        }
        return res;
    }
    // 计算 a 的模逆元，使用扩展欧几里得算法
    private int modInverse(int a, int mod) {
        int m0 = mod, t, q;
        int x0 = 0, x1 = 1;

        if (mod == 1)
            return 0;

        while (a > 1) {
            q = a / mod;
            t = mod;

            mod = a % mod;
            a = t;

            t = x0;
            x0 = x1 - q * x0;
            x1 = t;
        }

        if (x1 < 0)
            x1 += m0;

        return x1;
    }

}

class ProductQueriesSolution2 {
    public int[] productQueries(int n, int[][] queries) {
        int[] res = new int[queries.length];
        int[] pre = new int[31];
        pre[0] = 1;
        int i = 0;
        int k = 0;
        int MOD = 1000000007;

        while(n>0){
            if((n&1)==1){
                pre[k+1] = (int)((long)pre[k] * (1<<i) % MOD);
                k++;
            }
            n = n>>1;
            i++;
        }
        for(int j = 0;j<queries.length;j++){
            int[] q = queries[j];
            // res[j] = (int)((long)pre[q[1] + 1] * modInverse(pre[q[0]], MOD) % MOD);
            res[j] = (int)((long)pre[q[1] + 1] * fermat(pre[q[0]], MOD-2, MOD) % MOD);
        }
        return res;
    }

    public long fermat(long base, int power, int mod){
        return getExp(base, power, mod);
    }
    //只考虑正数的power
    public long getExp(long base, long power, int mod){
        long res = 1;
        while(power>0){
            if((power&1) ==1){
                res = (res * base)%mod;
            }
            base = (base*base)%mod;
            power>>=1;
        }
        return res;
    }

}