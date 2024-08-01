package prefixSumAndDifference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class MinOperationsSolution {
    public List<Long> minOperations(int[] nums, int[] queries) {
        //|num[i]-q| + |num[i+1] - q| + |num[i+2] -q| +|num[i+3] -q|
        // num[i]+num[i+1]+num[i+2]+num[i+3] - q*4
        Arrays.sort(nums);
        int n = nums.length;
        long[] prefixSum = new long[n+1];
        prefixSum[0] = nums[0];
        for(int i = 1;i<n;i++){
            prefixSum[i] = prefixSum[i-1] + nums[i];
        }
        List<Long> res = new ArrayList<>();
        for(int i = 0;i<queries.length;i++){
            //> queries[i] -> first element
            int query = queries[i];
            int pivot = binarySearch(nums, query);
            long suffixSum= pivot==-1?prefixSum[n-1]: prefixSum[n-1] - prefixSum[pivot];
            long prefixRes = pivot==-1?0:(long)query * (pivot+1) - prefixSum[pivot];
            long suffixRes = suffixSum - (long)query * (n-pivot-1);
            res.add(prefixRes + suffixRes);
        }
        return res;
    }

    public int binarySearch(int[] nums, int target){
        //<=target的最后一个数，如果没有数小于等于target，就会返回-1
        //边界：如果没有数大于等于target，返回-1
        int l = 0, r = nums.length-1;
        while(l<r){
            int mid = (l+r+1)>>1;
            if(nums[mid]<=target){
                l = mid;
            }else{
                r = mid - 1;
            }
        }
        if(nums[l]<=target) return l;
        return -1;
    }
}
