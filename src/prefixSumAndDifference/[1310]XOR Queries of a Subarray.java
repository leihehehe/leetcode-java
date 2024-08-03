package prefixSumAndDifference;

class XorQueriesSolution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        int[] xor = new int[n+1];
        for(int i = 0;i<n;i++){
            xor[i+1] = xor[i] ^ arr[i];
        }
        int len = queries.length;
        int[] res = new int[len];
        for(int i = 0;i<len;i++){
            int[] query = queries[i];
            res[i]= xor[query[1]+1] ^ xor[query[0]];
        }
        return res;
    }
}
