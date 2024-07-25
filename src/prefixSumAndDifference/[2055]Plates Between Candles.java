package prefixSumAndDifference;

class PlatesBetweenCandles {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int n = s.length();
        int[] prefix = new int[n+1];
        int[] nearestLeft = new int[n];
        int left = -1;
        for(int i = 0;i<n;i++){
            char c = s.charAt(i);
            if(c=='*'){
                prefix[i+1] = prefix[i] + 1;
            }else{
                prefix[i+1] = prefix[i];
            }
            if(c=='|'){
                left = i;
            }
            nearestLeft[i] = left;
        }
        int[] nearestRight = new int[n];
        int right = n;
        for(int i = n-1;i>=0;i--){
            char c = s.charAt(i);
            if(c=='|'){
                right = i;
            }
            nearestRight[i] = right;
        }
        int[] res = new int[queries.length];
        for(int i = 0;i<queries.length;i++){
            int[] query = queries[i];
            int l = nearestRight[query[0]];
            int r = nearestLeft[query[1]];
            if(l<=query[1] && r>=query[0]) res[i] = prefix[r+1]-prefix[l];
        }
        return res;

    }
}
