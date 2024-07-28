package prefixSumAndDifference;

class Solution {
    int module = (int)1e9 + 7;
    public int numOfSubarrays(int[] arr) {

        long oddCount = 0, evenCount = 1;
        int n = arr.length;
        int sum = 0;
        long res = 0;
        for(int i = 0;i<n;i++){
            sum+=arr[i];
            //even
            if((sum&1)==0){
                res+=oddCount;
                evenCount++;
            }else{
                res+=evenCount;
                oddCount++;
            }
        }
        return (int)(res%module);
    }
}
