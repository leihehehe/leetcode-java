package prefixSumAndDifference;

class CountDivisibleSubstringsSolution {
    public int countDivisibleSubstrings(String word) {
        int[] valueMap = new int[]{1,1,2,2,2,3,3,3,4,4,4,5,5,5,6,6,6,7,7,7,8,8,8,9,9,9};
        //(preSum[j] - preSum[i]) % (j-i) ==0
        //preSum[j] % (j-i) = preSum[i] % (j-i)
        int sum = 0;
        int n = word.length();
        int[] prefixSum = new int[n+1];
        int res = 0;
        for(int i = 0;i<word.length();i++){
            char c = word.charAt(i);
            sum+=valueMap[c-'a'];
            for(int j = 0;j<=i;j++){
                int len = i-j+1;
                if(prefixSum[j]%len == sum%len) res++;
            }
            prefixSum[i+1] = sum;
        }
        return res;

    }
}
